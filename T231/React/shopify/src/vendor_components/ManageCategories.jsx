import React, { useContext, useEffect, useState } from 'react'
import { useForm } from 'react-hook-form'
import { LoggedInUserContext } from '../project_context/LoggedInUserContext';
import { toast } from 'react-toastify';

export default function ManageCategories() {
    //posting new category
    let {register, handleSubmit, formState, watch}=useForm()
    let { userData, setUserData } = useContext(LoggedInUserContext);
    let [categoryAdded, setCategoryAdded]=useState(false)
    async function collectFormData(formData)
    {
            console.log(formData);
            let response=await fetch("http://localhost:8080/api/v1/vendor/categories",
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
                setCategoryAdded(true)
               toast.success(responseObject.message)
            }
            else
            {
                toast.error(responseObject.message)
            }
        }

    //getting all categories
    let [categories, setCategories]=useState(null)
    console.log(categories);
    
    async function getAllCategories()
    {
        setCategoryAdded(false)
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
    },[categoryAdded])
  return (
    <div className='mt-4'>
        <h1 className='text-center mb-4'>Manage Categories</h1>
        {/* add category */}
      <div>
        <form className='w-50 ms-auto me-auto' onSubmit={handleSubmit(collectFormData)}>
        
        <div className="mb-3">
            <input type="text" className="form-control" placeholder='Category Name' 
            {...register("name", 
            {
                required:{value:true, message:"Category Name is required"},
                minLength:{value:3, message:"Category must have min 3 characters"},
                maxLength:{value:10, message:"max 10 characters allowed"}
                })}/>
            
            <div className="form-text text-danger">{formState.errors?.name?.message}</div> 
        </div>
        
        <button type="submit" className="btn btn-primary w-100">Submit</button>
        </form>
      </div>
      <hr />
      <div className='d-flex justify-content-center mt-3 text-center'>
        <table className="table w-50 table-bordered table-hover">
            <thead>
                <tr>
                <th scope="col">ID</th>
                <th scope="col">NAME</th>
                </tr>
            </thead>
            <tbody>
                {
                    categories?categories.map(category=>{
                        return (
                            <tr key={category.id}>
                                <th scope="row">{category.id}</th>
                                <td className='text-capitalize'>{category.name}</td>
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
