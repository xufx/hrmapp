package org.fkit.hrm.dao.provider;
import org.apache.ibatis.jdbc.SQL;
import org.fkit.hrm.domain.Document;

import java.util.Map;

import static org.fkit.hrm.util.common.HrmConstants.DOCUMENTABLE;
/**
 * Created by xufuxiu on 2017/7/18.
 */
public class DocumentDynaSqlProvider
{
    public String selectWithParam(Map<String,Object> params)
    {
        String sql=new SQL()
        {
            {
                SELECT("*");
                FROM(DOCUMENTABLE);
                if (params.get("document") != null)
                {
                    Document document = (Document) params.get("document");
                    if (document.getTitle() != null && !document.getTitle().equals(""))
                    {
                        WHERE("title LIKE CONCAT('%',#{document.title},'%')");
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
                FROM (DOCUMENTABLE);
                if (params.get("document")!=null)
                {
                    Document document = (Document) params.get("document");
                    if (document.getTitle() != null && !document.getTitle().equals(""))
                    {
                        WHERE("title LIKE CONCAT('%',#{document.title},'%')");
                    }

                }
            }
        }.toString();
    }

    public String insertDocument(Document document)
    {//动态插入用户
        return  new SQL()
        {
            {
                INSERT_INTO(DOCUMENTABLE);
                if (document.getTitle() != null && !document.getTitle().equals(""))
                {
                    VALUES("title","#{title}");
                }
                if (document.getFileName() != null && !document.getFileName().equals(""))
                {
                    VALUES("fileName","#{fileName}");
                }
                if (document.getRemark() != null && !document.getRemark().equals(""))
                {
                    VALUES("remark","#{remark}");
                }
                if (document.getUser() != null && !document.getUser().equals(""))
                {
                    VALUES("user_id","#{user.id");
                }
            }

        }.toString();
    }

    public String updateDocument(Document document)
    {
        return  new SQL()
        {
            {
                UPDATE(DOCUMENTABLE);
                if (document.getTitle() != null&&!document.getTitle().equals("") )
                {
                    SET("title=#{title}");
                }
                if (document.getFileName() != null && !document.getFileName().equals(""))
                {
                    SET("fileName=#{fileName}");
                }
                if(document.getRemark()!=null&&!document.getRemark().equals(""))
                {
                    SET("remark=#{remark}");
                }
                if(document.getUser() != null && !document.getUser().equals(""))
                {
                    SET("user_id=#{user.id}");
                }
                WHERE("id=#{id}");
            }

        }.toString();
    }

}
