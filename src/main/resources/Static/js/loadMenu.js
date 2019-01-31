$(document).ready(loadMenu());

function loadMenu()
{
$.ajax({
type:"GET",
url:"/api/menu/menu",
success:function(data)
{

var html = "<table><thead><tr><th>course</th><th>Name</th><th>description</th><th>price</th></tr></thead>"
$.each(data, function(index,value)
{
    html = html + "<tr><td>" + value.course + "</td><td>" + value.name + "</td><td>" + value.description + "</td><td>" + value.price + "</td></tr>";
})
html = html + "</table>";
$('#menu').html(html);
}
})
}