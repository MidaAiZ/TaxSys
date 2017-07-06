<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>个人中心</title>
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <script type='text/javascript' src="js/jquery-3.2.1.min.js"></script>
    <script type='text/javascript' src="js/bootstrap.min.js"></script>
    <script type='text/javascript' src="js/center.js"></script>
    <script src="js/common.js"></script>
    <script src="js/register.js"></script>
    <link rel="stylesheet" href="css/d068214fb974cd02e0a547e672733d3a.css" type="text/css" media="all"/>
    <link rel='stylesheet' id='dt-main-css' href='http://57ea237f1ddc0.t73.qifeiye.com/qfy-content/themes/qfy-01/css/main.css?ver=2.35' type='text/css' media='all'/>
    <!-- Cache! 用于检验密码-->
    <script type='text/javascript'>
        /* <![CDATA[ */
        /* thickbox */
        var thickboxL10n = {
            "next": "\u4e0b\u4e00\u5f20 >",
            "prev": "< \u4e0a\u4e00\u5f20",
            "image": "\u56fe\u7247",
            "of": "\/",
            "close": "\u5173\u95ed",
            "noiframes": "\u8fd9\u4e2a\u529f\u80fd\u9700\u8981iframe\u7684\u652f\u6301\u3002\u60a8\u53ef\u80fd\u7981\u6b62\u4e86iframe\u7684\u663e\u793a\uff0c\u6216\u60a8\u7684\u6d4f\u89c8\u5668\u4e0d\u652f\u6301\u6b64\u529f\u80fd\u3002",
            "loadingAnimation": "\/\/fast.qifeiye.com\/FeiEditor\/bitSite\/images\/preloader.gif"
        };
        /* iphorm-plugin */
        var iphormL10n = {
            "error_submitting_form": "\u5728\u63d0\u4ea4\u8868\u5355\u65f6\u6709\u9519\u8bef",
            "swfupload_flash_url": "http:\/\/57ea237f1ddc0.t73.qifeiye.com\/qfy-includes\/js\/swfupload\/swfupload.swf",
            "swfupload_upload_url": "http:\/\/57ea237f1ddc0.t73.qifeiye.com\/?iphorm_swfupload=1",
            "swfupload_too_many": "\u961f\u5217\u4e2d\u7684\u6587\u4ef6\u592a\u591a\u4e86",
            "swfupload_file_too_big": "\u6587\u4ef6\u592a\u5927\u4e86",
            "swfupload_file_empty": "\u4e0d\u80fd\u4e0a\u4f20\u7a7a\u6587\u4ef6",
            "swfupload_file_type_not_allowed": "\u8be5\u6587\u4ef6\u7684\u7c7b\u578b\u662f\u4e0d\u5141\u8bb8\u4e0a\u4f20\u7684",
            "swfupload_unknown_queue_error": "\u672a\u77e5\u961f\u5217\u9519\u8bef\uff0c\u8bf7\u7a0d\u5019\u518d\u8bd5",
            "swfupload_upload_error": "\u4e0a\u4f20\u9519\u8bef",
            "swfupload_upload_failed": "\u4e0a\u4f20\u5931\u8d25",
            "swfupload_server_io": "\u670d\u52a1\u5668IO\u9519\u8bef",
            "swfupload_security_error": "\u5b89\u5168\u9519\u8bef",
            "swfupload_limit_exceeded": "\u4e0a\u4f20\u8d85\u8fc7\u9650\u5236",
            "swfupload_validation_failed": "\u9a8c\u8bc1\u5931\u8d25",
            "swfupload_upload_stopped": "\u4e0a\u4f20\u88ab\u7ec8\u6b62",
            "swfupload_unknown_upload_error": "\u6587\u4ef6\u4e0a\u4f20\u88ab\u610f\u5916\u7ec8\u6b62",
            "plugin_url": "http:\/\/57ea237f1ddc0.t73.qifeiye.com\/qfy-content\/plugins\/qfy_form",
            "preview_no_submit": "\u5728\u9884\u89c8\u6a21\u5f0f\u4e0b\u4e0d\u80fd\u63d0\u4ea4\u8868\u5355"
        };
        /* dt-plugins */
        var dtLocal = {
            "passText": "\u67e5\u770b\u8fd9\u4e2a\u52a0\u5bc6\u8d44\u8baf\uff0c\u8bf7\u5728\u4e0b\u9762\u8f93\u5165\u5bc6\u7801\uff1a",
            "moreButtonAllLoadedText": "\u5168\u90e8\u5df2\u52a0\u8f7d",
            "postID": "15281",
            "ajaxurl": "http:\/\/57ea237f1ddc0.t73.qifeiye.com\/admin\/admin-ajax.php",
            "contactNonce": "dacecab78d",
            "ajaxNonce": "57854e3e99",
            "pageData": {"type": "page", "template": "page", "layout": null},
            "themeSettings": {"smoothScroll": "on"}
        };

        /* ]]> */
    </script>
</head>

<body style="background-image: url(image/bg.png)">
<h3 style="margin-left: 100px;margin-top: 50px">个人中心</h3>
<a href="/index" style="float: right;margin-right: 50px;"><h4>返回</h4></a>
<div class="container" style="margin-top: 20px;">
    <ul class="nav nav-tabs">
        <li class="active"><a data-toggle="tab" href="#information" aria-expanded="true">个人信息</a></li>
        <li class=""><a data-toggle="tab" href="#modify" aria-expanded="false">修改信息</a></li>
    </ul>
    <div class="tab-content" style="text-align: center;">
        <div id="information" class="tab-pane fade active in" style="text-align: center">
            <div>
                <div class="qfyuser-label" style="margin-top: 125px;margin-left: 30%">
                    <div style="font-size: medium;width: 120px;float: left">用户名：</div>
                        <div id="name" style="font-size: medium;width: 250px;float: left;margin-left: 50px"></div><br><br><br>
                    <div style="font-size: medium;width: 120px;float: left">手机号：</div>
                        <div id="tel" style="font-size: medium;width: 250px;float: left;margin-left: 50px"></div><br><br><br>
                    <div style="font-size: medium;width: 120px;float: left">角色：</div>
                        <div id="role" style="font-size: medium;width: 250px;float: left;margin-left: 50px"></div><br><br><br>
                    <div style="font-size: medium;width: 120px;float: left">用户注册日期：</div>
                        <div id="date" style="font-size: medium;width: 250px;float: left;margin-left: 50px"></div><br><br><br>
                </div>
            </div>
        </div>
        <div id="modify" class="tab-pane fade" style="text-align: center;">
            <section class="bitBanner" id="bitBanner" bitdatamarker="bitBanner" bitdataaction="site_fix_container"></section>
            <div id="main" class="bit_main_content">

                <div class="main-gradient"></div>

                <div class="wf-wrap">
                    <div class="wf-container-main">


                        <div id="content" class="content" role="main">


                            <div class="main-outer-wrapper ">
                                <div class="bit_row">

                                    <div class="twelve columns no-sidebar-content ">

                                        <div class="bit_row">

                                            <div class="content-wrapper twelve columns ">
                                                <section data-fixheight="" class="qfy-row-1-5918701b512be451290 section     no  section-text-no-shadow section-inner-no-shadow section-normal" id="bit_gevkg" style='margin-bottom:0px;border-radius:0px;color:#000000;padding: 0px;padding-bottom: 15px'>
                                                    <div class="background-overlay grid-overlay-0 " style=" background-position: center center;background-size:cover ;"></div>

                                                    <div class="container">
                                                        <div class="row wpb_row" style="padding:0px ">
                                                            <div style="border: 0px solid #eee" class="qfy-column-1-5918701b515af936039 qfy-column-inner vc_span12 text-default small-screen-default fullrow" data-dw="1/1" data-fixheight="">
                                                                <div style=";position:relative;padding: 80px;" class="column_inner ">
                                                                    <div class=" background-overlay grid-overlay-" style=""></div>
                                                                    <div class="column_containter" style="z-index:3;position:relative;">
                                                                        <section data-fixheight="" class="qfy-row-2-5918701b51742695123 section     bothfull  section-text-no-shadow section-inner-no-shadow section-normal" style='margin-bottom:0px;border-radius:0px;'>
                                                                            <div class="background-overlay grid-overlay-0 " style=""></div>

                                                                            <div class="container">
                                                                                <div class="row wpb_row">

                                                                                    <style>
                                                                                        div.qfyuser-warning {
                                                                                            float: left;
                                                                                            font-size: 8px;
                                                                                            padding: 2px;
                                                                                        }
                                                                                        .qfy-column-2-5918701b518fe495101 > .column_inner:hover {
                                                                                        }

                                                                                        .qfy-column-2-5918701b518fe495101 > .column_inner:hover > .background-media {
                                                                                        }

                                                                                        .qfy-column-2-5918701b518fe495101 > .column_inner:hover > .background-overlay {
                                                                                        }

                                                                                        @media only screen and (min-width: 992px) {
                                                                                            .qfy-column-2-5918701b518fe495101 > .column_inner {
                                                                                                padding-left: 0px;
                                                                                                padding-right: 0px;
                                                                                                padding-top: 0px;
                                                                                                padding-bottom: 0px;
                                                                                            }

                                                                                            .wpb_row .vc_span_class.qfy-column-2-5918701b518fe495101 {
                                                                                            }

                                                                                        ;
                                                                                        }

                                                                                        @media only screen and (max-width: 992px) {
                                                                                            .qfy-column-2-5918701b518fe495101 > .column_inner {
                                                                                                margin: 0px auto 0px !important;
                                                                                                padding-left: 0px;
                                                                                                padding-right: 0px;
                                                                                                padding-top: px;
                                                                                                padding-bottom: px;
                                                                                            }

                                                                                            .display_entire .wpb_row .vc_span_class.qfy-column-2-5918701b518fe495101 {
                                                                                            }

                                                                                        ;
                                                                                        }</style>
                                                                                    <div class="qfy-column-3-5918701b52ae12925 qfy-column-inner vc_span_class vc_span6  text-Default small-screen-Default" data-dw="1/2" data-fixheight="">
                                                                                        <div style="max-width:480px;margin-top:0px;margin-bottom:0px;margin-left:0px;margin-right:0px;border-radius:5px;;position:relative;overflow:hidden;;" class="column_inner ">
                                                                                            <div class=" background-overlay grid-overlay-0" style=""></div>
                                                                                            <div class="column_containter" style="z-index:3;position:relative;">
                                                                                                <div class="qfy-element qfyuser qfyuser-910 qfyuser-float " data-modal_profile_saved='您的个人资料已保存！' data-template='register' data-uploads_dir='http://57ea237f1ddc0.t73.qifeiye.com/qfy-content/uploads/qfyuser/' data-default_avatar_male='http://57ea237f1ddc0.t73.qifeiye.com/qfy-content/plugins/qfyuser/img/default_avatar_male.jpg' data-default_avatar_female='http://57ea237f1ddc0.t73.qifeiye.com/qfy-content/plugins/qfyuser/img/default_avatar_male.jpg' data-skin='elegant' data-required_text='此项必须填写' data-password_too_short='你的密码太短了' data-passwords_do_not_match='两个密码不匹配' data-password_not_strong='密码不够强高' data-keep_one_section_open='0' data-allow_sections='1' data-permalink='http://57ea237f1ddc0.t73.qifeiye.com/?page_id=15281' data-field_icons='0' data-profile_thumb_size='80' data-register_heading='注册帐号' data-register_side='注册会员点这里' data-register_side_action='login' data-register_button_action='login' data-register_button_primary='注册' data-register_button_secondary='登录' data-register_group='default' data-register_redirect='0' data-type='0' data-login_heading='登录' data-login_side='忘记密码？点这里找回' data-login_side_action='reset' data-login_button_action='register' data-login_button_primary='登录' data-login_button_secondary='注册' data-login_group='default' data-login_redirect='0' data-rememberme='true' data-delete_heading='删除个人资料' data-delete_side='取消并返回' data-delete_side_action='view' data-delete_button_action='view' data-delete_button_primary='确认删除' data-delete_button_secondary='返回到用户资料' data-delete_group='default' data-reset_heading='重设密码' data-reset_side='返回登录' data-reset_side_action='login' data-reset_button_action='change' data-reset_button_primary='发送' data-reset_button_secondary='更改您的密码' data-reset_group='default' data-change_heading='更改您的密码' data-change_side='重发验证码' data-change_side_action='reset' data-change_button_action='reset' data-change_button_primary='更新密码' data-change_button_secondary='重新发送验证码' data-change_group='default' data-list_heading='最新成员' data-list_per_page='5' data-list_sortby='registered' data-list_order='desc' data-list_users='0' data-list_group='default' data-list_thumb='50' data-list_showthumb='1' data-list_showsocial='1' data-list_showbio='0' data-list_verified='0' data-list_relation='or' data-online_heading='查看在线用户' data-online_thumb='30' data-online_showthumb='1' data-online_showsocial='0' data-online_showbio='0' data-online_mini='1' data-online_mode='vertical' data-edit_button_primary='保存更改' data-edit_group='default' data-view_group='default' data-social_target='_blank' data-social_group='default' data-card_width='250px' data-card_img_width='250' data-card_showbio='1' data-card_showsocial='1' data-link_target='_blank' data-error_heading='有错误发生' data-memberlist_table='0' data-memberlist_table_columns='user_id,picture,name,country,gender,role,email_user,message_user' data-show_on_mobile='picture,name,country,email_user,message_user' data-memberlist_v2='1' data-memberlist_v2_pic_size='86' data-memberlist_v2_fields='age,gender,country' data-memberlist_v2_bio='1' data-memberlist_v2_showbadges='1' data-memberlist_v2_showname='1' data-memberlist_v2_showsocial='1' data-memberlist_pic_size='120' data-memberlist_pic_topspace='15' data-memberlist_pic_sidespace='30' data-memberlist_pic_rounded='1' data-memberlist_width='100%' data-memberlist_paginate='1' data-memberlist_paginate_top='1' data-memberlist_paginate_bottom='1' data-memberlist_show_name='1' data-memberlist_popup_view='0' data-memberlist_withavatar='0' data-memberlist_verified='0' data-memberlist_filters='0' data-memberlist_default_search='1' data-per_page='12' data-sortby='registered' data-order='desc' data-relation='and' data-search='1' data-exclude='0' data-show_social='1' data-registration_closed_side='已经注册了？请登录' data-registration_closed_side_action='login' data-facebook_redirect='profile' data-logout_redirect='0' data-postsbyuser_num='12' data-postsbyuser_types='post' data-postsbyuser_mode='grid' data-postsbyuser_thumb='50' data-postsbyuser_showthumb='1' data-postsbyuser_taxonomy='category' data-postsbyuser_category='0' data-publish_heading='添加一个新资讯' data-publish_button_primary='发布' data-layout='float' data-margin_top='0' data-margin_bottom='0' data-align='center' data-max_width='480' data-fontcolor='#104f68' data-bzfontcolor='#888888' data-inputbordercolor='#ddd' data-inputborderHovercolor='#aaa' data-fonthovercolor='#aaa' data-button1color='#104f68' data-button1bordercolor='#104f68' data-button1fontcolor='#ffffff' data-button2color='transparent' data-button2bordercolor='#104f68' data-button2fontcolor='#104f68' data-linebackground='#104f68' data-linefontcolor='#ffffff' data-line2background='#104f68' data-line2fontcolor='#ffffff' data-box_background='2' data-bg_image='0' data-bg_color='0' data-bg_image_repeat='no-repeat' data-box_border='0' data-box_border_settings='1|^|1|^|#ffffff|^|0|^|1|^|#ffffff|^|0|^|1|^|#ffffff|^|0|^|1|^|#ffffff|^|0' data-box_shadow='0' data-box_shadowcolor='#000000' data-box_shadowstyle='0' data-box_shadowsize='1' data-z_index='0' data-show_logout_login='0' data-show_groups='0' data-isshowlabel='0' data-login_txt0='0' data-login_txt1='0' data-login_txt2='0' data-login_txt3='0' data-login_txt4='0' data-custom_template='0' data-dependency_tab='1' data-allfontsize='14' data-inputborderhovercolor='#aaa' data-margintop='0' data-marginbottom='0' data-paddingtop='0' data-paddingbottom='0' data-paddingleft='20' data-paddingright='20' data-updateparamtime='1477029391231' data-qfyuuid='qfyuser_mrl7z' data-password_checking='0'>

                                                                                                        <form id="register-form" class="qfyuser_register">

                                                                                                            <div class='qfyuser-field qfyuser-field-user_login ' data-key='user_login'>
                                                                                                                <div class='qfyuser-label'>
                                                                                                                    <label for='user_login-910'>手机号：</label>

                                                                                                                    <span class="qfyuser-tip" title="数字"></span>
                                                                                                                </div>
                                                                                                                <div class='qfyuser-input '>
                                                                                                                    <input type='text' name='number' id='user_login-910' value="" placeholder='请输入手机号' data-ajaxcheck='username_exists' data-help='英文字母和数字' data-label='登录名' data-placeholder='' data-_builtin='1' data-hidden='0' data-hideable='0' data-html='0' data-locked='0' data-private='0' data-required='1' data-type='text' data-woo='0'/>

                                                                                                                    <div class='qfyuser-clear'></div>
                                                                                                                </div>
                                                                                                            </div>
                                                                                                            <div class='qfyuser-clear'></div>

                                                                                                            <div class='qfyuser-field qfyuser-field-user_email '
                                                                                                                 data-key='user_email'>
                                                                                                                <div class='qfyuser-label'>
                                                                                                                    <label for='user_email-910'>原始密码</label>

                                                                                                                </div>
                                                                                                                <div class='qfyuser-input '>
                                                                                                                    <input type='password' name='oldPassword' id='user_email-910' value="" placeholder='请输入原始密码' data-ajaxcheck='email_exists' data-help='' data-label='手机号' data-placeholder='' data-_builtin='1' data-hidden='0' data-hideable='0' data-html='0' data-locked='0' data-private='0' data-required='1' data-type='text' data-woo='0'/>

                                                                                                                    <div class='qfyuser-clear'></div>
                                                                                                                </div>
                                                                                                            </div>
                                                                                                            <div class='qfyuser-clear'></div>

                                                                                                            <div class='qfyuser-field qfyuser-field-user_pass ' data-key='user_pass'>
                                                                                                                <div class='qfyuser-label'>
                                                                                                                    <label for='user_pass-910'>新的密码</label>

                                                                                                                    <span class="qfyuser-tip" title="最少8位"></span>
                                                                                                                </div>
                                                                                                                <div class='qfyuser-input '>
                                                                                                                    <input autocomplete='new-password' type='password' class='password' name='newPassword' id='user_pass-910' value='' placeholder='请输入密码' data-ajaxcheck='' data-help='最少8位' data-label='密码' data-placeholder='' data-_builtin='1' data-hidden='0' data-hideable='0' data-html='0' data-locked='0' data-private='0' data-required='1' data-type='password' data-woo='0'/>

                                                                                                                    <div class='qfyuser-clear'></div>
                                                                                                                </div>
                                                                                                            </div>
                                                                                                            <div class='qfyuser-clear'></div>

                                                                                                            <div class='qfyuser-field qfyuser-field-user_pass_confirm ' data-key='user_pass_confirm'>
                                                                                                                <div class='qfyuser-label'>
                                                                                                                    <label for='user_pass_confirm-910'>再次输入密码</label>
                                                                                                                </div>
                                                                                                                <div class='qfyuser-input '>
                                                                                                                    <input autocomplete='new-password' type='password' class='password' name='user_pass_confirm-910' id='user_pass_confirm-910' value='' placeholder='请确认密码' data-ajaxcheck='' data-help='' data-label='再次输入密码' data-placeholder='' data-_builtin='1' data-hidden='0' data-hideable='0' data-html='0' data-locked='0' data-private='0' data-required='0' data-type='password' data-woo='0'/>

                                                                                                                    <div class='qfyuser-clear'></div>
                                                                                                                </div>
                                                                                                            </div>
                                                                                                            <div class='qfyuser-clear'></div>

                                                                                                            <div class='qfyuser-field qfyuser-field-passwordstrength ' data-key='passwordstrength'>
                                                                                                                <div class='qfyuser-input '>
                                                                                                                    <span class="strength-text" data-ajaxcheck='' data-help='' data-label='密码强度' data-placeholder='' data-_builtin='1' data-good='密码强度一般' data-hidden='0' data-hideable='0' data-html='0' data-locked='0' data-private='0' data-required='0' data-strong='密码强度强' data-too_short='密码太短' data-type='passwordstrength' data-very_strong='密码强度非常强' data-very_weak='密码强度非常弱' data-weak='密码强度弱' data-woo='0'>密码强度</span>

                                                                                                                    <div class="qfyuser-clear"></div>
                                                                                                                    <span class="strength-container"><span class="strength-plain"></span><span class="strength-plain"></span><span class="strength-plain"></span><span class="strength-plain"></span><span class="strength-plain"></span></span>

                                                                                                                    <div class="qfyuser-clear"></div>
                                                                                                                    <div class='qfyuser-clear'></div>
                                                                                                                </div>
                                                                                                            </div>
                                                                                                            <br><br>

                                                                                                            <input id="confirm" class="btn-xs btn-primary form-control" style="font-size: medium;width: 100px;float: left;margin-left: 150px" type="submit" value="确定">
                                                                                                            <br/></form>
                                                                                                    </div>

                                                                                                </div>

                                                                                                <style type="text/css">
                                                                                                    div.qfyuser-awsm-pic {
                                                                                                        margin-left: -48px;
                                                                                                        top: -48px;
                                                                                                    }

                                                                                                    div.qfyuser-awsm-pic img {
                                                                                                        width: 86px;
                                                                                                        height: 86px;
                                                                                                    }

                                                                                                    div.qfyuser,
                                                                                                    div.emd-main,
                                                                                                    div.emd-filters,
                                                                                                    div.qfyuser-search-results,
                                                                                                    div.qfyuser-label label,
                                                                                                    div.qfyuser input,
                                                                                                    div.qfyuser textarea,
                                                                                                    div.qfyuser select,
                                                                                                    div.qfyuser-field textarea.qfyuser_editor,
                                                                                                    div.qfyuser-msg-overlay-content,
                                                                                                    div.qfyuser-msg-overlay-content input,
                                                                                                    div.qfyuser-msg-overlay-content textarea,
                                                                                                    div.qfyuser-notifier {
                                                                                                        font-family: Roboto;
                                                                                                    }

                                                                                                    div.qfyuser-910 {
                                                                                                        max-width: 480px;
                                                                                                        width: 100%;
                                                                                                        margin-left: auto;
                                                                                                        margin-right: auto;
                                                                                                    }

                                                                                                    div.qfyuser-910.qfyuser-nostyle {
                                                                                                        max-width: 250px;
                                                                                                    }

                                                                                                    div.qfyuser-910.qfyuser-users {
                                                                                                        max-width: 100% !important;
                                                                                                    }

                                                                                                    div.qfyuser-910 div.qfyuser-user {
                                                                                                        margin-top: 15px;
                                                                                                        margin-left: 30px;
                                                                                                        margin-right: 30px;
                                                                                                    }

                                                                                                    div.qfyuser-910 div.qfyuser-user a.qfyuser-user-img {
                                                                                                        width: 120px;
                                                                                                        height: 120px;
                                                                                                    }

                                                                                                    div.qfyuser-910 div.qfyuser-user a.qfyuser-user-img span {
                                                                                                        top: -120px;
                                                                                                        line-height: 120px;
                                                                                                    }

                                                                                                    div.qfyuser-910 div.qfyuser-user div.qfyuser-user-link {
                                                                                                        width: 120px;
                                                                                                    }

                                                                                                    div.qfyuser-910 div.qfyuser-user a.qfyuser-user-img,
                                                                                                    div.qfyuser-910 div.qfyuser-user a.qfyuser-user-img span {
                                                                                                        border-radius: 999px !important;
                                                                                                    }

                                                                                                    div.qfyuser-910 div.qfyuser-list-item-i {
                                                                                                        width: 50px;
                                                                                                        height: 50px;
                                                                                                    }

                                                                                                    div.qfyuser-910 div.qfyuser-online-item-i {
                                                                                                        width: 30px;
                                                                                                        height: 30px;
                                                                                                    }

                                                                                                    div.qfyuser-910 div.qfyuser-online-item {
                                                                                                        border-bottom: 0px !important;
                                                                                                        padding: 10px 0 0 0;
                                                                                                    }

                                                                                                    div.qfyuser-910 div.qfyuser-online-item img.qfyuser-profile-badge,
                                                                                                    div.qfyuser-910 div.qfyuser-online-item img.qfyuser-profile-badge-right {
                                                                                                        max-width: 14px !important;
                                                                                                        max-height: 14px !important;
                                                                                                    }

                                                                                                    div.qfyuser-910 div.qfyuser-profile-img {
                                                                                                        width: 80px;
                                                                                                        height: 80px;
                                                                                                    }

                                                                                                    div.emd-user {
                                                                                                        width: !important;
                                                                                                        margin-left: !important;
                                                                                                    }

                                                                                                    div.qfyuser-910 div.qfyuser-label label,
                                                                                                    div.qfyuser-910 .qfyuser-qfy-action,
                                                                                                    div.qfyuser-910 div.qfyuser-profile-name a {
                                                                                                        color: #104f68 !important;
                                                                                                    }

                                                                                                    div.qfyuser-910 div.qfyuser-input label.qfyuser-checkbox.hide-field,
                                                                                                    div.qfyuser-910 .open_social_box span,
                                                                                                    div.qfyuser-910 .open_social_box .login_button,
                                                                                                    div.qfyuser-910 .qfyuser-checkbox-wrap,
                                                                                                    div.qfyuser-910 div.qfyuser-input label.qfyuser-radio,
                                                                                                    div.qfyuser-910 div.qfyuser-input label.qfyuser-checkbox,
                                                                                                    div.qfyuser-910.qfyuser .qfyuser-pic-upload,
                                                                                                    div.qfyuser-910 .qfyuser-qfy-bz-action,
                                                                                                    div.qfyuser-910 .qfyuser-pic-none,
                                                                                                    div.qfyuser-910 div.qfyuser-maxwidth div.qfyuser-input label,
                                                                                                    div.qfyuser-910 .strength-text {
                                                                                                        color: #888888 !important;
                                                                                                    }

                                                                                                    div.qfyuser-910 div.qfyuser-input input[type="text"],
                                                                                                    div.qfyuser-910 div.qfyuser-input input[type="password"],
                                                                                                    div.qfyuser-910 div.qfyuser-input select,
                                                                                                    div.qfyuser-910 .chosen-container-single .chosen-single,
                                                                                                    div.qfyuser-910 div.qfyuser-input textarea,
                                                                                                    div.qfyuser-910 .qfyuser-checkbox > span,
                                                                                                    div.qfyuser-910 img.qfyuser-img {
                                                                                                        border: 1px solid #ddd !important;
                                                                                                        color: #104f68 !important;
                                                                                                    }

                                                                                                    div.qfyuser-910 div.qfyuser-input input[type="text"]:focus,
                                                                                                    div.qfyuser-910 div.qfyuser-input input[type="password"]:focus,
                                                                                                    div.qfyuser-910 div.qfyuser-input textarea:focus {
                                                                                                        border: 1px solid #aaa !important;
                                                                                                        color: #aaa !important;
                                                                                                    }

                                                                                                    div.qfyuser-910 input.qfyuser-button,
                                                                                                    div.qfyuser-910 a.qfyuser-button {
                                                                                                        background: #104f68 !important;
                                                                                                        border: 1px solid #104f68 !important;
                                                                                                        color: #ffffff !important;
                                                                                                        box-shadow: inset 0 1px #104f68 !important;
                                                                                                    }

                                                                                                    div.qfyuser-910 input.qfyuser-button.secondary,
                                                                                                    div.qfyuser-910 a.qfyuser-button.secondary,
                                                                                                    div.qfyuser-910 div.qfyuser div.ajax-file-upload {
                                                                                                        background: transparent !important;
                                                                                                        border: 1px solid #104f68 !important;
                                                                                                        color: #104f68 !important;
                                                                                                        box-shadow: inset 0 1px transparent !important;
                                                                                                    }

                                                                                                    div.qfyuser-910 div.qfyuser-section.qfyuser-collapsed-0 {
                                                                                                        background: #104f68;
                                                                                                        border: none;
                                                                                                        color: #ffffff !important;
                                                                                                        text-shadow: none;
                                                                                                    }

                                                                                                    div.qfyuser-910 div.qfyuser-section.qfyuser-collapsed-1 {
                                                                                                        background: #104f68;
                                                                                                        border: none;
                                                                                                        color: #ffffff !important;
                                                                                                        text-shadow: none;
                                                                                                    }

                                                                                                    div.qfyuser-910 .qfyuser-input.fa:before {
                                                                                                        left: 10px;
                                                                                                        position: absolute;

                                                                                                        top: 9px;
                                                                                                    }

                                                                                                    div.qfyuser-910 .qfyuser-input.fa.fa-envelope-o:before {
                                                                                                        left: 8px;
                                                                                                        position: absolute;
                                                                                                    }

                                                                                                    div.qfyuser-910 .qfyuser-field div.qfyuser-input.fa input {
                                                                                                        padding-left: 30px !important;
                                                                                                    }

                                                                                                    div.qfyuser-910 div.qfyuser-label label,
                                                                                                    div.qfyuser-910,
                                                                                                    div.qfyuser-910 div.qfyuser-input label.qfyuser-checkbox.hide-field,
                                                                                                    div.qfyuser-910 div.qfyuser input,
                                                                                                    div.qfyuser-910 div.qfyuser textarea,
                                                                                                    div.qfyuser-910 div.qfyuser select {
                                                                                                        font-size: 14px !important;
                                                                                                    }

                                                                                                    div.qfyuser-910 div.qfyuser-input input[type="text"],
                                                                                                    div.qfyuser-910 div.qfyuser-input input[type="password"],
                                                                                                    div.qfyuser-910 div.qfyuser-input textarea,
                                                                                                    div.qfyuser-910 div.qfyuser-input select,
                                                                                                    div.qfyuser-910 div.qfyuser-submit input,
                                                                                                    div.qfyuser-910 div.qfyuser-section,
                                                                                                    div.qfyuser-910 div.qfyuser-input label.qfyuser-radio,
                                                                                                    div.qfyuser-910 div.qfyuser-input label.qfyuser-checkbox,
                                                                                                    div.qfyuser-910 input.input-after-button {
                                                                                                        font-size: 15px !important;
                                                                                                    }

                                                                                                    div.qfyuser-910 div.qfyuser-input input[type="text"],
                                                                                                    div.qfyuser-910 div.qfyuser-input input[type="password"],
                                                                                                    div.qfyuser-910 div.qfyuser-submit input,
                                                                                                    div.qfyuser-910 .qfyuser-qfy-action,
                                                                                                    div.qfyuser-910 input.input-after-button,
                                                                                                    div.qfyuser-910 .qfyuser-input img.qfyuser-img {
                                                                                                        height: 32px !important;
                                                                                                        line-height: 32px !important;
                                                                                                    }

                                                                                                    div.qfyuser-910 div.qfyuser-profile-img img {
                                                                                                        background: transparent !important;
                                                                                                    }

                                                                                                    div.qfyuser-910 {
                                                                                                        background: transparent;
                                                                                                        margin-top: 0px;
                                                                                                        margin-bottom: 0px;
                                                                                                    }

                                                                                                    div.qfyuser-910 {
                                                                                                        padding-top: 0px;
                                                                                                        padding-bottom: 0px;
                                                                                                        padding-right: 20px;
                                                                                                        padding-left: 20px;
                                                                                                    }

                                                                                                    @media screen and (max-width: 768px) {
                                                                                                        .bit-html div.qfyuser-910 {
                                                                                                            padding: 0px 0px 0px 0px;
                                                                                                        }
                                                                                                    }
                                                                                                </style>
                                                                                                <div m-padding="10px 0px 10px 0px" p-padding="10px 35px 10px 35px" css_animation_delay="0" qfyuuid="qfy_column_text_ft5br" class="qfy-element qfy-text qfy-text-93074 wpb_text_column wpb_content_element " style="position: relative;;;line-height:1.5em;;background-repeat: no-repeat;;margin-top:0px;margin-bottom:0px;padding-top:10px;padding-bottom:10px;padding-right:35px;padding-left:35px;border-radius:0px;"></div>
                                                                                            </div>
                                                                                        </div>
                                                                                    </div>
                                                                                    <style>
                                                                                        .qfy-column-3-5918701b52ae12925 > .column_inner:hover {
                                                                                        }

                                                                                        .qfy-column-3-5918701b52ae12925 > .column_inner:hover > .background-media {
                                                                                        }

                                                                                        .qfy-column-3-5918701b52ae12925 > .column_inner:hover > .background-overlay {
                                                                                        }

                                                                                        @media only screen and (min-width: 992px) {
                                                                                            .qfy-column-3-5918701b52ae12925 > .column_inner {
                                                                                                margin: 0px auto 0px !important;
                                                                                                padding-left: 0px;
                                                                                                padding-right: 0px;
                                                                                                padding-top: 0px;
                                                                                                padding-bottom: 0px;
                                                                                            }

                                                                                            .wpb_row .vc_span_class.qfy-column-3-5918701b52ae12925 {
                                                                                            }

                                                                                        ;
                                                                                        }

                                                                                        @media only screen and (max-width: 992px) {
                                                                                            .qfy-column-3-5918701b52ae12925 > .column_inner {
                                                                                                margin: 0px auto 0px !important;
                                                                                                padding-left: 0px;
                                                                                                padding-right: 0px;
                                                                                                padding-top: 0px;
                                                                                                padding-bottom: 0px;
                                                                                            }

                                                                                            .display_entire .wpb_row .vc_span_class.qfy-column-3-5918701b52ae12925 {
                                                                                            }
                                                                                            div.qfyuser{
                                                                                                border: 0px solid #eee;
                                                                                            };
                                                                                        ;

                                                                                        }</style>
                                                                                    <div class="wf-mobile-hidden" style="clear:both;"></div>
                                                                                </div>
                                                                            </div>
                                                                            <style>
                                                                                @media only screen and (min-width: 992px) {
                                                                                    section.section.qfy-row-2-5918701b51742695123 {
                                                                                        padding-left: 0px;
                                                                                        padding-right: 0px;
                                                                                        padding-top: 0px;
                                                                                        padding-bottom: 0px;
                                                                                        margin-top: 0px;
                                                                                    }
                                                                                }

                                                                                @media only screen and (max-width: 992px) {
                                                                                    .bit-html section.section.qfy-row-2-5918701b51742695123 {
                                                                                        padding-left: 15px;
                                                                                        padding-right: 15px;
                                                                                        padding-top: 0px;
                                                                                        padding-bottom: px;
                                                                                        margin-top: 0px;
                                                                                    }
                                                                                }
                                                                            </style>
                                                                        </section>
                                                                    </div>
                                                                </div>
                                                            </div>
                                                            <style>
                                                                .qfy-column-1-5918701b515af936039 > .column_inner:hover {
                                                                }

                                                                .qfy-column-1-5918701b515af936039 > .column_inner:hover > .background-media {
                                                                }

                                                                .qfy-column-1-5918701b515af936039 > .column_inner:hover > .background-overlay {
                                                                }

                                                                @media only screen and (min-width: 992px) {
                                                                    .qfy-column-1-5918701b515af936039 > .column_inner {
                                                                        padding-left: 0px;
                                                                        padding-right: 0px;
                                                                        padding-top: 140px;
                                                                        padding-bottom: 0px;
                                                                    }

                                                                    .wpb_row .vc_span_class.qfy-column-1-5918701b515af936039 {
                                                                    }

                                                                ;
                                                                }

                                                                @media only screen and (max-width: 992px) {
                                                                    .qfy-column-1-5918701b515af936039 > .column_inner {
                                                                        margin: 0px auto 0px !important;
                                                                        padding-left: 0px;
                                                                        padding-right: 0px;
                                                                        padding-top: 140px;
                                                                        padding-bottom: px;
                                                                    }

                                                                    .display_entire .wpb_row .vc_span_class.qfy-column-1-5918701b515af936039 {
                                                                    }

                                                                ;
                                                                }</style>
                                                        </div>
                                                    </div>
                                                    <style>
                                                        @media only screen and (min-width: 992px) {
                                                            section.section.qfy-row-1-5918701b512be451290 {
                                                                padding-left: 0px;
                                                                padding-right: 0px;
                                                                padding-top: 20px;
                                                                padding-bottom: 133px;
                                                                margin-top: 0px;
                                                                min-height: 700px
                                                            }

                                                            section.section.qfy-row-1-5918701b512be451290 > .container {
                                                                max-width: 1280px;
                                                                margin: 0 auto;
                                                            }
                                                        }

                                                        @media only screen and (max-width: 992px) {
                                                            .bit-html section.section.qfy-row-1-5918701b512be451290 {
                                                                padding-left: 15px;
                                                                padding-right: 15px;
                                                                padding-top: 20px;
                                                                padding-bottom: 133px;
                                                                margin-top: 0px;
                                                                min-height: 700px;
                                                            }
                                                        }
                                                    </style>
                                                </section>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <!-- .wf-container -->
                </div>
                <!-- .wf-wrap -->
            </div>
        </div>
    </div>
</div>

</body>
</html>
