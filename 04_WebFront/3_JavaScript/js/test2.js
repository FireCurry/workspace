const width = document.getElementById('width');
const height = document.getElementById('height');
const fontSize = document.getElementById('font-size');
const weight = document.querySelector("[name=weight]:checked")
const weight1 = document.getElementById('weight1');
const weight2 = document.getElementById('weight2');
const color = document.getElementById('color');
const bgColor = document.getElementById('bg-color');
const left = document.getElementById('left');
const hCenter = document.getElementById('h-center');
const right = document.getElementById('right');
const top1 = document.getElementById('top');
const vCenter = document.getElementById('v-center');
const bottom = document.getElementById('bottom');
const text = document.getElementById('text');
const output = document.getElementById('output');
const btn = document.getElementById('btn');

btn.addEventListener('click', function(){
  output.style.width = width.value + 'px';
  output.style.height = height.value + 'px';
  output.style.fontSize = fontSize.value + 'px';
  output.style.fontWeight = 
});

