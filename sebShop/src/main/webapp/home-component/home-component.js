

console.log("used2");

$("#details-button").click(function(){
    console.log("detail");
    $("#main-div").load("details-component/details-component.html");
});