import React, { useState } from 'react';

const NumberPlusMinus = ()=>{

  const [number, setNumber] = useState(0);

  const plusFn = ()=>{
    setNumber(number + 1);
  }
  
  const minusFn = ()=>{
    setNumber(number - 1);
  }

  return(
    <>
      <button className='minus' onClick={()=>{minusFn()}}>-</button>
      {number}
      <button className='plus' onClick={()=>{plusFn()}}>+</button>
    </>
  );
}

export default NumberPlusMinus;