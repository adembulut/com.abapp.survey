<#import "/view/shared/template/main-template.ftl" as template>
<#import "/view/taglib/authority/roles.ftl" as role_tag>
<@template.html title="Anasayfa" headerSection=headerSection footerSection=footerSection breadCrumb=breadCrumb>
    <@contentBody/>
</@template.html>

<#macro headerSection>
</#macro>
<#macro footerSection>
    <script type="text/javascript" src="/assets/app/js/authority/roles.js"></script>
</#macro>
<#macro breadCrumb>
    <div class="breadcrumb-line"><a class="breadcrumb-elements-toggle"><i class="icon-menu-open"></i></a>
        <ul class="breadcrumb">
            <li>
                <a href="/">
                    <i class="icon-home2 position-left"></i>
                    <@spring.message code='survey.menu.home'/>
                </a>
            </li>
            <li class="active">
                <a href="/authority/roles" class="active">
                    <i class="icon-home2 position-left"></i>
                    <@spring.message code='survey.menu.roles'/>
                </a>
            </li>
        </ul>
    </div>
</#macro>

<#macro contentBody>
    <@role_tag.content roleList=roleList/>
</#macro>
