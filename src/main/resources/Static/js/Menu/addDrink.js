
function addDrink()
{
var drinkJSON = formToJSON();
addNewDrink(drinkJSON);
}

function formToJSON()
{
    var jsonObject = {};
        if($("#name").val() != "")
             {
                jsonObject["name"] = $("#name").val();
             }
        if($("#volumeInMilliLiters").val() != "")
             {
                     jsonObject["volumeInMilliLiters"] = $("#volumeInMilliLiters").val();
             }
        if($("#description").val() != "")
             {
                jsonObject["description"] = $("#description").val();
            }
        if($("#price").val() > 0)
            {
                jsonObject["price"] = $("#price").val();
            }
         if($("#course").val() != "")
            {
                jsonObject["course"] = $("#course").val();
            }
//          if($("#bottleCheckBox").val() != "")
//            {
//                        jsonObject["bottleCheckBox"] = $("#bottleCheckBox").val();
//            }
        return jsonObject;
}

function addNewDrink(drinkJSON){
$.ajax
    ({
        type: "POST",
        url: "/api/drink",
        contentType: 'application/json',
        data: JSON.stringify(drinkJSON),
//        dataType:'json'
    })
}

