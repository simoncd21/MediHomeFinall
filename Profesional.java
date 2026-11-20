import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;


public class Profesional extends Persona {

    private final String especialidad;
    private final String registroProfesional;
    private final List<Atencion> atenciones = new ArrayList<>();

    public Profesional(String documento, String nombre, String apellido,
                       String telefono, String correoElectronico,
                       String especialidad, String registroProfesional) {
        super(documento, nombre, apellido, telefono, correoElectronico);
        this.especialidad = especialidad;
        this.registroProfesional = registroProfesional;
    }


    public void registrarSignosVitales(Atencion atencion, MedicionDeSignosVitales medicion) {
        Objects.requireNonNull(atencion, "La atención no puede ser nula");
        atencion.agregarMedicion(medicion);
    }

    public List<Atencion> consultarAtenciones() {
        return Collections.unmodifiableList(atenciones);
    }

    /** Lo llama Atencion al crearse para quedar asociada a este profesional. */
    void agregarAtencion(Atencion atencion) {
        atenciones.add(atencion);
    }
}
