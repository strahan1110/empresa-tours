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
import modelo.Clientes;

public class controlCliente extends HttpServlet {
    AgenciaViajes obj=new AgenciaViajes();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        int op=Integer.parseInt(request.getParameter("opc")); 
        if(op==1)adicionCli(request, response);
        if(op==2)busCliente(request, response);
        if(op==3)delCli(request, response);
        if(op==4)cambiaCli(request, response);
    }
    //CLIENTE
    protected void adicionCli(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Clientes a=new Clientes();
        a.setNom_clie(request.getParameter("nombre"));
        a.setApe_cli(request.getParameter("apellido"));
        a.setDni_cli(Integer.parseInt(request.getParameter("dni")));
        a.setDirec_cli(request.getParameter("direc"));
        a.setFono_cli(request.getParameter("tel"));
        a.setMail_cli(request.getParameter("correo"));
        a.setPassword(request.getParameter("psw"));
        a.setNacionalidad(request.getParameter("nacio"));
        obj.adicionCli(a);
      String pag="/login.jsp";
      request.getRequestDispatcher(pag).forward(request, response);
    }
    protected void cambiaCli(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Clientes a=new Clientes();
        a.setId_cli(request.getParameter("id"));
        a.setNom_clie(request.getParameter("nom"));
        a.setApe_cli(request.getParameter("ape"));
        a.setDni_cli(Integer.parseInt(request.getParameter("dni")));
        a.setDirec_cli(request.getParameter("dir"));
        a.setFono_cli(request.getParameter("tel"));
        a.setMail_cli(request.getParameter("cor"));
        a.setPassword(request.getParameter("psw"));
        a.setNacionalidad(request.getParameter("nac"));
        obj.cambiaCli(a);
      String pag="/lisCli_usr.jsp";
      request.getRequestDispatcher(pag).forward(request, response);
    }
    protected void delCli(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String id=request.getParameter("id");
        obj.delCli(id);
      String pag="/lisCli_usr.jsp";
      request.getRequestDispatcher(pag).forward(request, response);
    }
    protected void busCliente(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException { 
        String cod=request.getParameter("id");
      //almacenar temporalmente la lista de alumnos y llamar a la pagAlumno
      request.setAttribute("dato", obj.busCliente(cod));
      String pag="/ModiCliente.jsp";
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
