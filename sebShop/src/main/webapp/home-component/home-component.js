console.log("used2");

$("#details-button").click(function(){
    $("#main-div").load("details-component/details-component.html");
});

$("#right-button").click(function(){
    if(position+9<all_articles.length){
        position = position+9;
        page++;
        show_articles()
    }
});

$("#left-button").click(function(){
    if(page>1){
        position = position-9;
        page--;
        show_articles()
    }
});

$(document).ready(function () {
    show_articles();
    prepare_details()
});

function show_articles() {
    $("#home-page-number").html(page);
    for (let n = 0; n < 9; n++) {
        if(all_articles.length > position+n) {
            $('#cell-' + n).html(`
            <div>Name: ${all_articles[position + n].itemName}</div>
            <div>Price ${all_articles[position + n].price}</div>
            <img class="home-item-picture"  src="${all_articles[position + n].imgPath}">
            `);
        } else {
            $('#cell-' + n).html(`<div></div>`);
        }
    }
}

function prepare_details() {
    for (let n = 0; n < 9; n++) {
        $("#cell-"+n).click(function () {
            $("#main-div").load("details-component/details-component.html");
            details_element = all_articles[position+n];
        });
    }
}

$("#search-button").click(function(){
    let result = [];
    let searchText = $("#input-search").val();
    let re = new RegExp(searchText, '');
    for(let i = 0; i< all_articles.length ; i++){

        if(all_articles[i].itemName.match(re)){
            result.push(all_articles[i]);
        }
    }
    all_articles = result
    position = 0;
    page = 1;
    show_articles();
});

$("#filter-button").click(function(){
    all_articles = [...all_articles_backUp];
    let e1 = document.getElementById("gender-select");
    let genderValue = e1.options[e1.selectedIndex].value;
    let e2 = document.getElementById("colour-select");
    let colourValue = e2.options[e2.selectedIndex].value;
    let e3 = document.getElementById("brand-select");
    let brandValue = e3.options[e3.selectedIndex].value;
    let e4 = document.getElementById("product-select");
    let productValue = e4.options[e4.selectedIndex].value;
    let e5 = document.getElementById("price-select");
    let priceValue = e5.options[e5.selectedIndex].value;
    let e6 = document.getElementById("filter-select");
    let filterValue = e6.options[e6.selectedIndex].value;

    if(!(genderValue.includes("all"))){
        all_articles = all_articles.filter(function (el) {
            return el.suitedFor.includes(genderValue);
        });
    }
    if(!(colourValue.includes("all"))){
        all_articles = all_articles.filter(function (el) {
            return el.color.includes(colourValue);
        });
    }
    if(!(brandValue.includes("all"))){
        all_articles = all_articles.filter(function (el) {
            return el.brand.includes(brandValue);
        });
    }
    if(!(productValue.includes("all"))){
        all_articles = all_articles.filter(function (el) {
            return el.itemType.includes(productValue);
        });
    }
    if(!(priceValue.includes("all"))){
        all_articles = all_articles.filter(function (el) {
            return el.price < priceValue;
        });
    }
    if(!(filterValue.includes("none"))){
        if(filterValue.includes("Name")){
            all_articles = all_articles.sort(compareSortName);
        }
        if(filterValue.includes("Name Asc")){
            all_articles = all_articles.sort(compareSortNameAsc);
        }
        if(filterValue.includes("Price")){
            all_articles = all_articles.sort(compareSortPrice);
        }
        if(filterValue.includes("Price Asc")){
            all_articles = all_articles.sort(compareSortPriceAsc);
        }
    }
    position = 0;
    page = 1;
    show_articles();
});

$("#reload-button").click(function(){
    all_articles = [...all_articles_backUp];
    position = 0;
    page = 1;
    show_articles();
})

function compareSortName( a, b ) {
    if ( a.itemName < b.itemName ){
        return -1;
    }
    if ( a.itemName > b.itemName ){
        return 1;
    }
    return 0;
}

function compareSortNameAsc( a, b ) {
    if ( a.itemName > b.itemName ){
        return -1;
    }
    if ( a.itemName < b.itemName ){
        return 1;
    }
    return 0;
}
function compareSortPrice( a, b ) {
    if ( a.price < b.price ){
        return -1;
    }
    if ( a.price > b.price ){
        return 1;
    }
    return 0;
}

function compareSortPriceAsc( a, b ) {
    if ( a.price > b.price ){
        return -1;
    }
    if ( a.price < b.price ){
        return 1;
    }
    return 0;
}