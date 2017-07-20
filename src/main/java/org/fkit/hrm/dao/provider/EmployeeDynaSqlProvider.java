package org.fkit.hrm.dao.provider;
import org.apache.ibatis.jdbc.SQL;
import org.fkit.hrm.domain.Employee;

import java.util.Map;

import static org.fkit.hrm.util.common.HrmConstants.EMPLOYEETABLE;
/**
 * Created by xufuxiu on 2017/7/18.
 */
public class EmployeeDynaSqlProvider
{
    public String selectWithParam(Map<String,Object> params)
    {//分页动态查询
        String sql=new SQL()
        {
            {
                SELECT("*");
                FROM(EMPLOYEETABLE);
                if (params.get("employee") != null)
                {
                    Employee employee = (Employee) params.get("employee");
                    if (employee.getDept() != null && employee.getDept().getId()!=null&& employee.getDept().getId()!=0)
                    {
                        WHERE("DEPT_ID LIKE CONCAT('%',#{employee.dept.id},'%')");
                    }
                    if (employee.getJob() != null && employee.getJob().getId()!=null&&employee.getJob().getId()!=0)
                    {
                        WHERE("JOB_ID LIKE CONCAT('%',#{employee.job.id},'%')");
                    }
                    if (employee.getName() != null && !employee.getName().equals(""))
                    {
                        WHERE("NAME LIKE CONCAT('%',#{employee.name},'%')");
                    }
                    if (employee.getPhone() != null && !employee.getPhone().equals(""))
                    {
                        WHERE("PHONE LIKE CONCAT('%',#{employee.phone},'%')");
                    }
                    if (employee.getCardId() != null && !employee.getCardId().equals(""))
                    {
                        WHERE("CARD_ID LIKE CONCAT('%',#{employee.cardId},'%')");
                    }
                    if (employee.getSex() != null && employee.getSex()!=0)
                    {
                        WHERE("SEX=#{employee.sex}");
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
                FROM (EMPLOYEETABLE);
                if (params.get("employee")!=null)
                {
                    Employee employee = (Employee) params.get("employee");
                    if (employee.getDept() != null && employee.getDept().getId()!=null&&employee.getDept().getId()!=0)
                    {
                        WHERE("DEPT_ID=#{employee.dept.id}");
                    }
                    if (employee.getJob() != null && employee.getJob().getId()!=null&&employee.getJob().getId()!=0)
                    {
                        WHERE("JOB_ID=#{employee.job.id}");
                    }
                    if (employee.getName() != null && !employee.getName().equals(""))
                    {
                        WHERE("NAME LIKE CONCAT('%',#{employee.name},'%')");
                    }
                    if (employee.getPhone() != null && !employee.getPhone().equals(""))
                    {
                        WHERE("PHONE LIKE CONCAT('%',#{employee.phone},'%')");
                    }
                    if (employee.getCardId() != null && !employee.getCardId().equals(""))
                    {
                        WHERE("CARD_ID LIKE CONCAT('%',#{employee.cardId},'%')");
                    }
                    if (employee.getSex() != null && employee.getSex()!=0)
                    {
                        WHERE("SEX=#{employee.sex}");
                    }
                }
            }
        }.toString();
    }

    public String insertEmployee(Employee employee)
    {//动态插入用户
        return  new SQL()
        {
            {
                INSERT_INTO(EMPLOYEETABLE);
                if (employee.getName() != null )
                {
                    VALUES("name","#{name}");
                }
                if (employee.getCardId() != null )
                {
                    VALUES("CARD_ID","#{cardId}");
                }
                if (employee.getAddress() != null)
                {
                    VALUES("ADDRESS","#{address}");
                }
                if (employee.getPostCode() != null)
                {
                    VALUES("POSTCODE","#{POSTcODE}");
                }
                if (employee.getTel() != null)
                {
                    VALUES("TEL","#{tel}");
                }
                if (employee.getPhone() != null )
                {
                    VALUES("PHONE","#{phone");
                }
                if(employee.getQqNum()!=null)
                {
                    VALUES("QQ_NUM","#{qqNum}");
                }
                if (employee.getEmail()!=null)
                {
                    VALUES("EMAIL","#{email");
                }
                if(employee.getSex() !=null)
                {
                    VALUES("sex","sex");
                }
                if(employee.getParty() !=null)
                {
                    VALUES("party","party");
                }
                if(employee.getBirthday() !=null)
                {
                    VALUES("birthday","birthday");
                }
                if(employee.getRace() !=null)
                {
                    VALUES("race","race");
                }
                if(employee.getEducation() !=null)
                {
                    VALUES("education","education");
                }
                if(employee.getSpeciality() !=null)
                {
                    VALUES("speciality","speciality");
                }
                if(employee.getHobby() !=null)
                {
                    VALUES("hobby","hobby");
                }
                if(employee.getRemark()!= null)
                {
                    VALUES("remark", "#{remark}");
                }
                if(employee.getCreatDate()!= null)
                {
                    VALUES("create_Date", "#{createDate}");
                }
                if(employee.getDept()!= null)
                {
                    VALUES("dept_id", "#{dept.id}");
                }
                if(employee.getJob()!= null)
                {
                    VALUES("job_id", "#{job.id}");
                }

            }

        }.toString();
    }

    public String updateEmployee(Employee employee)
    {
        return  new SQL()
        {
            {
                UPDATE(EMPLOYEETABLE);
                if (employee.getName() != null)
                {
                    SET("name=#{name");
                }
                if (employee.getPhone() != null)
                {
                    SET("phone=#{phone");
                }
                if(employee.getCardId() != null)
                {
                    SET(" card_id = #{cardId} ");
                }
                if(employee.getAddress()!= null)
                {
                    SET(" address = #{address} ");
                }
                if(employee.getPostCode()!= null)
                {
                    SET(" post_code = #{postCode} ");
                }
                if(employee.getTel()!= null)
                {
                    SET(" tel = #{tel} ");
                }
                if(employee.getPhone()!= null)
                {
                    SET(" phone = #{phone} ");
                }
                if(employee.getQqNum()!= null)
                {
                    SET(" qq_num = #{qqNum} ");
                }
                if(employee.getEmail()!= null)
                {
                    SET(" email = #{email} ");
                }
                if(employee.getSex()!= null){
                    SET(" sex = #{sex} ");
                }
                if(employee.getParty()!= null)
                {
                    SET(" party = #{party} ");
                }
                if(employee.getBirthday()!= null)
                {
                    SET(" birthday = #{birthday} ");
                }
                if(employee.getRace()!= null)
                {
                    SET(" race = #{race} ");
                }
                if(employee.getEducation()!= null)
                {
                    SET(" education = #{education} ");
                }
                if(employee.getSpeciality()!= null)
                {
                    SET(" speciality = #{speciality} ");
                }
                if(employee.getHobby()!= null)
                {
                    SET(" hobby = #{hobby} ");
                }
                if(employee.getRemark()!= null)
                {
                    SET(" remark = #{remark} ");
                }
                if(employee.getCreatDate()!= null)
                {
                    SET(" create_Date = #{createDate} ");
                }
                if(employee.getDept()!= null)
                {
                    SET(" dept_id = #{dept.id} ");
                }
                if(employee.getJob()!= null)
                {
                    SET(" job_id = #{job.id} ");
                }
                WHERE(" id = #{id} ");
            }

        }.toString();
    }

}
