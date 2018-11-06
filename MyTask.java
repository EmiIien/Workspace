/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package labonnecombinaison;

import java.util.TimerTask;

/**
 *
 * @author emiliendenot
 */
public class MyTask extends TimerTask{
        
    private int chrono = 66; // Nombre de secondes, pour ce cas soixante secondes, (pour une minute).
        
    @Override public void run() {
            
        chrono--;

        if (chrono >= 0) {
            //System.out.print(chrono); // Permet d'afficher toutes les secondes du chrono.
        } else {
            System.out.println("Trop tard !");
            System.exit(0); // Arrête le programme lorsque le timer arrive a zéro.
        }
        
        //Switch pour afficher le temps restant.
        switch (chrono) {
            case 5:
                System.out.println("Ils ne vous reste que 5 secondes !!!!");
                break;
            case 10:
                System.out.println("Ils ne vous reste que 10 secondes !!!");
                break;
            case 20:
                System.out.println("Ils ne vous reste que 20 secondes !!");
                break;
            case 30:
                System.out.println("Ils ne vous reste que 30 secondes !!");
                break;
            case 40:
                System.out.println("Ils ne vous reste que 40 secondes !!");
                break;
            case 50:
                System.out.println("Ils ne vous reste que 50 secondes !!");
                break;
            case 60:
                System.out.println("C'est partie vous avez 1 minute pour trouver la suite chiffre !");
                break;
            default:
                break;
        }
    }
    
    public int getChrono(){
        return chrono;
    }
}