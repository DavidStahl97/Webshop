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
