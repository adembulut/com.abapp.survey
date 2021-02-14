<#macro sidebar>
    <div class="sidebar sidebar-main sidebar-default">
        <div class="sidebar-content">

            <!-- User menu -->
            <div class="sidebar-user-material">
                <div class="category-content">
                    <div class="sidebar-user-material-content">
                        <a href="#"><img src="assets/images/demo/users/face12.jpg" class="img-circle img-responsive"
                                         alt=""></a>
                        <h6>
                            ${applicationUser.nameSurname}
                        </h6>
                        <span class="text-size-small">${applicationUser.email}</span>
                    </div>

                    <div class="sidebar-user-material-menu">
                        <a href="#user-nav"
                           data-toggle="collapse"><span><@spring.message code='survey.general.myAccount'/></span> <i
                                    class="caret"></i></a>
                    </div>
                </div>

                <div class="navigation-wrapper collapse" id="user-nav">
                    <ul class="navigation">
                        <li><a href="#"><i class="icon-user-plus"></i> <span>
                                    <@spring.message code='survey.general.myProfile'/>
                                </span></a></li>
                        <#--                        <li><a href="#"><i class="icon-coins"></i> <span>My balance</span></a></li>-->
                        <#--                        <li><a href="#"><i class="icon-comment-discussion"></i> <span><span class="badge bg-teal-400 pull-right">58</span> Messages</span></a></li>-->
                        <#--                        <li class="divider"></li>-->
                        <#--                        <li><a href="#"><i class="icon-cog5"></i> <span>Account settings</span></a></li>-->
                        <li><a href="/logout"><i class="icon-switch2"></i>
                                <span><@spring.message code='survey.general.logout'/></span></a></li>
                    </ul>
                </div>
            </div>
            <!-- /user menu -->


            <!-- Main navigation -->
            <div class="sidebar-category sidebar-category-visible">
                <div class="category-content no-padding">
                    <ul class="navigation navigation-main navigation-accordion">
                        <li>
                            <a href="/"><i class="icon-home4"></i>
                                <span>
                                    <@spring.message code='survey.menu.dashboard'/>
                                </span>
                            </a>
                        </li>

                        <li>
                            <a href="#"><i class="icon-stack2"></i> <span>Page layouts</span></a>
                            <ul>
                                <li><a href="layout_navbar_fixed.html">Fixed navbar</a></li>
                                <li><a href="layout_navbar_sidebar_fixed.html">Fixed navbar &amp; sidebar</a></li>
                                <li><a href="layout_sidebar_fixed_native.html">Fixed sidebar native scroll</a></li>
                                <li><a href="layout_navbar_hideable.html">Hideable navbar</a></li>
                                <li><a href="layout_navbar_hideable_sidebar.html">Hideable &amp; fixed sidebar</a></li>
                                <li><a href="layout_footer_fixed.html">Fixed footer</a></li>
                                <li class="navigation-divider"></li>
                                <li><a href="boxed_default.html">Boxed with default sidebar</a></li>
                                <li><a href="boxed_mini.html">Boxed with mini sidebar</a></li>
                                <li><a href="boxed_full.html">Boxed full width</a></li>
                            </ul>
                        </li>
                        <li>
                            <a href="#"><i class="icon-copy"></i> <span>Layouts</span></a>
                            <ul>
                                <li><a href="../index.html" id="layout1">Layout 1</a></li>
                                <li><a href="index.html" id="layout2">Layout 2 <span class="label bg-warning-400">Current</span></a>
                                </li>
                                <li><a href="../../../layout_3/LTR/index.html" id="layout3">Layout 3</a></li>
                                <li><a href="../../../layout_4/LTR/index.html" id="layout4">Layout 4</a></li>
                                <li><a href="../../../layout_5/LTR/index.html" id="layout5">Layout 5</a></li>
                                <li class="disabled"><a href="../../../layout_6/LTR/index.html" id="layout6">Layout 6
                                        <span class="label label-transparent">Coming soon</span></a></li>
                            </ul>
                        </li>
                    </ul>
                </div>
            </div>
            <!-- /main navigation -->

        </div>
    </div>
</#macro>