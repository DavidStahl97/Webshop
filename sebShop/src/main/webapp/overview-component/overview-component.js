function show_articles_summary() {
    let totalPrice = 0.0;
    for(const article of order.articles) {
        $("#overview-list-group").append(`
            <div class="list-group-item">
                <div class="d-flex w-100 justify-content-between">
                    <img src="http://localhost:8080/${ article.imgPath }" class="article-image"/>
                    <h5 class="mb-1 vertical-center-element">${ article.itemName }</h5>
                    <div class="vertical-center-element">
                        <p>Size: ${ article.size }</p>
                    </div>
                    <div class="vertical-center-element">
                        <p>Quantity: ${ article.quantity }</p>
                    </div>                   
                    <p>${ article.price * article.quantity }</p>
                </div>                        
            </div>
        `);

        totalPrice += article.price * article.quantity;
    }

    order.totalprice = totalPrice;
    $('#total-price').text(`Total price: ${ order.totalprice }$`);
    
    const payment_option = payment_options.find(x => x.name == order.payment);
    $('#selected-payment').addClass(payment_option.icon)
}

$(document).ready(function () {
    show_articles_summary();
});