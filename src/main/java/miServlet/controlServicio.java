
package miServlet;

import dao.AgenciaViajes;
import java.io.IOException;
import java.io.OutputStream;
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
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.Image;


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
        if(op==7)adicionServiciofinal(request, response);
        if(op==8)getPDF(request, response); //JEMI
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
        
        //a.setNom_clie(request.getParameter("nombre"));
        //request.setAttribute("nombre", cli.getNom_clie()+", "+cli.getNom_clie());
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
    
     protected void adicionServiciofinal(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Servicios a=new Servicios();
        HttpSession ses=request.getSession();
        Clientes cli=(Clientes)ses.getAttribute("cliente");
        a.setTour_id(request.getParameter("tour"));
        a.setId_cli(request.getParameter("id"));
        a.setId_fp(request.getParameter("pago"));
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
      Tours cli=obj.busTourxCliente(cod);//esta buscando en base al id de cliente
      HttpSession ses=request.getSession();
      ses.setAttribute("cliente",cli);
      request.setAttribute("dato", obj.busTourxCli(cod));
      String pag="/MisTours.jsp";
      request.getRequestDispatcher(pag).forward(request, response);
    }
    
    //JEMII
    protected void getPDF(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
    String tourId = request.getParameter("id");
    String clientId = request.getParameter("idc");

    Tours tour = obj.busTourCli(tourId);
    Clientes cliente = obj.busCliente(clientId);

    response.setContentType("application/pdf");
    response.setHeader("Content-Disposition", "attachment; filename=ReciboCliente_" + cliente.getNom_clie() +"_"+ tour.getDescrip_tour() + ".pdf");
    try (OutputStream out = response.getOutputStream()) {
        // Crear un nuevo documento PDF
        Document document = new Document();
        PdfWriter.getInstance(document, out);

        // Abrir el documento
        document.open();

        // Agregar logo NO ME SALE :(
       /* Image logo = Image.getInstance("assets/LOGO.png");
        logo.scaleToFit(40,40); // Ajustar el tamaño del logo
        document.add(logo);*/
        
        // Agregar contenido al documento 
        document.add(new Paragraph("RECIBO EMITIDO POR TURISMO SAN RAMÓN "));
        document.add(new Paragraph("TOUR: " + tourId));
        document.add(new Paragraph("CLIENTE: " + clientId));
        document.add(new Paragraph(" "));
        document.add(new Paragraph(" "));
        document.add(new Paragraph(" "));
        document.add(new Paragraph("----------Información del Cliente----------"+"\n"));
        document.add(new Paragraph("Nombre: " + cliente.getNom_clie()+" "+ cliente.getApe_cli()));
        document.add(new Paragraph("DNI: " + cliente.getDni_cli()));
        document.add(new Paragraph("Teléfono: " + cliente.getFono_cli()));
        document.add(new Paragraph("Mail: " + cliente.getMail_cli()));
        document.add(new Paragraph(" "));
        document.add(new Paragraph(" "));
        document.add(new Paragraph(" "));
        document.add(new Paragraph("----------Información del Tour----------"+"\n"));
        document.add(new Paragraph(tour.getDescrip_tour()));
        document.add(new Paragraph("Destino: " + tour.getDestino()));
        document.add(new Paragraph("Tarifa: " + tour.getTarifa()));
        document.add(new Paragraph("Fecha programada: " + tour.getFecha_inicio()));
        document.add(new Paragraph("Fecha de retorno: " + tour.getFecha_fin()));
        document.add(new Paragraph(" "));
        document.add(new Paragraph(" "));
        document.add(new Paragraph(" "));
        document.add(new Paragraph("----------Instrucciones----------"+"\n"));
        document.add(new Paragraph("Recuerde acudir con su DNI y copia física de ticket de compra"));
        document.add(new Paragraph("Aceptamos pagos VISA / MASTERCARD [Débito/Crédito] / YAPE - PLIN"));
        document.add(new Paragraph("Para comunicarse con asistencia puede llamar al siguiente número"));
        document.add(new Paragraph("9999 20 247"));
        
        
        // Cerrar el documento
        document.close();
    } catch (Exception ex) {
        ex.printStackTrace();
        System.out.println("Error al generar el PDF: " + ex.getMessage());
     }
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
