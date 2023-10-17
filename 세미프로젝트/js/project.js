const menu = document.querySelectorAll('.menu');
const liContainer = document.querySelectorAll('.li-container');
const header = document.querySelector('.header');
const navUl = document.querySelectorAll('.dropdown>ul');
const qnaQ = document.querySelectorAll('.qna-q');


/* 네비게이션 */
for(let i = 0 ; i < menu.length ; i++){
     menu[i].addEventListener('mouseenter', ()=>{

          for(let u = 0; u < liContainer.length ; u++){
               liContainer[u].classList.add("dpnone");
          }
          header.setAttribute("style", 'height: 28rem;')
          header.addEventListener('mouseleave', ()=>{
               for(let u = 0; u < liContainer.length ; u++){
                    liContainer[u].classList.remove("dpnone");
               }
               header.removeAttribute("style");
         });
    })
}

/* QnA 질문 */
for(let i = 0 ; i < qnaQ.length ; i++){
     qnaQ[i].addEventListener('click',e=>{
          if(e.target.nextElementSibling.classList.contains("qna-a-act")){
               e.target.nextElementSibling.classList.remove('qna-a-act');
          } else{
               e.target.nextElementSibling.classList.add('qna-a-act');
          }
     });
}