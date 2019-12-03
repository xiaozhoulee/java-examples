package xiaozhoubgcom;


import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter(
        filterName = "Filter",
        value = {"/user.jsp"}
)
public class MyFilter implements javax.servlet.Filter {

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException, IOException {
            String age = req.getParameter("age");
        //通过过滤器继续访问资源
        if(Integer.valueOf(age)>=18){
            chain.doFilter(req, resp);
            System.out.println("过滤响应");

        }else {
            req.getRequestDispatcher("/test.jsp").forward(req,resp);

        }
    }

}
