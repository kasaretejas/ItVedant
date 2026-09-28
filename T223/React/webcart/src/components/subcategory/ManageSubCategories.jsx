import React, { useEffect, useState } from 'react'
import { useForm } from 'react-hook-form';
import { toast } from 'react-toastify';

export default function ManageSubCategories() {
  let {register, handleSubmit, formState}=useForm()
  let [categories, setCategories]=useState(null)
  let [isSubCategoryAdded, setSubCategoryAdded]=useState(false)
  const user = JSON.parse(localStorage.getItem("user"));
  console.log(user);

  async function collectFormData(formData)
    {
      console.log(formData);
      console.log(formData.category);
      console.log(Number(formData.category));
      
      formData.category = { id:Number(formData.category)}
      console.log(formData);
      
      let response=await fetch("http://localhost:8080/api/v1/vendor/subcategories",
        {
          method:"post",
          headers : {"Content-Type":"application/json", Authorization: `Bearer ${user.token}`},
          body:JSON.stringify(formData)
        }) 
       let ResponseObject=await response.json()
       console.log(ResponseObject);
       setSubCategoryAdded(true)
      toast.success("sub category added")
    }

    useEffect(()=>
      {
          async function getAllCategories()
        {
          setSubCategoryAdded(false)
            //let response = await fetch("http://localhost:8080/api/v1/vendor/categories")
            let response = await fetch("http://localhost:8080/api/v1/get/categories", {
              headers : {Authorization: `Bearer ${user.token}`}
            })
            let responseObject  = await response.json()
            console.log(responseObject);
            setCategories(responseObject.data)
        }
        getAllCategories()
    },[isSubCategoryAdded])
  return (
    <div className=''>
      <div className='d-flex mt-5 justify-content-center'>
        <form className='d-flex w-50' onSubmit={handleSubmit(collectFormData)}>
          <input type="number" className="form-control me-3 border border-2 w-25" placeholder='Id' 
          {...register("id",
                        {required:{value:true, message:"sub category id required, "}})}/>

          <select className="form-select me-3"  
          {...register("category",
                      {required:{value:true, message:"category is required, "}})}>
            {
              categories==null?"Categories Loading...":
              categories.map((category)=>
                {
                  return <option key={category.id} value={category.id}>{category.name}</option>
                })
            }
            
          </select>

          <input type="text" className="form-control me-3 border border-2" placeholder='SubCategory Name' 
            {...register("name",
                        {required:{value:true, message:"sub category name is required"},
                        minLength:{value:3, message:"Min 3 characters required"}, 
                        maxLength:{value:10, message:"Max 10 characters allowed"}})}/>
            
          <input type="submit" className="btn btn-primary"/>
        </form>
      </div>
      <div className="form-text text-danger text-center">
              {formState.errors?.id?.message}
              {formState.errors?.name?.message} 
        </div>
      <div className='d-flex justify-content-center mt-5'>
        
        <table className="table table-hover table-bordered w-25">
          <thead>
            <tr>
              <th scope="col">Id</th>
              <th scope="col">Category</th>
              <th scope="col">Sub-Categories</th>
            </tr>
          </thead>
          <tbody className="table-group-divider">
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
                      <td>{category.id}</td>
                      <td>{category.name}</td>
                      <td>
                        {
                        category.subCategories.map((subcategory)=>{
                          return <span key={subcategory.id} className='bg-secondary rounded-pill ps-2 pe-2 me-1 text-light'>{subcategory.name}</span>
                        })
                      }
                      </td>
                     
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
