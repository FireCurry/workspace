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
    result1.innerText = '';
    console.log(e);
  } )
});

/* 이메일이 일치하는 회원의 전화번호 조회(비동기) */
const inputEmail = document.getElementById("inputEmail");
const btn2 = document.getElementById("btn2");
const result2 = document.getElementById("result2");

btn2.addEventListener('click', ()=>{
  fetch("/ajax/selectEmail?inputEmail=" + inputEmail.value)
  .then( response=>response.text() ) // 응답이 왔을 때 수행, 응답 결과를 text로 파싱

  // 첫 번째 then()의 반환된 결과를 이용해 기능을 수행
  .then( tel=>{
    if(tel == ""){
      result2.innerText = '이메일이 일치하는 회원이 없습니다';
    } else{
      result2.innerText = tel;
    }
  } )
  .catch( e=>console.log(e) ) // 예외 발생 시 수행
});

// 회원 번호가 일치하는 회원 정보 모두 조회
const no2 = document.getElementById("inputMemberNo2");
const btn3 = document.getElementById("btn3");
const result3 = document.getElementById("result3");

btn3.addEventListener('click', ()=>{
  fetch("/ajax/selectMember?no=" + no2.value)

  // 응답 데이터가 JSON인 경우 JS 객체로 파싱
  .then(resp => resp.json()) 

  .then( member=>{
    // console.log(member);
    result3.innerText = ''; // #result3 내용 삭제

    const ul = document.createElement("ul");

    ul.setAttribute('style', 'list-style : none;');

    for(let key in member){
      const li = document.createElement("li"); // li 요소 생성
      li.innerText = `${key} : ${member[key]}`; // li 내용 추가
      ul.append(li);
    }
    result3.append(ul);
  } )
  .catch( e => { // 조회 결과가 null이면 JSON 파싱에서 예외 발생
    console.log(e);
    result3.innerText = ''; // 기존 내용 삭제
    const h4 = document.createElement('h4');
    h4.innerText = '일치하는 회원이 없습니다';
    result3.append(h4);
  } );

});


/* 문자열을 입력 받아 일부라도 일치하는 이메일 조회 */
const input4 = document.getElementById('input4');
const btn4 = document.getElementById('btn4');
const result4 = document.getElementById('result4');

btn4.addEventListener('click', ()=>{
  fetch("/ajax/selectEmailList?keyword=" + input4.value)
  .then( resp => resp.json() ) // List 객체 -> JSON Array -> JS 객체 배열 변환
  .then( emailList =>{
    result4.innerText = '';

    if(emailList.length == 0){ // 조회 결과가 없을 경우
      const tr = document.createElement('tr');
      const th = document.createElement('th');
      th.innerText = "조회 결과가 없습니다.";

      tr.append(th);
      result4.append(tr);
    } else { // 조회 결과가 있을 경우

      // JS의 향상된 for문 : for...of
      for(let email of emailList){
        const tr = document.createElement('tr');
        const td = document.createElement('td');

        td.innerText = email;
        // td 클릭 시 해당 이메일 회원 정보 상세 조회 페이지 이동
        td.addEventListener('click', e=>{
          location.href = '/admin/selectMember?inputEmail=' + e.target.innerText;
        });

        tr.append(td);
        result4.append(tr);
      }
    }
  })
  .catch(e => console.log(e));
});