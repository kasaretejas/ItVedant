import React, { useContext, useEffect, useState } from 'react'
import { useForm } from 'react-hook-form';
import { LoggedInUserContext } from '../project_context/LoggedInUserContext';
import { toast } from 'react-toastify';
import { Link } from 'react-router-dom';

export default function ManageSubCategories() {
    //posting new sub category
    let {register, handleSubmit, formState, watch}=useForm()
    let { userData, setUserData } = useContext(LoggedInUserContext);
    let [subCategoryAdded, setSubCategoryAdded]=useState(false)

    async function collectFormData(formData)
    {
        formData.category = {id:formData.category}
            console.log(formData);
            
            let response=await fetch("http://localhost:8080/api/v1/vendor/sub-categories",
                {
                    method:"post",
                    headers : 
                            {
                                "Content-Type":"application/json",
                                "Authorization":`Bearer ${userData.jwtToken}`
                            },
                    body: JSON.stringify(formData)
                }
            )
            let responseObject=await response.json()
            console.log(responseObject.data);
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
    // getting all categories to display inside dropdown 
    let [categories, setCategories]=useState(null)
    async function getAllCategories()
        {
            setSubCategoryAdded(false)
            let response=await fetch("http://localhost:8080/api/v1/vendor/categories",
                    {
                        method:"get",
                        headers : 
                                {
                                    "Authorization":`Bearer ${userData.jwtToken}`
                                }
                    }
                )
                let responseObject=await response.json()
                 
                setCategories(responseObject.data)  
        }
    
        useEffect(()=>{
            getAllCategories()
        },[subCategoryAdded])    

  return (
    <div className='mt-4'>
        <h1 className='text-center mb-4'>Manage Sub-Categories</h1>
        {/* add sub category */}
      <div>
        <form className='w-50 ms-auto me-auto' onSubmit={handleSubmit(collectFormData)}>
        
        <div className="mb-3 row">

            <div className='col-6'>
                <select className="form-select" aria-label="Default select example"
                {...register("category", {required:{value:true, message:"Category is required"}})}>
                    <option value={""}>Select Category</option>
                    {
                        categories?categories.map(category=>{
                            return  <option value={category.id} key={category.id}>{category.name}</option>
                        }): <option value={""}>Categories Loading</option>
                    }
                </select>
                <div className="form-text text-danger">{formState.errors?.category?.message}</div>
            </div>

            <div className='col-6'>
                <input type="text" className="form-control" placeholder='Sub Category Name' 
                {...register("name", 
                {
                    required:{value:true, message:"Sub Category name required"},
                    minLength:{value:3, message:"Sub Category must have min 3 characters"},
                    maxLength:{value:10, message:"max 10 characters allowed"}
                    })}/>
                <div className="form-text text-danger">{formState.errors?.name?.message}</div> 
            </div>
        </div>
        
        <button type="submit" className="btn btn-primary w-100">Submit</button>
        </form>
      </div>
      <hr />
      {/* display sub categories */}
    <div className='d-flex justify-content-center mt-3 text-center'>
        <table className="table w-75 table-bordered table-hover">
            <thead>
                <tr>
                <th scope="col">ID</th>
                <th scope="col">CATEGORY - NAME</th>
                <th scope="col">SUB-CATEGORIES</th>
                <th scope="col">ACTION</th>
                </tr>
            </thead>
            <tbody>
                {
                    categories?categories.map(category=>{
                        return (
                            <tr key={category.id}>
                                <th scope="row">{category.id}</th>
                                <td className='text-capitalize'>{category.name}</td>
                                <td className='text-capitalize'>
                                    {
                                        category.subCategories.map(subcategory=>{
                                            return <span className='bg-secondary text-light me-2 rounded-pill px-2'>{subcategory.name}</span>
                                        })
                                    }
                                </td>
                                <td className='text-capitalize'>
                                    <Link className='btn btn-warning' to={"/vendor/add-product"}>Add Product</Link>
                                </td>
                                
                            </tr>
                        )
                    }):<tr>
                            <th scope="row" colSpan={2}>Categories Loading...</th>
                            </tr>
                }
                
            </tbody>
        </table>
    </div> 
    </div>
  )
}
