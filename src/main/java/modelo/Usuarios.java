
package modelo;
public class Usuarios {
    private String id_us;
    private String nom_us;
    private String ape_us;
    private int dni_us;
    private String fono_us;
    private String mail_us;
    private String fecha;
    private String pws_us;
    
    public Usuarios(){
        
    }
    
    public Usuarios (String id_us,String nom_us, String ape_us, int dni_us, String fono_us,String mail_us, String fecha, String pws_us){
     this.id_us=id_us;
     this.nom_us=nom_us;
     this.dni_us=dni_us;
     this.fono_us=fono_us;
     this.ape_us=ape_us;
     this.mail_us=mail_us;
     this.fecha=fecha;
     this.pws_us=pws_us;
 }


    public String getNom_us() {
        return nom_us;
    }

    public void setNom_us(String nom_us) {
        this.nom_us = nom_us;
    }

    public String getApe_us() {
        return ape_us;
    }

    public void setApe_us(String ape_us) {
        this.ape_us = ape_us;
    }

    public int getDni_us() {
        return dni_us;
    }

    public void setDni_us(int dni_us) {
        this.dni_us = dni_us;
    }

    public String getFono_us() {
        return fono_us;
    }

    public void setFono_us(String fono_us) {
        this.fono_us = fono_us;
    }

    public String getMail_us() {
        return mail_us;
    }

    public void setMail_us(String mail_us) {
        this.mail_us = mail_us;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getPws_us() {
        return pws_us;
    }

    public void setPws_us(String pws_us) {
        this.pws_us = pws_us;
    }

    public String getId_us() {
        return id_us;
    }

    public void setId_us(String id_us) {
        this.id_us = id_us;
    }
    
    
}
