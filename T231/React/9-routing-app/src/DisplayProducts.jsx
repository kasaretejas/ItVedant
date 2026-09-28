import React from 'react'

export default function DisplayProducts(props) 
{
    let products=props.productsValue

  return (
    <div className='container mt-3'>
      <div className="row">
        {
            products==null?"Loading...":
            products.map((product)=>{
                return <div className="col-3 mb-3 ">
                            <div class="card shadow-sm" style={{width:"18rem"}}>
                                <img src={product.image} class="card-img-top ms-auto me-auto" style={{height:"200px",width:"180px"}}/>
                                <div class="card-body">
                                    <h5 class="card-title text-center">{product.title.slice(0,20)}</h5>
                                    <p class="card-text">{product.description.slice(0,120)}</p>
                                    <div className='d-flex justify-content-between'>
                                        <a href="#" class="btn btn-success">Add to Cart</a>
                                        <a href="#" class="btn btn-primary">View More</a>
                                    </div>
                                </div>
                            </div>
                       </div>
            })
        }
      </div>
    </div>
  )
}
