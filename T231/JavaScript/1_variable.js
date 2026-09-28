console.log("variables in javascript")
//variables are used to store data
//syntax : prefix variableName=value;
//there are 3 prefix available in javascript : let , var, const
//example : let age=34;
let name="raju";
let age=34;
console.log(name);
console.log(age);

//diff 1 : let and const are block scoped {}, var has global scope
{
    var a=10;
    let b=20;
    const c=30;
    console.log(b);
}
console.log(a);
//console.log(b); //ReferenceError: b is not defined
//console.log(c); //ReferenceError: b is not defined

//diff 2 : we can update var and let, not const
var d=40;
console.log(d);
d=400;
console.log(d);

let e=50;
console.log(e);
e=500;
console.log(e);

const f=60;
console.log(f);
//f=600; //ERROR : TypeError: Assignment to constant variable.
console.log(f);


//diff 3: we can only re-decalre var, cant let or const
var g=11;
var g=111;

let h=22;
//let h=222;

const i=33;
//const i=333;












