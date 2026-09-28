  import React, { useEffect, useState } from 'react'
  import { useForm } from 'react-hook-form'

  export default function AddPetBreed() {
  let { register, handleSubmit, formState } = useForm();
  let [pets, setPets] = useState(null);       // list of pet types
  let [breeds, setBreeds] = useState(null);   // list of breeds
  let [isPetBreedAdded, setIsPetBreedAdded] = useState(false);

  const user = JSON.parse(localStorage.getItem("user"));
  const token = user?.token;

  let submitForm = async (formData) => {
    console.log(token);
    
    console.log(formData);
    // formData = {petTypeId: '1', breedName: 'persian'}

    let response = await fetch(
      `http://localhost:8080/api/v1/admin/add-pet-breed/${formData.petTypeId}`,
      {
        method: "POST",
        headers: { "Content-Type": "application/json","Authorization": `Bearer ${token}` },
        body: JSON.stringify(formData),
      }
    );
    let responseObject = await response.json();
    console.log(responseObject);
    setIsPetBreedAdded(true); 
  };

  async function fetchAllPetBreeds() {
    setIsPetBreedAdded(false);
    let response = await fetch("http://localhost:8080/api/v1/get/pet-breeds");
    let responseObject = await response.json();
    let allBreeds = responseObject.data;
    setBreeds(allBreeds);
  }

  async function fetchAllPetTypes() {
    let response = await fetch(
      "http://localhost:8080/api/v1/get/pet-types"
    );
    let responseObject = await response.json();
    let allPettypes = responseObject.data;
    setPets(allPettypes);
  }

  async function filterBreedByPetType(event) {
    let petTypeId = event.target.value;
    if (petTypeId == 0) {
      fetchAllPetBreeds();
    } else {
      let response = await fetch(
        `http://localhost:8080/api/v1/admin/findBreedByPetTypeId/${petTypeId}`,
        {
           headers:{"Authorization": `Bearer ${token}`}
        }
      );
      let responseObject = await response.json();
      let filteredBreeds = responseObject.data;
      setBreeds(filteredBreeds);
    }
  }

  useEffect(()=>{fetchAllPetTypes()},[])
  useEffect(() => {
    // fetchAllPetTypes();
    fetchAllPetBreeds();
  }, [isPetBreedAdded]);

  return (
    <div>
      <h3 className="text-center mt-3">Add Pet Breed</h3>
      <form
        className="d-flex justify-content-center mt-3 border-bottom border-primary border-3 rounded"
        onSubmit={handleSubmit(submitForm)}
      >
        <div className="mb-3 me-3">
          <select
            className="form-select"
            {...register("petTypeId", { required: true })}
          >
            <option value={""}>Select Pet Type &nbsp;</option>
            {pets &&
              pets.map((pet) => (
                <option value={pet.id} key={pet.id}>
                  {pet.typeName}
                </option>
              ))}
          </select>
          <div className="text-danger">
            {formState.errors.petTypeId?.type === "required" &&
              "Pet Type is Required"}
          </div>
        </div>
        <div className="mb-3 me-3">
          <input
            type="text"
            className="form-control"
            placeholder="Enter Pet Breed here"
            {...register("breedName", {
              required: true,
              minLength: 3,
              maxLength: 10,
            })}
          />
          <div className="text-danger">
            {formState.errors.breedName?.type === "required" &&
              "Pet Breed is Required"}
            {formState.errors.breedName?.type === "minLength" &&
              "Pet Breed must have min 3 characters"}
            {formState.errors.breedName?.type === "maxLength" &&
              "Pet Breed is not allowed more than 10 characters"}
          </div>
        </div>
        <div>
          <button type="submit" className="btn btn-primary">
            Submit
          </button>
        </div>
      </form>

      <div className="mt-4 d-flex align-items-center flex-column ">
        <div className="mb-3 d-flex justify-content-end w-50">
          <h4>Select pet Type:</h4> &nbsp; &nbsp;
          <select
            className="form-select w-25"
            onChange={filterBreedByPetType}
          >
            <option value={0}>All &nbsp;</option>
            {pets &&
              pets.map((pet) => (
                <option value={pet.id} key={pet.id}>
                  {pet.typeName}
                </option>
              ))}
          </select>
        </div>

        <table className="table table-hover table-bordered table-dark w-50 text-center">
          <thead>
            <tr>
              <th scope="col">ID</th>
              <th scope="col">BREED</th>
              <th scope="col" colSpan={2}>
                Action
              </th>
            </tr>
          </thead>
          <tbody>
            {breeds &&
              breeds.map((breed) => (
                <tr key={breed.id}>
                  <th scope="row">{breed.id}</th>
                  <td>{breed.breedName.toLowerCase()}</td>
                  <td>
                    <button type="button" className="btn btn-warning">
                      Update
                    </button>
                  </td>
                  <td>
                    <button type="button" className="btn btn-danger">
                      Delete
                    </button>
                  </td>
                </tr>
              ))}
          </tbody>
        </table>
      </div>
    </div>
  );
}
