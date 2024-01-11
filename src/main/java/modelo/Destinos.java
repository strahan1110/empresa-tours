
package modelo;
public class Destinos {
    private String id_destino;
    private String nom_destino;
    private String depart_destino;
    private String prov_destino;
    
    public Destinos(){
        
    }
    
    public Destinos(String id_destino, String nom_destino, String depart_destino, String prov_destino){
        this.nom_destino=nom_destino;
        this.depart_destino=depart_destino;
        this.prov_destino=prov_destino;
        this.id_destino=id_destino;
    }

    public String getNom_destino() {
        return nom_destino;
    }

    public void setNom_destino(String nom_destino) {
        this.nom_destino = nom_destino;
    }

    public String getDepart_destino() {
        return depart_destino;
    }

    public void setDepart_destino(String depart_destino) {
        this.depart_destino = depart_destino;
    }

    public String getProv_destino() {
        return prov_destino;
    }

    public void setProv_destino(String prov_destino) {
        this.prov_destino = prov_destino;
    }

    public String getId_destino() {
        return id_destino;
    }

    public void setId_destino(String id_destino) {
        this.id_destino = id_destino;
    }
    
}
