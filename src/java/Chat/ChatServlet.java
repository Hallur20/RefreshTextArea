/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Chat;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Hallur
 */
@WebServlet(name = "ChatServlet", urlPatterns = {"/ChatServlet"})
public class ChatServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession();
        Mapper m = new Mapper();

        String del = "";
        String delP = request.getParameter("delPsw");
        String msg = "";

        msg = request.getParameter("getMsg");
        String name = "";

        del = request.getParameter("del");
        name = request.getParameter("name");
        try {
            if (!del.equals("") && delP.equals("hey")) {
                try (PrintWriter out = response.getWriter()) {
                    out.println("<script>alert('password was correct. Messages have been deleted.');</script>");
                    m.delAllMsg();
                    request.getRequestDispatcher("index.jsp").include(request, response);
                }
            } else {
                try (PrintWriter out = response.getWriter()) {
                    out.println("<script>alert('wrong password');</script>");
                    request.getRequestDispatcher("index.jsp").include(request, response);
                }
            }
        } catch (Exception ex) {

        }
        try {
            if (!name.equals("")) {
                session.setAttribute("name",name);

            }
        } catch (Exception ex) {

        }
        try {
            if (!msg.equals("")) {
                m.insMsg((String) session.getAttribute("name"), msg);
            }
        } catch (Exception ex) {

        }
        response.sendRedirect("index.jsp");
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
