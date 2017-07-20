package org.fkit.hrm.dao;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;
import org.fkit.hrm.dao.provider.EmployeeDynaSqlProvider;
import org.fkit.hrm.domain.Employee;

import java.util.List;
import java.util.Map;

import static org.fkit.hrm.util.common.HrmConstants.EMPLOYEETABLE;
/**
 * Created by xufuxiu on 2017/7/18.
 */
public interface EmployeeDao
{
    /*根据参数查询总数*/
    @SelectProvider(type = EmployeeDynaSqlProvider.class, method = "count")
    Integer count(Map<String, Object> params);

    /*动态查询用户*/
    @SelectProvider(type = EmployeeDynaSqlProvider.class, method = "selectWithParam")
    @Results({//当domain中包含对象属性时需要使用mybatis注解支持的动态SQL语句
            @Result(id=true,column = "id",property = "id"),
            @Result(column = "CAR_ID",property="cardId"),
            @Result(column = "POST_CODE",property = "postcode"),
            @Result(column = "QQ_NUM",property = "qqNum"),
            @Result(column = "BIRTHDAY",property = "birthday"),
            @Result(column = "CREATE_DATE",property = "createDate",javaType = java.util.Date.class),
            @Result(column = "DEPT_ID",property = "dept",
                    one=@One(
                            select="org.fkit.hrm.dao.DeptDao.selectById",
                            fetchType= FetchType.EAGER)),
            @Result(column = "JOB_ID",property = "job",one=@One(
                    select="org.fkit.hrm.dao.JobDao.selectById",
                    fetchType= FetchType.EAGER))

    })
    List<Employee> selectByPage(Map<String, Object> params);


    @SelectProvider(type = EmployeeDynaSqlProvider.class,method="insertEmployee")
    void save(Employee employee);

    @Delete("delete from" + EMPLOYEETABLE + "where id=#{id")
    void deleteById(Integer id);

    @Select("select * from" + EMPLOYEETABLE + "WHERE id=#{id}")
    @Results({
            @Result(id=true,column = "id",property = "id"),
            @Result(column = "CAR_ID",property="cardId"),
            @Result(column = "POST_CODE",property = "postcode"),
            @Result(column = "QQ_NUM",property = "qqNum"),
            @Result(column = "BIRTHDAY",property = "birthday"),
            @Result(column = "CREATE_DATE",property = "createDate",javaType = java.util.Date.class),
            @Result(column = "DEPT_ID",property = "dept",
                    one=@One(
                            select="org.fkit.hrm.dao.DeptDao.selectById",
                            fetchType= FetchType.EAGER)),
            @Result(column = "JOB_ID",property = "job",one=@One(
                    select="org.fkit.hrm.dao.JobDao.selectById",
                    fetchType= FetchType.EAGER))

    })
    Employee selectById(Integer id);


    @SelectProvider(type = EmployeeDynaSqlProvider.class,method ="updateEmployee" )
    void update(Employee employee);


}
