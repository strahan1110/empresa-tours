
package Iagencia;
import modelo.*;
import java.util.*;
public interface InterAgencia {
    List<Clientes> lisCliente();
    List<Tours> lisTours();
    List<Buses> lisBuses();
    List<Choferes> lisChoferes();
    List<Hoteles> lisHoteles();
    List<Destinos> lisDestinos();
    List<Guias> lisGuias();
    List<Usuarios> filtraUsu(String ape);
    List<Usuarios> lisUsuarios();
    List<Clientes> filtraClie(String ape);
    List<Tours> lisResTours ();
    List<Servicios> lisServicios();
    
    Usuarios busUsuarios (String usr, String pwd);
    Clientes busCliente (String id);
    //al grabar debe regresar el numero de factura 
    String grabaFactura (String codc, List<FormaPago>lista);
}
