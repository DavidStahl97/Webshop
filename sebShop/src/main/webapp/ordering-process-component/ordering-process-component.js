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
   }
];

let current_element = -1;

function nextElement() {
   console.log('next element');

   current_element++;
   const element = ordering_elements[current_element];

   if (current_element > 0) {
      const left_element = ordering_elements[current_element - 1];

      $(`#${ left_element.name }-icon`).removeClass(`${ left_element.icon_class }`);
      $(`#${ left_element.name }-icon`).addClass('fa-check-circle');
   }

   $('#ordering-process-container').load(`${ element.name }-component\\${ element.name }-component.html`);
}

$(document).ready(function () {
   nextElement();
});