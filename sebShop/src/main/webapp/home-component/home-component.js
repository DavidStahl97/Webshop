$(document).ready(function(){


$("#details-button").click(function(){
    $("body").load("details-component/home-component.html");
});

$("#buy-button").click(function(){
    $("body").load("product-list-component/product-list-component.html");
});
});