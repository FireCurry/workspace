// script 태그 또는 js 파일에
// 함수 내부가 아닌 위치에 코드를 작성하면
// HTML 랜더링 시 바로 수행

// 전역 변수
var str = "html 랜더링 시 바로 실행";
console.log(str);

var num1 = 100; // 전역 변수
num2 = 200; // 전역 변수

console.log("num1(전) : " + num1);
console.log("num2(전) : " + num2);

function testFn(){
  var num3 = 300; // function 레벨
  num4 = 400; // 전역 변수
  
  console.log("num3(함) : " + num3);
  console.log("num4(전) : " + num4);

  if( 1 == 1){ // 무조건 수행
    var num5 = 500;
    num6 = 600;
  }

  console.log("if 문 밖 num5(if) : " + num5);
  console.log("num6(전) : " + num6);
}

testFn(); // 함수는 호출해야 수행된다

// num3 is not defined(num3 변수가 정의되지 않았다)
// -> 함수 밖이라서 인식 안됨!!
// console.log("num3(함) : " + num3);

/* ***** JS는 중간에 오류가 발생하면 다음코드 해석X ****** */
console.log("함수 밖 num4(전) : " + num4);
console.log("if->함수 밖 num6(전) : " + num6);

var num7;
var num7; // var는 변수명 중복 가능

// ----------------------------------------------------------

// let / const
let let1 = 100;
// let let1 = 200; // 변수명 중복불가

let1 = 10; // 값 변경 가능

const con1 = 200; // 전역 변수(상수)
// con1 = 20; // Assignment to constant variable
          // (상수형 변수에는 새로운 값을 할당 할 수 없다)

function test2Fn(){
  let let1 = 1000; // block{}이 다르면 변수명 중복 가능

  let let3 = 321;
  const con3 = 3000;

  if (1 == 1){
    let let4 = 4444; 
    const con4 = 4567;
  }

  // if문 {} 밖으로 나와서 사용 불가
  // console.log(let4); // let4 is not defined
  // console.log(con4); con4 is not defined
}

test2Fn(); // 함수 호출

// 함수 밖으로 나오면 사용 불가
// console.log(let3); // let3 is not defined
// console.log(con3); //con3 is not defined

function typeTest(){
 
  // typeof 변수 : 변수의 자료형을 반환

  const box = document.getElementById("box");
  box.innerHTML = ""; // box 내부에 작성된 내용을 모두 삭제
  // undefined 확인
  let undef; // 선언 후 값 대입 x (자료형이 정의되지 않음)
  box.innerHTML += "undef : " + typeof undef;
  br();

  // string 확인
  // "", '' 모두 string(문자열) 의미
  const name = "홍길동"; // string
  const gender = 'M'; // string
  const phone = '01012341234'; // string

  print(name);
  print(gender);
  print(phone);

  // number 확인
  const age = 33;
  const height = 188.2;

  print(age);
  print(height);

  // boolean 확인
  const tt = true;
  const ff = false;

  print(tt);
  print(ff);

  // object 확인
  const arr = [10, 30, 20, 50, 40]; // object
  print(arr);

  // ******* JS 객체 { K:V, K:V } *********
  const user = {
    id : "user01",
    pw : "password01",
    age : 30
  };
  print(user);
  console.log(user);

  // 객체에 존재하는 값 얻어오는 방법(1)
  // 변수명.key
  print(user.id);
  print(user.pw);
  print(user.age);

  // 객체에 존재하는 값 얻어오는 방법(2)
  // 변수명["key"]
  print(user["id"]);
  print(user["pw"]);
  print(user["age"]);

  // function 확인

  // 요즘(2023년)에 함수 선언, 정의하는 트렌드
  // function(){} : 익명 함수(함수명 없음)
  // 변수명 == 함수명
  const sumFn = function(n1, n2){  return n1 + n2;  }

  // 함수 호출
  console.log(sumFn(10,40));
  print(sumFn);

  // sumFn    : 함수 자체(함수 코드)
  // sumFn()  : 함수 호출(함수 실행)

  print(br);
}

function br(){ // 줄바꿈 추가 함수
  const box = document.getElementById("box");
  box.innerHTML += "<br>";
}

// box에 출력하기
// 함수 매개변수 선언 시 let/const 작성 X
function print(temp){
  const box = document.getElementById("box");
  box.innerHTML += temp + " : " + typeof temp;
  br();
}