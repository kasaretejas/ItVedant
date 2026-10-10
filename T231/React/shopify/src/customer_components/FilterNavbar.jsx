import React, { useEffect, useState } from 'react'
import { useForm } from 'react-hook-form';

export default function FilterNavbar() {
    let [categories, setCategories]=useState(null)
    let {register, handleSubmit, formState, watch}=useForm()
    console.log(categories);
    
     //get all categories
    async function getAllCategories()
        {
            let response=await fetch("http://localhost:8080/api/v1/get/categories")
                let responseObject=await response.json()
                    
                setCategories(responseObject.data)  
        }
            
    useEffect(()=>{
        getAllCategories()
    },[]) 

    function collectFormData(formData)
    {

    }
  return (
    <div className='row mt-3'>
      <div className='col-3'>
            <select className="form-select" aria-label="Default select example">
                <option value={""}>Select Category</option>
                {
                    categories?categories.map(category=>{
                        return  <option value={category.id} key={category.id}>{category.name}</option>
                    }): <option value={""}>Categories Loading</option>
                }
            </select>
      </div>

      <div className='col-3'>
        <select className="form-select" aria-label="Default select example">
            <option value={""}>Select SubCategory</option>
            {
                categories?categories.map(category=>
                    {
                        return category.subCategories.map(subCategory=>{
                            return  <option value={subCategory.id} key={subCategory.id}>{subCategory.name}</option>
                        })
                    }): <option value={""}>SubCategories Loading</option>
            }
        </select>
      </div>


      <div className='col-3'>
                <select className="form-select" aria-label="Default select example">
                    <option value={""}>Sort By Price</option>
                    <option value={"asc"}>Low to High</option>
                    <option value={"desc"}>High to Low</option>
                </select>
                <div className="form-text text-danger">{formState.errors?.subCategory?.message}</div>
      </div>


      <div className="col-3">
        <form onSubmit={handleSubmit(collectFormData)} className='d-flex'>
            <div className='me-2'>
                <input type="text" className="form-control" placeholder='Product Name' 
                {...register("name", 
                {
                    required:{value:true, message:"product name required"}
                })}/>
            <div className="form-text text-danger">{formState.errors?.name?.message}</div></div> 
            <div>
                <button type="submit" className="btn btn-primary w-100">Submit</button>
            </div>
        </form>
      </div>
    </div>
  )
}
