package dao;
import util.MySQLConexion;
import modelo.*;
import java.util.*;
import java.sql.*;
import Iagencia.*;
public class AgenciaViajes implements InterAgencia{
    //lista clientes
     public List<Clientes> lisCliente(){
    List<Clientes> lis=new ArrayList();
    Connection cn=MySQLConexion.getConexion();
    try{
      String sql="select idcliente,nomcliente,apecliente,docidentidad,direccion,telefono,correo,password,nacionalidad from clientes";  
        PreparedStatement st=cn.prepareStatement(sql);
        ResultSet rs=st.executeQuery();
        while(rs.next()){//leer cada fila de la tabla
            Clientes p=new Clientes();
            p.setId_cli(rs.getString(1));
            p.setNom_clie(rs.getString(2));
            p.setApe_cli(rs.getString(3));
            p.setDni_cli(rs.getInt(4));
            p.setDirec_cli(rs.getString(5));
            p.setFono_cli(rs.getString(6));
            p.setMail_cli(rs.getString(7));
            p.setPassword(rs.getString(8));
            p.setNacionalidad(rs.getString(9));
            lis.add(p); //el objeto prestamo de un cliente pasar a la lista
        }
    }catch(Exception ex){
        ex.printStackTrace();
    }
       return lis;
     }
     public void adicionCli(Clientes a){
     Connection cn=MySQLConexion.getConexion();
     try{
       String sql="{call adiCliente(?,?,?,?,?,?,?,?)}";  
       CallableStatement st=cn.prepareCall(sql);
       st.setString(1,a.getNom_clie());
       st.setString(2, a.getApe_cli());
       st.setInt(3, a.getDni_cli());
       st.setString(4, a.getDirec_cli());
       st.setString(5, a.getFono_cli());
       st.setString(6, a.getMail_cli());
       st.setString(7, a.getPassword());
       st.setString(8, a.getNacionalidad());
       st.executeUpdate();
     }catch(Exception ex){
         ex.printStackTrace();
     }
     }
     
     public Clientes busCliente(String id){
         Clientes p=null;
    Connection cn=MySQLConexion.getConexion();
    try{
      String sql="select idcliente,nomcliente,apecliente,docidentidad,direccion,telefono,correo,password,nacionalidad from clientes where idcliente=?";  
        PreparedStatement st=cn.prepareStatement(sql);
        st.setString(1, id);
        ResultSet rs=st.executeQuery();
        while(rs.next()){//leer cada fila de la tabla
            p=new Clientes();
            p.setId_cli(rs.getString(1));
            p.setNom_clie(rs.getString(2));
            p.setApe_cli(rs.getString(3));
            p.setDni_cli(rs.getInt(4));
            p.setDirec_cli(rs.getString(5));
            p.setFono_cli(rs.getString(6));
            p.setMail_cli(rs.getString(7));
            p.setPassword(rs.getString(8));
            p.setNacionalidad(rs.getString(9));
        }
    }catch(Exception ex){
        ex.printStackTrace();
    }
       return p;
   } 
     
       //nuevo cambioooo jemi
      public Clientes busCliente2(String correo, String pass){
        Clientes p=null;  
        Connection cn=MySQLConexion.getConexion();
     try{
     String sql="select * from clientes where correo=? and password=?";
     PreparedStatement st=cn.prepareStatement(sql);
     st.setString(1, correo);
     st.setString(2, pass);
     ResultSet rs=st.executeQuery();
     if(rs.next()){
         p=new Clientes();
            p.setId_cli(rs.getString(1));
            p.setNom_clie(rs.getString(2));
            p.setApe_cli(rs.getString(3));
            p.setDni_cli(rs.getInt(4));
            p.setDirec_cli(rs.getString(5));
            p.setFono_cli(rs.getString(6));
            p.setMail_cli(correo);
            p.setPassword(pass);
            p.setNacionalidad(rs.getString(9));
       }
     }catch(Exception ex){
      ex.printStackTrace();
     }finally{
         try{ cn.close();}catch(Exception ex2){}
     }
     return p;
   } 
   
      
     public void cambiaCli(Clientes a){
     Connection cn=MySQLConexion.getConexion();
     try{
       String sql="{call editCliente(?,?,?,?,?,?,?,?,?)}";  
       CallableStatement st=cn.prepareCall(sql);
       st.setString(1, a.getId_cli());
       st.setString(2,a.getNom_clie());
       st.setString(3, a.getApe_cli());
       st.setInt(4, a.getDni_cli());
       st.setString(5, a.getDirec_cli());
       st.setString(6, a.getFono_cli());
       st.setString(7, a.getMail_cli());
       st.setString(8, a.getPassword());
       st.setString(9, a.getNacionalidad());
       st.executeUpdate();
     }catch(Exception ex){
         ex.printStackTrace();
     }
     }
   //Eliminar chofer
   public void delCli(String id){
     Connection cn=MySQLConexion.getConexion();
     try{
       String sql="{call delCliente(?)}";  
       CallableStatement st=cn.prepareCall(sql);
       st.setString(1, id);
       st.executeUpdate();
     }catch(Exception ex){
         ex.printStackTrace();
     }
     }
     
     //Filtra clientes
     
     public List<Clientes> filtraClie(String ape){
    List<Clientes> lis=new ArrayList();
    Connection cn=MySQLConexion.getConexion();
    try{
      String sql="select idcliente,nomcliente,apecliente,docidentidad,direccion,telefono,correo,password,nacionalidad from clientes where nomcliente like ? or apecliente like ?";
        PreparedStatement st=cn.prepareStatement(sql);
        st.setString(1, ape+"%");
        st.setString(2, ape+"%");
        ResultSet rs=st.executeQuery();
        while(rs.next()){//leer cada fila de la tabla
            Clientes p=new Clientes();
             p.setId_cli(rs.getString(1));
            p.setNom_clie(rs.getString(2));
            p.setApe_cli(rs.getString(3));
            p.setDni_cli(rs.getInt(4));
            p.setDirec_cli(rs.getString(5));
            p.setFono_cli(rs.getString(6));
            p.setMail_cli(rs.getString(7));
            p.setPassword(rs.getString(8));
            p.setNacionalidad(rs.getString(9));
            lis.add(p); //el objeto prestamo de un cliente pasar a la lista
        }
    }catch(Exception ex){
        ex.printStackTrace();
    }
       return lis;
   }
     
     //lista de usuarios 
     
     public List<Usuarios> lisUsuarios(){
    List<Usuarios> lis=new ArrayList();
    Connection cn=MySQLConexion.getConexion();
    try{
      String sql="select idusuario,nomusuario,apeusuario,docidentidad,telefono,correo,fecNacimiento, u.password from usuarios u";  
        PreparedStatement st=cn.prepareStatement(sql);
        ResultSet rs=st.executeQuery();
        while(rs.next()){//leer cada fila de la tabla
            Usuarios p=new Usuarios();
            p.setId_us(rs.getString(1));
            p.setNom_us(rs.getString(2));
            p.setApe_us(rs.getString(3));
            p.setDni_us(rs.getInt(4));
            p.setFono_us(rs.getString(5));
            p.setMail_us(rs.getString(6));
            p.setFecha(rs.getString(7));
            p.setPws_us(rs.getString(8));
            lis.add(p); //el objeto prestamo de un cliente pasar a la lista
        }
    }catch(Exception ex){
        ex.printStackTrace();
    }
       return lis;
   }   
    
     
      public List<Usuarios> filtraUsu(String ape){
    List<Usuarios> lis=new ArrayList();
    Connection cn=MySQLConexion.getConexion();
    try{
      String sql="select idusuario,nomusuario,apeusuario,idalumno,docidentidad,telefono,correo,fecNacimiento,password from usuarios where nomusuario like ? or apeusuario like ?";
        PreparedStatement st=cn.prepareStatement(sql);
        st.setString(1, ape+"%");
        st.setString(2, ape+"%");
        ResultSet rs=st.executeQuery();
        while(rs.next()){//leer cada fila de la tabla
            Usuarios p=new Usuarios();
            p.setId_us(rs.getString(1));
            p.setNom_us(rs.getString(2));
            p.setApe_us(rs.getString(3));
            p.setDni_us(rs.getInt(4));
            p.setFono_us(rs.getString(5));
            p.setMail_us(rs.getString(6));
            p.setFecha(rs.getString(7));
            p.setPws_us(rs.getString(8));
            lis.add(p); //el objeto prestamo de un cliente pasar a la lista
        }
    }catch(Exception ex){
        ex.printStackTrace();
    }
       return lis;
   }
      
      //Busca usuarios
      
      public Usuarios busUsuarios (String usr, String pwd) {
        Connection cn=MySQLConexion.getConexion();
     Usuarios p=null;
     try{
     String sql="Select apeusuario, nomusuario from usuarios where correo=? and password=?";
     PreparedStatement st=cn.prepareStatement(sql);
     st.setString(1, usr);
     st.setString(2, pwd);
     ResultSet rs=st.executeQuery();
     if(rs.next()){
         p=new Usuarios();
         p.setMail_us(usr);
         p.setApe_us(rs.getString(1));
         p.setNom_us(rs.getString(2));
       }
     }catch(Exception ex){
      ex.printStackTrace();
     }finally{
         try{ cn.close();}catch(Exception ex2){}
     }
     return p;
    }
      
       //lista de servicios
      public List<Servicios> lisServicios(){
    List<Servicios> lis=new ArrayList();
    Connection cn=MySQLConexion.getConexion();
    try{
      String sql="SELECT s.idServicio,t.descripcion,c.nomCliente,c.apeCliente,p.descripcion from servicios s JOIN tours t "
              + "on s.idTour=t.idTour join clientes c on c.idCliente=s.idCliente join formapago p on p.idfpago=s.idfPago";
        PreparedStatement st=cn.prepareStatement(sql);
        ResultSet rs=st.executeQuery();
        while(rs.next()){//leer cada fila de la tabla
            Servicios p=new Servicios();
            p.setId_serv(rs.getString(1));
            p.setDescripcion(rs.getString(2));
            p.setNomcli(rs.getString(3));
            p.setApecli(rs.getString(4));
            p.setFormpago(rs.getString(5));
            lis.add(p); //el objeto prestamo de un cliente pasar a la lista
        }
    }catch(Exception ex){
        ex.printStackTrace();
    }
       return lis;
   }  
      
      //lista de tours
      public List<Tours> lisTours (){
    List<Tours> lis=new ArrayList();
    Connection cn=MySQLConexion.getConexion();
    try{
      String sql="SELECT t.idTour,t.descripcion,t.idDestino,t.idBus,t.idGuia,t.idHotel,t.tarifa,t.fechaInicio,t.fechaFin,d.destino,b.placaBus,g.nomGuia FROM tours t JOIN destinos d on d.idDestino=t.idDestino join buses b on b.idBus=t.idBus join guias g on g.idGuia=t.idGuia";  
        PreparedStatement st=cn.prepareStatement(sql);
        ResultSet rs=st.executeQuery();
        while(rs.next()){//leer cada fila de la tabla
            Tours p=new Tours();
            p.setTour_id(rs.getString(1));
            p.setDescrip_tour(rs.getString(2));
            p.setId_destino(rs.getString(3));
            p.setId_buses(rs.getString(4));
            p.setId_guia(rs.getString(5));
            p.setId_hotel(rs.getString(6));
            p.setTarifa(rs.getDouble(7));
            p.setFecha_inicio(rs.getString(8));
            p.setFecha_fin(rs.getString(9));
            p.setDestino(rs.getString(10));
            p.setPlaca(rs.getString(11));
            p.setGuia(rs.getString(12));
            lis.add(p); //el objeto prestamo de un cliente pasar a la lista
        }
    }catch(Exception ex){
        ex.printStackTrace();
    }
       return lis;
   }   
      
      //lista de buses
      public List<Buses> lisBuses(){
    List<Buses> lis=new ArrayList();
    Connection cn=MySQLConexion.getConexion();
    try{
      String sql="select b.idBus,b.marcaBus,b.modelo,b.placaBus,b.idconductor,c.nomConductor from buses b join conductores c on c.idconductor=b.idconductor";  
        PreparedStatement st=cn.prepareStatement(sql);
        ResultSet rs=st.executeQuery();
        while(rs.next()){//leer cada fila de la tabla
            Buses p=new Buses();
            p.setId_buses(rs.getString(1));
            p.setMarca_bus(rs.getString(2));
            p.setModelo_bus(rs.getString(3));
            p.setPlaca_bus(rs.getString(4));
            p.setId_chofer(rs.getString(5));
            p.setNom_chofer(rs.getString(6));
            lis.add(p); //el objeto prestamo de un cliente pasar a la lista
        }
    }catch(Exception ex){
        ex.printStackTrace();
    }
       return lis;
   }
      //AÑADIR CHOFER
      public void adicionBus(Buses a){
     Connection cn=MySQLConexion.getConexion();
     try{
       String sql="{call adiBus(?,?,?,?)}";  
       CallableStatement st=cn.prepareCall(sql);
       st.setString(1,a.getMarca_bus());
       st.setString(2, a.getModelo_bus());
       st.setString(3, a.getPlaca_bus());
       st.setString(4, a.getId_chofer());
       st.executeUpdate();
     }catch(Exception ex){
         ex.printStackTrace();
     }
     }
   //MODIFICAR CHOFER
   public void cambiaBus(Buses a){
     Connection cn=MySQLConexion.getConexion();
     try{
       String sql="update buses set marcabus=?, modelo=?, placabus=?, idconductor=? where idbus=?";  
       PreparedStatement st=cn.prepareStatement(sql);
       st.setString(5, a.getId_buses());
       st.setString(1,a.getMarca_bus());
       st.setString(2, a.getModelo_bus());
       st.setString(3, a.getPlaca_bus());
       st.setString(4, a.getId_chofer());
       st.executeUpdate();
     }catch(Exception ex){
         ex.printStackTrace();
     }
     }
   //Eliminar chofer
   public void delBus(String id){
     Connection cn=MySQLConexion.getConexion();
     try{
       String sql="{call delBus(?)}";  
       CallableStatement st=cn.prepareCall(sql);
       st.setString(1, id);
       st.executeUpdate();
     }catch(Exception ex){
         ex.printStackTrace();
     }
     }
   public Buses busBus (String id) {
        Connection cn=MySQLConexion.getConexion();
        Buses p=null;
        try{
          String sql="select idBus,marcaBus,modelo,placaBus,idconductor from buses where idbus=?";
          PreparedStatement st=cn.prepareStatement(sql);
          st.setString(1, id);
          ResultSet rs=st.executeQuery();
          if(rs.next()){
              p=new Buses();
              p.setId_buses(id);
              p.setMarca_bus(rs.getString(2));
              p.setModelo_bus(rs.getString(3));
              p.setPlaca_bus(rs.getString(4));
              p.setId_chofer(rs.getString(5));
          }
        }catch(Exception ex){
            ex.printStackTrace();
        }finally{
            try{cn.close();}catch (Exception ex2){}
        }
        return p;
    }
      //CHOFER
      //LISTA DE CHOFERES
      
      public List<Choferes> lisChoferes(){
    List<Choferes> lis=new ArrayList();
    Connection cn=MySQLConexion.getConexion();
    try{
      String sql="select idconductor, nomconductor, docidentidad, telefono, correo from conductores";  
        PreparedStatement st=cn.prepareStatement(sql);
        ResultSet rs=st.executeQuery();
        while(rs.next()){//leer cada fila de la tabla
            Choferes p=new Choferes();
            p.setId_chofer(rs.getString(1));
            p.setNom_chofer(rs.getString(2));
            p.setDni(rs.getInt(3));
            p.setFono_chofer(rs.getInt(4));
            p.setMail_chofer(rs.getString(5));
            
            lis.add(p); //el objeto prestamo de un cliente pasar a la lista
        }
    }catch(Exception ex){
        ex.printStackTrace();
    }
       return lis;
   }
      //AÑADIR CHOFER
      public void adicionCho(Choferes a){
     Connection cn=MySQLConexion.getConexion();
     try{
       String sql="{call adiconductor(?,?,?,?)}";  
       CallableStatement st=cn.prepareCall(sql);
       st.setString(1,a.getNom_chofer());
       st.setInt(2, a.getDni());
       st.setInt(3, a.getFono_chofer());
       st.setString(4, a.getMail_chofer());
       st.executeUpdate();
     }catch(Exception ex){
         ex.printStackTrace();
     }
     }
   //MODIFICAR CHOFER
   public void cambiaCho(Choferes a){
     Connection cn=MySQLConexion.getConexion();
     try{
       String sql="update conductores set nomconductor=?, docidentidad=?, telefono=?, correo=? where idconductor=?";  
       PreparedStatement st=cn.prepareStatement(sql);
       st.setString(5, a.getId_chofer());
       st.setString(1,a.getNom_chofer());
       st.setInt(2, a.getDni());
       st.setInt(3, a.getFono_chofer());
       st.setString(4, a.getMail_chofer());
       st.executeUpdate();
     }catch(Exception ex){
         ex.printStackTrace();
     }
     }
   //Eliminar chofer
   public void delCho(String id){
     Connection cn=MySQLConexion.getConexion();
     try{
       String sql="{call delConductor(?)}";  
       CallableStatement st=cn.prepareCall(sql);
       st.setString(1, id);
       st.executeUpdate();
     }catch(Exception ex){
         ex.printStackTrace();
     }
     }
   public Choferes busChoferes (String id) {
        Connection cn=MySQLConexion.getConexion();
        Choferes p=null;
        try{
          String sql="select idconductor, nomconductor, docidentidad, telefono, correo from conductores where idconductor=?";
          PreparedStatement st=cn.prepareStatement(sql);
          st.setString(1, id);
          ResultSet rs=st.executeQuery();
          if(rs.next()){
              p=new Choferes();
              p.setId_chofer(id);
              p.setNom_chofer(rs.getString(2));
              p.setDni(rs.getInt(3));
              p.setFono_chofer(rs.getInt(4));
              p.setMail_chofer(rs.getString(5));
          }
        }catch(Exception ex){
            ex.printStackTrace();
        }finally{
            try{cn.close();}catch (Exception ex2){}
        }
        return p;
    }
      //LISTA DE HOTELES
      
      public List<Hoteles> lisHoteles(){
    List<Hoteles> lis=new ArrayList();
    Connection cn=MySQLConexion.getConexion();
    try{
      String sql="select idhotel,nomhotel,nestrellas,direccion,telefono,contacto from hoteles";  
        PreparedStatement st=cn.prepareStatement(sql);
        ResultSet rs=st.executeQuery();
        while(rs.next()){//leer cada fila de la tabla
            Hoteles p=new Hoteles();
            p.setId_hotel(rs.getString(1));
            p.setNom_hotel(rs.getString(2));
            p.setEstrellas(rs.getInt(3));
            p.setDirec_hotel(rs.getString(4));
            p.setFono_hotel(rs.getInt(5));
            p.setContacto(rs.getString(6));
            lis.add(p); //el objeto prestamo de un cliente pasar a la lista
        }
    }catch(Exception ex){
        ex.printStackTrace();
    }
       return lis;
   }
      //AÑADIR HOTEL
      public void adicionHotel(Hoteles a){
     Connection cn=MySQLConexion.getConexion();
     try{
       String sql="{call adiHotel(?,?,?,?,?)}";  
       CallableStatement st=cn.prepareCall(sql);
       st.setString(1,a.getNom_hotel());
       st.setInt(2, a.getEstrellas());
       st.setString(3, a.getDirec_hotel());
       st.setInt(4, a.getFono_hotel());
       st.setString(5, a.getContacto());
       st.executeUpdate();
     }catch(Exception ex){
         ex.printStackTrace();
     }
     }
   //MODIFICAR HOTEL
   public void cambiaHotel(Hoteles a){
     Connection cn=MySQLConexion.getConexion();
     try{
       String sql="update hoteles set nomhotel=?, nestrellas=?, direccion=?, telefono=?, contacto=? where idhotel=?";  
       PreparedStatement st=cn.prepareStatement(sql);
       st.setString(6, a.getId_hotel());
       st.setString(1,a.getNom_hotel());
       st.setInt(2, a.getEstrellas());
       st.setString(3, a.getDirec_hotel());
       st.setInt(4, a.getFono_hotel());
       st.setString(5, a.getContacto());
       st.executeUpdate();
     }catch(Exception ex){
         ex.printStackTrace();
     }
     }
   //Eliminar HOTEL
   public void delHotel(String id){
     Connection cn=MySQLConexion.getConexion();
     try{
       String sql="{call delHotel(?)}";  
       CallableStatement st=cn.prepareCall(sql);
       st.setString(1, id);
       st.executeUpdate();
     }catch(Exception ex){
         ex.printStackTrace();
     }
     }
   //BUSCAR HOTEL
   public Hoteles busHotel(String id) {
        Connection cn=MySQLConexion.getConexion();
        Hoteles p=null;
        try{
          String sql="select idhotel,nomhotel,nestrellas,direccion,telefono,contacto from hoteles where idhotel=?";
          PreparedStatement st=cn.prepareStatement(sql);
          st.setString(1, id);
          ResultSet rs=st.executeQuery();
          if(rs.next()){
              p=new Hoteles();
              p.setId_hotel(id);
              p.setNom_hotel(rs.getString(2));
              p.setEstrellas(rs.getInt(3));
              p.setDirec_hotel(rs.getString(4));
              p.setFono_hotel(rs.getInt(5));
              p.setContacto(rs.getString(6));
          }
        }catch(Exception ex){
            ex.printStackTrace();
        }finally{
            try{cn.close();}catch (Exception ex2){}
        }
        return p;
    }
      //LISTA DE DESTINOS
      
      public List<Destinos> lisDestinos(){
    List<Destinos> lis=new ArrayList();
    Connection cn=MySQLConexion.getConexion();
    try{
      String sql="select iddestino, destino, departamento, provincia from destinos";  
        PreparedStatement st=cn.prepareStatement(sql);
        ResultSet rs=st.executeQuery();
        while(rs.next()){//leer cada fila de la tabla
            Destinos p=new Destinos();
            p.setId_destino(rs.getString(1));
            p.setNom_destino(rs.getString(2));
            p.setDepart_destino(rs.getString(3));
            p.setProv_destino(rs.getString(4));
            lis.add(p); //el objeto prestamo de un cliente pasar a la lista
        }
    }catch(Exception ex){
        ex.printStackTrace();
    }
       return lis;
   }
      //AÑADIR DESTINO
      public void adicionDestino(Destinos a){
     Connection cn=MySQLConexion.getConexion();
     try{
       String sql="{call adiDestino(?,?,?)}";  
       CallableStatement st=cn.prepareCall(sql);
       st.setString(1,a.getNom_destino());
       st.setString(2, a.getDepart_destino());
       st.setString(3, a.getProv_destino());
       st.executeUpdate();
     }catch(Exception ex){
         ex.printStackTrace();
     }
     }
   //MODIFICAR DESTINO
   public void cambiaDest(Destinos a){
     Connection cn=MySQLConexion.getConexion();
     try{
       String sql="update destinos set destino=?, departamento=?, provincia=? where iddestino=?";  
       PreparedStatement st=cn.prepareStatement(sql);
       st.setString(4, a.getId_destino());
       st.setString(1,a.getNom_destino());
       st.setString(2, a.getDepart_destino());
       st.setString(3, a.getProv_destino());
       st.executeUpdate();
     }catch(Exception ex){
         ex.printStackTrace();
     }
     }
   //Eliminar DESTINO
   public void delDest(String id){
     Connection cn=MySQLConexion.getConexion();
     try{
       String sql="{call delDestino(?)}";  
       CallableStatement st=cn.prepareCall(sql);
       st.setString(1, id);
       st.executeUpdate();
     }catch(Exception ex){
         ex.printStackTrace();
     }
     }
   //BUSCAR DESTINO
   public Destinos busDestinos (String id) {
        Connection cn=MySQLConexion.getConexion();
        Destinos p=null;
        try{
          String sql="select iddestino, destino, departamento, provincia from destinos where iddestino=?";
          PreparedStatement st=cn.prepareStatement(sql);
          st.setString(1, id);
          ResultSet rs=st.executeQuery();
          if(rs.next()){
              p=new Destinos();
              p.setId_destino(id);
              p.setNom_destino(rs.getString(2));
              p.setDepart_destino(rs.getString(3));
              p.setProv_destino(rs.getString(4));
          }
        }catch(Exception ex){
            ex.printStackTrace();
        }finally{
            try{cn.close();}catch (Exception ex2){}
        }
        return p;
    }
      
      //LISTA DE GUIAS
      
      public List<Guias> lisGuias(){
    List<Guias> lis=new ArrayList();
    Connection cn=MySQLConexion.getConexion();
    try{
      String sql="select idguia,nomguia,docidentidad,telefono,correo,idioma from guias";  
        PreparedStatement st=cn.prepareStatement(sql);
        ResultSet rs=st.executeQuery();
        while(rs.next()){//leer cada fila de la tabla
            Guias p=new Guias();
            p.setId_guia(rs.getString(1));
            p.setNom_guia(rs.getString(2));
            p.setDni_guia(rs.getInt(3));
            p.setFono_guia(rs.getString(4));
            p.setMail_guia(rs.getString(5));
            p.setIdioma_guia(rs.getString(6));
            lis.add(p); //el objeto prestamo de un cliente pasar a la lista
        }
    }catch(Exception ex){
        ex.printStackTrace();
    }
       return lis;
   }
      //AÑADIR DESTINO
      public void adicionGuia(Guias a){
     Connection cn=MySQLConexion.getConexion();
     try{
       String sql="{call adiGuia(?,?,?,?,?)}";  
       CallableStatement st=cn.prepareCall(sql);
       st.setString(1,a.getNom_guia());
       st.setInt(2, a.getDni_guia());
       st.setString(3, a.getFono_guia());
       st.setString(4, a.getMail_guia());
       st.setString(5, a.getIdioma_guia());
       st.executeUpdate();
     }catch(Exception ex){
         ex.printStackTrace();
     }
     }
   //MODIFICAR DESTINO
   public void cambiaGuia(Guias a){
     Connection cn=MySQLConexion.getConexion();
     try{
       String sql="{call editGuia(?,?,?,?,?,?)}";  
       CallableStatement st=cn.prepareCall(sql);
       st.setString(1, a.getId_guia());
       st.setString(2,a.getNom_guia());
       st.setInt(3, a.getDni_guia());
       st.setString(4, a.getFono_guia());
       st.setString(5, a.getMail_guia());
       st.setString(6, a.getIdioma_guia());
       st.executeUpdate();
     }catch(Exception ex){
         ex.printStackTrace();
     }
     }
   //Eliminar DESTINO
   public void delGuia(String id){
     Connection cn=MySQLConexion.getConexion();
     try{
       String sql="{call delGuia(?)}";  
       CallableStatement st=cn.prepareCall(sql);
       st.setString(1, id);
       st.executeUpdate();
     }catch(Exception ex){
         ex.printStackTrace();
     }
     }
   //BUSCAR DESTINO
   public Guias busGuia (String id) {
        Connection cn=MySQLConexion.getConexion();
        Guias p=null;
        try{
          String sql="select idguia,nomguia,docidentidad,telefono,correo,idioma from guias where idguia=?";
          PreparedStatement st=cn.prepareStatement(sql);
          st.setString(1, id);
          ResultSet rs=st.executeQuery();
          if(rs.next()){
              p=new Guias();
              p.setId_guia(id);
              p.setNom_guia(rs.getString(2));
              p.setDni_guia(rs.getInt(3));
              p.setFono_guia(rs.getString(4));
              p.setMail_guia(rs.getString(5));
              p.setIdioma_guia(rs.getString(6));
          }
        }catch(Exception ex){
            ex.printStackTrace();
        }finally{
            try{cn.close();}catch (Exception ex2){}
        }
        return p;
    }
      
      //LISTA DE PAGO
      //FILTRO DE PAGO
      
    public String grabaFactura(String id_cli, List<FormaPago> lista) {
       String nfac="";
       Connection cn=MySQLConexion.getConexion();
       double sm=0;
       for(FormaPago x:lista) sm=sm;//+x.Total();
       try{
           String sql="{call spfactura(?,?)}";
           CallableStatement st=cn.prepareCall(sql);
           st.setString(1, id_cli);
           st.setDouble(2, sm);
           ResultSet rs=st.executeQuery();
           rs.next(); //leee el valor devuelto
           nfac=rs.getString(1);
           //grabacion del detalle
           sql="{call spdetalle=(?,?,?)}";
           CallableStatement st2=cn.prepareCall(sql);
           
           for(FormaPago c:lista){
               st2.setString(1, nfac);
               st2.setString(2, c.getDescrip());
             //()  st2.setInt(3, c.getCantidad());
               st2.executeUpdate();
           }
    }catch(Exception ex){
            ex.printStackTrace();
        }finally{
            try{cn.close();}catch (Exception ex2){}
        }
        return nfac;
    }
    //LISTA DE Formas de Pago
      
      public List<FormaPago> lisPago(){
    List<FormaPago> lis=new ArrayList();
    Connection cn=MySQLConexion.getConexion();
    try{
      String sql="select idfpago,descripcion from formapago";  
        PreparedStatement st=cn.prepareStatement(sql);
        ResultSet rs=st.executeQuery();
        while(rs.next()){//leer cada fila de la tabla
            FormaPago p=new FormaPago();
            p.setId_fp(rs.getString(1));
            p.setDescrip(rs.getString(2));
            lis.add(p); //el objeto prestamo de un cliente pasar a la lista
        }
    }catch(Exception ex){
        ex.printStackTrace();
    }
       return lis;
   }
      //RESUMEN DE LOS TOUR
      public List<Tours> lisResTours (){
    List<Tours> lis=new ArrayList();
    Connection cn=MySQLConexion.getConexion();
    try{
      String sql="SELECT t.idTour, t.descripcion,d.destino,g.nomGuia,t.tarifa,t.fechaInicio,t.fechaFin from tours t join destinos d "
              + "on d.idDestino=t.idDestino join guias g on g.idGuia=t.idGuia";  
        PreparedStatement st=cn.prepareStatement(sql);
        ResultSet rs=st.executeQuery();
        while(rs.next()){//leer cada fila de la tabla
            Tours p=new Tours();
            p.setTour_id(rs.getString(1));
            p.setDescrip_tour(rs.getString(2));
            p.setDestino(rs.getString(3));
            p.setGuia(rs.getString(4));
            p.setTarifa(rs.getDouble(5));
            p.setFecha_inicio(rs.getString(6));
            p.setFecha_fin(rs.getString(7));
            lis.add(p); //el objeto prestamo de un cliente pasar a la lista
        }
    }catch(Exception ex){
        ex.printStackTrace();
    }
       return lis;
   }   
      
   //Servicios
   //Lista de Servicios
   public List<Servicios> lisServ(){
    List<Servicios> lis=new ArrayList();
    Connection cn=MySQLConexion.getConexion();
    try{
      String sql="select idservicio,idtour,idcliente,idfpago from servicios";  
        PreparedStatement st=cn.prepareStatement(sql);
        ResultSet rs=st.executeQuery();
        while(rs.next()){//leer cada fila de la tabla
            Servicios p=new Servicios();
            p.setId_serv(rs.getString(1));
            p.setTour_id(rs.getString(2));
            p.setId_cli(rs.getString(3));
            p.setId_fp(rs.getString(4));
            lis.add(p); //el objeto prestamo de un cliente pasar a la lista
        }
    }catch(Exception ex){
        ex.printStackTrace();
    }
       return lis;
   }
   //buscar Servicios
   public Servicios busServicio (String id) {
        Connection cn=MySQLConexion.getConexion();
        Servicios p=null;
        try{
          String sql="select idservicio,idtour,idcliente,idfpago from servicios where idservicio=?";
          PreparedStatement st=cn.prepareStatement(sql);
          st.setString(1, id);
          ResultSet rs=st.executeQuery();
          if(rs.next()){
              p=new Servicios();
              p.setId_serv(id);
              p.setTour_id(rs.getString(2));
              p.setId_cli(rs.getString(3));
              p.setId_fp(rs.getString(4));
          }
        }catch(Exception ex){
            ex.printStackTrace();
        }finally{
            try{cn.close();}catch (Exception ex2){}
        }
        return p;
    }
   //Adicionar Servicios
   public void adicionServicio(Servicios a){
     Connection cn=MySQLConexion.getConexion();
     try{
       String sql="{call adiServicio(?,?,?)}";  
       CallableStatement st=cn.prepareCall(sql);
       st.setString(1, a.getTour_id());
       st.setString(2, a.getId_cli());
       st.setString(3, a.getId_fp());
       st.executeUpdate();
     }catch(Exception ex){
         ex.printStackTrace();
     }
     }
   //Eliminar Servicios
   public void delServicio(String id){
     Connection cn=MySQLConexion.getConexion();
     try{
       String sql="delete from servicios where idservicio=?";  
       CallableStatement st=cn.prepareCall(sql);
       st.setString(1, id);
       st.executeUpdate();
     }catch(Exception ex){
         ex.printStackTrace();
     }
     }
   //Modificar Servicios
   public void cambiaServicio(Servicios a){
     Connection cn=MySQLConexion.getConexion();
     try{
       String sql="update servicios set idtour=?, idcliente=?, idfpago=? where idservicio=?";  
       PreparedStatement st=cn.prepareStatement(sql);
       st.setString(4, a.getId_serv());
       st.setString(1,a.getTour_id());
       st.setString(2, a.getId_cli());
       st.setString(3, a.getId_fp());
       st.executeUpdate();
     }catch(Exception ex){
         ex.printStackTrace();
     }
     }
   //Adicion Tours
   public void adicionTours(Tours a){
     Connection cn=MySQLConexion.getConexion();
     try{
       String sql="{call adiTours(?,?,?,?,?,?,?,?)}";  
       CallableStatement st=cn.prepareCall(sql);
       st.setString(1,a.getDescrip_tour());
       st.setString(2, a.getId_destino());
       st.setString(3, a.getId_buses());
       st.setString(4, a.getId_guia());
       st.setString(5, a.getId_hotel());
       st.setDouble(6, a.getTarifa());
       st.setString(7, a.getFecha_inicio());
       st.setString(8, a.getFecha_fin());
       st.executeUpdate();
     }catch(Exception ex){
         ex.printStackTrace();
     }
     }
   //Buscar Tours
  //BUSCAR Tour
   public Tours busTour(String id) {
        Connection cn=MySQLConexion.getConexion();
        Tours p=null;
        try{
          String sql="select idtour, descripcion, iddestino, idbus, idGuia, idhotel, tarifa, fechainicio, fechafin from tours where idtour=?";
          PreparedStatement st=cn.prepareStatement(sql);
          st.setString(1, id);
          ResultSet rs=st.executeQuery();
          if(rs.next()){
              p=new Tours();
              p.setTour_id(id);
              p.setDescrip_tour(rs.getString(2));
              p.setId_destino(rs.getString(3));
              p.setId_buses(rs.getString(4));
              p.setId_guia(rs.getString(5));
              p.setId_hotel(rs.getString(6));
              p.setTarifa(rs.getDouble(7));
              p.setFecha_inicio(rs.getString(8));
              p.setFecha_fin(rs.getString(9));
          }
        }catch(Exception ex){
            ex.printStackTrace();
        }finally{
            try{cn.close();}catch (Exception ex2){}
        }
        return p;
    }
   //Modificar Tours
   public void cambiaTours(Tours a){
     Connection cn=MySQLConexion.getConexion();
     try{
       String sql="{call editTour(?,?,?,?,?,?,?,?,?)}";  
       PreparedStatement st=cn.prepareStatement(sql);
       st.setString(1, a.getTour_id());
       st.setString(2,a.getDescrip_tour());
       st.setString(3, a.getId_destino());
       st.setString(4, a.getId_buses());
       st.setString(5, a.getId_guia());
       st.setString(6, a.getId_hotel());
       st.setDouble(7, a.getTarifa());
       st.setString(8, a.getFecha_inicio());
       st.setString(9, a.getFecha_fin());
       st.executeUpdate();
     }catch(Exception ex){
         ex.printStackTrace();
     }
     }
   //Eliminar Tours
   public void delTour(String id){
     Connection cn=MySQLConexion.getConexion();
     try{
       String sql="delete from tours where idtour=?";  
       CallableStatement st=cn.prepareCall(sql);
       st.setString(1, id);
       st.executeUpdate();
     }catch(Exception ex){
         ex.printStackTrace();
     }
     }
   //Adicion Usuario
   public void adicionUsuario(Usuarios a){
     Connection cn=MySQLConexion.getConexion();
     try{
       String sql="{call adiUsuario(?,?,?,?,?,?,?)}";  
       CallableStatement st=cn.prepareCall(sql);
       st.setString(1,a.getNom_us());
       st.setString(2, a.getApe_us());
       st.setInt(3, a.getDni_us());
       st.setString(4, a.getFono_us());
       st.setString(5, a.getMail_us());
       st.setString(6, a.getFecha());
       st.setString(7, a.getPws_us());
       st.executeUpdate();
     }catch(Exception ex){
         ex.printStackTrace();
     }
     }

  //BUSCAR Usuario
   public Usuarios busUsuario(String id) {
        Connection cn=MySQLConexion.getConexion();
        Usuarios p=null;
        try{
          String sql="select idusuario, nomusuario, apeusuario, docidentidad, telefono, correo, fecnacimiento, password from usuarios where idusuario=?";
          PreparedStatement st=cn.prepareStatement(sql);
          st.setString(1, id);
          ResultSet rs=st.executeQuery();
          if(rs.next()){
              p=new Usuarios();
              p.setId_us(id);
              p.setNom_us(rs.getString(2));
              p.setApe_us(rs.getString(3));
              p.setDni_us(rs.getInt(4));
              p.setFono_us(rs.getString(5));
              p.setMail_us(rs.getString(6));
              p.setFecha(rs.getString(7));
              p.setPws_us(rs.getString(8));
          }
        }catch(Exception ex){
            ex.printStackTrace();
        }finally{
            try{cn.close();}catch (Exception ex2){}
        }
        return p;
    }
   //Modificar Usuario
   public void cambiaUsuario(Usuarios a){
     Connection cn=MySQLConexion.getConexion();
     try{
       String sql="update usuarios set nomusuario=?, apeusuario=?, docidentidad=?, telefono=?, correo=?,fecnacimiento=?,password=? where idusuario=?";  
       PreparedStatement st=cn.prepareStatement(sql);
       st.setString(8, a.getId_us());
       st.setString(1,a.getNom_us());
       st.setString(2, a.getApe_us());
       st.setInt(3, a.getDni_us());
       st.setString(4, a.getFono_us());
       st.setString(5, a.getMail_us());
       st.setString(6, a.getFecha());
       st.setString(7, a.getPws_us());
       st.executeUpdate();
     }catch(Exception ex){
         ex.printStackTrace();
     }
     }
   //Eliminar Usuario
   public void delUsuario(String id){
     Connection cn=MySQLConexion.getConexion();
     try{
       String sql="delete from usuarios where idusuario=?";  
       CallableStatement st=cn.prepareCall(sql);
       st.setString(1, id);
       st.executeUpdate();
     }catch(Exception ex){
         ex.printStackTrace();
     }
     }
   //login
   public Clientes busCliente(String usr, String pwd) {
   Connection cn=MySQLConexion.getConexion();
     Clientes p=null;
     try{
     String sql="Select idcliente,Apecliente, nomcliente from clientes where correo=? and Password=?";
     PreparedStatement st=cn.prepareStatement(sql);
     st.setString(1, usr);
     st.setString(2, pwd);
     ResultSet rs=st.executeQuery();
     if(rs.next()){
         p=new Clientes();
         p.setMail_cli(usr);
         p.setId_cli(rs.getString(1));
         p.setApe_cli(rs.getString(2));
         p.setNom_clie(rs.getString(3));
       }
     }catch(Exception ex){
      ex.printStackTrace();
     }finally{
         try{ cn.close();}catch(Exception ex2){}
     }
     return p;
    }
   public Clientes busClienteLog(String id) {
   Connection cn=MySQLConexion.getConexion();
     Clientes p=null;
     try{
     String sql="Select idcliente,Apecliente, nomcliente from clientes where idcliente=?";
     PreparedStatement st=cn.prepareStatement(sql);
     st.setString(1, id);
     ResultSet rs=st.executeQuery();
     if(rs.next()){
         p=new Clientes();
         p.setId_cli(id);
         //p.setId_cli(rs.getString(1));
         p.setApe_cli(rs.getString(2));
         p.setNom_clie(rs.getString(3));
       }
     }catch(Exception ex){
      ex.printStackTrace();
     }finally{
         try{ cn.close();}catch(Exception ex2){}
     }
     return p;
    }
   //BUSCAR Tour
   public Tours busTourCli(String id) {
        Connection cn=MySQLConexion.getConexion();
        Tours p=null;
        try{
          String sql="SELECT t.idTour,t.descripcion,t.idDestino,t.idBus,t.idGuia,t.idHotel,t.tarifa,t.fechaInicio,t.fechaFin,d.destino,b.placaBus,g.nomGuia FROM "
                  + "tours t JOIN destinos d on d.idDestino=t.idDestino join buses b on b.idBus=t.idBus join guias g on g.idGuia=t.idGuia where idtour=?";
          PreparedStatement st=cn.prepareStatement(sql);
          st.setString(1, id);
          ResultSet rs=st.executeQuery();
          if(rs.next()){
              p=new Tours();
              p.setTour_id(id);
              p.setDescrip_tour(rs.getString(2));
              p.setId_destino(rs.getString(3));
              p.setId_buses(rs.getString(4));
              p.setId_guia(rs.getString(5));
              p.setId_hotel(rs.getString(6));
              p.setTarifa(rs.getDouble(7));
              p.setFecha_inicio(rs.getString(8));
              p.setFecha_fin(rs.getString(9));
              p.setDestino(rs.getString(10));
              p.setPlaca(rs.getString(11));
              p.setGuia(rs.getString(12));
          }
        }catch(Exception ex){
            ex.printStackTrace();
        }finally{
            try{cn.close();}catch (Exception ex2){}
        }
        return p;
    }
   public List<Tours> busTourxCli(String id) {
       List<Tours> lis=new ArrayList();
        Connection cn=MySQLConexion.getConexion();
        try{
          String sql="SELECT t.idTour,t.descripcion,t.idDestino,t.idBus,t.idGuia,t.idHotel,t.tarifa,t.fechaInicio,t.fechaFin,d.destino,b.placaBus,g.nomGuia FROM "
                  + "tours t JOIN destinos d on d.idDestino=t.idDestino join buses b on b.idBus=t.idBus join guias g on g.idGuia=t.idGuia join servicios s on s.idTour=t.idTour "
                  + "join clientes c on c.idCliente=s.idCliente where c.idCliente=?";
          PreparedStatement st=cn.prepareStatement(sql);
          st.setString(1, id);
          ResultSet rs=st.executeQuery();
          while(rs.next()){
              Tours p=new Tours();
              p.setId_cli(id);
              p.setTour_id(rs.getString(1));
              p.setDescrip_tour(rs.getString(2));
              p.setId_destino(rs.getString(3));
              p.setId_buses(rs.getString(4));
              p.setId_guia(rs.getString(5));
              p.setId_hotel(rs.getString(6));
              p.setTarifa(rs.getDouble(7));
              p.setFecha_inicio(rs.getString(8));
              p.setFecha_fin(rs.getString(9));
              p.setDestino(rs.getString(10));
              p.setPlaca(rs.getString(11));
              p.setGuia(rs.getString(12));
              lis.add(p);
          }
        }catch(Exception ex){
            ex.printStackTrace();
        }finally{
            try{cn.close();}catch (Exception ex2){}
        }
        return lis;
    }
   //buscar tour x cliente
   public Tours busTourxCliente(String id) {
        Connection cn=MySQLConexion.getConexion();
        Tours p=null;
        try{
          String sql="SELECT t.idTour,t.descripcion,d.destino,g.idGuia,t.tarifa,t.fechaInicio,t.fechaFin FROM tours t join servicios s on t.idTour=s.idTour join "
                  + "clientes c on c.idCliente=s.idCliente join destinos d on d.idDestino=t.idDestino JOIN guias g on g.idGuia=t.idGuia where c.idCliente=?";
          PreparedStatement st=cn.prepareStatement(sql);
          st.setString(1, id);
          ResultSet rs=st.executeQuery();
          if(rs.next()){
              p=new Tours();
              p.setId_cli(id);
              p.setTour_id(rs.getString(1));
              p.setDescrip_tour(rs.getString(2));
              p.setDestino(rs.getString(3));
              p.setGuia(rs.getString(4));
              p.setTarifa(rs.getDouble(5));
              p.setFecha_inicio(rs.getString(6));
              p.setFecha_fin(rs.getString(7));
          }
        }catch(Exception ex){
            ex.printStackTrace();
        }finally{
            try{cn.close();}catch (Exception ex2){}
        }
        return p;
    }

    public Object filtra(String cod) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
