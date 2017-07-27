package org.fkit.hrm.controller;
import org.fkit.hrm.domain.Dept;
import org.fkit.hrm.service.HrmService;
import org.fkit.hrm.util.tag.PageModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
/**
 * Created by xufuxiu on 2017/7/25.
 */
@Controller
public class DeptController
{
    @Autowired
    @Qualifier("hrmService")
    private HrmService hrmService;

    @RequestMapping(value="/dept/selectDept")
    public String selectDept(
            Model model,    //将后台数据存储到Model中，供前端jsp页面使用
            Integer pageIndex,
            @ModelAttribute Dept dept
            )
    {
        System.out.println("slectDept-->>");
        System.out.println("pageIndex="+pageIndex);
        System.out.println("dept:"+dept);
        PageModel pageModel=new PageModel();
        System.out.println(pageModel);
        if(pageIndex != null)
        {
            pageModel.setPageIndex(pageIndex);
        }
        List<Dept> depts=hrmService.findDept(dept,pageModel);
        model.addAttribute("depts",depts);
        model.addAttribute("pageModel",pageModel);
        return "dept/dept";
    }

    /*处理删除部门请求*/
    @RequestMapping(value="/dept/removeDept")
    public ModelAndView removeDept(
            String ids,
            ModelAndView mv
    )
    {
        String[] idArray=ids.split(",");
        for(String id:idArray)
        {
            hrmService.removeDeptById(Integer.parseInt(id));
        }
        mv.setViewName("redirect:/dept/selectDept");
        return mv;
    }
    /*处理添加请求*/
    @RequestMapping(value="/dept/addDept")
    public ModelAndView addDept(
            String flag,
            @ModelAttribute Dept dept,//获得前端jsp页面输入的对象，封装为Dept对象
            ModelAndView mv
    )
    {
        if (flag.equals("1"))
        {
            mv.setViewName("dept/showAddDept");
        }
        else
        {
            hrmService.addDept(dept);//点击添加之后变为查询请求
            mv.setViewName("redirect:/dept/selectDept");
        }
        return mv;
    }

    /*处理修改部门请求*/
    @RequestMapping(value = "/dept/updateDept")
    public ModelAndView updateDept(
            String flag,
            @ModelAttribute Dept dept,
            ModelAndView mv
    )
    {
        if(flag.equals("1"))
        {//修改之前先到数据库查询对象信息
            Dept target = hrmService.findDeptById(dept.getId());
            mv.addObject("dept",target);
            mv.setViewName("dept/showUpdateDept");
        }else
        {
            System.out.println("updateDept 已经修改完的dept:"+dept);
            hrmService.modifyDept(dept); //执行修改请求，dept是修改后的对象
            mv.setViewName("redirect:/dept/selectDept");//修改后查询数据库信息
        }
        return  mv;
    }
}
