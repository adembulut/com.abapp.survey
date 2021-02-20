<#import "/templates/view/shared/template/main-template.ftl" as template>
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
            <li><a href="index.html"><i class="icon-home2 position-left"></i> Home</a></li>
            <li><a href="components_breadcrumbs.html">Components</a></li>
            <li class="active">Location</li>
        </ul>
    </div>
</#macro>

<#macro contentBody>
    Yetki testi
</#macro>
