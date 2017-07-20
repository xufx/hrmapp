package org.fkit.hrm.dao;
import org.apache.ibatis.annotations.*;
import org.fkit.hrm.dao.provider.JobDynaSqlProvider;
import org.fkit.hrm.domain.Job;

import java.util.List;
import java.util.Map;

import static org.fkit.hrm.util.common.HrmConstants.JOBTABLE;
/**
 * Created by xufuxiu on 2017/7/18.
 */
public interface JobDao
{

    @Select("select * from"+JOBTABLE+"where id=#{id}")
   Job selectById(Integer id);//根据id查询

    @Select("select * from "+JOBTABLE+" ")
    List<Job> selecAllJob();//查询所有行

    @SelectProvider(type =JobDynaSqlProvider.class,method="selectWithParam")
    List<Job> selectByPage(Map<String, Object> params);//动态查询

    @SelectProvider(type =JobDynaSqlProvider.class,method="count")
    Integer count(Map<String, Object> params);//计算满足查询条件的对象数量

    @Delete("delete * from"+JOBTABLE+"where id=#{id}")
    void deleteById(Integer id);//根据id删除

    @SelectProvider(type =JobDynaSqlProvider.class,method="insertJob")
    void save(Job job);//动态插入

    @SelectProvider(type =JobDynaSqlProvider.class,method="updateJob")
    void update(Job job);//动态修改
}
