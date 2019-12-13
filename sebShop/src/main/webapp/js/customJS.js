//include your JavaScript here


//Example Ajax Call on Hello world Servlet
var date = new Date();
$.ajax({
    url: '/helloServlet',
    data: { "date": date},
    type: 'GET',
    success: function (data) {
        document.body.innerHTML = "<h1>"+data+"</h1>";
    }
});