package org.fkit.hrm.dao;
import org.apache.ibatis.annotations.*;
import org.fkit.hrm.dao.provider.DeptDynaSqlProvider;
import org.fkit.hrm.domain.Dept;

import java.util.List;
import java.util.Map;

import static org.fkit.hrm.util.common.HrmConstants.DEPTTABLE;
/**
 * Created by xufuxiu on 2017/7/18.
 */
public interface DeptDao
{
    @SelectProvider(type = DeptDynaSqlProvider.class,method="selectWithParam")
    List<Dept> selectByPage(Map<String,Object> params);

    @SelectProvider(type = DeptDynaSqlProvider.class,method="count")
    Integer count(Map<String,Object> params);

    @Select("select * from"+DEPTTABLE+"where id=#{id}")
    Dept selectById(Integer id);

    @Select("select * from "+DEPTTABLE+" ")
    List<Dept> selectAllDept();

    @Delete("delete * from"+DEPTTABLE+"where id=#{id}")
    void deleteById(Integer id);

    @SelectProvider(type = DeptDynaSqlProvider.class,method="insertDept")
    void save(Dept dept);

    @SelectProvider(type = DeptDynaSqlProvider.class,method="updateDept")
    void update(Dept dept);
}
