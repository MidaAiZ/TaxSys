/**
 * Created by Vodka on 2017/5/30.
 */
$(document).ready(function() {

    //进项选择option
    var _select1 = $("select[name=item1]");
    setFormone(_select1);
    $(_select1).on("change", function() {
       setFormone($(this));
    });

    //销项选择option
    var _select2 = $("select[name=item2]");
    setFormtwo(_select2);
    $(_select2).on("change", function() {
        setFormtwo($(this));
    });


    //进项导入反馈
    $('#import-1_btn').click(function() {
        $.ajax({
                url: '/incomes/createIncome',
                data: $('#form1-1').serialize(),
                type: 'post',
                dataType: 'json'
            }
        ).done(function(res) {
            if(res.income) {
                $("#uploadModal").find("#upload-tip").text("导入成功！").siblings("#f-loading").hide().end().end().modal("show");
            } else {
                $("#uploadModal").find("#upload-tip").text(res.error).siblings("#f-loading").hide().end().end().modal("show");
            }
        }).fail(function(err) {
            $("#uploadModal").find("#upload-tip").text("导入失败！").siblings("#f-loading").hide().end().end().modal("show");
        });
        return false;
    })
    $('#form1-1').submit(function() {
        return false
    })

    //销项导入反馈
    $('#import-2_btn').click(function() {
        $.ajax({
                url: '/outcomes/createOutcome',
                data: $('#form2-1').serialize(),
                type: 'post',
                dataType: 'json'
            }
        ).done(function(res) {
            if(res.outcome) {
                $("#uploadModal").find("#upload-tip").text("导入成功！").siblings("#f-loading").hide().end().end().modal("show");
            } else {
                $("#uploadModal").find("#upload-tip").text(res.error).siblings("#f-loading").hide().end().end().modal("show");
            }
        }).fail(function(err) {
            $("#uploadModal").find("#upload-tip").text("导入失败！").siblings("#f-loading").hide().end().end().modal("show");
        });
        return false;
    })
    $('#form2-1').submit(function() {
        return false
    })
})

//进项变换option
function setFormone(_ele) {
    var isPoi = _ele.val();
    // console.log(isPoi);
    if (isPoi==0) {
        $("#form1-1").css("display", 'none');
        $("#form1-2").css("display", "inline-block");
    } else {
        $("#form1-2").css("display", 'none');
        $("#form1-1").css("display", "inline-block");
        $("#result1").css("display", 'none');
    }
}

//销项变换option
function setFormtwo(_ele) {
    var isPoi = _ele.val();
    // console.log(isPoi);
    if (isPoi==0) {
        $("#form2-1").css("display", 'none');
        $("#form2-2").css("display", "inline-block");
    } else {
        $("#form2-2").css("display", 'none');
        $("#form2-1").css("display", "inline-block");
        $("#result2").css("display", 'none');
    }
}




