package com.it.webui.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


/**
 * 此处为功能菜单入口
 * 
 * @version v1.0
 * @date 2019年7月8日  
 * @author yangzz  
 *
 */
@Controller
public class RenderController {

    /*工作台*/
    @GetMapping("/workdest")
    public String workdest(){
        return "index/workdest";
    }

    /**用户列表入口*/
    @GetMapping("/users")
    public String userList(){
        return "user/list";
    }

    /*角色列表入口*/
    @GetMapping("/roles")
    public String roleList() {
        return "role/list";
    }

    /*权限列表入口*/
    @GetMapping("/permissions")
    public String permissionList(){
        return "permission/list";
    }

    /*在线用户入口*/
    @GetMapping("/online/users")
    public String onlineUsers(){
    	return "onlineUsers/list";
    }
    
    /*子项目列表入口*/
    @GetMapping("/projects")
    public String projectList() {
        return "project/list";
    }
    
    /*项目组管理入口*/
    @GetMapping("/groups")
    public String groupList() {
        return "project/groupList";
    }
    
    /*项目质量入口*/
    @GetMapping("/charts")
    public String projectChart() {
        return "report/projectChart";
    }
    
    /*人员能力入口*/
    @GetMapping("/userCharts")
    public String userChart() {
        return "report/userChart";
    }
    
    /*技术架构入口*/
    @GetMapping("/technologys")
    public String technologyChart() {
        return "report/technologyChart";
    }
}
