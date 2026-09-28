import React, { useEffect, useState } from 'react'
import { flushSync } from 'react-dom';
import { useForm } from 'react-hook-form'
import { toast } from 'react-toastify';

export default function ManageCategories() {
  let {register, handleSubmit, formState}=useForm()
  let [categories, setCategories]=useState(null)
  let [isCategoryAdded, setCategoryAdded]=useState(false)
  const user = JSON.parse(localStorage.getItem("user"));
  console.log(user);
  async function collectFormData(formData)
    {
      console.log(formData);
      let response=await fetch("http://localhost:8080/api/v1/vendor/categories",
        {
          method:"post",
          headers : {"Content-Type":"application/json", Authorization: `Bearer ${user.token}`},
          body:JSON.stringify(formData)
        }) 
        
       let ResponseObject=await response.json()
       console.log(ResponseObject);
       setCategoryAdded(true)
      toast.success("category added")
    }

    useEffect(()=>
      {
          async function getAllCategories()
        {
          setCategoryAdded(false)
            //let response = await fetch("http://localhost:8080/api/v1/vendor/categories")
            let response = await fetch("http://localhost:8080/api/v1/get/categories",
              {
                headers : {Authorization: `Bearer ${user.token}`}
              })
            let responseObject  = await response.json()
            console.log(responseObject);
            setCategories(responseObject.data)
        }
        getAllCategories()
    },[isCategoryAdded])
  return (
    <div className=''>
      <div className='d-flex mt-5 justify-content-center'>
        <form className='d-flex w-50' onSubmit={handleSubmit(collectFormData)}>
          <input type="number" class="form-control me-3 border border-2 w-25" placeholder='Category Id' 
          {...register("id",
                        {required:{value:true, message:"category id required, "}})}/>

          <input type="text" class="form-control me-3 border border-2" placeholder='Category Name' 
            {...register("name",
                        {required:{value:true, message:"category name is required"},
                        minLength:{value:3, message:"Min 3 characters required"}, 
                        maxLength:{value:10, message:"Max 10 characters allowed"}})}/>
            
          <input type="submit" class="btn btn-primary"/>
        </form>
      </div>
      <div className="form-text text-danger text-center">
              {formState.errors?.id?.message}
              {formState.errors?.name?.message} 
        </div>
      <div className='d-flex justify-content-center mt-5'>
        
        <table class="table table-hover table-bordered w-25">
          <thead>
            <tr>
              <th scope="col">Category Id</th>
              <th scope="col">Category Name</th>
            </tr>
          </thead>
          <tbody class="table-group-divider">
            {
              categories==null?(
                <tr>
                  <td colSpan="2">Loading...</td>
                </tr>
              )
              :categories.map((category)=>
                {
                  return (
                    <tr key={category.id}>
                      <th scope="row">{category.id}</th>
                      <td>{category.name}</td>
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
