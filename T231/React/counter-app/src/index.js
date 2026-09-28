import React, { useState } from 'react';
import ReactDOM from 'react-dom/client';


function App()
{
  //let count=0;
  let [count,setCount]=useState(0)

  function changeCounter()
  {
    count = count+1;
    console.log(count);
    setCount(count)
  }
  return <div>
    <h1>{count}</h1>
    <button onClick={()=>{changeCounter()}}>+1</button>
  </div>
}

const root = ReactDOM.createRoot(document.getElementById('root'));
root.render(<App/>);


