const menu = document.querySelectorAll('.menu');
const liContainer = document.querySelectorAll('.li-container');
const header = document.querySelector('.header');
for(let i = 0 ; i < menu.length ; i++){
    menu[i].addEventListener('mouseenter', ()=>{
         header.setAttribute("style", 'height: 30rem;');
    })
    menu[i].addEventListener('mouseleave', ()=>{
         header.removeAttribute("style");
    })
}