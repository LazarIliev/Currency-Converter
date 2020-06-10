let form = document.getElementById("currency-convert-form");
form.onsubmit = function (e) {
    let fromCode = document.getElementById("codeFrom").value;
    let toCode = document.getElementById("codeTo").value;
    let sumToConvert = document.getElementById("currencyAmountToConvert").value;
    console.log("from code: "+fromCode);
    console.log("to code: "+toCode);
    console.log("sum: "+sumToConvert);

    e.preventDefault();
    fetch("convert?codeFrom="+ fromCode+"&codeTo="+ toCode+"&amount="+sumToConvert,{
        method: "get"
    }).then( response =>{
             console.log(response.json().then((data) =>{console.log(data)}));
        });
}