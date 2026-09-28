    import React, { useEffect, useState } from "react";
    import { useForm } from "react-hook-form";
    import { Link, replace, useNavigate } from "react-router-dom";
    import { toast } from "react-toastify";

    export default function AddProduct() {
    const { register, handleSubmit, formState, watch } = useForm();
    const selectedCategoryId = watch("category");
    let navigateTo = useNavigate();
    let loggedInUser = JSON.parse(localStorage.getItem("user"));

    async function collectFormData(formData) 
    {
        console.log(formData);
        let formDataObject=new FormData()
        formDataObject.append("productObject", JSON.stringify(
            {
                name:formData.name,
                price:formData.price,
                inStock:formData.inStock,
                subCategory:{id:Number(formData.subCategory)},
                vendor:{id:loggedInUser.id}
            }
        ))
    
        formDataObject.append("productImage",formData.productImage[0])

        let response=await fetch("http://localhost:8080/api/v1/vendor/products",
                    {
                        method:"post",
                        headers:{Authorization:`Bearer ${loggedInUser.jwtToken}`},
                        body:formDataObject
                    })
        let responseObject=await response.json()
        console.log(responseObject);
        if(response.ok)
        {
            toast.success(responseObject.message)
            navigateTo("/vendor")
        }
        else
        {
            toast.error("Cant add Product!")
        }
        
    }

    let [categories, setCategories] = useState(null);
    console.log(categories);
    async function fetchCategories() {
        let response = await fetch("http://localhost:8080/api/v1/get/categories");
        let responseObject = await response.json();
        setCategories(responseObject.data);
    }

    useEffect(() => {
        fetchCategories();
    }, []);
    return (
        <div>
        <h3 className="text-center">Add Product Here</h3>
        <form
            className="w-25 ms-auto me-auto"
            onSubmit={handleSubmit(collectFormData)}
        >
            {/* product name  */}
            <div className="mb-4">
            <input
                type="text"
                className="form-control"
                id="name"
                placeholder="Product Name"
                {...register("name", {
                required: { value: true, message: "Product name is required" },
                minLength: { value: 3, message: "min 3 characters required" },
                maxLength: { value: 15, message: "max 15 characters allowed" },
                })}
            />
            <div className="text-danger">{formState.errors?.name?.message}</div>
            </div>

            {/* category selection  */}
            <div className="mb-4">
            <select
                className="form-select"
                {...register("category", {
                required: { value: true, message: "category is required" },
                })}
            >
                <option value="">Select Category</option>
                {
                // categories?"yes":"Loading categories"
                categories
                    ? categories.map((category) => {
                        return (
                        <option value={category.id} key={category.id}>
                            {category.name}
                        </option>
                        );
                    })
                    : "Loading categories"
                }
            </select>
            <div className="text-danger">
                {formState.errors?.category?.message}
            </div>
            </div>

                {/* sub category selection  */}
            <div className="mb-4">
            <select
                className="form-select"
                {...register("subCategory", {
                required: { value: true, message: "subCategory is required" },
                })}
            >
                <option value="">Select Sub Category</option>

                {categories
                ?.find((category) => category.id == selectedCategoryId)
                ?.subCategories?.map((subcategory) => (
                    <option value={subcategory.id} key={subcategory.id}>
                    {subcategory.name}
                    </option>
                ))}
            </select>
            <div className="text-danger">
                {formState.errors?.subCategory?.message}
            </div>
            </div>

                {/* product price  */}
            <div className="mb-4">
            <input
                type="number"
                className="form-control"
                id="price"
                placeholder="Product price/kg"
                {...register("price", {
                required: { value: true, message: "Product price is required" },
                min: { value: 100, message: "min 100/kg required" },
                max: { value: 1000, message: "max 1000/kg allowed" },
                })}
            />
            <div className="text-danger">{formState.errors?.price?.message}</div>
            </div>

            <div className="mb-4">
                <input className="form-control" type="file" id="formFile"
                {...register("productImage", {
                required: { value: true, message: "product Image is required" }
                })}/>
                <div className="text-danger">{formState.errors?.productImage?.message}</div>
            </div>

            <div className="d-flex justify-content-between mb-3">
                <p className="">This Product is avaiable</p>
                <div className="form-check form-switch">
                    <input className="form-check-input" type="checkbox" role="switch" id="switchCheckChecked" defaultChecked
                    {...register("inStock")}/> 
                </div>
            </div>


            <div >
                <button type="submit" className="btn btn-primary w-100">Submit</button>
            </div> 
        </form>
        </div>
    );
    }
