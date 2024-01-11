package modelo;
public class Clientes {
    private String id_cli;
    private String nom_clie;
    private String ape_cli;
    private int dni_cli;
    private String direc_cli;
    private String fono_cli;
    private String mail_cli;
    private String password;
    private String nacionalidad;
    
    public Clientes (String id_cli, String nom_clie, String ape_cli, int dni_cli, String direc_cli, String fono_cli, String mail_cli,String password, String nacionalidad){
        this.id_cli=id_cli;
        this.nom_clie=nom_clie;
        this.ape_cli=ape_cli;
        this.dni_cli=dni_cli;
        this.direc_cli=direc_cli;
        this.fono_cli=fono_cli;
        this.mail_cli=mail_cli;
        this.password=password;
        this.nacionalidad=nacionalidad;
    }

    public Clientes() {
    }

    public String getNom_clie() {
        return nom_clie;
    }

    public void setNom_clie(String nom_clie) {
        this.nom_clie = nom_clie;
    }

    public String getApe_cli() {
        return ape_cli;
    }

    public void setApe_cli(String ape_cli) {
        this.ape_cli = ape_cli;
    }

    public int getDni_cli() {
        return dni_cli;
    }

    public void setDni_cli(int dni_cli) {
        this.dni_cli = dni_cli;
    }

    public String getDirec_cli() {
        return direc_cli;
    }

    public void setDirec_cli(String direc_cli) {
        this.direc_cli = direc_cli;
    }

    public String getFono_cli() {
        return fono_cli;
    }

    public void setFono_cli(String fono_cli) {
        this.fono_cli = fono_cli;
    }

    public String getMail_cli() {
        return mail_cli;
    }

    public void setMail_cli(String mail_cli) {
        this.mail_cli = mail_cli;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public String getId_cli() {
        return id_cli;
    }

    public void setId_cli(String id_cli) {
        this.id_cli = id_cli;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    
           
}
