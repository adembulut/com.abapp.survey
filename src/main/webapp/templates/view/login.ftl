<!DOCTYPE html>
<#assign  path="/dashboard" />

<#if path2go??>
    <#assign  path="${path2go}"/>
</#if>
<html lang="en">
<meta http-equiv="content-type" content="text/html;charset=UTF-8" />
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Login</title>

    <!-- Global stylesheets -->
    <link href="https://fonts.googleapis.com/css?family=Roboto:400,300,100,500,700,900" rel="stylesheet" type="text/css">
    <link href="/assets/css/icons/icomoon/styles.css" rel="stylesheet" type="text/css">
    <link href="/assets/css/bootstrap.css" rel="stylesheet" type="text/css">
    <link href="/assets/css/core.css" rel="stylesheet" type="text/css">
    <link href="/assets/css/components.css" rel="stylesheet" type="text/css">
    <link href="/assets/css/colors.css" rel="stylesheet" type="text/css">
    <!-- /global stylesheets -->

    <!-- Core JS files -->
    <script type="text/javascript" src="/assets/js/plugins/loaders/pace.min.js"></script>
    <script type="text/javascript" src="/assets/js/core/libraries/jquery.min.js"></script>
    <script type="text/javascript" src="/assets/js/core/libraries/bootstrap.min.js"></script>
    <script type="text/javascript" src="/assets/js/plugins/loaders/blockui.min.js"></script>
    <!-- /core JS files -->


    <!-- Theme JS files -->
    <script type="text/javascript" src="/assets/js/core/app.js"></script>

    <script type="text/javascript" src="/assets/js/plugins/ui/ripple.min.js"></script>
    <!-- /theme JS files -->

</head>

<body class="login-container">

<!-- Page container -->
<div class="page-container">

    <!-- Page content -->
    <div class="page-content">

        <!-- Main content -->
        <div class="content-wrapper">

            <!-- Content area -->
            <div class="content">

                <!-- Simple login form -->
                <form method="post" action="">
                    <div class="panel panel-body login-form">
                        <div class="text-center">
                            <div class="icon-object border-slate-300 text-slate-300"><i class="icon-reading"></i></div>
                            <h5 class="content-group">
                                <@spring.message code='survey.general.loginMessage'/>
                                <small class="display-block">
                                    <@spring.message code='survey.general.loginExplanation'/>
                                </small></h5>
                        </div>

                        <div class="form-group has-feedback has-feedback-left">
                            <input type="text" class="form-control" name="j_username" placeholder="<@spring.message code='survey.general.email'/>">
                            <div class="form-control-feedback">
                                <i class="icon-user text-muted"></i>
                            </div>
                        </div>

                        <div class="form-group has-feedback has-feedback-left">
                            <input type="password" class="form-control" name="j_password" placeholder="<@spring.message code='survey.general.password'/>">
                            <div class="form-control-feedback">
                                <i class="icon-lock2 text-muted"></i>
                            </div>
                        </div>

                        <#if error??>
                            <style>
                                .login-error{
                                    color: red;
                                    border: 1px solid red;
                                    border-radius: 3px;
                                    padding: 5px;
                                }
                            </style>
                            <div class="form-group has-feedback has-feedback-left login-error">
                                <center>
                                    <@spring.message code='${error}'/>
                                </center>
                            </div>
                        </#if>


                        <div class="form-group">
                            <button type="submit" class="btn bg-pink-400 btn-block"><@spring.message code='survey.general.signIn'/> <i class="icon-circle-right2 position-right"></i></button>
                        </div>

<#--                        <div class="text-center">-->
<#--                            <a href="login_password_recover.html">Forgot password?</a>-->
<#--                        </div>-->
                    </div>
                </form>
                <!-- /simple login form -->

            </div>
            <!-- /content area -->

        </div>
        <!-- /main content -->

    </div>
    <!-- /page content -->

</div>
<!-- /page container -->

</body>

<!-- Mirrored from demo.interface.club/limitless/layout_1/LTR/material/login_simple.html by HTTrack Website Copier/3.x [XR&CO'2014], Tue, 20 Mar 2018 13:24:18 GMT -->
</html>
