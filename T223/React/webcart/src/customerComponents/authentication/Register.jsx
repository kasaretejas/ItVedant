import React from 'react'
import { useForm } from 'react-hook-form';
import { replace, useNavigate } from 'react-router-dom';
import { toast } from 'react-toastify';

export default function Register() {
 let { register, handleSubmit, formState } = useForm();
  const navigate = useNavigate();


  async function handleRegister (formData)
    {
      console.log(formData);
      let response = await fetch(
                              `http://localhost:8080/api/v1/register`,
                              {
                                method: "POST",
                                headers: { "Content-Type": "application/json" },
                                body: JSON.stringify(formData),
                              });
      let responseObject = await response.json();
      if(response.ok)
      {
        toast.success(responseObject.message)
        navigate("/login",replace);
      }
      else
      {
        toast.error(responseObject.message)
      }
     
    };
return (
  <div className='d-flex flex-column align-items-center'>
    <h1>Register!</h1>
    <form className='w-50' onSubmit={handleSubmit(handleRegister)}>
      <table className="table table-hover table-bordered table-light">
        <tbody>
           
            <tr>
                <td> <label for="username" class="form-label">Username</label> </td>
                <td> <input type="text" class="form-control" id="username"
                {...register('username',{required:true})}/>
                {/* email pattern  - pattern:/^[^\s@]+@[^\s@]+\.[^\s@]+$/ */}
                </td>
            </tr>
            <tr>
              <td> <label for="password" class="form-label">Password</label> </td>
              <td> <input type="password" class="form-control" id="password" {...register('password',{required:true})}/></td>
            </tr>
            <tr>
                <td> <label for="role" class="form-label">I am</label> </td>
                <td>
                    <select id="role" className="form-select"
                    {...register('role',{required:true})}>
                    <option value="VENDOR">Vendor</option>
                    <option value="CUSTOMER">Customer</option>
                    </select>
                </td>
            </tr>
            <tr>
               <td colSpan={2}> <button type="submit" className="btn btn-primary w-100">Submit</button></td>
            </tr>
        </tbody>
      </table>
    </form>
  </div>
)
}
