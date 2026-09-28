import React from 'react'
import useFetch from '../customHooks/useFetch'

export default function FilterProducts(props) {
    
    let {data:categories}=useFetch("https://dummyjson.com/products/category-list")
        function handleCategoryChange(e) {
        const selectedCategory = e.target.value;
        console.log(selectedCategory);
        props.filterProductsByCategoryFunction(selectedCategory)
    }

    
  return (
    <div>
        {categories===null?"Loading":<div className='w-50'>
            <select className="form-select" onChange={handleCategoryChange}>
                <option defaultValue={'all'} >Filter By Category</option>
                <option value="all" key={'all'}>All</option>
                {categories.map(category => {return (
                    <option value={category} key={category}>{category}</option>
                )})}
            </select>
        </div>
        }
        
    </div>
    //   <div className='w-50'>
    //         <select className="form-select" aria-label="Default select example">
    //             <option selected>Filter By Category</option>
    //             <option value="all">All</option>
    //             {categories.map(category => {return (
    //                 <option value="all">{category}</option>
    //             )})}
    //         </select>
    //     </div>
  )
}
