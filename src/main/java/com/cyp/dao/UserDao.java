package com.cyp.dao;

import com.cyp.entity.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * Created by CYP on 2018/6/5.
 */
@Repository
public interface UserDao {
    //添加用户
    public void addUser(User user);

    //根据用户名和密码查询用户
    //注解的两个参数会自动封装成map集合，括号内即为键
    public void findUserByNameAndPwd(@Param("userName")String userName, @Param("password")String password);
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    User findByUsername(String userName);
}
