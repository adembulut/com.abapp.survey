package com.abapp.survey.test;

import com.abapp.survey.backend.utils.PasswordUtil;
import org.junit.Assert;
import org.junit.Test;

/*
    Project : com.abapp.survey
    User    : adem.bulut
    Date    : 2/14/21 22:22
*/
public class PasswordTest {

//    @Test
    public void test() {
        String originalPassword = "merdiye";
        String hashedPassword = PasswordUtil.encodePassword(originalPassword);
        String newHashedPassword = PasswordUtil.encodePassword(originalPassword);

        Assert.assertEquals(hashedPassword,newHashedPassword);
    }
}
