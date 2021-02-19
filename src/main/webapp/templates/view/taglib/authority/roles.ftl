<#macro content roleList>
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
                            <li>
                                <button class="btn btn-primary btn-sm" type="button" name="btn-role-new">
                                    <@spring.message code='survey.authority.newRole'/>
                                </button>
                            </li>
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
                            <th><@spring.message code='survey.authority.roleDescription'/></th>
                            <th><@spring.message code='survey.authority.actions'/></th>
                        </tr>
                        </thead>
                        <tbody>
                        <#list roleList as role>
                            <tr>
                                <td>${role.code}</td>
                                <td>${role.description}</td>
                                <td>actions</td>
                            </tr>
                        </#list>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>
</#macro>