import React, { useEffect, useState } from 'react'
import { useForm } from 'react-hook-form'
import { toast } from 'react-toastify';

export default function ManageCategories() {
  let {register,handleSubmit, formState}=useForm()
  let [categories, setCategories]=useState(null)
  let [iscategoryAdded, setIscategoryAdded]=useState(false)
  async function collectFormData(formData)
  {
    console.log(formData);
    let response= await fetch("http://localhost:8080/api/v1/vendor/categories",
                            {
                              method:"POST", 
                              headers: {"Content-Type":"application/json"}, 
                              body:JSON.stringify(formData)
                            })
    let responseObject = await response.json()
    toast.success("Category Added!")
    setIscategoryAdded(true)
    }

    useEffect(()=>
      {
        async function getAllCategories()
        {
           setIscategoryAdded(false)
            let response=await fetch("http://localhost:8080/api/v1/vendor/categories")
            let responseObject=await response.json()
            console.log(responseObject.data);
            
            setCategories(responseObject.data)
        }
        getAllCategories()
      },[iscategoryAdded])
  return (
    <div>
      {/* code for form to add new category */}
      <div className='d-flex justify-content-center mt-5'>
        <form className='w-25 d-flex align-items-start' onSubmit={handleSubmit(collectFormData)}>
            <div className='me-3'>
              <input type="text" className="form-control me-3" 
                    {...register("name",
                        {
                          required:{value:true, message:"category name is required"},
                          minLength:{value:3, message:"min 3 characters required"},
                          maxLength:{value:10, message:"max 10 characters allowed"}
                        })} />
            <p className='text-danger'>{formState.errors?.name?.message}</p>
            </div>
            <input type="submit" className='btn btn-primary' value={"Add"}/>
        </form>
      </div>
      {/* code for table to display all categories */}
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
            </tr>
          </thead>
          <tbody className="table-group-divider">
            {categories.map((category)=>{
              return(
                <tr key={category.id}>
                  <th scope="row">{category.id}</th>
                  <td>{category.name}</td>
                </tr>
              )
            })}
            
            
          </tbody>
        </table>}
        
      </div>
    </div>
  )
}
