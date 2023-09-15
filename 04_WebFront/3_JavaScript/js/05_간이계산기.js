// string->number
// --> Number("123") == 123

/* 입력 요소의 값 얻어오기 : 입력요소.value
  특정 요소에 내용 삽입하기 : 요소.innerText = "내용" */
const first = document.getElementById("first");
const second = document.getElementById("second");
const result = document.querySelector(".result");
// const result = document.getElementsByClassName("result");
function plus(){
  result.innerText = Number(first.value) + Number(second.value);
}

function minus(){
  result.innerText = Number(first.value) - Number(second.value);
}

function mul(){
  result.innerText = Number(first.value) * Number(second.value);
}

function div(){
  result.innerText = Number(first.value) / Number(second.value);
}

function mod(){
  result.innerText = Number(first.value) % Number(second.value);
}