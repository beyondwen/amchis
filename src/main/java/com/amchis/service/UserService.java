package com.amchis.service;

import com.amchis.bean.User;
import com.amchis.common.UserUtils;
import com.amchis.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by sang on 2017/12/28.
 */
@Service
@Transactional
public class UserService implements UserDetailsService {

    @Autowired
    UserMapper userMapper;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user = userMapper.loadUserByUsername(s);
        if (user == null) {
            throw new UsernameNotFoundException("用户名不对");
        }
        return user;
    }

    public int userReg(String username, String password) {
        //如果用户名存在，返回错误
        if (userMapper.loadUserByUsername(username) != null) {
            return -1;
        }
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String encode = encoder.encode(password);
        return userMapper.userReg(username, encode);
    }

    public List<User> getHrsByKeywords(String keywords) {
        return userMapper.getUsersByKeywords(keywords);
    }

    public int updateUser(User user) {
        return userMapper.updateUser(user);
    }

    public int updateUserRoles(Long uId, Long[] rids) {
        int i = userMapper.deleteRoleByUserId(uId);
        return userMapper.addRolesForUser(uId, rids);
    }

    public User getUserById(Long uId) {
        return userMapper.getUserById(uId);
    }

    public int deleteUser(Long uId) {
        return userMapper.deleteUser(uId);
    }

    public List<User> getAllUserExceptAdmin() {
        return userMapper.getAllUser(UserUtils.getCurrentUser().getId());
    }

    public List<User> getAllUser() {
        return userMapper.getAllUser(null);
    }
}
