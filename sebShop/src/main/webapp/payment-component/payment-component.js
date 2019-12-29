function next() {
    $('#money-check-icon').removeClass('fa-money-check-alt');
    $('#money-check-icon').addClass('fa-check-circle');

    $('#ordering-process-container').load('overview-component/overview-component.html');
}

$(document).ready(function () {

    $('#money-button').click(function () {
        next();
    });

    $('#visa-button').click(function () {
        next();
    });

    $('#paypal-button').click(function () {
        next();
    });

});