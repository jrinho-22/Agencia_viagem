import javax.swing.*;


import java.awt.*;
import java.awt.event.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Tela extends JPanel implements WindowListener, ActionListener {

    private JTextField textFieldLocalPartida = new JTextField("", 10);
    public JLabel labelLocalPartida = new JLabel("Cidade de Partida");
    private JCheckBox internacional = new JCheckBox("Destindo internacional");
    private JTextField textFieldPaisDestino = new JTextField("", 10);
    public JLabel labelPaisDestino = new JLabel("Pais de Destino");
    private JTextField textFieldCidadeDestino = new JTextField("", 10);
    public JLabel labelCidadeDestino = new JLabel("Cidade de Destino");
    private JTextField textFieldDataCkeckIn = new JTextField("", 10);
    public JLabel labelDataCkeckIn = new JLabel("Data de CheckIn");
    private JTextField textFieldDataCheckOut = new JTextField("", 10);
    public JLabel labelDataCheckOut = new JLabel("Data de CheckOut");
    private JTextField textFieldAdultos = new JTextField("", 3);
    public JLabel labelAdultos = new JLabel("Adultos");
    private JTextField textFieldCriancas = new JTextField("", 3);
    public JLabel labelCriancas = new JLabel("Criancas");
    private JCheckBox possuiPassagemAerea = new JCheckBox("Passagem Aerea");

    public JLabel valor = new JLabel("");
    private JTextField textFieldCartao = new JTextField("", 10);
    public JLabel labelCartao = new JLabel("Numero do Cartao");
    private JTextField textFieldParcelas = new JTextField("", 3);
    public JLabel labelParcelas = new JLabel("Quantidade de parcelas");

    private JPanel painel;
    private JLabel sucesso = new JLabel("Reserva realizada com Sucesso!");
    private JLabel erroDataPassada = new JLabel("Erro, selecione datas futuras");
    private JLabel erroDataFormato = new JLabel("Erro, selecione data no formato dd/MM/yyyy");
    private JButton reserva = new JButton("-->PAGAMENTO<--");
    private JButton compra = new JButton("-->FINALIZAR RESERVA<--");
    private double valorTotal;
    Reserva_passagem_aerea reserva_passagem_aerea;
    LocalDate dataCkeckIn;
    LocalDate dataCkeckOut;

    public Tela() {
        super();
        this.telinha();
        this.add(this.painel);

    }

    private void telinha(){
        this.painel = new JPanel(new FlowLayout());
        painel.setPreferredSize(new Dimension(240,800));
        painel.add(labelLocalPartida);
        painel.add(textFieldLocalPartida);
        painel.add(internacional);
        painel.add(labelPaisDestino);
        labelPaisDestino.setVisible(false);
        painel.add(textFieldPaisDestino);
        textFieldPaisDestino.setVisible(false);
        painel.add(labelCidadeDestino);
        painel.add(textFieldCidadeDestino);
        painel.add(labelDataCkeckIn);
        painel.add(textFieldDataCkeckIn);
        painel.add(labelDataCheckOut);
        painel.add(textFieldDataCheckOut);
        painel.add(labelAdultos);
        painel.add(textFieldAdultos);
        painel.add(labelCriancas);
        painel.add(textFieldCriancas);
        painel.add(possuiPassagemAerea);
        painel.add(reserva);
        painel.add(erroDataPassada);
        painel.add(erroDataFormato);
        erroDataPassada.setVisible(false);
        erroDataFormato.setVisible(false);
        painel.add(valor);
        valor.setVisible(false);
        painel.add(labelCartao);
        labelCartao.setVisible(false);
        painel.add(textFieldCartao);
        textFieldCartao.setVisible(false);
        painel.add(labelParcelas);
        labelParcelas.setVisible(false);
        painel.add(textFieldParcelas);
        textFieldParcelas.setVisible(false);
        painel.add(compra);
        compra.setVisible(false);
        painel.add(sucesso);
        sucesso.setVisible(false);

        ArrayList<String> dadosCliente = new ArrayList<String>();
        try {
            FileReader arquivo = new FileReader("cliente.txt");
            BufferedReader buffer = new BufferedReader(arquivo);
            System.out.println(buffer);
            String str;
            while ((str = buffer.readLine()) != null) {
                dadosCliente.add(str);
            }

        }
        catch (IOException e) {
            e.printStackTrace();
        }

        Cliente cliente = new Cliente(dadosCliente.get(0), dadosCliente.get(1), dadosCliente.get(2), dadosCliente.get(3), dadosCliente.get(4), dadosCliente.get(5), dadosCliente.get(6), dadosCliente.get(7), dadosCliente.get(8), dadosCliente.get(9));
        
        reserva.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                erroDataPassada.setVisible(false);
                erroDataFormato.setVisible(false);
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                try {
                    dataCkeckIn = LocalDate.parse(textFieldDataCkeckIn.getText(), formatter);
                    dataCkeckOut = LocalDate.parse(textFieldDataCheckOut.getText(), formatter);
                    ChecarData.checkDate(dataCkeckIn);
                    ChecarData.checkDate(dataCkeckOut);
                }
                catch(DataInvalida ex) {
                    erroDataPassada.setVisible(true);
                    compra.setVisible(false);
                    valor.setVisible(false);
                    textFieldCartao.setVisible(false);
                    labelCartao.setVisible(false);
                    textFieldParcelas.setVisible(false);
                    labelParcelas.setVisible(false);
                    compra.setVisible(false);
                    return;    
                }
                catch(DateTimeParseException ex) {
                    erroDataFormato.setVisible(true);
                    compra.setVisible(false);
                    valor.setVisible(false);
                    textFieldCartao.setVisible(false);
                    labelCartao.setVisible(false);
                    textFieldParcelas.setVisible(false);
                    labelParcelas.setVisible(false);
                    compra.setVisible(false);
                    return;
                }

                erroDataPassada.setVisible(false);
                erroDataFormato.setVisible(false);

                ReservaHospedagem reservaHospedagem = new ReservaHospedagem(cliente.getNome(),cliente.getEmail(), Integer.parseInt(textFieldAdultos.getText()),Integer.parseInt(textFieldCriancas.getText()),0,"41996028585",300,344,"Avenida Manoel ribas","Ibis",textFieldCidadeDestino.getText(),textFieldPaisDestino.getText(),dataCkeckIn,dataCkeckOut);
                valorTotal = reservaHospedagem.ValorTotal();

                if (possuiPassagemAerea.isSelected()) {
                    ArrayList<Object> escala = new ArrayList<Object>();
                    if (internacional.isSelected()) {
                        escala.add("16:30 - Guarulhos");   
                    }
                    for (int i = 0; i < Integer.parseInt(textFieldAdultos.getText()); i++) {
                        Reserva_passagem_aerea reserva_passagem_aerea__ida = new Reserva_passagem_aerea(reserva_passagem_aerea_ida, cliente.getNome(), cliente.getEmail(), Integer.parseInt(textFieldAdultos.getText()), Integer.parseInt(textFieldCriancas.getText()), 805, "Executiva", 22, "GOL", "Aeroporto de " + textFieldCidadeDestino.getText(), "Aeroporto de " + textFieldLocalPartida.getText(), 2000, 900, 920, textFieldCidadeDestino.getText(), textFieldLocalPartida.getText(), dataCkeckIn.minusDays(1), dataCkeckIn.plusDays(1), false);
                        Reserva_passagem_aerea reserva_passagem_aerea__volta = new Reserva_passagem_aerea(reserva_passagem_aerea_volta, cliente.getNome(), cliente.getEmail(), Integer.parseInt(textFieldAdultos.getText()), Integer.parseInt(textFieldCriancas.getText()), 805, "Executiva", 22, "GOL", "Aeroporto de " + textFieldCidadeDestino.getText(), "Aeroporto de " + textFieldLocalPartida.getText(), 2000, 900, 920, textFieldCidadeDestino.getText(), textFieldLocalPartida.getText(), dataCkeckIn.minusDays(1), dataCkeckIn.plusDays(1), false);
                        valorTotal += reserva_passagem_aerea__ida.ValorTotal();
                        valorTotal += reserva_passagem_aerea__volta.ValorTotal();
                    }
                    for (int i = 0; i < Integer.parseInt(textFieldCriancas.getText()); i++) {
                        reserva_passagem_aerea_ida = new Reserva_passagem_aerea("ida", escala, cliente.getNome(), cliente.getEmail(), Integer.parseInt(textFieldAdultos.getText()), Integer.parseInt(textFieldCriancas.getText()), 805, "Executiva", 22, "GOL", "Aeroporto de " + textFieldCidadeDestino.getText(), "Aeroporto de " + textFieldLocalPartida.getText(), 2000, 900, 920, textFieldCidadeDestino.getText(), textFieldLocalPartida.getText(), dataCkeckIn.minusDays(1), dataCkeckIn.plusDays(1), false);
                        reserva_passagem_aerea_volta = new Reserva_passagem_aerea("volta", escala, cliente.getNome(), cliente.getEmail(), Integer.parseInt(textFieldAdultos.getText()), Integer.parseInt(textFieldCriancas.getText()), 805, "Executiva", 22, "GOL", "Aeroporto de " + textFieldCidadeDestino.getText(), "Aeroporto de " + textFieldLocalPartida.getText(), 2000, 900, 920, textFieldCidadeDestino.getText(), textFieldLocalPartida.getText(), dataCkeckIn.minusDays(1), dataCkeckIn.plusDays(1), true);                        
                        valorTotal += reserva_passagem_aerea.ValorTotal();
                    }
                    // reserva_passagem_aerea.Horariocomescala();
                    // valorTotal += reserva_passagem_aerea.ValorTotal();
                }

                valor.setVisible(true);
                valor.setText("Valor total de sua reserva: " + valorTotal);
                textFieldCartao.setVisible(true);
                labelCartao.setVisible(true);
                textFieldParcelas.setVisible(true);
                labelParcelas.setVisible(true);
                compra.setVisible(true);

                compra.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent event) {
                        System.out.println(valorTotal);
                        Pagamento pagamento = new Pagamento(valorTotal, "Mastercard", Double.parseDouble(textFieldParcelas.getText()), textFieldCartao.getText());
                        pagamento.Pagamento_com_parcelas();
                        // Confirmacao confirmacao = new Confirmacao(cliente, pagamento, reservaHospedagem, reserva_passagem_aerea);    
                        sucesso.setVisible(true);
                        // if (possuiPassagemAerea.isSelected()) {
                        //     sucesso.setText(confirmacao.GetInfo(true));
                        // } else {
                        //     sucesso.setText(confirmacao.GetInfo(false));
                        // }
                        
                    }
                });

            }});

        internacional.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (internacional.isSelected()) {
                    labelPaisDestino.setVisible(true);
                    textFieldPaisDestino.setVisible(true);
                } else {
                    labelPaisDestino.setVisible(false);
                    textFieldPaisDestino.setVisible(false);
                }
            }
        });

    }

    public void windowOpened(WindowEvent e) {}
    @Override
    public void windowClosing(WindowEvent e) {}
    public void windowClosed(WindowEvent e) {}
    public void windowIconified(WindowEvent e) {}
    public void windowDeiconified(WindowEvent e) {}
    public void windowActivated(WindowEvent e) {}
    public void windowDeactivated(WindowEvent e) {}

    @Override
    public void actionPerformed(ActionEvent e) {}
} 