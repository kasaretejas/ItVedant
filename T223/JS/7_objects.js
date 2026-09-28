//to store data in key value pair
//key can not be duplicate
//not fixed in size

//1. creating object
let employee = {"name":"raj", "age":30}
console.log(employee);

//2. adding key values in object
employee.salary = 25000;
console.log(employee);
employee.name = "amit"; //if key aleady exists, then value will be override
console.log(employee);

//3. accessing objects value
console.log(employee.name);
console.log(employee.address);
console.log(Object.keys(employee));
console.log(Object.values(employee));


//advanced object
console.log("---advanced object---");
let student = {
    "name":"sumit",
    "age":28,
    "married":false,
    "subjects":["HTML","CSS","JS","REACT"],
    "address":{"city":"thane","pincode":400302}
}

console.log(student.name);
console.log(student.age);
console.log(student.married);
console.log(student.subjects);
console.log(student.address);
console.log(student.address.pincode);

//object short hand property
let age = 29
let person1 = {name:"raju", age:age, gender:"male"}
console.log(person1);

let person2 = {name:"raju", age, gender:"male"}
console.log(person2);









