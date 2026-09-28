import React from 'react'
import './imageHover.css'
import { Link } from 'react-router-dom'

export default function DisplayAllPets(props) {
  let pets=props.petsData  
  let fetchAllPets=props.onFetchAllPets
   const user = JSON.parse(localStorage.getItem("user"));
    const token = user?.token;

  async function deletePetById(petId)
   {
    let response = await fetch(`http://localhost:8080/api/v1/admin/delete-pet/${petId}`,{method:"delete", headers: {"Authorization": `Bearer ${token}` }})
    let responseObject=await response.json()
    console.log(responseObject);
    fetchAllPets()
    
   }
    
  return (
    <div className="mt-4 d-flex align-items-center flex-column">
        <h1>Manage Pets</h1>
        <table className="table table-hover table-bordered table-dark w-50 text-center">
          <thead>
            <tr>
              <th scope="col">ID</th>
              <th scope="col">IMAGE</th>
              <th scope="col">NAME</th>
              <th scope="col">AGE</th>
              <th scope="col">WEIGHT</th>
              <th scope="col">PRICE</th>
              <th scope="col">BREED</th>
              <th scope="col" colSpan={2}>
                Action
              </th>
            </tr>
          </thead>
          <tbody>
            {pets &&
              pets.map((pet) => (
                <tr key={pet.id}>
                  <th scope="row">{pet.id}</th>
                  <th scope="row"><img src={`http://localhost:8080/images/${pet.imageName}`} alt="" height={50} width={50} className='img-fluid rounded shadow img-hover-zoom'/></th>
                  <th scope="row" className='text-capitalize'>{pet.name}</th>
                  <th scope="row">{pet.age}</th>
                  <th scope="row">{pet.weight}</th>
                  <th scope="row">&#8377;{pet.price}</th>
                  <th scope="row">{pet.petBreed.breedName}</th>
                  <td>
                    <Link type="button" className="btn btn-warning" to={`/admin/update-pet/${pet.id}`}>
                      Update
                    </Link>
                  </td>
                  <td>
                    <button type="button" className="btn btn-danger" onClick={()=>{deletePetById(pet.id)}}>
                      Delete
                    </button>
                  </td>
                </tr>
              ))}
          </tbody>
        </table>
    </div>
  )
}
