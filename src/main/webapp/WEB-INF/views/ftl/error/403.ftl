<#import "/view/shared/template/main-template.ftl" as template>
<@template.html title="Anasayfa" headerSection=headerSection footerSection=footerSection breadCrumb=breadCrumb>
    <@contentBody/>
</@template.html>

<#macro headerSection>
</#macro>
<#macro footerSection>
</#macro>
<#macro breadCrumb>
</#macro>

<#macro contentBody>
    <div class="text-center content-group">
        <h1 class="error-title">403</h1>
        <h5>Oops, an error has occurred. Forbidden!</h5>
    </div>
    <!-- /error title -->


    <!-- Error content -->
    <div class="row">
        <div class="col-lg-4 col-lg-offset-4 col-sm-6 col-sm-offset-3">
            <form action="#" class="main-search panel panel-body">

                <div class="text-center">
                    <a href="/" class="btn bg-pink-400"><i class="icon-circle-left2 position-left"></i>
                        <@spring.message code='survey.general.backToDashboard'/>
                    </a>
                </div>
            </form>
        </div>
    </div>
</#macro>