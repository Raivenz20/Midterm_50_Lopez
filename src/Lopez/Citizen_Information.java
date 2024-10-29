package Lopez;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Citizen_Information {
    public void cit_info(){
        Scanner input = new Scanner(System.in);
        Citizen_Add c_add = new Citizen_Add();
        Citizen_View_Delete c_vd = new Citizen_View_Delete();
        Citizen_Edit c_edit = new Citizen_Edit();
        boolean exit = true;
        do{
            System.out.println("+----------------------------------------------------------------------------------------------------+");
            System.out.printf("|%-40s%-21s%-39s|\n","","Citizen's Information","");
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
                    c_add.add_citizen();
                break;
                case 2:
                    c_vd.view_citizen();
                    c_edit.edit_citizen();
                    c_vd.view_citizen();
                break;
                case 3:
                    c_vd.view_citizen();
                    c_vd.delete_citizen();
                    c_vd.view_citizen();
                break;
                case 4:
                    c_vd.view_citizen();
                break;
                default:
                    exit = false;
                break;
            }
        }while(exit);
    }
}
