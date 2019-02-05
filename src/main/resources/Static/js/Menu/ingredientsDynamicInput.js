//function addIngredientField()
//{
//    var numberOfIngredients = $("#metaIngredients > div").length + 1;
//    var fields = "<div class=form-group>";
//    fields += '<input id="ingredientQuantity'+numberOfIngredients+'" type="number" min="0" placeholder="0" size="3">';
//    fields += '<select id="ingredientUnit'+numberOfIngredients+'">';
//    fields += '<option value="GRAM"> Gram </option>';
//    fields += '<option value="KILOGRAM"> KiloGram </option>';
//    fields += '<option value="AMOUNT"> pieces of </option>';
//    fields += '</select>';
//    fields += '<input id="ingredientName'+numberOfIngredients+'" type="text" placeholder="Ingredient name">';
//    fields += '<input id="ingredientSupplier'+numberOfIngredients+'" placeholder="Ingredient supplier" type="text">';
//    fields += '</div>';
//    $("#metaIngredients").append(fields);
//
//}

(function ($) {
    $(function () {

        var addFormGroup = function (event) {
            event.preventDefault();

            var $formGroup = $(this).closest('.input-group');
            var $multipleFormGroup = $formGroup.closest('.multiple-input-group');
            var $formGroupClone = $formGroup.clone();

            $(this)
                .toggleClass('btn-default btn-add btn-danger btn-remove')
                .html('-');

            //$formGroupClone.find('input').val('');
            $formGroupClone.insertAfter($formGroup);


            var $lastFormGroupLast = $multipleFormGroup.find('.input-group:last');
            if ($multipleFormGroup.data('max') <= countFormGroup($multipleFormGroup)) {
                $lastFormGroupLast.find('.btn-add').attr('disabled', true);
            }
        };

        var removeFormGroup = function (event) {
            event.preventDefault();

            var $formGroup = $(this).closest('.input-group');
            var $multipleFormGroup = $formGroup.closest('.multiple-input-group');

            var $lastFormGroupLast = $multipleFormGroup.find('.input-group:last');
            if ($multipleFormGroup.data('max') >= countFormGroup($multipleFormGroup)) {
                $lastFormGroupLast.find('.btn-add').attr('disabled', false);
            }

            $formGroup.remove();
        };

        var countFormGroup = function ($form) {
            return $form.find('.input-group').length;
        };

        $(document).on('click', '.btn-add', addFormGroup);
        $(document).on('click', '.btn-remove', removeFormGroup);

    });
})(jQuery);