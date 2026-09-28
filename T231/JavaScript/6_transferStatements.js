//so, based on condition, we have to either stop the loop OR
//go for next iteration.

//if we want to stop the loop -----> use break
//if we want to skip current iteration and go for next -----> use continue

//in range 1-20, stop as soon as you get number divisible by 3 and even

for(let i=1; i<=20; i++)
{
    if(i%3==0 && i%2==0)
    {
        break;
    }
    else
    {
        console.log(i);
    }
}
console.log("-------------------------------------");

//in range 1-20, skip as soon as you get number divisible by 3 and even

for(let i=1; i<=20; i++)
{
    if(i%3==0 && i%2==0)
    {
        continue;
    }
    else
    {
        console.log(i);
    }
}