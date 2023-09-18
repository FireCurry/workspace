// 인라인 이벤트 모델
function inlineEventModel(btn){
  console.log(btn); // 클릭 이벤트가 발생한 요소(버튼)
  console.log(btn.style.backgroundColor); // 클릭한 요소의 배경색 얻어오기

  if(btn.style.backgroundColor != 'pink'){
    btn.style.backgroundColor = 'pink'; // 클릭한 요소의 배경색으로 pink 추가
  } else{
    // Attribute : 속성
    btn.removeAttribute('style'); // style 속성 제거
  }
}

// 고전 이벤트 모델

// 아이디가 test2-1인 요소를 선택해 변수에 저장
const a = document.getElementById('test2-1');

// 요소.이벤트리스너 = 이벤트 핸들러
a.onclick = function(){
  // function(){} : 익명 함수(이벤트 핸들러로 많이 사용)
  alert('test2-1 클릭')
}

// 이벤트 제거
// #test2-2 클릭 시 #test2-1의 클릭 이벤트 제거
const b = document.querySelector('#test2-2');

b.onclick = function(){
  // #test2-1의 onclick 속성에 null을 대입해서 덮어쓰기
  a.onclick = null;
  alert('#test2-1 이벤트 제거')
}

// 고전 이벤트 모델 단점
// -> 한 요소의 같은 이벤트 리스너에
//    여러 이벤트 핸들러를 대입할 수 없다
const c = document.querySelector('#test2-3');

// #test2-3 클릭 시 버튼의 배경색을 yellow로 변경
c.onclick = function(){
  c.style.backgroundColor = 'yellow';
}

// #test2-3 클릭 시 버튼의 글자 크기를 30px로 변경
c.onclick = function(){
  c.style.fontSize = '30px';
}

// ---------------------------------------------------------------

/* ***** 표준 이벤트 모델 ***** */

/* [작성법]
  요소.addEventListener("click", function(){});
                       이벤트명, 이벤트 핸들러
*/

// 아이디가 test3인 요소에 click 했을 때 동작을 추가
document.getElementById('test3').addEventListener("click", function(){

  // 클릭된 요소의 너비가 10px 증가
  // 고전/표준 이벤트 핸들러 내부에서 this : 이벤트가 발생한 요소
  console.log(this);

  // 요소.clientWidth : 요소의 너비(테두리 제외)
  // -> css/style 속성으로 지정된 너비를 얻어올 때 사용
  console.log(this.clientWidth);

  // 요소.style.width : 요소의 style 속성 중 width의 값을 얻어옴
  // -> 요소 자체에 작성된 style 속성의 값을 얻어올 때 사용(inline)
  console.log(this.style.width);

  // this.style.width = '300px'; // 현재 요소 너비 변경
  this.style.width = this.clientWidth + 10 + 'px';
});

// #test3 요소에 click 이벤트 리스너를 또 추가
document.getElementById('test3').addEventListener('click', function(e){

  // 이벤트 핸들러 매개변수 e 또는 event
  // -> 이벤트 객체(이벤트 관련 정보가 담긴 객체)가 전달됨

  // e.target : 이벤트가 발생한 요소
  console.log(e);
  console.log(e.target);

  // 현재 요소의 높이를 변경
  e.target.style.height = e.target.clientHeight + 10 + 'px';
});

// 입력한 색상으로 배경색 변경(표준 이벤트 모델)

const btn4 = document.getElementById('btn4');
const box4 = document.getElementById('box4');
const input4 = document.getElementById('input4');

btn4.addEventListener('click', function(){
  
  box4.style.backgroundColor = input4.value;
});

// input 태그에서 엔터 입력 시 배경색 변경

input4.addEventListener("keyup" , function(e){
  // e : 이벤트 객체
  // e.key : 입력한 키(키 관련 이벤트 객체만 확인 가능)
  // e.target : 이벤트가 발생한 요소 (여기서는 #input4)
  // console.log(e.key);
  if(e.key == 'Enter'){
    box4.style.backgroundColor = e.target.value;
  }
});

/* a 태그 기본 이벤트 제거 */
document.getElementById('move').addEventListener('click', function(e){

  // e : 이벤트 객체
  // prevent : 하지 못하게 막다
  // default : 기본

  e.preventDefault(); // HTML 요소의 기본 이벤트 막음(제거)
});

/* form 태그 기본 이벤트 제거 */

// 방법 1. e.preventDefault()
// document.getElementById('login').addEventListener('submit', function(e){
//   e.preventDefault();
// });

// 방법 2. 인라인 이벤트 모델 onsubmit 이용
function testFn(){
  const id = document.getElementById('input-id');
  const pw = document.getElementById('input-pw');

  // 아이디 또는 비밀번호를 입력하지 않았을 때
  if(id.value.trim().length == 0 || pw.value.trim().length == 0){
    return false;
  }

  // 둘 다 입력한 경우
  return true;
}

// 방법 3. 일반 버튼 클릭으로 제출 막음
// #login-btn2 버튼이 눌렸을 때
const loginBtn2 = document.querySelector('#login-btn2');
loginBtn2.addEventListener('click', function(){
  const id = document.getElementById('input-id');
  const pw = document.getElementById('input-pw');

  // 아이디 또는 비밀번호 둘 다 입력했을 때
  if(id.value.trim().length != 0 && pw.value.trim().length != 0){

    /* document.form태그name속성 == 해당 form요소 선택 */

    // 문서 내에서 name 속성 값이 loginForm인 form 태그를 제출 시킴
    document.loginForm.submit();
  }
});

// ---------------------------------------------------------------
const list = document.getElementById('list');
const countInput = document.getElementById('count-input');
const calcResult = document.getElementById('calc-result');
const calc = document.getElementById('calc');

const calcFn = function(){
  // list, 계산값 초기화
  list.innerHTML = "";
  calcResult.innerText = '0';

  // 입력된 숫자만큼 list item 생성
  if(Number(countInput.value) >= 1 && Number(countInput.value) <= 10){
    for(let i = 1 ; i <= Number(countInput.value); i++){
      list.innerHTML += "<li><input type='number' class='list-input'></li>";
    }
  } else {
    alert("1에서 10사이의 숫자만 입력해주세요")
    countInput.value = "";
    countInput.focus();
  }
};

const calcFn2 = function(){
  // 결과 값 저장할 변수 선언 및 초기화
  let result = 0;
  const listInput = document.getElementsByClassName('list-input');
  // 값이 모두 존재할 경우 모든 값 더한 결과 반환
  // 값이 하나라도 존재하지 않으면 alert 반환
  for(let i = 0 ; i < listInput.length ; i++){
    // console.log(document.getElementsByClassName('list-input')[i].value.length);
    if(listInput[i].value.length == 0){
      listInput[i].focus();
      return alert("숫자를 전부 입력해주세요");
    }
    result += Number(listInput[i].value);
  }
  calcResult.innerText = result;
}

document.getElementById('create-btn').addEventListener('click', function(){
  calcFn();
});

countInput.addEventListener('keyup', function(e){
  if(e.key == 'Enter'){
    calcFn();
  }
});

calc.addEventListener('click', function(){
  calcFn2();
});
