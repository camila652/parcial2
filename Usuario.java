public class Usuario{   
    private String nombre;
    private String apellido;
    private String cedula;
    private String tipoCredito;
    private double montoCredito;

    public Usuario(String nombre, String apellido, String cedula, String tipoCredito, double montoCredito) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.cedula = cedula;
        this.tipoCredito = tipoCredito;
        this.montoCredito = montoCredito;
    }                   

    public String getNombre() {
        return this.nombre;
    }           
    public String getApellido() {
        return this.apellido;
    }           
    public String getCedula() {
        return this.cedula;
    }           
    public String getTipoCredito() {
        return this.tipoCredito;
    }           
    public double getMontoCredito() {
        return this.montoCredito;
    }       

    public void setMontoCredito(double montoCredito) {
        this.montoCredito = montoCredito;
    }   
    
    public void setTipoCredito(String tipoCredito) {
        this.tipoCredito = tipoCredito;
    }   

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }   

    public void setNombre(String nombre) {          
        this.nombre = nombre;
    }

    public void setCedula(String cedula) {          
        this.cedula = cedula;
    }

    public String toString() {
        return "Usuario{" + "nombre=" + this.nombre + ", apellido=" + this.apellido + ", cedula=" + this.cedula + ", tipoCredito=" + this.tipoCredito + ", montoCredito=" + this.montoCredito + '}';
    }
    




    
}
