export function Button(props)
{
  
  return <button onClick={()=>{ props.changeCounterFunction() }}>Click to change Counter</button>
}