function addToOrder(consumableID)
{
$.ajax({
type:"GET",
url:"/api/dish/dish?consumableID="+consumableID,
success:function(data)
{
    $.ajax({
        type: "POST",
        url: "/api/overview/addToOrder",
           data: JSON.stringify(data),
           contentType: 'application/json'
           }
       )
   }
   }
   )
}