
package modelo;

public class FormaPago {
    private String id_fp;
    private String descrip;
    
    public FormaPago(){
        
    }
    
    public FormaPago(String id_fp, String descrip){
        this.id_fp=id_fp;
        this.descrip=descrip;
    }

  
    public String getDescrip() {
        return descrip;
    }

    public void setDescrip(String descrip) {
        this.descrip = descrip;
    }

    public String getId_fp() {
        return id_fp;
    }

    public void setId_fp(String id_fp) {
        this.id_fp = id_fp;
    }
    
}
