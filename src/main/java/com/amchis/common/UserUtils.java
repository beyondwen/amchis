package com.amchis.common;

import com.amchis.bean.User;
import org.springframework.security.core.context.SecurityContextHolder;


public class UserUtils {
    public static User getCurrentUser() {
        User principal = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return principal;
    }
}
