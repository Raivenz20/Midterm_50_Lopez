package Lopez;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Violation_MVReport {
    public void MV_report(){
        MVR_AEDV mvr_aedv = new MVR_AEDV();
        Scanner input = new Scanner(System.in);
        boolean exit = true;
        do{
            System.out.println("+----------------------------------------------------------------------------------------------------+");
            System.out.printf("|%-35s%-30s%-35s|\n","","Management Violation Report","");
            System.out.println("|\t1. Add"
                    + "\n|\t2. Edit"
                    + "\n|\t3. Delete"
                    + "\n|\t4. View"
                    + "\n|\t5. Back");
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
                if(choice == 1 || choice == 2 || choice == 3 || choice == 4 || choice == 5){
                    break;
                }else{
                    System.out.printf("|%-40s%-20s%-40s|\n","","Input not Matched!!!","");
                }
            }
            switch(choice){
                case 1:
                    mvr_aedv.add_mvr();
                break;
                case 2:
                    mvr_aedv.view_mvr();
                    mvr_aedv.edit_mvr();
                    mvr_aedv.view_mvr();
                break;
                case 3:
                    mvr_aedv.view_mvr();
                    mvr_aedv.delete_mvr();
                    mvr_aedv.view_mvr();
                break;
                case 4:
                    mvr_aedv.view_mvr();
                break;
                default:
                    exit = false;
                break;
            }
        }while(exit);
    }
}
