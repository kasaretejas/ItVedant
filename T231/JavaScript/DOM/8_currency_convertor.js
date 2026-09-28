let fromCurrency = document.getElementById("fromCurrency")
let toCurrency = document.getElementById("toCurrency")

async function fetchAllCurrencies()
{
    let response = await fetch("https://api.frankfurter.dev/v2/currencies")
    let currenciesData=await response.json() //currenciesData is an array
    for(let currency of currenciesData) //currency is an object present inside array
    {
        let option = document.createElement("option")
        option.textContent = `${currency.iso_code} : ${currency.name}`;
        fromCurrency.appendChild(option)

        let clonnedOption=option.cloneNode(true)
        toCurrency.appendChild(clonnedOption)
    }
}

fetchAllCurrencies()

//coverting currency
let btn = document.getElementById("btn")
let inputAmount = document.getElementById("inputAmount")
let convertedAmount = document.getElementById("convertedAmount")
btn.addEventListener("click", ()=>
    {
           
            let from = fromCurrency.value.substr(0,3);
            let to = toCurrency.value.substr(0,3);
            let amount = inputAmount.value

            console.log(from , to , amount);

            const api = "https://api.frankfurter.dev";
            fetch(`${api}/v2/rate/${from}/${to}`)
            .then((response) => response.json())
            .then((data) => 
            {
                let convertedValue = (amount * data.rate).toFixed(2)
                //console.log(convertedValue);
                convertedAmount.value = convertedValue;
            });
            
    })