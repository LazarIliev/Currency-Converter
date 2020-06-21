$(() =>{
    console.log("test message!")
    const tableBody = document.getElementById("currencyTableBody");
    let selectFrom = document.getElementById("codeFrom");
    let selectTo = document.getElementById("codeTo");
    fetch("api/currencies",
        { method: "get"
        }).then(response => {
        response.json().then(data =>{
            console.log(data);
            console.log(data[0]["code"])
            data.forEach((currency) =>{
                console.log(currency)
                let row = tableBody.insertRow();
                let code = row.insertCell(0);
                code.innerHTML = currency["code"];
                let name = row.insertCell(1);
                name.innerHTML = currency["name"];
                let rate = row.insertCell(2);
                rate.innerHTML = currency["rate"];
                let ratio = row.insertCell(3);
                ratio.innerHTML = currency["ratio"];

                const opt = document.createElement("option");
                const opt2 = document.createElement("option");
                opt.value = currency["code"];
                opt2.value = currency["code"];
                opt.innerHTML = currency["code"];
                opt2.innerHTML = currency["code"];

                selectFrom.appendChild(opt);
                selectTo.appendChild(opt2);
            });
        });
    });
});