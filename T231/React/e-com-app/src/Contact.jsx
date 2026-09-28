import React from 'react'
import { useForm } from 'react-hook-form'

export default function Contact() {
    let {register, handleSubmit,formState}=useForm()
    function collectFormData(formData)
    {
        console.log(formData);
    }
  return (
    <div className='border border-secondary mt-5 container p-5 rounded-5 border-3'>
      <form className='w-25 ms-auto me-auto' onSubmit={handleSubmit(collectFormData)}>
        <div className="mb-3">
            <label htmlFor="username" className="form-label">UserName</label>
            <input type="text" className="form-control" id="username" 
            {...register('username',{required:{value:true, message:"Username is required"}})} />

            <div className='text-danger'>
                {formState.errors?.username?.message}
            </div>
            
        </div>
        <button type="submit" className="btn btn-primary w-100">Submit</button>
    </form>
    </div>
  )
}
