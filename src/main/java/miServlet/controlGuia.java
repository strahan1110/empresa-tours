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
import modelo.Guias;

public class controlGuia extends HttpServlet {
    AgenciaViajes obj=new AgenciaViajes();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        int op=Integer.parseInt(request.getParameter("opc")); 
        if(op==1)adicionGuias(request, response);
        if(op==2)busGuia(request, response);
        if(op==3)delGuia(request, response);
        if(op==4)cambiaGuia(request, response);
    }
    //Guias
    protected void adicionGuias(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Guias a=new Guias();
        a.setNom_guia(request.getParameter("nom"));
        a.setDni_guia(Integer.parseInt(request.getParameter("dni")));
        a.setFono_guia(request.getParameter("tel"));
        a.setMail_guia(request.getParameter("cor"));
        a.setIdioma_guia(request.getParameter("idi"));
        obj.adicionGuia(a);
      String pag="/lisGuia_usr.jsp";
      request.getRequestDispatcher(pag).forward(request, response);
    }
    
    protected void cambiaGuia(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Guias a=new Guias();
        a.setId_guia(request.getParameter("id"));
        a.setNom_guia(request.getParameter("nom"));
        a.setDni_guia(Integer.parseInt(request.getParameter("dni")));
        a.setFono_guia(request.getParameter("tel"));
        a.setMail_guia(request.getParameter("cor"));
        a.setIdioma_guia(request.getParameter("idi"));
        obj.cambiaGuia(a);
      String pag="/lisGuia_usr.jsp";
      request.getRequestDispatcher(pag).forward(request, response);
    }
    protected void delGuia(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String id=request.getParameter("id");
        obj.delGuia(id);
      String pag="/lisGuia_usr.jsp";
      request.getRequestDispatcher(pag).forward(request, response);
    }
    protected void busGuia(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException { 
        String cod=request.getParameter("id");
      //almacenar temporalmente la lista de alumnos y llamar a la pagAlumno
      request.setAttribute("dato", obj.busGuia(cod));
      String pag="/ModiGuia.jsp";
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
