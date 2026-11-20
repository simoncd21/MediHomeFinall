public abstract class Persona {

    private final String documento;
    private final String nombre;
    private final String apellido;
    private final String telefono;
    private final String correoElectronico;

    protected Persona(String documento, String nombre, String apellido,
                      String telefono, String correoElectronico) {
        this.documento = documento;
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.correoElectronico = correoElectronico;
    }

    public String getNombreCompleto() {
        return nombre + " " + apellido;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }
}
