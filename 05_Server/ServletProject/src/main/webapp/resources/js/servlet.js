// servlet.js 입니다.

const container = document.querySelector(".container");
const addBtn = document.querySelector("#add-btn");

addBtn.addEventListener('click', ()=>{

  const input = document.createElement('input');
  input.setAttribute('type','text');
  input.setAttribute('name','menu');

  container.append(input);
});