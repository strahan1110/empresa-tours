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
import modelo.Choferes;

public class controlChofer extends HttpServlet {
    AgenciaViajes obj=new AgenciaViajes();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        int op=Integer.parseInt(request.getParameter("opc")); 
        if(op==1)adicionCho(request, response);
        if(op==2)busCho(request, response);
        if(op==3)delCho(request, response);
        if(op==4)cambiaCho(request, response);
    }
    //CHOFER
    protected void adicionCho(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Choferes a=new Choferes();
        a.setNom_chofer(request.getParameter("nom"));
        a.setDni(Integer.parseInt(request.getParameter("dni")));
        a.setFono_chofer(Integer.parseInt(request.getParameter("tel")));
        a.setMail_chofer(request.getParameter("cor"));
        obj.adicionCho(a);
      String pag="/lisChofer_usr.jsp";
      request.getRequestDispatcher(pag).forward(request, response);
    }
    
    protected void cambiaCho(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Choferes a=new Choferes();
        a.setId_chofer(request.getParameter("id"));
        a.setNom_chofer(request.getParameter("nom"));
        a.setDni(Integer.parseInt(request.getParameter("dni")));
        a.setFono_chofer(Integer.parseInt(request.getParameter("tel")));
        a.setMail_chofer(request.getParameter("cor"));
        obj.cambiaCho(a);
      String pag="/lisChofer_usr.jsp";
      request.getRequestDispatcher(pag).forward(request, response);
    }
    protected void delCho(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String id=request.getParameter("id");
        obj.delCho(id);
      String pag="/lisChofer_usr.jsp";
      request.getRequestDispatcher(pag).forward(request, response);
    }
    protected void busCho(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException { 
        String cod=request.getParameter("id");
      //almacenar temporalmente la lista de alumnos y llamar a la pagAlumno
      request.setAttribute("dato", obj.busChoferes(cod));
      String pag="/ModiCho.jsp";
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
