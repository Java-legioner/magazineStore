
let userRole = null;
let products = null;

$.get("products", function (data) {
    if (data !== '') {
        products = data;
    }
}).done(function () {
    let cardsContent = "";

    jQuery.each(products, function (i, value) {


        cardsContent += "<div class='col-md-4 cabinet-card'>" +
            "<h2>" + value.name + "</h2>" +
            "<p>" + value.description + "</p>" +
            "<h1 class='card-title pricing-card-title'>" + value.price + " $ </h1>" +
            "<p><a class='btn btn-secondary btn-view' href='product?id=" + value.id + "' role='button'>View</a></p>" +
        "</div>"

    });




    $('.productsCards').html(cardsContent);

}).done(function () {
    $.get("user-role", function (data) {
        if (data !== ''){
            userRole = data;
        }
    }).done(function () {
        if(userRole ==='ADMIN'){
            $('a.btn-view').hide();
        }

    })
});