function addIngredientField()
{
    var numberOfIngredients = $("#metaIngredients > div").length + 1;
    var fields = "<div>";
    fields += '<input id="ingredientQuantity'+numberOfIngredients+'" type="number" min="0" placeholder="0" size="3">';
    fields += '<select id="ingredientUnit'+numberOfIngredients+'">';
    fields += '<option value="GRAM"> Gram </option>';
    fields += '<option value="KILOGRAM"> KiloGram </option>';
    fields += '<option value="AMOUNT"> pieces of </option>';
    fields += '</select>';
    fields += '<input id="ingredientName'+numberOfIngredients+'" type="text" placeholder="Ingredient name">';
    fields += '<input id="ingredientSupplier'+numberOfIngredients+'" placeholder="Ingredient supplier" type="text">';
    fields += '</div>';
    $("#metaIngredients").append(fields);

}