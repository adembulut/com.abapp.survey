package com.abapp.survey.front.controller;

import com.abapp.survey.backend.entity.auth.Role;
import com.abapp.survey.backend.entity.base.base.BaseEntity;
import com.abapp.survey.backend.entity.user.User;
import com.abapp.survey.backend.model.BaseResult;
import com.abapp.survey.contract.service.AuthorityService;
import com.abapp.survey.front.util.UserProfileManager;
import com.google.gson.Gson;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/*
    Project : com.abapp.survey
    User    : adem.bulut
    Date    : 2/14/21 22:57
*/
@Controller
@RequestMapping("/authority")
public class AuthorityController {
    private AuthorityService authorityService;

    @GetMapping("/roles")
    public String getRoles(ModelMap map) {
        BaseResult<List<Role>> roles = authorityService.getAllRoles();
        map.addAttribute("role", new Role());
        map.addAttribute("roleList", roles.getData());
        return "authority/roles";
    }


    //ajax-begin
    @RequestMapping("/role-save")
    @ResponseBody
    public String saveRole(@ModelAttribute Role role, HttpServletRequest request) {
        User user = UserProfileManager.getLoggedUser(request);
        role.setUpdatedBy(user.getUsername());
        BaseResult<Boolean> result = authorityService.addRole(role);
        return new Gson().toJson(result);
    }
    @RequestMapping("/role-remove")
    @ResponseBody
    public BaseResult<Boolean> removeRole(String roleCode,HttpServletRequest request){
        User user = UserProfileManager.getLoggedUser(request);
        Role role = new Role();
        role.setRoleCode(roleCode);
        role.setUpdatedBy(user.getUsername());
        return authorityService.removeRole(role);
    }
    //ajax-end


    public void setAuthorityService(AuthorityService authorityService) {
        this.authorityService = authorityService;
    }
}
