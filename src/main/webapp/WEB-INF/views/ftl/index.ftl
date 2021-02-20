<#import "/shared/template/main-template.ftl" as template>
<@template.html title="Anasayfa" headerSection=headerSection footerSection=footerSection breadCrumb=breadCrumb>
    <@contentBody/>
</@template.html>

<#macro headerSection>
</#macro>
<#macro footerSection>
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
        </ul>
    </div>
</#macro>

<#macro contentBody>
    Content burada yer alacak.
</#macro>
