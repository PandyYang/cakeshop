package com.xzy.Controller;

import com.google.gson.Gson;
import com.xzy.FTPUtil;
import com.xzy.IDUtils;
import com.xzy.service.UserService;
import org.apache.ibatis.annotations.Param;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xzy.pojo.Users;
import com.xzy.service.GuestService;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.InputStream;


@Controller
    public class UserController {

        @Autowired
        private GuestService guestService;
        @Autowired
        private UserService userService;


        @RequestMapping("/toregist.htm")
        public String toregist() {
            return "regist";
        }
        @RequestMapping("/tologin.htm")
        public String tologin(){
            return "login";
        }
        @RequestMapping("/todisplay.htm")
        public String dtodisplay(){return "display";}



        @Value("${remote.host}")
        private String host;    // 主页
        @Value("${remote.port}")
        private int port;    // ftp用户名
        @Value("${remote.user}")
        private String userName;    // ftp用户密码
        @Value("${remote.password}")
        private String passWord;
        @Value("${remote.dir}")
        private String basePath;   // 文件在服务器端保存的主目录
        @Value("${remote.baseUrl}")
        private String baseUrl;     // 访问图片时的基础url

        @RequestMapping("/addUser")
        public String addUser(
                @RequestParam("username") String username,
                @RequestParam("password") String password,
                @RequestParam("sex") String sex,
                @RequestParam("age") int age,
                @RequestParam("signd") String signd,
                @RequestParam("photo") MultipartFile uploadFile,
                @RequestParam("telephone") String telephone,
                @RequestParam("email") String email
                //@RequestParam("createTime") Date createTime,
                //@RequestParam("updateTime") Date updateTime,
                //@RequestParam("status") int status
        ) {
            try {
                //1、给上传的图片生成新的文件名
                //1.1获取原始文件名
                String oldName = uploadFile.getOriginalFilename();
                //1.2使用IDUtils工具类生成新的文件名，新文件名 = newName + 文件后缀
                String newName = IDUtils.genImageName();
                newName = newName + oldName.substring(oldName.lastIndexOf("."));
                //1.3生成文件在服务器端存储的子目录
                String filePath = new DateTime().toString("/yyyy/MM/dd");
                //2、把前端输入信息，包括图片的url保存到数据库
                Users users = new Users();
                users.setUsername(username);
                users.setPassword(password);
                users.setSex(sex);
                users.setAge(age);
                users.setSignd(signd);
                users.setPhoto(baseUrl + filePath + "/" + newName);
                users.setTelephone(telephone);
                users.setEmail(email);
                //users.setCreateTime(new Date());
                //users.setUpdateTime(new Date());
                //users.setStatus(0);

                userService.addUsers(username, password, sex, age, signd, filePath,
                        telephone, email);

                //3、把图片上传到图片服务器
                //3.1获取上传的io流
                InputStream input = uploadFile.getInputStream();
                //3.2调用FtpUtil工具类进行上传
                boolean result = FTPUtil.uploadFile(host, port, userName, passWord,
                        basePath, filePath, newName, input);
                if (result) {
                    return "success";
                } else {
                    return "fail";
                }
            } catch (IOException e) {
                return "fail";
            }
        }

	//登录
    @RequestMapping("/login")
    public String login(HttpSession session,String username,String password){
	    Users  users = userService.findUserByUsername(username);
	    //保存用户的session
	    session.setAttribute("users",users);
	    //存在用户
	    if (users!=null){
	        //存在用户但是密码错误
	        if (userService.login(username,password)!=null){
	            return "success";
            }
            return "fail";
        }
        return "fail";
    }


	//展示
    @RequestMapping("/display")
    @ResponseBody
    public Users display(HttpSession session,@Param("id") Long id){
        //Object id = session.getAttribute("id");
        //Users u = userService.display(Long.valueOf(String.valueOf(id)));
        String ss = new Gson().toJson(userService.display(id));
        System.out.println("------------------------------------------------------->");
        System.out.println(ss);
        return userService.display(id);
    }


    //修改
    @RequestMapping("/edit")
    public String edit(String username, String password,
                       String sex, Integer age, String signd,
                       String photo, String telephone, String email
                       ){
        if (userService.login(username,password)!=null){
            userService.edit(username,password,sex,age,signd,photo,telephone,email);
            return "success";
        }
        return "fail";
    }



        public GuestService getGuestService() {
            return guestService;
        }

        public void setGuestService(GuestService guestService) {
            this.guestService = guestService;
        }
}