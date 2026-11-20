import java.util.Objects;

public class ServicioDomiciliario {

    private final TipoServicio tipoServicio;
    private final String descripcion;
    private final double costo;

    public ServicioDomiciliario(TipoServicio tipoServicio, String descripcion, double costo) {
        this.tipoServicio = Objects.requireNonNull(tipoServicio, "El tipo de servicio no puede ser nulo");
        this.descripcion = descripcion;
        this.costo = costo;
    }

    public TipoServicio getTipoServicio() {
        return tipoServicio;
    }

    public double getCosto() {
        return costo;
    }
}
