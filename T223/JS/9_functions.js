//function is block of code written to
//execute some task.
//function executes ONLY when we call it
//we can call a function infinite time
//main use : reusability

//function syntax :

//  function  functionName()
//  {
        //function body - logic
//  }

console.log("function example");

function  add() //function defination
 {
     console.log(10+8);   //function logic   
 }

add() //function call
add() //function call

//in above exmple, the output will be same no matter how many times we call add() function

//making function dynamic : by providing parameters
//Parameters : are values required for the function
function div(n1, n2) //n1:24, n2:2 ==> here n1, n2 are parameters
{
    let result = n1/n2
    console.log(result); 
}

div(24,2)//24:n1, 2:n2 ==>here 24 and 2 are called as argumets


//return : hey funtion, perform this task and RETURN a value/output/result
//to send final result outside a funtion, we use return
//returned value goes to the function call
console.log("return keyword");

function multiply(n1, n2)
{
    let result = n1*n2;
    return result;
}

multiply(5,6);
console.log(multiply(7,1));
let output = multiply(8,2); //recommonded
console.log(output);

//function type :
//1. Named function : function that has name
function display()
{
    console.log("display function called"); 
}
display()

//2. anonymous function : function without name
let show = function ()
{
    console.log("show function called"); 
}
show()



//3. arrow function
let x = 20
let print  = () => {
                        console.log("print function called"); 
                   }
print()

