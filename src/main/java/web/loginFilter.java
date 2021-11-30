package web;


import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(filterName = "loginFilter",urlPatterns = "/*")
public class loginFilter implements Filter {
    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;
        Cookie[] cookies = req.getCookies();
        String uri = req.getRequestURI();

        boolean isLogin = false;
        if(cookies!=null){
            for (Cookie cookie : cookies) {
                if(cookie.getName().equals("isLogin")&&cookie.getValue().equals("true")){
                    isLogin=true;
                }
            }
        }

        if(uri.equals("/")||uri.equals("/error.jsp")||uri.equals("/index.jsp")){
            chain.doFilter(request,response);
        }else if(isLogin){
            chain.doFilter(request,response);
        }else{
            req.setAttribute("msg","please login...");
            resp.sendRedirect("/error.jsp");
        }
    }
}
