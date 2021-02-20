package com.abapp.survey.front.controller;

import com.abapp.survey.backend.entity.auth.Role;
import com.abapp.survey.contract.service.AuthorityService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

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

    @RequestMapping("/roles")
    public String getRoles(ModelMap map){
        List<Role> roles = authorityService.getAllRoles();
        Role role = new Role();
        role.setRoleCode("adem");
        map.put("role",role);
        map.put("roleList",roles);

        return "authority/roles";
    }

    public void setAuthorityService(AuthorityService authorityService) {
        this.authorityService = authorityService;
    }
}
