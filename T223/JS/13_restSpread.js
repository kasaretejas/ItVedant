//rest operator on array
let prices= [99,199,149,499]

//destructure : no of values = no of variables
let [soap, tshirt, pen, pant] = prices

//rest on prices
let[cap, ...restOfPrices1] = prices
console.log(cap);
console.log(restOfPrices1);

let [pencil, mouse, ...restOfPrices2] = prices
console.log(pencil);
console.log(mouse);
console.log(restOfPrices2);

//rest must be last
//let [remote, ...restOfPrices3, phoneCase]=prices


//rest operator on object
let employee = {name:"raj", age:25, salary:95000, city:"thane"}
let {name, city, ...restOfEmployee} = employee
console.log(name);
console.log(restOfEmployee);


//spred operator on array
let arr1 = [10,20]
let arr2 = [55,66]

let arr3 = [arr1, arr2]
console.log(arr3);

let arr4 = [...arr1, ...arr2]
console.log(arr4);

let arr5 = [1,2 , ...arr1, 3, 4,  ...arr2]
console.log(arr5);

let arr6 = [...arr1, 100,200,  ...arr2]
console.log(arr6);


//spred operator on object
let student = {name:"raj", age:25}
let address = {city: "thane", pincode:409098}

let studentDetails1 = {student, address}
console.log(studentDetails1);

let studentDetails2 = {...student, ...address}
console.log(studentDetails2);

let studentDetails3 = {rollNo:21, ...student, ...address}
console.log(studentDetails3);
