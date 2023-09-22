const createBtn = document.getElementById('create-btn');
const result = document.getElementById('result');

createBtn.addEventListener('click', ()=>{
  result.innerHTML = "";
  const number = document.querySelector('[name="number"]:checked');
  let playCount;
  if(number !== null){
    // switch(number.value){
    //   case '1' : playCount = 1; break;
    //   case '3' : playCount = 3; break;
    //   case '5' : playCount = 5; break;
    //   case '10' : playCount = 10; break;
    //   default : playCount = document.getElementById('play-number').value; break;
    // }

    playCount = number.value;
    if(number.value == -1) playCount = document.getElementById('play-number').value; 

    for(let i=0; i<playCount; i++){
      const div = document.createElement('div')
      div.classList.add('ball-container');
      for(let j=0; j<6; j++){
        const span = document.createElement('span');
        div.append(span);
        let random = crypto.getRandomValues(new Uint32Array(1))[0] % 45 + 1;
        span.innerText = random;
        if(random<10){
          span.style.backgroundColor = 'gold';
        } else if(random<20){
          span.style.backgroundColor = 'skyblue';
        } else if(random<30){
          span.style.backgroundColor = 'tomato';
        } else if(random<40){
          span.style.backgroundColor = 'darkgrey';
        } else {
          span.style.backgroundColor = 'yellowgreen';
        }
      }
      result.append(div);
    }
  }
});