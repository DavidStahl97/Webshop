$(document).ready(function () {

    $('#next-button').click(function () {
        $('#process-list-icon').removeClass('fa-cart-arrow-down');
        $('#process-list-icon').addClass('fa-check-circle');
        
        $('#ordering-process-container').load('payment-component/payment-component.html');
    });

    $.ajax({
        url: 'http://localhost:8080/shopItemsServlet',
        data: {},
        type: 'GET',
        success: function (data) {
            var products = JSON.parse(data);

            for (var i = 0; i < 5; i++) {
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