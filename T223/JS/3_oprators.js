//oprators : are used to perform operation in variables
//operators:
    //1. Arithmatic :  +, - , *, /, %
    //2. Assignment :  =, +=, -= ......
    //3. Logical    :  &&, ||, !
    //4. Comparision:  >,<,>=,<=, !=, ===
    //5. Ternary    :  ?:
    //6. Unary      :  ++, --
    //7. rest/spread:  ...

//1. Arithmatic :  +, - , *, /, %
console.log(10+2); //12
console.log(10-2); //8
console.log(10*2); //20
console.log(10/2); //5
console.log(10%2); //0

console.log(10.0/2); //5
console.log(10/3); //3.3333
console.log(10%3); //1

console.log("Hi"+"bye"); //Hibye
console.log("hi"+2); //hi2
console.log("hi"*2); //NaN
console.log("hi"/2); //NaN
console.log(0/10); //0  
console.log(10/0); //Infinity

console.log(true + true); //2



//2. Assignment :  =, +=, -= ......
let x = 10; //10
x = x+5; //15
x+=3 //x=x+3 ==> 18
x-=4 //x=x-4 ==> 14
console.log(x);


//4. Comparision:  >,<,>=,<=, !=, ===

console.log(10>2); //t
console.log(10<2); //f
console.log(5>5);  //f
console.log(5>=5); //t
console.log(3!=5); //t
console.log(3==3); //t
// == is used for content comparision, datatype doesnt matter
console.log(4 == "4"); 
console.log(4 == 4.0); 
// == is used for content comparision and datatype 
console.log(4 === "4"); 
console.log(4 === 4); 
console.log(4 === 4.0);


//3. Logical    :  &&, ||, !
//&& : returns true if all conditions are true
//|| : return true if at least one condition is true
//!  : reverse the result
console.log("-----Logical-------");

console.log(3>2 && 5>3); //true && true  ==> true
console.log(3>2 && 5<3); //true && false ==> false

console.log(3>2 || 5>3); //true || true  ==> true
console.log(3>2 || 5<3); //true || false ==> true
console.log(3<2 || 5<3); //false|| false ==> false

console.log(! 3>2); //! true ==> false


//5. Ternary    :  ?:
console.log("----Ternary---");
console.log(5>2 ? "YES" : "No");

//6. Unary      :  ++, --
// x++ : post increment   : read first then use incremented value in next access
// ++x : pre increment    : increment first then read
// y-- : post decrement   : read first then use decremented value in next access
// --y : pre decrement    : decrement first then read
console.log("--------Unary--------");

let a = 20;
console.log(a++); //20
console.log(a);   //21

let b = 10;
console.log(++b); //11
console.log(b);   //11

let p=14;
let q=21;
console.log(p++ + ++q + p);
//14 + 22 + 15 ==> 51



//7. rest/spread:  ...
//rest and spread will be continued in array & object













