// const q =document.getElementById('q');
// const w =document.getElementById('w');
// const e =document.getElementById('e');
// const r =document.getElementById('r');
// console.log(document.key);


// document.addEventListener('keydown', function(event){
//   new Function("if(event.key == '"+event.key+"'){ return "+event.key+".style.backgroundColor = 'black' "+event.key+".style.color = 'white'}")();
//   console.log(event.key);
//   // if(event.key == 'q'){
//   //   q.style.backgroundColor = "black"
//   //   q.style.color = "white"
//   // }
//   // if(event.key == 'w'){
//   //   w.style.backgroundColor = "black";
//   //   w.style.color = "white";
//   // }
//   // if(event.key == 'e'){
//   //   e.style.backgroundColor = "black";
//   //   e.style.color = "white";
//   // }
//   // if(event.key == 'r'){
//   //   r.style.backgroundColor = "black";
//   //   r.style.color = "white";
//   // }
// })
// document.addEventListener('keyup', function(event){
//   console.log(event.key);
//   if(event.key == 'q'){
//     q.style.backgroundColor = "white"
//     q.style.color = "black"
//   }
//   if(event.key == 'w'){
//     w.style.backgroundColor = "white";
//     w.style.color = "black";
//   }
//   if(event.key == 'e'){
//     e.style.backgroundColor = "white";
//     e.style.color = "black";
//   }
//   if(event.key == 'r'){
//     r.style.backgroundColor = "white";
//     r.style.color = "black";
//   }
// })
const keys = document.getElementsByClassName("key");

// 문서 내에서 키다운 이벤트가 발생했을 때
document.addEventListener("keydown", function(e){
  let index = 0;

  // e.key : 입력한 키
  // 문자열.toLowerCase() : 소문자로
  switch(e.key.toLowerCase()){
  case 'q': index = 0; break;
  case 'w': index = 1; break;
  case 'e': index = 2; break;
  case 'r': index = 3; break;
  default: return;
  }

  keys[index].style.backgroundColor = "skyblue";
})

document.addEventListener("keyup", function(e){

  let index = 0;

  switch(e.key.toLowerCase()){
  case 'q': index = 0; break;
  case 'w': index = 1; break;
  case 'e': index = 2; break;
  case 'r': index = 3; break;
  }

  keys[index].style.backgroundColor = "white";
});
