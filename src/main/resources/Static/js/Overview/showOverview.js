$(document).ready(function(){
  showOverview();
})
function showOverview()
{
    $.ajax
    ({
        type:"GET",
        url:"/api/overview/overview",
        success:function(data)
        {
          var starters = "";
          var main_courses = "";
          var side_dish = "";
          var desserts = "";
          var soft_drinks = "";
          var spirits = "";
          var html = "<table class ='table table-hover'><thead class='thead-light'><tr><th>Name</th><th>Price per item</th><th>Amount ordered</th><th>Subtotal</tr></thead>"
          var total = 0;
          $.each(data, function(index,value)
          {
            console.log(value);
            if(value.course =="Starter"){
              starters = starters + "<tr><td>" + value.name  + "</td><td>&#165; " + value.price + "</td><td>" + value.amount + "</td><td>&#165; " + value.price * value.amount + "</td></tr>";
            }
            else if(value.course =="Main Course"){
              main_courses = main_courses + "<tr><td>" + value.name  + "</td><td>&#165; " + value.price + "</td><td>" + value.amount + "</td><td>&#165; " + value.price * value.amount + "</td></tr>";
            }
            else if(value.course =="Side Dish"){
              side_dish = side_dish + "<tr><td>" + value.name  + "</td><td>&#165; " + value.price + "</td><td>" + value.amount + "</td><td>&#165; " + value.price * value.amount + "</td></tr>";
            }
            else if(value.course =="Dessert"){
              desserts = desserts + "<tr><td>" + value.name  + "</td><td>&#165; " + value.price + "</td><td>" + value.amount + "</td><td>&#165; " + value.price * value.amount + "</td></tr>";
            }
            else if(value.course =="Soft Drink"){
              soft_drinks = soft_drinks + "<tr><td>" + value.name  + "</td><td>&#165; " + value.price + "</td><td>" + value.amount + "</td><td>&#165; " + value.price * value.amount + "</td></tr>";
            }
            else if(value.course =="Spirit"){
              spirits = spirits + "<tr><td>" + value.name  + "</td><td>&#165; " + value.price + "</td><td>" + value.amount + "</td><td>&#165; " + value.price * value.amount + "</td></tr>";
            }
              // html = html + "<tr><td>" + value.name  + "</td><td>&#165; " + value.price + "</td><td>" + value.amount + "</td><td>&#165; " + value.price * value.amount + "</td></tr>";
              total += (value.price * value.amount)
          })
          html = html + starters + main_courses + side_dish + desserts + soft_drinks + spirits;
          html = html + "<tr class='table-secondary'><td></td><td></td><td></td><td>Total price: &#165; " + total + "</td>";
          html = html + "</table>";
          $('#show-overview').html(html);
        }
    })
}
