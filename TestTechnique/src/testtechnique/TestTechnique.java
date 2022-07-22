/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package testtechnique;


/**
 *
 * @author ilyassberradi
 */
public class TestTechnique {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Aspirateur a=null;
        try {
            a= new Aspirateur(5, 5, 'N', 10, 10);//On insère ici la position initial et l'orientation de l'aspirateur,
            //ainsi que la dimension de la grille comme paramètre
            a.run("DADADADAA");//On insère ici les instructions données à l'aspirateur comme paramètre
        } catch (CoordonneesException ex) {
            System.out.println("Les coordonnés entrées au paramètres n'appartient pas à la dimension de la grille");
            System.exit(-1);
        } catch (NegativeException ex) {
            System.out.println("La dimension de la grille n'est pas positive");
            System.exit(-1);
        } catch (OrientationException ex) {
            System.out.println("Orientation non existante");
            System.exit(-1);
        } catch (InstructionsException ex) {
            System.out.println("L'instruction passée à l'aspirateur est incorrecte!");
        } 
        System.out.println("L'aspirateur s'est arrêté à "
                    + "x= "+a.getX()+", y= "+a.getY()+" et l'orientation "+ a.getOrientation());    
    }
    
}
