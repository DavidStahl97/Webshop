var payment_options = [
    {
        name: 'Paypal',
        icon: 'fab fa-paypal'
    },
    {
        name: 'Credit Card',
        icon: 'far fa-credit-card'
    },
    {
        name: 'Klarna',
        icon: 'fab fa-cc-visa'
    },
    {
        name: 'Bitcoin',
        icon: 'fab fa-bitcoin'
    },
    {
        name: 'Invoice',
        icon: 'far fa-money-bill-alt'
    }
]

function load_payments() {
    $.ajax({
        url: 'http://localhost:8080/paymentServlet',
        data: {},
        type: 'GET',
        success: function (data) {
            const received_payment_options = JSON.parse(data);

            let i = 0;
            for (const payment of received_payment_options) {
                const payment_option = payment_options.find(x => x.name == payment);

                const button_id = `payment-button-${ i }`;
                payment_option.button_id = button_id;

                $('#payment-option-row').append(`
                    <div class="col">
                        <button type="button" class="btn btn-link" id="${ button_id }">
                            <i class="${ payment_option.icon } payment-button"></i>                            
                        </button>
                        <h3 class="text-center"><span class="badge badge-secondary">${ payment }</span></h3>
                    </div>               
                `);

                $(`#${ button_id }`).click(function () {
                    const payment_option = payment_options.find(x => x.button_id == this.id);
                    order.payment = payment_option.name;

                    nextElement();
                });

                i++;
            }
        }
    });
}

$(document).ready(function () {
    load_payments();
});