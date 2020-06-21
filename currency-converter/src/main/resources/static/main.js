let form = document.getElementById("currency-convert-form");
form.onsubmit = function (e) {
    e.preventDefault();
    let fromCode = document.getElementById("codeFrom").value;
    let toCode = document.getElementById("codeTo").value;
    let sumToConvert = document.getElementById("currencyAmountToConvert").value;
    console.log("from code: " + fromCode);
    console.log("to code: " + toCode);
    console.log("sum: " + sumToConvert);
    if (sumToConvert <= 0 || fromCode === "" || toCode === "" || fromCode === toCode) {
        document.getElementById("convertedAmount").value = "Invalid input!";
        return;
    }


    fetch("api/convert?codeFrom=" + fromCode + "&codeTo=" + toCode + "&amount=" + sumToConvert, {
        method: "get"
    }).then(response => {
        if (response.status !== 400 && response.status !== 500) {
            console.log(response.json()
                .then((data) => {
                    console.log(data)
                    document.getElementById("convertedAmount").value = data;
                }));
        } else {
            document.getElementById("convertedAmount").value = "Invalid input!";
        }
    });
}