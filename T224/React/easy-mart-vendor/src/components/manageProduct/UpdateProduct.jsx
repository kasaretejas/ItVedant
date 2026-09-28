import React, { useEffect, useState } from 'react'
import { useForm } from 'react-hook-form';
import { useNavigate, useParams } from 'react-router-dom';
import { toast } from 'react-toastify';

export default function UpdateProduct() {
    let {register,handleSubmit, formState,watch,setValue}=useForm()
  let[categories, setCategories]=useState(null)
  //const [selectedCategoryId, setSelectedCategoryId] = useState("");

  const [subCategories, setSubCategories] = useState([]);
  let loggedInVendor=JSON.parse(localStorage.getItem("user"))
  let navigateTo=useNavigate()
  //console.log(loggedInVendor);
  let URLParams=useParams()
  let [product, setProduct]=useState(null)
   let selectedCategoryId;
  if(product!=null)
  {
    selectedCategoryId = watch("category", product.subCategory.category.id);
  }
    
  
  console.log(product);
  
  
useEffect(()=>{
   async function fetchProduct()
    {
      let response=await fetch(`http://localhost:8080/api/v1/vendor/${loggedInVendor.id}/products/${URLParams.id}`,
        {
          headers:{Authorization: `Bearer ${loggedInVendor.token}`}
        }
      )
      let responseObject=await response.json()
      setValue("subCategory", responseObject.data.subCategory.id);
      setProduct(responseObject.data)
    }
    fetchProduct()
},[])

  useEffect(()=>{
    async function fetchAllCategories()
    {
      let response=await fetch("http://localhost:8080/api/v1/get/categories")
      let responseObject=await response.json()
      setCategories(responseObject.data)
    }
    fetchAllCategories()
  },[])

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

  async function collectFormData(formData)
  {
    console.log(formData);
    let formDataObject=new FormData()
    formDataObject.append("productObject", JSON.stringify(
      {
        name:formData.name,
        price:formData.price,
        quantity:formData.quantity,
        description:formData.description,
        brand:formData.brand,
        subCategory:{id:formData.subCategory}, //{id:1} --> here 1 is subcategory id
        vendor:{id:loggedInVendor.id}
      }
    ))

    formDataObject.append("productImage",formData.imageName[0])

    let response=await fetch(`http://localhost:8080/api/v1/vendor/${loggedInVendor.id}/products/${URLParams.id}`,
      {
        method:"put",
        body:formDataObject,
        headers:{Authorization: `Bearer ${loggedInVendor.token}`}
      }
    )
    let responseObject=await response.json()
    if(response.ok)
    {
      toast.success(responseObject.message)
      navigateTo("/", {replace:true})

    }
    else
    {
      toast.error("Product adding failed!")
    }
    
    
  }
  return (
    <div className="container mt-2" style={{ maxWidth: 500 }} >
      <h1 className='text-center'>Update Product</h1>
      {
        product==null?"Loading....":<form onSubmit={handleSubmit(collectFormData)} noValidate className='mt-3 needs-validation' >
       
        {/* select category and sub category  */}
        <div className='row'>
              {/* category select  */}
              <div className="mb-2 col-6">
                <label className="form-label">Select category</label>
                <select className={`form-select ${formState.errors.category ? "is-invalid" : ""}`}
                {...register("category", {required: {value:true, message:"Please select category"}})}>
                    {/* <option value={product.subCategory.category.id}>{product.subCategory.category.name}</option> */}
                    {/* <option value="">Select Category</option> */}
                        {categories===null?
                          <option>Loading Categories...</option>:
                          categories.map((category)=>{
                          return <option selected={category.name==product.subCategory.category.name?true:false} key={category.id} value={category.id}>{category.name}</option>
                        })}
                </select>
              {/* Reserved error space */}
                <div style={{ minHeight: "20px" }}>
                  {formState.errors.category && (
                    <div className="invalid-feedback d-block">
                      {formState.errors.category.message}
                    </div>
                  )}
                </div>
              </div>

              {/* sub category select  */}
              <div className="mb-2 col-6">
                  <label className="form-label">Select sub-category</label>
                  <select className={`form-select ${formState.errors.subCategory ? "is-invalid" : ""}`}
                      {...register("subCategory", {required: {value:true, message:"Please select sub-category"}})}
                    disabled={!subCategories.length}>
                  {/* <option value="">Select Sub-Category</option> */}
                      {subCategories
                              .filter((sub) => sub.name) // remove null names
                              .map((sub) => (
                                 <option key={sub.id} value={sub.id} selected={sub.name==product.subCategory.name?true:false}  >
                                  {/* selected={sub.name==product.subCategory.name?true:false} */}
                                  {sub.name}
                                </option>
                              ))}
                  </select>
                {/* Reserved error space */}
                  <div style={{ minHeight: "20px" }}>
                    {formState.errors.subCategory && (
                      <div className="invalid-feedback d-block">
                        {formState.errors.subCategory.message}
                      </div>
                    )}
                  </div>
              </div>
        </div>

        {/* input price and quantity  */}
        <div className='row'>
              {/* product price  */}
              <div className="mb-2 col-6">
                      <label className="form-label">Product Price:</label>
                      <input type="number" className={`form-control ${formState.errors.price ? "is-invalid" : ""}`}
                        {...register("price", {required: {value:true, message:"Product price required"},
                                               min:{value:100,message:"min product value should be 100"}})}
                        defaultValue={product.price}
                      />
                      <div style={{ minHeight: "20px" }}>
                        {formState.errors.price && (
                          <div className="invalid-feedback d-block">
                            {formState.errors.price.message}
                          </div>
                        )}
                      </div>
              </div>
              
              {/* product quantity  */}
              <div className="mb-2 col-6">
                    <label className="form-label">Product quantity:</label>
                    <input type="number" className={`form-control ${formState.errors.quantity ? "is-invalid" : ""}`}
                      {...register("quantity", {required: {value:true, message:"Product quantity required"}})}
                      defaultValue={product.quantity}
                    />
                    <div style={{ minHeight: "20px" }}>
                      {formState.errors.quantity && (
                        <div className="invalid-feedback d-block">
                          {formState.errors.quantity.message}
                        </div>
                      )}
                    </div>
              </div>
        </div>


        {/* input brand and select image  */}
        <div className='row'>
             {/* product brand  */}
            <div className="mb-2 col-6">
                  <label className="form-label">Product brand:</label>
                  <input type="text" className={`form-control ${formState.errors.brand ? "is-invalid" : ""}`}
                    {...register("brand", {required: {value:true, message:"Product brand required"}})}
                  defaultValue={product.brand}
                  />
                  <div style={{ minHeight: "20px" }}>
                    {formState.errors.brand && (
                      <div className="invalid-feedback d-block">
                        {formState.errors.brand.message}
                      </div>
                    )}
                  </div>
            </div>

            {/* product image  */}
            <div className="mb-2 col-6">
                <label className="form-label">Product image:</label>
                <input type="file" className={`form-control ${formState.errors.imageName ? "is-invalid" : ""}`}
                  {...register("imageName", {required: {value:true, message:"Product image required"}})}
                />
                <div style={{ minHeight: "20px" }}>
                  {formState.errors.imageName && (
                    <div className="invalid-feedback d-block">
                      {formState.errors.imageName.message}
                    </div>
                  )}
                </div>
            </div>
        </div>



        {/* product name  */}
        <div className="mb-2">
          <label className="form-label">Product Name:</label>
          <input type="text" className={`form-control ${formState.errors.name ? "is-invalid" : ""}`}
            {...register("name", {required: {value:true, message:"Product Name required"}})}
            defaultValue={product.name}
          />
          <div style={{ minHeight: "20px" }}>
            {formState.errors.name && (
              <div className="invalid-feedback d-block">
                {formState.errors.name.message}
              </div>
            )}
          </div>
        </div>

        {/* product description  */}
        <div className="mb-2">
          <label className="form-label">Product description:</label>
          <input type="text" className={`form-control ${formState.errors.description ? "is-invalid" : ""}`}
            {...register("description", {required: {value:true, message:"Product description required"}})}
            defaultValue={product.description}
          />
          <div style={{ minHeight: "20px" }}>
            {formState.errors.description && (
              <div className="invalid-feedback d-block">
                {formState.errors.description.message}
              </div>
            )}
          </div>
        </div>

        <button className="btn btn-primary w-100">Submit </button>
      </form>
      }
    </div>

  )
}
