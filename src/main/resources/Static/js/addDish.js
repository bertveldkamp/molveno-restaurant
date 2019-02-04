function addDish()
{
var consumableJSON = formToJSON();
addConsumable(consumableJSON);
}

function formToJSON()
{
    alert($("#name").val())
    var jsonObject = {};
    if($("#name").val() != "")
    {
        jsonObject["name"] = $("#name").val();
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

    if($("#ingredientQuantity1").val() > 0)
    {
        metaIngredientList = []
        var numberOfIngredients = $("#metaIngredients > div").length + 1;
        for (i = 1; i <= numberOfIngredients; i++)
        {
            metaIngredientList.push({
                "quantity": $("#ingredientQuantity"+numberOfIngredients).val(),
                "unit": $("#ingredientUnit"+numberOfIngredients).val(),
                "ingredient":{
                    "name":$("#ingredientName"+numberOfIngredients).val(),
                    "supplier":$("#ingredientSupplier"+numberOfIngredients).val()
                    }
                })
        }
        jsonObject["ingredientList"] = metaIngredientList;
    }
    $("#hierkandejson").text(JSON.stringify(jsonObject));
    return jsonObject;
}


function addConsumable(consumableJSON){
//else if Drink?
//else if Bottle?

$.ajax({
    type: "POST",
    url: "/api/menu/addDish",
    contentType: 'application/json',
    data: JSON.stringify(consumableJSON),
    dataType:'json'
    })
loadMenu();
}