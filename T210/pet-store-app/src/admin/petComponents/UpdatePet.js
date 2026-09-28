import React, { useEffect, useState } from 'react'
import { useForm } from 'react-hook-form'
import { useNavigate, useParams } from 'react-router-dom'


export default function UpdatePet() {
    let urlParams=useParams()
    const user = JSON.parse(localStorage.getItem("user"));
    const token = user?.token;


    //console.log(urlParams.petId); //here petId is same that we have metioned in index.js
    let petId = urlParams.petId
   
    let {register,handleSubmit,formState}=useForm()
    let [petTypes, setPetTypes] = useState([])
    let [petBreeds, setPetBreeds] = useState([])
    let [pet, setPet]=useState(null)
    
    const [loading, setLoading] = useState(true); // flag for waiting

    let navigate=useNavigate()

      //in below function we are going to fetch all 3 apis at a time (getPetById, getAllPetTypes, getAllPetBreeds)
      async function fetchAllAPIs()
      {
          try 
            {
              // Call multiple APIs in parallel
              const [petResponse, PetTypesResponse, PetBreedsResponse] = await Promise.all([
                fetch(`http://localhost:8080/api/v1/get/pets/${petId}`),
                fetch("http://localhost:8080/api/v1/get/pet-types"),
                fetch("http://localhost:8080/api/v1/get/pet-breeds"),
              ]);

              // Wait for all JSON conversions
              const [pet, petTypes, petBreeds] = await Promise.all([
                petResponse.json(),
                PetTypesResponse.json(),
                PetBreedsResponse.json(),
              ]);
              
              
              //setData({pet:pet.data, petTypes:petTypes.data, petBreeds:petBreeds.data})
              setPet(pet.data)
              setPetTypes(petTypes.data)
              setPetBreeds(petBreeds.data)
              

            } 
          catch (error) 
            {
              console.error("Error fetching data:", error);
            }
          finally
            {
              setLoading(false); 
            }
      }

      useEffect(()=>{fetchAllAPIs()},[])
    
        async function handleForm (data)
        {
          console.log(data);

          let formData = new FormData()
          formData.append("pet", JSON.stringify(
            {
              name:data.name,
              price:data.price,
              age:data.age,
              weight:data.weight,
              petBreed:{id:data.petBreedId}
            }
          ))
         
          
    
         formData.append("file",data.file[0])
    
        let response=await fetch(`http://localhost:8080/api/v1/admin/update-pet/${petId}`,
          {method:"put",headers: {"Authorization": `Bearer ${token}` },body:formData})
        let responseObject= await response.json()
        console.log(responseObject);
        navigate("/admin/manage-pets",{replace:true})

        }

 return (
    <>
      {loading? <div>Loading ...</div> : (
      <div className='d-flex flex-column align-items-center'>
      <h1 className='text-capitalize'>Update your Pet : { pet && pet.name}</h1>
      <form className='w-50' onSubmit={handleSubmit(handleForm)}>
       
        <table className="table table-hover table-bordered table-dark">
          <tbody>
            <tr>
                <td> <label htmlFor="petType" className="form-label">Select Pet Category</label>   </td>
                <td>  
                    <select  className="form-select" {...register('petTypeId',{required:true})}>
               
                        {pet && (<option value={pet?.petBreed?.petType?.id} key={pet?.petBreed?.petType?.id} >{pet?.petBreed?.petType?.typeName}</option>)}
                        {
                          petTypes.length>0 && 
                          petTypes
                                  .filter(petType => petType.id!==pet?.petBreed?.petType?.id)
                                  .map(petType => <option value={petType.id} key={petType.id}>{petType.typeName}</option>)
                        }
                    </select>
                </td>
            </tr> 
             <tr>
                <td> <label htmlFor="petBreed" className="form-label">Select Pet Breed</label>   </td>
                 <td>
                    <select  className="form-select" {...register('petBreedId',{required:true})}>
               
                        {pet && (<option value={pet?.petBreed?.id} key={pet?.petBreed?.id} >{pet?.petBreed?.breedName}</option>)}
                        {
                          petBreeds.length>0 && 
                          petBreeds
                                  .filter(petBreed => petBreed.id!==pet?.petBreed?.id)
                                  .map(petBreed => <option value={petBreed.id} key={petBreed.id}>{petBreed.breedName}</option>)
                        }
                    </select>  </td>            
            </tr> 
             <tr>
                <td> <label htmlFor="name" className="form-label">Pet Name</label>   </td>
                <td> <input type="text" className="form-control" id="name" defaultValue={pet && pet.name}
                      {...register('name',{required:true, minLength:3, maxLength:15})}/></td>
            </tr>
            <tr>
                <td> <label htmlFor="price" className="form-label">Pet Price</label>   </td>
                <td> <input type="number" className="form-control" id="price" defaultValue={pet && pet.price} 
                      {...register('price',{required:true, min:10, max:500})}/></td>
            </tr>  
            <tr>
                <td> <label htmlFor="age" className="form-label">Pet Age</label>   </td>
                <td> <input type="number" className="form-control" id="age" defaultValue={pet && pet.age}
                      {...register('age',{required:true, min:1, max:5})}/></td>
            </tr> 
            <tr>
                <td> <label htmlFor="weight" className="form-label">Pet Weight</label>   </td>
                <td> <input type="number" className="form-control" id="weight" defaultValue={pet && pet.weight}
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
      )}
    </>
  )

}

