import React from 'react'
import { useForm } from 'react-hook-form'
import { useNavigate } from 'react-router-dom';
import { toast } from 'react-toastify';

export default function Register() {
    let {register, handleSubmit, formState, watch}=useForm()
    let navigateTo=useNavigate()
    async function collectFormData(formData)
    {
        console.log(formData);
        let response=await fetch("http://localhost:8080/api/v1/register",
            {
                method:"post",
                headers : {"Content-Type":"application/json"},
                body: JSON.stringify(formData)
            }
        )
        let responseObject=await response.json()
        console.log(responseObject.data);
        if(response.ok)
        {
           toast.success(responseObject.message)
           navigateTo("/login")
        }
        else
        {
            toast.error(responseObject.message)
        }
    }

  return (
    <div className='container mt-3'>
    <h1 className='text-center mb-4'>Register</h1>
     <form className='w-50 ms-auto me-auto' onSubmit={handleSubmit(collectFormData)}>
        
        <div className="mb-3">
            <input type="text" className="form-control" placeholder='UserName' 
            {...register("username", 
            {
                required:{value:true, message:"Username is required"},
                minLength:{value:3, message:"Username must have min 3 characters"},
                maxLength:{value:10, message:"max 10 characters allowed"}
                })}/>
            
            <div className="form-text text-danger">{formState.errors?.username?.message}</div>
            
            
        </div>
        <div className="mb-3">
            <input type="password" className="form-control" placeholder='Password'
            {...register("password", {required:{value:true, message:"Password is required"}})}/>
            <div className="form-text text-danger">{formState.errors?.password?.message}</div>
        </div>

        <div className="mb-3">
            <select className="form-select" aria-label="Default select example"
            {...register("role", {required:{value:true, message:"Role is required"}})}>
                <option value={""}>Select Role</option>
                <option value="VENDOR">Vendor</option>
                <option value="CUSTOMER">Customer</option>
            </select>
            <div className="form-text text-danger">{formState.errors?.role?.message}</div>
        </div>

        <button type="submit" className="btn btn-primary w-100">Submit</button>
    </form>
    </div>
  )
}
