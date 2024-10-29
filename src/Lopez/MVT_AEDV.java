package Lopez;

import java.util.Scanner;

public class MVT_AEDV {
    Scanner input = new Scanner(System.in);
    public void add_mvt(){
        System.out.println("+----------------------------------------------------------------------------------------------------+");
        System.out.printf("|%-35s%-30s%-35s|\n","","Add Violation Type","");
        System.out.print("|\tEnter Violation Name: ");
        String vname;
        while(true){
            try{
                vname = input.nextLine();
                break;
            }catch(Exception e){
                System.out.println("|\tError Occured!");
            }
        }
        String SQL = "INSERT INTO Violation_Type (VT_name) Values(?)";
        config conf = new config();
        conf.addRecord(SQL, vname);
    }
    
    public void edit_mvt(){
        System.out.println("+----------------------------------------------------------------------------------------------------+");
        System.out.printf("|%-35s%-30s%-35s|\n","","Edit Violation Type","");
        System.out.print("|\tEnter Violation Type ID to be Edit: ");
        int id;
        while(true){
            try{
                id = input.nextInt();
                input.nextLine();
                break;
            }catch(Exception e){
                System.out.print("|\tError Occured!");
                input.next();
            }
        }
        System.out.print("|\tEnter New Violation Name: ");
        String vname;
        while(true){
            try{
                vname = input.nextLine();
                break;
            }catch(Exception e){
                System.out.println("|\tError Occured!");
                input.next();
            }
        }
        String SQL = "UPDATE Violation_Type set VT_name = ? Where VT_id = ?";
        config conf = new config();
        conf.updateRecord(SQL, vname, id);
    }
    
    public void view_mvt(){
        String tbl_view = "SELECT * FROM Violation_Type";
        String[] tbl_Headers = {"ID", "Violation Name"};
        String[] tbl_Columns = {"VT_id", "VT_name"};
        config conf = new config();
        conf.viewRecords(tbl_view, tbl_Headers, tbl_Columns);
    }
    
    public void delete_mvt(){
        System.out.println("+----------------------------------------------------------------------------------------------------+");
        System.out.printf("|%-35s%-30s%-35s|\n","","Delete Violation Type","");
        System.out.print("|\tEnter ID to delete: ");
        int id = input.nextInt();
        String SQL = "Delete from Violation_Type where VT_id = ?";
        config conf = new config();
        conf.deleteRecord(SQL,id);
    }
}
