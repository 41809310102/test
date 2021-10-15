package web.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import domain.ResultInfo;
import domain.School;
import service.UserService;
import service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 查询课程所有信息跟评论内容
 * schoolid 课程id
 */
@WebServlet("/findSchoolandInfo")
public class FindSchoolandInfo  extends HttpServlet {
    private UserService userService = new UserServiceImpl();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String schoolid = req.getParameter("schoolid");
        School schoolandInfo = userService.findSchoolandInfo(schoolid);
        ObjectMapper objectMapper = new ObjectMapper();
        ResultInfo info = new ResultInfo();
        if (schoolandInfo!=null){
            info.setFlag(true);
            info.setErrorMsg("查询成功");
            info.setData(schoolandInfo);
        }else {
            info.setFlag(false);
            info.setErrorMsg("查询失败");
        }
        resp.setContentType("application/json;charset=utf-8");
        objectMapper.writeValue(resp.getOutputStream(),info);

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
