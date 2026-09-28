import React, { useEffect, useState } from 'react'
import { useForm } from 'react-hook-form'
import { replace, useNavigate } from 'react-router-dom';
import { toast } from 'react-toastify';

export default function ManageCategories() {
    const {register,handleSubmit,formState}=useForm()
    let navigateTo=useNavigate()
    let loggedInUser=JSON.parse(localStorage.getItem("user"))
    let [categoryAdded, setCategoryAdded]=useState(false)

    //add category code
   async  function collectFormData(formData)
    {
      console.log(formData);
      let response=await fetch("http://localhost:8080/api/v1/admin/categories",
            {
                method:"post",
                headers:{"Content-Type":"application/json", Authorization:`Bearer ${loggedInUser.jwtToken}`},
                body:JSON.stringify(formData)
            })
        let responseObject=await response.json()
        if(response.ok)
        {
          toast.success(responseObject.message)
          setCategoryAdded(true)
        }
        else
        {
          toast.error(responseObject.message)
        }
      
    }

    //fetch all categories code
    let [categories,setCategories]=useState(null)
    console.log(categories);
    
    async function fetchCategories()
    {
       setCategoryAdded(false)
        let response=await fetch("http://localhost:8080/api/v1/get/categories")
        let responseObject=await response.json()
        setCategories(responseObject.data)
        
    }
    
    useEffect(()=>
      {
        fetchCategories()
      },[categoryAdded])

  return (
    <div className='container'>
      <h3 className='text-center'>Manage Categories</h3>
      <hr />
      <div>
        {/* form code  */}
        <div className='container'>  
            <form className='w-50 ms-auto me-auto'  onSubmit={handleSubmit(collectFormData)}>
                <div className='row'>
                  <div className='col-9'>
                      <input type="text" className="form-control" id="username" placeholder='Category Name'
                      {...register("name", 
                          {
                            required:{value:true, message:"category name is required"} ,
                            minLength:{value:3, message:"min 3 characters required"},
                            maxLength:{value:15, message:"max 15 characters allowed"}
                          })}/>
                      <div className="text-danger">{formState.errors?.name?.message}</div>
                  </div>
                  <div className='col-3'>
                      <button type="submit" className="btn btn-primary w-100">Submit</button>
                  </div> 
                </div>  
            <hr />
            </form>
            
            
        </div>

        {/* table code  */}
        <div className='container mt-3'>
           <table className="table w-50 ms-auto me-auto text-center table-hover table-bordered">
              <thead>
                <tr>
                  <th scope="col">Id</th>
                  <th scope="col">Category Name</th>
                  <th scope="col">Action</th>
                </tr>
              </thead>
              <tbody>

                {
                  //categories?"YES":"Loading Categories...."
                  categories?categories.map(category=>{
                    return (
                      <tr key={category.id}>
                        <th scope="row">{category.id}</th>
                        <td>{category.name}</td>
                        <td><button className='btn btn-warning'><i className="bi bi-pencil"></i></button> </td>
                      </tr> 
                    )
                  }): <tr><td colSpan={3}>Loading Categories....</td></tr>
                }
              </tbody>
            </table> 
        </div>
      </div>
    </div>
  )
}
