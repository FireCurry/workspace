// 회원 번호를 입력 받아 일치하는 회원의 이메일 조회하기(비동기)

const inputMemberNo = document.getElementById('inputMemberNo');
const selectMemberNo = document.getElementById('selectMemberNo');
const result1 = document.getElementById('result1');

// 조회 버튼 클릭 시
selectMemberNo.addEventListener('click', ()=>{

  // fetch() API를 이용한 GET 방식 요청
  // GET : 조회(SELECT)

  // 쿼리스트링(querystring) : 
  // - 주소에 담겨진 파라미터를 지칭하는 단어
  // - ?key=vaule&key=value  (띄어쓰기가 없어야됨!)

  // then : 그리고 나서, (앞 동작이) 완료된 후에

  fetch("/ajax/selectMemberNo?memberNo=" + inputMemberNo.value)

  // 요청에 대한 응답이 돌아왔을 때 수행
  .then( (response)=>{ // response : 응답이 담겨져있는 객체(promise)
    console.log(response); // promise 객체
    return response.text(); // promise에 담긴 응답 결과를 text 형태로 파싱 후 반환
  } )

  // 첫 번째 then()에서 반환된 결과를 이용해 기능을 수행
  .then( (email)=>{ // email : 첫 번째 then 에서 파싱된 데이터
    console.log("email : " + email);

    // 응답 결과(email)이 존재하는 경우
    // 있으면 : 이메일 문자열
    // 없으면 : 빈칸

    if(email == ""){
      result1.innerText = "일치하는 회원이 없습니다";
    } else{
      result1.innerText = email;
    }
  } )

  // 비동기 통신 중 예외 발생 시 수행
  .catch( (e)=>{
    console.log(e);
  } )
});