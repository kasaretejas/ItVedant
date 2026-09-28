import React, { useEffect, useState } from 'react'
import { useForm } from 'react-hook-form'

export default function AddPetType() {

  let {register, handleSubmit, formState} = useForm();
  let [pets, setPets] = useState(null);
  let [isPetAdded, setIsPetAdded] = useState(false);
  const user = JSON.parse(localStorage.getItem("user"));
  const token = user?.token;

  let submitForm = async (formData) => {
    console.log(formData);
    let response = await fetch('http://localhost:8080/api/v1/admin/add-pet-type',{
      method:'POST',
      headers:{'Content-Type':'application/json',"Authorization": `Bearer ${token}`},
      body:JSON.stringify(formData)
    })
    let responseObject = await response.json();
    console.log(responseObject);
    setIsPetAdded(true); //to fecth all pets and display below 
  }

  async function fetchAllPetTypes() {
    setIsPetAdded(false)
    let response = await fetch("http://localhost:8080/api/v1/get/pet-types")
    let responseObject = await response.json()
    let allPetTypes = responseObject.data
    // console.log(allPetTypes)
    setPets(allPetTypes)
  }
  // fetchAllPetTypes();
  useEffect(()=>{fetchAllPetTypes()}, [isPetAdded])

  return (
    <div>
    <h3 className='text-center mt-3'>Add Pet Type</h3>
     <form className='d-flex justify-content-center mt-3 border-bottom border-primary border-3 rounded' onSubmit={handleSubmit(submitForm)}>
        <div className="mb-3 me-3 w-25">
          <input type="text" className="form-control"  placeholder='Enter Pet Type here' 
          {...register('typeName',{required:true, minLength:3, maxLength:10})}/>
         <div className='text-danger'>
           {formState.errors.typeName && formState.errors.typeName.type=="required" && "Pet Type is Required"}
           {formState.errors.typeName && formState.errors.typeName.type=="minLength" && "Pet Type must have min 3 characters"}
           {formState.errors.typeName && formState.errors.typeName.type=="maxLength" && "Pet Type is not allowed more than 10 characters"}
         </div>
        </div>
      <div>
        <button type="submit" className="btn btn-primary">Submit</button>
      </div>
    </form>
    <div className='mt-4 text-center d-flex justify-content-center'>
        <table className="table table-hover table-bordered table-dark w-50">
          <thead>
            <tr>
              <th scope="col">ID</th>
              <th scope="col">Pet Type</th>
              <th scope="col" colSpan={2}>Action</th>
            </tr>
          </thead>
          <tbody>
            {
              pets && pets.map(pet => {
                return <tr key={pet.id}>
                          <th scope="row">{pet.id}</th>
                          {/* <td>{pet.typeName.toLowerCase()}</td> */}
                          {/* <td>{pet.typeName[0].toUpperCase().concat(pet.typeName.slice(1))}</td> */}
                          <td>{pet.typeName[0].toUpperCase() + pet.typeName.slice(1)}</td>
                          <td>
                            <button type="button" className="btn btn-warning">Update</button>
                          </td>
                          <td>
                            <button type="button" className="btn btn-danger">Delete</button>
                          </td>
                        </tr>
              })
            }
            {/* <tr>
              <th scope="row">1</th>
              <td>Cat</td>
              <td>
                <button type="button" class="btn btn-warning">Update</button>
              </td>
              <td>
                <button type="button" class="btn btn-danger">Delete</button>
              </td>
            </tr> */}
          </tbody>
        </table>
      </div>
    </div>
  )
}
