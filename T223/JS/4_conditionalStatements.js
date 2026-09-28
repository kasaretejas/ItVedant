//if we want to perform action, but that action is depends on condition, we use
//conditional statement


//check given age is eligible for voting
//let age=17;
let age=19;
if(age>=18)
{
    console.log("eligible for voting");  
}
else
{
    console.log("not eligible for voting"); 
}

//there are 2 numbers x=6, y=7, tell me which is greater number
let x=16;
let y=7;
if(x>y)
{
    console.log(x + " is greater");
}
else
{
    console.log(y + " is greater");
}

//take length and breadth and check given structure is square or rectangle
let length = 12;
let breadth = 13;
if(length==breadth)
{
    console.log("Its a square");
}
else
{
    console.log("Its a rectangle");
}

//check for largest number among 3 numbers
let n1=12;
let n2=15;
let n3=2;
if(n1>n2 && n1>n3)
{
    console.log(n1 + " is largest");
}
else if(n2>n1 && n2>n3)
{
    console.log(n2 + " is largest");
}
else
{
    console.log(n3 + " is largest");  
}

//91-100:A, 81-90:B, below 80:failed
let marks=70;
if(marks>=91 && marks<=100)
{
    console.log("A grade");
}
else if(marks>=81 && marks<=90)
{
    console.log("B grade");
}
else
{
    console.log("failed");
}








