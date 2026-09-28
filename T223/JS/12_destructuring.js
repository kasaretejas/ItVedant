//array destructuring : unpacking array element into variables
//while array destructuring, number of array elemnts and variables must match
let marks = [90,85,67]
let [python, java, react] = marks
console.log(marks);
console.log(python);
console.log(java);
console.log(react);

let [js,,css] = marks //array destructuring by skipping a value
console.log(js);
console.log(css);

//object destructuring
//in object destructuring, our variable name must be same as key of object given
let employee = {name:"raj", age:25, salary:95000}
let {name, salary} = employee
console.log(employee);
console.log(name);
console.log(salary);

let {myName, mySalary} = employee
console.log(myName);
console.log(mySalary);
