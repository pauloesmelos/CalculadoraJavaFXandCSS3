package com.example.calculadorajavafx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class HelloController {
    //teste
    @FXML
    private Label welcomeText;
    //

    @FXML
    private TextField tf01;
    @FXML
    private Button btn04;
    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }
    @FXML
    private TextArea txt01;

    private double valor1;

    private double valor2;

    private char operacao;

    static private int chamadas;

    static private int chamadasBtnAction;

    public void setValor1(double valor1){
        this.valor1 = valor1;
    }

    public double getValor1() {
        return valor1;
    }

    public void setValor2(double valor2){
        this.valor2 = valor2;
    }

    public double getValor2() {
        return valor2;
    }

    public void setOperacao(char operacao){
        this.operacao = operacao;
    }

    public char getOperacao() {
        return operacao;
    } /// IMPLEMENTAR O TIPO DE OPERAÇÃO QUE ESTÁ SENDO RECEBEIDO;

    public static void setChamadas() {
        HelloController.chamadas++;
    }

    public int getChamadas(){
        return HelloController.chamadas;
    }

    public static void resetChamadas(){
        HelloController.chamadas = 0;
    }

    public void setChamadasBtnAction(){
        HelloController.chamadasBtnAction++;
    }

    public int getChamadasBtnAction(){
        return HelloController.chamadasBtnAction;
    }

    public void btnAction(ActionEvent event){ //metodo 1
        //tf01.setText(btn01.getText());
        String text = ((Button)event.getSource()).getText(); // casting no event passado como parametro para converter o objeto em um Button e dps pegar o texto
        tf01.setText(tf01.getText() + text);

        if(getChamadas() == 2){
            resetChamadas();
        }
        else if(getChamadas() == 0){

            setValor1(Double.parseDouble(text));
            System.out.println(getValor1());
            btnOperacao(event);
        }
        else if(getChamadas() == 1){
            setValor2(Double.parseDouble(text));
            System.out.println(getValor2());
            btnOperacao(event);
        }
        setChamadas();
        setChamadasBtnAction();
        //System.out.println(getChamadas());
    }

    public void btnRemove(ActionEvent event){ //metodo 2
        tf01.setText("");
    }
    public void btnRemoveExpression(ActionEvent event){ //metodo 3
        txt01.setText("");
        setValor1(0);
        setValor2(0);
        resetChamadas(); //0 a quantidade de chamadas de números no text area;
    }
    public void btnOperacao(ActionEvent event){ //metodo 4
        btnRemove(new ActionEvent());
        String text = ((Button)event.getSource()).getText();
        txt01.setText(txt01.getText() + text);

    }

    public void btnCalcular(ActionEvent event){ //metodo 5
        double resultado = 0;
        if(txt01.getText().contains("+"))
            resultado = getValor1() + getValor2();
        else if(txt01.getText().contains("-"))
            resultado = getValor1() - getValor2();
        else if(txt01.getText().contains("x"))
            resultado = getValor1() * getValor2();
        else if(txt01.getText().contains("/"))
            resultado = getValor1() / getValor2();
        //double resultado = getValor1() + getValor2();
        String texto = String.valueOf(resultado);
        tf01.setText(texto);
        setValor1(0);
        setValor2(0);
        resetChamadas();
        txt01.setText("");
    }


}
