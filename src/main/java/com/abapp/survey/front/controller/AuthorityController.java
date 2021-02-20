package com.abapp.survey.front.controller;

import com.abapp.survey.backend.entity.auth.Role;
import com.abapp.survey.backend.entity.user.User;
import com.abapp.survey.backend.model.IUser;
import com.abapp.survey.contract.service.AuthorityService;
import com.abapp.survey.front.util.UserProfileManager;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

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

    @RequestMapping("/roles")
    public String getRoles(ModelMap map){
        List<Role> roles = authorityService.getAllRoles();
        map.put("role",new Role());
        map.put("roleList",roles);
        return "authority/roles";
    }
    @RequestMapping("/role-save")
    public String saveRole(@ModelAttribute Role role, HttpServletRequest request){
        User user = UserProfileManager.getLoggedUser(request);

        return "authority/roles";
    }






    public void setAuthorityService(AuthorityService authorityService) {
        this.authorityService = authorityService;
    }
}
