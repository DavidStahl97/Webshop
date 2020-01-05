console.log("Details");


$("#back-button").click(function(){
    $("#main-div").load("home-component/home-component.html");
});
$("#details-buy-item").click(function(){
    let e1 = document.getElementById("details-select-size");
    let sizeValue = e1.options[e1.selectedIndex].value;
    let e2 = document.getElementById("details-select-quantity");
    let quantityValue = e2.options[e2.selectedIndex].value;
    $('#details-article-description').append(`
        <span>${sizeValue}+${quantityValue}</span>
    `);
});


$(document).ready(function () {
    $('#details-article-name').html(details_element.itemName);
    $('#details-article-description').html(details_element.description);
    $('#details-article-picture').html(`
        <img  class="details-white-picture" src="${details_element.imgPath}">
    `);
    $('#details-tag-1').html(`
        <span>#for ${details_element.suitedFor}</span>
    `);
    $('#details-tag-2').html(`
        <span>#${details_element.color}</span>
    `);
    $('#details-tag-3').html(`
        <span>#${details_element.brand}</span>
    `);
    $('#details-tag-4').html(`
        <span>#${details_element.itemType}</span>
    `);
    $('#details-article-price').html(`
        <span>${details_element.price}$</span>
    `);
});