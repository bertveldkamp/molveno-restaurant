function addDrink()
{
var consumableJSON = formToJSON();
addConsumable(consumableJSON);
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

function addConsumable(consumableJSON){
$.ajax
    ({
        type: "POST",
        url: "/api/menu/addDrink",
        contentType: 'application/json',
        data: JSON.stringify(consumableJSON),
//        dataType:'json'
    })
}

