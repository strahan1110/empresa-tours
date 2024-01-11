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
import modelo.Destinos;

public class controlDestino extends HttpServlet {
    AgenciaViajes obj=new AgenciaViajes();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        int op=Integer.parseInt(request.getParameter("opc")); 
        if(op==1)adicionDest(request, response);
        if(op==2)busDest(request, response);
        if(op==3)delDest(request, response);
        if(op==4)cambiaDest(request, response);
    }
    //DESTINO
    protected void adicionDest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Destinos a=new Destinos();
        a.setNom_destino(request.getParameter("nom"));
        a.setDepart_destino(request.getParameter("dep"));
        a.setProv_destino(request.getParameter("prov"));
        obj.adicionDestino(a);
      String pag="/lisDest_usr.jsp";
      request.getRequestDispatcher(pag).forward(request, response);
    }
    
    protected void cambiaDest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Destinos a=new Destinos();
        a.setId_destino(request.getParameter("id"));
        a.setNom_destino(request.getParameter("nom"));
        a.setDepart_destino(request.getParameter("dep"));
        a.setProv_destino(request.getParameter("prov"));
        obj.cambiaDest(a);
      String pag="/lisDest_usr.jsp";
      request.getRequestDispatcher(pag).forward(request, response);
    }
    protected void delDest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String id=request.getParameter("id");
        obj.delDest(id);
      String pag="/lisDest_usr.jsp";
      request.getRequestDispatcher(pag).forward(request, response);
    }
    protected void busDest(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException { 
        String cod=request.getParameter("id");
      //almacenar temporalmente la lista de alumnos y llamar a la pagAlumno
      request.setAttribute("dato", obj.busDestinos(cod));
      String pag="/ModiDest.jsp";
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
