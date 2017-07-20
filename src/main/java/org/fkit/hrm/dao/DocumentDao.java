package org.fkit.hrm.dao;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;
import org.fkit.hrm.dao.provider.DocumentDynaSqlProvider;
import org.fkit.hrm.domain.Document;

import java.util.List;
import java.util.Map;

import static org.fkit.hrm.util.common.HrmConstants.DOCUMENTABLE;
/**
 * Created by xufuxiu on 2017/7/18.
 */
public interface DocumentDao
{
    @SelectProvider(type = DocumentDynaSqlProvider.class,method="selectWithParam")
    @Results({//当domain中包含对象属性时需要使用mybatis注解支持的动态SQL语句
            @Result(id=true,column = "id",property = "id"),
            @Result(column = "CREATE_DATE",property = "createDate",javaType = java.util.Date.class),
            @Result(column = "USER_ID",property = "user",
                    one=@One(
                            select="org.fkit.hrm.dao.UserDao.selectById",
                            fetchType= FetchType.EAGER))
    })
    List<Document> selectByPage(Map<String, Object> params);

    @SelectProvider(type = DocumentDynaSqlProvider.class,method="count")
    Integer count(Map<String, Object> params);

    @Select("select * from"+DOCUMENTABLE+"where id=#{id}")
    Document selectById(Integer id);

    @Delete("delete * from"+DOCUMENTABLE+"where id=#{id}")
    void deleteById(Integer id);

    @SelectProvider(type = DocumentDynaSqlProvider.class,method="updateDocument")
    void update(Document document);

    @SelectProvider(type = DocumentDynaSqlProvider.class,method = "insertDocument")
    void save(Document document);
}
