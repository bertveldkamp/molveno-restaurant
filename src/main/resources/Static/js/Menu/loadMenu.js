$(document).ready(loadMenu());

function loadMenu()
{
$.ajax({
type:"GET",
url:"/api/menu/menu",
success:function(data)
{
var starters = "<h4>Starters</h4><div id=starters>";
var main_courses = "<h4>Main Courses</h4><div id=main_courses>";
var desserts = "<h4>Desserts</h4><div id=desserts>";
var side_dish = "<h4>Side Dishes</h4><div id=side_dish>";
var soft_drinks = "<h4Soft Drinks</h4><div id=soft_drinks>";
var spirits = "<h4>Soft Drinks</h4><div id=spirit>";

$.each(data, function(index,value)
{
    if(value.course == "Starter")
    {
        starters += "<div class='row'>";
        starters += "<div class='col'>" + value.name + "<img src='/public/images/info.png' height='10' width='10'></div><div class='col'>" + value.price + "</div></div>";
        starters += "<div class='row'><div class='col'><p class='text-center font-italic'>" + value.description + "</p></div></div>";
    }
    if(value.course == "Main Course")
    {
        main_courses += "<div class='row'>";
        main_courses += "<div class='col'>" + value.name + "<img src='/public/images/info.png' height='10' width='10'></div><div class='col'>" + value.price + "</div></div>";
        main_courses += "<div class='row'>" + value.description + "</div>";
    }
    if(value.course == "Dessert")
    {
        desserts += "<div class='row'>";
        desserts += "<div class='col'>" + value.name + "<img src='/public/images/info.png' height='10' width='10'></div><div class='col'>" + value.price + "</div></div>";
        desserts += "<div class='row'>" + value.description + "</div>";
    }
    if(value.course == "Side Dish")
    {
        side_dish += "<div class='row'>";
        side_dish += "<div class='col'>" + value.name + "<img src='/public/images/info.png' height='10' width='10'></div><div class='col'>" + value.price + "</div></div>";
        side_dish += "<div class='row'>" + value.description + "</div>";
    }
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
             soft_drinks += "<div class='row'>";
             soft_drinks += "<div class='col'>" + value.name + "<img src='/public/images/info.png' height='10' width='10'></div><div class='col'>" + value.price + "</div></div>";
             soft_drinks += "<div class='row'>" + value.description + "</div>";
          //   alert("JAJAJA");
         }

})
    starters += "</div>";
    main_courses += "</div>";
    desserts += "</div>";
    side_dish += "</div>";
    soft_drinks += "</div>";

    html = starters + main_courses + desserts + side_dish + soft_drinks;

$('#menu').html(html);
}
})
}
