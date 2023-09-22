const createBtn = document.querySelector(".create-btn");
const lottoArea = document.querySelector(".lotto-area");
const directInput = document.querySelector("#direct-input");

/* 생성 버튼 클릭 시 */
createBtn.addEventListener('click', () => {

  /* 선택된 개수 얻어오기 */
  const countSelect = document.querySelector("[name='count']:checked");

  if(countSelect == null){
    alert("생성할 번호 조합 개수를 선택 해주세요");
    return;
  }

  let count = Number(countSelect.value); // 선택한 개수
  if(count === -1){
    if(directInput.value.trim().length === 0){
      alert("생성 조합 개수를 직접 입력 해주세요")
      directInput.focus();
      return;
    }

    count = Number(directInput.value.trim());
  }

  // --------------------------------------

  /* 로또 번호 생성 후 화면에 추가하기 */

  lottoArea.innerHTML = '';

  let set;
  let arr;
  let row;
  let col;
  for(let i=0 ; i<count ; i++){
    // 난수 생성
    set = new Set();
    while(set.size < 6){
      // Math.random()을 대체하는 난수 생성 방법
      set.add(crypto.getRandomValues(new Uint32Array(1))[0] % 45 + 1);
    }

    // 배열로 변경 후 정렬
    arr = Array.from(set);
    arr.sort( (a,b) => a-b );

    // 요소 생성
    row = document.createElement('div');
    row.classList.add('row');

    for(let num of arr){
      col = document.createElement("div");
      col.classList.add("col");
      col.classList.add(`ball${Math.floor(num/10) + 1}`);
      col.textContent = num;
      row.append(col);      
    }

    lottoArea.append(row);
  }
});

/* 직접 입력 input 포커스 시 라디오 체크 */
directInput.addEventListener('focus', e => {
  e.target.previousElementSibling.checked = true;
});