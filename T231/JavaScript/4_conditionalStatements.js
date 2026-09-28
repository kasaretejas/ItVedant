//when the execution of action is depends on condition, 
//we use conditional statements

//          if (condition)
//          {}
//          else
//          {}

//          if (condition1)
//          {}
//          else if (condition2)
//          {}
//          else if (condition3) ----> like we can add as many else if we want
//          {}
//          else
//          {}

//always, if is entry point and else is exit


//          if (raning)
//          { go for movie}
//          else
//          { go for bike ride}
//in above example, execution of action is depends on condition,

//check a given number is even or odd
let num=8; //change to 87
if(num%2 == 0) //8%2 ==> 0        0==0
    {
        console.log(`${num} is even`); 
    }
else
    {
    console.log(`${num} is odd`);  
    }


//check given age is eligible for votting
let age=19; //change to 14
if(age>18)
{
    console.log('eligible for votting');
}
else
{
    console.log('not eligible for votting');
}

//based on marks, provide grades
//91-100:A, 81-90:B, 71-80:C, otheriwise D
let marks=76; //65
if(marks>=91 && marks<=100)
{
    console.log('congratulations for A grade');
}
else if(marks>=81 && marks<=90)
{
    console.log('congratulations for B grade');
}
else if(marks>=71 && marks<=80)
{
    console.log('congratulations for C grade');
}
else
{
    console.log('congratulations for D grade');
}



//take two numbers and check for greatest
//take a number and check whether it is two digit number
//take length and bredth and check for rectangle or square
//take 3 numbers and check for largest
//take a number and check for prime
//take a number and check for divisible by 3 and also even
//take a number and check for perfect square