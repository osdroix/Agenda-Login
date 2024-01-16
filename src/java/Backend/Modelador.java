/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Backend;

import Entidades.usuarios;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author osdroix
 */
@WebServlet(name = "Modelador", urlPatterns = {"/Modelador"})
public class Modelador extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
       protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        String accion = request.getParameter("accion");
        String fechas;
               java.util.Date fecha = new Date();
               fechas = fecha.toString();
           usuarios e = new usuarios();
        switch(accion){
            case "Registro":
            String usu,con;
             
           usu = request.getParameter("NOMBRE");
           con = request.getParameter("CONTRA");
            
               e.setNom_usu(usu);
               e.setContraseña_usu(con);
                        
                        int query = CRUD.guardar(e);
                
            
                  response.sendRedirect("Dashboard.jsp?in=Registro Valido&img=Img/ok.png&error=Bienvenido");
             break;
            case "Registro-Nota":
                String titulo,descripcion,Id;
               titulo = request.getParameter("titulo");
               descripcion = request.getParameter("des");
               Id = request.getParameter("id");
               

                   e.setId_AS(Id);
                   e.setNom_Agenda(titulo);
                   e.setFecha_Agenda(fechas);
                   e.setAgenda(descripcion);

                            int query1 = CRUD.guardarAgenda(e);


                      response.sendRedirect("info.jsp");
             break;
            case "login":
            
            try (PrintWriter out = response.getWriter()) {
           String nom = request.getParameter("NOMBRE");
            String contraseña = request.getParameter("CONTRA"); 
            usuarios u = new usuarios();
            u = u.Validarusuario(nom, contraseña);
          
            
           if (u!=null) {
                HttpSession sesionOk=request.getSession();
                sesionOk.setAttribute("user", u);
                usuarios x=(usuarios)sesionOk.getAttribute("user");
                System.out.print(x.getNom_usu());
                
                    response.sendRedirect("info.jsp");
           
            }else 
               response.sendRedirect("Dashboard.jsp?in=Usuario &error=Usuario no registrado&img=Img/enojo.jpg");

                }catch(Exception c){

                 System.out.println(c.getMessage());
                        System.out.println(c.getStackTrace());
                }
             break;
        case "cerrar-sesion":
             HttpSession sesion=request.getSession();
            sesion.removeAttribute("user");
            sesion.invalidate();
                
            
                  response.sendRedirect("Dashboard.jsp?in=Cerrando sesion&img=Img/ok.png&error=Hasta luego");
             break;
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
           try {
               processRequest(request, response);
           } catch (SQLException ex) {
               Logger.getLogger(Modelador.class.getName()).log(Level.SEVERE, null, ex);
           }
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
           try {
               processRequest(request, response);
           } catch (SQLException ex) {
               Logger.getLogger(Modelador.class.getName()).log(Level.SEVERE, null, ex);
           }
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
