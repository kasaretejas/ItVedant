import React, { useEffect, useState } from 'react'
import DisplayAllPets from './DisplayAllPets'

export default function FetchAllPets() {
    let [pets, setPets]=useState(null)
    async function fetchAllPets()
    {
        let responseObject  = await fetch("http://localhost:8080/api/v1/get/pets")
        let response=await responseObject.json()
        //console.log(response.data);
        setPets(response.data)
        
    }
    useEffect(()=>{fetchAllPets()},[])
  return (
    <div>
      <DisplayAllPets  petsData={pets} onFetchAllPets={fetchAllPets}/>
    </div>
  )
}
