/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package miServlet;

import dao.AgenciaViajes;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Hoteles;

public class controlHotel extends HttpServlet {
    AgenciaViajes obj=new AgenciaViajes();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        int op=Integer.parseInt(request.getParameter("opc")); 
        if(op==1)adicionHotel(request, response);
        if(op==2)busHotel(request, response);
        if(op==3)delHotel(request, response);
        if(op==4)cambiaHotel(request, response);
    }
    //Hoteles
    protected void adicionHotel(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Hoteles a=new Hoteles();
        a.setNom_hotel(request.getParameter("nom"));
        a.setEstrellas(Integer.parseInt(request.getParameter("est")));
        a.setDirec_hotel(request.getParameter("dir"));
        a.setFono_hotel(Integer.parseInt(request.getParameter("tel")));
        a.setContacto(request.getParameter("con"));
        obj.adicionHotel(a);
      String pag="/lisHotel_usr.jsp";
      request.getRequestDispatcher(pag).forward(request, response);
    }
    
    protected void cambiaHotel(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Hoteles a=new Hoteles();
        a.setId_hotel(request.getParameter("id"));
        a.setNom_hotel(request.getParameter("nom"));
        a.setEstrellas(Integer.parseInt(request.getParameter("est")));
        a.setDirec_hotel(request.getParameter("dir"));
        a.setFono_hotel(Integer.parseInt(request.getParameter("tel")));
        a.setContacto(request.getParameter("con"));
        obj.cambiaHotel(a);
      String pag="/lisHotel_usr.jsp";
      request.getRequestDispatcher(pag).forward(request, response);
    }
    protected void delHotel(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String id=request.getParameter("id");
        obj.delHotel(id);
      String pag="/lisHotel_usr.jsp";
      request.getRequestDispatcher(pag).forward(request, response);
    }
    protected void busHotel(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException { 
        String cod=request.getParameter("id");
      //almacenar temporalmente la lista de alumnos y llamar a la pagAlumno
      request.setAttribute("dato", obj.busHotel(cod));
      String pag="/ModiHotel.jsp";
      request.getRequestDispatcher(pag).forward(request, response);
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
