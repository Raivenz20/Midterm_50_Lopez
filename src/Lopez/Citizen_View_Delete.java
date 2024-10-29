package Lopez;

import java.util.Scanner;

public class Citizen_View_Delete {
    Scanner input = new Scanner(System.in);
    public void view_citizen(){
        String tbl_view = "SELECT * FROM Citizen_information";
        String[] tbl_Headers = {"ID", "First Name", "Middle Name", "Last Name", "Gender", "Birth Date", "Registered Date"};
        String[] tbl_Columns = {"C_id", "C_fname", "C_mname", "C_lname", "C_gender", "C_birth_date", "C_registered_date"};
        config conf = new config();
        conf.viewRecords(tbl_view, tbl_Headers, tbl_Columns);
    }
    public void delete_citizen(){
        System.out.println("+----------------------------------------------------------------------------------------------------+");
        System.out.printf("|%-35s%-30s%-35s|\n","","Delete Citizen's Information","");
        System.out.print("|\tEnter ID to delete: ");
        int id = input.nextInt();
        String SQL = "Delete from Citizen_information where C_id = ?";
        config conf = new config();
        conf.deleteRecord(SQL,id);
    }
}
