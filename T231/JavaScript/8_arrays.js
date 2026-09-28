//arrays : collection of values inside []
//ex : let marks = [98,93,94]

//creating array
let a=[] 
console.log(a);

let b=[10,20,30]
console.log(b);

let c=new Array(11,22,33)
console.log(c);

//accessing values in array : using index, and index starts from zero
console.log(c[0]); //11
console.log(c[2]); //33
console.log(c[5]); //undefined

//getting total value in array
console.log(c.length);

//upadting values in array
console.log(c);
c[0]=111;
console.log(c);



//adding values in array
let d = []
d.push(100) //add value at the end of array
d.push(200)
d.push(300)
console.log(d);
d.unshift(400) //add value at the start of array
d.unshift(500)
console.log(d);

//removing values from array
d.pop() //remove value from the end of array
console.log(d);
d.shift() //remove value from the start of array
console.log(d);


//array destructuring : unpacking values inside array into variables.
let marks = [95,92,45,35]
console.log(marks);

let [p, q, r, s] = marks //p=95,q=92, r=45, s=35

let [python, java, , javascript] = marks //skipping value
console.log(python);
console.log(javascript);

//rest : remaining all
let [english, maths, ...restOfMarks] = marks //instead of restOfMarks, you can use x or y or any other variable
console.log(english); //95
console.log(maths); //92
console.log(restOfMarks); //[ 45, 35 ]

//spread : spreading values of one array into another
let ar1 = [10,20,30]
let ar2 = [11,22,33]

let myArray1 = [ar1, ar2]
console.log(myArray1); //[ [ 10, 20, 30 ], [ 11, 22, 33 ] ]

let myArray2 = [...ar1, ar2]
console.log(myArray2); //[ 10, 20, 30, [ 11, 22, 33 ] ]

let myArray3 = [...ar1, ...ar2]
console.log(myArray3);  //[ 10, 20, 30, 11, 22, 33 ]

let myArray4 = [100, 200, ...ar2, 300, ...ar1, 400]
console.log(myArray4);  //[100, 200, 11, 22,  33,300,  10, 20, 30, 400]


//nested array
let nestedArray = [[50,90],[44,11]]
console.log(nestedArray.length);
console.log(nestedArray[0]); //[50,90]
console.log(nestedArray[0][0]);
console.log(nestedArray[1][1]);

//loop on array
let numbers = [9,4,1,7,6,11,22]
//0 - 9
//4 - 6
//0 to 4th index
for(let i=0; i<numbers.length; i++) //0,1,2,3,4
{
    console.log(numbers[i]);
}

for(let number of numbers)
{
    console.log(number);
    
}



//map, filter and reduce
//---------------map----------------------
let salaries = [20000, 45000, 31000]
//show salary after giving 20% increment
//map each salary given in salaries array and increment it by 20%
//with map function, we write arithmatic operation

for(let salary of salaries)
{
    console.log(salary*0.20+salary);   
}

let incrementedSalaries=salaries.map( (salary) => 
    {
        return salary*0.20+salary
    })

console.log(salaries);
console.log(incrementedSalaries);

//---------------filter----------------------
let numberss = [2,5,7,4,8,6,1]
//display even from from given array : filter even number
//with filter we write condition.
let evenNumbers = numberss.filter( (number) => 
    {
        return number%2==0;
    })

console.log(evenNumbers);

//---------------reduce----------------------
let values = [2,5,7]
//reduce data array into a sum of an array
//avg, sum, largest, smallest

//find sum of values array 
let sum=0
for(let value of values)
{
    sum=sum+value;
}
console.log(`sum is ${sum}`);
//finding sum using reduce function
let sumOfArray = values.reduce ((sum,value)=>
    {
        return sum+value
    },0) 

console.log(sumOfArray);
console.log(`avg of array is ${sumOfArray/values.length}`);





