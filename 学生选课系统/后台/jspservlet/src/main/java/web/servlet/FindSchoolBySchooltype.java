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
import java.util.List;

/**
 * 根据课程类型查询
 * schooltype
 */
@WebServlet("/findSchoolBySchooltype")
public class FindSchoolBySchooltype  extends HttpServlet {
UserService userService = new UserServiceImpl();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String schooltype = req.getParameter("schooltype");
        ResultInfo info = new ResultInfo();
        List<School> list = null;
        if (schooltype!=null){
            list = userService.findSchoolBySchooltype(schooltype);
        }
        if (list!=null&&list.size()>0){
            info.setFlag(true);
            info.setErrorMsg("查询成功");
            info.setData(list);

        }else {
            info.setFlag(false);
            info.setErrorMsg("查询为空");
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
