package miServlet;
//import com.google.gson.
import com.google.gson.Gson;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.*;
import dao.AgenciaViajes;
public class control extends HttpServlet {
       
    AgenciaViajes obj=new AgenciaViajes();
              
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException { 
        response.setContentType("text/html;charset=UTF-8"); 
        int op=Integer.parseInt(request.getParameter("opc")); 

        if(op==3)lisServicios(request, response); 
        if(op==4)lisTours(request, response);
        if(op==5)adicionCli(request, response);
        if(op==6)busCliente(request, response);
        if(op==7)cambiaCli(request, response);
        if(op==8)delCli(request, response);
        if(op==10)busCli(request, response);
        if(op==11)busUsr(request, response);
        if(op==12)adicionCho(request, response);
        if(op==13)busCho(request, response);
        if(op==14)delCho(request, response);
        if(op==15)cambiaCho(request, response);
        if(op==16)adicionDest(request, response);
        if(op==17)busDest(request, response);
        if(op==18)delDest(request, response);
        if(op==19)cambiaDest(request, response);
        if(op==20)adicionHotel(request, response);
        if(op==21)busHotel(request, response);
        if(op==22)delHotel(request, response);
        if(op==23)cambiaHotel(request, response);
        if(op==24)adicionGuias(request, response);
        if(op==25)busGuia(request, response);
        if(op==26)delGuia(request, response);
        if(op==27)cambiaGuia(request, response);
        if(op==28)adicionBus(request, response);
        if(op==29)busBus(request, response);
        if(op==30)delBus(request, response);
        if(op==31)cambiaBus(request, response);
    } 
    
  
    protected void filtrado(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException { 
      String cod=request.getParameter("consulta");         
        PrintWriter out = response.getWriter(); 
   Gson gs=new Gson(); 
        //Lo imprime en el json 
   out.println(gs.toJson(obj.filtra(cod))); 
         
    }
    protected void busCli(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException { 
        String cod=request.getParameter("user");
        String psw=request.getParameter("psw");
      //almacenar temporalmente la lista de alumnos y llamar a la pagAlumno
      request.setAttribute("dato", obj.busUsuarios(cod,psw));
      String pag="/Bienvenida.jsp";
      request.getRequestDispatcher(pag).forward(request, response);
    }
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
    
    protected void busUsr(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException { 
        String cod=request.getParameter("user");
        String psw=request.getParameter("psw");
      //almacenar temporalmente la lista de alumnos y llamar a la pagAlumno
      request.setAttribute("dato", obj.busUsuarios(cod,psw));
      String pag="/User_dashboard.jsp";
      request.getRequestDispatcher(pag).forward(request, response);
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
      String pag="/lisChofer_user.jsp";
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

    private void lisServicios(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String cod=request.getParameter("cod");
        String nom=request.getParameter("nombre");
        //almacenar temporalmente la lista de alumnos y llamar a la pagAlumno
        request.setAttribute("dato", obj.lisServicios());
        request.setAttribute("dato2", nom);
        String pag="/pagservicios.jsp";
        request.getRequestDispatcher(pag).forward(request,response);
    }

    private void lisTours(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String cod=request.getParameter("cod");
        String nom=request.getParameter("nombre");
        //almacenar temporalmente la lista de alumnos y llamar a la pagAlumno
        request.setAttribute("dato", obj.lisTours());
        request.setAttribute("dato2", nom);
        String pag="/pagtours.jsp";
        request.getRequestDispatcher(pag).forward(request,response);
    }
}



