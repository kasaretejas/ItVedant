//there is block of code/group of code required repeatedly, so we write that code 
//inside {} bracket and we call it whenenver required, called as functions

//function is a block of code which executed only when we call it!

//syntax 
//          function funcionName() ---> function defination
//              {
                    //function body
//              }
//          funcionName()  ----------> function call

console.log("---Welcome to function ---");

function display()
{
    console.log("display function called"); 
}
display()
display()
display()

//why there is () after function name or after function all
//solution --> () are there to pass data /required data 

function add(n1, n2) //---> add() function required n1 and n2 --------> parameters
{
    let result = n1+n2;
    console.log(`addition is ${result}`);  
}
add(10,3) //---> 10 and 3 are data passed to the add() function ------> arguments
add(56,3)
//console.log(result); //ReferenceError: result is not defined

//in above code, we cant access result outside a function. still i want to access result outside a function
//solution : use return
function sub(x,y)
{
    let result = x-y;
    return result; //when we use return, the value goes to the function call
}
sub(45,3)

console.log(sub(10,2));
console.log(sub(10,2));
console.log(sub(10,2));

let output = sub(6,1);
console.log(output);
console.log(output);
console.log(output);

//anonymous function : function without name
let div = function (a,b) 
{
    console.log(`division is ${a/b}`);
}

div(12,4)

//arraow function
let multi = (n1, n2) => 
    {
        console.log(`multiplication is ${n1*n2}`);
    }
multi(4,8)

//call back function : function that pass as argument
function placeOrder(orderNumber, callBackFunction)
{
    console.log(`order ${orderNumber} is placed`); 
    callBackFunction(orderNumber) //prepareOrder(1122)
}
//placeOrder(1122)

function prepareOrder(orderNumber)
{
    console.log(`order ${orderNumber} is prepared`); 
}
//prepareOrder(1122)
placeOrder(1122, prepareOrder)

//in above example we are passing prepareOrder as an argument ---> call back function
//and placeOrder is a function who is responsible to call  "call back function" ---> higher order function



