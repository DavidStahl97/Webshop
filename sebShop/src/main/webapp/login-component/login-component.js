var all_articles = [];
var all_articles_backUp = [];
var position = 0;
var page = 1;
var details_element;

$("#login-button").click(function(){
    $("body").load("main-component/main-component.html");
});

$(document).ready(function () {
    load_all_articles();
});

function load_all_articles() {
    $.ajax({
        url: 'http://localhost:8080/shopItemsServlet',
        data: {},
        type: 'GET',
        success: function (data) {
            let shop_items = JSON.parse(data);
            for(let i = 0; i < 4410; i++) {
                all_articles.push({
                    itemName: shop_items[i].id,
                    description: shop_items[i].description,
                    itemType: shop_items[i].itemType,
                    suitedFor: shop_items[i].suitedFor,
                    brand: shop_items[i].brand,
                    color: shop_items[i].color,
                    imgPath: shop_items[i].imgPath,
                    price: shop_items[i].price,
                });
            }
            all_articles_backUp = [...all_articles];
        }
    });
}
