
import React, { useEffect, useState } from 'react'
import ShowAllPets from './ShowAllPets'
import NavbarFilter from '../homeComponents/NavbarFilter'

export default function GetAllPets() {
    let [pets, setPets]=useState([])
    
    async function filterAndFetchPets({petName, typeName,sortDirection,minAndMaxAge})
    {
        let urlParams= new URLSearchParams()
        if(petName) urlParams.append("petName",petName)
        if(typeName) urlParams.append("typeName",typeName)
        if(sortDirection) urlParams.append("sortDirection",sortDirection)
        if(minAndMaxAge) 
        {
          urlParams.append("minAge",minAndMaxAge.minAge)
          urlParams.append("maxAge",minAndMaxAge.maxAge)
        }
      //console.log(`http://localhost:8080/api/v1/admin/filter?${urlParams.toString()}`);
      console.log(`http://localhost:8080/api/v1/filter?${urlParams.toString()}`);
      
            
        //let response = await fetch(`http://localhost:8080/api/v1/admin/filter?${urlParams.toString()}`);
        let response = await fetch(`http://localhost:8080/api/v1/filter?${urlParams.toString()}`);
        let responseObject = await response.json();
        let filteredPets = responseObject.data;
        console.log(filteredPets);
        setPets(filteredPets)
    }
        async function fetchAllPets()
        {
            //let responseObject  = await fetch("http://localhost:8080/api/v1/admin/pets")
            let responseObject  = await fetch("http://localhost:8080/api/v1/get/pets")
            let response=await responseObject.json()
            //console.log(response.data);
            setPets(response.data)
            
        }
        useEffect(()=>{fetchAllPets()},[])
  return (
    <div>
       <NavbarFilter onFilterAndFetchPets={filterAndFetchPets}/>
       <ShowAllPets petsData={pets}/>
    </div>
  )
}
