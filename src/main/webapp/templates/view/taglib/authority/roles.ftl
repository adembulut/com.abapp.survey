<#macro content roleList>
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
    <div id="new-role-body" class="col-md-6">
        <div class="row">
            <div class="col-md-12">
                <form id="form-new-role">
                    <div class="row">
                        <div class="col-md-12">
                            <div class="form-group has-feedback">
                                <input type="text" class="form-control" placeholder="Second name">
                                <div class="form-control-feedback">
                                    <i class="icon-user-check text-muted"></i>
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="role-code"><@spring.message code='survey.authority.roleCode'/>:</label>
                                <input type="text" id="role-code" name="role-code" class="form-control">
                            </div>
                        </div>
                    </div>
                </form>
            </div>
        </div>
        <div class="row">
            <div class="col-md-12 text-right">
                <button type="button" class="btn btn-link btn-sm">
                    <@spring.message code='survey.authority.cancel'/>
                </button>
                <button type="button" class="btn btn-primary btn-sm">
                    <@spring.message code='survey.authority.save'/>
                </button>
            </div>
        </div>
    </div>
</#macro>