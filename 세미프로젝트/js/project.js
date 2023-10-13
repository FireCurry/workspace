const menu = document.querySelectorAll('.menu');
const liContainer = document.querySelectorAll('.li-container');
const header = document.querySelector('.header');
const navUl = document.querySelectorAll('.dropdown>ul');
for(let i = 0 ; i < menu.length ; i++){
    menu[i].addEventListener('mouseenter', ()=>{
         header.setAttribute("style", 'height: 28rem;')
         header.addEventListener('mouseleave', ()=>{
              header.removeAttribute("style");
         });
    })
}