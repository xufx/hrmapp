package org.fkit.hrm.dao.provider;
import org.apache.ibatis.jdbc.SQL;
import org.fkit.hrm.domain.Notice;

import java.util.Map;

import static org.fkit.hrm.util.common.HrmConstants.NOTICETABLE;
/**
 * Created by xufuxiu on 2017/7/18.
 */
public class NoticeDynaSqlProvider
{
    public String selectWithParam(Map<String,Object> params)
    {
        String sql=new SQL()
        {
            {
                SELECT("*");
                FROM(NOTICETABLE);
                if (params.get("notice") != null)
                {
                    Notice notice = (Notice) params.get("notice");
                    if (notice.getTitle() != null && !notice.getTitle().equals(""))
                    {
                        WHERE("title LIKE CONCAT('%',#{notice.title},'%')");
                    }
                    if (notice.getContent() != null && !notice.getContent().equals(""))
                    {
                        WHERE("content LIKE CONCAT('%',#{notice.content},'%')");
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
                FROM (NOTICETABLE);
                if (params.get("notice")!=null)
                {
                    Notice notice = (Notice) params.get("notice");
                    if (notice.getTitle() != null && !notice.getTitle().equals(""))
                    {
                        WHERE("title LIKE CONCAT('%',#{notice.title},'%')");
                    }
                    if (notice.getContent() != null && !notice.getContent().equals(""))
                    {
                        WHERE("content LIKE CONCAT('%',#{notice.content},'%')");
                    }
                }
            }
        }.toString();
    }

    public String insertNotice(Notice notice)
    {//动态插入用户
        return  new SQL()
        {
            {
                INSERT_INTO(NOTICETABLE);
                if (notice.getTitle() != null && !notice.getTitle().equals(""))
                {
                    VALUES("title","#{title}");
                }
                if (notice.getContent() != null && !notice.getContent().equals(""))
                {
                    VALUES("content","#{content");
                }
                if (notice.getUser() != null && !notice.getUser().equals(""))
                {
                    VALUES("user_id","#{user.id");
                }
            }

        }.toString();
    }

    public String updateNotice(Notice notice)
    {
        return  new SQL()
        {
            {
                UPDATE(NOTICETABLE);
                if (notice.getTitle() != null&&!notice.getTitle().equals("") )
                {
                    SET("title=#{title}");
                }
                if (notice.getContent() != null && !notice.getContent().equals(""))
                {
                    SET("content=#{content}");
                }
                if(notice.getUser() != null && !notice.getUser().equals(""))
                {
                    SET("user_id=#{user.id}");
                }
                WHERE("id=#{id}");
            }

        }.toString();
    }
}
