package com.itechart;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/report")
public class MoodServlet extends HttpServlet {

  private static final long serialVersionUID = 18925377774889413L;
  private static final Logger log =
      Logger.getLogger("jlab21.MoodServlet");

  /**
   * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
   *
   * @param request  servlet request
   * @param response servlet response
   * @throws ServletException if a servlet-specific error occurs
   * @throws IOException      if an I/O error occurs
   */
  protected void processRequest(HttpServletRequest request,
      HttpServletResponse response)
      throws ServletException, IOException {
    response.setContentType("text/html;charset=UTF-8");
    try (PrintWriter out = response.getWriter()) {
      out.println("<html lang=\"en\">");
      out.println("<head>");
      out.println("<title>Servlet MoodServlet</title>");
      out.println("</head>");
      out.println("<body>");
      out.println("<h1>Servlet MoodServlet at "
          + request.getContextPath() + "</h1>");
      String mood = (String) request.getAttribute("mood");
      out.println("<p>Duke's mood is: " + mood + "</p>");
      log.log(Level.INFO, "Current mood is {0}", mood);
      switch (mood) {
        case "sleepy":
          out.println("<img src=\"images/duke.snooze.gif\" alt=\"Duke sleeping\"/><br/>");
          break;
        case "alert":
          out.println("<img src=\"images/duke.waving.gif\" alt=\"Duke waving\"/><br/>");
          break;
        case "hungry":
          out.println("<img src=\"images/duke.cookies.gif\" alt=\"Duke with cookies\"/><br/>");
          break;
        case "lethargic":
          out.println(
              "<img src=\"images/duke.handsOnHips.gif\" alt=\"Duke with hands on hips\"/><br/>");
          break;
        case "thoughtful":
          out.println("<img src=\"images/duke.pensive.gif\" alt=\"Duke thinking\"/><br/>");
          break;
        default:
          out.println(
              "<img src=\"images/duke.thumbsup.gif\" alt=\"Duke with thumbs-up gesture\"/><br/>");
          break;
      }
      out.println("</body>");
      out.println("</html>");
    }
  }

  /**
   * Handles the HTTP <code>GET</code> method.
   *
   * @param request  servlet request
   * @param response servlet response
   * @throws ServletException if a servlet-specific error occurs
   * @throws IOException      if an I/O error occurs
   */
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    response.setContentType("text/html;charset=UTF-8");
    processRequest(request, response);
  }

  /**
   * Handles the HTTP <code>POST</code> method.
   *
   * @param request  servlet request
   * @param response servlet response
   * @throws ServletException if a servlet-specific error occurs
   * @throws IOException      if an I/O error occurs
   */
  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    processRequest(request, response);
  }

  /**
   * Returns a short description of the servlet.
   *
   * @return a String containing servlet description
   */
  @Override
  public String getServletInfo() {
    return "Short description";
  }
}
