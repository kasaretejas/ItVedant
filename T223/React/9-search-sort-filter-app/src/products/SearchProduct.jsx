import React from 'react'
import { useForm } from 'react-hook-form';

export default function SearchProduct(props) {
    let {register, handleSubmit, formState}=useForm()
    function collectFormData(data)
    {
        console.log(data);
        props.searchProductsByNameFunction(data.productName)
        
    }
  return (
    <div>
      <form onSubmit={handleSubmit(collectFormData)}>
        <div className="mb-3 d-flex">
            <input type="text" className="form-control" placeholder='Enter Product Name'
            {...register("productName", {required:true,message:"username is required"})}/>
            {formState.errors?.productName?alert("product name is required"):""}
            <input type="submit" className="btn btn-primary ms-2"/>
        </div>
        </form>
    </div>
  )
}
