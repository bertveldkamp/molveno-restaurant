$(document).ready(function({
    $.ajax({
        type: "POST",
        url: "/addToOrder/",
        data: JSON.stringify({
        name: "Cola",
        amount: 4,
        }),
        contentType: 'application/json'
        }
    })
}))