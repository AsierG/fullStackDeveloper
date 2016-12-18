package com.fullstack.test.integration;


import com.fullstack.FullstackApplication;
import com.fullstack.backend.persistence.domain.backend.Role;
import com.fullstack.backend.persistence.domain.backend.User;
import com.fullstack.backend.persistence.domain.backend.UserRole;
import com.fullstack.backend.service.UserService;
import com.fullstack.enums.PlansEnum;
import com.fullstack.enums.RolesEnum;
import com.fullstack.utils.UserUtils;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.HashSet;
import java.util.Set;

@RunWith(value = SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(FullstackApplication.class)
public class UserServiceIntegrationTest {

    @Autowired
    private UserService userService;

    @Test
    public void testCreateNewUser() throws Exception {

        Set<UserRole> userRoles = new HashSet<>();
        User basicUser = UserUtils.createBasicUser();
        userRoles.add(new UserRole(basicUser, new Role(RolesEnum.BASIC)));

        User user = userService.createUser(basicUser, PlansEnum.BASIC, userRoles);
        Assert.assertNotNull(user);
        Assert.assertNotNull(user.getId());

    }
}