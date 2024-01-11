
package miServlet;

import dao.AgenciaViajes;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modelo.Clientes;
import modelo.Usuarios;

public class controlLogin extends HttpServlet {
    AgenciaViajes obj=new AgenciaViajes();
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        int op=Integer.parseInt(request.getParameter("opc"));
        if(op==1)loginCliente(request, response);
        if(op==2)loginUser(request, response);
        if(op==3)logoutUser(request, response);
    }
    protected void loginCliente(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String usr=request.getParameter("user").trim();
        String clave=request.getParameter("clave").trim();
        Clientes cli=obj.busCliente2(usr, clave);
        String pag="";
        if(cli==null){
            request.setAttribute("dato", "Usuario o clave incorrecto");
            pag="/login.jsp";
        }else{
            HttpSession ses=request.getSession();
            ses.setAttribute("cliente",cli);
            pag="/pruebas.jsp";
        }
        request.getRequestDispatcher(pag).forward(request, response);
    }
    protected void loginUser(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String usr=request.getParameter("user").trim();
        String clave=request.getParameter("clave").trim();
        Usuarios cli=obj.busUsuarios(usr, clave);
        String pag="";
        if(cli==null){
            request.setAttribute("dato", "Usuario o clave incorrecto");
            pag="/login_usr.jsp";
        }else{
            HttpSession ses=request.getSession();
            ses.setAttribute("cliente",cli);
            pag="/User_dashboard.jsp";
        }
        request.getRequestDispatcher(pag).forward(request, response);
    }
    protected void logoutUser(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession ses=request.getSession();
        ses.removeAttribute("cliente");
        String  pag="/login_usr.jsp";
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
