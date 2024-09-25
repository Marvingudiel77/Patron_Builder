package Solucion_problema_patron_builder;

public class Ejecutar {
    public static void main(String[] args) {

        Email email = new Email.EmailBuilder()
                .addDestinatario("CristianChamo@gmail.com")
                .addDestinatario("FernandoCarranza@gmail.com")
                .setAsunto("Reunión de trabajo")
                .setCuerpo("Trabajadores, por favor asistan a la reunión mañana a las 10 AM.")
                .build();

        System.out.println(email);
    }
}

