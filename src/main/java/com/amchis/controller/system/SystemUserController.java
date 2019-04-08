package com.amchis.controller.system;

import com.amchis.bean.User;
import com.amchis.bean.base.BaseApiService;
import com.amchis.bean.base.BaseResponse;
import com.amchis.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/system/user")
public class SystemUserController extends BaseApiService<User> {
    @Autowired
    UserService userService;

    @RequestMapping("/id/{userId}")
    public User getHrById(@PathVariable Long userId) {
        return userService.getUserById(userId);
    }

    @RequestMapping(value = "/{userId}", method = RequestMethod.DELETE)
    public BaseResponse<User> deleteHr(@PathVariable Long userId) {
        if (userService.deleteUser(userId) == 1) {
            return setResultSuccess("删除成功");
        }
        return setResultSuccess("删除失败");
    }

    @RequestMapping(value = "/", method = RequestMethod.PUT)
    public BaseResponse<User> updateUser(User user) {
        if (userService.updateUser(user) == 1) {
            return setResultSuccess("更新成功");
        }
        return setResultSuccess("更新失败");
    }

    @RequestMapping(value = "/roles", method = RequestMethod.PUT)
    public BaseResponse<User> updateUserRoles(Long userId, Long[] rids) {
        if (userService.updateUserRoles(userId, rids) == rids.length) {
            return setResultSuccess("更新成功");
        }
        return setResultSuccess("更新失败");
    }

    @RequestMapping("/{keywords}")
    public List<User> getHrsByKeywords(@PathVariable(required = false) String keywords) {
        List<User> hrs = userService.getHrsByKeywords(keywords);
        return hrs;
    }


    @RequestMapping(value = "/user/reg", method = RequestMethod.POST)
    public BaseResponse<User> hrReg(String username, String password) {
        int i = userService.userReg(username, password);
        if (i == 1) {
            return setResultSuccess("注册成功!");
        } else if (i == -1) {
            return setResultError("用户名重复，注册失败!");
        }
        return setResultError("注册失败!");
    }

}
