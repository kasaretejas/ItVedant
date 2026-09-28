//step 1 :
let selectFrom=document.getElementById("selectFrom")
let inputAmount=document.getElementById("inputAmount")
let selectTo=document.getElementById("selectTo")
let btn=document.getElementById("btn")
let convertedAmount=document.getElementById("convertedAmount")

//step 2 : fetch currency code and generate option tag in select tag
async function fetchCurrencyCodes()
{
    let response=await fetch("https://api.frankfurter.dev/v1/currencies")
    let currencies=await response.json()
    console.log(currencies);
    let currencyCodes=Object.keys(currencies) 
    console.log(currencyCodes);
    currencyCodes.map((currencyCode)=>
        {
            selectFrom.innerHTML += `<option>${currencyCode}</option>`
            selectTo.innerHTML += `<option>${currencyCode}</option>`
        })
    
} 
fetchCurrencyCodes()


btn.addEventListener("click",()=>
    {    
        let from  = selectFrom.value
        let to = selectTo.value
        let amount = inputAmount.value
        convert(from,to, amount)
    })


async function convert(from, to, amount)
{
    let response=await fetch(`https://api.frankfurter.dev/v1/latest?base=${from}&symbols=${to}`)
    let data = await response.json()
    const finalAmount = (amount * data.rates[to]).toFixed(2);
    convertedAmount.value = finalAmount
}












