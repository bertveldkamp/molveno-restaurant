function addDish(){
$.ajax({
    type: "POST",
    url: "/addDish",
    contentType: 'application/json',
    data: JSON.stringify({
    "name": (document).getElementById("name").value,
    "description": (document).getElementById("description").value,
    "price": (document).getElementById("price").value,
    "course":(document).getElementById("course").value
    }),
    dataType:'json'
    })
alert("HEEL LEUK");
}