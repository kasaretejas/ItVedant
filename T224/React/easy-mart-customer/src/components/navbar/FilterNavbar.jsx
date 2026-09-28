import React, { useEffect, useState } from 'react'
import { useForm } from 'react-hook-form';

export default function FilterNavbar(props) {
  
  let filterProducts=props.onFilterProducts
let {register,handleSubmit, formState,watch}=useForm()
let[categories, setCategories]=useState(null)
const selectedCategoryId = watch("category");
const [subCategories, setSubCategories] = useState([]);

let [categoryName, setCategoryName]=useState("")
let [subCategoryName, setSubCategoryName]=useState("")
let [sortDirection, setSortDirection] = useState("")
let [productName, setProductName] = useState("")


useEffect(()=>
  {
    async function fetchAllCategories()
    {
      let response = await fetch("http://localhost:8080/api/v1/get/categories");
      let responseObject = await response.json();
      setCategories(responseObject.data);
    }
    fetchAllCategories();
  },[]);


useEffect(()=>
  {
      filterProducts(categoryName,subCategoryName, sortDirection, productName)
  },[categoryName,subCategoryName,sortDirection, productName])

  useEffect(()=>{
    if(!selectedCategoryId) 
    {
      setSubCategories([])
      return
    }
    let selectedCategory=categories.find((category)=>
      {
        return category.id===Number(selectedCategoryId)
      })
    setSubCategories(selectedCategory?.subCategories)
  },[selectedCategoryId])


  return (
    <div className='d-flex justify-content-between container'>
      <div>
        <select className={`form-select ${formState.errors.category ? "is-invalid" : ""}`}
                {...register("category", {onChange:(event)=>{
                  // console.log(event.target.options[event.target.selectedIndex].text);
                  setCategoryName(event.target.options[event.target.selectedIndex].text)
                  //setCategoryName(event.target.value)
                  setSubCategoryName("")
                }})}>
                    <option value="">Select Category</option>
                    <option value="">All</option>
                        {categories===null?
                          <option>Loading Categories...</option>:
                          categories.map((category)=>{
                          return <option key={category.id} value={category.id}>{category.name}</option>
                        })}
        </select>
      </div>

      <div>
        <select className={`form-select ${formState.errors.subCategory ? "is-invalid" : ""}`}
                      {...register("subCategory", {onChange:(event)=>{
                  // console.log(event.target.options[event.target.selectedIndex].text);
                  setSubCategoryName(event.target.options[event.target.selectedIndex].text)
                  //setCategoryName(event.target.value)
                }})}
                    disabled={!subCategories.length}>
                  <option value="">Select Sub-Category</option>
                  <option value="">All</option>
                      {subCategories
                              .filter((sub) => sub.name) // remove null names
                              .map((sub) => (
                                <option key={sub.id} value={sub.id}>
                                  {sub.name}
                                </option>
                              ))}
        </select>
      </div>
      <div>
        <select className={`form-select ${formState.errors.subCategory ? "is-invalid" : ""}`}
                      {...register("sortDirection", {onChange:(event)=>{
                  // console.log(event.target.options[event.target.selectedIndex].text);
                  //setSortDirection(event.target.options[event.target.selectedIndex].text)
                  setSortDirection(event.target.value)
                }})}>
                  <option value="">Sort By Price</option>
                  <option value="All">Reset</option>
                  <option value="desc">High to Low</option>
                  <option value="asc">Low to High</option>
        </select>
      </div>
      <div>
        <input type="text" class="form-control" id="exampleInputEmail1" placeholder='Type Product Name'
        {...register("productName", {onChange:(event)=>{
                  // console.log(event.target.options[event.target.selectedIndex].text);
                  //setSortDirection(event.target.options[event.target.selectedIndex].text)
                  setProductName(event.target.value)
                }})}></input>
      </div>
    </div>
  )
}
