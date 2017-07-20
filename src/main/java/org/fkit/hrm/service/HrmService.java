package org.fkit.hrm.service;
import org.fkit.hrm.domain.*;
import org.fkit.hrm.util.tag.PageModel;

import java.util.List;
/**
 * Created by xufuxiu on 2017/7/18.
 */
public interface HrmService
{//服务层接口
    /*对用户进行增删改查*/
    User login(String loginname, String password);
    User findUserById(Integer id);
    List<User> findUser(User user,PageModel pageModel);
    void removeUserById(Integer id);
    void modifyUser(User user);
    void addUser(User user);

    /*对部门进行增删改查*/
    List<Dept> findDept(Dept dept, PageModel pageModel);
    List<Dept> findAllDept();
    void removeDeptById(Integer id);
    Dept findDeptById(Integer id);
    void addDept(Dept dept);
    void modifyDept(Dept dept);

    /*对员工进行增删改查*/
    List<Employee> findEmployee(Employee employee,PageModel pageModel);
    void removeEmployeeById(Integer id);
    Employee findEmployeeById(Integer id);
    void addEmployee(Employee employee);
    void modifyEmployee(Employee employee);


    /*对工作进行增删改查*/
    List<Job> findJob(Job job, PageModel pageModel);
    List<Job> findAllJob();
    void removeJobById(Integer id);
    Job findJobById(Integer id);
    void addJob(Job job);
    void modifyJob(Job job);

    /*对公告进行增删改查*/
    List<Notice> findNotice(Notice notice, PageModel pageModel);
    Notice findNoticeById(Integer id);
    void addNotice(Notice notice);
    void modifyNotice(Notice notice);

    /*对文档进行增删改查*/
    List<Document> findDocument(Document document, PageModel pageModel);
    Document findDocumentById(Integer id);
    void addDocument(Document document);
    public void removeDocumentById(Integer id);
    void modifyDocument(Document document);

}
