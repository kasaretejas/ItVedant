//when we have to perform certain action upto given 
// number of interations

//problem : print 1 to 5 numbers on console
//action  : print
//iterations : 5

//in JS we have 3 looping statements :
    //1. for loop -------> use when you have range(start and end given)
                         //1-5, 6-10, 78-56
    //2. while loop -----> when we dont know when to stop (there is a start, but not end)
                         //number guessing OR input password
    //3. do while loop --> perform some action first then check condition
                          //ATM, gym application

//for loop:
//syntax : for(initialization ; condition ; inc/dec) {}
//ex1 : display 1-5 numbers using for loop
for(let i=1 ; i<=5 ; i++) 
    {
        console.log(i);   
    }
//ex2 : display 13-19 numbers using for loop
//ex3 : display 78-73 numbers using for loop
for(let i=78; i>=73; i--)
    {
        console.log(i);
    }

//while loop
//syntax : while(condition)  {}
//we have to initialize before while loop.
//we have to write inc/dec inside while loop
//ex1 : display 1-5 numbers using for loop
let a=1;
while(a<=5) 
{
    console.log(a); 
    a++; 
}

//number guessing game using while loop :
//pre requisite : break and continue


//do while :  do {} while(condition)

do
{
    console.log("hello");
}
while(8<2)

//display 11-13 using do-while
let i=11;
do{
    console.log(i);
    i++;
}
while(i<=13)