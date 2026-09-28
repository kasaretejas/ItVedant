import React from 'react'
import { useForm } from 'react-hook-form'
import { replace, useNavigate } from 'react-router-dom';
import { toast } from 'react-toastify';

export default function Login() {
  
    const {register,handleSubmit,formState}=useForm()
    let navigateTo=useNavigate()
    async function collectFormData(formData)
    {
        console.log(formData);
       let response=await fetch("http://localhost:8080/api/v1/login",
            {
                method:"post",
                headers:{"Content-Type":"application/json"},
                body:JSON.stringify(formData)
            })
        let responseObject=await response.json()
        if(response.ok)
        {
            //console.log(responseObject);
            //console.log(responseObject.data);
            localStorage.setItem("user", JSON.stringify(responseObject.data))
            let role = responseObject.data.role;
            console.log(role);
            toast.success(responseObject.message) 
            if(role==="ADMIN") 
                {
                    navigateTo("/admin", replace)
                }
            else if (role ==="VENDOR") 
                {
                    navigateTo("/vendor", replace)
                }
            else 
                {
                    navigateTo("/", replace)
                }
        }
        else
        {
            //console.log("Registration failed");
            toast.error(responseObject.message)
            
        }
        
    }
  return (
    <div className='d-flex justify-content-center mt-5'>
      <form className='w-25 border border-2 p-4 rounded-5' onSubmit={handleSubmit(collectFormData)}>
            <h1 className='text-center'>Login</h1>
            <hr />
            <div className="mb-3">
                <label htmlFor="username" className="form-label">Username</label>
                <input type="text" className="form-control" id="username" 
                {...register("username", 
                    {
                       required:{value:true, message:"username is required"} ,
                       minLength:{value:3, message:"min 3 characters required"},
                       maxLength:{value:10, message:"max 10 characters allowed"}
                    })}/>
                <div className="text-danger">{formState.errors?.username?.message}</div>
            </div>
            <div className="mb-3">
                <label htmlFor="password" className="form-label">Password</label>
                <input type="password" className="form-control" id="password"
                {...register("password", 
                    {
                       required:{value:true, message:"password is required"} ,
                       pattern: {value: /^(?=.*[A-Za-z])(?=.*\d)(?=.*[!@#$%^&*]).+$/, message: "Include letters, numbers & special characters"}
                    })}
                />
                <div className="text-danger">{formState.errors?.password?.message}</div>
            </div>
            
            <button type="submit" className="btn btn-primary w-100">Login</button>
      </form>
    </div>
  )
}
