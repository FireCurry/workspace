const createBtn = document.getElementById('create-btn');
const bingoBoard = document.getElementById('bingo-board');
const color = document.getElementById('font-color')

createBtn.addEventListener('click' , ()=>{
  const bingoLength = createBtn.previousElementSibling.value;
  // bingoLength * bingoLength 한 수 만큼 중복되지 않는 난수 생성
  // - Java 컬렉션 중 Set(중복x)과 똑같은 객체 존재!
  if(bingoLength < 3 || bingoLength > 7){
    return alert('3에서 7사이의 숫자를 입력해주세요')
  }
  const set = new Set(); // Set 생성

  // set.size : set에 저장된 요소의 수
  // set.add("값") : set에 값 추가
  while(set.size < bingoLength * bingoLength){
    const r = Math.floor( Math.random() * bingoLength * bingoLength +1 );
    set.add(r);
  }

  // set을 array(배열) 변경
  // - Array.from(set) : set을 배열로 변경하여 반환
  const arr = Array.from(set);

  // 재사용 용도의 변수 생성
  let row;
  let col;

  bingoBoard.innerHTML = ""; // 초기화

  for(let i=0 ; i<arr.length ; i++){

    // 각 행의 첫 번째 값이 들어갈 index 차례일 때
    if(i % bingoLength == 0){

      // 행(div.bingo-row) 만들기
      row = document.createElement('div');
      row.classList.add('bingo-row')

      // 만들어진 행을 #bingo-board에 추가
      bingoBoard.append(row);
    }

    // 열(div.bingo-col) 생성
    col = document.createElement('div');
    col.classList.add('bingo-col');
    col.innerText = arr[i]; // 생성된 열에 난수를 순서대로 대입

    /* ******************************************** */
    // 생성된 열(col)이 클릭 되었을 때
    // .check가 없으면 추가, 있으면 제거
    col.addEventListener('click', e=>{
      // e.target : 이벤트가 발생한 요소(클릭된 열)

      // 이벤트가 발생한 요소가 check 클래스를 포함하는지 확인
      if(e.target.classList.contains('check')){ // check 있을 때
        e.target.classList.remove('check'); // check 클래스 제거
      } else { // check 없을 때
        e.target.classList.add('check'); // check 클래스 생성
      }

      // 빙고 여부 검사
      checkBingo();
    });
    /* ******************************************** */

    // 행에 열을 마지막 자식으로 추가
    row.append(col);



  }
  
});


// bingoBoard.innerHTML = "";

// for(let i = 0 ; i < Number(bingoLength) ; i++){
//   const divRow = document.createElement('div');
//   divRow.classList.add('bingo-row');
//   bingoBoard.append(divRow);
  
//   for(let j = 0 ; j < Number(bingoLength) ; j++){
//     const divCol = document.createElement('div');
//     divCol.innerText = arr[j];
//     divCol.classList.add('bingo-col');
//     divRow.append(divCol);
//     divCol.addEventListener('click', ()=>{
//       divCol.classList.add('check');
//     });
//   }
// }

color.addEventListener('keyup', e=>{
  if(e.key == 'Enter'){
    bingoBoard.style.color = color.value;
  }
});

// 빙고 여부 검사
function checkBingo(){

  let board = []; // 비어있는 배열 생성
  // (참고. JS의 배열은 Java의 List와 비슷하다)

  const rows = document.querySelectorAll('.bingo-row');
  // console.log(rows);

  for(let i=0; i<rows.length; i++){
    // rows[i].children : 각 행의 모든 열(자식 요소)을 배열로 반환

    // 배열.push( 값/객체 ) : 배열 마지막 요소로 추가 (Java : List.add(E))
    board.push(rows[i].children);
  }

  // 모든 행, 열이 담긴 2차원 배열 생성
  // console.log(board);

  /* 모든 col에 있는 bingo 클래스 제거 */
  for(let i=0; i<board.length; i++){
    for(let k=0; k<board[i].length; k++){
      board[i][k].classList.remove('bingo');
    }
  }
  // 1. 행 빙고 검사
  rowCheck(board);

  // 2. 열 빙고 검사
  colCheck(board);
  
  // 3. 대각 빙고 검사
  diaCheck(board);
}

// 행 빙고 검사
function rowCheck(board){
  // board : 빙고판을 나타내는 2차원 배열
  // board[i] : i 번째 행
  // board[i][k] : i 번째 행 k 번째 열

  for(let i=0 ; i<board.length ; i++){

    // 한 행씩 접근해서 모든 열에 check 클래스가 있는지 검사
    let count = 0; // 현재 행에 check 개수 count

    for(let k=0; k<board[i].length; k++){
      if(board[i][k].classList.contains('check')){
        count++;
      }
    }

    // 행의 길이와 check 개수가 같다면
    // == 해당 행의 모든 열이 check 되어 있음
    if(count == board[i].length){
      for(let k=0; k<board[i].length; k++){
        board[i][k].classList.add('bingo');
      }
    }
  }
};

// 열 빙고 검사
function colCheck(board){
  // board : 빙고판을 나타내는 2차원 배열

  // k == 열의 인덱스
  // i == 행의 인덱스

  // board[i][k] : i 번째 행 k 번째 열

  // board.length : 행의 길이
  // board[0].length : 0행의 열의 길이
  // 빙고판은 정사각형 : 행과 열의 길이가 같다

  const bingoLength = board.length; // 빙고판 길이
  for(let k=0; k<bingoLength; k++){ // 열 제어
    let count = 0; // check 개수 count
    for(let i=0; i<bingoLength; i++){ // 행 제어
      if(board[i][k].classList.contains('check')){
        count++;
      }
    }
    if(count == bingoLength){ // 모든 열이 체크되어 있다면
      for(let i=0; i<bingoLength; i++){ // 행 제어
        board[i][k].classList.add('bingo');
      }
    }
  }
};

// 대각 빙고 검사
function diaCheck(board){
  const bingoLength = board.length;
  let count1 = 0;
  let count2 = 0;
  for(let i=0; i<board.length; i++){

    // 좌상 -> 우하 요소에 check 클래스가 있다면
    if(board[i][i].classList.contains('check')){
      count1++;
    }
    // 우상 -> 좌하 요소에 check 클래스가 있다면
    if(board[i][bingoLength-i-1].classList.contains('check')){
      count2++;
    }
  }

  // 좌상 -> 우하 방향이 모두 체크되어 있다면
  if(count1 == bingoLength){
    for(let i=0; i<board.length; i++){
      board[i][i].classList.add('bingo');
    }
  }
  // 좌하 -> 우상 방향이 모두 체크되어 있다면
  if(count2 == bingoLength){
    for(let i=0; i<board.length; i++){
      board[i][bingoLength-i-1].classList.add('bingo');
    }
  }
}