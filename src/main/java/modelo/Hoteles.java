
package modelo;

public class Hoteles {
    private String id_hotel;
    private String nom_hotel;
    private int estrellas;
    private String contacto;
    private String direc_hotel;
    private int fono_hotel;
    public Hoteles(){
        
    }
    
    public Hoteles (String id_hotel, String nom_hotel, int estrellas, String contacto, String direc_hotel, int fono_hotel){
        this.nom_hotel=nom_hotel;
        this.estrellas=estrellas;
        this.contacto=contacto;
        this.direc_hotel=direc_hotel;
        this.fono_hotel=fono_hotel;
        this.id_hotel=id_hotel;
    }

    public String getNom_hotel() {
        return nom_hotel;
    }

    public void setNom_hotel(String nom_hotel) {
        this.nom_hotel = nom_hotel;
    }

    public int getEstrellas() {
        return estrellas;
    }

    public void setEstrellas(int estrellas) {
        this.estrellas = estrellas;
    }

    public String getContacto() {
        return contacto;
    }

    public void setContacto(String contacto) {
        this.contacto = contacto;
    }

    public String getDirec_hotel() {
        return direc_hotel;
    }

    public void setDirec_hotel(String direc_hotel) {
        this.direc_hotel = direc_hotel;
    }

    public int getFono_hotel() {
        return fono_hotel;
    }

    public void setFono_hotel(int fono_hotel) {
        this.fono_hotel = fono_hotel;
    }

    public String getId_hotel() {
        return id_hotel;
    }

    public void setId_hotel(String id_hotel) {
        this.id_hotel = id_hotel;
    }
    
    
}
