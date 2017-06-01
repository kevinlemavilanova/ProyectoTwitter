/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectotwitter;

import javax.swing.JOptionPane;

/**
 *
 * @author kevin
 */
public class ProyectoTwitter {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        AppTwitter tw = new AppTwitter();
        Boolean seguir = true;
        tw.connect();

        String option = JOptionPane.showInputDialog("Seleccione un opcion: "
                + "\n a. Ver time line"
                + "\n b. Buscar"
                + "\n c. Twittear"
                + "\n d. Salir"
        );
        switch (option) {
            case "a":
                tw.verTimeline();
                break;
            case "b":
                tw.buscar("text");
                break;
            case "c":
                tw.postearTweet();
                break;
            case "d":
                seguir = false;
                break;
        }
        while (seguir == true);
    }
}
