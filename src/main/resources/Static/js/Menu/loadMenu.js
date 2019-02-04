$(document).ready(loadMenu());

function loadMenu()
{
$.ajax({
type:"GET",
url:"/api/menu/menu",
success:function(data)
{
var starters = "<h2>Starters</h2><div id=starters>";
var main_courses = "<h2>Main Courses</h2><div id=main_courses>";
var desserts = "<h2>Desserts</h2><div id=desserts>";
var side_dish = "<h2>Side Dishes</h2><div id=side_dish>";
var soft_drinks = "<h2>Soft Drinks</h2><div id=soft_drinks>";

$.each(data, function(index,value)
{
    if(value.course == "Starter")
    {
        starters += "<div class='row'>";
        starters += "<div class='col'>" + value.name + "</div><div class='col'>" + value.price + "</div></div>";
        starters += "<div class='row'>" + value.description + "</div>";
    }
    if(value.course == "Main Course")
    {
        main_courses += "<div class='row'>";
        main_courses += "<div class='col'>" + value.name + "</div><div class='col'>" + value.price + "</div></div>";
        main_courses += "<div class='row'>" + value.description + "</div>";
    }
    if(value.course == "Desserts")
    {
        desserts += "<div class='row'>";
        desserts += "<div class='col'>" + value.name + "</div><div class='col'>" + value.price + "</div></div>";
        desserts += "<div class='row'>" + value.description + "</div>";
    }
    if(value.course == "Side Dish")
    {
        side_dish += "<div class='row'>";
        side_dish += "<div class='col'>" + value.name + "</div><div class='col'>" + value.price + "</div></div>";
        side_dish += "<div class='row'>" + value.description + "</div>";
    }
    if(value.course == "Soft Drinks")
    {
    //    alert("JAJAJA");
        soft_drinks += "<div class='row'>";
        soft_drinks += "<div class='col'>" + value.name + "</div><div class='col'>" + value.price + "</div></div>";
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