
package modelo;

public class Buses {
    private String id_buses;
    private String marca_bus;
    private String modelo_bus;
    private String placa_bus;
    private String id_chofer;
    private String nom_chofer;
    
    public Buses(){
        
    }
    
    public Buses(String id_buses, String marca_bus, String modelo_bus, String placa_bus,String id_chofer){
        this.marca_bus=marca_bus;
        this.modelo_bus=modelo_bus;
        this.placa_bus=placa_bus;
        this.id_chofer=id_chofer;
        this.id_buses=id_buses;
    }

    public String getMarca_bus() {
        return marca_bus;
    }

    public void setMarca_bus(String marca_bus) {
        this.marca_bus = marca_bus;
    }

    public String getModelo_bus() {
        return modelo_bus;
    }

    public void setModelo_bus(String modelo_bus) {
        this.modelo_bus = modelo_bus;
    }

    public String getPlaca_bus() {
        return placa_bus;
    }

    public void setPlaca_bus(String placa_bus) {
        this.placa_bus = placa_bus;
    }

    

    public String getId_buses() {
        return id_buses;
    }

    public void setId_buses(String id_buses) {
        this.id_buses = id_buses;
    }

    public String getId_chofer() {
        return id_chofer;
    }

    public void setId_chofer(String id_chofer) {
        this.id_chofer = id_chofer;
    }

    public String getNom_chofer() {
        return nom_chofer;
    }

    public void setNom_chofer(String nom_chofer) {
        this.nom_chofer = nom_chofer;
    }
    
    
}
