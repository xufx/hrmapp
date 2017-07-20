package org.fkit.hrm.dao;
import org.apache.ibatis.annotations.*;
import org.fkit.hrm.dao.provider.UserDynaSqlProvider;
import org.fkit.hrm.domain.User;

import java.util.List;
import java.util.Map;

import static org.fkit.hrm.util.common.HrmConstants.USERTABLE;
/**
 * Created by xufuxiu on 2017/7/18.
 */
public interface UserDao
{
    @Select("select * from " + USERTABLE + " WHERE loginname=#{loginname}and password=#{password}")
    User selectByLoginnameAndPassword(@Param("loginname") String loginname, @Param("password") String password);

    @Select("select * from " + USERTABLE + " WHERE id=#{id}")
    User selectById(Integer id);

    @Delete("delete from " + USERTABLE + " where id=#{id")
    void deleteById(Integer id);

    @SelectProvider(type = UserDynaSqlProvider.class,method ="updateUser" )
    void update(User user);

    /*动态查询用户*/
    @SelectProvider(type = UserDynaSqlProvider.class, method = "selectWithParam")
    List<User> selectByPage(Map<String,Object> params);

    /*根据参数查询用户总数*/
    @SelectProvider(type = UserDynaSqlProvider.class, method = "count")
    Integer count(Map<String, Object> params);

    @SelectProvider(type = UserDynaSqlProvider.class,method="insertUser")
    void save(User user);
}
