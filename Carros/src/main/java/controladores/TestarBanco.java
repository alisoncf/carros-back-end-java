/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controladores;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import util.ConectaBD;

/**
 *
 * @author Administrador
 */
@WebServlet(urlPatterns = "/testbd")
public class TestarBanco extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        ConectaBD bd = new ConectaBD();
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Lista de Veículos</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Lista de Veículos " + request.getContextPath() + "</h1>");
            try {
                out.println(bd.getResultset("select 1>0"));
            } catch (Exception ex) {
                
                out.println(ex.getMessage());
            }
            out.println("</body>");
            out.println("</html>");
        }
    }
}
