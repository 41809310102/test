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

import java.io.IOException;

/**
 * 用户收藏 true收藏，false取消收藏
 */
@WebServlet("/userShouCang")
public class UserShouCang extends HttpServlet {
    UserService service = new UserServiceImpl();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String studentid = req.getParameter("studentid");
        String schoolid = req.getParameter("schoolid");
        String flagstring = req.getParameter("flag");
        Boolean flag= null;
        ResultInfo info = new ResultInfo();
        if ("true".equals(flagstring)){
            //true 为收藏
            flag= service.ShouCang_Ok(studentid,schoolid);
            info.setErrorMsg("收藏成功");
            info.setFlag(true);
        }else {
            //false 为取消收藏
            flag =service.ShouCang_No(studentid,schoolid);
            info.setErrorMsg("取消成功");
            info.setFlag(false);
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
