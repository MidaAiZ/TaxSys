/**
 * Created by Vodka on 2017/5/29.
 */
/**
 * Created by Vodka on 2017/5/29.
 */
$(document).ready(function() {

    $('#login_btn').click(function() {
        $.ajax({
                url: '/users/login',
                data: $('#login-form').serialize(),
                type: 'post',
                dataType: 'json'
            }
        ).done(function(res) {
            if(res.user) {
                sessionStorage.setItem("userId",res.user.id);
                window.location = 'index.jsp'
            } else {
                alert(res.error);
            }
        }).fail(function(err) {
            alert("登录失败！");
        });
        return false;
    })

    $('#login-form').submit(function() {
        return false
    })
});


