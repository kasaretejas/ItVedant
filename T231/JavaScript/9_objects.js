//object : is used to store data in key value pair
let employee = {"id":101, "name":"raj"}
console.log(employee);

employee.city = "pune"; //adding new key value pair 
console.log(employee);

employee.id = 202; //this will override existing value of id
console.log(employee);

console.log(employee.id);
console.log(employee.name);
console.log(employee.gender); //undefined

console.log(Object.keys(employee)); //get array of all keys
console.log(Object.values(employee)); //get array of all values

//complex object
let student = {
    "rollNo":12,
    "name":"amit",
    "married":false,
    "marks":[94,93,91,99],
    "address":{"houseNo":"B009", "city":"pune", "pincode":455231}
}

console.log(student.rollNo);
console.log(student.name);
console.log(student.married);
console.log(student.marks[0]);
console.log(student.address.city);

//object destructuring
let bike = {"brand":"tvs", "model":"ronin","price":250000}
console.log(bike);

// let {brand, model, price} = bike
// console.log(brand);

// let {brand} = bike
// console.log(brand);

let {x, y, z} = bike //x,y,z keys not present in bike object
console.log(x); //undefined

//rest and spread operator
let car = {"brand":"volvo", "model":"xc60","price":25000}
console.log(car);

let {brand, ...restOfCarDetails}=car;
console.log(brand);
console.log(restOfCarDetails);

let obj1 = {name:"raj", age:20}
let obj2 = {city:"pune", phone:"9898767656"}

let person = {...obj1, ...obj2}
console.log(person);










