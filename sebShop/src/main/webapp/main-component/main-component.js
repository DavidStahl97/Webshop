$(document).ready(function () {

    // to prevent the default href link click
    $('.nav-link').click(function(e) {
        e.stopPropagation();
        e.preventDefault();
    });

    $("#product-list-link").click(function () {
        $("#main-div").load("product-list-component/product-list-component.html");
    });

    $("#home-link").click(function () {
        $("#main-div").load("home-component/home-component.html");
    });

    $("#logout-link").click(function () {
        $("#container").load("login-component/login-component.html");
    })

    $("#home-link").click();
});