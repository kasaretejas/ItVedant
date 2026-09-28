import React from 'react'

export default function SortProduct(props) {
    function handleSortChange(e) {
    const flag = e.target.value;
    console.log(flag);
    props.sortProductsByPriceFunction(flag)
}

  return (
    <div>
        <select className="form-select" onChange={handleSortChange}>
            <option defaultValue={'1'} >Sort By Price</option>
            <option value="desc" >High to Low</option> 
            <option value="asc" >Low to High</option> 
            <option value="reset" >Reset</option>      
        </select>
    </div>
  )
}
