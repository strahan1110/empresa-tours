
package miServlet;

import dao.AgenciaViajes;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modelo.Clientes;
import modelo.Servicios;
import modelo.Tours;

public class controlServicio extends HttpServlet {
    AgenciaViajes obj=new AgenciaViajes();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        int op=Integer.parseInt(request.getParameter("opc")); 
        if(op==1)adicionServicio(request, response);
        if(op==2)busServicio(request, response);
        if(op==3)delServicio(request, response);
        if(op==4)cambiaServicio(request, response);
        if(op==5)busServ(request, response);
        if(op==6)misTours(request, response);
    }
    //Hoteles
    protected void adicionServicio(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Servicios a=new Servicios();
        HttpSession ses=request.getSession();
        Clientes cli=(Clientes)ses.getAttribute("cliente");
        a.setTour_id(request.getParameter("tour"));
        a.setId_cli(request.getParameter("id"));
        a.setId_fp(request.getParameter("pago"));
       // request.setAttribute("cli", cli.getApe_cli()+", "+cli.getNom_clie());
       // request.setAttribute("fin", a.getFechafin());
       // request.setAttribute("ini", a.getFechaini());
       // request.setAttribute("idcli", cli.getId_cli());
       // request.setAttribute("placa", a.getPlaca());
       // request.setAttribute("guia", a.getGuia());
       //request.setAttribute("desc", a.getDescripcion());
        obj.adicionServicio(a);
        String pag="/gracias.jsp";
        request.getRequestDispatcher(pag).forward(request, response);
    }
    
    protected void cambiaServicio(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Servicios a=new Servicios();
        a.setId_serv(request.getParameter("id"));
        a.setTour_id(request.getParameter("idt"));
        a.setId_cli(request.getParameter("idc"));
        a.setId_fp(request.getParameter("idp"));
        obj.cambiaServicio(a);
      String pag="/lisServicio_usr.jsp";
      request.getRequestDispatcher(pag).forward(request, response);
    }
    protected void delServicio(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String id=request.getParameter("id");
        obj.delServicio(id);
      String pag="/lisServicio_usr.jsp";
      request.getRequestDispatcher(pag).forward(request, response);
    }
    protected void busServicio(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException { 
        String cod=request.getParameter("id");
      //almacenar temporalmente la lista de alumnos y llamar a la pagAlumno
      request.setAttribute("dato", obj.busServicio(cod));
      String pag="/ModiServ.jsp";
      request.getRequestDispatcher(pag).forward(request, response);
    }
    protected void busServ(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException { 
        String cod=request.getParameter("id");
        String codc=request.getParameter("idc");
      //almacenar temporalmente la lista de alumnos y llamar a la pagAlumno
      Clientes cli=obj.busClienteLog(codc);//esta buscnado en base al id de cliente
      HttpSession ses=request.getSession();
      ses.setAttribute("cliente",cli);
      request.setAttribute("dato", obj.busTourCli(cod));
      String pag="/pagRegistroServicio.jsp";
      request.getRequestDispatcher(pag).forward(request, response);
    }
    protected void misTours(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException { 
        String cod=request.getParameter("id");
      //almacenar temporalmente la lista de alumnos y llamar a la pagAlumno
      Tours cli=obj.busTourxCliente(cod);//esta buscnado en base al id de cliente
      HttpSession ses=request.getSession();
      ses.setAttribute("cliente",cli);
      request.setAttribute("dato", obj.busTourxCli(cod));
      String pag="/MisTours.jsp";
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
