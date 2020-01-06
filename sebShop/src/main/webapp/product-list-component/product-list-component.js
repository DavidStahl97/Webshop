function show_articles() {
    let i = 0;
    for(const article of order.articles) {
        const select_size_id = `select-size-${ i }`;
        const select_quantity_id = `select-quantity-${ i }`;
        const small_article_price_id = `small-article-price-${ i }`;

        $("#product-list-group").append(`
            <div class="list-group-item">
                <div class="d-flex w-100 justify-content-between">
                    <img src="http://localhost:8080/${ article.imgPath }" class="product-image"/>
                    <h5 class="mb-1 vertical-center-element">${ article.itemName }</h5>
                    <div class="vertical-center-element">
                        <small>Size</small>
                        <select class="form-control selection-component" id="${ select_size_id }">
                            <option>XXS</option>
                            <option>XS</option>
                            <option>S</option>
                            <option>M</option>
                            <option>L</option>
                            <option>XL</option>
                        </select>
                    </div>
                    <div class="vertical-center-element">
                        <small>Quality</small>
                        <select class="form-control selection-component" id="${ select_quantity_id }">
                            <option>1</option>
                            <option>2</option>
                            <option>3</option>
                            <option>4</option>
                            <option>5</option>
                            <option>6</option>
                            <option>7</option>
                            <option>8</option>
                            <option>9</option>
                        </select>
                    </div>                   
                    <small id="${ small_article_price_id }">${ article.price }</small>
                </div>                        
            </div>
        `);

        $(`#${ select_size_id }`).on('change', '', function (e) {
            const n = 'select-size-'.length;
            const index = this.id.substr(n, this.id.length - 1);
            order.articles[index].size = this.value;
        });

        $(`#${ select_quantity_id }`).on('change', '', function (e) {
            const n = 'select-quantity-'.length;
            const index = this.id.substr(n, this.id.length - 1);
            order.articles[index].quantity = this.value;
        });

        i++;
    }
}

$(document).ready(function () {
    $('#next-button').click(function () {
        nextElement();
    });

    if (order.articles.length > 0) {
        show_articles();
    }
    else {
        $('#next-button').css('visibility', 'hidden');
    }
});

  