//place order -----> Preparing Order ----> Packing Order ---> On the Way

//function that we pass as parameter, called as call back function
//the function that calls callback function is called as higher order function
function placeOrder(orderNumber, callBackFunction)
{
    console.log(`order ${orderNumber} is placed`); 
    callBackFunction(orderNumber, packingOrder)
}

function prepareOrder(orderNumber,callBackFunction )
{
    console.log(`order ${orderNumber} is being prepared`); 
    callBackFunction(orderNumber)
}

function packingOrder(orderNumber)
{
    console.log(`order ${orderNumber} is packed!`); 
}
// placeOrder(889)
// prepareOrder(889)
// packingOrder(889)

placeOrder(889, prepareOrder)