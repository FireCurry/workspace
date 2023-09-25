const inputPw = document.getElementById('input-pw');
const inputId = document.getElementById('input-id');
const inputPwCheck = document.getElementById('input-pw-check');
const inputEmail1 = document.getElementById('input-email1');
const inputEmail2 = document.getElementById('input-email2');
const inputAddress1 = document.getElementById('input-address1');
const inputAddress2 = document.getElementById('input-address2');

inputId.addEventListener('input' ,e=>{
  idCheckFn();
});
inputPw.addEventListener('focus', e=>{
  e.target.nextElementSibling.classList.remove('check');
  e.target.nextElementSibling.classList.remove('error');
  e.target.nextElementSibling.innerText =
  '영문자 대/소문자 특수문자, 숫자 포함 8 ~ 32자';
  pwCheckFn();
});
inputPw.addEventListener('blur', e=>{
  pwCheckFn();
  if(inputPw.value.trim().length === 0 && inputPwCheck.value.trim().length !== 0){
    inputPwCheck.nextElementSibling.innerText = '비밀번호를 먼저 입력해주세요';
    inputPwCheck.nextElementSibling.classList.add('error');
    inputPwCheck.nextElementSibling.classList.remove('check');
  }
});

inputPw.addEventListener('input', e=>{
  regEx = /^[a-zA-Z\d!@#$%^&*]{8,32}$/;
  e.target.nextElementSibling.classList.remove('error');
  e.target.nextElementSibling.classList.remove('check');
  pwCheckCheckFn();
  if(regEx.test(inputPw.value)){
    e.target.nextElementSibling.innerText = '유효한 패스워드 입니다';
    e.target.nextElementSibling.classList.add('check');
    e.target.nextElementSibling.classList.remove('error');
    pwCheckCheckFn2();
  } else {
    e.target.nextElementSibling.innerText = '유효하지 않은 패스워드 입니다';
    e.target.nextElementSibling.classList.add('error');
    e.target.nextElementSibling.classList.remove('check');
  }
});

inputPwCheck.addEventListener('focus', e=>{
  idCheckFn();
  pwCheckFn();
});

inputPwCheck.addEventListener('blur', e=>{
  pwCheckCheckFn();
});
inputPwCheck.addEventListener('input', e=>{
  if(inputPw.value.trim().length === 0){
    inputPwCheck.nextElementSibling.innerText = '비밀번호를 먼저 입력해주세요';
    e.target.nextElementSibling.classList.add('error');
    return;
  }
  pwCheckCheckFn2();
});
inputEmail1.addEventListener('focus', e=>{
  idCheckFn();
  pwCheckFn();
  pwCheckCheckFn();
});
inputEmail2.addEventListener('focus', e=>{
  idCheckFn();
  pwCheckFn();
  pwCheckCheckFn();
});
inputAddress1.addEventListener('focus', e=>{
  idCheckFn();
  pwCheckFn();
  pwCheckCheckFn();
});
inputAddress2.addEventListener('focus', e=>{
  idCheckFn();
  pwCheckFn();
  pwCheckCheckFn();
});
function idCheckFn(){
  if(inputId.value.trim().length == 0){
    inputId.nextElementSibling.innerText = '필수 입력 항목입니다';
    inputId.nextElementSibling.classList.add('error');
  } else {
    inputId.nextElementSibling.innerText = '';
    inputId.nextElementSibling.classList.remove('error');
  }
};
function pwCheckFn(){
  if(inputPw.value.trim().length == 0){
    inputPw.nextElementSibling.innerText = '필수 입력 항목입니다';
    inputPw.nextElementSibling.classList.add('error');
    return;
  }
};
function pwCheckCheckFn(){
  if(inputPwCheck.value.trim().length == 0){
    inputPwCheck.nextElementSibling.innerText = '필수 입력 항목입니다';
    inputPwCheck.nextElementSibling.classList.add('error');
    inputPwCheck.nextElementSibling.classList.remove('check');
  }
};

function pwCheckCheckFn2(){
  if(inputPwCheck.value.trim().length === 0){
    return;
  }
  if(inputPw.value === inputPwCheck.value){
    inputPwCheck.nextElementSibling.innerText = '패스워드 확인 완료'
    inputPwCheck.nextElementSibling.classList.add('check');
    inputPwCheck.nextElementSibling.classList.remove('error');
  } else {
    inputPwCheck.nextElementSibling.innerText = '패스워드가 불일치합니다'
    inputPwCheck.nextElementSibling.classList.remove('check');
    inputPwCheck.nextElementSibling.classList.add('error');
  }
}