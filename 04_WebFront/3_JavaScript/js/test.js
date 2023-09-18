const q =document.getElementById('q');
const w =document.getElementById('w');
const e =document.getElementById('e');
const r =document.getElementById('r');
console.log(document.key);


document.addEventListener('keydown', function(event){
  new Function("if(event.key == '"+event.key+"'){ return "+event.key+".style.backgroundColor = 'black' "+event.key+".style.color = 'white'}")();
  console.log(event.key);
  // if(event.key == 'q'){
  //   q.style.backgroundColor = "black"
  //   q.style.color = "white"
  // }
  // if(event.key == 'w'){
  //   w.style.backgroundColor = "black";
  //   w.style.color = "white";
  // }
  // if(event.key == 'e'){
  //   e.style.backgroundColor = "black";
  //   e.style.color = "white";
  // }
  // if(event.key == 'r'){
  //   r.style.backgroundColor = "black";
  //   r.style.color = "white";
  // }
})
document.addEventListener('keyup', function(event){
  console.log(event.key);
  if(event.key == 'q'){
    q.style.backgroundColor = "white"
    q.style.color = "black"
  }
  if(event.key == 'w'){
    w.style.backgroundColor = "white";
    w.style.color = "black";
  }
  if(event.key == 'e'){
    e.style.backgroundColor = "white";
    e.style.color = "black";
  }
  if(event.key == 'r'){
    r.style.backgroundColor = "white";
    r.style.color = "black";
  }
})

switch(event.key.toLowerCase()){
  case 'q' : index = 0; break;
  case 'w' : index = 1; break;
  case 'e' : index = 2; break;
  case 'r' : index = 3; break;
  default : return;
}

keys[index].
