// const div1 = document.getElementsByClassName("color")[0];
// const div2 = document.getElementsByClassName("color")[1];
// const div3 = document.getElementsByClassName("color")[2];
// const div4 = document.getElementsByClassName("color")[3];
// const div5 = document.getElementsByClassName("color")[4];

// const color1 = document.getElementsByClassName("color-name")[0];
// const color2 = document.getElementsByClassName("color-name")[1];
// const color3 = document.getElementsByClassName("color-name")[2];
// const color4 = document.getElementsByClassName("color-name")[3];
// const color5 = document.getElementsByClassName("color-name")[4];

// function changeColor(){
//   for(let i = 0 ; i <= 4 ; i++){
//     new Function("return div" + i +".style.backgroundColor = color" + i + ".value")();
//   }
// }

function changeColor(){
  for(let i = 0 ; i <= 4 ; i++){
    new Function("return document.getElementsByClassName('color')["+i+"].style.backgroundColor"
    +" = document.getElementsByClassName('color-name')["+i+"].value")();
  }
}
