/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package miServlet;
import dao.AgenciaViajes;
import modelo.Tours;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class controlTour extends HttpServlet {
    AgenciaViajes obj=new AgenciaViajes();


    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        int op=Integer.parseInt(request.getParameter("opc")); 
        if(op==1)adicionTour(request, response);
        if(op==2)busTour(request, response);
        if(op==3)delTour(request, response);
        if(op==4)cambiaTour(request, response);
    }
    //CHOFER
    protected void adicionTour(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Tours a=new Tours();
        //a.setTour_id(request.getParameter("id"));
        a.setDescrip_tour(request.getParameter("des"));
        a.setId_destino(request.getParameter("idd"));
        a.setId_buses(request.getParameter("idb"));
        a.setId_guia(request.getParameter("idg"));
        a.setId_hotel(request.getParameter("idh"));
        a.setTarifa(Double.parseDouble(request.getParameter("tar")));
        a.setFecha_inicio(request.getParameter("fecini"));
        a.setFecha_fin(request.getParameter("fecfin"));
        obj.adicionTours(a);
      String pag="/lisTour_usr.jsp";
      request.getRequestDispatcher(pag).forward(request, response);
    }
    
    protected void cambiaTour(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Tours a=new Tours();
        a.setTour_id(request.getParameter("id"));
        a.setDescrip_tour(request.getParameter("desc"));
        a.setId_destino(request.getParameter("idd"));
        a.setId_buses(request.getParameter("idb"));
        a.setId_guia(request.getParameter("idg"));
        a.setId_hotel(request.getParameter("idh"));
        a.setTarifa(Double.parseDouble(request.getParameter("tar")));
        a.setFecha_inicio(request.getParameter("fecini"));
        a.setFecha_fin(request.getParameter("fecfin"));
        obj.cambiaTours(a);
      String pag="/lisTour_usr.jsp";
      request.getRequestDispatcher(pag).forward(request, response);
    }
    protected void delTour(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String id=request.getParameter("id");
        obj.delTour(id);
      String pag="/lisTour_usr.jsp";
      request.getRequestDispatcher(pag).forward(request, response);
    }
    protected void busTour(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException { 
        String cod=request.getParameter("id");
      //almacenar temporalmente la lista de alumnos y llamar a la pagAlumno
      request.setAttribute("dato", obj.busTour(cod));
      String pag="/ModiTour.jsp";
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
