$(document).ready(function() {
    $.ajax({
        type: "get",
        url: "/users/self",
        dataType: "json",
        success: function (data) {
            $("#name").append(data.number);
            $("#tel").append(data.phone);
            $("#role").append(data.role);
            $("#date").append(data.created_at);
        }
    })
})