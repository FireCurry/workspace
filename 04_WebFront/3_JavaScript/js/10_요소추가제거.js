/*  
  요소.classList : 요소 클래스 관련 속성

  요소.classList.add("클래스명")    : 클래스 추가
  요소.classList.remove("클래스명") : 클래스 제거

  요소.remove() : 요소 제거

*/



// 만들려는 기능 중 공통적으로 사용되는 요소를 전역 변수 선언
// querySelector() -> 여러 요소가 선택 되어도 첫 번째 요소 하나만 얻어옴
const addBtn = document.querySelector('#add');
const calcBtn = document.querySelector('#calc');
const container = document.querySelector('.container');
const result = document.querySelector('#result');

/* 추가 버튼 클릭 시 */
addBtn.addEventListener('click', ()=>{
  const row = document.createElement('div');
  const input = document.createElement('input');
  const span = document.createElement('span');

  // 요소에 class 추가 하기
  // row.setAttribute('class', 'row');
  row.classList.add('row');

  // input 관련 만들기
  input.setAttribute('type', 'number');
  input.classList.add('input-number');

  // span 관련 만들기
  span.classList.add('remove-row');
  span.innerHTML = '&times;';

  /* **************************** */
  // 클릭된 x버튼의 부모 요소를 제거

  // [1] 만들어지는 X버튼(span)에 이벤트 리스너 추가
  span.addEventListener('click', e=>{
    // [2] 현재 이벤트가 발생한 요소(클릭된 X버튼)의
    //       부모 요소를 선택(탐색)
    const parent = e.target.parentElement; // == div.row
    
    // [3] 부모 요소를 제거
    parent.remove();
  });
  /* **************************** */

  row.append(input);
  row.append(span);
  container.append(row);
});

calcBtn.addEventListener('click', ()=>{
  const input = document.querySelectorAll('.input-number');
  let sum = 0;
  for (let i = 0 ; i < input.length ; i++){
    sum += Number(input[i].value);
    if(input[i].value.trim().length == 0){
      return alert("숫자를 모두 입력해주세요")
    }
  }
  alert(sum + " 입니다")
});

