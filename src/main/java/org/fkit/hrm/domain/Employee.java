package org.fkit.hrm.domain;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;
/**
 * Created by xufuxiu on 2017/7/18.
 */
public class Employee implements Serializable
{
    private Integer id;
    private Dept dept;
    private Job job;

    private String name;
    private String cardId;
    private String address;
    private String postCode;
    private String tel;
    private String phone;
    private String  qqNum;
    private String email;
    private Integer sex;
    private String party;//政治面貌

    /*使用@ModelAttribute接收参数时，form表单有日期，spring不知道如何转换，要在实体类的日期属性上加@DateTtimeFormat(pattern="yyyy-MM-dd"注解*/
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birthday;
    private String race;//民族
    private String education;//学历
    private String speciality;//专业
    private String hobby;//爱好
    private String remark;//简介
    private Date creatDate;//建档日期
    public Integer getId()
    {
        return id;
    }
    public void setId(Integer id)
    {
        this.id = id;
    }
    public Dept getDept()
    {
        return dept;
    }
    public void setDept(Dept dept)
    {
        this.dept = dept;
    }
    public Job getJob()
    {
        return job;
    }
    public void setJob(Job job)
    {
        this.job = job;
    }
    public String getName()
    {
        return name;
    }
    public void setName(String name)
    {
        this.name = name;
    }
    public String getCardId()
    {
        return cardId;
    }
    public void setCardId(String cardId)
    {
        this.cardId = cardId;
    }
    public String getAddress()
    {
        return address;
    }
    public void setAddress(String address)
    {
        this.address = address;
    }
    public String getPostCode()
    {
        return postCode;
    }
    public void setPostCode(String postCode)
    {
        this.postCode = postCode;
    }
    public String getTel()
    {
        return tel;
    }
    public void setTel(String tel)
    {
        this.tel = tel;
    }
    public String getPhone()
    {
        return phone;
    }
    public void setPhone(String phone)
    {
        this.phone = phone;
    }
    public String getQqNum()
    {
        return qqNum;
    }
    public void setQqNum(String qqNum)
    {
        this.qqNum = qqNum;
    }
    public String getEmail()
    {
        return email;
    }
    public void setEmail(String email)
    {
        this.email = email;
    }
    public Integer getSex()
    {
        return sex;
    }
    public void setSex(Integer sex)
    {
        this.sex = sex;
    }
    public String getParty()
    {
        return party;
    }
    public void setParty(String party)
    {
        this.party = party;
    }
    public Date getBirthday()
    {
        return birthday;
    }
    public void setBirthday(Date birthday)
    {
        this.birthday = birthday;
    }
    public String getRace()
    {
        return race;
    }
    public void setRace(String race)
    {
        this.race = race;
    }
    public String getEducation()
    {
        return education;
    }
    public void setEducation(String education)
    {
        this.education = education;
    }
    public String getSpeciality()
    {
        return speciality;
    }
    public void setSpeciality(String speciality)
    {
        this.speciality = speciality;
    }
    public String getHobby()
    {
        return hobby;
    }
    public void setHobby(String hobby)
    {
        this.hobby = hobby;
    }
    public String getRemark()
    {
        return remark;
    }
    public void setRemark(String remark)
    {
        this.remark = remark;
    }
    public Date getCreatDate()
    {
        return creatDate;
    }
    public void setCreatDate(Date creatDate)
    {
        this.creatDate = creatDate;
    }
}
