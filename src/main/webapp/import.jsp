<!DOCTYPE html>
<!--[if IE 6]>
<html id="ie6" class="ancient-ie old-ie no-js bit-html" dir="ltr" lang="zh-CN">
<![endif]-->
<!--[if IE 7]>
<html id="ie7" class="ancient-ie old-ie no-js bit-html" dir="ltr" lang="zh-CN">
<![endif]-->
<!--[if IE 8]>
<html id="ie8" class="old-ie no-js bit-html" dir="ltr" lang="zh-CN">
<![endif]-->
<!--[if IE 9]>
<html id="ie9" class="old-ie9 no-js bit-html" dir="ltr" lang="zh-CN">
<![endif]-->
<!--[if !(IE 6) | !(IE 7) | !(IE 8) ]><!-->
<html class="no-js bit-html" dir="ltr" lang="zh-CN">
<!--<![endif]-->
<head>
    <title>企业增值税发票数据分析系统 | 导入</title>
    <!--[if lt IE 9]>
    <![endif]-->
    <!--[if lt IE 9]>
    <style type="text/css" id="static-stylesheet"></style>
    <link rel="stylesheet"
          href="http://57ea239cecea4.t73.qifeiye.com/qfy-content/cache/scripts/57ec8d9b352f33adc09c11ca94f4b7b0.css"
          type="text/css" media="all"/>
    <!-- Cache! -->
    <link rel="stylesheet" href="css/style1.css" type="text/css" media="screen" />
    <link rel="stylesheet" href="css/style2.css" type="text/css" media="all" />
    <link rel='stylesheet' id='dt-main-css'  href='css/style3.css' type='text/css' media='all' />
    <link rel='stylesheet' id='dt-custom-less-css'  href='css/style4.css' type='text/css' media='all' />
    <link rel='stylesheet' id='dt-bit-custom-less-css'  href='css/style5.css' type='text/css' media='all' />
    <link rel='stylesheet' id='qfy_dynamic_css-css'  href='css/style6.css' type='text/css' media='all' />
    <link rel="stylesheet" href="css/style7.css" type="text/css" media="all" />
    <link rel="stylesheet" href="css/uploader.css">
    <link rel="stylesheet" href="css/context.css">
    <!-- Cache! -->
    <style>
        .qfyuser-label label {
            float: left;
            margin-top: 5px;
        }
        .list-tabs li.active {
            background: #eee;
        }
    </style>
    <script src="http://apps.bdimg.com/libs/jquery/2.1.4/jquery.min.js"></script>
    <script src="js/index.js"></script>
    <script src="js/echarts.min.js"></script>
    <script src="js/exportPOI.js"></script>
    <script src="js/import.js"></script>
    <script src="js/dataOpt.js"></script>
    <script src="js/paginate.js"></script>
    <script src="js/context.js"></script>

</head>

<body>
<div id="page" class=' breackall wide '>
    <!-- left, center, classical, classic-centered -->
    <!-- !Header -->
    <header id="header" class="logo-left-right headerPM menuPosition transparent" role="banner">
        <!-- class="overlap"; class="logo-left", class="logo-center", class="logo-classic" -->
        <div class="wf-wrap">
            <div class="wf-table">
                <div id="branding" class="wf-td bit-logo-bar" style="">
                    <a class="bitem logo small" style="display: table-cell;" href="index.jsp">
                        <span class="logospan">
                            <img class="preload-me" src="image/Aisino_1.jpg" width="675" height="220" alt=""/>
                        </span>
                    </a>
                </div>
                <!-- !- Navigation -->
                <nav id="navigation" class="wf-td" bitDataAction="site_menu_container"
                     bitDataLocation="primary">
                    <ul id="main-nav" data-st="1" data-sp="1" data-fh="0" data-mw="0" data-lh="40"
                        class="mainmenu fancy-rollovers wf-mobile-hidden bit-menu-default underline-hover"
                        data-bit-menu=underline-hover data-bit-float-menu=underline-hover>
                        <li class=" menu-item menu-item-type-post_type menu-item-object-page current-menu-item page_item page-item-2160 current_page_item bit-menu-post-id-2160 menu-item-2319 ">
                            <a href="index.jsp"><span>首页</span></a></li>
                        <li class=" menu-item menu-item-type-post_type menu-item-object-page bit-menu-post-id-7010 menu-item-7011 act first">
                            <a href="import.jsp"><span>导入</span></a></li>
                        <li class=" menu-item menu-item-type-post_type menu-item-object-page bit-menu-post-id-8330 menu-item-15097">
                            <a href="require.jsp"><span>查询</span></a></li>
                        <li class=" menu-item menu-item-type-post_type menu-item-object-page bit-menu-post-id-9556 menu-item-9557">
                            <a href="count.jsp"><span>月度统计</span></a></li>
                        <li class=" menu-item menu-item-type-post_type menu-item-object-page bit-menu-post-id-8115 menu-item-8116">
                            <a href="chart.jsp"><span>年度报表</span></a></li>
                        <li class=" menu-item menu-item-type-post_type menu-item-object-page bit-menu-post-id-8116 menu-item-8117">
                            <a href="predict.jsp"><span>分析预测</span></a></li>
                        <li class=" menu-item menu-item-type-post_type menu-item-object-page bit-menu-post-id-8117 menu-item-8118">
                            <a href="calculateTax.jsp"><span>计算增值税</span></a></li>
                        <li class=" menu-item menu-item-type-post_type menu-item-object-page bit-menu-post-id-17296 menu-item-17297">
                            <a href="help.jsp"><span>帮助</span></a></li>
                    </ul>

                    <a href="#show-menu" data-padding='' data-top='8' data-right='8' rel="nofollow" id="mobile-menu"
                       style="display:none;" class="glyphicon glyphicon-icon-align-justify dropCenterStyle center">
                        <span class="menu-open  phone-text">首页</span>
                        <span class="menu-close">关闭</span>
                        <span class="menu-back">返回上一级</span>
                        <span class="wf-phone-visible">&nbsp;</span>
                    </a>

                </nav>
                <div style="display:none;" id="main-nav-slide">
                    <div class="main-nav-slide-inner" data-class="align_center">
                        <div class="floatmenu-bar-right bit_widget_more" bitdatamarker="bitHeader-3"
                             bitdataaction="site_fix_container" bitdatacolor="white">
                        </div>
                    </div>
                </div>

                <div class="wf-td assistive-info " id="assistive-info-unlogin" role="complementary" style="">
                    <div class="top-bar-right right bit_widget_more" bitdatamarker="bitHeader-2"
                         bitdataaction="site_fix_container" bitdatacolor="white" style="">
                        <div id="register" style="margin-top:0px;margin-bottom:0px; display: none;"
                             class="mobileHidden headerWidget_1 widget_text site_tooler">
                            <div class="bitWidgetFrame ">
                                <div style="margin-top:0px;margin-bottom:0px;padding-top:0px;padding-bottom:0px;padding-right:0px;padding-left:0px;"
                                     m-padding="0px 0px 0px 0px" p-padding="0px 0px 0px 0px" css_animation_delay="0"
                                     qfyuuid="0" class="qfy-element vc_btn3-container vc_btn3-center">
                                    <a onmouseleave="this.style.borderColor='#61b0ff'; this.style.backgroundColor='#61b0ff'; this.style.color='#ffffff';"
                                       onmouseenter="this.style.backgroundColor='transparent'; this.style.borderColor='#61b0ff'; this.style.color='#61b0ff';"
                                       style="font-family:微软雅黑; font-size:14px; border-color:#61b0ff; background-color:#61b0ff; color:#ffffff;"
                                       class="vc_general vc_btn3 vc_btn3-size-sm vc_btn3-shape-round vc_btn3-style-qfy-custom"
                                       href="register.jsp" target="">注册</a>
                                </div>
                            </div>
                        </div>
                        <div id="login" style="margin-top:0px;margin-bottom:0px; display: none;"
                             class="mobileHidden headerWidget_1 widget_text site_tooler">
                            <div class="bitWidgetFrame ">
                                <div style="margin-top:0px;margin-bottom:0px;padding-top:0px;padding-bottom:0px;padding-right:0px;padding-left:0px;"
                                     m-padding="0px 0px 0px 0px" p-padding="0px 0px 0px 0px" css_animation_delay="0"
                                     qfyuuid="0" class="qfy-element vc_btn3-container vc_btn3-center">
                                    <a  onmouseleave="this.style.borderColor='#61b0ff'; this.style.backgroundColor='transparent'; this.style.color='#61b0ff';"
                                        onmouseenter="this.style.backgroundColor='#61b0ff'; this.style.borderColor='#61b0ff'; this.style.color='#ffffff';"
                                        style="font-family:微软雅黑; font-size:14px; border-color:#61b0ff; background-color:transparent; color:#61b0ff;"
                                        class="vc_general vc_btn3 vc_btn3-size-sm vc_btn3-shape-round vc_btn3-style-qfy-custom"
                                        href="login.jsp" target="_self">登录</a>
                                </div>
                            </div>
                        </div>
                        <div id="logout" style="margin-top:0px;margin-bottom:0px; display: none;"
                             class="mobileHidden headerWidget_1 widget_text site_tooler">
                            <div class="bitWidgetFrame ">
                                <div style="margin-top:0px;margin-bottom:0px;padding-top:0px;padding-bottom:0px;padding-right:0px;padding-left:0px;"
                                     m-padding="0px 0px 0px 0px" p-padding="0px 0px 0px 0px" css_animation_delay="0"
                                     qfyuuid="0" class="qfy-element vc_btn3-container vc_btn3-center">
                                    <a id="logout_btn"  onmouseleave="this.style.borderColor='#61b0ff'; this.style.backgroundColor='transparent'; this.style.color='#61b0ff';"
                                       onmouseenter="this.style.backgroundColor='#61b0ff'; this.style.borderColor='#61b0ff'; this.style.color='#ffffff';"
                                       style="font-family:微软雅黑; font-size:14px; padding-left:22px;padding-right:22px; padding-top:6px;padding-bottom:6px; border-width:1px; border-color:#61b0ff; background-color:transparent; color:#61b0ff;"
                                       class="vc_general vc_btn3 vc_btn3-size-sm vc_btn3-shape-round vc_btn3-style-qfy-custom"
                                    >退出</a>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <!-- #branding -->
        </div>
        <!-- .wf-wrap -->
    </header>
    <!-- #masthead -->
</div><br><br>
<link rel="stylesheet" href="css/bootstrap.min.css">
<script src="js/bootstrap.min.js"></script>
<div class="file-box" style="text-align: center;margin-top: 0px">
    <div class="container">
        <ul class="nav nav-tabs">
            <li class="active"><a data-toggle="tab" href="#home">近期导入的数据</a></li>
            <li><a data-toggle="tab" href="#up-income">导入进项数据</a></li>
            <li><a data-toggle="tab" href="#up-outcome">导入销项数据</a></li>
        </ul>
        <div class="tab-content">
            <div id="home" class="tab-pane fade in active">
                <div class="inner-tab">
                    <ul class="nav list-tabs">
                        <li style="float: right;"><a data-toggle="tab" href="#outcomeList" style="float: right;">近期销项数据</a></li>
                        <li class="active" style="float: right;"><a data-toggle="tab" href="#incomeList">近期进项数据</a></li>
                    </ul>
                    <div class="list-tab-content">
                        <div id="incomeList">
                            <div class="row">
                                <div class="col-lg-10 col-lg-offset-1 col-md-12">
                                    <br>
                                    <table class="table table-condensed table-striped" data-role="recent-list" id="recent-table-in">
                                        <thead>
                                            <tr>
                                                <td width="20%">发票号</td>
                                                <td width="20%">进项类型</td>
                                                <td width="20%">金额</td>
                                                <td width="20%">进项日期</td>
                                                <td width="20%">导入时间</td>
                                            </tr>
                                        </thead>
                                        <tbody>
                                        </tbody>
                                    </table>
                                    <nav aria-label="Page navigation">
                                        <ul class="pagination pagination-sm incomes" id="in-page">

                                        </ul>
                                    </nav>
                                </div>
                            </div>
                        </div>
                        <div id="outcomeList" style="display: none;">
                            <div class="row">
                                <div class="col-lg-10 col-lg-offset-1 col-md-12">
                                    <br>
                                    <table class="table table-condensed table-striped" data-role="recent-list" id="recent-table-out">
                                        <thead>
                                        <tr>
                                            <td width="20%">发票号</td>
                                            <td width="20%">销项类型</td>
                                            <td width="20%">金额</td>
                                            <td width="20%">进项日期</td>
                                            <td width="20%">导入时间</td>
                                        </tr>
                                        </thead>
                                        <tbody>

                                        </tbody>
                                    </table>
                                    <nav aria-label="Page navigation">
                                        <ul class="pagination pagination-sm outcomes" id="out-page">

                                        </ul>
                                    </nav>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <script>
                $(function() {
                    $(".list-tabs").on("click", "a", function() {
                        var _this = $(this);
                        _this.toggleClass("active").siblings().toggleClass("active");
                        $(_this.attr("href")).show().siblings().hide();
                    })
                })
            </script>
            <div id="up-income" class="tab-pane fade in"><br>
                <div class="require-box" style="text-align: center; margin: auto; display: inline-block; float: right;">
                    <form action="" method="post" enctype="multipart/form-data" style=";float:left">
                        <label style="display: block">请选择导入方式</label>
                        <select name="item1" >
                            <option value="0">excel导入</option>
                            <option value="1">手动输入</option>
                        </select>
                    </form>
                </div>
                <div>
                    <%--手动上传--%>
                    <form  id="form1-1" action="/incomes/createIncome" method="post" style="margin: auto; max-width: 400px">
                        <div class='qfyuser-field qfyuser-field-username_or_email ' data-key='username_or_email'>
                            <div class='qfyuser-label'>
                                <label for='tax1-1'>发票号:</label>
                                <input type='text' class="form-control" placeholder='请输入发票号' name='taxId' id='tax1-1' value="" placeholder='' data-ajaxcheck='' data-help='' data-label='用户名或者邮箱' data-placeholder='' data-_builtin='1' data-hidden='0' data-hideable='0' data-html='0' data-locked='0' data-private='0' data-required='1' data-type='text' data-woo='0'/>
                            </div>
                        </div>
                        <div class="qfyuser-clear"></div>
                        <div class='qfyuser-field qfyuser-field-user_pass ' data-key='user_pass'>
                            <div class='qfyuser-label'>
                                <label for='kind1-1'>品种类:</label>
                                <input type='text'  class="form-control" placeholder='请输品种类' name='inType' id='kind1-1' value='' placeholder='' data-ajaxcheck='' data-placeholder='' data-_builtin='1' data-hidden='0' data-hideable='0' data-html='0' data-locked='0' data-private='0' data-required='1' data-type='password' data-woo='0'/>
                            </div>
                        </div>
                        <div class="qfyuser-clear"></div>
                        <div class='qfyuser-field qfyuser-field-user_pass ' data-key='user_pass'>
                            <div class='qfyuser-label'>
                                <label for='money1-1'>进项额:</label>
                                <input type='text' class="form-control" placeholder='请输入进项额' name='money' id='money1-1' value='' placeholder='' data-ajaxcheck='' data-placeholder='' data-_builtin='1' data-hidden='0' data-hideable='0' data-html='0' data-locked='0' data-private='0' data-required='1' data-type='password' data-woo='0'/>
                            </div>
                        </div>
                        <div class="qfyuser-clear"></div>
                        <div class='qfyuser-field qfyuser-field-user_pass ' data-key='user_pass'>
                            <div class='qfyuser-label'>
                                <label for='time1-1'>日期：</label>
                                <input id="time1-1"  class="form-control" name="taxDate" type="date" value="2017-01-01"/>
                            </div>
                        </div><br>
                        <input id="import-1_btn" class="btn-xs btn-primary form-control" type="submit" value="提交"/>
                    </form>
                    <%--excel上传--%>
                    <div>
                        <form id="form1-2" class="form-horizontal" action="" method="post" enctype="multipart/form-data">
                            <div class="field" class="margin: auto;">
                                <input type="file" name="file"  style="width:0px;height:0px;" id="uploadEventFile1">
                                <button class="btn btn-success btn-xs" id="uploadEventBtn1" style="height:35px"  type="button" >选择文件</button>
                                <input id="uploadEventPath1"  disabled="disabled"  type="text" placeholder="请选择excel表" style="border: 1px solid #e6e6e6; height: 35px;width: 200px;margin-top: 10px;" >
                            </div>
                            <br>
                            <button type="button" style="width: 100%;" class="btn btn-success btn-sm"  onclick="exportIn.uploadBtn()" >上传</button>
                        </form>
                    </div>
                </div>
                <div id="result1" class="result" style="display:none;margin-left:17%;width: 60%;text-align: center">
                    <table class="table table-striped" data-type="income"  style="margin-top: 10px">
                        <thead>
                        <tr>
                            <td width="20%">发票号</td>
                            <td width="20%">类型</td>
                            <td width="15%">金额</td>
                            <td width="20%">日期</td>
                            <td width="20%">导入结果</td>
                        </tr>
                        </thead>
                        <tbody class="table-hover">
                        </tbody>
                    </table>
                    <div class="operator" style="display: none;">
                        <div class="field" style="float: right;">
                            <a href="javascript: void(0)" data-role="force-btn" data-type="income" data-url="incomes/createIncomeForce" class="btn-danger btn-sm" style="display: none;">覆盖原进项</a>
                        </div>
                    </div>
                </div>
            </div>
            <div id="up-outcome" class="tab-pane fade"><br>
                <div class="require-box" style="text-align: center; margin: auto; display: inline-block; float: right;">
                    <form action="" method="post" enctype="multipart/form-data" style=";float:left">
                        <label style="display: block">请选择导入方式</label>
                        <select name="item2" >
                            <option value="0">excel导入</option>
                            <option value="1">手动输入</option>
                        </select>
                    </form>
                </div>
                <div>
                    <%--手动上传--%>
                    <form  id="form2-1" action="/incomes/createIncome" method="post" style="margin: auto; max-width: 400px;">
                        <div class='qfyuser-field qfyuser-field-username_or_email ' data-key='username_or_email'>
                            <div class='qfyuser-label'>
                                <label for='tax2-1'>发票号:</label>
                                <input type='text' class="form-control" placeholder='请输入发票号' name='taxId' id='tax2-1' value="" placeholder='' data-ajaxcheck='' data-help='' data-label='用户名或者邮箱' data-placeholder='' data-_builtin='1' data-hidden='0' data-hideable='0' data-html='0' data-locked='0' data-private='0' data-required='1' data-type='text' data-woo='0'/>
                            </div>
                        </div>
                        <div class="qfyuser-clear"></div>
                        <div class='qfyuser-field qfyuser-field-user_pass ' data-key='user_pass'>
                            <div class='qfyuser-label'>
                                <label for='kind2-1'>品种类:</label>
                                <input type='text' class="form-control" placeholder='请输品种类' name='outType' id='kind2-1' value='' placeholder='' data-ajaxcheck='' data-placeholder='' data-_builtin='1' data-hidden='0' data-hideable='0' data-html='0' data-locked='0' data-private='0' data-required='1' data-type='password' data-woo='0'/>
                            </div>
                        </div>
                        <div class="qfyuser-clear"></div>
                        <div class='qfyuser-field qfyuser-field-user_pass ' data-key='user_pass'>
                            <div class='qfyuser-label'>
                                <label for='money2-1'>进项额:</label>
                                <input type='text' class="form-control" placeholder='请输入进项额' name='money' id='money2-1' value='' placeholder='' data-ajaxcheck='' data-placeholder='' data-_builtin='1' data-hidden='0' data-hideable='0' data-html='0' data-locked='0' data-private='0' data-required='1' data-type='password' data-woo='0'/>
                            </div>
                        </div>
                        <div class="qfyuser-clear"></div>
                        <div class='qfyuser-field qfyuser-field-user_pass ' data-key='user_pass'>
                            <div class='qfyuser-label'>
                                <label for='time2-1'>日期：</label>
                                <input id="time2-1" class="form-control" name="taxDate" type="date" value="2017-01-01"/>
                            </div>
                        </div><br>
                        <input id="import-2_btn" class="btn-xs btn-primary form-control" type="submit" value="提交"/>
                    </form>
                    <%--excel上传--%>
                        <div>
                            <form id="form2-2" class="form-horizontal" action="" method="post" enctype="multipart/form-data">
                                <div class="field" style="margin: auto;">
                                    <input type="file" name="file"  style="width:0px;height:0px;" id="uploadEventFile2">
                                    <button class="btn btn-success btn-xs" id="uploadEventBtn2" style="height:35px"  type="button" >选择文件</button>
                                    <input id="uploadEventPath2"  disabled="disabled"  type="text" placeholder="请选择excel表" style="border: 1px solid #e6e6e6; height: 35px;width: 200px;margin-top: 10px;" >
                                </div>
                                <br>
                                <button type="button" style="width: 100%;" class="btn btn-success btn-sm"  onclick="exportOut.uploadBtn()" >上传</button>
                            </form>
                        </div>
                </div>
                <div id="result2" class="result" style="display:none;margin-left:17%;width: 60%;text-align: center">
                    <table class="table table-striped" data-type="outcome" style="margin-top: 10px;">
                        <thead>
                        <tr>
                            <td width="20%">发票号</td>
                            <td width="20%">类型</td>
                            <td width="15%">金额</td>
                            <td width="20%">日期</td>
                            <td width="20%">导入结果</td>
                        </tr>
                        </thead>
                        <tbody class="table-hover">
                        </tbody>
                    </table>
                    <div class="operator" style="display: none;">
                        <div class="field" style="float: right;">
                            <a href="javascript: void(0)" data-role="force-btn" data-type="outcome"  data-url="outcomes/createOutcomeForce" class="btn-danger btn-sm"  style="display: none;">覆盖原销项</a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

    <!-- Modal -->
    <div class="modal fade" id="uploadModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
        <div class="modal-dialog modal-sm" role="document">
            <div class="modal-content">
                <div class="modal-body">
                    <p id="upload-tip">上传中...</p>
                    <div id="f-loading">
                        <div class="spinner">
                            <div class="rect1"></div>
                            <div class="rect2"></div>
                            <div class="rect3"></div>
                            <div class="rect4"></div>
                            <div class="rect5"></div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</body>
</html>