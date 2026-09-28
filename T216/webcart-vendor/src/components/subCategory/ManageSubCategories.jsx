import React, { useEffect, useState } from 'react'
import { useForm } from 'react-hook-form'
import { toast } from 'react-toastify';

export default function ManageSubCategories() {
  let {register,handleSubmit, formState}=useForm()
  let [categories, setCategories]=useState(null)
  let [isSubCategoryAdded, setIsSubCategoryAdded]=useState(false)
  async function collectFormData(formData)
    {
      console.log(formData);
      
      let response= await fetch(`http://localhost:8080/api/v1/vendor/sub-categories/${formData.categoryId}`,
                              {
                                method:"POST", 
                                headers: {"Content-Type":"application/json"}, 
                                body:JSON.stringify(formData)
                              })
      let responseObject = await response.json()
      toast.success("Sub - Category Added!")
      setIsSubCategoryAdded(true)
      }

   useEffect(()=>
        {
          async function getAllCategories()
          {
             setIsSubCategoryAdded(false)
              let response=await fetch("http://localhost:8080/api/v1/vendor/categories")
              let responseObject=await response.json()
              console.log(responseObject.data);
              
              setCategories(responseObject.data)
          }
          getAllCategories()
        },[isSubCategoryAdded])
  return (
  <div>
      {/* code for form to add new sub-category */}
      <div className='d-flex justify-content-center mt-5'>
        <form className='w-50 d-flex align-items-start justify-content-center' onSubmit={handleSubmit(collectFormData)}>
            <div className='me-3'>
              <select className="form-select" aria-label="Default select example" {...register("categoryId",{required:{value:true, message:"Category name required"}})}>
                <option value="">Select Category</option>
                {categories===null?
                  <option>Loading Categories...</option>:
                  categories.map((category)=>{
                  return <option key={category.id} value={category.id}>{category.name}</option>
                })}
              </select>
            <p className='text-danger'>{formState.errors?.categoryId?.message}</p>
            </div>
            <div className='me-3'>
              <input type="text" className="form-control me-3" placeholder='sub category name' 
                    {...register("name",
                        {
                          required:{value:true, message:"sub-category name is required"},
                          minLength:{value:3, message:"min 3 characters required"},
                          maxLength:{value:10, message:"max 10 characters allowed"}
                        })} />
            <p className='text-danger'>{formState.errors?.name?.message}</p>
            </div>
            <input type="submit" className='btn btn-primary' value={"Add"}/>
        </form>
      </div>
      {/* code for table to display all categories and sub categories */}
      <div className='d-flex justify-content-center mt-3'>
        {categories===null?
        <div class="spinner-border" role="status">
          <span class="visually-hidden">Loading...</span>
        </div>:
        <table className="table table-hover table-bordered w-50">
          <thead>
            <tr>
              <th scope="col">Category Id</th>
              <th scope="col">Category Name</th>
              <th scope="col">Sub Categories</th>
            </tr>
          </thead>
          <tbody className="table-group-divider">
            {categories.map((category)=>{
              return(
                <tr key={category.id}>
                  <th scope="row">{category.id}</th>
                  <td>{category.name}</td>
                  <td>
                    {category.subCategories.map((subCategory)=>
                      {
                        console.log(subCategory);
                        return <span className='bg-secondary text-light ps-2 pe-2 p-1 rounded-5 me-2' >{subCategory.name}</span>
                        
                      })}
                    {/* <span className='bg-primary text-light p-1 rounded-5' >formal</span> */}

                  </td>
                </tr>
              )
            })}
          </tbody>
        </table>}
        
      </div>
    </div>
  )
}
