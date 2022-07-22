/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package testtechnique;


/**
 *
 * @author ilyassberradi
 */
public class Aspirateur {
    private int x, y;
    private char orientation;
    private final String s; 
    
    private int x_max, y_max;// x_max et y_max sont les dimensions de la grille
    public Aspirateur(int x, int y, char orientation, int x_max, int y_max) throws CoordonneesException, NegativeException, OrientationException {
        if(x_max<0||y_max<0) throw new NegativeException();
        if(x>x_max||x<0||y>y_max||y<0) throw new CoordonneesException();
        if(orientation!='N' && orientation!='E' && orientation!='W' && orientation!='S') throw new OrientationException();
        this.x=x;
        this.y=y;
        this.orientation=orientation;
        s="NESW";//On utilise cette chaine de caractère où les orientations sont représentés par des caractères et ordonnés de sorte qu'on les parcourt 
        //en fonction des instructions données à l'aspirateur dans la méthode run(...)
        this.x_max=x_max;
        this.y_max=y_max;
    }
    
    public void run(String instructions) throws InstructionsException {
        for(int i=0; i<instructions.length(); i++){
            if(instructions.charAt(i)=='D'){
                if(s.indexOf(orientation)+1<s.length()){
                    orientation=s.charAt(s.indexOf(orientation)+1);
                }
                else{
                    orientation=s.charAt(0);
                }
                /*switch(orientation){
                    case 'N':
                        orientation='E';
                        break;
                        
                    case 'E':
                        orientation='S';
                        break;
                        
                    case 'S':
                        orientation='W';
                        break;
                        
                    case 'W':
                        orientation='N';
                        break;
                }*/
                
            }
            else if(instructions.charAt(i)=='G'){
                if(s.indexOf(orientation)-1>=0){
                    orientation=s.charAt(s.indexOf(orientation)-1);
                }
                else{
                    orientation=s.charAt(s.length()-1);
                }
                /*switch(orientation){
                    case 'N':
                        orientation='W';
                        break;
                        
                    case 'E':
                        orientation='N';
                        break;
                        
                    case 'S':
                        orientation='E';
                        break;
                        
                    case 'W':
                        orientation='S';
                        break;
                }*/
                
            }
            else if(instructions.charAt(i)=='A'){
                switch(orientation){
                    case 'N':
                        if(y+1>y_max){
                            System.out.println("L'aspirateur a essayé de dépassé la dimension de "
                                + "la grille à x= "+this.getX()+", y= "+this.getY()+" et l'orientation "+ this.getOrientation());
                        }
                        else
                            y++;
                        break;
                        
                    case 'E':
                        if(x+1>x_max){
                            System.out.println("L'aspirateur a essayé de dépassé la dimension de "
                                + "la grille à x= "+this.getX()+", y= "+this.getY()+" et l'orientation "+ this.getOrientation());
                        }
                        else
                            x++;
                        break;
                        
                    case 'S':
                        if(y-1<0){
                            System.out.println("L'aspirateur a essayé de dépassé la dimension de "
                                + "la grille à x= "+this.getX()+", y= "+this.getY()+" et l'orientation "+ this.getOrientation());
                        }
                        else
                            y--;
                        break;
                        
                    case 'W':
                        if(x-1<0){
                            System.out.println("L'aspirateur a essayé de dépassé la dimension de "
                                + "la grille à x= "+this.getX()+", y= "+this.getY()+" et l'orientation "+ this.getOrientation());
                        }
                        else
                            x--;
                        break;
                }
            }
            else
                throw new InstructionsException();
        }
    }
    
    public int getX(){return x;}
    public int getY(){return y;}
    public int getXmax(){return x_max;}
    public int getYmax(){return y_max;}
    public char getOrientation(){return orientation;}
    public void setX(int x){this.x=x;}
    public void setY(int y){this.y=y;}
    public void setOrientation(char orientation){this.orientation=orientation;}
    public void setXmax(int x_max){this.x_max=x_max;}
    public void setYmax(int y_max){this.y_max=y_max;}
    
}


class CoordonneesException extends Exception {

    
    public CoordonneesException() {
    }

   
    public CoordonneesException(String msg) {
        super(msg);
    }
}



class NegativeException extends Exception {

    
    public NegativeException() {
    }

   
    public NegativeException(String msg) {
        super(msg);
    }
}

class OrientationException extends Exception {

    
    public OrientationException() {
    }

   
    public OrientationException(String msg) {
        super(msg);
    }
}

class InstructionsException extends Exception {

    
    public InstructionsException() {
    }

   
    public InstructionsException(String msg) {
        super(msg);
    }
}