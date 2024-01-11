
package modelo;

public class Servicios {
    private String id_serv;
    private String tour_id;
    private String id_cli;
    private String id_fp;
    private String descripcion;
    private String nomcli;
    private String apecli;
    private String formpago;
    private String placa;
    private String fechaini;
    private String fechafin;
    private String guia;
    private String descrip;
    
    public Servicios(){
}
    
     public Servicios(String tour_id,String id_cli,String id_fp ){
        this.tour_id=tour_id;
        this.id_cli=id_cli;
        this.id_fp=id_fp;
}

    public String getId_serv() {
        return id_serv;
    }

    public void setId_serv(String id_serv) {
        this.id_serv = id_serv;
    }

    public String getTour_id() {
        return tour_id;
    }

    public void setTour_id(String tour_id) {
        this.tour_id = tour_id;
    }

    public String getId_cli() {
        return id_cli;
    }

    public void setId_cli(String id_cli) {
        this.id_cli = id_cli;
    }

    public String getId_fp() {
        return id_fp;
    }

    public void setId_fp(String id_fp) {
        this.id_fp = id_fp;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getNomcli() {
        return nomcli;
    }

    public void setNomcli(String nomcli) {
        this.nomcli = nomcli;
    }

    public String getApecli() {
        return apecli;
    }

    public void setApecli(String apecli) {
        this.apecli = apecli;
    }

    public String getFormpago() {
        return formpago;
    }

    public void setFormpago(String formpago) {
        this.formpago = formpago;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getFechaini() {
        return fechaini;
    }

    public void setFechaini(String fechaini) {
        this.fechaini = fechaini;
    }

    public String getFechafin() {
        return fechafin;
    }

    public void setFechafin(String fechafin) {
        this.fechafin = fechafin;
    }

    public String getGuia() {
        return guia;
    }

    public void setGuia(String guia) {
        this.guia = guia;
    }

    public String getDescrip() {
        return descrip;
    }

    public void setDescrip(String descrip) {
        this.descrip = descrip;
    }

  

     
   
}
