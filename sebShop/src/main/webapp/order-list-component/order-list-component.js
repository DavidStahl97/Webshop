function createOrderView(data) {    const orders = JSON.parse(data);    let i = 0;    for(const order of orders) {        const headingId = `heading-${ i }`;        const collapsedId = `collapse-${ i }`;        const listGroupId = `order-list-group-${ i }`;        $('#accordion').append(`            <div class="card">                <div class="card-header" id="${ headingId }">                    <h5 class="mb-0">                        <button class="btn btn-link" data-toggle="collapse" data-target="#${ collapsedId }" aria-expanded="true" aria-controls="${ collapsedId }">                            ${ order.date }                        </button>                        <span style="float:right"><h5>${ order.totalprice }$</h5></span>                    </h5>                </div>                        <div id="${ collapsedId }" class="collapse" aria-labelledby="${ headingId }" data-parent="#accordion">                    <div class="card-body">                        <div id="${ listGroupId }">                        </div>                    </div>                </div>            </div>                   `);        for(const article of order.articles) {            $(`#${ listGroupId }`).append(`                <div class="list-group-item">                    <div class="d-flex w-100 justify-content-between">                        <img src="http://localhost:8080/images/shopItems/${ article.itemName.substring(0, 3) }.png" class="article-image"/>                        <h5 class="mb-1 vertical-center-element">${ article.itemName }</h5>                        <div class="vertical-center-element">                            <p>Size: ${ article.size }</p>                        </div>                        <div class="vertical-center-element">                            <p>Quantity: ${ article.quantity }</p>                        </div>                                           <p>${ article.price * article.quantity }</p>                    </div>                                        </div>            `);        }        i++;    }}$(document).ready(function () {    $.ajax({        url: 'http://localhost:8080/ordersServlet?user=david',        contentType: 'application/json',        type: 'GET',        success: function (data) {            createOrderView(data);        }    });});