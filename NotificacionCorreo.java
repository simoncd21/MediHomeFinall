public class NotificacionCorreo implements Notificacion {

    @Override
    public void enviar(Persona destinatario, String mensaje) {
        System.out.println("[CORREO] Para: " + destinatario.getCorreoElectronico()
                + " | " + mensaje);
    }
}
