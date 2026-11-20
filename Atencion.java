import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Objects;


public final class Atencion {

    private static final DateTimeFormatter FORMATO = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

    private final Paciente paciente;
    private final Profesional profesional;
    private final ServicioDomiciliario servicio;
    private final LocalDateTime fechaHora;
    private final String motivo;
    private final String observaciones;
    private final List<MedicionDeSignosVitales> mediciones = new ArrayList<>();
    private EstadoAtencion estado;

    public Atencion(Paciente paciente, Profesional profesional, ServicioDomiciliario servicio,
                    LocalDateTime fechaHora, String motivo, String observaciones) {
        this.paciente = Objects.requireNonNull(paciente, "El paciente no puede ser nulo");
        this.profesional = Objects.requireNonNull(profesional, "El profesional no puede ser nulo");
        this.servicio = Objects.requireNonNull(servicio, "El servicio no puede ser nulo");
        this.fechaHora = Objects.requireNonNull(fechaHora, "La fecha y hora no pueden ser nulas");
        this.motivo = motivo;
        this.observaciones = observaciones;
        paciente.agregarAtencion(this);
        profesional.agregarAtencion(this);
    }

    public void programar(Notificacion notificacion) {
        estado = EstadoAtencion.PROGRAMADA;
        notificacion.enviar(paciente, "Se programó su atención de "
                + nombreServicio() + " con " + profesional.getNombreCompleto()
                + " para el " + fechaHora.format(FORMATO) + ".");
    }

    public void cancelar(Notificacion notificacion) {
        estado = EstadoAtencion.CANCELADA;
        notificacion.enviar(paciente, "Se canceló su atención de "
                + nombreServicio() + " con " + profesional.getNombreCompleto()
                + " del " + fechaHora.format(FORMATO) + ".");
    }

    public void agregarMedicion(MedicionDeSignosVitales medicion) {
        mediciones.add(Objects.requireNonNull(medicion, "La medición no puede ser nula"));
    }

    public String generarReporte() {
        StringBuilder reporte = new StringBuilder();
        reporte.append("===== REPORTE DE LA ATENCIÓN PRESTADA =====\n");
        reporte.append("Paciente:      ").append(paciente.getNombreCompleto()).append('\n');
        reporte.append("Profesional:   ").append(profesional.getNombreCompleto()).append('\n');
        reporte.append("Servicio:      ").append(nombreServicio()).append('\n');
        reporte.append("Costo:         $").append(String.format(Locale.forLanguageTag("es-CO"), "%,.0f", servicio.getCosto())).append('\n');
        reporte.append("Fecha y hora:  ").append(fechaHora.format(FORMATO)).append('\n');
        reporte.append("Motivo:        ").append(motivo).append('\n');
        reporte.append("Observaciones: ").append(observaciones).append('\n');
        reporte.append("Estado:        ").append(estado == null ? "Sin programar" : estado).append('\n');
        reporte.append("Signos vitales registrados:\n");
        if (mediciones.isEmpty()) {
            reporte.append("  (ninguno)\n");
        } else {
            for (MedicionDeSignosVitales medicion : mediciones) {
                reporte.append("  - ").append(medicion.getSignoVital()).append(": ")
                        .append(medicion.getValor()).append(' ')
                        .append(medicion.getUnidad()).append('\n');
            }
        }
        reporte.append("===========================================");
        return reporte.toString();
    }

    public EstadoAtencion getEstado() {
        return estado;
    }

    private String nombreServicio() {
        return servicio.getTipoServicio().name().replace('_', ' ').toLowerCase(Locale.ROOT);
    }
}
