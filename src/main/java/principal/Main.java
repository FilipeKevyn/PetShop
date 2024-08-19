package principal;

import controller.Controlador;
import model.*;
//import window.AgendarWindow;

import javax.naming.ldap.Control;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        Controlador control = new Controlador();
        //AgendarWindow petWindow = new AgendarWindow();
        control.addDono("Dudu"); // -> Lista de donos
        // addPet
        control.addPet("toto", "Cachorro"); // -> Lista de Pet
        // addProcedimento
        Procedimento procedimento1 = control.addProcedimento("Cortar as unhas", 20, 30);
        Procedimento procedimento2 = control.addProcedimento("Tosa",30, 20);
        Procedimento procedimento3 = control.addProcedimento("Banho", 80, 50);
        // addProcedimento para o Pet

        // add agendamento
        control.addAgendamento();
    }
}
