import React, { useState } from "react";

const Display = ({ message, onClick }) => 
    {
  console.log("Child Rendered");
  return (
    <>
      <h2>{message}</h2>
      <button onClick={onClick}>Click Me</button>
    </>
  );
};

export default function Without() 
{
  const [count, setCount] = useState(0);

  const expensiveCalculation = () => 
    {
        console.log("Calculating...");
        return count * 1000;
    };

  const result = expensiveCalculation();

  const handleClick = () => 
    {
        console.log("Button clicked");
    };

  return (
    <>
      <h1>Count: {count}</h1>
      <h1>Result: {result}</h1>

      <button onClick={() => setCount(count + 1)}>Increase Count</button>

      <Display message="Hello Student" onClick={handleClick} />
    </>
  );
}
