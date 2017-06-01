/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectotwitter;

import javax.swing.JOptionPane;
import twitter4j.*;
import twitter4j.conf.Configuration;

/**
 *
 * @author kevin
 */
public class AppTwitter {
    TwitterFactory tf = new TwitterFactory();
    Twitter twitter = tf.getInstance();
    
    
    /**
     * Muestra por consola el listado de tweets
     */
    public void verTimeline() {
        
        try {
            Paging pagina = new Paging();
            pagina.setCount(40);
            ResponseList listado = twitter.getHomeTimeline(pagina);
            for (int i = 0; i < listado.size(); i++) {
                System.out.println(listado.get(i).toString());
            }
        } catch (TwitterException ex) {
            System.out.println("Error al ver la linea de tiempo");
        }
    }

    /**
     * Habre una ventana en la que podemos postear un tweet en nuestra cuenta
     */
    public void postearTweet() {
        try {
            twitter.updateStatus(JOptionPane.showInputDialog("Mensaje para twittear"));
        } catch (TwitterException ex) {
            System.out.println("Error post");
        }
    }
/**
 * recibe un texto por el cual busca en twiter
 * @param text 
 */
    public void buscar(String text) {
        try {
            Query query = new Query("#" + text);
            QueryResult result = twitter.search(query);
            for (Status status : result.getTweets()) {
                System.out.println("@" + status.getUser().getScreenName() + ":" + status.getText());
            }
        } catch (TwitterException ex) {
            System.out.println("Error al buscar");
        }
    }
/**
 * Recibe un usaurio y el mensaje para ese usuario y s elo envia directamente 
 * @param user
 * @param msg 
 */
    public void mensajeDirecto(String user, String msg) {
        DirectMessage message;
        try {
            message = twitter.sendDirectMessage("@" + user, msg);
            System.out.println("Sent: " + message.getText() + " to @" + message.getRecipientScreenName());
        } catch (TwitterException ex) {
            System.out.println("Error mensaje directo");
        }
    }
}
