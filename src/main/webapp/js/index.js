
$(document).ready(function() {
        var isLogin = sessionStorage.getItem("userId");
        if (isLogin) {
            $("#register,#login").remove();
            $("#logout").css("display", "inline-block");
        } else {
            $("#logout").remove();
            $("#register,#login").css("display", "inline-block");
        }

// 退出登录
    $('#logout_btn').click(function() {
        $.ajax({
                url: '/users/logout',
                type: 'DELETE',
                data: null,
                dataType: 'json'
            }
        ).done(function(res) {
            if(res.logout) {
                sessionStorage.removeItem("userId");
                window.location = '/login';
            }
        }).fail(function(err) {
            alert("系统错误！");
        });
        return false;
    })
});

//读取cookies

function getCookie(name)
{
    var arr,reg=new RegExp("(^| )"+name+"=([^;]*)(;|$)");
    if(arr=document.cookie.match(reg))
        return unescape(arr[2]);
    else
        return null;
}
