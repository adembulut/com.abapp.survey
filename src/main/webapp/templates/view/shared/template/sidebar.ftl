<#macro sidebar>
    <div class="sidebar sidebar-main sidebar-default">
        <div class="sidebar-content">

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
                            <a href="#"><i class="icon-copy"></i> <span>
                                    <@spring.message code='survey.menu.authorityManagement'/>
                                </span></a>
                            <ul>
                                <li><a href="/authority/roles" id="roles"><@spring.message code='survey.menu.roles'/></a></li>
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