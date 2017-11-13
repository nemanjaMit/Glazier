package presentation;

import glazier.Calculation;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@WebServlet(name = "Servlet", urlPatterns = {"/Servlet"})
public class Servlet extends HttpServlet {
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
          
        int type = Integer.parseInt(request.getParameter("type")); // Searches for the parameter "type" with the request.getParameter() method, so we can pull out information to the servlet.
        int width = Integer.parseInt(request.getParameter("width")); // Searches for the parameter "width" with the request.getParameter() method, so we can pull out information to the servlet.
        int height = Integer.parseInt(request.getParameter("height")); // Searches for the parameter "height" with the request.getParameter() method, so we can pull out information to the servlet.
        
        
        Calculation calc;
        try {
            calc = new Calculation();
            calc.Calculation(height, width, type);
            
        } catch (Exception ex) {
            response.sendRedirect("error.html"); // Sending the user to the error page if calculation fails or misconnection with SQL Database.
            Logger.getLogger(Servlet.class.getName()).log(Level.SEVERE, null, ex);
            return;
        }

        
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {

            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<link href=\"media/style.css\" rel=\"stylesheet\" type=\"text/css\" />");
            out.println("<title>Order page</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<div id=\"wrapper\">");
            out.println("<div id=\"header\">");
            out.println("<nav id=\"nav\" style =\"padding-top: 6px\">");
            out.println("<ul>");
            out.println("<li><a style=\"padding-left: 230px;\" href=\"index.html\">Home</a></li>");
            out.println("<li>");
            out.println("<a style=\"padding-right: 40px;\">Order</a>");
            out.println("<ul>");
            out.println("<li><a href=\"window.html\">Create an order</a></li>");
            out.println("</ul>");
            out.println("</li>");
            out.println("</ul>");
            out.println("</nav>");
            out.println("</div>");
            out.println("<div id=\"left-column\" style=\"padding-left: 165px\">");
            out.println("<div class=\"box\">");
            out.println("<center><h1>Order Succesful</h1></center>");
            out.println("<p><b><u>Frametype</p></b></u>");
            
            // Switch case of the variable type, so we can print which frame our user have chosen.
            switch (type) {
                case 1: {
                    out.println("<p>Woodframe - kr. 100,- pr m</p>");
                    break;
                }
                case 2: {
                    out.println("<p>Vinylframe - kr. 200,- pr m</p>");
                    break;
                }
                case 3: {
                    out.println("<p>Aluminiumframe - kr. 350,- pr m</p>");
                    break;
                }
            }
   
            out.println("<p><b><br><u>Dimensions</p></b></u> ");
            out.println("<p>Width: <i>" + request.getParameter("width") + "</i> cm"); // Gets users width input.
            out.println("<p>Height: <i> " + request.getParameter("height") + "</i> cm"); // Gets users height input.
            out.println("<hr>");
            out.println("<h3> Receipt </h3>");
            out.println("<p><b><li>Frameprice - </b> kr <i> " + calc.getFramePrice() + "</i>,-</p>"); // Gets the frameprice from the calculation class.
            out.println("<p><b><li>Glassprice - </b> kr <i> " + calc.getGlassPrice() + "</i>,-</p>"); // Gets the glassprice from the calculation class.
            out.println("<hr>");
            out.println("<p><b><li>Total price - </b> kr <i>" + calc.getTotalPrice() + ",-</p><hr></i>"); // Gets the totalprice from the calculation clas.
            out.println("</div>");
            
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
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
    }// </editor-fold>

}
