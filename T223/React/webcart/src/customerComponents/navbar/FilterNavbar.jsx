import React, { useEffect, useState } from 'react'
import { useForm } from 'react-hook-form';

export default function FilterNavbar(props) {  
  let filterProducts = props.onfilterProducts
  let {register,handleSubmit, formState,watch}=useForm()
  let[categories, setCategories]=useState(null)
  const selectedCategoryId = watch("category");
  const [subCategories, setSubCategories] = useState([]);

  let [categoryName, setCategoryName]=useState("")
  let [subCategoryName, setSubCategoryName]=useState("")
  let [sortDirection, setSortDirection]=useState("")
  let [productName, setProductName]=useState("")


  useEffect(()=>
    {

        const timer = setTimeout(() => {

            filterProducts(categoryName, subCategoryName,sortDirection, productName)

        }, 500) // waits 500ms after typing stops

        return () => clearTimeout(timer)


        //filterProducts(categoryName, subCategoryName,sortDirection, productName)
    },[categoryName, subCategoryName,sortDirection,productName])

  
    useEffect(()=>
            {
              async function getAllCategories()
              {
                  //let response=await fetch("http://localhost:8080/api/v1/vendor/categories")
                  let response=await fetch("http://localhost:8080/api/v1/get/categories")
                  let responseObject=await response.json()
                  console.log(responseObject.data);
                  setCategories(responseObject.data)
              }
              getAllCategories()
            },[])
  
  
    useEffect(() => {
    if (!selectedCategoryId) {
      setSubCategories([]);
      return;
    }
  
  
    const selectedCategory = categories.find(
      (cat) => cat.id === Number(selectedCategoryId)
    );
  
  
    setSubCategories(selectedCategory?.subCategories || []);
  }, [selectedCategoryId, categories]);


  return (
    <div  className="">
       <form  noValidate className='mt-3' >
       
        {/* select category and sub category  */}
        <div className='row'>
            {/* category select  */}
            <div className="mb-2 col-3">
            <select className={`form-select ${formState.errors.category ? "is-invalid" : ""}`}
              {...register("category",{onChange:(event)=>
                {
                    setCategoryName(event.target.options[event.target.selectedIndex].text)
                    setSubCategoryName("")
                }})}
              >
                  <option value={""}>Select Category</option>
                  <option value="all">All</option>
                      {categories===null?
                        <option>Loading Categories...</option>:
                        categories.map((category)=>{
                        return <option key={category.id} value={category.id}>{category.name}</option>
                      })}
              </select>
            </div>

            {/* sub category select  */}
            <div className="mb-2 col-3">
                
                <select className={`form-select ${formState.errors.subCategory ? "is-invalid" : ""}`}
                  {...register("subCategory", {onChange:(event)=>
                {
                    setSubCategoryName(event.target.options[event.target.selectedIndex].text)
                }})}>


                      <option value="">Select Sub-Category</option>
                      <option value="all">All</option>
                          {subCategories
                          .filter((sub) => sub.name) // remove null names
                          .map((sub) => (
                            <option key={sub.id} value={sub.id}>
                              {sub.name}
                            </option>
                          ))}
                </select>
         
            </div>


            <div className="mb-2 col-3">
            <select className={`form-select ${formState.errors.category ? "is-invalid" : ""}`}
              {...register("sortby",{onChange:(event)=>
                {
                    setSortDirection(event.target.value)
                }})}
              >
                  <option value="All">Sort By Price</option>
                  <option value="All">Clear</option>
                  <option value="desc">High to Low</option>
                  <option value="asc">Low to High</option>
                  
                  
              </select>
            </div>

            <div className="mb-2 col-3">
                <input type='text' placeholder='Product Name' className='form-control'
                {...register("productName", {onChange: (event)=>{ setProductName(event.target.value)}}   )}/>
            </div>
        </div>
      </form>
    </div>
  )
}
