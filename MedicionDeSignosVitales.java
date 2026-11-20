import java.time.LocalDateTime;
import java.util.Objects;


public class MedicionDeSignosVitales {

    private final String signoVital;
    private final double valor;
    private final String unidad;
    private final LocalDateTime fechaHora;

    public MedicionDeSignosVitales(String signoVital, double valor, String unidad, LocalDateTime fechaHora) {
        this.signoVital = Objects.requireNonNull(signoVital, "El signo vital no puede ser nulo");
        this.valor = valor;
        this.unidad = Objects.requireNonNull(unidad, "La unidad no puede ser nula");
        this.fechaHora = Objects.requireNonNull(fechaHora, "La fecha y hora no pueden ser nulas");
    }

    public String getSignoVital() {
        return signoVital;
    }

    public double getValor() {
        return valor;
    }

    public String getUnidad() {
        return unidad;
    }
}
