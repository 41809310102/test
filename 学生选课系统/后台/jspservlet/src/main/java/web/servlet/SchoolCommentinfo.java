package web.servlet;


import com.fasterxml.jackson.databind.ObjectMapper;
import domain.ResultInfo;
import service.UserService;
import service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.WebEndpoint;
import java.io.IOException;

/**
 * 用户评论
 * studentid 学号
 * schoolid 课程号
 * info 评论内容
 */
@WebServlet("/schoolCommentinfo")
public class SchoolCommentinfo  extends HttpServlet {
    UserService userService = new UserServiceImpl();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        ResultInfo info = new ResultInfo();
        String studentid = req.getParameter("studentid");
        String schoolid = req.getParameter("schoolid");
        String info2 = req.getParameter("info");
        if (studentid!=null&&schoolid!=null){

            boolean updateinfo = userService.updateinfo(studentid, schoolid, info2);
            if (updateinfo){
                info.setErrorMsg("评论成功");
                info.setFlag(true);

            }
        }else{
            info.setFlag(false);
            info.setErrorMsg("姓名或课程编号为空");
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
