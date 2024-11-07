import java.time.LocalDate;
import java.util.ArrayList;

public class Passagem_aerea_volta implements IPassagemAerea {

    private String limite_escala_ida = 3
    private ArrayList<String> escala;
    private int valor_ticket_adulto;
    private boolean adulto;

    public Reserva_passagem_aerea_volta(ArrayList<String> escala, int valor_ticket_adulto, boolean adulto) {
        this.escala = escala;
    }

    public double getValor_ticket_adulto() {
        if (!adulto) {
            return valor_ticket_adulto;
        } else {
            return valor_ticket_adulto * .90;
        }
    }

    public void Horariocomescala() {
        for (int i = 0; i < this.escala.size(); i++) {
            String Escala = this.escala.get(i);
            String[] partes = Escala.split(" - ");
            if (partes.length == 2) {
                String horario = partes[0];
                String aeroporto = partes[1];
                System.out.println("No Horário: " + horario + " será realizado uma escala no Aeroporto: " + aeroporto);
            }
        }
    }
}