package Solucion_problema_patron_builder;

import java.util.ArrayList;
import java.util.List;

public class Email {
    private List<String> destinatarios;
    private String asunto;
    private String cuerpo;

    private Email(EmailBuilder builder) {
        this.destinatarios = builder.destinatarios;
        this.asunto = builder.asunto;
        this.cuerpo = builder.cuerpo;
    }

    public List<String> getDestinatarios() {
        return destinatarios;
    }

    public String getAsunto() {
        return asunto;
    }

    public String getCuerpo() {
        return cuerpo;
    }

    @Override
    public String toString() {
        return "Destinatarios: " + destinatarios +
                "\nAsunto: " + asunto +
                "\nCuerpo: " + cuerpo;
    }

    public static class EmailBuilder {
        private List<String> destinatarios = new ArrayList<>();
        private String asunto;
        private String cuerpo;

        public EmailBuilder addDestinatario(String destinatario) {
            this.destinatarios.add(destinatario);
            return this;
        }

        public EmailBuilder setAsunto(String asunto) {
            this.asunto = asunto;
            return this;
        }

        public EmailBuilder setCuerpo(String cuerpo) {
            this.cuerpo = cuerpo;
            return this;
        }

        public Email build() {
            if (destinatarios.isEmpty()) {
                throw new IllegalStateException("El correo debe tener al menos un destinatario.");
            }
            if (asunto == null || asunto.isEmpty()) {
                throw new IllegalStateException("El correo tiene que tener un asunto.");
            }
            if (cuerpo == null || cuerpo.isEmpty()) {
                throw new IllegalStateException("El correo tiene que tener un cuerpo.");
            }
            return new Email(this);
        }
    }
}

