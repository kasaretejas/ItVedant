import React from 'react'
import { useForm } from 'react-hook-form';
import { replace, useNavigate } from 'react-router-dom';
import { toast } from 'react-toastify';

export default function Login() {
  let {register, handleSubmit, formState}=useForm()
  let navigateTo=useNavigate()
 async function collectFormData(formData)
  {
    console.log(formData);
   let response=await fetch("http://localhost:8080/api/v1/login", 
                {
                  method:"post",
                  headers: { "Content-Type": "application/json" },
                  body:JSON.stringify(formData)
                })
    let responseObject=await response.json()            
    if(response.ok)
    {
      toast.success(responseObject.message)
      //localStorage.setItem("user", JSON.stringify(responseObject.data))
      let role=responseObject.data.role
      if(role==="VENDOR")
      {
          window.open(`http://localhost:3001/?token=${encodeURIComponent(JSON.stringify(responseObject.data))}`,"_blank")
          navigateTo("/",replace)
      }
      else
      {
        localStorage.setItem("user", JSON.stringify(responseObject.data))
        navigateTo("/",replace)
      }
      
    }
    else if(response.status===404)
    {
      toast.error(responseObject.message)
    }
    else
    {
      toast.error("Login Failed")
    }

  }
  return (
   <div className='mt-3'>
      <h1 className='text-center'>Login Here!</h1>
      <div className='d-flex justify-content-center'>
        <form className='w-50' onSubmit={handleSubmit(collectFormData)}>
          <table className='table table-hover table-bordered '>
          <tbody >
            <tr>
              <td>
                <label htmlFor="userName" className="form-label">Username </label>
              </td>
              <td>
                <input type="text" className="form-control" id="userName"
                {...register("userName",
                                        {
                                          required:{value:true,message:"Username is required"},
                                          minLength:{value:3, message:"Min 3 characters required"},
                                          maxLength:{value:20, message:"Max 20 characters allowed"}
                                        })}/>
                <div className='text-danger'>{formState.errors?.userName?.message}</div>
              </td>
            </tr>
            <tr>
              <td>
                <label htmlFor="password" className="form-label">Password</label>
              </td>
              <td>
                <input type="password" className="form-control" id="password" 
                {...register("password",
                                        {
                                          required:{value:true,message:"Password is required"},
                                          minLength:{value:3, message:"Min 3 characters required"},
                                          maxLength:{value:20, message:"Max 20 characters allowed"}
                                        })}/>
                <div className='text-danger'>{formState.errors?.password?.message}</div>
              </td>
            </tr>
            <tr>
              <td colSpan={2}>
                <button type="submit" className="btn btn-primary w-100 mt-4">Login</button>
              </td>
            </tr>
            
          </tbody>
          </table>
        </form>
      </div>
    </div>
  )
}
