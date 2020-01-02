$(document).ready(function () {
    $('#shop-more-button').click(function () {
        $("#main-div").load("home-component/home-component.html");
    });

    $('#order-button').click(function () {
        $("#main-div").load("order-list-component/order-list-component.html");
    });
});