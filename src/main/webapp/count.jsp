﻿<!DOCTYPE html>
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
    <title>企业增值税发票数据分析系统 | 月度统计</title>
    <link rel="profile" href="http://gmpg.org/xfn/11" />
    <link rel="pingback" href="http://57ea239cecea4.t73.qifeiye.com/xmlrpc.php" />
    <!--[if lt IE 9]>
    <script src="http://57ea239cecea4.t73.qifeiye.com/FeiEditor/bitSite/js/html5shiv.min.js"></script>
    <![endif]-->
    <link rel="stylesheet" href="http://57ea239cecea4.t73.qifeiye.com/FeiEditor/bitSite/css/respond.css?ver=2.41" type="text/css" media="screen" />
    <!--[if lt IE 9]>
    <script src="http://57ea239cecea4.t73.qifeiye.com/FeiEditor/bitSite/js/respond.min.js"></script>
    <![endif]-->
    <style type="text/css" id="static-stylesheet"></style>
    <link rel="stylesheet" href="http://57ea239cecea4.t73.qifeiye.com/qfy-content/cache/scripts/57ec8d9b352f33adc09c11ca94f4b7b0.css" type="text/css" media="all" />
    <link rel='stylesheet' id='dt-main-css'  href='http://57ea239cecea4.t73.qifeiye.com/qfy-content/themes/qfy-01/css/main.css?ver=2.41' type='text/css' media='all' />
    <link rel='stylesheet' id='dt-custom-less-css'  href='http://57ea239cecea4.t73.qifeiye.com/qfy-content/uploads/wp-less/qfy-01/css/custom-6a3391fc76.css?ver=2.41' type='text/css' media='all' />
    <link rel='stylesheet' id='dt-bit-custom-less-css'  href='http://57ea239cecea4.t73.qifeiye.com/qfy-content/uploads/wp-less/qfy-01/css/bit-custom-6a3391fc76.css?ver=2.41' type='text/css' media='all' />
    <link rel='stylesheet' id='qfy_dynamic_css-css'  href='http://57ea239cecea4.t73.qifeiye.com/qfy-content/uploads/qfy-custom-style.css?m=1489546564?ver=2.41' type='text/css' media='all' />
    <style type='text/css'>
        .ppstart{
            background:transparent !important;
        }
    </style>
    <link rel="stylesheet" href="http://57ea239cecea4.t73.qifeiye.com/qfy-content/cache/scripts/a635b3ad6691a30f641df40e4f4b28c9.css" type="text/css" media="all" />
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
    <script type="text/javascript" src="http://57ea239cecea4.t73.qifeiye.com/qfy-content/cache/scripts/cd58c9a4a337ab56f72a3d05f4920d79.js"></script>
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
    <script type="text/javascript">
        dtGlobals.logoEnabled = 1;dtGlobals.curr_id = 2160;dtGlobals.logoURL = 'image/Aisino_1.jpg';dtGlobals.logoW = '675';dtGlobals.logoH = '220';dtGlobals.qfyname = '起飞页';dtGlobals.id = '57ea239cecea4';dtGlobals.language = '';smartMenu = 1;document.cookie='resolution='+Math.max(screen.width,screen.height)+'; path=/';
        dtGlobals.gallery_bgcolor = 'rgba(51,51,51,1)';dtGlobals.gallery_showthumbs = '0';dtGlobals.gallery_style = '';dtGlobals.gallery_autoplay = '0';dtGlobals.gallery_playspeed = '3';dtGlobals.gallery_imagesize = '100';dtGlobals.gallery_stopbutton = '';dtGlobals.gallery_thumbsposition = '';dtGlobals.gallery_tcolor = '#fff';dtGlobals.gallery_tsize = '16';dtGlobals.gallery_dcolor = '#fff';dtGlobals.gallery_dsize = '14';dtGlobals.gallery_tfamily = '';dtGlobals.gallery_dfamily = '';dtGlobals.gallery_blankclose = '0';dtGlobals.fm_showstyle = '';dtGlobals.fm_showspeed = '';dtGlobals.cdn_url = 'http://static.qifeiye.com';dtGlobals.qfymodel = "";dtGlobals.viewtemplate = "";
        var socail_back_url = '';
    </script>
    <script src="js/count.js"></script>
</head>



<body class="home page page-id-2160 page-template-default image-blur btn-flat content-fullwidth wpb-js-composer js-comp-ver-4.0.1 vc_responsive" backgroundSize='true' data-pid="2160" data-pkey="43696bcdc4f8022776101003c5671fe2" style="background-image: url('http://static.qifeiye.com/caches/e9ef95eecba4dae95a41c96bc9c459e6/aHR0cDovLzU3ZWEyMzljZWNlYTQudDczLnFpZmVpeWUuY29tL3FmeS1jb250ZW50L3VwbG9hZHMvMjAxNi8xMC9lMzA1YzE4ZWY5YTE1MDQzZGI0NzA4NDEyMjE5NmVkYS5wbmc_p_p100_p_3D.png'); background-repeat:no-repeat; background-size:cover; background-attachment:scroll; background-position:0 0%;">

<div id="page" class=' breackall wide '>


    <!-- left, center, classical, classic-centered -->
    <!-- !Header -->
    <header id="header" class="logo-left-right headerPM menuPosition transparent" role="banner">
        <!-- class="overlap"; class="logo-left", class="logo-center", class="logo-classic" -->
        <div class="wf-wrap">
            <div class="wf-table">


                <div id="branding" class="wf-td bit-logo-bar" style="">
                    <a class="bitem logo small" style="display: table-cell;"
                       href="index.jsp"><span class="logospan"><img class="preload-me"
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
                            <a href="index.jsp"><span>首页</span></a></li>
                        <li class=" menu-item menu-item-type-post_type menu-item-object-page bit-menu-post-id-7010 menu-item-7011">
                            <a href="import.jsp"><span>导入</span></a></li>
                        <li class=" menu-item menu-item-type-post_type menu-item-object-page bit-menu-post-id-8330 menu-item-15097">
                            <a href="require.jsp"><span>查询</span></a></li>
                        <li class=" menu-item menu-item-type-post_type menu-item-object-page bit-menu-post-id-9556 menu-item-9557 act first">
                            <a href="count.jsp"><span>月度统计</span></a></li>
                        <li class=" menu-item menu-item-type-post_type menu-item-object-page bit-menu-post-id-8115 menu-item-8116">
                            <a href="chart.jsp"><span>年度报表</span></a></li>
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
                                       style="font-family:微软雅黑; font-size:14px; padding-left:22px;padding-right:22px; padding-top:6px;padding-bottom:6px; border-width:1px; border-color:#61b0ff; background-color:#61b0ff; color:#ffffff;"
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
                                        style="font-family:微软雅黑; font-size:14px; padding-left:22px;padding-right:22px; padding-top:6px;padding-bottom:6px; border-width:1px; border-color:#61b0ff; background-color:transparent; color:#61b0ff;"
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
</div>
<div id="yuedu">
    <div class="count-box" style="text-align: center;margin-top: 50px">
        <form action="" method="post" enctype="multipart/form-data">
            <select name="year_one">
                <option value="2006">2006</option>
                <option value="2007">2007</option>
                <option value="2008">2008</option>
                <option value="2009">2009</option>
                <option value="2010">2010</option>
                <option value="2011">2011</option>
                <option value="2012">2012</option>
                <option value="2013">2013</option>
                <option value="2014">2014</option>
                <option value="2015">2015</option>
                <option value="2016">2016</option>
                <option value="2017">2017</option>
            </select>
            <select name="month">
                <option value="1">1月份</option>
                <option value="2">2月份</option>
                <option value="3">3月份</option>
                <option value="4">4月份</option>
                <option value="5">5月份</option>
                <option value="6">6月份</option>
                <option value="7">7月份</option>
                <option value="8">8月份</option>
                <option value="9">9月份</option>
                <option value="10">10月份</option>
                <option value="11">11月份</option>
                <option value="12">12月份</option>
            </select>
            <%--<input type="submit" name="submit_one" class="btn" value="确定" />--%>
        </form><br><br>
        <div id="main1" style="width: 600px;height:400px;margin-left:50px;float: left"></div>
        <div id="main2" style="width: 600px;height:400px;margin-right:50px;float: right"></div>
        <div id="baobiao1" style="width:1000px;height:400px;text-align: center;margin-left: 50px;float: left"></div>
        <div id="baobiao11" style="width:200px;height:400px;text-align: center;float: left"></div>
</div><br><br>
</div>
</body>
</html>