public class NotificacionSMS implements Notificacion {

    @Override
    public void enviar(Persona destinatario, String mensaje) {
        System.out.println("[SMS] Para: " + destinatario.getTelefono()
                + " | " + mensaje);
    }
}
