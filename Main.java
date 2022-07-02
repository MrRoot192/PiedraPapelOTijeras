import java.util.Scanner;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        
            try {
                Scanner sc = 
                new Scanner(System.in);
                
                if (sc.hasNext()) { 
                   
                    String userInput = quickFormat( sc.next() );
                    sc.close();
                
                    if (isValid( userInput )) {
                        game( userInput );
                        
                    } else {
                        displayInputs();
                    }    
                } else {
                   displayInputs(); 
                }
                
            } catch (Exception e) {
                e.printStackTrace();
            }
    }
    
    
    public static void game(String user) {
        String computer = computerResults();
        
        print( user + " vs " + computer + "\n");
        
        if (user.equalsIgnoreCase(computer)) {
            print("Empate!");
        } else {
        
            if (checkWin(user, computer)) {
               print("Ganaste contra la computadora!");
            } else {
               print("La computadora te ganó!");
            }
        }
    }
    
    public static String computerResults() {
        
        String types[] = 
        {"piedra", "papel", "tijeras"};
        
        Random rand = new Random(); 
        int computerChoice = rand.nextInt(3);
        
        return types[computerChoice];
    }
    
    public static boolean isValid(String input) {
        
        
        switch( input.toLowerCase()) {
           
            case "piedra":
               return true;
        
            case "papel":
                return true;
            
            case "tijeras":
                return true;
            
            default:
                return false;
        }
    }
    
    public static boolean checkWin(String user, String opponent) {
        
        if ( (!isValid( user )) || (!isValid( opponent )) ) {
            return false;
        }
        
        String rock = "piedra", paper = "papel", scissors = "tijeras";
        
        if ( (user.equalsIgnoreCase( rock )) && (opponent.equalsIgnoreCase( scissors )) ) {
           return true; 
        }
        
         if ( (user.equalsIgnoreCase( scissors)) && (opponent.equalsIgnoreCase( paper )) ) {
           return true; 
        }
        
         if ( (user.equalsIgnoreCase( paper )) && (opponent.equalsIgnoreCase( rock  )) ) {
           return true; 
        }
        
        return false; 
    }

    public static void displayInputs() {
        print("Elección inválida!\nEscribe piedra, papel o tijeras!");
    }
    
    public static void print(String text) {
       System.out.println( text );
    }
    
    public static String quickFormat(String input) { 
       
       String output = input;
       
       switch( input.toLowerCase() ) {
        
        case "r":
            output = "piedra";
            break;
            
        case "p":
           output = "papel";
           break;
           
        case "s":
            output = "tijeras";
            break;
            
       case "scissor":
            output = "tijeras";
            break;
        }
       
       return output;
    }
}