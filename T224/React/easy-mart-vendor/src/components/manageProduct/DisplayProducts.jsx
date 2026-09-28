import React, { useState } from 'react'
import { Link } from 'react-router-dom';

export default function DisplayProducts(props) {
  let products = props.allProducts;
  console.log(products);
  let [selectedProductId, setSelectedProductId]=useState(null)
  
  return (
   <div className='container mt-5'>
        <table className="table table-hover table-bordered">
          <thead>
            <tr className='text-center'>
              <th scope="col">ID</th>
              <th scope="col">IMAGE</th>
              <th scope="col">NAME</th>
              <th scope="col">PRICE</th>
              <th scope="col">QUANTITY</th>
              <th scope="col">BRAND</th>
              <th scope="col">DESCRIPTION</th>
              <th scope="col" colSpan={2}>ACTION</th>
              
              
            </tr>
          </thead>
          <tbody className='table-group-divider'>
            {
              products?products.map(product=>{
                return (
                <tr key={product.id}>
                  <td>{product.id}</td>
                  <td>
                    <img src={`http://localhost:8080/api/v1/images/${product.imageName}`} alt="" style={{height:"40px", width:"40px"}}/>
                  </td>
                  <td className='text-capitalize'>{product.name}</td>
                  <td className='text-capitalize'>{product.price}</td>
                  <td className='text-capitalize'>{product.quantity}</td>
                  <td className='text-capitalize'>{product.brand}</td>
                  <td className='text-capitalize'>{product.description}</td>
                  <td className='text-capitalize text-center'>
                    <Link to={`/update-product/${product.id}`} className='btn btn-primary'>Update</Link>
                  </td>
                  <td className='text-capitalize text-center'>
                    <button className='btn btn-danger' type="button" data-bs-toggle="modal" data-bs-target="#exampleModal" onClick={()=>{setSelectedProductId(product.id)}}>Delete</button>
                  </td>
                </tr>)
              }):"Loading Products..."
            }
          </tbody>
        </table>
        
        {/* modal code  */}
        <div className="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
          <div className="modal-dialog">
            <div className="modal-content">
              <div className="modal-header">
                <h1 className="modal-title fs-5" id="exampleModalLabel">Delete Product?</h1>
                <button type="button" className="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
              </div>
              <div className="modal-body">
                This action will delete product permanantly!
              </div>
              <div className="modal-footer">
                <button type="button" className="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                <button type="button" className="btn btn-danger" data-bs-dismiss="modal" onClick={()=>{props.ondeleteProduct(selectedProductId)}}>Delete</button>
              </div>
            </div>
          </div>
        </div>
    </div>
  )
}
