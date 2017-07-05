$(document).ready(function(){

    $.ajax({
        type: "get",
        url: "/users/self",
        dataType: "json",
        success: function (data) {
            var list = data.incomeList;
            $.each(list, function (i, p) {
                $("#name").append(p.name);
                $("#tel").append(p.tel);
                $("#role").append(p.role);
                $("#date").append(p.date);
            });
        }
    })
})