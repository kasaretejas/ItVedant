import React, { useEffect, useState } from 'react'
import { useForm } from 'react-hook-form'
import { toast } from 'react-toastify';

export default function Categories() {
  //---------- add category code starts
  let user=JSON.parse(localStorage.getItem("user"))
  console.log(user);
  let {register, handleSubmit, formState}=useForm()

  async function collectFormData(formData)
  {
    console.log(formData);
    let response=await  fetch("http://localhost:8080/api/v1/vendor/categories",
      {
        method:"post",
        body:JSON.stringify(formData),
        headers:{"Content-Type":"application/json", Authorization: `Bearer ${user.token}`}
      })
    let responseObject=await response.json()
    if(response.ok)
    {
      toast.success("Category Added!")
      fetchAllCategories()
    }
    else if(response.status===302)
    {
      toast.error(`${formData.name} already exists!`)
    }
    else
    {
      toast.error("Unable to add category")
    }
  }
 //---------- add category code ends

 //---------- display categories code starts
 let [categories, setCategories]=useState(null)
 
console.log(categories);

  async function fetchAllCategories()
    {
      let response =await fetch("http://localhost:8080/api/v1/get/categories")
      let responseObject=await response.json()
      setCategories(responseObject.data)
    }

  useEffect(()=>{
    fetchAllCategories()
  },[])
  //---------- display categories code ends
  return (
    <div className='d-flex flex-column align-items-center mt-3'>
      <h1>Add Category</h1>
      {/* code for form to add category */}
      <div className=' w-25'>
        <form className='d-flex justify-content-between' onSubmit={handleSubmit(collectFormData)}>
          <div className='w-75'>
            <input type="text" className="form-control" id="name" placeholder='Category name' 
            {...register("name", {required:{value:true,message:"Category name required"}})}/>
            
            <div className="form-text text-danger">{formState.errors?.name?.message}</div>
          </div>
          <div>
            <button type="submit" className="btn btn-primary">Submit</button>
          </div>
      </form>
      </div>
      {/* code for table to display categories */}
      <div className='w-25 mt-5'>
        <table className="table table-hover table-bordered">
          <thead>
            <tr>
              <th scope="col">ID</th>
              <th scope="col">Category Name</th>
            </tr>
          </thead>
          <tbody className='table-group-divider'>
            {
              categories?categories.map(category=>{
                return (
                <tr key={category.id}>
                  <td>{category.id}</td>
                  <td className='text-capitalize'>{category.name}</td>
                </tr>)
              }):"Loading Categories..."
            }
            
            
          </tbody>
        </table>
      </div>
    </div>
  )
}
