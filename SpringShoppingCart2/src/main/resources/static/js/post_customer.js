$(document).ready(function() {
    $("#add_new_customer").submit(function(evt) {
        evt.preventDefault();

        // PREPARE FORM DATA
        let formData = {
            code : $("#code").val(),
            name :  $("#name").val(),
            price: $("#price").val(),
            fileData: $("#fileData").val()
        }

        $.ajax({
            url: '/admin/product1/create',
            type: 'POST',
            contentType : "application/json",
            data: JSON.stringify(formData),
            dataType : 'json',
            async: false,
            cache: false,
            success: function (response) {
                let product = response.products[0];
                let productString = "{ Mã Món ĂN: " + product.code + " tên món ăn" + product.name + 
                                            ", giá món ăn: " + product.price + " }"
                let successAlert = '<div class="alert alert-success alert-dismissible">' + 
                                        '<button type="button" class="close" data-dismiss="alert">&times;</button>' +
                                        '<strong>' + response.message + '</strong> Product\'s Info = ' + productString;
                                    '</div>'
                $("#response").append(successAlert);
                $("#response").css({"display": "block"});

                resetUploadForm();
            },
            error: function (response) {
                let errorAlert = '<div class="alert alert-danger alert-dismissible">' + 
                                    '<button type="button" class="close" data-dismiss="alert">&times;</button>' +
                                    '<strong>' + response.message + '</strong>' + ' ,Error: ' + message.error + 
                                '</div>'
                $("#response").append(errorAlert);
                $("#response").css({"display": "block"});

                resetUploadForm();
            }
        });
    });

    function resetUploadForm(){
        $("#code").val("");
        $("#name").val("");
        $("#price").val("");
        $("#fileData").val("");
    }

});