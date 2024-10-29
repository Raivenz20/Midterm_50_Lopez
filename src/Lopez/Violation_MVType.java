package Lopez;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Violation_MVType {
    public void MV_type(){
        Scanner input = new Scanner(System.in);
        MVT_AEDV mvt_aedv = new MVT_AEDV();
        boolean exit = true;
        do{
            System.out.println("+----------------------------------------------------------------------------------------------------+");
            System.out.printf("|%-35s%-30s%-35s|\n","","Management Violation Type","");
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
                    mvt_aedv.add_mvt();
                break;
                case 2:
                    mvt_aedv.view_mvt();
                    mvt_aedv.edit_mvt();
                    mvt_aedv.view_mvt();
                break;
                case 3:
                    mvt_aedv.view_mvt();
                    mvt_aedv.delete_mvt();
                    mvt_aedv.view_mvt();
                break;
                case 4:
                    mvt_aedv.view_mvt();
                break;
                default:
                    exit = false;
                break;
            }
        }while(exit);
    }
}
