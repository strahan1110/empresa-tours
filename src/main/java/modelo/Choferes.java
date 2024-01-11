
package modelo;
public class Choferes {
    private String id_chofer;
    private String nom_chofer;
    private int dni;
    private int fono_chofer;
    private String mail_chofer;
    
    public Choferes(){
        
    }
    public Choferes(String id_chofer, String nom_chofer,int dni, int fono_chofer, String mail_chofer){
        this.nom_chofer=nom_chofer;
        this.dni=dni;
        this.fono_chofer=fono_chofer;
        this.mail_chofer=mail_chofer;
        this.id_chofer=id_chofer;
    }

    public String getNom_chofer() {
        return nom_chofer;
    }

    public void setNom_chofer(String nom_chofer) {
        this.nom_chofer = nom_chofer;
    }

    public int getFono_chofer() {
        return fono_chofer;
    }

    public void setFono_chofer(int fono_chofer) {
        this.fono_chofer = fono_chofer;
    }

    public String getMail_chofer() {
        return mail_chofer;
    }

    public void setMail_chofer(String mail_chofer) {
        this.mail_chofer = mail_chofer;
    }

    public String getId_chofer() {
        return id_chofer;
    }

    public void setId_chofer(String id_chofer) {
        this.id_chofer = id_chofer;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }
    
    
    
}
