package org.fkit.hrm.service.impl;
import org.fkit.hrm.dao.*;
import org.fkit.hrm.domain.*;
import org.fkit.hrm.service.HrmService;
import org.fkit.hrm.util.tag.PageModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.*;

import java.util.*;
/**
 * Created by xufuxiu on 2017/7/18.
 */
@Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.DEFAULT)
@Service("hrmService")
public class HrmServiceImpl implements HrmService
{
    /*自动注入持久层DAO对象*/
    @Autowired
    private UserDao userDao;
    @Autowired
    private EmployeeDao employeeDao;
    @Autowired
    private DeptDao deptDao;
    @Autowired
    private NoticeDao noticeDao;
    @Autowired
    private DocumentDao documentDao;
    @Autowired
    private JobDao jobDao;
    /*****************************用户服务接口实现*************************/
    @Transactional(readOnly = true)
    @Override
    public User login(String loginname, String password)
    {System.out.println("enter into HrmServiceImpl的login方法实现");
        return userDao.selectByLoginnameAndPassword(loginname,password);
    }
    @Override
    public User findUserById(Integer id)
    {
        return userDao.selectById(id);
    }
    @Transactional(readOnly = true)
    @Override
    public List<User> findUser(User user, PageModel pageModel)
    {//分页查询所有用户
        Map<String,Object>params=new HashMap<>();
        params.put("user",user);
        int recordCount=userDao.count(params);
        pageModel.setRecordCount(recordCount);
        if (recordCount>0)
            params.put("pageModel",pageModel);
        List<User> users=userDao.selectByPage(params);
        return users;
    }
    @Transactional(readOnly = true)
    @Override
    public void removeUserById(Integer id)
    {
        userDao.deleteById(id);
    }
    @Override
    public void modifyUser(User user)
    {
        userDao.update(user);
    }
    @Override
    public void addUser(User user)
    {
        userDao.save(user);
    }

    /*************************部门服务接口实现*****************************/
    @Transactional(readOnly = true)
    public List<Dept> findDept(Dept dept, PageModel pageModel)
    {//分页查询
        Map<String,Object> params=new HashMap<>();
        params.put("dept",dept);
        int recordCount=deptDao.count(params);
        System.out.println("recordCount-->>"+recordCount);
        pageModel.setRecordCount(recordCount);
        if (recordCount>0)
        {
            params.put("pageModel",pageModel);
        }
        List<Dept> depts=deptDao.selectByPage(params);
        return depts;
    }
    @Transactional(readOnly = true)
    public List<Dept> findAllDept()
    {
        return deptDao.selectAllDept();
    }
    public void removeDeptById(Integer id)
    {
       deptDao.deleteById(id);
    }
    public void addDept(Dept dept)
    {
        deptDao.save(dept);
    }
    @Transactional(readOnly = true)
    public Dept findDeptById(Integer id)
    {
        return deptDao.selectById(id);
    }

    public void modifyDept(Dept dept)
    {
        deptDao.update(dept);
    }

    /*************************员工服务接口实现*****************************/
    @Transactional(readOnly = true)
    public List<Employee> findEmployee(Employee employee, PageModel pageModel)
    {
        Map<String,Object> params=new HashMap<>();
        params.put("employee",employee);
        int recordCount=employeeDao.count(params);
        System.out.println("recordCount-->>"+recordCount);
        pageModel.setRecordCount(recordCount);
        if (recordCount>0)
        {//如果记录条数》0，开始分页：查询第几页的数据
            params.put("pageModel",pageModel);
        }
        List<Employee> employees=employeeDao.selectByPage(params);
        return employees;
    }
    public void removeEmployeeById(Integer id)
    {
        employeeDao.deleteById(id);
    }
    @Transactional(readOnly = true)
    public Employee findEmployeeById(Integer id)
    {
        return employeeDao.selectById(id);
    }
    public void addEmployee(Employee employee)
    {
        employeeDao.save(employee);
    }
    public void modifyEmployee(Employee employee)
    {
        employeeDao.update(employee);
    }

    /***************************职位服务接口实现**************************/
    @Transactional(readOnly = true)
    public List<Job> findJob(Job job, PageModel pageModel)
    {
        Map<String,Object> params=new HashMap<>();
        params.put("job",job);
        int recordCount=jobDao.count(params);
        System.out.println("recordCount-->>"+recordCount);
        pageModel.setRecordCount(recordCount);
        if (recordCount>0)
        {//如果记录条数>0，开始分页：查询第几页的数据
            params.put("pageModel",pageModel);
        }
        List<Job> jobs=jobDao.selectByPage(params);
        return jobs;
    }
    @Transactional(readOnly = true)
    public List<Job> findAllJob()
    {
        return jobDao.selecAllJob();
    }

    public void removeJobById(Integer id)
    {
        jobDao.deleteById(id);
    }
    @Transactional(readOnly = true)
    public Job findJobById(Integer id)
    {
        return jobDao.selectById(id);
    }
    public void addJob(Job job)
    {
        jobDao.save(job);
    }
    public void modifyJob(Job job)
    {
        jobDao.update(job);
    }
    /***************************公告接口实现**************************/
    @Transactional(readOnly = true)
    public List<Notice> findNotice(Notice notice, PageModel pageModel)
    {
        Map<String,Object> params=new HashMap<>();
        params.put("notice",notice);
        int recordCount=noticeDao.count(params);
        System.out.println("recordCount-->>"+recordCount);
        pageModel.setRecordCount(recordCount);
        if (recordCount>0)
        {//如果记录条数>0，开始分页：查询第几页的数据
            params.put("pageModel",pageModel);
        }
        List<Notice> notices=noticeDao.selectByPage(params);
        return notices;
    }
    public void removeNoticeById(Integer id)
    {
        noticeDao.deleteById(id);
    }
    @Transactional(readOnly = true)
    public Notice findNoticeById(Integer id)
    {
        return noticeDao.selectById(id);
    }
    public void addNotice(Notice notice)
    {
        noticeDao.save(notice);
    }
    public void modifyNotice(Notice notice)
    {
        noticeDao.update(notice);
    }
    /***************************文件接口实现**************************/
    @Transactional(readOnly = true)
    public List<Document> findDocument(Document document, PageModel pageModel)
    {
        Map<String,Object> params=new HashMap<>();
        params.put("document",document);
        int recordCount=documentDao.count(params);
        System.out.println("recordCount-->>"+recordCount);
        pageModel.setRecordCount(recordCount);
        if (recordCount>0)
        {//如果记录条数>0，开始分页：查询第几页的数据
            params.put("pageModel",pageModel);
        }
        List<Document> documents=documentDao.selectByPage(params);
        return documents;
    }
    public void removeDocumentById(Integer id)
    {
        documentDao.deleteById(id);
    }
    @Transactional(readOnly = true)
    public Document findDocumentById(Integer id)
    {
        return documentDao.selectById(id);
    }
    public void addDocument(Document document)
    {
        documentDao.save(document);
    }
    public void modifyDocument(Document document)
    {
        documentDao.update(document);
    }
}
