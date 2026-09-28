import React, { useState } from 'react';
import ReactDOM from 'react-dom/client';
import { Parent } from './Parent';

//one component, returning one element
// function Counter()
// {
//   return <h1>Counter Application</h1>
// }

//one component, returning mutiple elements
// function Counter()
// {
//   return <div>
//           <h1>0</h1>
//           <button>Change Counter</button>
//         </div>
// }


//on button click, change counter value : here counter value inside h1 will not
//change but we will get chnaged value inside console
// function Counter()
// {
//   let count = 0
//   let changeCounter = ()=>
//   {
//       count = count + 1; 
//       console.log(count);
//   }
//   return <div>
//           <h1 id='counter'>{count}</h1>
//           <button onClick={()=>{changeCounter()}}>Change Counter</button>
//         </div>
// }


//understanding useState()
// function Counter()
// {
//   //let [variable, functionToUpdateStateOfVariable]=useState(defaultState)
//   let [count, setCount]=useState(0)//1->2
//   let changeCounter = ()=>
//   {
//       //count = count + 1; //here state of variable count is chnaging
//       setCount(count + 1)
//       console.log(count);
//   }
//   return <div>
//           <h1 id='counter'>{count}</h1>
//           <button onClick={()=>{changeCounter()}}>Change Counter</button>
//         </div>
// }

// const root = ReactDOM.createRoot(document.getElementById('root'));
// root.render(<Counter/>);


//creating mutiple component and data passing between component 
// function Display(props)
// { 
//   return <h1>Counter is - {props.countValue}</h1>
// }

// function Button(props)
// {
  
//   return <button onClick={()=>{ props.changeCounterFunction() }}>Click to change Counter</button>
// }

// function Parent()
// {
//   let [count, setCount]=useState(5)
//   let changeCounter = ()=>
//   {
//       setCount(count+1)
//   }
//   return <>
//     <Display countValue={count}/> {/*Display:Component, countValue:property */}
//     <Button changeCounterFunction={changeCounter}/>
//   </>
// }

// const root = ReactDOM.createRoot(document.getElementById('root'));
// root.render(<Parent/>);


//creating separate file for each component
const root = ReactDOM.createRoot(document.getElementById('root'));
root.render(<Parent/>);


