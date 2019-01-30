function removeDish(){
$.ajax({
    type: "POST",
    url: "/removeDish",
    contentType: 'application/json',
    data: JSON.stringify({
    "name": (document).getElementById("name").value,
    "description": (document).getElementById("description").value,
    "price": (document).getElementById("price").value,
    "course":(document).getElementById("course").value
    }),
    dataType:'json'
    })
alert("Erg jammer.");
}