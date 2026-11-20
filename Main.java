import java.time.LocalDate;
import java.time.LocalDateTime;

public class Main {

    public static void main(String[] args) {

        Paciente paciente = new Paciente("1012345678", "Ana", "Gómez", "3001112233",
                "ana.gomez@gmail.com", LocalDate.of(1990, 5, 14), "Calle 45 # 12-30");

        Profesional profesional = new Profesional("1098765432", "Carlos", "Ruiz", "3004445566",
                "carlos.ruiz@gmail.com", "Medicina general", "RM-12345");

        ServicioDomiciliario servicio = new ServicioDomiciliario(
                TipoServicio.MEDICINA_GENERAL, "Consulta médica general en casa", 80000);

        paciente.solicitarServicio(servicio);

        Atencion atencion = new Atencion(paciente, profesional, servicio,
                LocalDateTime.of(2026, 11, 20, 9, 0), "Control general", "Sin observaciones");
        atencion.programar(new NotificacionCorreo());

        MedicionDeSignosVitales medicion = new MedicionDeSignosVitales(
                "Temperatura", 36.8, "°C", LocalDateTime.of(2026, 11, 20, 9, 10));
        profesional.registrarSignosVitales(atencion, medicion);

        System.out.println();
        System.out.println(atencion.generarReporte());
    }
}
