package modelo;
public class Tours {
    private String tour_id;
    private String descrip_tour;
    private String id_destino;
    private String id_buses;
    private String id_guia;
    private String id_hotel;
    private double tarifa;
    private String fecha_inicio;
    private String fecha_fin;
    private String destino;
    private String Guia;
    private String placa;
    private String id_cli;
    
    
    public Tours(){
        
    }
    
    public Tours (String tour_id, String descrip_tour,String id_destino,String id_buses,String id_guia,String id_hotel,double tarifa,String fecha_inicio,String fecha_fin){
        this.descrip_tour=descrip_tour;
        this.id_destino=id_destino;
        this.id_buses=id_buses;
        this.id_guia=id_guia;
        this.id_hotel=id_hotel;
        this.tarifa=tarifa;
        this.fecha_inicio=fecha_inicio;
        this.fecha_fin=fecha_fin;
        this.tour_id=tour_id;
    }

    public String getDescrip_tour() {
        return descrip_tour;
    }

    public void setDescrip_tour(String descrip_tour) {
        this.descrip_tour = descrip_tour;
    }

    public double getTarifa() {
        return tarifa;
    }

    public void setTarifa(double tarifa) {
        this.tarifa = tarifa;
    }

    public String getFecha_inicio() {
        return fecha_inicio;
    }

    public void setFecha_inicio(String fecha_inicio) {
        this.fecha_inicio = fecha_inicio;
    }

    public String getFecha_fin() {
        return fecha_fin;
    }

    public void setFecha_fin(String fecha_fin) {
        this.fecha_fin = fecha_fin;
    }

    public String getTour_id() {
        return tour_id;
    }

    public void setTour_id(String tour_id) {
        this.tour_id = tour_id;
    }

    public String getId_destino() {
        return id_destino;
    }

    public void setId_destino(String id_destino) {
        this.id_destino = id_destino;
    }

    public String getId_buses() {
        return id_buses;
    }

    public void setId_buses(String id_buses) {
        this.id_buses = id_buses;
    }

    public String getId_guia() {
        return id_guia;
    }

    public void setId_guia(String id_guia) {
        this.id_guia = id_guia;
    }

    public String getId_hotel() {
        return id_hotel;
    }

    public void setId_hotel(String id_hotel) {
        this.id_hotel = id_hotel;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public String getGuia() {
        return Guia;
    }

    public void setGuia(String Guia) {
        this.Guia = Guia;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getId_cli() {
        return id_cli;
    }

    public void setId_cli(String id_cli) {
        this.id_cli = id_cli;
    }
}
