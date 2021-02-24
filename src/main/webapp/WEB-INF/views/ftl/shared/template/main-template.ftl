<#import "/shared/template/sidebar.ftl" as sidebar/>
<#import "/shared/template/footer.ftl" as footer/>
<#import "/shared/template/header.ftl" as header/>
<#macro html title="Survey Management" headerSection="" footerSection="" breadCrumb="">
    <!DOCTYPE html>
    <html lang="en">

    <!-- Mirrored from demo.interface.club/limitless/layout_1/LTR/material/general_faq.html by HTTrack Website Copier/3.x [XR&CO'2014], Tue, 20 Mar 2018 13:23:28 GMT -->
    <!-- Added by HTTrack --><meta http-equiv="content-type" content="text/html;charset=UTF-8" /><!-- /Added by HTTrack -->
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>${title}</title>

        <!-- Global stylesheets -->
        <link href="https://fonts.googleapis.com/css?family=Roboto:400,300,100,500,700,900" rel="stylesheet" type="text/css">
        <link href="/assets/css/icons/icomoon/styles.css" rel="stylesheet" type="text/css">
        <link href="/assets/css/bootstrap.css" rel="stylesheet" type="text/css">
        <link href="/assets/css/core.css" rel="stylesheet" type="text/css">
        <link href="/assets/css/components.css" rel="stylesheet" type="text/css">
        <link href="/assets/css/colors.css" rel="stylesheet" type="text/css">
        <link href="/assets/app/css/application.css" rel="stylesheet" type="text/css">

        <script type="text/javascript" src="/assets/js/plugins/notifications/bootbox.min.js"></script>
        <script type="text/javascript" src="/assets/js/plugins/notifications/sweet_alert.min.js"></script>
        <!-- /global stylesheets -->
        <#call headerSection/>
<#--        ${headerSection?html}-->
    </head>

    <body>
    <div class="preloader">
        <div class="loader">
            <div class="loader__figure"></div>
            <p class="loader__label">adem bulut adem bulut</p>
        </div>
    </div>
    <!-- Main navbar -->
    <@header.header/>
    <!-- /main navbar -->


    <!-- Page container -->
    <div class="page-container">

        <!-- Page content -->
        <div class="page-content">

            <!-- Main sidebar -->
            <@sidebar.sidebar/>
            <!-- /main sidebar -->
            <!-- Main content -->
            <div class="content-wrapper">

                <!-- Page header -->
                <#call breadCrumb/>
                <!-- /page header -->


                <!-- Content area -->
                <div class="content">

                    <#nested />

                    <!-- Footer -->
                    <@footer.footer/>
                    <!-- /footer -->

                </div>
                <!-- /content area -->

            </div>
            <!-- /main content -->

        </div>
        <!-- /page content -->

    </div>
    <!-- /page container -->

    <!--modals-->
    <div id="modal_default" class="modal fade" style="display: none;">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal">×</button>
                    <h5 class="modal-title">modal title</h5>
                </div>

                <div class="modal-body">

                </div>
            </div>
        </div>
    </div>
    <!--/modals-->

    <!-- Core JS files -->

    <script type="text/javascript" src="/assets/js/plugins/loaders/pace.min.js"></script>
    <script type="text/javascript" src="/assets/js/core/libraries/jquery.min.js"></script>
    <script type="text/javascript" src="/assets/js/core/libraries/bootstrap.min.js"></script>
    <script type="text/javascript" src="/assets/js/plugins/loaders/blockui.min.js"></script>
    <!-- /core JS files -->

    <!-- Theme JS files -->
    <script type="text/javascript" src="/assets/js/plugins/forms/validation/validate.min.js"></script>
    <script type="text/javascript" src="/assets/js/plugins/forms/styling/uniform.min.js"></script>


    <script type="text/javascript" src="/assets/js/core/app.js"></script>
    <script type="text/javascript" src="/assets/app/js/application.js"></script>
    <!-- /theme JS files -->
    <#call footerSection/>

    </body>
    </html>

</#macro>