$(document).ready(function(){
    $("#getButton").click(function(){
        $.ajax
            ({
                type: "GET",
                url: "/api/drink",
                success:function(data)
                          {
                            alert("ok " + data);
                            console.log(data);
                            $('#showGetButton').html(data[0].name);
                          }
        });
    });
});


//function showDrink()
//{
//var drinkJSON = showAllDrinks();
//}
//
//    function showAllDrinks(){
//    $.ajax
//    ({
//        type: "GET",
//        url: "/api/drink",
//
//    })
//}
