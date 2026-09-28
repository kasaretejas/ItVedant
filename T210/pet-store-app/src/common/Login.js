import React from 'react'
import { useForm } from "react-hook-form";
import { useNavigate } from "react-router-dom";


export default function Login() {
    let { register, handleSubmit, formState } = useForm();
    const navigate = useNavigate();
    async function handleLogin  (formData) 
    {
    console.log(formData);
    let response = await fetch(
      `http://localhost:8080/api/v1/login`,
      {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify(formData),
      }
    );
    let responseObject = await response.json();
    localStorage.setItem("user", JSON.stringify(responseObject.data));
    //console.log(responseObject);
     // Navigate based on role
      const role = responseObject.data.role;

      if (role === "ADMIN") {
        navigate("/admin");
      } else if (role === "CUSTOMER") {
        navigate("/");
      } else {
        navigate("/");
      }
    
  };


   return (
    <div className='d-flex flex-column align-items-center'>
      <h1>Login!</h1>
      <form className='w-50' onSubmit={handleSubmit(handleLogin)}>
       
        <table className="table table-hover table-bordered table-dark">
          <tbody>
             <tr>
                <td> <label for="email" class="form-label">Email</label>   </td>
                <td> <input type="email" class="form-control" id="email" 
                      {...register('email',{required:true,pattern:/^[^\s@]+@[^\s@]+\.[^\s@]+$/})}/></td>
            </tr> 
            <tr>
                <td> <label for="password" class="form-label">Password</label>   </td>
                <td> <input type="password" class="form-control" id="password" 
                      {...register('password',{required:true})}/></td>
            </tr>  
             <tr>
                <td colSpan={2}>  <button type="submit" className="btn btn-primary w-100">Submit</button></td>
            </tr> 
          </tbody>
        
        </table>
      </form>
    </div>
  )
}
