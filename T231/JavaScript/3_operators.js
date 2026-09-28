//operators : are symbols in JS, used to perform operation on data

//arithmatic  : +, -, *, /, %
//assignment  : =, +=, -=, *=, ...
//comparision : >, <, >=, <=, ==, !=, ===
//logical     : &&, ||, !
//unary       : ++, --
//ternary     : ?:

//arithmatic  : +, -, *, /, %
console.log(20+2); //22
console.log(20-2); //18
console.log(20*2); //40
console.log(20/2); //10
console.log(20%2); //0

console.log(20.0/2); //10
console.log(20/3); //6.66666
console.log(20%3); //2

console.log("hi"+"bye"); //concatination hibye

//assignment  : =, +=, -=, *=, ...
let x=10;
x = x+2; //x=10+2 --> x=12    (x+=2)

x-=5; //x=x-5 --> x=12-5 ---> x=7

//comparision : >, <, >=, <=, ==, !=, ===
console.log(8 > 2); //t
console.log(8 < 2); //f
console.log(8 > 8); //f
console.log(8 >= 8); //t
console.log(8 < 8); //f
console.log(8 <= 8); //t
console.log(8 == 8); //t
console.log(8 != 6); //t

console.log("hii" > "haa"); //t
console.log("hii" > "hyy"); //f (character by character comparision)

console.log(3 == 3); //t
console.log(3 == "3"); //t == operator do content/value comparision, data type doesnt matter
console.log(3.0 == 3); //t

console.log(3 === 3); //t
console.log(3 === "3"); //f, with content/value, there is data type comparision
console.log(3 === 3.0); //t


//logical     : &&, ||, !
//&& ---> gives true only if all conditions are true
//|| ---> gives true if at least on condition is true
//! ----> reverse the decision/output
console.log(8>2 && 8>5 && 8>7); //t
console.log(8>2 && 8>5 && 8<7); //f
console.log(8<2 && 8>5 && 8>7); //f

console.log(8>2 || 8>5 || 8>7); //t
console.log(8<2 || 8<5 || 8>7); //t
console.log(8<2 || 8<5 || 8<7); //f

console.log(! 8>2); //f
console.log(! 8<2); //t

//unary       : ++, --
//let a=5;
//a++   -----> post increment--> first access then inc for next use of a
//++a   -----> pre increment --> first inc then pass incremented value
//a--   -----> post decrement--> first access then dec for next use of a
//--a   -----> pre  decrement--> first dec then pass decremented value

let a=5;
console.log(a++ - --a);
//          5 - 5
console.log(a); //5


console.log(a-- + --a - ++a);
//            5 + 3 - 4  


//ternary      ?:
console.log(9>3 ? "YES" : "NO");



 


