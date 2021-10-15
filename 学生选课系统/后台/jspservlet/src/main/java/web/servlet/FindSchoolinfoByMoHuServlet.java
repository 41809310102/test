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
 * 搜索课程模糊查询
 * schoolname
 */
@WebServlet("/FindSchoolinfoByMoHuServlet")
public class FindSchoolinfoByMoHuServlet extends HttpServlet {

    UserService userService = new UserServiceImpl();
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String schoolname = request.getParameter("schoolname");
        List<School> schoolByMoHu = null;
        if (schoolname!=null){
           schoolByMoHu = userService.findSchoolByMoHu(schoolname);
        }
        ResultInfo info = new ResultInfo();
        if (schoolByMoHu!=null){
            info.setFlag(true);
            info.setErrorMsg("模糊查询成功");
            info.setData(schoolByMoHu);
        }else {
            info.setFlag(false);
            info.setErrorMsg("模糊查询失败");
        }

        response.setContentType("application/json;charset=utf-8");
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.writeValue(response.getOutputStream(),info);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
