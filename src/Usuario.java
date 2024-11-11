abstract class Usuario {
    protected String nombre;
    protected String apellido;
    protected AlquilerCanchita alquilerCanchita;

    public String getApellido() {
        return apellido;
    }

    public String getNombre(){
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public AlquilerCanchita getAlquilerCanchita() {
        return alquilerCanchita;
    }

    public void setAlquilerCanchita(AlquilerCanchita alquilerCanchita) {
        this.alquilerCanchita = alquilerCanchita;
    }
}
