$(document).ready(loadMenu());

function loadMenu()
{
$.ajax({
type:"GET",
url:"/api/drink",
success:function(data)
{

var soft_drinks = "<h4Soft Drinks</h4><div id=soft_drinks>";
var spirits = "<h4>Soft Drinks</h4><div id=spirit>";

$.each(data, function(index,value)
{
     if(value.course == "Soft Drinks")
         {
         //    alert("JAJAJA");
             soft_drinks += "<div class='row'>";
             soft_drinks += "<div class='col'>" + value.name + "<img src='/public/images/info.png' height='10' width='10'></div><div class='col'>" + value.price + "</div></div>";
             soft_drinks += "<div class='row'>" + value.description + "</div>";
          //   alert("JAJAJA");
         }
     if(value.course == "Spirit")
         {
         //    alert("JAJAJA");
             spirits += "<div class='row'>";
             spirits += "<div class='col'>" + value.name + "<img src='/public/images/info.png' height='10' width='10'></div><div class='col'>" + value.price + "</div></div>";
             spirits += "<div class='row'>" + value.description + "</div>";
          //   alert("JAJAJA");
         }

})
    soft_drinks += "</div>";
    spirits += "</div>";

    html = soft_drinks + spirits;

$('#menu').html(html);
}
})
}
