package org.fkit.hrm.dao.provider;
import org.apache.ibatis.jdbc.SQL;
import org.fkit.hrm.domain.Dept;

import java.util.Map;

import static org.fkit.hrm.util.common.HrmConstants.DEPTTABLE;
/**
 * Created by xufuxiu on 2017/7/18.
 */
public class DeptDynaSqlProvider
{
    public String selectWithParam(Map<String,Object> params)
    {
        String sql=new SQL()
        {
            {
                SELECT("*");
                FROM(DEPTTABLE);
                if (params.get("dept") != null)
                {
                    Dept dept = (Dept) params.get("dept");
                    if (dept.getName() != null && !dept.getName().equals(""))
                    {
                        WHERE("name LIKE CONCAT('%',#{dept.name},'%')");
                    }
                }
            }
        }.toString();
        if (params.get("pageModel")!=null)
        {
            sql+="limit#{pageModel.firstLimitParam},#{pageModel.pageSize}";
        }
        return sql;
    }

    public String count(Map<String,Object> params)
    {//动态查询总数量
        return  new SQL()
        {
            {
                SELECT("COUNT(*)");
                FROM (DEPTTABLE);
                if (params.get("dept")!=null)
                {
                    Dept dept = (Dept) params.get("dept");
                    if (dept.getName() != null && !dept.getName().equals(""))
                    {
                        WHERE("name LIKE CONCAT('%',#{dept.name},'%')");
                    }
                }
            }
        }.toString();
    }

    public String insertDept(Dept dept)
    {//动态插入用户
        return  new SQL()
        {
            {
                INSERT_INTO(DEPTTABLE);
                if (dept.getName() != null && !dept.getName().equals(""))
                {
                    VALUES("name","#{name");
                }
                if (dept.getRemark() != null && !dept.getRemark().equals(""))
                {
                    VALUES("remark","#{remark");
                }
            }

        }.toString();
    }

    public String updateDept(Dept dept)
    {
        return  new SQL()
        {
            {
                UPDATE(DEPTTABLE);
                if (dept.getName() != null )
                {
                    SET("name=#{name");
                }
                if (dept.getRemark() != null)
                {
                    SET("remark=#{remark}");
                }
            }

        }.toString();
    }
}
