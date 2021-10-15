package web.jspservlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import domain.*;
import org.apache.commons.beanutils.BeanUtils;
import service.JspService;
import service.UserService;
import service.impl.JspServletImpl;
import service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Map;

@WebServlet("/jsp/*")
public class UserServlet extends BaseServlet {
   private UserService userService = new UserServiceImpl();
   private JspService jspService = new JspServletImpl();
   private ObjectMapper objectMapper = new ObjectMapper();


    /**
     * 登录
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ResultInfo_jsp jsp = new ResultInfo_jsp();
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        JspUser jspUser = userService.jsp_Login(username, password);
        if (jspUser!=null){
        request.getSession().setAttribute("jspuser",jspUser);
        jsp.setMsg("登录成功");
        jsp.setCode(0);
        jsp.setData(jspUser);
        System.out.println("登录成功");
        }else {
            jsp.setCode(1);
            jsp.setMsg("用户名或密码错误");
            System.out.println("登录失败");
        }
        response.setContentType("application/json;charset=utf-8");
        objectMapper.writeValue(response.getOutputStream(),jsp);


    }

    /**
     * 修改密码
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void password(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ResultInfo_jsp jsp = new ResultInfo_jsp();
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        Boolean flag = userService.jsp_Password(username, password);
        if (flag){
            User login = userService.login(username, password);
            request.getSession().setAttribute("jspuser",login);
            jsp.setMsg("修改密码成功");
            jsp.setCode(0);
            jsp.setData(login);
        }else {
            jsp.setCode(1);
            jsp.setMsg("修改密码失败");
        }
        response.setContentType("application/json;charset=utf-8");
        objectMapper.writeValue(response.getOutputStream(),jsp);
    }

    /**
     * 查询所有学生
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void findUserAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ResultInfo_jsp jsp = new ResultInfo_jsp();
        List<User> users = jspService.findUserAll();
        if (users!=null){
            request.getSession().setAttribute("users",users);
            jsp.setCode(0);
            jsp.setData(users);
            jsp.setMsg("查询成功");
            jsp.setCount(users.size());
        }else {
            jsp.setCode(1);
            jsp.setMsg("查询失败或无任何信息");
        }
        response.setContentType("application/json;charset=utf-8");
        objectMapper.writeValue(response.getOutputStream(),jsp);

    }

    /**
     * 删除指定学生 根据学号
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void delUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ResultInfo_jsp jsp = new ResultInfo_jsp();
        String studentid = request.getParameter("studentid");
        Boolean flag = jspService.delUser(studentid);
        if (flag){
            this.findUserAll(request,response);
            return;
        }
        else {
            jsp.setCode(1);
            jsp.setMsg("删除失败");
        }
        response.setContentType("application/json;charset=utf-8");
        objectMapper.writeValue(response.getOutputStream(),jsp);
    }

    /**
     * 更新用户信息  根据学号
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void updateUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ResultInfo_jsp jsp = new ResultInfo_jsp();
        Map<String, String[]> map = request.getParameterMap();
        User user = new User();
        try {
            BeanUtils.populate(user,map);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        if (user!=null){
            jspService.updateUser(user.getStudentid(),user.getPassword(),user.getUsername());
            this.findUserAll(request,response);
            return;
        }
        jsp.setMsg("更新失败");
        jsp.setCode(1);
        response.setContentType("application/json;charset=utf-8");
        objectMapper.writeValue(response.getOutputStream(),jsp);
    }

    /**
     * 查询所有课程
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void findSchoolAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ResultInfo_jsp jsp = new ResultInfo_jsp();
        List<School> schools = jspService.findSchoolAll();
        if (schools!=null&&schools.size()>0){
            jsp.setCode(0);
            jsp.setMsg("查询成功");
            jsp.setData(schools);
            jsp.setCount(schools.size());
        }else {
            jsp.setCode(1);
            jsp.setMsg("查询失败或无信息");
        }
        response.setContentType("application/json;charset=utf-8");
        objectMapper.writeValue(response.getOutputStream(),jsp);
    }

    /**
     * 删除指定课程 根据课程编号
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void delSchool(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ResultInfo_jsp jsp = new ResultInfo_jsp();
        String schoolid = request.getParameter("schoolid");
        Boolean flag = jspService.delSchool(schoolid);
        if(flag){
            this.findSchoolAll(request,response);
            return;
        }
        jsp.setMsg("删除失败");
        jsp.setCode(1);

        response.setContentType("application/json;charset=utf-8");
        objectMapper.writeValue(response.getOutputStream(),jsp);
    }

    /**
     * 更新课程
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void updateSchool(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ResultInfo_jsp jsp = new ResultInfo_jsp();
        Map<String, String[]> map = request.getParameterMap();
        School school = new School();
        try {
            BeanUtils.populate(school,map);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        if (school!=null){
            Boolean flag = jspService.updateSchool(school);
            if (flag){
                this.findSchoolAll(request,response);
                return;
            }
        }
        jsp.setCount(1);
        jsp.setMsg("更新失败");
        response.setContentType("application/json;charset=utf-8");
        objectMapper.writeValue(response.getOutputStream(),jsp);
    }

    /**
     * 添加课程
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void addSchool(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       ResultInfo info = new ResultInfo();
       info.setFlag(true);
        School school = new School();
        Map<String, String[]> map = request.getParameterMap();
        try {
            BeanUtils.populate(school,map);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        school.setSchoolcount("0");
       jspService.addSchool(school);

       response.setContentType("application/json;charset=utf-8");
       objectMapper.writeValue(response.getOutputStream(),info);
    }
}
