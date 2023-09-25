const inputBtn = document.getElementById('input-btn');
const commentDelBtn = document.getElementById('comment-del-btn');
const inputName = document.getElementById('input-name');
const inputText = document.getElementById('input-text');

inputBtn.addEventListener('click', ()=>{
  inputName.value;


});




































function getCurrentDate(){
  const now = new Date();

  const year = now.getFullYear();
  const month = now.getMonth() < 10 ? "0"+now.getMonth() : now.getMonth();
  const date = now.getDate() < 10 ? "0"+now.getDate() : now.getDate();
  const hour = now.getHours() < 10 ? "0"+now.getHours() : now.getHours();
  const minute = now.getMinutes() < 10 ? "0"+now.getMinutes() : now.getMinutes();
  const second = now.getSeconds() < 10 ? "0"+now.getSeconds() : now.getSeconds();

  return `${year}-${month}-${date} ${hour}:${minute}:${second}`;
}