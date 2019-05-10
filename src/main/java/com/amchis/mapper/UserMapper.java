package com.amchis.mapper;

import com.amchis.bean.Role;
import com.amchis.bean.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserMapper {

    /**
     * @param username 登录用户名称
     * @return user 用户
     */
    User loadUserByUsername(String username);

    /**
     * 根据用户id查询所有的角色
     *
     * @param id 用户id
     * @return List<Role> 角色集合
     */
    List<Role> getRolesByUserId(Long id);

    /**
     * 用户注册
     *
     * @param username 用户名称
     * @param password 密码
     * @return 返回插入数量
     */
    int userReg(@Param("username") String username, @Param("password") String password);

    /**
     * 根据关键字查询用户集合
     *
     * @param keywords 关键词
     * @return List<User> 用户集合
     */
    List<User> getUsersByKeywords(@Param("keywords") String keywords);

    /**
     * 更新用户
     *
     * @param user 对象
     * @return 插入成功数量
     */
    int updateUser(User user);

    /**
     * 删除用户对应的角色
     *
     * @param userId 用户id
     * @return 是否删除成功
     */
    int deleteRoleByUserId(Long userId);

    /**
     * 为用户批量设置角色
     *
     * @param userId 用户id
     * @param rids   角色ids
     * @return 是否成功
     */
    int addRolesForUser(@Param("UserId") Long userId, @Param("rids") Long[] rids);

    /**
     * 通过userid 查询用户
     *
     * @param userId 用户id
     * @return user对象
     */
    User getUserById(Long userId);

    /**
     * 通过userid 删除用户
     *
     * @param userId 用户id
     * @return 是否成功
     */
    int deleteUser(Long userId);

    /**
     * 查询所有用户
     *
     * @param currentId 当前用户id
     * @return 返回所有用户集合
     */
    List<User> getAllUser(@Param("currentId") Long currentId);
}
