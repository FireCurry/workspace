const btn = document.getElementById('btn');

btn.addEventListener('click', function(){
  const width = document.getElementById('width');
  const height = document.getElementById('height');
  const fontSize = document.getElementById('font-size');
  const weight = document.querySelector("[name=weight]:checked");
  const color = document.getElementById('color');
  const bgColor = document.getElementById('bg-color');
  const hSort = document.querySelector("[name=h-sort]:checked");
  const vSort = document.querySelector("[name=v-sort]:checked");
  const text = document.getElementById('text');
  const output = document.getElementById('output');
  if(width.value.trim().length > 0){
    output.style.width = width.value + 'px';
  }
  if(height.value.trim().length > 0){
    output.style.height = height.value + 'px';
  }
  if(fontSize.value.trim().length > 0){
    output.style.fontSize = fontSize.value + 'px';
  }
  console.log(weight);
  // switch(weight.id){
  //   case "weight1": output.style.fontWeight = 'normal'; break;
  //   case "weight2": output.style.fontWeight = 'bold'; break;
  // }
  if(weight != null){ // 글자 굵기가 체크 되었을 때
    output.style.fontWeight = weight.value;
  }
  output.style.color = color.value;
  output.style.backgroundColor = bgColor.value;
  if(hSort != null){
    output.style.justifyContent = hSort.value;
    output.style.textAlign = hSort.id;
  }
  // switch(hSort.id){
  //   case "left": output.style.justifyContent = "flex-start"; output.style.textAlign = 'left'; break; 
  //   case "h-center": output.style.justifyContent = "center"; output.style.textAlign = 'center'; break; 
  //   case "right": output.style.justifyContent = "flex-end"; output.style.textAlign = 'right';break;
  // default: break; 
  // }
  // switch(vSort.id){
  //   case "top": output.style.alignItems = "flex-start"; break; 
  //   case "v-center": output.style.alignItems = "center"; break; 
  //   case "bottom": output.style.alignItems = "flex-end"; break;
  // default: break; 
  // }
  if(vSort != null){
    output.style.alignItems = vSort.value;
  }
  if(text.value.trim().length > 0){
    output.innerText = text.value;
  }
});

