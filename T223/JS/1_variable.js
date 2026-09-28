//creating simple variable
age = 50;
console.log(age)

//to decalre variable in JS, we have to use 3 types of prefix - var, let or const
//SCOPE : let and const are called as block scope {} where as var is having global scope
{
   var a = 10;
   let b = 20;
   const c = 30; 
}

console.log(a);
//console.log(b);  //ReferenceError: b is not defined
//console.log(c);   //ReferenceError: c is not defined


//UPDATE : we can only update values of var and let, not const
var d = 40;
console.log(d);  //40
d=50;
console.log(d);  //50

let e = 60;
console.log(e);  //60
e=70;
console.log(e);  //70

const f = 80;
console.log(f);  //80
//f=90;    TypeError: Assignment to constant variable. ==> cant change value of const
console.log(f);  //80


//REDECLARATION : declaring variable again with same name (value can be diff)
//we can  redeclare var but not  let and const, 
var g = 1;
var g="one"

let h = 2;
//let h = "two";

const i = 3;
//const i = "three";


//variable houisting : accessing varibale before initalizing
console.log(name);
//var name = "tejas";
//let name = "tejas";    //ReferenceError: Cannot access 'name' before initialization
//const name = "tejas";    //ReferenceError: Cannot access 'name' before initialization















