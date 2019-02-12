$(document).ready(loadDishMenu());
function loadDishMenu()
 {
 $.ajax({
 type:"GET",
 url:"/api/dish/all",
 success:function(data)
 {

     var starters = "<h4>Starters</h4><div id=starters>";
     var main_courses = "<h4>Main Courses</h4><div id=main_courses>";
     var desserts = "<h4>Desserts</h4><div id=desserts>";
     var side_dish = "<h4>Side Dishes</h4><div id=side_dish>";
     $.each(data, function(index, value)
     {
      console.log(value);
        if(value.course == "Starter")
         {
             starters += "<div class='row'>";
             starters += "<div class='col'>" + value.name + "<img src='/public/images/info.png' height='10' width='10'></div><div class='col'>&yen;" + value.price + "</div></div>";
             starters += "<div class='row'><div class='col'><p class='text-center font-italic'>" + value.description + "</p></div></div>";
         }
         else if(value.course == "Main Course")
         {
             main_courses += "<div class='row'>";
             main_courses += "<div class='col'>" + value.name + "<img src='/public/images/info.png' height='10' width='10'></div><div class='col'>&yen;" + value.price + "</div></div>";
             main_courses += "<div class='row'>" + value.description + "</div>";
         }
         else if(value.course == "Dessert")
         {
             desserts += "<div class='row'>";
             desserts += "<div class='col'>" + value.name + "<img src='/public/images/info.png' height='10' width='10'></div><div class='col'>&yen;" + value.price + "</div></div>";
             desserts += "<div class='row'>" + value.description + "</div>";
         }
         else if(value.course == "Side Dish")
         {
             side_dish += "<div class='row'>";
             side_dish += "<div class='col'>" + value.name + "<img src='/public/images/info.png' height='10' width='10'></div><div class='col'>&yen;" + value.price + "</div></div>";
             side_dish += "<div class='row'>" + value.description + "</div>";
         }

     }
     )
         starters += "</div>";
         main_courses += "</div>";
         desserts += "</div>";
         side_dish += "</div>";

         var html = starters + main_courses + desserts + side_dish;
         loadDrinkMenu(html);


 }
 })
 }
 function loadDrinkMenu(html)
 {
 $.ajax({
 type:"GET",
 url:"/api/drink",
 success:function(data)
 {

 var soft_drinks = "<h4>Soft Drinks</h4><div id=soft_drinks>";
 var spirits = "<h4>Spirits</h4><div id=spirit>";

 $.each(data, function(index,value)
 {
    console.log(value)
      if(value.course == "Soft Drinks")
          {
              soft_drinks += "<div class='row'>";
              soft_drinks += "<div class='col'>" + value.name + "<img src='/public/images/info.png' height='10' width='10'></div><div class='col'>" + value.price + "</div></div>";
              soft_drinks += "<div class='row'>" + value.description + "</div>";
          }
      if(value.course == "Spirit")
          {
              spirits += "<div class='row'>";
              spirits += "<div class='col'>" + value.name + "<img src='/public/images/info.png' height='10' width='10'></div><div class='col'>" + value.price + "</div></div>";
              spirits += "<div class='row'>" + value.description + "</div>";
          }

 })
     soft_drinks += "</div>";
     spirits += "</div>";

     html += soft_drinks + spirits;
     $('#menu').html(html);
 }
 })
 }
