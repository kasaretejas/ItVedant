import React from 'react'
import { useForm } from 'react-hook-form'

export default function Contact() 
{
  // pattern: {
  //     value: /^(?=.*[A-Z])(?=.*\d)(?=.*[^A-Za-z0-9]).+$/,
  //     message:
  //       "Password must contain at least 1 uppercase letter, 1 number, and 1 special character",
  //   }
  let {register, handleSubmit, formState}=useForm()
  function collectFormData(formData)
  {
    console.log(formData); 
  }
  return (
    <div className='mt-5'>
      <p>Collect follwoing data : full name, email, age,phone, address, password, date of birth(date), gender(radio), course(dropdown) </p>
      <form className='w-25 m-auto border border-2 p-3 rounded-4' onSubmit={handleSubmit(collectFormData)}>
        <div className="mb-3">
          <label htmlFor="username" className="form-label">UserName</label>
          <input type="text" className="form-control" {...register("username",
            {required:{value:true, message:"username is required"},
            pattern: {value: /^[^.]+$/,message: "User name must not contain dots (.)",}, 
            minLength:{value:3, message:"Min 3 characters required"}, 
            maxLength:{value:10, message:"Max 10 characters allowed"}})}/>
          <div className="form-text text-danger">
            {formState.errors?.username?.message}
          </div>
        </div>
        <button type="submit" className="btn btn-primary w-100">Submit</button>
      </form>
    </div>
  )
}
