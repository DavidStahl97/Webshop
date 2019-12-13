

console.log("used");

    $("#details-button").click(function(){
        console.log("detail");
        $("body").load("details-component/details-component.html");
    });

    $("#buy-button").click(function(){
        console.log("buy");
        $("body").load("production-list-component/product-list-component.html");
    });
