/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package labonnecombinaison;

import java.util.Random;
import java.util.Scanner;
import java.util.Timer;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author emiliendenot
 */
public class LaBonneCombinaison {
   
    // Permet de savoir dans quel cas on se trouve.
    private static int kx = 1;
    
    // Fonction random, permet d'avoir trois nombres aléatoires entre zéro et cent.
    private static int myRandom() { 
        
        int randomNumb;

        Random rand = new Random();
        randomNumb = rand.nextInt(100);
        return randomNumb;
    }
    
    // Fonction permettant de vérifier la valeur donnée par l'utilisateur par rapport au nombre random.
    private static void checkValue(int kEx, int rNx) {
        
        if (kEx == rNx){
            System.out.println("Code bon.");
            kx++;
        }else if (kEx > rNx) {
            System.out.println("Plus petit.");
        }else if (kEx < rNx){
            System.out.println("Plus grand.");
        }else{
            System.out.println("Erreur, code invalide.");
        }
    }
    
    public static void main(String[] args) {
        
        int kE1, kE2, kE3;  // Pour les valeurs entrées par l'utilisateur (Keyboard Entries).
        int rN1, rN2, rN3; // Pour les nombres random à tester (Random Number).
        
        Scanner sc = new Scanner(System.in);
        Timer timer = new Timer();
        MyTask t = new MyTask();
        timer.schedule(t, 0, 1000);   
        
        //Affectation des valeurs avec la fonction random.
        rN1 = LaBonneCombinaison.myRandom(); 
        rN2 = LaBonneCombinaison.myRandom();
        rN3 = LaBonneCombinaison.myRandom();
        
        //Phrases d'introduction.
        System.out.println("Bienvenue sur le programme de 'La Bonne combinaison'.");
        System.out.println("Vous devez trouver la suite de code à trois nombres en moins d'une minute, "
                + "pour cela vous avez juste à rentrer un nombre entre 0 et 100. Bonne chance !");
        
        //do...while pour laisser dix secondes à l'utilisateur pour lire l'introduction et commencer le programme.
        do {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException ex) {
                Logger.getLogger(LaBonneCombinaison.class.getName()).log(Level.SEVERE, null, ex);
            }
        } while(t.getChrono() >= 60);
        
        //do...while puis switch pour les diffents cas (nombres) 
        do{
            switch (kx) {
                case 0: 
                    // Dans le cas 0 l'utilisateur est forcement passé par les quatres autres cas donc il a fini (kx = 0).
                    break;
                case 1:
                    System.out.print("Entrez le premier code : ");
                    kE1 = sc.nextInt();
                    checkValue(kE1, rN1);
                    break;
                case 2:
                    System.out.print("Entrez le deuxième code : ");
                    kE2 = sc.nextInt();
                    checkValue(kE2, rN2);
                    break;
                case 3:
                    System.out.print("Entrez le troisième code : ");
                    kE3 = sc.nextInt();
                    checkValue(kE3, rN3);
                    break;
                case 4:
                    System.out.println();
                    System.out.println("Vous avez trouvé le trésor !!!");
                    System.out.println("Cependant, votre tentative de cambriolage a "
                        + "dÃ©clenchÃ© une alarme silencieuse et l'arrivÃ©e de la police. ");
                    System.out.println("Lorsque le temps est totalement écoulé, "
                        + "la police arrive et vous arrête.");
                    kx = 0;
                    break;
                default:
                    System.out.println("ERROR");
                    System.exit(0);
                    break;
            }
        }while (kx != 0);
        
        //Arrêt du programme.
        System.out.println("Programme terminé !");
        System.exit(0);
    }
}