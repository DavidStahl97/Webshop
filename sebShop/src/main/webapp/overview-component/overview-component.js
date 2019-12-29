function show_articles_summary() {
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
    }
}

$(document).ready(function () {
    show_articles_summary();
});