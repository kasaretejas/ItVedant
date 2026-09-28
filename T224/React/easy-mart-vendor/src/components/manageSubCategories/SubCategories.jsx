import React, { useEffect, useState } from 'react'
import { useForm } from 'react-hook-form'
import { toast } from 'react-toastify';
import Categories from '../manageCategories/Categories';

export default function SubCategories() {
  //---------- add subcategory code starts
  let user=JSON.parse(localStorage.getItem("user"))
  //console.log(user);
  let {register, handleSubmit, formState}=useForm()

  async function collectFormData(formData)
  {
    // console.log(formData);
    formData.category={id:Number(formData.category)}
    //console.log(formData);
    let response=await  fetch("http://localhost:8080/api/v1/vendor/subcategories",
      {
        method:"post",
        body:JSON.stringify(formData),
        headers:{"Content-Type":"application/json", Authorization: `Bearer ${user.token}`}
      })
    let responseObject=await response.json()
    if(response.ok)
    {
      toast.success("Sub-Category Added!")
      fetchAllCategories()
    }
    else
    {
      toast.error("Unable to add sub-category")
    }
  }
 //---------- add subcategory code ends

 //---------- display categories and sub categories code starts
 let [categories, setCategories]=useState(null)
 
//console.log(categories);

  async function fetchAllCategories()
    {
      let response =await fetch("http://localhost:8080/api/v1/get/categories")
      let responseObject=await response.json()
      setCategories(responseObject.data)
    }

  useEffect(()=>{
    fetchAllCategories()
  },[])
  //---------- display categories and sub categories code ends
  return (
    <div className='d-flex flex-column align-items-center mt-3'>
      <h1>Add Sub Category</h1>
      {/* code for form to add category */}
      <div className=' w-50'>
        <form className='d-flex justify-content-between' onSubmit={handleSubmit(collectFormData)}>
          <div>
            <select className="form-select" aria-label="Default select example"
            {...register("category",{required:{value:true,message:"Please select Category"}})}>
            <option value="">Select Category</option>
            {
              categories==null?"Categories Loading...": categories.map(category =>
                {
                  return <option key={category.id} value={category.id}>{category.name}</option>
                })
            }
          </select>
          <div className='text-danger'>{formState.errors?.category?.message}</div>
          </div>
          <div className='w-50'>
            <input type="text" className="form-control" id="name" placeholder='Category name' 
            {...register("name", {required:{value:true,message:"Sub-Category name required"}})}/>
            
            <div className="form-text text-danger">{formState.errors?.name?.message}</div>
          </div>
          <div>
            <button type="submit" className="btn btn-primary">Submit</button>
          </div>
      </form>
      </div>
      {/* code for table to display categories */}
      <div className='w-50 mt-5'>
        <table className="table table-hover table-bordered">
          <thead>
            <tr>
              <th scope="col">ID</th>
              <th scope="col">Category Name</th>
              <th scope="col">Sub-Categories</th>
            </tr>
          </thead>
          <tbody className='table-group-divider'>
                {
                  categories==null? 
                  <tr>
                      <td colSpan={3}>Data Loading</td>
                  </tr>:
                  categories.map(category=>{
                  return (
                    <tr key={category.id}>
                      <td>{category.id}</td>
                      <td className='text-capitalize'>{category.name}</td>
                      <td>
                        {
                          category.subCategories.map(subcategory=>
                            {
                              return <span key={subcategory.id} className='bg-secondary text-light border px-2 rounded-pill me-1'>{subcategory.name}</span>
                            })
                        }</td>
                    </tr>
                  )
                })
                }
                
                
            
          </tbody>
        </table>
      </div>
    </div>
  )
}
