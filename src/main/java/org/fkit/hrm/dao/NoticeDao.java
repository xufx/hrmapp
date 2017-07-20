package org.fkit.hrm.dao;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;
import org.fkit.hrm.dao.provider.NoticeDynaSqlProvider;
import org.fkit.hrm.domain.Notice;

import java.util.List;
import java.util.Map;

import static org.fkit.hrm.util.common.HrmConstants.NOTICETABLE;
/**
 * Created by xufuxiu on 2017/7/18.
 */
public interface NoticeDao
{
    @SelectProvider(type = NoticeDynaSqlProvider.class,method="selectWithParam")
    @Results({//当domain中包含对象属性时需要使用mybatis注解支持的动态SQL语句
            @Result(id=true,column = "id",property = "id"),
            @Result(column = "CAR_ID",property="cardId"),
            @Result(column = "CREATE_DATE",property = "createDate",javaType = java.util.Date.class),
            @Result(column = "USER_ID",property = "user",
                    one=@One(
                            select="org.fkit.hrm.dao.UserDao.selectById",
                            fetchType= FetchType.EAGER))
    })
    List<Notice> selectByPage(Map<String, Object> params);

    @SelectProvider(type = NoticeDynaSqlProvider.class,method="count")
    Integer count(Map<String, Object> params);

    @Select("select * from"+NOTICETABLE+"where id=#{id}")
    Notice selectById(Integer id);

    @Delete("delete * from"+NOTICETABLE+"where id=#{id}")
    void deleteById(Integer id);

    @SelectProvider(type = NoticeDynaSqlProvider.class,method="insertNotice")
    void save(Notice notice);

    @SelectProvider(type = NoticeDynaSqlProvider.class,method="updateNotice")
    void update(Notice notice);
}
