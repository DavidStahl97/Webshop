let ordering_elements = [
   {
      name: 'product-list',
      icon_class: 'fa-cart-arrow-down',
   },
   {
      name: 'payment',
      icon_class: 'fa-money-check-alt'
   },
   {
      name: 'overview',
      icon_class: 'fa-eye'
   },
   {
      name: 'complete-order'
   }
];

let current_element = -1;

function nextElement() {
   current_element++;
   const element = ordering_elements[current_element];

   if (current_element == 0 || current_element == ordering_elements.length - 1) {
      $('#back-button').css('visibility', 'hidden');
   }
   else {
      $('#back-button').css('visibility', 'visible');
   }

   if (current_element > 0) {
      const left_element = ordering_elements[current_element - 1];

      $(`#${ left_element.name }-icon`).removeClass(`${ left_element.icon_class }`);
      $(`#${ left_element.name }-icon`).addClass('fa-check-circle');
   }

   $('#ordering-process-container').load(`${ element.name }-component\\${ element.name }-component.html`);
}

function on_back_button_click() {
   const left_element = ordering_elements[current_element - 1];

   $(`#${ left_element.name }-icon`).removeClass('fa-check-circle');
   $(`#${ left_element.name }-icon`).addClass(`${ left_element.icon_class }`);

   current_element = current_element - 2;
   nextElement();
}

$(document).ready(function () {
   $('#back-button').click(function () { on_back_button_click() });
   nextElement();
});