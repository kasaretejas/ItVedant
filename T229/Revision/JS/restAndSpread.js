//destructuring in array
let numbers = [10,20,30] //structure
let [a,b,c] = numbers    //de - structure
console.log(numbers);
console.log(a);
console.log(b);
console.log(c);

//destructuring in object
let student = {name:"raju", age:30}
let {fullname, name, age} = student
console.log(student);
console.log(fullname);
console.log(name);
console.log(age);

//rest in array
let marks = [98,95,99,34,56]
let [java, sql, ...restOfMarks] = marks
console.log(marks);
console.log(java);
console.log(sql);
console.log(restOfMarks);

//rest in object
let employee = {id:12, firstName:"ramu", age:34, city:"pune"}
let {id, firstName, ...restOfEmployee} = employee
console.log(employee);
console.log(id);
console.log(firstName);
console.log(restOfEmployee);


//spread in array
let a1 = [10, 20, 30]
let a2 = [11, 22, 33]
let a3 = [a1,a2]
console.log(a3);
let a4 = [...a1,...a2]
console.log(a4);
let a5 = [...a1, 5, 1,0, ...a2]
console.log(a5);

//spread in object
let p1 = {name : "raj"}
let p2 = {age : 76, city: "pune"}
let person = {...p1, ...p2}
console.log(person);
