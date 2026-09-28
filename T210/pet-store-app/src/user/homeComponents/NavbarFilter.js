import React, { useEffect, useState } from 'react'

export default function NavbarFilter(props) 
{
    let filterAndFetchPets = props.onFilterAndFetchPets
    let [petTypes, setPettypes]=useState([])
    let [petName, setPetName] = useState("")
    let [typeName, setTypeName] = useState("")
    let [minAndMaxAge, setMinAndMaxAge]=useState("") //'{"min":1,"max":3}'
    let [sortDirection, setSortDirection] = useState("")

    useEffect(()=>{filterAndFetchPets({petName:petName,typeName:typeName,sortDirection:sortDirection,minAndMaxAge:minAndMaxAge})},[petName,typeName,sortDirection,minAndMaxAge])

    async function fetchAllPetTypes() 
    {
        //let response = await fetch("http://localhost:8080/api/v1/admin/get-pet-types");
        let response = await fetch("http://localhost:8080/api/v1/get/pet-types");
        let responseObject = await response.json();
        let allPettypes = responseObject.data;
        setPettypes(allPettypes);
    }
    useEffect(()=>{fetchAllPetTypes()},[])
  return (
     <div style={{boxShadow:"5px 7px 5px grey"}} className='bg-dark '>
        <div className='container d-flex justify-content-between p-3'>
            <div>
                <select className="form-select" onChange={(event)=>{setTypeName(event.target.value)}}>
                    <option value="">Select Pet Category</option>
                    <option value={""}>All Pets</option>
                    {
                        petTypes.length>0 && petTypes.map(petType => {
                            return  <option value={petType.typeName} key={petType.id}>{petType.typeName}</option>
                        })
                    }
                    
                </select>
            </div> 

            <div>
                <select className="form-select" onChange={(event)=>{setSortDirection(event.target.value)}}>
                    <option value="">Sort By Age</option>
                    <option value="">Reset</option>
                    <option value="asc">Younger First</option>
                    <option value="desc">Older First</option>
                </select>
            </div> 

            <div>
                <select className="form-select" onChange={(event)=>{setMinAndMaxAge(JSON.parse(event.target.value))}}>
                    <option value="null">Pet Age Between</option>
                    <option  value="null">Reset</option>
                    <option value='{"minAge":1,"maxAge":3}'>1Yr to 3Yr</option>
                    <option value='{"minAge":3,"maxAge":6}'>3Yr to 6Yr</option>
                    <option value='{"minAge":6,"maxAge":10}'>6Yr to 10Yr</option>
                </select>
            </div>  

            <div className='nav-item'>
                <input onChange={(event)=>{setPetName(event.target.value)}} className="me-2 rounded-pill ps-3 p-2" type="search" placeholder="Search" />
            </div>
        </div>
          
        </div>
  )
}
