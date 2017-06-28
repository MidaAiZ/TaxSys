<%--
  Created by IntelliJ IDEA.
  User: Vodka
  Date: 2017/6/27
  Time: 13:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
<!--[if !(IE 6) | !(IE 7) | !(IE 8)  ]><!-->
<html class="no-js bit-html" dir="ltr" lang="zh-CN">
<!--<![endif]-->
<head>
    <!-- for 360 -->
    <script src="js/jquery-3.2.1.min.js"></script>
    <script src="js/index.js"></script>
    <meta name="renderer" content="webkit">
    <meta name="applicable-device" content="pc,mobile"> <!-- for baidu -->
    <meta http-equiv="Cache-Control" content="no-transform" /> <!-- for baidu -->
    <meta name="MobileOptimized" content="width"/><!-- for baidu -->
    <meta name="HandheldFriendly" content="true"/><!-- for baidu -->

    <!-- start of customer header -->
    <!-- end of customer header -->
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <script src="js/echarts.min.js"></script>
    <title>企业增值税发票数据分析系统 | 帮助</title>
    <link rel="profile" href="http://gmpg.org/xfn/11" />
    <link rel="pingback" href="http://57ea239cecea4.t73.qifeiye.com/xmlrpc.php" />
    <!--[if lt IE 9]>
    <script src="http://57ea239cecea4.t73.qifeiye.com/FeiEditor/bitSite/js/html5shiv.min.js"></script>
    <![endif]-->
    <!--[if lt IE 9]>
    <script src="http://57ea239cecea4.t73.qifeiye.com/FeiEditor/bitSite/js/respond.min.js"></script>
    <![endif]-->
    <style type="text/css" id="static-stylesheet"></style>

    <link rel="stylesheet" href="css/style1.css" type="text/css" media="screen" />
    <link rel="stylesheet" href="css/style2.css" type="text/css" media="all" />
    <link rel='stylesheet' id='dt-main-css' href='css/style3.css' type='text/css' media='all' />
    <link rel='stylesheet' id='dt-custom-less-css' href='css/style4.css' type='text/css' media='all' />
    <link rel='stylesheet' id='dt-bit-custom-less-css' href='css/style5.css' type='text/css' media='all' />
    <link rel='stylesheet' id='qfy_dynamic_css-css' href='css/style6.css' type='text/css' media='all' />
    <link rel="stylesheet" href="css/style7.css" type="text/css" media="all" />

    <style type='text/css'>
        .ppstart{
            background:transparent !important;
        }
    </style>
    <script type='text/javascript'>
        /* <![CDATA[ */
        /* iphorm-plugin */
        var iphormL10n = {"error_submitting_form":"\u5728\u63d0\u4ea4\u8868\u5355\u65f6\u6709\u9519\u8bef","swfupload_flash_url":"http:\/\/57ea239cecea4.t73.qifeiye.com\/qfy-includes\/js\/swfupload\/swfupload.swf","swfupload_upload_url":"http:\/\/57ea239cecea4.t73.qifeiye.com\/?iphorm_swfupload=1","swfupload_too_many":"\u961f\u5217\u4e2d\u7684\u6587\u4ef6\u592a\u591a\u4e86","swfupload_file_too_big":"\u6587\u4ef6\u592a\u5927\u4e86","swfupload_file_empty":"\u4e0d\u80fd\u4e0a\u4f20\u7a7a\u6587\u4ef6","swfupload_file_type_not_allowed":"\u8be5\u6587\u4ef6\u7684\u7c7b\u578b\u662f\u4e0d\u5141\u8bb8\u4e0a\u4f20\u7684","swfupload_unknown_queue_error":"\u672a\u77e5\u961f\u5217\u9519\u8bef\uff0c\u8bf7\u7a0d\u5019\u518d\u8bd5","swfupload_upload_error":"\u4e0a\u4f20\u9519\u8bef","swfupload_upload_failed":"\u4e0a\u4f20\u5931\u8d25","swfupload_server_io":"\u670d\u52a1\u5668IO\u9519\u8bef","swfupload_security_error":"\u5b89\u5168\u9519\u8bef","swfupload_limit_exceeded":"\u4e0a\u4f20\u8d85\u8fc7\u9650\u5236","swfupload_validation_failed":"\u9a8c\u8bc1\u5931\u8d25","swfupload_upload_stopped":"\u4e0a\u4f20\u88ab\u7ec8\u6b62","swfupload_unknown_upload_error":"\u6587\u4ef6\u4e0a\u4f20\u88ab\u610f\u5916\u7ec8\u6b62","plugin_url":"http:\/\/57ea239cecea4.t73.qifeiye.com\/qfy-content\/plugins\/qfy_form","preview_no_submit":"\u5728\u9884\u89c8\u6a21\u5f0f\u4e0b\u4e0d\u80fd\u63d0\u4ea4\u8868\u5355"};
        /* dt-plugins */
        var dtLocal = {"passText":"\u67e5\u770b\u8fd9\u4e2a\u52a0\u5bc6\u8d44\u8baf\uff0c\u8bf7\u5728\u4e0b\u9762\u8f93\u5165\u5bc6\u7801\uff1a","moreButtonAllLoadedText":"\u5168\u90e8\u5df2\u52a0\u8f7d","postID":"2160","ajaxurl":"http:\/\/57ea239cecea4.t73.qifeiye.com\/admin\/admin-ajax.php","contactNonce":"f1561b484f","ajaxNonce":"969854a037","pageData":{"type":"page","template":"page","layout":null},"themeSettings":{"smoothScroll":"on"}};
        /* thickbox */
        var thickboxL10n = {"next":"\u4e0b\u4e00\u5f20 >","prev":"< \u4e0a\u4e00\u5f20","image":"\u56fe\u7247","of":"\/","close":"\u5173\u95ed","noiframes":"\u8fd9\u4e2a\u529f\u80fd\u9700\u8981iframe\u7684\u652f\u6301\u3002\u60a8\u53ef\u80fd\u7981\u6b62\u4e86iframe\u7684\u663e\u793a\uff0c\u6216\u60a8\u7684\u6d4f\u89c8\u5668\u4e0d\u652f\u6301\u6b64\u529f\u80fd\u3002","loadingAnimation":"\/\/fast.qifeiye.com\/FeiEditor\/bitSite\/images\/preloader.gif"};

        /* ]]> */
    </script>
    <link rel="EditURI" type="application/rsd+xml" title="RSD" href="http://57ea239cecea4.t73.qifeiye.com/xmlrpc.php?rsd" />
    <link rel="wlwmanifest" type="application/wlwmanifest+xml" href="http://57ea239cecea4.t73.qifeiye.com/qfy-includes/wlwmanifest.xml" />

    <link rel='canonical' href='http://57ea239cecea4.t73.qifeiye.com/' />
    <link rel='shortlink' href='http://57ea239cecea4.t73.qifeiye.com/?p=2160' />
    <style class='style_0'>.bitRightSider .widget-title,.bitLeftSider .widget-title{padding:0 0 0 10px;height:28px;line-height:28px;background-color:#024886;margin:0px;font-family:;font-size:px;font-weight:normal;font-style:normal;text-decoration:none;color:#fff;border-top:0;border-left:0;border-right:0;border-bottom:0;background-image: url(//fast.qifeiye.com/qfy-content/plugins//bit-plugin/assets/frame/header_bg/1/bg.png);background-repeat: repeat;-webkit-border-top-left-radius: 0;-webkit-border-top-right-radius: 0;-moz-border-radius-topleft: 0;-moz-border-radius-topright: 0;border-top-left-radius: 0;border-top-right-radius: 0;} .bitRightSider .bitWidgetFrame,.bitLeftSider .bitWidgetFrame{border-top:0;border-bottom:1px solid #bababa;border-left:1px solid #bababa;border-right:1px solid #bababa;padding:4px 10px 4px 10px;-webkit-border-bottom-left-radius: 0;-webkit-border-bottom-right-radius: 0;-moz-border-radius-bottomleft: 0;-moz-border-radius-bottomright: 0;border-bottom-left-radius: 0;border-bottom-right-radius: 0;}.bitRightSider .site_tooler,.bitLeftSider .site_tooler{-webkit-box-shadow:none;box-shadow:none;}.bitRightLeftSiderWidget.site_tooler .bitWidgetFrame,.bitRightLeftSiderWidget.site_tooler .bitWidgetFrame{background-color:transparent;background-image:none;-webkit-border-bottom-left-radius: 0px;border-bottom-left-radius: 0px;-webkit-border-bottom-right-radius: 0px;border-bottom-right-radius: 0px;}</style><style class='style_0'>.footer .widget-title{padding:0 0 0 10px;height:28px;line-height:28px;background-color:#024886;margin:0px;font-family:;font-size:px;font-weight:normal;font-style:normal;text-decoration:none;color:#fff;border-top:0;border-left:0;border-right:0;border-bottom:0;background-image:none;-webkit-border-top-left-radius: 4px;-webkit-border-top-right-radius: 4px;-moz-border-radius-topleft: 4px;-moz-border-radius-topright: 4px;border-top-left-radius: 4px;border-top-right-radius: 4px;} .footer .widget-title{border-top:0;border-left:0;border-right:0;} .footer  .bitWidgetFrame{border-bottom:0;border-top:0;border-left:0;border-right:0;padding:4px 10px 4px 10px;}.footer .site_tooler{-webkit-box-shadow:none;box-shadow:none;}.footer .site_tooler .bitWidgetFrame{background-color:transparent;background-image:none;-webkit-border-bottom-left-radius: 4px;border-bottom-left-radius: 4px;-webkit-border-bottom-right-radius: 4px;border-bottom-right-radius: 4px;}</style>     <script type="text/javascript">
    var qfyuser_ajax_url = 'http://57ea239cecea4.t73.qifeiye.com/admin/admin-ajax.php';
</script>
    <script type="text/javascript">
        var qfyuser_upload_url = 'http://57ea239cecea4.t73.qifeiye.com/qfy-content/plugins/qfyuser/lib/fileupload/fileupload.php';
    </script>
    <link rel="icon" href="http://57ea239cecea4.t73.qifeiye.com/qfy-content/uploads/2016/10/e6dd361961920299bdf281049f45ca2a.png" type="image/png"/>
    <link rel="apple-touch-icon-precomposed" href="http://57ea239cecea4.t73.qifeiye.com/qfy-content/uploads/2016/10/e6dd361961920299bdf281049f45ca2a.png" />
    <link rel="apple-touch-icon" href="http://57ea239cecea4.t73.qifeiye.com/qfy-content/uploads/2016/10/e6dd361961920299bdf281049f45ca2a.png" />
    <meta name="robots" content="index, follow" />
    <style type="text/css" >
        body {background-color: #ffffff;background-position:center top;background-repeat:repeat;background-size: cover;background-attachment: fixed;}
        #page{background-color: #ffffff;background-position:center top;background-repeat:repeat;background-size: auto;background-attachment: scroll;}
    </style>
    <link rel="stylesheet" href="css/help.css">
    <link rel="stylesheet" href="css/bootstrap.min.css">
</head>



<body class="home page page-id-2160 page-template-default image-blur btn-flat content-fullwidth wpb-js-composer js-comp-ver-4.0.1 vc_responsive" backgroundSize='true' data-pid="2160" data-pkey="43696bcdc4f8022776101003c5671fe2" style="background-image: url('image/bg.png'); background-repeat:no-repeat; background-size:cover; background-attachment:scroll; background-position:0 0%;">

<div id="page" class=' breackall wide '>


    <!-- left, center, classical, classic-centered -->
    <!-- !Header -->
    <header id="header" class="logo-left-right headerPM menuPosition transparent" role="banner">
        <!-- class="overlap"; class="logo-left", class="logo-center", class="logo-classic" -->
        <div class="wf-wrap">
            <div class="wf-table">


                <div id="branding" class="wf-td bit-logo-bar" style="">
                    <a class="bitem logo small" style="display: table-cell;"
                       href="index"><span class="logospan"><img class="preload-me"
                                                                    src="image/Aisino_1.jpg"
                                                                    width="675" height="220"
                                                                    alt=""/></span></a>

                    <!-- <div id="site-title" class="assistive-text"></div>
                    <div id="site-description" class="assistive-text"></div> -->
                </div>
                <!-- !- Navigation -->
                <nav style="0" id="navigation" class="wf-td" bitDataAction="site_menu_container"
                     bitDataLocation="primary">
                    <ul id="main-nav" data-st="1" data-sp="1" data-fh="0" data-mw="0" data-lh="40"
                        class="mainmenu fancy-rollovers wf-mobile-hidden bit-menu-default underline-hover"
                        data-bit-menu=underline-hover data-bit-float-menu=underline-hover>
                        <li class=" menu-item menu-item-type-post_type menu-item-object-page current-menu-item page_item page-item-2160 current_page_item bit-menu-post-id-2160 menu-item-2319 ">
                            <a href="index"><span>首页</span></a></li>
                        <li class=" menu-item menu-item-type-post_type menu-item-object-page bit-menu-post-id-7010 menu-item-7011">
                            <a href="import"><span>导入</span></a></li>
                        <li class=" menu-item menu-item-type-post_type menu-item-object-page bit-menu-post-id-8330 menu-item-15097">
                            <a href="require"><span>查询</span></a></li>
                        <li class=" menu-item menu-item-type-post_type menu-item-object-page bit-menu-post-id-9556 menu-item-9557">
                            <a href="count"><span>月度统计</span></a></li>
                        <li class=" menu-item menu-item-type-post_type menu-item-object-page bit-menu-post-id-8115 menu-item-8116">
                            <a href="chart"><span>年度报表</span></a></li>
                        <li class=" menu-item menu-item-type-post_type menu-item-object-page bit-menu-post-id-8116 menu-item-8117">
                            <a href="predict"><span>分析预测</span></a></li>
                        <li class=" menu-item menu-item-type-post_type menu-item-object-page bit-menu-post-id-8117 menu-item-8118">
                            <a href="calculateTax"><span>计算增值税</span></a></li>
                        <li class=" menu-item menu-item-type-post_type menu-item-object-page bit-menu-post-id-17296 menu-item-17297 act first">
                            <a href=""><span>帮助</span></a></li>
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
                        <div id="register" style="margin-top:0px;margin-bottom:0px;display: none;"
                             class="mobileHidden headerWidget_1 widget_text site_tooler">
                            <div class="bitWidgetFrame ">
                                <div style="margin-top:0px;margin-bottom:0px;padding-top:0px;padding-bottom:0px;padding-right:0px;padding-left:0px;"
                                     m-padding="0px 0px 0px 0px" p-padding="0px 0px 0px 0px" css_animation_delay="0"
                                     qfyuuid="0" class="qfy-element vc_btn3-container vc_btn3-center">
                                    <a onmouseleave="this.style.borderColor='#61b0ff'; this.style.backgroundColor='#61b0ff'; this.style.color='#ffffff';"
                                       onmouseenter="this.style.backgroundColor='transparent'; this.style.borderColor='#61b0ff'; this.style.color='#61b0ff';"
                                       style="font-family:微软雅黑; font-size:14px; border-color:#61b0ff; background-color:#61b0ff; color:#ffffff;"
                                       class="vc_general vc_btn3 vc_btn3-size-sm vc_btn3-shape-round vc_btn3-style-qfy-custom"
                                       href="register" target="">注册</a>
                                </div>
                            </div>
                        </div>
                        <div id="login" style="margin-top:0px;margin-bottom:0px;display: none; "
                             class="mobileHidden headerWidget_1 widget_text site_tooler">
                            <div class="bitWidgetFrame ">
                                <div style="margin-top:0px;margin-bottom:0px;padding-top:0px;padding-bottom:0px;padding-right:0px;padding-left:0px;"
                                     m-padding="0px 0px 0px 0px" p-padding="0px 0px 0px 0px" css_animation_delay="0"
                                     qfyuuid="0" class="qfy-element vc_btn3-container vc_btn3-center">
                                    <a onmouseleave="this.style.borderColor='#61b0ff'; this.style.backgroundColor='transparent'; this.style.color='#61b0ff';"
                                       onmouseenter="this.style.backgroundColor='#61b0ff'; this.style.borderColor='#61b0ff'; this.style.color='#ffffff';"
                                       style="font-family:微软雅黑; font-size:14px; border-color:#61b0ff; background-color:transparent; color:#61b0ff;"
                                       class="vc_general vc_btn3 vc_btn3-size-sm vc_btn3-shape-round vc_btn3-style-qfy-custom"
                                       href="login" target="_self">登录</a>
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
</div>
<div class="container"  style=";width: 100%">
    <div class="row wpb_row"  style=";width: 100%">
        <div data-animalename="qfyfadeInUp" data-delay=""
             class=" qfy-column-2-592134b61e1ad788989 qfy-column-inner vc_span_class vc_span6  text-Default small-screen-undefined"
             data-dw="1/2" data-fixheight=""  style=";width: 100%">
            <div style=";width: 100%;margin-top:0px;margin-bottom:0px;margin-left:0px;margin-right:0px;border-radius:0px;;position:relative;;"
                 class="column_inner ">
                <div class="column_containter" style="z-index:3;position:relative;;width: 100%">
                    <section data-fixheight="" class="qfy-row-3-592134b61e3b0564954 section     bothfull  section-text-no-shadow section-inner-no-shadow section-normal display_entire" style='margin-bottom:0px;border-radius:0px;color:#000000; ;width: 100%'>
                        <div class="container"  style=";width: 100%">
                            <div class="row wpb_row"   style=";width: 100%;margin-left: 3px;margin-top: 15px">
                                <div  style=";width: 100%" data-animalename="qfyfadeInUp" data-delay="" class=" qfy-column-4-592134b61f274474529 qfy-column-inner vc_span_class vc_span6  text-Default small-screen-Default" data-dw="1/2" data-fixheight="">
                                    <div style=";width: 100%;margin-top:0px;margin-bottom:0px;margin-left:10px;margin-right:10px;border-radius:0px;border-top:1px solid #cecece;border-bottom:1px solid #cecece;border-left:1px solid #cecece;border-right:1px solid #cecece;;position:relative;;" class="column_inner ">
                                        <div class="column_containter" style="z-index:3;position:relative; ;width: 100%">
                                            <div class="content"  style=";width: 100%">
                                                <!--通用-->
                                                <div class="help_01" style="text-indent: 2em">
                                                    <h4 class="search_title">1、查询服务提供哪些功能？</h4>
                                                    <p style="text-indent: 4em">本系统查询模块可提供按月份查询、按种类查询、按进销项查询等条件查询功能。</p>
                                                </div><br>
                                                <div class="help_01" style="text-indent: 2em">
                                                    <h4 class="search_title">2、如何按照进销项查询？</h4>
                                                    <p style="text-indent: 4em">在界面的左右边界各有一个小按钮，点击可在进项和销项数据查询界面进行切换。</p>
                                                </div><br>
                                                <div class="help_01"  style="text-indent: 2em">
                                                    <h4 class="search_title">3、查询条件包括全部商品品种吗？</h4>
                                                    <p style="text-indent: 4em">本系统经过预处理，保证查询可选项包括全部商品品种。</p>
                                                </div><br>
                                                <div class="help_01" style="text-indent: 2em">
                                                    <h4 class="search_title">4、如何对查询到的信息进行下载？</h4>
                                                    <p style="text-indent: 4em">您可点击当前界面的下载按钮，即可下载当前查询到的数据信息。</p>
                                                </div><br><br><br><br><br><br><br><br>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </section>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>