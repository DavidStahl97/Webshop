$(document).ready(function () {

    // to prevent the default href link click
    $('.nav-link').click(function(e) {
        e.stopPropagation();
        e.preventDefault();
    });

    $("#product-list-link").click(function () {
        $("#main-div").load("ordering-process-component/ordering-process-component.html");
    });

    $("#home-link").click(function () {
        $("#main-div").load("home-component/home-component.html");
    });

    $("#logout-link").click(function () {
        $("body").empty();
        $("body").load("login-component/login-component.html");
    });

    $('#order-list-link').click(function () {
        $("#main-div").load("order-list-component/order-list-component.html");
    });

    $("#main-div").load("home-component/home-component.html");

});