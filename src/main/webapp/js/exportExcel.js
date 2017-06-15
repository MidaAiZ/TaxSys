/**
 * Created by Sinner on 2017/6/6.
 */
$(document).ready(function() {
    //excel导出
    $("#download").click(function() {
      exportLabType();
    })
})
function exportLabType(){
    var $form = $("<form action='incomes/exportExcel' method='POST'></form>");
    $form.append("<input name='taxId' value='taxId'>");
    $form.append("<input name='inType' value='inType'>");
    $form.append("<input name='money' value='money'>");
    $form.append("<input name='created_at' value='created_at'>");
    $form.submit();
}
