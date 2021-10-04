package com.itechart;

import java.io.IOException;
import java.time.LocalDateTime;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;

@WebFilter(filterName = "TimeOfDayFilter",
    urlPatterns = {"/*"},
    initParams = {
        @WebInitParam(name = "mood", value = "awake")})
public class TimeOfDayFilter implements Filter {

  private String mood = null;

  @Override
  public void init(FilterConfig filterConfig) throws ServletException {
    mood = filterConfig.getInitParameter("mood");
  }

  @Override
  public void doFilter(ServletRequest req,
      ServletResponse res,
      FilterChain chain) throws IOException, ServletException {
    LocalDateTime now = LocalDateTime.now();
    switch (now.getHour()) {
      case 23:
      case 0:
      case 1:
      case 2:
      case 3:
      case 4:
      case 5:
      case 6:
        mood = "sleepy";
        break;
      case 7:
      case 13:
      case 18:
        mood = "hungry";
        break;
      case 8:
      case 9:
      case 10:
      case 12:
      case 14:
      case 16:
      case 17:
        mood = "alert";
        break;
      case 11:
      case 15:
        mood = "in need of coffee";
        break;
      case 19:
      case 20:
      case 21:
        mood = "thoughtful";
        break;
      case 22:
        mood = "lethargic";
        break;
    }
    req.setAttribute("mood", mood);
    chain.doFilter(req, res);
  }

  @Override
  public void destroy() {
  }
}
