package Lopez;

import java.util.Scanner;

public class Citizen_Add {
    Scanner input = new Scanner(System.in);
    public void add_citizen(){
        boolean exit = true;
        System.out.println("+----------------------------------------------------------------------------------------------------+");
        System.out.printf("|%-35s%-30s%-35s|\n","","Add Citizen's Information","");
        int add;
        while(true){
            System.out.println("+----------------------------------------------------------------------------------------------------+");
            while(true){
                System.out.print("|\tEnter Number of Citizen to Add (exit '0'): ");
                try{
                    add = input.nextInt();
                    break;
                }catch(Exception e){
                    System.out.println("|\tPlease Enter a Valid Input (or input 0 to exit)! Try Again:");
                    input.next();
                }
            }
            if(add>=0){
                break;
            }else{
                System.out.println("|\tInput 0 to exit, or 1 or above to continue!");
            }
        }
        for(int x=0; x<add; x++){
            System.out.println("+----------------------------------------------------------------------------------------------------+");
            System.out.printf("|%-35s%-12s%-1d%-17s%-35s|\n","","Information ",x+1,"","");
            System.out.print("|\tEnter First Name: ");
            String fname = input.next();
            System.out.print("|\tEnter Middle Name: ");
            String mname = input.next();
            System.out.print("|\tEnter Last Name: ");
            String lname = input.next();
            String gender;
            while(true){
                System.out.print("|\tEnter Gender(Male/Female): ");
                gender = input.next();
                if(gender.equalsIgnoreCase("male")||gender.equalsIgnoreCase("Female")){
                    break;
                }else{
                    System.out.println("|\tPlease Enter Male/Female only!");
                }
            }
            int cdm=0, cdd=0, cdy=2024;
            boolean cd1 = true;
            boolean cd2 = true;
            System.out.println("+----------------------------------------------------------------------------------------------------+");
            System.out.printf("|%-35s%-30s%-35s|\n","","Enter Current Date","");
            while(cd1){
                while(true){
                    while(cd2){
                        while(true){
                            System.out.print("|\tEnter Current Month (1-12): ");
                            try{
                                cdm = input.nextInt();
                                break;
                            }catch(Exception e){
                                System.out.println("|\tPlease Enter a Valid Input!");
                                input.next();
                            }
                        }
                        if(cdm>=1 && cdm<=12){
                            cd2 = false;
                        }
                    }
                    System.out.print("|\tEnter Current Day (1-31):  ");
                    try{
                        cdd = input.nextInt();
                        break;
                    }catch(Exception e){
                        System.out.println("|\tPlease Enter a Valid Input!");
                        input.next();
                    }
                }
                if(cdd>=1 && cdd<=31){
                    cd1 = false;
                }
            }
            System.out.println("|\tCurrent Year: "+cdy);
            String bdate;
            int bmonth, bday, byear;
            System.out.println("+----------------------------------------------------------------------------------------------------+");
            System.out.printf("|%-45s%-10s%-45s|\n","","Birth Date","");
            while(true){
                System.out.print("|\tEnter Birth Date (mm/dd/yyyy): ");
                try{
                    bdate = input.next();
                    String [] Dsplit = bdate.split("/");
                    if(Dsplit.length==3){
                        bmonth = Integer.parseInt(Dsplit[0]);
                        bday = Integer.parseInt(Dsplit[1]);
                        byear = Integer.parseInt(Dsplit[2]);
                        if(bmonth>=1 && bmonth<=12 && bday>=1 && bday<=31 && byear>=cdy-120 && byear<=cdy){
                            break;
                        }else{
                            System.out.println("|\tInvalid Date. Please Enter a Valid Date!");
                        }
                    }else{
                        System.out.println("|\tFollow The Instruction use (/) & Enter Valid Date!");
                    }

                }catch(Exception e){
                    System.out.println("Error!");
                    input.next();
                }
            }
            String rdy;
            System.out.println("+----------------------------------------------------------------------------------------------------+");
            System.out.printf("|%-43s%-15s%-42s|\n","","Registered Date","");
            while(true){
                System.out.print("|\tEnter Registered Date (mm/dd/yyyy): ");
                try{
                    rdy = input.next();
                    String [] Dsplit = rdy.split("/");
                    if(Dsplit.length==3){
                        int month = Integer.parseInt(Dsplit[0]);
                        int day = Integer.parseInt(Dsplit[1]);
                        int year = Integer.parseInt(Dsplit[2]);
                        if(month>=1 && month<=12 && day>=1 && day<=31 && year>=cdy-120 && year<=cdy){
                            if(year>byear){
                                break;
                            }else if(year==byear){
                                if(month>bmonth){
                                    break;
                                }else if(month==bmonth){
                                    if(day>=bday){
                                        break;
                                    }else{
                                        System.out.println("|\tInvalid, this person is not born yet!");
                                    }
                                }else{
                                    System.out.println("|\tInvalid, this person is not born yet!");
                                }
                            }else{
                                System.out.println("|\tInvalid, this person is not born yet!");
                            }
                        }else{
                            System.out.println("|\tInvalid Date. Please Enter a Valid Date!");
                        }
                    }else{
                        System.out.println("|\tFollow The Instruction use (/) & Enter Valid Date!");
                    }

                }catch(Exception e){
                    System.out.println("Error!");
                    input.next();
                }
            }
            String SQL = "INSERT INTO Citizen_information(C_fname, C_mname, C_lname, C_gender, C_birth_date, C_registered_date)Values (?,?,?,?,?,?)";
            config conf = new config();
            conf.addRecord(SQL, fname, mname, lname, gender, bdate, rdy);
        }
    }
}
