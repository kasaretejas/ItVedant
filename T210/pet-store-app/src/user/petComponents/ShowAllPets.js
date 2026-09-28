import React, { useContext } from 'react'
import './bootstrapCard.css'
import { Navigate, useNavigate } from 'react-router-dom';
import { CartCounterContext } from '../contexts/CartCountContext';

export default function ShowAllPets(props) {
    let pets=props.petsData
    let navigate = useNavigate()

    let {cartCount,setCartCount}=useContext(CartCounterContext)
     const handleAddToCart = async(petId) => 
    {
      // if not logged in OR not customer → redirect to login
      //!user.token || user.role !== "CUSTOMER"
      const user = JSON.parse(localStorage.getItem("user"));
      const token = user?.token;
      const userId = user?.userId;
        if (!user) 
        {
            navigate("/login");
            return;
        }
        else
        {
          let response = await fetch(`http://localhost:8080/api/v1/customer/add-to-cart/${userId}/${petId}`,
            {
              method:'POST',
              headers:{'Content-Type':'application/json',"Authorization": `Bearer ${token}`}
            })
          let responseObject = await response.json();
          console.log(responseObject);
          if(responseObject.data===null)
          {
            console.log("Not added");  
          }
    else
    {
        setCartCount(cartCount+1)
    }
    }

    // else proceed to cart page
    //navigate("/my/cart");
  };

  return (
    <div className="container mt-3">
        <div className="row">
            {pets && pets.map(pet => {
                return <div className="col-3">
                    <div className="card" style={{width:16+"rem"}}>
                        <img src={`http://localhost:8080/images/${pet.imageName}`} className="card-img-top fixed-img" alt="..."/>
                        <div className="card-body">
                            <h5 className="card-title text-capitalize d-flex justify-content-between">
                                <span>{pet.name}</span>
                                <span className='bg-warning p-1 rounded-pill'>&#8377;{pet.price}</span> 
                            </h5>
                            <p className="card-text">Age : {pet.age} Years</p>
                            <p className="card-text">Weight : {pet.weight}Kg</p>
                            <div className='d-flex justify-content-between'>
                                {/* <a href="#" className="btn btn-success">Add to Cart</a> */}
                                <button className="btn btn-success" onClick={()=>{handleAddToCart(pet.id)}}>Add to Cart</button>
                                <a href="#" className="btn btn-primary">View</a>
                            </div>
                        </div>
                        </div>
                    </div>
            })}
        </div>
    </div>
  )
}
