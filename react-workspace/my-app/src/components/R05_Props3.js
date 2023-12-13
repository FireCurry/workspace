import React from 'react';

// 컴포넌트 부모/자식 관계 순서
// App -> Props3 -> ChildComponent

const ChildComponent = (props)=>{

  // PropsEx3로 부터 전달 받은 props : {name : "이름", age : 나이}

  return(
    <>
      <h3>App에서 부터 전달된 name : {props.name}</h3>
      <h3>PropsEx3에서 전달된 age : {props.age}</h3>
    </>
  );

}

const PropsEx3 = (props)=>{

  // 전달받은 props : {name : "이름"}

  // 동등 비교 연산자(==) : 값이 같으면 true
  // 동일 비교 연상자(===) : 자료형, 값이 모두 같으면 true

  const obj = {};
  obj.name = props.name;
  obj.age = props.name === '김민규' ? 28 : 30;

  // 전개, 나열 연산자 (...) : 배열, 객체를 나열하는 연산자
  // (양쪽 괄호가 사라진다고 생각하면 된다!)
  // ex) [1, 2, 3] -> 1, 2, 3
  // ex) {a:10, b:20} -> a:10, b:20

  return(
    // <ChildComponent name={props.name} age={props.name === '김민규' ? 28 : 30} />
    <ChildComponent {...obj} />
    /* name='김민규' age={28} 로 React에서 바꿔준다 */
  );
}

export default PropsEx3;