
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
  const btn = document.getElementById('btn');
  output.style.width = width.value + 'px';
  output.style.height = height.value + 'px';
  output.style.fontSize = fontSize.value + 'px';
  console.log(weight);
  switch(weight.id){
    case "weight1": output.style.fontWeight = 'normal'; break;
    case "weight2": output.style.fontWeight = 'bold'; break;
  }
  output.style.fontWeight = 
  output.style.color = color.value;
  output.style.backgroundColor = bgColor.value;
  switch(hSort.id){
    case "left": output.style.justifyContent = "flex-start"; break; 
    case "h-center": output.style.justifyContent = "center"; break; 
    case "right": output.style.justifyContent = "flex-end"; break;
  default: break; 
  }
  switch(vSort.id){
    case "top": output.style.alignItems = "flex-start"; break; 
    case "v-center": output.style.alignItems = "center"; break; 
    case "bottom": output.style.alignItems = "flex-end"; break;
  default: break; 
  }
  output.innerText = text.value;
});

