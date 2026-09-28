import React, { useState } from 'react'
import { Link } from 'react-router-dom';
import { toast } from 'react-toastify';

export default function DisplayProducts(props) 
{
    let products = props.productsArray;
    let [deleteId, setDeleteId]=useState(null)
    async function deleteProduct()
    {
        props.setIsProductDeletedFunction(false)
        console.log(deleteId);
        
        let responseObject=await fetch(`http://localhost:8080/api/v1/vendor/products/1/${deleteId}`, {method:"DELETE"})
        let responseData=await responseObject.json()
        console.log(responseData.data);
        if(responseData.data===false)
        {
            toast.error(responseData.message)
        }
        else if(responseData.data===true)
        {
            toast.success(responseData.message)
            props.setIsProductDeletedFunction(true)
        }      
    }
    
  return (
    <div className='container mt-3'>
        <h1 className='text-center'>Manage Products</h1>

        {/* code for showing table  */}
        <div className='table-responsive border rounded-5 overflow-hidden p-3 mt-3'>
            <table className="table table-hover table-borderless mb-0 text-center">
                <thead>
                    <tr  >
                    <th scope="col">ID</th>
                    <th scope="col">IMAGE</th>
                    <th scope="col">PRODUCT NAME</th>
                    <th scope="col">BRAND</th>
                    <th scope="col">PRICE</th>
                    <th scope="col">QUANTITY</th>
                    <th scope="col" colSpan={3}>ACTION</th>
                    </tr>
                </thead>
                <tbody className="table-group-divider">
                    {products.map((product)=>{
                    return(
                        <tr key={product.id} >
                        <th scope="row">{product.id}</th>
                        <td> <img src={`http://localhost:8080/images/${product.imageName}`} alt="" style={{height:"50px",width:"50px"}}/> </td>
                        <td>{product.name}</td>
                        <td>{product.brand}</td>
                        <td>{product.price}</td>
                        <td>{product.quantity}</td>
                        <td><Link className='btn btn-primary' to={`/vendor/view-product/${product.id}`}>View</Link></td>
                        <td><Link className='btn btn-warning' to={`/vendor/update-product/${product.id}`}>Update</Link></td>
                        <td><button className='btn btn-danger' type="button" data-bs-toggle="modal" data-bs-target="#staticBackdrop" onClick={()=>{setDeleteId(product.id)}}>Delete</button></td>
                        </tr>
                    )
                    })}
                </tbody>
            </table>
        </div>
        
        {/* modal code  */}
        <div class="modal fade" id="staticBackdrop" data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1" aria-labelledby="staticBackdropLabel" aria-hidden="true">
            <div class="modal-dialog">
                <div class="modal-content">
                <div class="modal-header">
                    <h1 class="modal-title fs-5" id="staticBackdropLabel">Do You really want to delete?</h1>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="modal-body">
                    This action will delete product data permanantly!
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cancle</button>
                    <button type="button" class="btn btn-danger" data-bs-dismiss="modal" onClick={()=>{deleteProduct()}}>Delete</button>
                </div>
                </div>
            </div>
        </div>
        
      
    </div>
  )
}
