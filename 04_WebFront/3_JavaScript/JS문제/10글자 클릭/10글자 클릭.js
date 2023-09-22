const clearBtn = document.getElementById('clear-btn');
const result = document.getElementById('result');
const number = document.querySelectorAll('.number');

for(let i=0; i<10;i++){
  number[i].addEventListener('click', e=>{
    if(result.innerText.length > 9){
      alert('10자 까지만 입력할 수 있습니다')
      return;
    }
    result.innerText += e.target.innerText;
  });
}

clearBtn.addEventListener('click', ()=>{
  result.innerText = '';
});