import React, { useEffect, useState } from 'react'
import { useForm } from 'react-hook-form'
import { Link, replace, useNavigate } from 'react-router-dom';
import { toast } from 'react-toastify';

export default function ManageSubCategories() {
    const {register,handleSubmit,formState}=useForm()
    let navigateTo=useNavigate()
    let loggedInUser=JSON.parse(localStorage.getItem("user"))
    let [subCategoryAdded, setSubCategoryAdded]=useState(false)

    //add sub category code
       async  function collectFormData(formData)
        {
          console.log(formData);
          formData.category = {id:formData.category}
          formData.user = {id:loggedInUser.id}
           console.log(formData);
          let response=await fetch("http://localhost:8080/api/v1/vendor/subcategories",
                {
                    method:"post",
                    headers:{"Content-Type":"application/json", Authorization:`Bearer ${loggedInUser.jwtToken}`},
                    body:JSON.stringify(formData)
                })
            let responseObject=await response.json()
            console.log(responseObject);
            
            if(response.ok)
            {
              toast.success(responseObject.message)
              setSubCategoryAdded(true)
            }
            else
            {
              toast.error(responseObject.message)
            }
          
        }
    
        //fetch all sub categories code
        // let [subCategories,setSubCategories]=useState(null)
        // console.log(subCategories);
        
        // async function fetchSubCategories()
        // {
        //    setSubCategoryAdded(false)
        //     let response=await fetch(`http://localhost:8080/api/v1/get/categories`)
        //     let responseObject=await response.json()
        //     setSubCategories(responseObject.data)
            
        // }
        
        // useEffect(()=>
        //   {
        //     fetchSubCategories()
        //   },[subCategoryAdded])


        //fetch all categories
        let [categories,setCategories]=useState(null)
        console.log(categories);
        async function fetchCategories()
            {
              setSubCategoryAdded(false)
                let response=await fetch("http://localhost:8080/api/v1/get/categories")
                let responseObject=await response.json()
                setCategories(responseObject.data)
                
            }
            
        useEffect(()=>
              {
                fetchCategories()
              },[subCategoryAdded])
    
  return (
    <div className='container'>
      <h3 className='text-center'>Manage Sub-Categories</h3>
      <hr />
      <div>
        {/* form code  */}
        <div className='container'>  
            <form className='w-50 ms-auto me-auto'  onSubmit={handleSubmit(collectFormData)}>
                <div className='row'>
                  <div className='col-4'>
                      <select className="form-select" {...register("category", {required:{value:true, message:"category is required"}})} >
                          <option value="">Select Category</option>
                          {
                            // categories?"yes":"Loading categories"
                            categories?categories.map(category=>{
                              return <option value={category.id} key={category.id}>{category.name}</option>
                            }):"Loading categories"
                          }
                      </select>
                      <div className="text-danger">{formState.errors?.category?.message}</div>
                  </div>
                  <div className='col-5'>
                      <input type="text" className="form-control" id="name" placeholder='Sub category Name'
                      {...register("name", 
                          {
                            required:{value:true, message:"sub category name is required"} ,
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
           <table className="table w-75 ms-auto me-auto text-center table-hover table-bordered" style={{ tableLayout: "fixed" }}>
              <colgroup>
                <col style={{ width: "5%" }} />
                <col style={{ width: "13%" }} />
                <col style={{ width: "67%" }} />
                <col style={{ width: "15%" }} />
              </colgroup>
              
              <thead>
                <tr>
                  <th scope="col">Id</th>
                  <th scope="col">Category</th>
                  <th scope="col">Sub Category</th>
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
                        <td>
                           <div className="d-flex flex-wrap justify-content-center gap-1">
                          {
                            category.subCategories.map(subcategory=>{
                              return <span className='bg-secondary px-2 rounded text-light' key={subcategory.id}>{subcategory.name}</span>
                            })
                          }
                          </div>
                        </td>
                        <td><Link className='btn btn-primary' to={"/vendor/add-product"}>Add Product</Link> </td>
                      </tr> 
                    )
                  }): <tr><td colSpan={4}>Loading Sub Categories....</td></tr>
                }
              </tbody>
            </table> 
        </div>

        
      </div>
    </div>
  )
}
