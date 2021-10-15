package web.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import domain.ResultInfo;
import domain.School;
import domain.User_School;
import service.UserService;
import service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * 根据学号查询他的收藏科目
 * studentid
 */
@WebServlet("/isUserShouCang")
public class IsUserShouCang extends HttpServlet {
UserService userService = new UserServiceImpl();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ResultInfo info = new ResultInfo();
        List<School> schools = new ArrayList<>();
        String studentid = req.getParameter("studentid");
        List<User_School> list = userService.findUser_School(studentid);
        if (list==null&&list.size()==0){
            info.setErrorMsg("没有收藏");
            info.setFlag(false);
        }else {
            for (User_School user_school : list) {
                schools.add(userService.findSchoolandInfo(user_school.getSchoolid()));
             }
          }
        if (schools!=null){
            info.setFlag(true);
            info.setErrorMsg("查询收藏科目详细信息");
            info.setData(schools);
        }

        resp.setContentType("application/json;charset=utf-8");
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.writeValue(resp.getOutputStream(),info);

        }





    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
