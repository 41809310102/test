package web.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter("/*")
public class CharchaterFilter implements Filter {
    @Override
    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest)req;
        HttpServletResponse response = (HttpServletResponse)resp;
        String method = request.getMethod();
        if (method.equalsIgnoreCase("post")||method.equalsIgnoreCase("get")){
            req.setCharacterEncoding("utf-8");
        }

        //处理响应乱码
        //resp.setContentType("text/html;charset=utf-8");
        chain.doFilter(request,response);
    }

    @Override
    public void init(FilterConfig config) throws ServletException {

    }

}
