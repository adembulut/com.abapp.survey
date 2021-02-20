<#import "/shared/template/main-template.ftl" as template>
<#import "/spring.ftl" as spring/>
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
    <div class="row">
        <div class="col-md-12">
            <div class="panel panel-flat">
                <div class="panel-heading">
                    <h5 class="panel-title"><@spring.message code='survey.authority.newRole'/><a
                                class="heading-elements-toggle"><i class="icon-more"></i></a></h5>
                    <div class="heading-elements">
                        <ul class="icons-list">
                            <li><a data-action="collapse"></a></li>
                        </ul>
                    </div>
                </div>

                <div class="panel-body">
                    <form class="needs-validation" name="new-role">
                        <div class="row">
                            <div class="col-md-2">
                                <label for="roleCode"><@spring.message code='survey.authority.roleCode'/></label>
                                <input type="text" class="form-control" name="roleCode" id="roleCode"
                                       value="${role.roleCode}">
                            </div>
                            <div class="col-md-2">
                                <label for="roleName"><@spring.message code='survey.authority.roleName'/></label>
                                <input type="text" class="form-control" name="roleName" id="roleName"
                                       value="${role.roleName}">
                            </div>
                            <div class="col-md-8">
                                <label for="roleDescription"><@spring.message code='survey.authority.roleDescription'/></label>
                                <input type="text" class="form-control" name="roleDescription" id="roleDescription"
                                       value="${role.roleDescription}">
                            </div>
                        </div>
                        <div class="row mx-top-1">
                            <div class="col-md-12 text-right">
                                <button type="reset" class="btn btn-primary">
                                    <@spring.message code='survey.general.reset'/>
                                </button>
                                <button type="button" class="btn btn-primary" name="role-save">
                                    <span class="glyphicon glyphicon-save-file"></span>
                                    <@spring.message code='survey.authority.save'/>
                                </button>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>

    <div class="row">
        <div class="col-md-12">
            <div class="panel panel-flat">
                <div class="panel-heading">
                    <h5 class="panel-title"><@spring.message code='survey.authority.roles.table.head'/><a
                                class="heading-elements-toggle"><i class="icon-more"></i></a></h5>
                    <div class="heading-elements">
                        <ul class="icons-list">
                            <li><a data-action="collapse"></a></li>
                        </ul>
                    </div>
                </div>

                <div class="panel-body">
                    <@spring.message code='survey.authority.roles.table.info'/>
                </div>

                <div class="table-responsive">
                    <table class="table">
                        <thead>
                        <tr class="bg-blue">
                            <th><@spring.message code='survey.authority.roleCode'/></th>
                            <th><@spring.message code='survey.authority.roleName'/></th>
                            <th><@spring.message code='survey.authority.roleDescription'/></th>
                            <th><@spring.message code='survey.authority.actions'/></th>
                        </tr>
                        </thead>
                        <tbody>
                        <#list roleList as role>
                            <tr>
                                <td>${role.roleCode}</td>
                                <td>${role.roleName}</td>
                                <td>${role.roleDescription}</td>
                                <td>
                                    <button type="button" class="btn btn-success btn-xs">
                                        <i class="icon-pencil7"></i>
                                        <@spring.message code='survey.authority.process.button.editAuthorities'/>
                                    </button>
                                    <button type="button" class="btn btn-danger btn-xs">
                                        <i class="icon-box-remove"></i>
                                        <@spring.message code='survey.general.button.remove'/>
                                    </button>
                                </td>
                            </tr>
                        </#list>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>
</#macro>
