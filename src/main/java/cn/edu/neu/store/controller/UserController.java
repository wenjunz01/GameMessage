package cn.edu.neu.store.controller;



import cn.edu.neu.store.core.Constants;
import cn.edu.neu.store.core.util.FileUtil;
import cn.edu.neu.store.model.User;
import cn.edu.neu.store.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/user")
public class UserController{
    @Autowired
    private UserService userService;
    //登录
    @RequestMapping("/login")
    public String ToLogin(User user, HttpSession session, Map<String, String> m) {
        User dbUser = userService.existsUser(user);
            System.out.println(user.getUsername()+","+user.getPassword()+"--------"+dbUser);
        if (dbUser != null) {
            session.setAttribute(Constants.LOGIN_USER, dbUser);
            m.put("login", "yes");
            return "manager/board";
        } else {
            m.put("login", Constants.LOGIN_ERR);
            return "login";
        }

    }

    @RequestMapping("/logout")
    public String logout(HttpSession session) {
        // 清除Session
        session.invalidate();
        // 重定向到登录页面的跳转方法
        return "redirect:manager/board";
    }

    @RequestMapping("home")
    public String Home(){
        return "manager/board";
    }

    @RequestMapping("/getReg")
    public String getReg(){
        return "user/register";
    }

    @RequestMapping( "/ToReg")
    public String ToReg(User user,Map<String,String> m){
        boolean f = userService.regUser(user);
        if(f){
            m.put("result", "yes");
            m.put("msg", "恭喜您，注册成功");
        }else {
            m.put("result", "no");
            m.put("msg", "对不起，数据输入格式有误，注册失败");
        }
        System.out.println("add:"+m);
        return "redirect:/user/login";

    }

    @RequestMapping("/getUserList")
    public String getUserList(User user, Map<String, List<User>> m) {
        System.out.println(user);
        List<User> userList = userService.getUserList(user);
        m.put("userList", userList);
        System.out.println("m:" + m);
        return "/user/getUserList";  //跳转getUserList页
    }

    @RequestMapping("/getUser")
    public String getUser(String userid, Map<String,User> m){
        System.out.println("getUser1111:"+userid);
        User user=userService.getUser(userid);
        m.put("user", user);
        System.out.println("user:"+user);
        return "/user/update";
    }
    //用户修改后点击提交
    @RequestMapping("/updateUser")
    public String updateUser(User user, Model model, Map<String, List<User>> m, HttpServletRequest request){
        MultipartFile file=user.getFile();
        System.out.println("size:========================="+file.getSize());
        File dest=null;
        String filePath=null;
        if(!file.isEmpty()) {//上传文件不为空
            dest= FileUtil.uploadFile(file, request);
            if(dest==null) {
                model.addAttribute("result", "no");
                model.addAttribute("msg", "照片文件上传失败");
                return "/user/result";
            }
            System.out.println("dest.getPath():===================="+dest.getPath());
            System.out.println("dest.getPath().substring:======="+dest.getPath().substring(dest.getPath().lastIndexOf("\\")));
            filePath= Constants.UPLOAD_PATH+dest.getPath().substring(dest.getPath().lastIndexOf("\\")+1);
            System.out.println("filePath::::::"+filePath);
            user.setFilePath(filePath);
        }
        userService.updateUser(user);
        System.out.println("update:"+m);
        return "redirect:/user/getUserList";
    }

    @RequestMapping("/deleteUser")
    public String deleteUser(User user){
        System.out.println("deleteUser========================"+user);
        boolean f = userService.deleteUser(user);
        Map<String,String> m=new HashMap<String,String>();
        if(f){
            m.put("result", "yes");
            m.put("msg", "恭喜您，删除成功");
            return "forward:/user/getUserList";
        }else {
            m.put("result", "no");
            m.put("msg", "对不起，删除失败");
            return "redirect:/user/getUserList";
        }
    }
    @RequestMapping("/getAdd")
    public String getAdd(Map<String, User> m){
        return "/user/adduser";
    }

    @RequestMapping("/addUser")
    public String addUser(User user, Model model, Map<String, List<User>> m, HttpServletRequest request){
        MultipartFile file=user.getFile();
        System.out.println("size:========================="+file.getSize());
        File dest=null;
        String filePath=null;
        if(!file.isEmpty()) {//上传文件不为空
            dest= FileUtil.uploadFile(file, request);
            if(dest==null) {
                model.addAttribute("result", "no");
                model.addAttribute("msg", "照片文件上传失败");
                return "/user/result";
            }
            System.out.println("dest.getPath():===================="+dest.getPath());
            System.out.println("dest.getPath().substring:======="+dest.getPath().substring(dest.getPath().lastIndexOf("\\")));
            filePath= Constants.UPLOAD_PATH+dest.getPath().substring(dest.getPath().lastIndexOf("\\")+1);
            System.out.println("filePath::::::"+filePath);
            user.setFilePath(filePath);
        }
        userService.addUser(user);
        List<User> userList = userService.getUserList(user);
        m.put("goodsList", userList);
        return "redirect:/user/getUserList";
    }

    @GetMapping("getUserById/{userId}")
    public ModelAndView getUserById(@PathVariable("userId") Integer id, Model model) {
        User user = userService.getUserById(id);
        model.addAttribute("user",user);
        model.addAttribute("title", "查看用户");
        return new ModelAndView("/user/userInfo.html","userModel",model);
    }

    @GetMapping("/ratio")
    @ResponseBody
    public Map<String, Integer> getUserGenderRatio() {
        return userService.getUserGenderRatio();
    }


}
