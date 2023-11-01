// 좋아요 버튼(#boardLike) 요소를 얻어와 변수에 저장
const boardLike = document.getElementById("boardLike");

// 좋아요 버튼 클릭 시 (이벤트 리스너 추가)
boardLike.addEventListener("click", e=>{

  // 1. 로그인 여부 확인 (로그인 한 회원만 좋아요를 누를 수 있다!)
  // *** 로그인 여부 확인 방법 ***
  // - session에 loginMember가 있으면 로그인 상태
  // - 없으면 로그아웃
  // --> session을 이용해야 되는데
  //     JS만으로는 server session 사용 불가
  //     단, Thymeleaf를 작성할 수 있는 html 파일에서는 JS와 혼용 가능

  // * html 파일에 boardDetail.js를 추가하기 전에
  //   script 태그를 이용해서 전역 변수를 로그인 여부를 저장 *

  if(!loginCheck) { // 로그인이 되어있지 않은 경우
    alert("로그인 후 이용 해주세요");
    return;
  }

  // 2. 기존 좋아요 상태 확인
  let check;

  // "fa-regular" : 비어있는 하트
  // "fa-solid" : 채워져 있는 하트
  // 클릭한 하트에 class 속성 값으로 "fa-regular"가 있으면 true
  if(e.target.classList.contains("fa-regular")){
    check = 0;
  } else{
    check = 1;
  }

  // 3. ajax 구문 작성

  // 1) ajax로 비동기 요청 시 전달할 데이터를 모아둔 객체
  const dataObj = {"boardNo" : boardNo , "check" : check};

  // 2) fetch() API 작성
  fetch("/board/like", {
    method : "POST",
    headers : {"Content-Type" : "application/json"},
    body : JSON.stringify(dataObj) // JS 객체 -> JSON 문자열화
  })
  .then( resp => resp.text())
  .then( count => {
    
    if(count == -1){
      console.log("좋아요 처리 실패");
      return;
    }

    // 요소.classList.toggle("클래스명")
    // - 요소에 클래스가 있으면 삭제, 없으면 추가
    e.target.classList.toggle("fa-regular");
    e.target.classList.toggle("fa-solid");
    
    // 좋아요 수(count)를 화면에 출력
    e.target.nextElementSibling.innerText = count;
    
    // if(count >= 0){
    //   if(check == 0){
    //     e.target.classList.add("fa-solid");
    //     e.target.classList.remove("fa-regular");
    //   } else{
    //     e.target.classList.add("fa-regular");
    //     e.target.classList.remove("fa-solid");
    //   }
    //   e.target.nextElementSibling.innerText = count;
    // } else{
    //   console.log("좋아요 처리 실패");
    //   alert("좋아요 처리 실패");
    //   return;
    // }
  })
  .catch(e=>console.log(e));
})

// ---------------------------------------------------------------------------
/* 목록으로 버튼 */

const goToListBtn = document.getElementById("goToListBtn");

if(goToListBtn != null){ // 화면에 목록으로 버튼이 있을 때만 수행

  // 함수 선언 (변수 대입 형식)
  const goToListFn = () => {

    // location.href : 현재 주소 반환
    // URL 객체 : JS에서 주소를 다루고 관리할 수 있는 객체
    // URL객체.searchParams : 주소에 담긴 쿼리스트링을 map 형식으로 반환

    const paramMap = new URL(location.href).searchParams;

    const obj = {}; // 주소에 담겨있는 파라미터를 담을 객체

    // paramMap 데이터를 obj 객체에 대입
    obj.cp = paramMap.get("cp");
    obj.key = paramMap.get("key");
    obj.query = paramMap.get("query");

    // 상세페이지 주소 : /board/{boardCode}/{boardNo}?cp=3&key=t&query=test
    // 목록 페이지 주소 : /board/{boardCode}?cp=3&key=t&query=test

    // URLSearchParams 객체 : 주소에서 쿼리스트링만 다루는 객체
    //                        쿼리스트링 추가, 수정, 제거, 생성 가능

    // 1) 쿼리스트링 조합하기
    const tempParams = new URLSearchParams();

    for(let key in obj){ // 객체 전용 향상된 for문
      if(obj[key] != null) tempParams.append(key, obj[key]);
    }
    // console.log(tempParams.toString());

    // 2) 목록으로 돌아가기
    location.href = `/board/${boardCode}?${tempParams.toString()}`;
  };



  // 이벤트 리스너 추가
  goToListBtn.addEventListener("click", goToListFn);
}

// -------------------------------------------------------------------

/* 게시글 삭제 */
const deleteBtn = document.getElementById("deleteBtn");

// 만약 화면에 버튼이 없으면 null 반환
if(deleteBtn != null){ // 삭제 버튼이 존재하는 경우

  deleteBtn.addEventListener("click", ()=>{

    // confirm : 확인 클릭 -> true / 취소 클릭 -> false 반환
    if(confirm("삭제 하시겠습니까?")){
      // 상세 조회 페이지 주소 : /board/{boardCode}/{boardNo}
      // 삭제 요청 주소 : /editBoard/{boardCode}/{boardNo}/delete (GET)
      location.href = location.pathname.replace("board","editBoard")+"/delete";
    }
  });
}