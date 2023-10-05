// #btn1 요소 클릭 시
const btn1 = document.getElementById("btn1");
const btn2 = document.getElementById("btn2");
const btn3 = document.getElementById("btn3");


btn1.addEventListener('click', ()=>{

  // location.href;        : 현재 주소 반환
  // location.href = 주소; : 대입된 주소로 이동(GET방식)
  location.href = "/jstl/basic";
});

btn2.addEventListener('click', ()=>{
  location.href = "/jstl/condition";
});

btn3.addEventListener('click', ()=>{
  location.href = "/jstl/loop";
});