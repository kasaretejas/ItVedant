import React, { useEffect, useState } from 'react'
import { useForm } from 'react-hook-form'
import { useNavigate } from 'react-router-dom'

export default function AddPet() {
 
    let {register,handleSubmit,formState}=useForm()
    let [pets, setPets] = useState(null)
    let [breeds, setbreeds] = useState(null)
    let navigate=useNavigate()
    const user = JSON.parse(localStorage.getItem("user"));
    const token = user?.token;

    async function fetchAllPetTypes() 
      {
        let response=await fetch("http://localhost:8080/api/v1/get/pet-types")
        let responseObject= await response.json()
        let allPetTypes = responseObject.data
        //console.log(allPettypes);
        setPets(allPetTypes)
      }

    async function fetchAllPetBreeds() 
      {
        let response=await fetch("http://localhost:8080/api/v1/get/pet-breeds")
        let responseObject= await response.json()
        let allPetBreeds = responseObject.data
        console.log(allPetBreeds);
        setbreeds(allPetBreeds)
      }
       useEffect(()=>{fetchAllPetTypes()},[])
       useEffect(()=>{fetchAllPetBreeds()},[])


    async function handleForm (data)
    {
      let formData = new FormData()
      formData.append("pet", JSON.stringify(
        {
          name:data.name,
          age:data.age,
          weight:data.weight,
          price:data.price,
          petBreed:{id:data.petBreedId}
        }
      ))

     formData.append("file",data.file[0])

    let response=await fetch(`http://localhost:8080/api/v1/admin/add-pet`,
      {
        method: "POST",
        headers: {"Authorization": `Bearer ${token}` },
        body:formData})
    let responseObject= await response.json()
    console.log(responseObject);
    navigate("/admin/manage-pets",{replace:true})


      

    }
    
  return (
    <div className='d-flex flex-column align-items-center'>
      <h1>Add your Pet</h1>
      <form className='w-50' onSubmit={handleSubmit(handleForm)}>
       
        <table className="table table-hover table-bordered table-dark">
          <tbody>
            <tr>
                <td> <label htmlFor="petType" className="form-label">Select Pet Category</label>   </td>
                <td>  
                    <select  className="form-select" {...register('petTypeId',{required:true})}>
               
                        {
                        pets && pets.map(pet => {
                            return <option value={pet.id} key={pet.id}>{pet.typeName}</option>

                        })
                        }
                    </select>
                </td>
            </tr> 
             <tr>
                <td> <label htmlFor="petBreed" className="form-label">Select Pet Breed</label>   </td>
                 <td>
                    <select  className="form-select" {...register('petBreedId',{required:true})}>
               
                        {
                        breeds && breeds.map(breed => {
                            return <option value={breed.id} key={breed.id}>{breed.breedName}</option>

                        })
                        }
                    </select>  </td>            
            </tr> 
             <tr>
                <td> <label htmlFor="name" className="form-label">Pet Name</label>   </td>
                <td> <input type="text" className="form-control" id="name" 
                      {...register('name',{required:true, minLength:3, maxLength:15})}/></td>
            </tr> 
            <tr>
                <td> <label htmlFor="price" className="form-label">Pet Price</label>   </td>
                <td> <input type="number" className="form-control" id="price" 
                      {...register('price',{required:true, min:10, max:500})}/></td>
            </tr> 
            <tr>
                <td> <label htmlFor="age" className="form-label">Pet Age</label>   </td>
                <td> <input type="number" className="form-control" id="age" placeholder='Enter in years'
                      {...register('age',{required:true, min:1, max:5})}/></td>
            </tr> 
            <tr>
                <td> <label htmlFor="weight" className="form-label">Pet Weight</label>   </td>
                <td> <input type="number" className="form-control" id="weight" placeholder='Enter in kg'
                      {...register('weight',{required:true, min:1, max:10})}/></td>
            </tr> 
            <tr>
                <td> <label htmlFor="image" className="form-label">Pet Image</label>   </td>
                <td> <input type="file" className="form-control" id="image"
                      {...register('file',{required:true})}/></td>
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
