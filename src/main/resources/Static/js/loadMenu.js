function loadMenu()
{
$.ajax({
type:"GET",
url:"/api/menu/menu",
success:function(data)
{
var html = "<table><tr><td>Name</td><td>description</td><td>price</td></tr>"
$.each(data, function(index,value)
{
    html = html + "<tr><td>" + value.name + "</td><td>" + value.description + "</td><td>" + value.price + "</td></tr>";
})
html = html + "</table>";
$('#menu').html(html);
}
})
}