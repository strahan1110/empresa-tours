
package modelo;
public class Guias {
    private String id_guia;
    private String nom_guia;
    private int dni_guia;
    private String mail_guia;
    private String fono_guia;
    private String idioma_guia;
    
    public Guias(){
        
    }
    
    public Guias(String id_guia, String nom_guia, int dni_guia, String mail_guia, String fono_guia, String idioma_guia){
      this.nom_guia=nom_guia;
      this.dni_guia=dni_guia;
      this.mail_guia=mail_guia;
      this.fono_guia=fono_guia;
      this.idioma_guia=idioma_guia;
      this.id_guia=id_guia;
    }


    public String getNom_guia() {
        return nom_guia;
    }

    public void setNom_guia(String nom_guia) {
        this.nom_guia = nom_guia;
    }

    public int getDni_guia() {
        return dni_guia;
    }

    public void setDni_guia(int dni_guia) {
        this.dni_guia = dni_guia;
    }

    public String getMail_guia() {
        return mail_guia;
    }

    public void setMail_guia(String mail_guia) {
        this.mail_guia = mail_guia;
    }

    public String getFono_guia() {
        return fono_guia;
    }

    public void setFono_guia(String fono_guia) {
        this.fono_guia = fono_guia;
    }

    public String getIdioma_guia() {
        return idioma_guia;
    }

    public void setIdioma_guia(String idioma_guia) {
        this.idioma_guia = idioma_guia;
    }

    public String getId_guia() {
        return id_guia;
    }

    public void setId_guia(String id_guia) {
        this.id_guia = id_guia;
    }
    
}
