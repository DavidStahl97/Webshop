$(document).ready(function () {

    $('#next-button').click(function () {
        nextElement();
    });

    $.ajax({
        url: 'http://localhost:8080/shopItemsServlet',
        data: {},
        type: 'GET',
        success: function (data) {
            const products = JSON.parse(data);

            for (let i = 0; i < 5; i++) {
                $("#product-list-group").append(`
                    <div class="list-group-item">
                        <div class="d-flex w-100 justify-content-between">
                            <img src="http://localhost:8080/${ products[i].imgPath }" class="product-image"/>
                            <h5 class="mb-1">${ products[i].id }</h5>
                            <small>${ products[i].price }</small>
                        </div>                        
                    </div>
                `);
            }
        }
    });
});