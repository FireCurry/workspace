const countBtn = document.getElementById('count-btn');
const result = document.getElementById('result');

countBtn.addEventListener('click', ()=>{
  result.innerHTML = '';
  const fruit = document.querySelectorAll('.fruit:checked');
  let inputNumber = [];
  let sum = 0;
  for(let i=0; i<fruit.length ; i++){
    inputNumber[i] = document.querySelectorAll(`[name="${fruit[i].getAttribute('name')}"]`)[1];
    let won = inputNumber[i].parentElement.previousElementSibling.firstElementChild;
    sum += Number(won.innerText)*Number(inputNumber[i].value);
    result.innerText += " " + fruit[i].value + " " + inputNumber[i].value + "개";
  }
  result.innerText += ' 총합 ' + sum + "원";
});
