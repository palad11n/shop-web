window.onload = function() {
   $(".btn-status").click((e) => {
    var btn = $(e.currentTarget);
    var orderId = btn.attr("data-order-id");
    btn.attr("disabled", "disabled");

    $.post("/status/" + orderId, (data) => {
       if (data) {
             btn.text( "ok");
             btn.removeClass("btn-secondary");
             btn.addClass("btn-danger");
        } else{ btn.text( "not");}
   });
};