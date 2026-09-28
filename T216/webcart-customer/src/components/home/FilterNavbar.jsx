import React, { useEffect, useRef, useState } from 'react'
import { useForm } from 'react-hook-form';

export default function FilterNavbar(props) 
{
  let filterProducts = props.onfilterProducts
  let {register,handleSubmit, formState,watch}=useForm()
  let[categories, setCategories]=useState(null)
  //const [selectedCategoryId, setSelectedCategoryId] = useState("");
  const selectedCategoryName = watch("category");
  const [subCategories, setSubCategories] = useState([]);
  let [categoryName, setCategoryName]=useState("")
  let [subCategoryName, setsubCategoryName]=useState("")
  let [productName, setproductName]=useState("")
  let [sortDirection, setsortDirection]=useState("")
  let [minPrice, setMinPrice]=useState("")
  let [maxPrice, setMaxPrice]=useState("")
    //we use debouse to call api after som delay when user enters somethin in input tag, not instantnly
  const debounceRef = useRef(null);

  useEffect(()=>{
    console.log("calling api to fetch filtered products.....");
    filterProducts(categoryName,subCategoryName,productName,sortDirection,minPrice,maxPrice)
    console.log(categoryName,subCategoryName,productName,sortDirection,minPrice,maxPrice);
    
    
  },[categoryName,subCategoryName,productName,sortDirection,minPrice,maxPrice])

    useEffect(()=>
          {
            async function getAllCategories()
            {
                let response=await fetch("http://localhost:8080/api/v1/vendor/categories")
                let responseObject=await response.json()
                console.log(responseObject.data);
                setCategories(responseObject.data)
            }
            getAllCategories()
          },[])

          
useEffect(() => 
    {
        if (!selectedCategoryName) 
            {
            setSubCategories([]);
            return;
            }

        const selectedCategory = categories.find(
            (cat) => cat.name === selectedCategoryName
        );

        setSubCategories(selectedCategory?.subCategories || []);
    }, [selectedCategoryName, categories]);

  return (
    <div>
      <form>
        <div className='d-flex bg-primary p-3 text-center justify-content-evenly'>
            <div className=''>
                <select className={`form-select ${formState.errors.category ? "is-invalid" : ""}`}
                    {...register("category", {required: {value:true, message:"Please select category"}, 
                        onChange:(event)=>
                            {
                                setCategoryName(event.target.value) 
                                setsubCategoryName("")
                            }})} >
                    <option value="">All categories</option>
                        {categories===null?
                        <option>Loading Categories...</option>:
                        categories.map((category)=>{
                        return <option key={category.id} value={category.name}>{category.name}</option>
                        })}
                </select>
            </div>

            <div className=''>
                <select className={`form-select ${formState.errors.subCategory ? "is-invalid" : ""}`}
                    {...register("subCategory", {required: {value:true, message:"Please select sub-category"}, onChange:(event)=>{setsubCategoryName(event.target.value)}})}
                    disabled={!subCategories.length} >

                        <option value="">Select Sub-Category</option>
                            {subCategories
                            .filter((sub) => sub.name) // remove null names
                            .map((sub) => (
                                <option key={sub.id} value={sub.name}>
                                {sub.name}
                                </option>
                            ))}
                </select>
            </div>

            <div className=''>
                <select className={`form-select ${formState.errors.sortDirection ? "is-invalid" : ""}`}
                    {...register("sortDirection",{onChange:(event)=>{setsortDirection(event.target.value)}})} >
                    <option value="">Sort by price</option>
                    <option value="desc">High to Low</option>
                    <option value="asc">Low to High</option>              
                </select>
            </div>

            <div className=''>
                <input type="text" className="form-control" placeholder='Search Product'
                {...register("productName",
                {   
                    onChange:(event)=>
                    {
                        const value = event.target.value;
                        if (debounceRef.current) 
                            {
                                clearTimeout(debounceRef.current);
                            }
                        // Set new timeout (500ms delay)
                        debounceRef.current = setTimeout(() => {
                            setproductName(value)
                        }, 800);
                        // setproductName(event.target.value)
                    }})
                    } />
            </div>

            <div className=''>
                <div class="dropdown">
                    <button type="button" class="btn btn-light dropdown-toggle" data-bs-toggle="dropdown" aria-expanded="false" data-bs-auto-close="outside">
                         Price Range {minPrice+"-"+maxPrice}
                    </button>
                    <div class="dropdown-menu p-4">
                        <div class="mb-3">
                            <input type="number" className="form-control" placeholder='Min Price'
                            {...register("minPrice",{onChange:(event)=>{setMinPrice(event.target.value)}})} />  
                        </div>
                        <div class="mb-3">
                            <input type="number" className="form-control" placeholder='Max Price'
                            {...register("maxPrice",{onChange:(event)=>{setMaxPrice(event.target.value)}})} />  
                        </div>
                    </div>
                </div>
            </div>
        </div>
      </form>
    </div>
  )
}
