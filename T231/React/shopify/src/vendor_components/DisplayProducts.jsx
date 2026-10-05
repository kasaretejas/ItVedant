import React, { useContext, useEffect, useState } from 'react'
import { LoggedInUserContext } from '../project_context/LoggedInUserContext';
import { toast } from 'react-toastify';
import { Link } from 'react-router-dom';

export default function DisplayProducts() {
  let [products, setProducts]=useState(null)
  let { userData, setUserData } = useContext(LoggedInUserContext);
  console.log(products);
  
  async function getAllProductsForVendor()
  {
      let response=await fetch(`http://localhost:8080/api/v1/vendor/products/${userData.id}`,
       {
          headers : 
               {
                "Authorization":`Bearer ${userData.jwtToken}`
               }
        })         
        let responseObject=await response.json()
        if(response.ok)
          {
            setProducts(responseObject.data)
          }   
  }

   async function deleteProduct(productId)
  {
      let response=await fetch(`http://localhost:8080/api/v1/vendor/products/${productId}`,
       {
          method:"delete",
          headers : 
               {
                "Authorization":`Bearer ${userData.jwtToken}`
               }
        })         
        let responseObject=await response.json()
        if(response.ok)
          {
            toast.success(responseObject.message)
            getAllProductsForVendor()
          }   
        else
          {
            toast.error(responseObject.message)
          }
  }

  useEffect(()=>{ getAllProductsForVendor() },[])
    
  return (
   <div className='text-center'>
    {
      products && products.length>0 ? 
      <>
        <h1 className='text-center mt-3'>Your Products</h1>
        <table className="table table-bordered table-hover container">
              <thead>
                  <tr>
                    <th scope="col">ID</th>
                    <th scope="col">IMAGE</th>
                    <th scope="col">NAME</th>
                    <th scope="col">PRICE</th>
                    <th scope="col">QUANTITY</th>
                    <th scope="col" colSpan={2}>ACTION</th>
                  </tr>
              </thead>
              <tbody>
                  {
                    products.map(product=>{
                      return <tr key={product.id}>
                                <td>{product.id}</td>
                                <td>
                                  <img src={`http://localhost:8080/api/v1/images/${product.imageName}`} alt="" style={{width:"50px", height:"50px"}} />
                                </td>
                                <td className='text-capitalize'>{product.name}</td>
                                <td>{product.price}</td>
                                <td>{product.quantity}</td>
                                <td>
                                  <Link className='btn btn-warning' to={`/vendor/update-product/${product.id}`}>Update</Link>
                                </td>
                                <td>
                                  <button className='btn btn-danger' onClick={()=>{deleteProduct(product.id)}}>Delete</button>
                                </td>
                              </tr>
                    })
                  }
              </tbody>
        </table>
      </>:<h1>There are no products, please add some!</h1>
    }
        
    </div> 
  )
}
