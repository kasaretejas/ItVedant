import React from 'react'
import { useForm } from 'react-hook-form'

export default function Contact() {
  let {register,handleSubmit,formState}=useForm()

  function collectFormData(formData)
  {
    console.log(formData);
  }

  return (
    <div className='d-flex flex-column align-items-center'>
      
      <h1 className='text-danger'>Contact Us</h1>
      <form className='w-25 border border-primary p-5 rounded-5' onSubmit={handleSubmit(collectFormData)}>
          <div className="mb-3">
            <label for="name" className="form-label">Name</label>
            <input type="text" className="form-control" id="name" 
            {...register("username",
            {required:{value:true, message:"Name is required"},
            minLength:{value:3, message:"Min 3 characters allowed in Name"},
            maxLength:{value:10, message:"Max 10 characters allowed in Name"}  })}/>

            <div className='text-danger'>{formState.errors?.username?.message}</div>
          </div>

          <div className="mb-3">
            <label for="age" className="form-label">Age</label>
            <input type="number" className="form-control" id="age"
            {...register("age",
            {required:{value:true, message:"Age is required"},
            min:{value:18, message:"Min 18 Age required"},
            max:{value:35, message:"Max 35 Age allowed"}})}/>

            <div className='text-danger'>{formState.errors?.age?.message}</div>
          </div>

          <div className="mb-3 mt-5">
            <select  id="city" className="form-select" 
            {...register("city",{required:{value:true, message:"City is required"}})}>
              <option selected value="">Select City</option>
              <option value="thane">Thane</option>
              <option value="pune">Pune</option>
              <option value="mumbai">Mumbai</option>
            </select>

            <div className='text-danger'>{formState.errors?.city?.message}</div>
          </div>

          <div className="mb-3 mt-4">
            <label for="gender" className="form-label">Gender</label> <br />

            <div className='d-flex justify-content-between'>
              <div>
                  <input type="radio"  id="male" className="form-check-input" value="male"
                {...register("gender",{required:{value:true, message:"Gender is required"}})}/>
                <label class="form-check-label ms-3" for="male">Male</label>
              </div>

              <div>
                <input type="radio"  id="female" className="form-check-input" value="female"
                {...register("gender",{required:{value:true, message:"Gender is required"}})}/>
                <label class="form-check-label ms-3" for="female">Female</label>
              </div>
            
            </div>
            <div className='text-danger'>{formState.errors?.gender?.message}</div>
          </div>

          <div className="mb-3 mt-4">
            <label for="doj" className="form-label">Joining Date</label>
            <input type="date" className="form-control" id="age"
            {...register("doj",{required:{value:true, message:"Joining date is required"}})}/>

            <div className='text-danger'>{formState.errors?.doj?.message}</div>
          </div>
          
          <button type="submit" className="btn btn-primary w-100 mt-4">Submit</button>
      </form>
    </div>
  )
}
