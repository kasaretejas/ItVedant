import React, { useState } from 'react'
import { Link } from 'react-router-dom'

export default function DisplayMyProducts(props) {
    let products=props.productsArray
    let [productId, setProductId]=useState(null)
    
  return (
    <div className='container'>
        <h3 className='text-center'>My Products</h3>
      {/* {
        products.map(product => {
            return <h1>{product.name}</h1>
        })
      } */}

    <table className="table table-hover table-bordered text-center">
        <thead className='table-primary'>
            <tr>
            <th scope="col">ID</th>
            <th scope="col">IMAGE</th>
            <th scope="col">NAME</th>
            <th scope="col">PRICE</th>
            <th scope="col">CATEGORY</th>
            <th scope="col">IN-STOCK</th>
            <th scope="col" colSpan={2}>ACTION</th>
            </tr>
        </thead>
        <tbody>
            {
                products.map(product => {
                    return (
                        <tr>
                            <th scope="row">{product.id}</th>
                            <td>
                                <img src={`http://localhost:8080/api/v1/images/${product.imageName}`} 
                                style={{height:"50px", width:"50px"}} className='rounded'/>
                            </td>
                            <td className='text-capitalize'>{product.name}</td>
                            <td>&#8377; {product.price}/Kg</td>
                            <td className='text-capitalize'>{product.subCategory.name}</td>
                            <td>{product.inStock?"YES":"NO"}</td>
                            <td>
                                <Link className='btn btn-warning' to={`/vendor/update-product/${product.id}`}>Update</Link>
                            </td>
                            <td>
                                {/* <Link className='btn btn-danger'>Delete</Link> */}
                                <button type="button" className="btn btn-danger" data-bs-toggle="modal" data-bs-target="#staticBackdrop" onClick={()=>{setProductId(product.id)}}>Delete</button>

                                 {/* modal code  */}
                                <div className="modal fade" id="staticBackdrop" data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1" aria-labelledby="staticBackdropLabel" aria-hidden="true">
                                    <div className="modal-dialog">
                                        <div className="modal-content">
                                        <div className="modal-header">
                                            <h1 className="modal-title fs-5" id="staticBackdropLabel">Do You Really Want to Delete?</h1>
                                            <button type="button" className="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                                        </div>
                                        <div className="modal-footer">
                                            <button type="button" className="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                                            <button type="button" className="btn btn-danger" onClick={()=>{props.deleteProductFunction(productId)}} data-bs-dismiss="modal">Delete</button>
                                        </div>
                                        </div>
                                    </div>
                                </div>
                            </td>
                        </tr>
                    )
                })
            }
            
        </tbody>
    </table>
   
    </div>
  )
}
