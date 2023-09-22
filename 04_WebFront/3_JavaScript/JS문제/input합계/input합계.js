const createBtn = document.getElementById('create-btn');
const plusBtn = document.getElementById('plus-btn');
const container = document.getElementById('container');
const result = document.getElementById('result');

createBtn.addEventListener('click', ()=>{
  const inputNumber = document.getElementById('input-number');
  container.innerHTML = "";
  for(let i=0; i<inputNumber.value; i++){
    const input = document.createElement('input');
    input.classList.add('calc');
    input.setAttribute('type','number');
    container.append(input);
  }

  plusBtn.addEventListener('click', ()=>{
    const arr = document.querySelectorAll('.calc');
    let sum = 0;
    for(let i=0; i<inputNumber.value; i++){
      sum += Number(arr[i].value);
    }
    result.innerText = "결과 : " + sum;
  });
});

