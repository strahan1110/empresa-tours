
package miServlet;

import dao.AgenciaViajes;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Usuarios;

public class controlUsuarios extends HttpServlet {
    AgenciaViajes obj=new AgenciaViajes();


    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        int op=Integer.parseInt(request.getParameter("opc")); 
        if(op==1)adicionUsuario(request, response);
        if(op==2)busUsuario(request, response);
        if(op==3)delUsuario(request, response);
        if(op==4)cambiaUsuario(request, response);
    }
    //CLIENTE
    protected void adicionUsuario(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Usuarios a=new Usuarios();
        a.setNom_us(request.getParameter("nom"));
        a.setApe_us(request.getParameter("ape"));
        a.setDni_us(Integer.parseInt(request.getParameter("dni")));
        a.setFono_us(request.getParameter("tel"));
        a.setMail_us(request.getParameter("cor"));
        a.setFecha(request.getParameter("nac"));
        a.setPws_us(request.getParameter("psw"));
        obj.adicionUsuario(a);
      String pag="/login_usr.jsp";
      request.getRequestDispatcher(pag).forward(request, response);
    }
    protected void cambiaUsuario(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Usuarios a=new Usuarios();
        a.setId_us(request.getParameter("id"));
        a.setNom_us(request.getParameter("nom"));
        a.setApe_us(request.getParameter("ape"));
        a.setDni_us(Integer.parseInt(request.getParameter("dni")));
        a.setFono_us(request.getParameter("tel"));
        a.setMail_us(request.getParameter("cor"));
        a.setFecha(request.getParameter("nac"));
        a.setPws_us(request.getParameter("psw"));
        obj.cambiaUsuario(a);
      String pag="/lisUsuario_usr.jsp";
      request.getRequestDispatcher(pag).forward(request, response);
    }
    protected void delUsuario(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String id=request.getParameter("id");
        obj.delUsuario(id);
      String pag="/lisUsuario_usr.jsp";
      request.getRequestDispatcher(pag).forward(request, response);
    }
    protected void busUsuario(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException { 
        String cod=request.getParameter("id");
      //almacenar temporalmente la lista de alumnos y llamar a la pagAlumno
      request.setAttribute("dato", obj.busUsuario(cod));
      String pag="/ModiUsuario.jsp";
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
