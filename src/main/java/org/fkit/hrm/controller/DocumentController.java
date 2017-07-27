package org.fkit.hrm.controller;
import org.fkit.hrm.domain.Notice;
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
public class NoticeController
{
    @Autowired
    @Qualifier("hrmService")
    private HrmService hrmService;

    @RequestMapping(value="/notice/selectNotice")
    public String selectNotice(
            Model model,    //将后台数据存储到Model中，供前端jsp页面使用
            Integer pageIndex,
            @ModelAttribute Notice notice
            )
    {
        System.out.println("slectNotice-->>");
        System.out.println("pageIndex="+pageIndex);
        System.out.println("notice:"+notice);
        PageModel pageModel=new PageModel();
        System.out.println(pageModel);
        if(pageIndex != null)
        {
            pageModel.setPageIndex(pageIndex);
        }
        List<Notice> notices=hrmService.findNotice(notice,pageModel);
        model.addAttribute("notices",notices);
        model.addAttribute("pageModel",pageModel);
        return "notice/notice";
    }

    /*处理添加请求*/
    @RequestMapping(value="/notice/addNotice")
    public ModelAndView addNotice(
            String flag,
            @ModelAttribute Notice notice,//获得前端jsp页面输入的对象，封装为Notice对象
            ModelAndView mv
    )
    {
        if (flag.equals("1"))
        {
            mv.setViewName("notice/showAddNotice");
        }
        else
        {
            hrmService.addNotice(notice);//点击添加之后变为查询请求
            mv.setViewName("redirect:/notice/selectNotice");
        }
        return mv;
    }

    /*处理修改部门请求*/
    @RequestMapping(value = "/notice/updateNotice")
    public ModelAndView updateNotice(
            String flag,
            @ModelAttribute Notice notice,
            ModelAndView mv
    )
    {
        if(flag.equals("1"))
        {//修改之前先到数据库查询对象信息
            Notice target = hrmService.findNoticeById(notice.getId());
            mv.addObject("notice",target);
            mv.setViewName("notice/showUpdateNotice");
        }else
        {
            System.out.println("updateNotice 已经修改完的notice:"+notice);
            hrmService.modifyNotice(notice); //执行修改请求，notice是修改后的对象
            mv.setViewName("redirect:/notice/selectNotice");//修改后查询数据库信息
        }
        return  mv;
    }
}
