/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controladores;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Marca;
import model.Modelo;
import util.ConectaBD;

@WebServlet(urlPatterns = "/teste")
public class testeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
            throws ServletException, IOException {
    
        resp.setContentType("text/html;charset=UTF-8");
        Marca marca = new Marca();
        marca.setId(0);
        marca.setNome("Volkswagen");
             
        try (PrintWriter out = resp.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Teste de Marca</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Teste de Marca</h1>");
            out.println("<p>Marca:" + marca.getId() + "-" + marca.getNome() + "</p>");
            out.println("</body>");
            out.println("</html>");
        }
        
        
    }
}
