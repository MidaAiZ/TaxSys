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
    });
    $('#confirm').click(function() {
        $.ajax({
            url: "users/" + sessionStorage.getItem("userId") + "/password?" + "oldPassword=" + $("input[name=oldPassword]").val()+ "&newPassword=" + $("input[name=newPassword]").val() ,
            type: "PUT",
            dataType: "json",
            success: function(res) {
            }
        })
        $.ajax({
            url: "users/" + sessionStorage.getItem("userId") + "/info?" + "&cellphone=" + $("input[name=number]").val() ,
            type: "PUT",
            dataType: "json",
            success: function(res) {
                if(res.user) {
                    alert("更改成功！")
                } else {
                    if(res.error==null)alert("更改成功！");
                    else alert(res.error);
                }
            }
        })
    })
})