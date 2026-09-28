//when we have to perform some action for given number of iteration, we use loop
//there are 3 loops in JS : for ,enhanced for loop, while, do-while

//for loop : when we know the start and end point
//ex : display sum of 1 to 5 numbers
//ex : even number between 10-25

//syntax : for(initialization; condition; inc/dec)

//display 1 to 5 numbres
for(let i=1; i<=5; i++)
{
    console.log(i);
}

//display 5 to 1 numbers
for(let i=5; i>=1; i--)
{
    console.log(i); 
}

//display even numbers between 10-20
for(let i=10; i<=20; i++)
{
    if(i%2==0)
    {
        console.log(i);
    }
   
}

//when we know start but we dont know end point, use while loop
//ex : enter correct password (here we dont know when user is going to enter correct password)
//ex : number guessing game

//intialization
// while(condition)
// {
    //inc/dec
// }

//display 1 to 5 numbers using while loop
let i=1;
while(i<=5)
{
    console.log(i);
    i++; 
}

//number guessing game on whuile loop - 5.1 file

//do while
do 
{
    console.log("I am inside do while");  
}
while(10>20)


