import React, { useContext, useEffect, useState } from 'react'
import { useForm } from 'react-hook-form';
import { LoggedInUserContext } from '../project_context/LoggedInUserContext';
import { Link, useNavigate } from 'react-router-dom';
import { toast } from 'react-toastify';

export default function AddProduct() {
    let {register, handleSubmit, formState, watch}=useForm()
    let { userData, setUserData } = useContext(LoggedInUserContext);
    let [categories, setCategories]=useState(null)
    let navigateTo=useNavigate()

    //get all categories
     async function getAllCategories()
            {
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
            },[])  
            
    //add new product
    async function collectFormData(formData)
    {
        let formDataObject=new FormData()
        formDataObject.append("productObject",JSON.stringify(
            {
                name:formData.name,
                price:formData.price,
                quantity:formData.quantity,
                subCategory:{id:formData.subCategory},
                vendor:{id:userData.id}
            }))
        formDataObject.append("productImage",formData.image[0])
        
        let response=await fetch("http://localhost:8080/api/v1/vendor/products",
                {
                    method:"post",
                    headers : 
                            {
                                "Authorization":`Bearer ${userData.jwtToken}`
                            },
                    body: formDataObject
                })
        let responseObject=await response.json()
         console.log(responseObject.data);
            if(response.ok)
                {
                    toast.success(responseObject.message)    
                    navigateTo("/vendor")
                }
                else
                {
                    toast.error("Can't add product")
                }           
    }



  return (
    <div className='mt-4'>
        <h1 className='text-center mb-4'>Add Product</h1>
        {/* add sub category */}
      <div>
        <form className='w-50 ms-auto me-auto' onSubmit={handleSubmit(collectFormData)}>
        
        {/* select category and sub category  */}
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
                <select className="form-select" aria-label="Default select example"
                {...register("subCategory", {required:{value:true, message:"Sub category is required"}})}>
                    <option value={""}>Select SubCategory</option>
                    {
                        categories?categories.map(category=>
                            {
                                return category.subCategories.map(subCategory=>{
                                    return  <option value={subCategory.id} key={subCategory.id}>{subCategory.name}</option>
                                })
                            }): <option value={""}>SubCategories Loading</option>
                    }
                </select>
                <div className="form-text text-danger">{formState.errors?.subCategory?.message}</div>
            </div>

        </div>

        {/* add product name and price  */}
        <div className="mb-3 row">
            <div className='col-6'>
                <input type="text" className="form-control" placeholder='Product Name' 
                {...register("name", 
                    {
                        required:{value:true, message:"product name required"}
                    })}/>
                <div className="form-text text-danger">{formState.errors?.name?.message}</div> 
            </div> 

            <div className='col-6'>
                <input type="number" className="form-control" placeholder='Product Price' 
                {...register("price", 
                    {
                        required:{value:true, message:"product price required"}
                    })}/>
                <div className="form-text text-danger">{formState.errors?.price?.message}</div> 
            </div> 
            

           
        </div>
        
        {/* add product image and qunatity */}
        <div className="mb-3 row">
            <div className='col-6'>
                <input type="file" className="form-control" placeholder='Product Image' 
                {...register("image", 
                    {
                        required:{value:true, message:"product image required"}
                    })}/>
                <div className="form-text text-danger">{formState.errors?.image?.message}</div> 
            </div> 

            <div className='col-6'>
                <input type="number" className="form-control" placeholder='Product Quantity' 
                {...register("quantity", 
                    {
                        required:{value:true, message:"product quantity required"}
                    })}/>
                <div className="form-text text-danger">{formState.errors?.quantity?.message}</div> 
            </div> 
            

           
        </div>

        <button type="submit" className="btn btn-primary w-100">Submit</button>
        </form>
      </div>
    
    </div>
  )
}
