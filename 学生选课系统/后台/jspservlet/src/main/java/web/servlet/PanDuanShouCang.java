package web.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import dao.UserDao;
import dao.impl.UserDaoImpl;
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
 * 判断是否收藏
 * studentid 学号
 * schoolid 科目id
 */
@WebServlet("/panDuanShouCang")
public class PanDuanShouCang extends HttpServlet {
    UserDao userDao = new UserDaoImpl() {
    };

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String studentid = req.getParameter("studentid");
        String schoolid = req.getParameter("schoolid");

        boolean shouCang = userDao.isShouCang(studentid, schoolid);
        ResultInfo info = new ResultInfo();
        info.setFlag(shouCang);

        resp.setContentType("application/json;charset=utf-8");
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.writeValue(resp.getOutputStream(),info);

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
