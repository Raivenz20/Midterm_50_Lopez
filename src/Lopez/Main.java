package Lopez;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        boolean exit = true;
        do{
            System.out.println("+----------------------------------------------------------------------------------------------------+");
            System.out.printf("|%-40s%-20s%-40s|\n","","Barangay Records","");
            System.out.println("|\t1. Citizen Information"
                    + "\n|\t2. Violation type"
                    + "\n|\t3. Report"
                    + "\n|\t4. Exit");
            int choice;
            while(true){
                while(true){
                    System.out.print("|\tEnter Choice: ");
                    try{
                        choice = input.nextInt();
                        break;
                    }catch(InputMismatchException e){
                        System.out.printf("|%-43s%-14s%-43s|\n","","Error Input!!!","");
                        input.next();
                    }
                }
                if(choice == 1 || choice == 2 || choice == 3 || choice == 4){
                    break;
                }else{
                    System.out.printf("|%-40s%-20s%-40s|\n","","Input not Matched!!!","");
                }
            }
            
            switch(choice){
                case 1:
                    Citizen_Information ci = new Citizen_Information();
                    ci.cit_info();
                break;
                case 2:
                    Violation_MVType vmvt = new Violation_MVType();
                    vmvt.MV_type();
                break;
                case 3:
                    Violation_MVReport vmvr = new Violation_MVReport();
                    vmvr.MV_report();
                break;
                default:
                    exit = false;
                break;
            }
        }while(exit);
        System.out.println("Thanks");
    }
}
