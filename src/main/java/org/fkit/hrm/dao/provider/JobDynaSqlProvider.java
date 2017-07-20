package org.fkit.hrm.dao.provider;
import org.apache.ibatis.jdbc.SQL;
import org.fkit.hrm.domain.Job;

import java.util.Map;

import static org.fkit.hrm.util.common.HrmConstants.JOBTABLE;
/**
 * Created by xufuxiu on 2017/7/18.
 */
public class JobDynaSqlProvider
{
    public String selectWithParam(Map<String,Object> params)
    {
        String sql=new SQL()
        {
            {
                SELECT("*");
                FROM(JOBTABLE);
                if (params.get("job") != null)
                {
                    Job job = (Job) params.get("job");
                    if (job.getName() != null && !job.getName().equals(""))
                    {
                        WHERE("name LIKE CONCAT('%',#{job.name},'%')");
                    }
                }
            }
        }.toString();
        if (params.get("pageModel")!=null)
        {
            sql+=" limit #{pageModel.firstLimitParam},#{pageModel.pageSize}";
        }
        return sql;
    }

    public String count(Map<String,Object> params)
    {//动态查询总数量
        return  new SQL()
        {
            {
                SELECT("COUNT(*)");
                FROM (JOBTABLE);
                if (params.get("job")!=null)
                {
                    Job job = (Job) params.get("job");
                    if (job.getName() != null && !job.getName().equals(""))
                    {
                        WHERE("name LIKE CONCAT('%',#{job.name},'%')");
                    }
                }
            }
        }.toString();
    }

    public String insertJob(Job job)
    {//动态插入用户
        return  new SQL()
        {
            {
                INSERT_INTO(JOBTABLE);
                if (job.getName() != null && !job.getName().equals(""))
                {
                    VALUES("name","#{name");
                }
                if (job.getRemark() != null && !job.getRemark().equals(""))
                {
                    VALUES("remark","#{remark");
                }
            }

        }.toString();
    }

    public String updateJob(Job job)
    {
        return  new SQL()
        {
            {
                UPDATE(JOBTABLE);
                if (job.getName() != null )
                {
                    SET("name=#{name");
                }
                if (job.getRemark() != null)
                {
                    SET("remark=#{remark}");
                }
            }

        }.toString();
    }
}
