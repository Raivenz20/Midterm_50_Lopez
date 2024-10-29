package Lopez;

import java.sql.*;
import java.util.Scanner;

public class MVR_AEDV {
    MVT_AEDV mvt_aedv = new MVT_AEDV();
    Citizen_View_Delete cvd = new Citizen_View_Delete();
    Scanner input = new Scanner(System.in);
    config conf = new config();
    
    public void add_mvr(){
        System.out.println("+----------------------------------------------------------------------------------------------------+");
        System.out.printf("|%-35s%-30s%-35s|\n","","Add Violation Report","");
        System.out.print("|\tEnter Complainant First Name: ");
        String fname = input.next();
        System.out.print("|\tEnter Complainant Middle Name: ");
        String mname = input.next();
        System.out.print("|\tEnter Complainant Last Name: ");
        String lname = input.next();
        int cyear = 2024, cday=0, cmonth=0;
        String dates;
        while(true){
            System.out.print("|\tEnter Current Date Month (1-12): ");
            try{
                cmonth = input.nextInt();
                if(cmonth>=1 && cmonth<=12){
                    break;
                }
            }catch(Exception e){
                System.out.println("|\tError Occured!");
                input.next();
            }
        }
        while(true){
            System.out.print("|\tEnter Current Date Day (1-31): ");
            try{
                cday = input.nextInt();
                if(cday>=1 && cday<=31){
                    break;
                }
            }catch(Exception e){
                System.out.println("|\tError Occured!");
                input.next();
            }
        }
        dates = cmonth+"/"+cday+"/"+cyear;
        cvd.view_citizen();
        int C_id;
        while(true){
            System.out.println("|\tSelect Citizen (ID): ");
            try{
                C_id = input.nextInt();
                if (isValidCitizenID(C_id, conf)) {
                    break;
                } else {
                    System.out.println("|\tInvalid Citizen ID. Please enter a valid ID.");
                }
            }catch(Exception e){
                System.out.println("|\tError Occured!");
                input.next();
            }
        }
        mvt_aedv.view_mvt();
        int MVT_id;
        while(true){
            System.out.print("|\tSelect Violation Type (ID): ");
            try{
                MVT_id = input.nextInt();
                if (isValidViolationTypeID(MVT_id, conf)) {
                    break;
                } else {
                    System.out.println("|\tInvalid Violation Type ID. Please enter a valid ID.");
                }
            }catch(Exception e){
                System.out.println("|\tError Occured!");
                input.next();
            }
        }
        String stat;
        while(true){
            System.out.print("|\tStatus (Finished/Unfinished): ");
            try{
                stat = input.next();
                if(stat.equalsIgnoreCase("Finished")||stat.equalsIgnoreCase("Unfinished")){
                    break;
                }
            }catch(Exception e){
                System.out.println("|\tError Occured!");
            }
        }
        String sql = "INSERT INTO Violation_Report (VRC_fname, VRC_mname, VRC_lname, VR_date, C_id, VT_id, VR_status) VALUES (?, ?, ?, ?, ?, ?, ?)";
        conf.addRecord(sql, fname, mname, lname, dates, C_id, MVT_id, stat);
    }
    public void edit_mvr() {
        config conf = new config();
        System.out.println("+----------------------------------------------------------------------------------------------------+");
        System.out.printf("|%-35s%-30s%-35s|\n","","Edit Violation Report","");
        
        int reportId;
        while (true) {
            System.out.print("|\tEnter Violation Report ID to Edit: ");
            try {
                reportId = input.nextInt();
                if (isValidReportID(reportId, conf)) {
                    break;
                } else {
                    System.out.println("|\tInvalid Violation Report ID. Please enter a valid ID.");
                }
            } catch (Exception e) {
                System.out.println("|\tError Occured!");
                input.next();
            }
        }

        System.out.print("|\tEnter New Complainant First Name: ");
        String fname = input.next();
        System.out.print("|\tEnter New Complainant Middle Name: ");
        String mname = input.next();
        System.out.print("|\tEnter New Complainant Last Name: ");
        String lname = input.next();
        int cyear = 2024, cday=0, cmonth=0;
        String dates;
        while(true){
            System.out.print("|\tEnter Current Date Month (1-12): ");
            try{
                cmonth = input.nextInt();
                if(cmonth>=1 && cmonth<=12){
                    break;
                }
            }catch(Exception e){
                System.out.println("|\tError Occured!");
                input.next();
            }
        }
        while(true){
            System.out.print("|\tEnter Current Date Day (1-31): ");
            try{
                cday = input.nextInt();
                if(cday>=1 && cday<=31){
                    break;
                }
            }catch(Exception e){
                System.out.println("|\tError Occured!");
                input.next();
            }
        }
        dates = cmonth+"/"+cday+"/"+cyear;
        cvd.view_citizen();
        int C_id;
        while (true) {
            System.out.println("|\tSelect New Citizen (ID): ");
            try {
                C_id = input.nextInt();
                if (isValidCitizenID(C_id, conf)) {
                    break;
                } else {
                    System.out.println("|\tInvalid Citizen ID. Please enter a valid ID.");
                }
            } catch (Exception e) {
                System.out.println("|\tError Occured!");
                input.next();
            }
        }
        mvt_aedv.view_mvt();
        int MVT_id;
        while (true) {
            System.out.print("|\tSelect New Violation Type (ID): ");
            try {
                MVT_id = input.nextInt();
                if (isValidViolationTypeID(MVT_id, conf)) {
                    break;
                } else {
                    System.out.println("|\tInvalid Violation Type ID. Please enter a valid ID.");
                }
            } catch (Exception e) {
                System.out.println("|\tError Occured!");
                input.next();
            }
        }
        String stat;
        while (true) {
            System.out.print("|\tNew Status (Finished/Unfinished): ");
            try {
                stat = input.next();
                if (stat.equalsIgnoreCase("Finished") || stat.equalsIgnoreCase("Unfinished")) {
                    break;
                }
            } catch (Exception e) {
                System.out.println("|\tError Occured!");
            }
        }

        String sql = "UPDATE Violation_Report SET VRC_fname = ?, VRC_mname = ?, VRC_lname = ?, VR_date = ?, C_id = ?, VT_id = ?, VR_status = ? WHERE VR_id = ?";
        conf.updateRecord(sql, fname, mname, lname, dates, C_id, MVT_id, stat,reportId);
    }
    public void view_mvr(){
        String tbl_view = "SELECT * FROM Violation_Report";
        String[] tbl_Headers = {"ID", "First Name", "Middle Name", "Last Name", "Date", "C_id", "VT_id", "Status"};
        String[] tbl_Columns = {"VR_id", "VRC_fname", "VRC_mname", "VRC_lname", "VR_date", "C_id", "VT_id", "VR_status"};
        config conf = new config();
        conf.viewRecords(tbl_view, tbl_Headers, tbl_Columns);
    }
    public void delete_mvr(){
        System.out.println("+----------------------------------------------------------------------------------------------------+");
        System.out.printf("|%-35s%-30s%-35s|\n","","Delete Violation Report","");
        System.out.print("|\tEnter ID to delete: ");
        int id = input.nextInt();
        String SQL = "Delete from Violation_Report where VR_id = ?";
        config conf = new config();
        conf.deleteRecord(SQL,id);
    }

    // Method to check if the Violation Report ID is valid
    private boolean isValidReportID(int reportId, config conf) {
        String query = "SELECT COUNT(*) FROM Violation_Report WHERE VR_id = ?";
        try (Connection conn = conf.connectDB();
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setInt(1, reportId);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return rs.getInt(1) > 0;
            }
        } catch (SQLException e) {
            System.out.println("|\tError checking Report ID: " + e.getMessage());
        }
        return false;
    }
    private boolean isValidCitizenID(int C_id, config conf) {
        String query = "SELECT COUNT(*) FROM Citizen_information WHERE C_id = ?";
        try (Connection conn = conf.connectDB();
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setInt(1, C_id);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return rs.getInt(1) > 0;
            }
        } catch (SQLException e) {
            System.out.println("|\tError checking Citizen ID: " + e.getMessage());
        }
        return false;
    }
    private boolean isValidViolationTypeID(int MVT_id, config conf) {
        String query = "SELECT COUNT(*) FROM Violation_Type WHERE VT_id = ?";
        try (Connection conn = conf.connectDB();
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setInt(1, MVT_id);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return rs.getInt(1) > 0;
            }
        } catch (SQLException e) {
            System.out.println("|\tError checking Violation Type ID: " + e.getMessage());
        }
        return false;
    }
}
