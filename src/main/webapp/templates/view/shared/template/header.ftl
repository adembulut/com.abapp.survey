<#macro header>
    <!-- Main navbar -->
    <div class="navbar navbar-inverse">
        <div class="navbar-header">
            <a class="navbar-brand" href="/">
                <span>ABAPP</span>
            </a>

            <ul class="nav navbar-nav visible-xs-block">
                <li><a data-toggle="collapse" data-target="#navbar-mobile"><i class="icon-tree5"></i></a></li>
                <li><a class="sidebar-mobile-main-toggle"><i class="icon-paragraph-justify3"></i></a></li>
            </ul>
        </div>

        <div class="navbar-collapse collapse" id="navbar-mobile">
            <ul class="nav navbar-nav">
                <li><a class="sidebar-control sidebar-main-toggle hidden-xs"><i class="icon-paragraph-justify3"></i></a></li>
            </ul>



            <ul class="nav navbar-nav navbar-right">

                <li class="dropdown dropdown-user">
                    <a class="dropdown-toggle" data-toggle="dropdown">
                        <img src="assets/images/image.png" alt="">
                        <span>${applicationUser.nameSurname}</span>
                        <i class="caret"></i>
                    </a>

                    <ul class="dropdown-menu dropdown-menu-right">
                        <li><a href="#"><i class="icon-user-plus"></i> <@spring.message code='survey.general.myAccount'/></a></li>
                        <li><a href="/logout"><i class="icon-switch2"></i> <@spring.message code='survey.general.logout'/></a></li>
                    </ul>
                </li>
            </ul>
            <ul class="nav navbar-nav navbar-right">
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                        <i class="icon-flag3"></i>
                        <span class="visible-xs-inline-block position-right">
                            <@spring.message code='survey.general.language'/>
                        </span>
                    </a>
                    <ul class="dropdown-menu">
                        <li class="<#if .locale=='en'>active</#if>">
                            <a class="english" href="?locale=en">
                                <img src="/assets/images/flags/gb.png" alt=""> English
                            </a>
                        </li>
                        <li class="<#if .locale=='tr'>active</#if>">
                            <a class="turkish" href="?locale=tr">
                                <img src="/assets/images/flags/tr.png" alt=""> Türkçe
                            </a>
                        </li>
                    </ul>
                </li>
            </ul>
        </div>
    </div>
    <!-- /main navbar -->
</#macro>

<#--<#macro header>-->
<#--    <div class="navbar navbar-inverse bg-indigo">-->
<#--        <div class="navbar-header">-->
<#--            <a class="navbar-brand" href="index.html"><img src="/assets/images/logo_light.png" alt=""></a>-->

<#--            <ul class="nav navbar-nav visible-xs-block">-->
<#--                <li><a data-toggle="collapse" data-target="#navbar-mobile"><i class="icon-tree5"></i></a></li>-->
<#--                <li><a class="sidebar-mobile-main-toggle"><i class="icon-paragraph-justify3"></i></a></li>-->
<#--            </ul>-->
<#--        </div>-->

<#--        <div class="navbar-collapse collapse" id="navbar-mobile">-->
<#--            <ul class="nav navbar-nav">-->
<#--                <li><a class="sidebar-control sidebar-main-toggle hidden-xs"><i class="icon-paragraph-justify3"></i></a></li>-->

<#--                <li class="dropdown">-->
<#--                    <a href="#" class="dropdown-toggle" data-toggle="dropdown">-->
<#--                        <i class="icon-puzzle3"></i>-->
<#--                        <span class="visible-xs-inline-block position-right">Git updates</span>-->
<#--                        <span class="status-mark border-orange-400"></span>-->
<#--                    </a>-->

<#--                    <div class="dropdown-menu dropdown-content">-->
<#--                        <div class="dropdown-content-heading">-->
<#--                            Git updates-->
<#--                            <ul class="icons-list">-->
<#--                                <li><a href="#"><i class="icon-sync"></i></a></li>-->
<#--                            </ul>-->
<#--                        </div>-->

<#--                        <ul class="media-list dropdown-content-body width-350">-->
<#--                            <li class="media">-->
<#--                                <div class="media-left">-->
<#--                                    <a href="#" class="btn border-primary text-primary btn-flat btn-rounded btn-icon btn-sm"><i class="icon-git-pull-request"></i></a>-->
<#--                                </div>-->

<#--                                <div class="media-body">-->
<#--                                    Drop the IE <a href="#">specific hacks</a> for temporal inputs-->
<#--                                    <div class="media-annotation">4 minutes ago</div>-->
<#--                                </div>-->
<#--                            </li>-->

<#--                            <li class="media">-->
<#--                                <div class="media-left">-->
<#--                                    <a href="#" class="btn border-warning text-warning btn-flat btn-rounded btn-icon btn-sm"><i class="icon-git-commit"></i></a>-->
<#--                                </div>-->

<#--                                <div class="media-body">-->
<#--                                    Add full font overrides for popovers and tooltips-->
<#--                                    <div class="media-annotation">36 minutes ago</div>-->
<#--                                </div>-->
<#--                            </li>-->

<#--                            <li class="media">-->
<#--                                <div class="media-left">-->
<#--                                    <a href="#" class="btn border-info text-info btn-flat btn-rounded btn-icon btn-sm"><i class="icon-git-branch"></i></a>-->
<#--                                </div>-->

<#--                                <div class="media-body">-->
<#--                                    <a href="#">Chris Arney</a> created a new <span class="text-semibold">Design</span> branch-->
<#--                                    <div class="media-annotation">2 hours ago</div>-->
<#--                                </div>-->
<#--                            </li>-->

<#--                            <li class="media">-->
<#--                                <div class="media-left">-->
<#--                                    <a href="#" class="btn border-success text-success btn-flat btn-rounded btn-icon btn-sm"><i class="icon-git-merge"></i></a>-->
<#--                                </div>-->

<#--                                <div class="media-body">-->
<#--                                    <a href="#">Eugene Kopyov</a> merged <span class="text-semibold">Master</span> and <span class="text-semibold">Dev</span> branches-->
<#--                                    <div class="media-annotation">Dec 18, 18:36</div>-->
<#--                                </div>-->
<#--                            </li>-->

<#--                            <li class="media">-->
<#--                                <div class="media-left">-->
<#--                                    <a href="#" class="btn border-primary text-primary btn-flat btn-rounded btn-icon btn-sm"><i class="icon-git-pull-request"></i></a>-->
<#--                                </div>-->

<#--                                <div class="media-body">-->
<#--                                    Have Carousel ignore keyboard events-->
<#--                                    <div class="media-annotation">Dec 12, 05:46</div>-->
<#--                                </div>-->
<#--                            </li>-->
<#--                        </ul>-->

<#--                        <div class="dropdown-content-footer">-->
<#--                            <a href="#" data-popup="tooltip" title="All activity"><i class="icon-menu display-block"></i></a>-->
<#--                        </div>-->
<#--                    </div>-->
<#--                </li>-->
<#--            </ul>-->

<#--            <div class="navbar-right">-->
<#--&lt;#&ndash;                <p class="navbar-text">&ndash;&gt;-->
<#--&lt;#&ndash;                    &ndash;&gt;-->
<#--&lt;#&ndash;                </p>&ndash;&gt;-->

<#--                <ul class="nav navbar-nav">-->
<#--                    <li class="dropdown">-->
<#--                        <a href="#" class="dropdown-toggle" data-toggle="dropdown">-->
<#--                            <i class="icon-flag3"></i>-->
<#--                            <span class="visible-xs-inline-block position-right">Language</span>-->
<#--                            <span class="status-mark border-orange-400"></span>-->
<#--                        </a>-->
<#--                        <ul class="dropdown-menu">-->
<#--                            <li class="<#if .locale=='en'>active</#if>">-->
<#--                                <a class="english" href="?locale=en">-->
<#--                                    <img src="/assets/images/flags/gb.png" alt=""> English-->
<#--                                </a>-->
<#--                            </li>-->
<#--                            <li class="<#if .locale=='tr'>active</#if>">-->
<#--                                <a class="turkish" href="?locale=tr">-->
<#--                                    <img src="/assets/images/flags/tr.png" alt=""> Türkçe-->
<#--                                </a>-->
<#--                            </li>-->
<#--                        </ul>-->
<#--                    </li>-->
<#--                </ul>-->

<#--                <ul class="nav navbar-nav">-->
<#--                    <li class="dropdown">-->
<#--                        <a href="#" class="dropdown-toggle" data-toggle="dropdown">-->
<#--                            <@spring.message code='survey.header.hi'/> ${applicationUser.nameSurname}!-->
<#--                            <span class="visible-xs-inline-block position-right">-->
<#--                                <@spring.message code='survey.general.myAccount'/>-->
<#--                            </span>-->
<#--                            <span class="status-mark border-orange-400"></span>-->
<#--                        </a>-->
<#--                        <ul class="dropdown-menu">-->
<#--                            <li>-->
<#--                                <a class="" href="#">-->
<#--                                    <i class="icon-user-check"></i>-->
<#--                                    <@spring.message code='survey.general.myProfile'/>-->
<#--                                </a>-->
<#--                            </li>-->
<#--                            <li class="">-->
<#--                                <a class="turkish" href="/logout">-->
<#--                                    <i class="icon-exit"></i>-->
<#--                                    <@spring.message code='survey.general.logout'/>-->
<#--                                </a>-->
<#--                            </li>-->
<#--                        </ul>-->
<#--                    </li>-->
<#--                </ul>-->


<#--            </div>-->
<#--        </div>-->
<#--    </div>-->
<#--</#macro>-->