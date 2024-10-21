import java.util.Scanner;

public class feature1 {
    public static void main(String[] args)
    {
       
        Scanner ui = new Scanner(System.in);
        System.out.print("Enter Name: ");
        String name = ui.nextLine();

       
            System.out.println("My name is  " +  name);
        
        // else System.out.println(" Not correct. IMPOSTER!!!!"); 
        

        ui.close();
       
    }
}
