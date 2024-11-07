public class Confirmacao {
    Cliente cliente;
    Pagamento pagamento;
    ReservaHospedagem reservaHospedagem;
    Reserva_passagem_aerea reserva_passagem_aerea;

    public Confirmacao(Cliente cliente, Pagamento pagamento, ReservaHospedagem reservaHospedagem, Reserva_passagem_aerea reserva_passagem_aerea) {
        this.cliente = cliente;
        this.pagamento = pagamento;
        this.reservaHospedagem = reservaHospedagem;
        this.reserva_passagem_aerea = reserva_passagem_aerea;
    }

    public String GetInfo(boolean possuiPassagemAerea) {
        if (possuiPassagemAerea == true) {
            System.out.println( "Confirmacao de reservas. \nHospedagem \nHotel: "+ reservaHospedagem.getNome_do_estabelecimento_da_hospedagem() +" data checkin: "+ reservaHospedagem.getCheckin() +" data checkOut: "+ reservaHospedagem.getCheckout() +" hospedes: "+ reservaHospedagem.quantidadeHospedes() +" \nPassagem Aerea \ncompanhia: "+ reserva_passagem_aerea.getCompanhia() +" data embarque: "+ reserva_passagem_aerea.getData_de_embarque() +" aeroporto: "+ reserva_passagem_aerea.getAeroporto_embarque() +" numero do voo: "+ reserva_passagem_aerea.getNumero_voo() +" valor total de "+ pagamento.getValor_total() +" parcelados em "+ pagamento.getNumeros_parcelas() +" vezes de "+ pagamento.getValor_de_cada_parcela());
            return "Confirmacao de reservas.\n Hospedagem \n Hotel: "+ reservaHospedagem.getNome_do_estabelecimento_da_hospedagem() +" data checkin: "+ reservaHospedagem.getCheckin() +"data checkOut: "+ reservaHospedagem.getCheckout() +" hospedes: "+ reservaHospedagem.quantidadeHospedes() +" \n Passagem Aerea \n companhia: "+ reserva_passagem_aerea.getCompanhia() +" data embarque:  "+ reserva_passagem_aerea.getData_de_embarque() +"aeroporto:  "+ reserva_passagem_aerea.getAeroporto_embarque() +"numero do voo:  "+ reserva_passagem_aerea.getNumero_voo() +"valor total de  "+ pagamento.getValor_total() +"parcelados em "+ pagamento.getNumeros_parcelas() +"vezes de "+ pagamento.getValor_de_cada_parcela();            
        } else {
            System.out.println("Confirmacao de reservas. \nHospedagem \nHotel: "+ reservaHospedagem.getNome_do_estabelecimento_da_hospedagem() +" data checkin: "+ reservaHospedagem.getCheckin() +" data checkOut: "+ reservaHospedagem.getCheckout() +" Hospedes: "+ reservaHospedagem.quantidadeHospedes() +" valor total de "+ pagamento.getValor_total() +" parcelados em "+ pagamento.getNumeros_parcelas() +" vezes de "+ pagamento.getValor_de_cada_parcela());
            return "Confirmacao de reservas.\n Hospedagem \n Hotel: "+ reservaHospedagem.getNome_do_estabelecimento_da_hospedagem() +" data checkin: "+ reservaHospedagem.getCheckin() +"data checkOut: "+ reservaHospedagem.getCheckout() +" hospedes: "+ reservaHospedagem.quantidadeHospedes() +"valor total de  "+ pagamento.getValor_total() +"parcelados em "+ pagamento.getNumeros_parcelas() +"vezes de "+ pagamento.getValor_de_cada_parcela();
        }
    }
}
