import React, { useEffect, useState } from 'react'

export default function Cart() {
  let [cartItems, setCartItems]=useState([])
   const user = JSON.parse(localStorage.getItem("user"));
    const token = user?.token;
    const userId = user?.userId;
    async function fetchAllCartItems()
    {
      let response = await fetch(`http://localhost:8080/api/v1/customer/${userId}`,{headers:{"Authorization": `Bearer ${token}`}})
      let responseObject = await response.json()
      let allCartItems = responseObject.data
      console.log(allCartItems)
      setCartItems(allCartItems)
    }

    useEffect(()=>{fetchAllCartItems()},[])

  return (
    <>
      {
      cartItems.length>0? <div className='container mt-3'>
      <h1 className='mb-5'>Your Shopping Cart</h1>
      <div className="row">
        <div className="col-8 border border-2 rounded-3 me-3">
          {
            cartItems.map(cartItem => {
              return <div className="row p-3">
            <div className="col-3">
              <img src={`http://localhost:8080/images/${cartItem.pet.imageName}`} alt="" height={80} width={80} className='img-fluid rounded'/>
            </div>
            <div className="col-5">
              <h4 className='text-capitalize'>{cartItem.pet.name}</h4>
              <p className='text-capitalize'>Breed : {cartItem.pet.petBreed.breedName}</p>
            </div>
            <div className="col-2">
              <div className='input-group'>
                <button className="btn btn-outline-secondary" type="button" id="button-addon1">-</button>
                <input type="text" className="form-control text-center" value={cartItem.quantity}/>
                <button className="btn btn-outline-secondary" type="button" id="button-addon1">+</button>
              </div>
            </div>
            <div className="col-2 text-end">
              <p className='fw-bold'>&#8377;{cartItem.pet.price}</p>
              <button type="button" class="btn btn-sm btn-outline-danger"><i class="bi bi-trash3"></i></button>
            </div>
            <hr className='mt-3'/> 
          </div>
            })
          }
        </div>
        <div className="col border border-2 rounded-3 bg-light-subtle p-3">
          <h4>Order Summary</h4>
          <p class="d-flex justify-content-between mt-4"><span>Subtotal</span><span>$199.97</span></p>
          <p class="d-flex justify-content-between"><span>Shipping</span><span>$199.97</span></p>
          <p class="d-flex justify-content-between"><span>Tax</span><span>$199.97</span></p>
          <hr />
          <p class="d-flex justify-content-between fw-bold"><span>Total</span><span>$199.97</span></p>
          <a className='btn btn-primary text-light w-100'   href="">Proceed To CheckOut</a>
        </div>
        <button type="button" className="btn btn-outline-primary mt-4 w-25"><i class="bi bi-arrow-left"></i> &nbsp; Continue Shopping</button>

      </div>
    </div>:"There Are No Items in Cart"
      }
    </>
    // <div className='container mt-3'>
    //   <h1 className='mb-5'>Your Shopping Cart</h1>
    //   <div className="row  gx-4 gy-3">
    //     <div className="col-8 border border-2 rounded-3 me-3">
    //       <div className="row p-3">
    //         <div className="col-3">
    //           <img src={`https://www.newworldencyclopedia.org/d/images/thumb/3/3a/Cat03.jpg/200px-Cat03.jpg`} alt="" height={80} width={80} className='img-fluid rounded'/>
    //         </div>
    //         <div className="col-5">
    //           <h4>Product 1</h4>
    //           <p>Category : Clothes</p>
    //         </div>
    //         <div className="col-2">
    //           <div className='input-group'>
    //             <button className="btn btn-outline-secondary" type="button" id="button-addon1">-</button>
    //             <input type="text" className="form-control text-center" value={1}/>
    //             <button className="btn btn-outline-secondary" type="button" id="button-addon1">+</button>
    //           </div>
    //         </div>
    //         <div className="col-2 text-end">
    //           <p className='fw-bold'>$99.99</p>
    //           <button type="button" class="btn btn-sm btn-outline-danger"><i class="bi bi-trash3"></i></button>
    //         </div>
    //         <hr className='mt-3'/>
    //       </div>
    //     </div>
    //     <div className="col border border-2 rounded-3 bg-light-subtle p-3">
    //       <h4>Order Summary</h4>
    //       <p class="d-flex justify-content-between mt-4"><span>Subtotal</span><span>$199.97</span></p>
    //       <p class="d-flex justify-content-between"><span>Shipping</span><span>$199.97</span></p>
    //       <p class="d-flex justify-content-between"><span>Tax</span><span>$199.97</span></p>
    //       <hr />
    //       <p class="d-flex justify-content-between fw-bold"><span>Total</span><span>$199.97</span></p>
    //       <a className='btn btn-primary text-light w-100'   href="">Proceed To CheckOut</a>
    //     </div>
    //   </div>
    // </div>

  )
}
