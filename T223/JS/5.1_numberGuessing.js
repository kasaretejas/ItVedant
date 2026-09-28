let actualNumber=45;
let guessedNumber=0; 

while(actualNumber!=guessedNumber) 
{
   guessedNumber =Number(prompt("Enter a two digit number")) 
   if(guessedNumber>actualNumber)  
   {
        alert("enter number smaller than " +guessedNumber)
        continue; //go towards the loop
   }
   else if(guessedNumber<actualNumber) 
   {
        alert("enter number greater than " +guessedNumber)
        continue; //go towards the loop
   }
    else
    {
        alert("Thank you for playing game")
        break; //go out of  the loop
    }
}
