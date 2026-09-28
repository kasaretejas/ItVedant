let values = [2,3,5,6,1]

//display only even numbers from given array values
for(let value of values)
{
    if(value%2==0)
        {
            console.log(value);  
        } 
}


let evenNumbers1 = values.filter(value => value%2==0)
let evenNumbers2 = values.filter((value) =>{ return value%2==0 })
console.log(evenNumbers1);
console.log(evenNumbers2);




//using values array elements, 
//create new array newValues with elements => [4,5,7,8,3]

let newValues=[];
for(let value of values)
{
    newValues.push(value+2)
}
console.log(newValues);

let afterAddingTwo = values.map(value => value+2)
console.log(afterAddingTwo);



//find the sum of all elements inside values array (17)
let sum = 0; //2   5   10   16  17
for(let value of values)
{
    sum = sum+value
    //sum = 0+2 =2
    //sum = 2+3 =5
    //sum = 5+5 =10
    //sum = 10+6=16
    //sum = 16+1=17
}
console.log(sum);

let sumOfValuesArray = values.reduce((n1,n2) => { return n1+n2})
console.log(sumOfValuesArray);











