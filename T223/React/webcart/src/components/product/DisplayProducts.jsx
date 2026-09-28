import React from 'react'
import { Link } from 'react-router-dom';
import { toast } from 'react-toastify';

export default function DisplayProducts(props) {
    let products = props.productsValue;

   
  return (
    <div className='text-center mt-3 container'>
      {
        products.length==0? <h1>There are no products added, please add some!</h1>:
        <>
            <h1>Manage Your Products</h1>
            <table class="table table-hover table-bordered w-100">
                <thead>
                    <tr>
                    <th scope="col">Id</th>
                    <th scope="col">Image</th>
                    <th scope="col">Name</th>
                    <th scope="col">Brand</th>
                    <th scope="col">Description</th>
                    <th scope="col">Price</th>
                    <th scope="col">Qunatity</th>
                    <th scope="col" colSpan={2}>Action</th>
                    </tr>
                </thead>
                <tbody class="table-group-divider">
                    {
                        products.map((product)=>{
                            return <tr>
                        <td>{product.id}</td>
                        <td>
                            <img src={`http://localhost:8080/images/${product.imageName}`} alt="" style={{height:"50px", width:"50px"}}/>
                        </td>
                        <td>{product.name}</td>
                        <td>{product.brand}</td>
                        <td>{product.description.slice(0,50)}...</td>
                        <td>{product.price}</td>
                        <td>{product.quantity}</td>
                        <td>
                            <button className='btn btn-danger' 
                                onClick={()=>{ props.onDeleteProduct(product.id)}}>
                                Delete
                            </button>
                        </td>
                        <td>
                            <Link className='btn btn-warning' to={`/vendor/update-product/${product.id}`}>Update</Link>
                        </td>
                    </tr>
                        })
                    }
                </tbody>
            </table>
        </> 
      }
    </div>
  )
}
