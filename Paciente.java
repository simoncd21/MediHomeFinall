import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;


public class Paciente extends Persona {

    private final LocalDate fechaNacimiento;
    private final String direccionDomicilio;
    private final List<ServicioDomiciliario> serviciosSolicitados = new ArrayList<>();
    private final List<Atencion> atenciones = new ArrayList<>();

    public Paciente(String documento, String nombre, String apellido,
                    String telefono, String correoElectronico,
                    LocalDate fechaNacimiento, String direccionDomicilio) {
        super(documento, nombre, apellido, telefono, correoElectronico);
        this.fechaNacimiento = fechaNacimiento;
        this.direccionDomicilio = direccionDomicilio;
    }

    public void solicitarServicio(ServicioDomiciliario servicio) {
        Objects.requireNonNull(servicio, "El servicio no puede ser nulo");
        serviciosSolicitados.add(servicio);
    }

    public List<Atencion> consultarAtenciones() {
        return Collections.unmodifiableList(atenciones);
    }

    void agregarAtencion(Atencion atencion) {
        atenciones.add(atencion);
    }
}
