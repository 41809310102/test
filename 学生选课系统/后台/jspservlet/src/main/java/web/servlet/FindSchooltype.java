package web.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import domain.ResultInfo;
import domain.Schooltype;
import service.UserService;
import service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@WebServlet("/findSchooltype")
public class FindSchooltype extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserService userService = new UserServiceImpl();
        List<Schooltype> schooltypes = userService.findschooltype();
        Set<String> set = new HashSet<>();
        for (Schooltype schooltype : schooltypes) {
            set.add(schooltype.getSchooltype());
        }
        ResultInfo info = new ResultInfo();
        if (set!=null){
            info.setData(set);
            info.setErrorMsg("成功");
            info.setFlag(true);
        }else {
            info.setErrorMsg("失败");
            info.setFlag(false);
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
