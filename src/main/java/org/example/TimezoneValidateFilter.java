package org.example;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.ZoneId;

@WebFilter(value = "/time/*")
public class TimezoneValidateFilter extends HttpFilter {
    @Override
    public void doFilter(HttpServletRequest req,
                         HttpServletResponse resp,
                         FilterChain chain) throws IOException, ServletException {
        String timezone = req.getParameter("timezone");
        if(timezone == null || timezoneIsCorrect(timezone)){
            chain.doFilter(req, resp);
        }else{
            resp.setStatus(400);
            resp.setContentType("text/html");
            resp.getWriter().write("Not valid timezone");
            resp.getWriter().close();
        }
    }
    private boolean timezoneIsCorrect(String timezone){
        try{
            ZoneId.of(timezone.replace(" ", "+"));
            return true;
        }catch (Exception e){
            return false;
        }
    }
}
