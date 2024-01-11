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
import modelo.Buses;

public class controlBus extends HttpServlet {
    AgenciaViajes obj=new AgenciaViajes();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        int op=Integer.parseInt(request.getParameter("opc"));
        if(op==1)adicionBus(request, response);
        if(op==2)busBus(request, response);
        if(op==3)delBus(request, response);
        if(op==4)cambiaBus(request, response);
    }
    //Bus
    protected void adicionBus(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Buses a=new Buses();
        a.setMarca_bus(request.getParameter("mar"));
        a.setModelo_bus(request.getParameter("mod"));
        a.setPlaca_bus(request.getParameter("pla"));
        a.setId_chofer(request.getParameter("idc"));
        obj.adicionBus(a);
      String pag="/lisBus_usr.jsp";
      request.getRequestDispatcher(pag).forward(request, response);
    }
    
    protected void cambiaBus(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Buses a=new Buses();
        a.setId_buses(request.getParameter("id"));
        a.setMarca_bus(request.getParameter("mar"));
        a.setModelo_bus(request.getParameter("mod"));
        a.setPlaca_bus(request.getParameter("pla"));
        a.setId_chofer(request.getParameter("idc"));
        obj.cambiaBus(a);
      String pag="/lisBus_usr.jsp";
      request.getRequestDispatcher(pag).forward(request, response);
    }
    protected void delBus(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String id=request.getParameter("id");
        obj.delBus(id);
      String pag="/lisBus_usr.jsp";
      request.getRequestDispatcher(pag).forward(request, response);
    }
    protected void busBus(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException { 
        String cod=request.getParameter("id");
      //almacenar temporalmente la lista de alumnos y llamar a la pagAlumno
      request.setAttribute("dato", obj.busBus(cod));
      String pag="/ModiBus.jsp";
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
