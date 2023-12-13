import './App.css';
import TestComponent from './components/TestComponent'
import React, { useState } from 'react';


function App() {

  const [flag, setFlag] = useState(true);

  return (
    <>
      <h1>hi</h1>
      <button onClick={()=>{setFlag(false)}}>{flag ? '삭제' : '복구'}</button>



      {flag ? <TestComponent /> : ''}
    </>
     );
}

export default App;
