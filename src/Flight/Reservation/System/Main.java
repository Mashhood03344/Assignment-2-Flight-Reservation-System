package Flight.Reservation.System;

import java.util.*;
import java.util.regex.*;
import java.lang.Exception.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.text.ParseException;
import java.lang.Exception;
import java.io.File;
import java.io.FileWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;


//Creating all the exceptions here

class InvalidAgeException  extends Exception
{
    public InvalidAgeException (String str)
    {
        super(str);
    }
}

class InvalidGenderException  extends Exception {
    public InvalidGenderException(String str) {
        super(str);
    }
}

class InvalidMobileNumberException  extends Exception
{
    public InvalidMobileNumberException (String str)
    {
        super(str);
    }
}

class InvalidEmailException  extends Exception
{
    public InvalidEmailException (String str)
    {
        super(str);
    }
}

class InvalidFnameException  extends Exception
{
    public InvalidFnameException (String str)
    {
        super(str);
    }
}

class InvalidLnameException  extends Exception
{
    public InvalidLnameException (String str)
    {
        super(str);
    }
}


////////////////////////////////////////////////////////////////////////////////////////////////

class Global{
public int global=0;
}

class Glob{
    public int glob=0;
}

//Class for mobile number validation
class MobileNumberValidation{
    public static boolean validateNumber(String mobNumber)
    {

        if (mobNumber.length()==11) {

            if (mobNumber.matches("^((?:00|\\+)92)?(0?3(?:[0-46]\\d|55)\\d{7})$|^03\\d{9}$")) {
                return true;
            }

            if(mobNumber.matches("^03\\d{2}-\\d{7}$")){
                return true;
            }
        }
        return false;
    }
}

//class for emial address validation
class EmailValidation{
    public static boolean validateEmail(String email)
    {

        String regex = "^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$";

        Pattern pattern = Pattern.compile(regex);

        Matcher matcher = pattern.matcher(email);
       return matcher.matches();

    }
}

//class for validating the first and the last names
class NameValidation{
    public static boolean validateFirstName( String firstName )
    {
        //String regex = "^[A-Z|a-z][a-z]$";
       String regex="([A-Z][a-z]*)([\\\\s\\\\\\'-][A-Z][a-z]*)*";
        Pattern pattern = Pattern.compile(regex);

        Matcher matcher = pattern.matcher(firstName);
        return matcher.matches();
    } // end method validateFirstName

    // validate last name
    public static boolean validateLastName( String lastName )
    {
        return lastName.matches( "([A-Z][a-z]*)([\\\\s\\\\\\'-][A-Z][a-z]*)*" );
    } // end method validateLastName
}


class d_booking //class  for domestic booking
{
    //protected members
    protected int choice,src,dest;
    Scanner scan = new Scanner(System.in);
    Glob g = new Glob();

   //seats arrays for the option source 1 and destination 2
    ArrayList<Integer> economy_src1_desti2_seats=new ArrayList<Integer>(); //seats for economy class
    ArrayList<Integer> business_src1_desti2_seats=new ArrayList<Integer>(); //seats for business class

    //seats arrays for the option source 1 and destination 3
    ArrayList<Integer> economy_src1_desti3_seats=new ArrayList<Integer>(); //seats for economy class
    ArrayList<Integer> business_src1_desti3_seats=new ArrayList<Integer>(); //seats for business class

    //seats arrays for the option source 1 and destination 3
    ArrayList<Integer> economy_src1_desti4_seats=new ArrayList<Integer>(); //seats for economy class
    ArrayList<Integer> business_src1_desti4_seats=new ArrayList<Integer>(); //seats for business class

    //seats arrays for the option source 2 and destination 1
    ArrayList<Integer> economy_src2_desti1_seats=new ArrayList<Integer>(); //seats for economy class
    ArrayList<Integer> business_src2_desti1_seats=new ArrayList<Integer>(); //seats for business class

    //seats arrays for the option source 2 and destination 3
    ArrayList<Integer> economy_src2_desti3_seats=new ArrayList<Integer>(); //seats for economy class
    ArrayList<Integer> business_src2_desti3_seats=new ArrayList<Integer>(); //seats for business class

    //seats arrays for the option source 2 and destination 4
    ArrayList<Integer> economy_src2_desti4_seats=new ArrayList<Integer>(); //seats for economy class
    ArrayList<Integer> business_src2_desti4_seats=new ArrayList<Integer>(); //seats for business class

    //seats arrays for the option source 3 and destination 1
    ArrayList<Integer> economy_src3_desti1_seats=new ArrayList<Integer>(); //seats for economy class
    ArrayList<Integer> business_src3_desti1_seats=new ArrayList<Integer>(); //seats for business class

    //seats arrays for the option source 3 and destination 2
    ArrayList<Integer> economy_src3_desti2_seats=new ArrayList<Integer>(); //seats for economy class
    ArrayList<Integer> business_src3_desti2_seats=new ArrayList<Integer>(); //seats for business class

    //seats arrays for the option source 3 and destination 4
    ArrayList<Integer> economy_src3_desti4_seats=new ArrayList<Integer>(); //seats for economy class
    ArrayList<Integer> business_src3_desti4_seats=new ArrayList<Integer>(); //seats for business class

    //seats arrays for the option source 4 and destination 1
    ArrayList<Integer> economy_src4_desti1_seats=new ArrayList<Integer>(); //seats for economy class
    ArrayList<Integer> business_src4_desti1_seats=new ArrayList<Integer>(); //seats for business class

    //seats arrays for the option source 4 and destination 2
    ArrayList<Integer> economy_src4_desti2_seats=new ArrayList<Integer>(); //seats for economy class
    ArrayList<Integer> business_src4_desti2_seats=new ArrayList<Integer>(); //seats for business class

    //seats arrays for the option source 4 and destination 3
    ArrayList<Integer> economy_src4_desti3_seats=new ArrayList<Integer>(); //seats for economy class
    ArrayList<Integer> business_src4_desti3_seats=new ArrayList<Integer>(); //seats for business class


    //array list for keeping track of passengers
    ArrayList<Passenger> passengersList = new ArrayList<Passenger>();
    int passengerCurrCount=-1;

    //public member functions
    void settingSeats(){

        //1. setting up seats for source 1 and destination 2
        for (int i = 1; i <= 5; i++) {
            business_src1_desti2_seats.add(i);
        }

        for (int i = 6; i <= 25; i++) {
            economy_src1_desti2_seats.add(i);
        }

        //2. setting up seats for source 1 and destination 3
        for (int i = 1; i <= 5; i++) {
            business_src1_desti3_seats.add(i);
        }

        for (int i = 6; i <= 25; i++) {
            economy_src1_desti3_seats.add(i);
        }

        //3. setting up seats for source 1 and destination 4
        for (int i = 1; i <= 5; i++) {
            business_src1_desti4_seats.add(i);
        }

        for (int i = 6; i <= 25; i++) {
            economy_src1_desti4_seats.add(i);
        }

        //4. setting up seats for source 2 and destination 1
        for (int i = 1; i <= 5; i++) {
            business_src2_desti1_seats.add(i);
        }

        for (int i = 6; i <= 25; i++) {
            economy_src2_desti1_seats.add(i);
        }

        //5. setting up seats for source 2 and destination 3
        for (int i = 1; i <= 5; i++) {
            business_src2_desti3_seats.add(i);
        }

        for (int i = 6; i <= 25; i++) {
            economy_src2_desti3_seats.add(i);
        }

        //6. setting up seats for source 2 and destination 4
        for (int i = 1; i <= 5; i++) {
            business_src2_desti4_seats.add(i);
        }

        for (int i = 6; i <= 25; i++) {
            economy_src2_desti4_seats.add(i);
        }

        //7. setting up seats for source 3 and destination 4
        for (int i = 1; i <= 5; i++) {
            business_src3_desti4_seats.add(i);
        }

        for (int i = 6; i <= 25; i++) {
            economy_src3_desti4_seats.add(i);
        }

        //8. setting up seats for source 3 and destination 1
        for (int i = 1; i <= 5; i++) {
            business_src3_desti1_seats.add(i);
        }

        for (int i = 6; i <= 25; i++) {
            economy_src3_desti1_seats.add(i);
        }

        //9. setting up seats for source 3 and destination 2
        for (int i = 1; i <= 5; i++) {
            business_src3_desti2_seats.add(i);
        }

        for (int i = 6; i <= 25; i++) {
            economy_src3_desti2_seats.add(i);
        }

        //10. setting up seats for source 4 and destination 1
        for (int i = 1; i <= 5; i++) {
            business_src4_desti1_seats.add(i);
        }

        for (int i = 6; i <= 25; i++) {
            economy_src4_desti1_seats.add(i);
        }

        //11. setting up seats for source 4 and destination 2
        for (int i = 1; i <= 5; i++) {
            business_src4_desti2_seats.add(i);
        }

        for (int i = 6; i <= 25; i++) {
            economy_src4_desti2_seats.add(i);
        }

        //12. setting up seats for source 4 and destination 3
        for (int i = 1; i <= 5; i++) {
            business_src4_desti3_seats.add(i);
        }

        for (int i = 6; i <= 25; i++) {
            economy_src4_desti3_seats.add(i);
        }
    }

    void d_pnr()
    {

        g.glob++; // increment variable
        passengersList.get(passengerCurrCount).pnr=g.glob;
    }

    void addPassenger(){
        passengersList.add(new Passenger());
        passengerCurrCount++;
        d_pnr();
    }

    int j_detail() // function declaration and definition for domestic journey
    {

        System.out.println("\nEnter DateOfJourney(DD/MM/YYYY). Please enter a valid date.");
        passengersList.get(passengerCurrCount).doj=scan.next();

        SimpleDateFormat sdfrmt = new SimpleDateFormat("dd/MM/yyyy");
        sdfrmt.setLenient(false);

        try
        {
            Date javaDate = sdfrmt.parse( passengersList.get(passengerCurrCount).doj);
        }
        // Date format is invalid
        catch (ParseException e) {
            System.out.println("Invalid! Date: " + passengersList.get(passengerCurrCount).doj);
            return j_detail();
        }

        System.out.println();
        System.out.println("\1.Brisbane(1) \t\2.Sydney(2) \t\3.Melbourne(3) \t\4.Canberra(4)");
        System.out.println("");

        System.out.println("\tEnter Source" );
        src = scan.nextInt();
        System.out.println("\n\tEnter destination");
        dest=scan.nextInt();

        if(( src==1 &&  dest==2) )//condition
        {
            //checking the availability of the seats in the economy and business class
            if(economy_src1_desti2_seats.size()==0 && business_src1_desti2_seats.size()==0){

                char option;
                System.out.println("\nNo seats available in the business and economy class");
                System.out.println("Do you wish to make another Reservation (y/n):");
                option= scan.next().charAt(0);

                while ( (option!='y') && (option!='n') ){
                    System.out.println("Invalid! Please enter y (for yes) or n (for no)");
                    System.out.println("Enter again..");
                    option= scan.next().charAt(0);
                }

                if(option=='n'){
                    passengersList.remove(passengerCurrCount);
                    passengerCurrCount--;
                    g.glob--;
                    return 0;
                }

                else if(option=='y'){
                    return j_detail();
                }

            }

            //Printing the process if these are no seats available in the economy class
            if(economy_src1_desti2_seats.size()==0){
                System.out.println("\nNo seats are available in the Economy class. Only Business class seats are avaiable");
                System.out.println("Do you wish to make another Reservation (y/n/e)");
                System.out.println("Enter 'y' to make another Reservation. Enter 'n' to continue with the business class booking");
                System.out.println("Enter e for exit");
                char option= scan.next().charAt(0);

                while ( (option!='y') && (option!='n' && (option!='e')) ){
                    System.out.println("Invalid! Please enter y (for yes) or n (for no) or e (for exit)");
                    System.out.println("Enter again..");
                    option= scan.next().charAt(0);
                }

                if(option=='e'){
                    passengersList.remove(passengerCurrCount);
                    passengerCurrCount--;
                    g.glob--;
                    return 0;
                }

                else if(option=='y'){
                    return j_detail();
                }
            }

            //Printing the process if these are no seats available in the business class
            if(business_src1_desti2_seats.size()==0){
                System.out.println("\nNo seats are available in the Business class. Only Economy class seats are avaiable");
                System.out.println("Do you wish to make another Reservation (y/n/e)");
                System.out.println("Enter 'y' to make another Reservation. Enter 'n' to continue with the Economy class booking");
                System.out.println("Enter e to exit");
                char option= scan.next().charAt(0);

                while ( (option!='y') && (option!='n') && (option!='e') ){
                    System.out.println("Invalid! Please enter y (for yes) or n (for no) or e (for exit)");
                    System.out.println("Enter again..");
                    option= scan.next().charAt(0);
                }

                if(option=='e'){
                    passengersList.remove(passengerCurrCount);
                    passengerCurrCount--;
                    g.glob--;
                    return 0;
                }

                else if(option=='y'){
                    return j_detail();
                }
            }

            System.out.println("\n\t \t \t \t \t \tFlights Found");
            System.out.println("");

            if( (business_src1_desti2_seats.size()!=0) && (economy_src1_desti2_seats.size()!=0) ){
                System.out.println("Airline:\t \tDeparture:\tArrival:\tPrice:\t\tCategory");
                System.out.println("1.Qantas(1)\t \t08:00\t\t11:05\t\tRs.5000\t\tEconomy");
                System.out.println("2.Fly Dubai(2)\t14:00\t\t17:05\t\tRs.5500\t\tEconomy");
                System.out.println("3.Go Air(3)\t \t19:00\t\t22:05\t\tRs.6000\t\tEconomy");

                System.out.println("");
                System.out.println("Airline:\t \tDeparture:\tArrival:\tPrice:\t\tCategory");
                System.out.println("4.Qantas(1)\t \t08:00\t\t11:05\t\tRs.7000\t\tBusiness");
                System.out.println("5.Fly Dubai(2)\t14:00\t\t17:05\t\tRs.7500\t\tBusiness");
                System.out.println("6.Go Air(3)\t \t19:00\t\t22:05\t\tRs.8000\t\tBusiness");

                //getting the flight option from the user
                System.out.println("\nEnter your Flight choice:");
                choice=scan.nextInt();

                //validating the choice
                while(choice<1 || choice>6){
                    System.out.println("Invalid! The choice can only be 1,2,3,4,5 or 6");
                    System.out.println("Enter again..");
                    choice=scan.nextInt();
                }

                //condition for selection from Economy class
                if(choice>=1 && choice<4){
                    //displaying the Availaable Business class seats
                    System.out.println("\nSeat numbers available for Economy class booking\n");
                    for (int i = 0; i < economy_src1_desti2_seats.size(); i++) {
                        System.out.println("Seat No.: "+economy_src1_desti2_seats.get(i));
                    }

                    //getting the seat number choice from the user
                    System.out.println("\nEnter Seat No.:");
                    passengersList.get(passengerCurrCount).seat_no=scan.nextInt();

                    //validating the seat number choice
                    boolean found=false;
                    while(found!=true){

                        for (int i = 0; i < economy_src1_desti2_seats.size(); i++) {
                            //finding the seat and removing the seat at the same time in this condition
                            if(passengersList.get(passengerCurrCount).seat_no==economy_src1_desti2_seats.get(i)){
                                found=true;
                                economy_src1_desti2_seats.remove(i);

                                //after removing sorting the arraylist
                                Collections.sort(economy_src1_desti2_seats);
                            }
                        }

                        if(found==false){
                            System.out.println("Invalid! Please select a seat from the above available seats");
                            passengersList.get(passengerCurrCount).seat_no=scan.nextInt();
                        }
                    }

                    //The selected seat is being removed from the arraylist successfully
                }

                //condition for selection from the business class
                if(choice>3 && choice<7){
                    //displaying the Availaable Business class seats
                    System.out.println("\nSeat numbers available for business class booking\n");
                    for (int i = 0; i < business_src1_desti2_seats.size(); i++) {
                        System.out.println("Seat No.: "+business_src1_desti2_seats.get(i));
                    }

                    //getting the seat number choice from the user
                    System.out.println("\nEnter Seat No.:");
                    passengersList.get(passengerCurrCount).seat_no=scan.nextInt();

                    //validating the seat number choice
                    boolean found=false;
                    while(found!=true){

                        for (int i = 0; i < business_src1_desti2_seats.size(); i++) {
                            //finding the seat and removing the seat at the same time in this condition
                            if(passengersList.get(passengerCurrCount).seat_no==business_src1_desti2_seats.get(i)){
                                found=true;
                                business_src1_desti2_seats.remove(i);

                                //after removing sorting the arraylist
                                Collections.sort(business_src1_desti2_seats);
                            }
                        }

                        if(found==false){
                            System.out.println("Invalid! Please select a seat from the above available seats");
                            passengersList.get(passengerCurrCount).seat_no=scan.nextInt();
                        }
                    }

                    //The selected seat is being removed from the arraylist successfully
                }
            }

            if(economy_src1_desti2_seats.size()!=0 && business_src1_desti2_seats.size()==0) {
                System.out.println("Airline:\t \tDeparture:\tArrival:\tPrice:\t\tCategory");
                System.out.println("1.Qantas(1)\t \t08:00\t\t11:05\t\tRs.5000\t\tEconomy");
                System.out.println("2.Fly Dubai(2)\t14:00\t\t17:05\t\tRs.5500\t\tEconomy");
                System.out.println("3.Go Air(3)\t \t19:00\t\t22:05\t\tRs.6000\t\tEconomy");
                System.out.println("");

                //getting the flight option from the user
                System.out.println("\nEnter your Flight choice:");
                choice=scan.nextInt();

                //validating the choice
                while(choice<1 || choice>3){
                    System.out.println("Invalid! The choice can only be 1,2 or 3");
                    System.out.println("Enter again..");
                    choice=scan.nextInt();
                }

                //displaying the Availaable Business class seats
                System.out.println("\nSeat numbers available for Economy class booking\n");
                for (int i = 0; i < economy_src1_desti2_seats.size(); i++) {
                    System.out.println("Seat No.: "+economy_src1_desti2_seats.get(i));
                }

                //getting the seat number choice from the user
                System.out.println("\nEnter Seat No.:");
                passengersList.get(passengerCurrCount).seat_no=scan.nextInt();

                //validating the seat number choice
                boolean found=false;
                while(found!=true){

                    for (int i = 0; i < economy_src1_desti2_seats.size(); i++) {
                        //finding the seat and removing the seat at the same time in this condition
                        if(passengersList.get(passengerCurrCount).seat_no==economy_src1_desti2_seats.get(i)){
                            found=true;
                            economy_src1_desti2_seats.remove(i);

                            //after removing sorting the arraylist
                            Collections.sort(economy_src1_desti2_seats);
                        }
                    }

                    if(found==false){
                        System.out.println("Invalid! Please select a seat from the above available seats");
                        passengersList.get(passengerCurrCount).seat_no=scan.nextInt();
                    }
                }

                //The selected seat is being removed from the arraylist successfully
            }

            if(business_src1_desti2_seats.size()!=0 && economy_src1_desti2_seats.size()==0) {
                System.out.println("Airline:\t \tDeparture:\tArrival:\tPrice:\t\tCategory");
                System.out.println("4.Qantas(1)\t \t08:00\t\t11:05\t\tRs.7000\t\tBusiness");
                System.out.println("5.Fly Dubai(2)\t14:00\t\t17:05\t\tRs.7500\t\tBusiness");
                System.out.println("6.Go Air(3)\t \t19:00\t\t22:05\t\tRs.8000\t\tBusiness");

                //getting the flight option from the user
                System.out.println("\nEnter your Flight choice:");
                choice=scan.nextInt();

                //validating the choice
                while(choice<4 || choice>6){
                    System.out.println("Invalid! The choice can only be 4,5 or 6");
                    System.out.println("Enter again..");
                    choice=scan.nextInt();
                }

                //displaying the Availaable Business class seats
                System.out.println("\nSeat numbers available for business class booking\n");
                for (int i = 0; i < business_src1_desti2_seats.size(); i++) {
                    System.out.println("Seat No.: "+business_src1_desti2_seats.get(i));
                }

                //getting the seat number choice from the user
                System.out.println("\nEnter Seat No.:");
                passengersList.get(passengerCurrCount).seat_no=scan.nextInt();

                //validating the seat number choice
                boolean found=false;
                while(found!=true){

                    for (int i = 0; i < business_src1_desti2_seats.size(); i++) {
                        //finding the seat and removing the seat at the same time in this condition
                        if(passengersList.get(passengerCurrCount).seat_no==business_src1_desti2_seats.get(i)){
                            found=true;
                            business_src1_desti2_seats.remove(i);

                            //after removing sorting the arraylist
                            Collections.sort(business_src1_desti2_seats);
                        }
                    }

                    if(found==false){
                        System.out.println("Invalid! Please select a seat from the above available seats");
                        passengersList.get(passengerCurrCount).seat_no=scan.nextInt();
                    }
                }

                //The selected seat is being removed from the arraylist successfully
            }

            //setting the src and dest variables of the passenger class because it will later help in
            //identifying in which arraylist to add the cancelled seat (seat cancelled by the passenger)
            passengersList.get(passengerCurrCount).src=1;
            passengersList.get(passengerCurrCount).dest=2;
            passengersList.get(passengerCurrCount).source="Brisbane";
            passengersList.get(passengerCurrCount).destination="Sydney";
        }

        else if( ( src==1 &&  dest==3) )//condition
        {
            //original code
            /*System.out.println("\n\t \t \t \t \t \tFlights Found");
            System.out.println("");
            System.out.println("Airline:\t \tDeparture:\tArrival:\tPrice:\t\tCategory");
            System.out.println("\1.Qantas(1)\t \t08:00\t\t11:05\t\tRs.5000\t\tEconomy");
            System.out.println("\2.Fly Dubai(2)\t14:00\t\t17:05\t\tRs.5500\t\tEconomy");
            System.out.println("\3.Go Air(3)\t \t19:00\t\t22:05\t\tRs.6000\t\tEconomy");

            System.out.println("");
            System.out.println("Airline:\t \tDeparture:\tArrival:\tPrice:\t\tCategory");
            System.out.println("\1.Qantas(1)\t \t08:00\t\t11:05\t\tRs.7000\t\tBusiness");
            System.out.println("\2.Fly Dubai(2)\t14:00\t\t17:05\t\tRs.7500\t\tBusiness");
            System.out.println("\3.Go Air(3)\t \t19:00\t\t22:05\t\tRs.8000\t\tBusiness");
            */
            ///////////////////////////////////////////////////////////////////////////////

            //checking the availability of the seats in the economy and business class
            if(economy_src1_desti3_seats.size()==0 && business_src1_desti3_seats.size()==0){

                char option;
                System.out.println("\nNo seats available in the business and economy class");
                System.out.println("Do you wish to make another Reservation (y/n):");
                option= scan.next().charAt(0);

                while ( (option!='y') && (option!='n') ){
                    System.out.println("Invalid! Please enter y (for yes) or n (for no)");
                    System.out.println("Enter again..");
                    option= scan.next().charAt(0);
                }

                if(option=='n'){
                    passengersList.remove(passengerCurrCount);
                    passengerCurrCount--;
                    g.glob--;
                    return 0;
                }

                else if(option=='y'){
                    return j_detail();
                }

            }

            //Printing the process if these are no seats available in the economy class
            if(economy_src1_desti3_seats.size()==0){
                System.out.println("\nNo seats are available in the Economy class. Only Business class seats are avaiable");
                System.out.println("Do you wish to make another Reservation (y/n/e)");
                System.out.println("Enter 'y' to make another Reservation. Enter 'n' to continue with the business class booking");
                System.out.println("Enter e for exit");
                char option= scan.next().charAt(0);

                while ( (option!='y') && (option!='n' && (option!='e')) ){
                    System.out.println("Invalid! Please enter y (for yes) or n (for no) or e (for exit)");
                    System.out.println("Enter again..");
                    option= scan.next().charAt(0);
                }

                if(option=='e'){
                    passengersList.remove(passengerCurrCount);
                    passengerCurrCount--;
                    g.glob--;
                    return 0;
                }

                else if(option=='y'){
                    return j_detail();
                }
            }

            //Printing the process if these are no seats available in the business class
            if(business_src1_desti3_seats.size()==0){
                System.out.println("\nNo seats are available in the Business class. Only Economy class seats are avaiable");
                System.out.println("Do you wish to make another Reservation (y/n/e)");
                System.out.println("Enter 'y' to make another Reservation. Enter 'n' to continue with the Economy class booking");
                System.out.println("Enter e to exit");
                char option= scan.next().charAt(0);

                while ( (option!='y') && (option!='n') && (option!='e') ){
                    System.out.println("Invalid! Please enter y (for yes) or n (for no) or e (for exit)");
                    System.out.println("Enter again..");
                    option= scan.next().charAt(0);
                }

                if(option=='e'){
                    passengersList.remove(passengerCurrCount);
                    passengerCurrCount--;
                    g.glob--;
                    return 0;
                }

                else if(option=='y'){
                    return j_detail();
                }
            }

            System.out.println("\n\t \t \t \t \t \tFlights Found");
            System.out.println("");

            if( (business_src1_desti3_seats.size()!=0) && (economy_src1_desti3_seats.size()!=0) ){
                System.out.println("Airline:\t \tDeparture:\tArrival:\tPrice:\t\tCategory");
                System.out.println("1.Qantas(1)\t \t08:00\t\t11:05\t\tRs.5000\t\tEconomy");
                System.out.println("2.Fly Dubai(2)\t14:00\t\t17:05\t\tRs.5500\t\tEconomy");
                System.out.println("3.Go Air(3)\t \t19:00\t\t22:05\t\tRs.6000\t\tEconomy");

                System.out.println("");
                System.out.println("Airline:\t \tDeparture:\tArrival:\tPrice:\t\tCategory");
                System.out.println("4.Qantas(1)\t \t08:00\t\t11:05\t\tRs.7000\t\tBusiness");
                System.out.println("5.Fly Dubai(2)\t14:00\t\t17:05\t\tRs.7500\t\tBusiness");
                System.out.println("6.Go Air(3)\t \t19:00\t\t22:05\t\tRs.8000\t\tBusiness");

                //getting the flight option from the user
                System.out.println("\nEnter your Flight choice:");
                choice=scan.nextInt();

                //validating the choice
                while(choice<1 || choice>6){
                    System.out.println("Invalid! The choice can only be 1,2,3,4,5 or 6");
                    System.out.println("Enter again..");
                    choice=scan.nextInt();
                }

                //condition for selection from Economy class
                if(choice>=1 && choice<4){
                    //displaying the Availaable Business class seats
                    System.out.println("\nSeat numbers available for Economy class booking\n");
                    for (int i = 0; i < economy_src1_desti3_seats.size(); i++) {
                        System.out.println("Seat No.: "+economy_src1_desti3_seats.get(i));
                    }

                    //getting the seat number choice from the user
                    System.out.println("\nEnter Seat No.:");
                    passengersList.get(passengerCurrCount).seat_no=scan.nextInt();

                    //validating the seat number choice
                    boolean found=false;
                    while(found!=true){

                        for (int i = 0; i < economy_src1_desti3_seats.size(); i++) {
                            //finding the seat and removing the seat at the same time in this condition
                            if(passengersList.get(passengerCurrCount).seat_no==economy_src1_desti3_seats.get(i)){
                                found=true;
                                economy_src1_desti3_seats.remove(i);

                                //after removing sorting the arraylist
                                Collections.sort(economy_src1_desti3_seats);
                            }
                        }

                        if(found==false){
                            System.out.println("Invalid! Please select a seat from the above available seats");
                            passengersList.get(passengerCurrCount).seat_no=scan.nextInt();
                        }
                    }

                    //The selected seat is being removed from the arraylist successfully
                }

                //condition for selection from the business class
                if(choice>3 && choice<7){
                    //displaying the Availaable Business class seats
                    System.out.println("\nSeat numbers available for business class booking\n");
                    for (int i = 0; i < business_src1_desti3_seats.size(); i++) {
                        System.out.println("Seat No.: "+business_src1_desti3_seats.get(i));
                    }

                    //getting the seat number choice from the user
                    System.out.println("\nEnter Seat No.:");
                    passengersList.get(passengerCurrCount).seat_no=scan.nextInt();

                    //validating the seat number choice
                    boolean found=false;
                    while(found!=true){

                        for (int i = 0; i < business_src1_desti3_seats.size(); i++) {
                            //finding the seat and removing the seat at the same time in this condition
                            if(passengersList.get(passengerCurrCount).seat_no==business_src1_desti3_seats.get(i)){
                                found=true;
                                business_src1_desti3_seats.remove(i);

                                //after removing sorting the arraylist
                                Collections.sort(business_src1_desti3_seats);
                            }
                        }

                        if(found==false){
                            System.out.println("Invalid! Please select a seat from the above available seats");
                            passengersList.get(passengerCurrCount).seat_no=scan.nextInt();
                        }
                    }

                    //The selected seat is being removed from the arraylist successfully
                }
            }

            if(economy_src1_desti3_seats.size()!=0 && business_src1_desti3_seats.size()==0) {
                System.out.println("Airline:\t \tDeparture:\tArrival:\tPrice:\t\tCategory");
                System.out.println("1.Qantas(1)\t \t08:00\t\t11:05\t\tRs.5000\t\tEconomy");
                System.out.println("2.Fly Dubai(2)\t14:00\t\t17:05\t\tRs.5500\t\tEconomy");
                System.out.println("3.Go Air(3)\t \t19:00\t\t22:05\t\tRs.6000\t\tEconomy");
                System.out.println("");

                //getting the flight option from the user
                System.out.println("\nEnter your Flight choice:");
                choice=scan.nextInt();

                //validating the choice
                while(choice<1 || choice>3){
                    System.out.println("Invalid! The choice can only be 1,2 or 3");
                    System.out.println("Enter again..");
                    choice=scan.nextInt();
                }

                //displaying the Availaable Business class seats
                System.out.println("\nSeat numbers available for Economy class booking\n");
                for (int i = 0; i < economy_src1_desti3_seats.size(); i++) {
                    System.out.println("Seat No.: "+economy_src1_desti3_seats.get(i));
                }

                //getting the seat number choice from the user
                System.out.println("\nEnter Seat No.:");
                passengersList.get(passengerCurrCount).seat_no=scan.nextInt();

                //validating the seat number choice
                boolean found=false;
                while(found!=true){

                    for (int i = 0; i < economy_src1_desti3_seats.size(); i++) {
                        //finding the seat and removing the seat at the same time in this condition
                        if(passengersList.get(passengerCurrCount).seat_no==economy_src1_desti3_seats.get(i)){
                            found=true;
                            economy_src1_desti3_seats.remove(i);

                            //after removing sorting the arraylist
                            Collections.sort(economy_src1_desti3_seats);
                        }
                    }

                    if(found==false){
                        System.out.println("Invalid! Please select a seat from the above available seats");
                        passengersList.get(passengerCurrCount).seat_no=scan.nextInt();
                    }
                }

                //The selected seat is being removed from the arraylist successfully
            }

            if(business_src1_desti3_seats.size()!=0 && economy_src1_desti3_seats.size()==0) {
                System.out.println("Airline:\t \tDeparture:\tArrival:\tPrice:\t\tCategory");
                System.out.println("4.Qantas(1)\t \t08:00\t\t11:05\t\tRs.7000\t\tBusiness");
                System.out.println("5.Fly Dubai(2)\t14:00\t\t17:05\t\tRs.7500\t\tBusiness");
                System.out.println("6.Go Air(3)\t \t19:00\t\t22:05\t\tRs.8000\t\tBusiness");

                //getting the flight option from the user
                System.out.println("\nEnter your Flight choice:");
                choice=scan.nextInt();

                //validating the choice
                while(choice<4 || choice>6){
                    System.out.println("Invalid! The choice can only be 4,5 or 6");
                    System.out.println("Enter again..");
                    choice=scan.nextInt();
                }

                //displaying the Availaable Business class seats
                System.out.println("\nSeat numbers available for business class booking\n");
                for (int i = 0; i < business_src1_desti3_seats.size(); i++) {
                    System.out.println("Seat No.: "+business_src1_desti3_seats.get(i));
                }

                //getting the seat number choice from the user
                System.out.println("\nEnter Seat No.:");
                passengersList.get(passengerCurrCount).seat_no=scan.nextInt();

                //validating the seat number choice
                boolean found=false;
                while(found!=true){

                    for (int i = 0; i < business_src1_desti3_seats.size(); i++) {
                        //finding the seat and removing the seat at the same time in this condition
                        if(passengersList.get(passengerCurrCount).seat_no==business_src1_desti3_seats.get(i)){
                            found=true;
                            business_src1_desti3_seats.remove(i);

                            //after removing sorting the arraylist
                            Collections.sort(business_src1_desti3_seats);
                        }
                    }

                    if(found==false){
                        System.out.println("Invalid! Please select a seat from the above available seats");
                        passengersList.get(passengerCurrCount).seat_no=scan.nextInt();
                    }
                }

                //The selected seat is being removed from the arraylist successfully
            }

            //setting the src and dest variables of the passenger class because it will later help in
            //identifying in which arraylist to add the cancelled seat (seat cancelled by the passenger)
            passengersList.get(passengerCurrCount).src=1;
            passengersList.get(passengerCurrCount).dest=3;
            passengersList.get(passengerCurrCount).source="Brisbane";
            passengersList.get(passengerCurrCount).destination="Melbourne";
        }

        else if( ( src==1 &&  dest==4) )//condition
        {
            //original code
            /*System.out.println("\n\t \t \t \t \t \tFlights Found");
            System.out.println("");
            System.out.println("Airline:\t \tDeparture:\tArrival:\tPrice:\t\tCategory");
            System.out.println("\1.Qantas(1)\t \t08:00\t\t11:05\t\tRs.4000\t\tEconomy");
            System.out.println("\2.Fly Dubai(2)\t14:00\t\t17:05\t\tRs.4250\t\tEconomy");
            System.out.println("\3.Go Air(3)\t \t19:00\t\t22:05\t\tRs.6100\t\tEconomy");

            System.out.println("");
            System.out.println("Airline:\t \tDeparture:\tArrival:\tPrice:\t\tCategory");
            System.out.println("\1.Qantas(1)\t \t08:00\t\t11:05\t\tRs.6000\t\tBusiness");
            System.out.println("\2.Fly Dubai(2)\t14:00\t\t17:05\t\tRs.6250\t\tBusiness");
            System.out.println("\3.Go Air(3)\t \t19:00\t\t22:05\t\tRs.8100\t\tBusiness");
            */
            ////////////////////////////////////////////////////////////////////////////

            //checking the availability of the seats in the economy and business class
            if(economy_src1_desti4_seats.size()==0 && business_src1_desti4_seats.size()==0){

                char option;
                System.out.println("\nNo seats available in the business and economy class");
                System.out.println("Do you wish to make another Reservation (y/n):");
                option= scan.next().charAt(0);

                while ( (option!='y') && (option!='n') ){
                    System.out.println("Invalid! Please enter y (for yes) or n (for no)");
                    System.out.println("Enter again..");
                    option= scan.next().charAt(0);
                }

                if(option=='n'){
                    passengersList.remove(passengerCurrCount);
                    passengerCurrCount--;
                    g.glob--;
                    return 0;
                }

                else if(option=='y'){
                    return j_detail();
                }

            }

            //Printing the process if these are no seats available in the economy class
            if(economy_src1_desti4_seats.size()==0){
                System.out.println("\nNo seats are available in the Economy class. Only Business class seats are avaiable");
                System.out.println("Do you wish to make another Reservation (y/n/e)");
                System.out.println("Enter 'y' to make another Reservation. Enter 'n' to continue with the business class booking");
                System.out.println("Enter e for exit");
                char option= scan.next().charAt(0);

                while ( (option!='y') && (option!='n' && (option!='e')) ){
                    System.out.println("Invalid! Please enter y (for yes) or n (for no) or e (for exit)");
                    System.out.println("Enter again..");
                    option= scan.next().charAt(0);
                }

                if(option=='e'){
                    passengersList.remove(passengerCurrCount);
                    passengerCurrCount--;
                    g.glob--;
                    return 0;
                }

                else if(option=='y'){
                    return j_detail();
                }
            }

            //Printing the process if these are no seats available in the business class
            if(business_src1_desti4_seats.size()==0){
                System.out.println("\nNo seats are available in the Business class. Only Economy class seats are avaiable");
                System.out.println("Do you wish to make another Reservation (y/n/e)");
                System.out.println("Enter 'y' to make another Reservation. Enter 'n' to continue with the Economy class booking");
                System.out.println("Enter e to exit");
                char option= scan.next().charAt(0);

                while ( (option!='y') && (option!='n') && (option!='e') ){
                    System.out.println("Invalid! Please enter y (for yes) or n (for no) or e (for exit)");
                    System.out.println("Enter again..");
                    option= scan.next().charAt(0);
                }

                if(option=='e'){
                    passengersList.remove(passengerCurrCount);
                    passengerCurrCount--;
                    g.glob--;
                    return 0;
                }

                else if(option=='y'){
                    return j_detail();
                }
            }

            System.out.println("\n\t \t \t \t \t \tFlights Found");
            System.out.println("");

            if( (business_src1_desti4_seats.size()!=0) && (economy_src1_desti4_seats.size()!=0) ){
                System.out.println("Airline:\t \tDeparture:\tArrival:\tPrice:\t\tCategory");
                System.out.println("\1.Qantas(1)\t \t08:00\t\t11:05\t\tRs.4000\t\tEconomy");
                System.out.println("\2.Fly Dubai(2)\t14:00\t\t17:05\t\tRs.4250\t\tEconomy");
                System.out.println("\3.Go Air(3)\t \t19:00\t\t22:05\t\tRs.6100\t\tEconomy");

                System.out.println("");
                System.out.println("Airline:\t \tDeparture:\tArrival:\tPrice:\t\tCategory");
                System.out.println("\4.Qantas(1)\t \t08:00\t\t11:05\t\tRs.6000\t\tBusiness");
                System.out.println("\5.Fly Dubai(2)\t14:00\t\t17:05\t\tRs.6250\t\tBusiness");
                System.out.println("\6.Go Air(3)\t \t19:00\t\t22:05\t\tRs.8100\t\tBusiness");

                //getting the flight option from the user
                System.out.println("\nEnter your Flight choice:");
                choice=scan.nextInt();

                //validating the choice
                while(choice<1 || choice>6){
                    System.out.println("Invalid! The choice can only be 1,2,3,4,5 or 6");
                    System.out.println("Enter again..");
                    choice=scan.nextInt();
                }

                //condition for selection from Economy class
                if(choice>=1 && choice<4){
                    //displaying the Availaable Business class seats
                    System.out.println("\nSeat numbers available for Economy class booking\n");
                    for (int i = 0; i < economy_src1_desti4_seats.size(); i++) {
                        System.out.println("Seat No.: "+economy_src1_desti4_seats.get(i));
                    }

                    //getting the seat number choice from the user
                    System.out.println("\nEnter Seat No.:");
                    passengersList.get(passengerCurrCount).seat_no=scan.nextInt();

                    //validating the seat number choice
                    boolean found=false;
                    while(found!=true){

                        for (int i = 0; i < economy_src1_desti4_seats.size(); i++) {
                            //finding the seat and removing the seat at the same time in this condition
                            if(passengersList.get(passengerCurrCount).seat_no==economy_src1_desti4_seats.get(i)){
                                found=true;
                                economy_src1_desti4_seats.remove(i);

                                //after removing sorting the arraylist
                                Collections.sort(economy_src1_desti4_seats);
                            }
                        }

                        if(found==false){
                            System.out.println("Invalid! Please select a seat from the above available seats");
                            passengersList.get(passengerCurrCount).seat_no=scan.nextInt();
                        }
                    }

                    //The selected seat is being removed from the arraylist successfully
                }

                //condition for selection from the business class
                if(choice>3 && choice<7){
                    //displaying the Availaable Business class seats
                    System.out.println("\nSeat numbers available for business class booking\n");
                    for (int i = 0; i < business_src1_desti4_seats.size(); i++) {
                        System.out.println("Seat No.: "+business_src1_desti4_seats.get(i));
                    }

                    //getting the seat number choice from the user
                    System.out.println("\nEnter Seat No.:");
                    passengersList.get(passengerCurrCount).seat_no=scan.nextInt();

                    //validating the seat number choice
                    boolean found=false;
                    while(found!=true){

                        for (int i = 0; i < business_src1_desti4_seats.size(); i++) {
                            //finding the seat and removing the seat at the same time in this condition
                            if(passengersList.get(passengerCurrCount).seat_no==business_src1_desti4_seats.get(i)){
                                found=true;
                                business_src1_desti4_seats.remove(i);

                                //after removing sorting the arraylist
                                Collections.sort(business_src1_desti4_seats);
                            }
                        }

                        if(found==false){
                            System.out.println("Invalid! Please select a seat from the above available seats");
                            passengersList.get(passengerCurrCount).seat_no=scan.nextInt();
                        }
                    }

                    //The selected seat is being removed from the arraylist successfully
                }
            }

            if(economy_src1_desti4_seats.size()!=0 && business_src1_desti4_seats.size()==0) {
                System.out.println("Airline:\t \tDeparture:\tArrival:\tPrice:\t\tCategory");
                System.out.println("\1.Qantas(1)\t \t08:00\t\t11:05\t\tRs.4000\t\tEconomy");
                System.out.println("\2.Fly Dubai(2)\t14:00\t\t17:05\t\tRs.4250\t\tEconomy");
                System.out.println("\3.Go Air(3)\t \t19:00\t\t22:05\t\tRs.6100\t\tEconomy");
                System.out.println("");

                //getting the flight option from the user
                System.out.println("\nEnter your Flight choice:");
                choice=scan.nextInt();

                //validating the choice
                while(choice<1 || choice>3){
                    System.out.println("Invalid! The choice can only be 1,2 or 3");
                    System.out.println("Enter again..");
                    choice=scan.nextInt();
                }

                //displaying the Availaable Business class seats
                System.out.println("\nSeat numbers available for Economy class booking\n");
                for (int i = 0; i < economy_src1_desti4_seats.size(); i++) {
                    System.out.println("Seat No.: "+economy_src1_desti4_seats.get(i));
                }

                //getting the seat number choice from the user
                System.out.println("\nEnter Seat No.:");
                passengersList.get(passengerCurrCount).seat_no=scan.nextInt();

                //validating the seat number choice
                boolean found=false;
                while(found!=true){

                    for (int i = 0; i < economy_src1_desti4_seats.size(); i++) {
                        //finding the seat and removing the seat at the same time in this condition
                        if(passengersList.get(passengerCurrCount).seat_no==economy_src1_desti4_seats.get(i)){
                            found=true;
                            economy_src1_desti4_seats.remove(i);

                            //after removing sorting the arraylist
                            Collections.sort(economy_src1_desti4_seats);
                        }
                    }

                    if(found==false){
                        System.out.println("Invalid! Please select a seat from the above available seats");
                        passengersList.get(passengerCurrCount).seat_no=scan.nextInt();
                    }
                }

                //The selected seat is being removed from the arraylist successfully
            }

            if(business_src1_desti4_seats.size()!=0 && economy_src1_desti4_seats.size()==0) {
                System.out.println("Airline:\t \tDeparture:\tArrival:\tPrice:\t\tCategory");
                System.out.println("\4.Qantas(1)\t \t08:00\t\t11:05\t\tRs.6000\t\tBusiness");
                System.out.println("\5.Fly Dubai(2)\t14:00\t\t17:05\t\tRs.6250\t\tBusiness");
                System.out.println("\6.Go Air(3)\t \t19:00\t\t22:05\t\tRs.8100\t\tBusiness");

                //getting the flight option from the user
                System.out.println("\nEnter your Flight choice:");
                choice=scan.nextInt();

                //validating the choice
                while(choice<4 || choice>6){
                    System.out.println("Invalid! The choice can only be 4,5 or 6");
                    System.out.println("Enter again..");
                    choice=scan.nextInt();
                }

                //displaying the Availaable Business class seats
                System.out.println("\nSeat numbers available for business class booking\n");
                for (int i = 0; i < business_src1_desti4_seats.size(); i++) {
                    System.out.println("Seat No.: "+business_src1_desti4_seats.get(i));
                }

                //getting the seat number choice from the user
                System.out.println("\nEnter Seat No.:");
                passengersList.get(passengerCurrCount).seat_no=scan.nextInt();

                //validating the seat number choice
                boolean found=false;
                while(found!=true){

                    for (int i = 0; i < business_src1_desti4_seats.size(); i++) {
                        //finding the seat and removing the seat at the same time in this condition
                        if(passengersList.get(passengerCurrCount).seat_no==business_src1_desti4_seats.get(i)){
                            found=true;
                            business_src1_desti4_seats.remove(i);

                            //after removing sorting the arraylist
                            Collections.sort(business_src1_desti4_seats);
                        }
                    }

                    if(found==false){
                        System.out.println("Invalid! Please select a seat from the above available seats");
                        passengersList.get(passengerCurrCount).seat_no=scan.nextInt();
                    }
                }

                //The selected seat is being removed from the arraylist successfully
            }

            //setting the src and dest variables of the passenger class because it will later help in
            //identifying in which arraylist to add the cancelled seat (seat cancelled by the passenger)
            passengersList.get(passengerCurrCount).src=1;
            passengersList.get(passengerCurrCount).dest=4;
            passengersList.get(passengerCurrCount).source="Brisbane";
            passengersList.get(passengerCurrCount).destination="Canberra";
        }

        else if( src==2 &&  dest==1){

        //checking the availability of the seats in the economy and business class
        if(economy_src2_desti1_seats.size()==0 && business_src2_desti1_seats.size()==0){

            char option;
            System.out.println("\nNo seats available in the business and economy class");
            System.out.println("Do you wish to make another Reservation (y/n):");
            option= scan.next().charAt(0);

            while ( (option!='y') && (option!='n') ){
                System.out.println("Invalid! Please enter y (for yes) or n (for no)");
                System.out.println("Enter again..");
                option= scan.next().charAt(0);
            }

            if(option=='n'){
                passengersList.remove(passengerCurrCount);
                passengerCurrCount--;
                g.glob--;
                return 0;
            }

            else if(option=='y'){
                return j_detail();
            }

        }

        //Printing the process if these are no seats available in the economy class
        if(economy_src2_desti1_seats.size()==0){
            System.out.println("\nNo seats are available in the Economy class. Only Business class seats are avaiable");
            System.out.println("Do you wish to make another Reservation (y/n/e)");
            System.out.println("Enter 'y' to make another Reservation. Enter 'n' to continue with the business class booking");
            System.out.println("Enter e for exit");
            char option= scan.next().charAt(0);

            while ( (option!='y') && (option!='n' && (option!='e')) ){
                System.out.println("Invalid! Please enter y (for yes) or n (for no) or e (for exit)");
                System.out.println("Enter again..");
                option= scan.next().charAt(0);
            }

            if(option=='e'){
                passengersList.remove(passengerCurrCount);
                passengerCurrCount--;
                g.glob--;
                return 0;
            }

            else if(option=='y'){
                return j_detail();
            }
        }

        //Printing the process if these are no seats available in the business class
        if(business_src2_desti1_seats.size()==0){
            System.out.println("\nNo seats are available in the Business class. Only Economy class seats are avaiable");
            System.out.println("Do you wish to make another Reservation (y/n/e)");
            System.out.println("Enter 'y' to make another Reservation. Enter 'n' to continue with the Economy class booking");
            System.out.println("Enter e to exit");
            char option= scan.next().charAt(0);

            while ( (option!='y') && (option!='n') && (option!='e') ){
                System.out.println("Invalid! Please enter y (for yes) or n (for no) or e (for exit)");
                System.out.println("Enter again..");
                option= scan.next().charAt(0);
            }

            if(option=='e'){
                passengersList.remove(passengerCurrCount);
                passengerCurrCount--;
                g.glob--;
                return 0;
            }

            else if(option=='y'){
                return j_detail();
            }
        }

        System.out.println("\n\t \t \t \t \t \tFlights Found");
        System.out.println("");

        if( (business_src2_desti1_seats.size()!=0) && (economy_src2_desti1_seats.size()!=0) ){
            System.out.println("Airline:\t \tDeparture:\tArrival:\tPrice:\t\tCategory");
            System.out.println("1.Qantas(1)\t \t08:00\t\t11:05\t\tRs.5000\t\tEconomy");
            System.out.println("2.Fly Dubai(2)\t14:00\t\t17:05\t\tRs.5500\t\tEconomy");
            System.out.println("3.Go Air(3)\t \t19:00\t\t22:05\t\tRs.6000\t\tEconomy");

            System.out.println("");
            System.out.println("Airline:\t \tDeparture:\tArrival:\tPrice:\t\tCategory");
            System.out.println("4.Qantas(1)\t \t08:00\t\t11:05\t\tRs.7000\t\tBusiness");
            System.out.println("5.Fly Dubai(2)\t14:00\t\t17:05\t\tRs.7500\t\tBusiness");
            System.out.println("6.Go Air(3)\t \t19:00\t\t22:05\t\tRs.8000\t\tBusiness");

            //getting the flight option from the user
            System.out.println("\nEnter your Flight choice:");
            choice=scan.nextInt();

            //validating the choice
            while(choice<1 || choice>6){
                System.out.println("Invalid! The choice can only be 1,2,3,4,5 or 6");
                System.out.println("Enter again..");
                choice=scan.nextInt();
            }

            //condition for selection from Economy class
            if(choice>=1 && choice<4){
                //displaying the Availaable Business class seats
                System.out.println("\nSeat numbers available for Economy class booking\n");
                for (int i = 0; i < economy_src2_desti1_seats.size(); i++) {
                    System.out.println("Seat No.: "+economy_src2_desti1_seats.get(i));
                }

                //getting the seat number choice from the user
                System.out.println("\nEnter Seat No.:");
                passengersList.get(passengerCurrCount).seat_no=scan.nextInt();

                //validating the seat number choice
                boolean found=false;
                while(found!=true){

                    for (int i = 0; i < economy_src2_desti1_seats.size(); i++) {
                        //finding the seat and removing the seat at the same time in this condition
                        if(passengersList.get(passengerCurrCount).seat_no==economy_src2_desti1_seats.get(i)){
                            found=true;
                            economy_src2_desti1_seats.remove(i);

                            //after removing sorting the arraylist
                            Collections.sort(economy_src2_desti1_seats);
                        }
                    }

                    if(found==false){
                        System.out.println("Invalid! Please select a seat from the above available seats");
                        passengersList.get(passengerCurrCount).seat_no=scan.nextInt();
                    }
                }

                //The selected seat is being removed from the arraylist successfully
            }

            //condition for selection from the business class
            if(choice>3 && choice<7){
                //displaying the Availaable Business class seats
                System.out.println("\nSeat numbers available for business class booking\n");
                for (int i = 0; i < business_src2_desti1_seats.size(); i++) {
                    System.out.println("Seat No.: "+business_src2_desti1_seats.get(i));
                }

                //getting the seat number choice from the user
                System.out.println("\nEnter Seat No.:");
                passengersList.get(passengerCurrCount).seat_no=scan.nextInt();

                //validating the seat number choice
                boolean found=false;
                while(found!=true){

                    for (int i = 0; i < business_src2_desti1_seats.size(); i++) {
                        //finding the seat and removing the seat at the same time in this condition
                        if(passengersList.get(passengerCurrCount).seat_no==business_src2_desti1_seats.get(i)){
                            found=true;
                            business_src2_desti1_seats.remove(i);

                            //after removing sorting the arraylist
                            Collections.sort(business_src2_desti1_seats);
                        }
                    }

                    if(found==false){
                        System.out.println("Invalid! Please select a seat from the above available seats");
                        passengersList.get(passengerCurrCount).seat_no=scan.nextInt();
                    }
                }

                //The selected seat is being removed from the arraylist successfully
            }
        }

        if(economy_src2_desti1_seats.size()!=0 && business_src2_desti1_seats.size()==0) {
            System.out.println("Airline:\t \tDeparture:\tArrival:\tPrice:\t\tCategory");
            System.out.println("1.Qantas(1)\t \t08:00\t\t11:05\t\tRs.5000\t\tEconomy");
            System.out.println("2.Fly Dubai(2)\t14:00\t\t17:05\t\tRs.5500\t\tEconomy");
            System.out.println("3.Go Air(3)\t \t19:00\t\t22:05\t\tRs.6000\t\tEconomy");
            System.out.println("");

            //getting the flight option from the user
            System.out.println("\nEnter your Flight choice:");
            choice=scan.nextInt();

            //validating the choice
            while(choice<1 || choice>3){
                System.out.println("Invalid! The choice can only be 1,2 or 3");
                System.out.println("Enter again..");
                choice=scan.nextInt();
            }

            //displaying the Availaable Business class seats
            System.out.println("\nSeat numbers available for Economy class booking\n");
            for (int i = 0; i < economy_src2_desti1_seats.size(); i++) {
                System.out.println("Seat No.: "+economy_src2_desti1_seats.get(i));
            }

            //getting the seat number choice from the user
            System.out.println("\nEnter Seat No.:");
            passengersList.get(passengerCurrCount).seat_no=scan.nextInt();

            //validating the seat number choice
            boolean found=false;
            while(found!=true){

                for (int i = 0; i < economy_src2_desti1_seats.size(); i++) {
                    //finding the seat and removing the seat at the same time in this condition
                    if(passengersList.get(passengerCurrCount).seat_no==economy_src2_desti1_seats.get(i)){
                        found=true;
                        economy_src2_desti1_seats.remove(i);

                        //after removing sorting the arraylist
                        Collections.sort(economy_src2_desti1_seats);
                    }
                }

                if(found==false){
                    System.out.println("Invalid! Please select a seat from the above available seats");
                    passengersList.get(passengerCurrCount).seat_no=scan.nextInt();
                }
            }

            //The selected seat is being removed from the arraylist successfully
        }

        if(business_src2_desti1_seats.size()!=0 && economy_src2_desti1_seats.size()==0) {
            System.out.println("Airline:\t \tDeparture:\tArrival:\tPrice:\t\tCategory");
            System.out.println("4.Qantas(1)\t \t08:00\t\t11:05\t\tRs.7000\t\tBusiness");
            System.out.println("5.Fly Dubai(2)\t14:00\t\t17:05\t\tRs.7500\t\tBusiness");
            System.out.println("6.Go Air(3)\t \t19:00\t\t22:05\t\tRs.8000\t\tBusiness");

            //getting the flight option from the user
            System.out.println("\nEnter your Flight choice:");
            choice=scan.nextInt();

            //validating the choice
            while(choice<4 || choice>6){
                System.out.println("Invalid! The choice can only be 4,5 or 6");
                System.out.println("Enter again..");
                choice=scan.nextInt();
            }

            //displaying the Availaable Business class seats
            System.out.println("\nSeat numbers available for business class booking\n");
            for (int i = 0; i < business_src2_desti1_seats.size(); i++) {
                System.out.println("Seat No.: "+business_src2_desti1_seats.get(i));
            }

            //getting the seat number choice from the user
            System.out.println("\nEnter Seat No.:");
            passengersList.get(passengerCurrCount).seat_no=scan.nextInt();

            //validating the seat number choice
            boolean found=false;
            while(found!=true){

                for (int i = 0; i < business_src2_desti1_seats.size(); i++) {
                    //finding the seat and removing the seat at the same time in this condition
                    if(passengersList.get(passengerCurrCount).seat_no==business_src2_desti1_seats.get(i)){
                        found=true;
                        business_src2_desti1_seats.remove(i);

                        //after removing sorting the arraylist
                        Collections.sort(business_src2_desti1_seats);
                    }
                }

                if(found==false){
                    System.out.println("Invalid! Please select a seat from the above available seats");
                    passengersList.get(passengerCurrCount).seat_no=scan.nextInt();
                }
            }

            //The selected seat is being removed from the arraylist successfully
        }

        //setting the src and dest variables of the passenger class because it will later help in
        //identifying in which arraylist to add the cancelled seat (seat cancelled by the passenger)
        passengersList.get(passengerCurrCount).src=2;
        passengersList.get(passengerCurrCount).dest=1;
        passengersList.get(passengerCurrCount).source="Sydney";
        passengersList.get(passengerCurrCount).destination="Brisbane";
        }

        else if( ( src==2 &&  dest==3) )//condition
        {
            //original code
            /*System.out.println("\n\t \t \t \t \t \tFlights Found");
            System.out.println("");
            System.out.println("Airline:\t \tDeparture:\tArrival:\tPrice:\t\tCategory");
            System.out.println("\1.Qantas(1)\t \t08:00\t\t11:05\t\tRs.5400\t\tEconomy");
            System.out.println("\2.Fly Dubai(2)\t14:00\t\t17:05\t\tRs.2500\t\tEconomy");
            System.out.println("\3.Go Air(3)\t \t19:00\t\t22:05\t\tRs.2890\t\tEconomy");

            System.out.println("");
            System.out.println("Airline:\t \tDeparture:\tArrival:\tPrice:\t\tCategory");
            System.out.println("\1.Qantas(1)\t \t08:00\t\t11:05\t\tRs.7400\t\tBusiness");
            System.out.println("\2.Fly Dubai(2)\t14:00\t\t17:05\t\tRs.5500\t\tBusiness");
            System.out.println("\3.Go Air(3)\t \t19:00\t\t22:05\t\tRs.4890\t\tBusiness");
            */
            ////////////////////////////////////////////////////////////////////////////

            //checking the availability of the seats in the economy and business class
            if(economy_src2_desti3_seats.size()==0 && business_src2_desti3_seats.size()==0){

                char option;
                System.out.println("\nNo seats available in the business and economy class");
                System.out.println("Do you wish to make another Reservation (y/n):");
                option= scan.next().charAt(0);

                while ( (option!='y') && (option!='n') ){
                    System.out.println("Invalid! Please enter y (for yes) or n (for no)");
                    System.out.println("Enter again..");
                    option= scan.next().charAt(0);
                }

                if(option=='n'){
                    passengersList.remove(passengerCurrCount);
                    passengerCurrCount--;
                    g.glob--;
                    return 0;
                }

                else if(option=='y'){
                    return j_detail();
                }

            }

            //Printing the process if these are no seats available in the economy class
            if(economy_src2_desti3_seats.size()==0){
                System.out.println("\nNo seats are available in the Economy class. Only Business class seats are avaiable");
                System.out.println("Do you wish to make another Reservation (y/n/e)");
                System.out.println("Enter 'y' to make another Reservation. Enter 'n' to continue with the business class booking");
                System.out.println("Enter e for exit");
                char option= scan.next().charAt(0);

                while ( (option!='y') && (option!='n' && (option!='e')) ){
                    System.out.println("Invalid! Please enter y (for yes) or n (for no) or e (for exit)");
                    System.out.println("Enter again..");
                    option= scan.next().charAt(0);
                }

                if(option=='e'){
                    passengersList.remove(passengerCurrCount);
                    passengerCurrCount--;
                    g.glob--;
                    return 0;
                }

                else if(option=='y'){
                    return j_detail();
                }
            }

            //Printing the process if these are no seats available in the business class
            if(business_src2_desti3_seats.size()==0){
                System.out.println("\nNo seats are available in the Business class. Only Economy class seats are avaiable");
                System.out.println("Do you wish to make another Reservation (y/n/e)");
                System.out.println("Enter 'y' to make another Reservation. Enter 'n' to continue with the Economy class booking");
                System.out.println("Enter e to exit");
                char option= scan.next().charAt(0);

                while ( (option!='y') && (option!='n') && (option!='e') ){
                    System.out.println("Invalid! Please enter y (for yes) or n (for no) or e (for exit)");
                    System.out.println("Enter again..");
                    option= scan.next().charAt(0);
                }

                if(option=='e'){
                    passengersList.remove(passengerCurrCount);
                    passengerCurrCount--;
                    g.glob--;
                    return 0;
                }

                else if(option=='y'){
                    return j_detail();
                }
            }

            System.out.println("\n\t \t \t \t \t \tFlights Found");
            System.out.println("");

            if( (business_src2_desti3_seats.size()!=0) && (economy_src2_desti3_seats.size()!=0) ){
                System.out.println("Airline:\t \tDeparture:\tArrival:\tPrice:\t\tCategory");
                System.out.println("\1.Qantas(1)\t \t08:00\t\t11:05\t\tRs.5400\t\tEconomy");
                System.out.println("\2.Fly Dubai(2)\t14:00\t\t17:05\t\tRs.2500\t\tEconomy");
                System.out.println("\3.Go Air(3)\t \t19:00\t\t22:05\t\tRs.2890\t\tEconomy");

                System.out.println("");
                System.out.println("Airline:\t \tDeparture:\tArrival:\tPrice:\t\tCategory");
                System.out.println("\4.Qantas(1)\t \t08:00\t\t11:05\t\tRs.7400\t\tBusiness");
                System.out.println("\5.Fly Dubai(2)\t14:00\t\t17:05\t\tRs.5500\t\tBusiness");
                System.out.println("\6.Go Air(3)\t \t19:00\t\t22:05\t\tRs.4890\t\tBusiness");

                //getting the flight option from the user
                System.out.println("\nEnter your Flight choice:");
                choice=scan.nextInt();

                //validating the choice
                while(choice<1 || choice>6){
                    System.out.println("Invalid! The choice can only be 1,2,3,4,5 or 6");
                    System.out.println("Enter again..");
                    choice=scan.nextInt();
                }

                //condition for selection from Economy class
                if(choice>=1 && choice<4){
                    //displaying the Availaable Business class seats
                    System.out.println("\nSeat numbers available for Economy class booking\n");
                    for (int i = 0; i < economy_src2_desti3_seats.size(); i++) {
                        System.out.println("Seat No.: "+economy_src2_desti3_seats.get(i));
                    }

                    //getting the seat number choice from the user
                    System.out.println("\nEnter Seat No.:");
                    passengersList.get(passengerCurrCount).seat_no=scan.nextInt();

                    //validating the seat number choice
                    boolean found=false;
                    while(found!=true){

                        for (int i = 0; i < economy_src2_desti3_seats.size(); i++) {
                            //finding the seat and removing the seat at the same time in this condition
                            if(passengersList.get(passengerCurrCount).seat_no==economy_src2_desti3_seats.get(i)){
                                found=true;
                                economy_src2_desti3_seats.remove(i);

                                //after removing sorting the arraylist
                                Collections.sort(economy_src2_desti3_seats);
                            }
                        }

                        if(found==false){
                            System.out.println("Invalid! Please select a seat from the above available seats");
                            passengersList.get(passengerCurrCount).seat_no=scan.nextInt();
                        }
                    }

                    //The selected seat is being removed from the arraylist successfully
                }

                //condition for selection from the business class
                if(choice>3 && choice<7){
                    //displaying the Availaable Business class seats
                    System.out.println("\nSeat numbers available for business class booking\n");
                    for (int i = 0; i < business_src2_desti3_seats.size(); i++) {
                        System.out.println("Seat No.: "+business_src2_desti3_seats.get(i));
                    }

                    //getting the seat number choice from the user
                    System.out.println("\nEnter Seat No.:");
                    passengersList.get(passengerCurrCount).seat_no=scan.nextInt();

                    //validating the seat number choice
                    boolean found=false;
                    while(found!=true){

                        for (int i = 0; i < business_src2_desti3_seats.size(); i++) {
                            //finding the seat and removing the seat at the same time in this condition
                            if(passengersList.get(passengerCurrCount).seat_no==business_src2_desti3_seats.get(i)){
                                found=true;
                                business_src2_desti3_seats.remove(i);

                                //after removing sorting the arraylist
                                Collections.sort(business_src2_desti3_seats);
                            }
                        }

                        if(found==false){
                            System.out.println("Invalid! Please select a seat from the above available seats");
                            passengersList.get(passengerCurrCount).seat_no=scan.nextInt();
                        }
                    }

                    //The selected seat is being removed from the arraylist successfully
                }
            }

            if(economy_src2_desti3_seats.size()!=0 && business_src2_desti3_seats.size()==0) {
                System.out.println("Airline:\t \tDeparture:\tArrival:\tPrice:\t\tCategory");
                System.out.println("\1.Qantas(1)\t \t08:00\t\t11:05\t\tRs.5400\t\tEconomy");
                System.out.println("\2.Fly Dubai(2)\t14:00\t\t17:05\t\tRs.2500\t\tEconomy");
                System.out.println("\3.Go Air(3)\t \t19:00\t\t22:05\t\tRs.2890\t\tEconomy");
                System.out.println("");

                //getting the flight option from the user
                System.out.println("\nEnter your Flight choice:");
                choice=scan.nextInt();

                //validating the choice
                while(choice<1 || choice>3){
                    System.out.println("Invalid! The choice can only be 1,2 or 3");
                    System.out.println("Enter again..");
                    choice=scan.nextInt();
                }

                //displaying the Availaable Business class seats
                System.out.println("\nSeat numbers available for Economy class booking\n");
                for (int i = 0; i < economy_src2_desti3_seats.size(); i++) {
                    System.out.println("Seat No.: "+economy_src2_desti3_seats.get(i));
                }

                //getting the seat number choice from the user
                System.out.println("\nEnter Seat No.:");
                passengersList.get(passengerCurrCount).seat_no=scan.nextInt();

                //validating the seat number choice
                boolean found=false;
                while(found!=true){

                    for (int i = 0; i < economy_src2_desti3_seats.size(); i++) {
                        //finding the seat and removing the seat at the same time in this condition
                        if(passengersList.get(passengerCurrCount).seat_no==economy_src2_desti3_seats.get(i)){
                            found=true;
                            economy_src2_desti3_seats.remove(i);

                            //after removing sorting the arraylist
                            Collections.sort(economy_src2_desti3_seats);
                        }
                    }

                    if(found==false){
                        System.out.println("Invalid! Please select a seat from the above available seats");
                        passengersList.get(passengerCurrCount).seat_no=scan.nextInt();
                    }
                }

                //The selected seat is being removed from the arraylist successfully
            }

            if(business_src2_desti3_seats.size()!=0 && economy_src2_desti3_seats.size()==0) {
                System.out.println("Airline:\t \tDeparture:\tArrival:\tPrice:\t\tCategory");
                System.out.println("\4.Qantas(1)\t \t08:00\t\t11:05\t\tRs.7400\t\tBusiness");
                System.out.println("\5.Fly Dubai(2)\t14:00\t\t17:05\t\tRs.5500\t\tBusiness");
                System.out.println("\6.Go Air(3)\t \t19:00\t\t22:05\t\tRs.4890\t\tBusiness");
                System.out.println("");

                //getting the flight option from the user
                System.out.println("\nEnter your Flight choice:");
                choice=scan.nextInt();

                //validating the choice
                while(choice<4 || choice>6){
                    System.out.println("Invalid! The choice can only be 4,5 or 6");
                    System.out.println("Enter again..");
                    choice=scan.nextInt();
                }

                //displaying the Availaable Business class seats
                System.out.println("\nSeat numbers available for business class booking\n");
                for (int i = 0; i < business_src2_desti3_seats.size(); i++) {
                    System.out.println("Seat No.: "+business_src2_desti3_seats.get(i));
                }

                //getting the seat number choice from the user
                System.out.println("\nEnter Seat No.:");
                passengersList.get(passengerCurrCount).seat_no=scan.nextInt();

                //validating the seat number choice
                boolean found=false;
                while(found!=true){

                    for (int i = 0; i < business_src2_desti3_seats.size(); i++) {
                        //finding the seat and removing the seat at the same time in this condition
                        if(passengersList.get(passengerCurrCount).seat_no==business_src2_desti3_seats.get(i)){
                            found=true;
                            business_src2_desti3_seats.remove(i);

                            //after removing sorting the arraylist
                            Collections.sort(business_src2_desti3_seats);
                        }
                    }

                    if(found==false){
                        System.out.println("Invalid! Please select a seat from the above available seats");
                        passengersList.get(passengerCurrCount).seat_no=scan.nextInt();
                    }
                }

                //The selected seat is being removed from the arraylist successfully
            }

            //setting the src and dest variables of the passenger class because it will later help in
            //identifying in which arraylist to add the cancelled seat (seat cancelled by the passenger)
            passengersList.get(passengerCurrCount).src=2;
            passengersList.get(passengerCurrCount).dest=3;
            passengersList.get(passengerCurrCount).source="Sydney";
            passengersList.get(passengerCurrCount).destination="Melbourne";

        }

        else if( ( src==2 &&  dest==4) )//condition
        {
            //original code
            /*System.out.println("\n\t \t \t \t \t \tFlights Found");
            System.out.println("");
            System.out.println("Airline:\t \tDeparture:\tArrival:\tPrice:\t\tCategory");
            System.out.println("\1.Qantas(1)\t \t08:00\t\t11:05\t\tRs.5000\t\tEconomy");
            System.out.println("\2.Fly Dubai(2)\t14:00\t\t17:05\t\tRs.4500\t\tEconomy");
            System.out.println("\3.Go Air(3)\t \t19:00\t\t22:05\t\tRs.6000\t\tEconomy");

            System.out.println("");
            System.out.println("Airline:\t \tDeparture:\tArrival:\tPrice:\t\tCategory");
            System.out.println("\1.Qantas(1)\t \t08:00\t\t11:05\t\tRs.5000\t\tBusiness");
            System.out.println("\2.Fly Dubai(2)\t14:00\t\t17:05\t\tRs.4500\t\tBusiness");
            System.out.println("\3.Go Air(3)\t \t19:00\t\t22:05\t\tRs.6000\t\tBusiness");
            */
            ///////////////////////////////////////////////////////////////////////////

            //checking the availability of the seats in the economy and business class
            if(economy_src2_desti4_seats.size()==0 && business_src2_desti4_seats.size()==0){

                char option;
                System.out.println("\nNo seats available in the business and economy class");
                System.out.println("Do you wish to make another Reservation (y/n):");
                option= scan.next().charAt(0);

                while ( (option!='y') && (option!='n') ){
                    System.out.println("Invalid! Please enter y (for yes) or n (for no)");
                    System.out.println("Enter again..");
                    option= scan.next().charAt(0);
                }

                if(option=='n'){
                    passengersList.remove(passengerCurrCount);
                    passengerCurrCount--;
                    g.glob--;
                    return 0;
                }

                else if(option=='y'){
                    return j_detail();
                }

            }

            //Printing the process if these are no seats available in the economy class
            if(economy_src2_desti4_seats.size()==0){
                System.out.println("\nNo seats are available in the Economy class. Only Business class seats are avaiable");
                System.out.println("Do you wish to make another Reservation (y/n/e)");
                System.out.println("Enter 'y' to make another Reservation. Enter 'n' to continue with the business class booking");
                System.out.println("Enter e for exit");
                char option= scan.next().charAt(0);

                while ( (option!='y') && (option!='n' && (option!='e')) ){
                    System.out.println("Invalid! Please enter y (for yes) or n (for no) or e (for exit)");
                    System.out.println("Enter again..");
                    option= scan.next().charAt(0);
                }

                if(option=='e'){
                    passengersList.remove(passengerCurrCount);
                    passengerCurrCount--;
                    g.glob--;
                    return 0;
                }

                else if(option=='y'){
                    return j_detail();
                }
            }

            //Printing the process if these are no seats available in the business class
            if(business_src2_desti4_seats.size()==0){
                System.out.println("\nNo seats are available in the Business class. Only Economy class seats are avaiable");
                System.out.println("Do you wish to make another Reservation (y/n/e)");
                System.out.println("Enter 'y' to make another Reservation. Enter 'n' to continue with the Economy class booking");
                System.out.println("Enter e to exit");
                char option= scan.next().charAt(0);

                while ( (option!='y') && (option!='n') && (option!='e') ){
                    System.out.println("Invalid! Please enter y (for yes) or n (for no) or e (for exit)");
                    System.out.println("Enter again..");
                    option= scan.next().charAt(0);
                }

                if(option=='e'){
                    passengersList.remove(passengerCurrCount);
                    passengerCurrCount--;
                    g.glob--;
                    return 0;
                }

                else if(option=='y'){
                    return j_detail();
                }
            }

            System.out.println("\n\t \t \t \t \t \tFlights Found");
            System.out.println("");

            if( (business_src2_desti4_seats.size()!=0) && (economy_src2_desti4_seats.size()!=0) ){
                System.out.println("Airline:\t \tDeparture:\tArrival:\tPrice:\t\tCategory");
                System.out.println("\1.Qantas(1)\t \t08:00\t\t11:05\t\tRs.5400\t\tEconomy");
                System.out.println("\2.Fly Dubai(2)\t14:00\t\t17:05\t\tRs.2500\t\tEconomy");
                System.out.println("\3.Go Air(3)\t \t19:00\t\t22:05\t\tRs.2890\t\tEconomy");

                System.out.println("");
                System.out.println("Airline:\t \tDeparture:\tArrival:\tPrice:\t\tCategory");
                System.out.println("\4.Qantas(1)\t \t08:00\t\t11:05\t\tRs.7400\t\tBusiness");
                System.out.println("\5.Fly Dubai(2)\t14:00\t\t17:05\t\tRs.5500\t\tBusiness");
                System.out.println("\6.Go Air(3)\t \t19:00\t\t22:05\t\tRs.4890\t\tBusiness");

                //getting the flight option from the user
                System.out.println("\nEnter your Flight choice:");
                choice=scan.nextInt();

                //validating the choice
                while(choice<1 || choice>6){
                    System.out.println("Invalid! The choice can only be 1,2,3,4,5 or 6");
                    System.out.println("Enter again..");
                    choice=scan.nextInt();
                }

                //condition for selection from Economy class
                if(choice>=1 && choice<4){
                    //displaying the Availaable Business class seats
                    System.out.println("\nSeat numbers available for Economy class booking\n");
                    for (int i = 0; i < economy_src2_desti4_seats.size(); i++) {
                        System.out.println("Seat No.: "+economy_src2_desti4_seats.get(i));
                    }

                    //getting the seat number choice from the user
                    System.out.println("\nEnter Seat No.:");
                    passengersList.get(passengerCurrCount).seat_no=scan.nextInt();

                    //validating the seat number choice
                    boolean found=false;
                    while(found!=true){

                        for (int i = 0; i < economy_src2_desti4_seats.size(); i++) {
                            //finding the seat and removing the seat at the same time in this condition
                            if(passengersList.get(passengerCurrCount).seat_no==economy_src2_desti4_seats.get(i)){
                                found=true;
                                economy_src2_desti4_seats.remove(i);

                                //after removing sorting the arraylist
                                Collections.sort(economy_src2_desti4_seats);
                            }
                        }

                        if(found==false){
                            System.out.println("Invalid! Please select a seat from the above available seats");
                            passengersList.get(passengerCurrCount).seat_no=scan.nextInt();
                        }
                    }

                    //The selected seat is being removed from the arraylist successfully
                }

                //condition for selection from the business class
                if(choice>3 && choice<7){
                    //displaying the Availaable Business class seats
                    System.out.println("\nSeat numbers available for business class booking\n");
                    for (int i = 0; i < business_src2_desti4_seats.size(); i++) {
                        System.out.println("Seat No.: "+business_src2_desti4_seats.get(i));
                    }

                    //getting the seat number choice from the user
                    System.out.println("\nEnter Seat No.:");
                    passengersList.get(passengerCurrCount).seat_no=scan.nextInt();

                    //validating the seat number choice
                    boolean found=false;
                    while(found!=true){

                        for (int i = 0; i < business_src2_desti4_seats.size(); i++) {
                            //finding the seat and removing the seat at the same time in this condition
                            if(passengersList.get(passengerCurrCount).seat_no==business_src2_desti4_seats.get(i)){
                                found=true;
                                business_src2_desti4_seats.remove(i);

                                //after removing sorting the arraylist
                                Collections.sort(business_src2_desti4_seats);
                            }
                        }

                        if(found==false){
                            System.out.println("Invalid! Please select a seat from the above available seats");
                            passengersList.get(passengerCurrCount).seat_no=scan.nextInt();
                        }
                    }

                    //The selected seat is being removed from the arraylist successfully
                }
            }

            if(economy_src2_desti4_seats.size()!=0 && business_src2_desti4_seats.size()==0) {
                System.out.println("Airline:\t \tDeparture:\tArrival:\tPrice:\t\tCategory");
                System.out.println("\1.Qantas(1)\t \t08:00\t\t11:05\t\tRs.5400\t\tEconomy");
                System.out.println("\2.Fly Dubai(2)\t14:00\t\t17:05\t\tRs.2500\t\tEconomy");
                System.out.println("\3.Go Air(3)\t \t19:00\t\t22:05\t\tRs.2890\t\tEconomy");
                System.out.println("");

                //getting the flight option from the user
                System.out.println("\nEnter your Flight choice:");
                choice=scan.nextInt();

                //validating the choice
                while(choice<1 || choice>3){
                    System.out.println("Invalid! The choice can only be 1,2 or 3");
                    System.out.println("Enter again..");
                    choice=scan.nextInt();
                }

                //displaying the Availaable Business class seats
                System.out.println("\nSeat numbers available for Economy class booking\n");
                for (int i = 0; i < economy_src2_desti4_seats.size(); i++) {
                    System.out.println("Seat No.: "+economy_src2_desti4_seats.get(i));
                }

                //getting the seat number choice from the user
                System.out.println("\nEnter Seat No.:");
                passengersList.get(passengerCurrCount).seat_no=scan.nextInt();

                //validating the seat number choice
                boolean found=false;
                while(found!=true){

                    for (int i = 0; i < economy_src2_desti4_seats.size(); i++) {
                        //finding the seat and removing the seat at the same time in this condition
                        if(passengersList.get(passengerCurrCount).seat_no==economy_src2_desti4_seats.get(i)){
                            found=true;
                            economy_src2_desti4_seats.remove(i);

                            //after removing sorting the arraylist
                            Collections.sort(economy_src2_desti4_seats);
                        }
                    }

                    if(found==false){
                        System.out.println("Invalid! Please select a seat from the above available seats");
                        passengersList.get(passengerCurrCount).seat_no=scan.nextInt();
                    }
                }

                //The selected seat is being removed from the arraylist successfully
            }

            if(business_src2_desti4_seats.size()!=0 && economy_src2_desti4_seats.size()==0) {
                System.out.println("Airline:\t \tDeparture:\tArrival:\tPrice:\t\tCategory");
                System.out.println("\4.Qantas(1)\t \t08:00\t\t11:05\t\tRs.7400\t\tBusiness");
                System.out.println("\5.Fly Dubai(2)\t14:00\t\t17:05\t\tRs.5500\t\tBusiness");
                System.out.println("\6.Go Air(3)\t \t19:00\t\t22:05\t\tRs.4890\t\tBusiness");
                System.out.println("");

                //getting the flight option from the user
                System.out.println("\nEnter your Flight choice:");
                choice=scan.nextInt();

                //validating the choice
                while(choice<4 || choice>6){
                    System.out.println("Invalid! The choice can only be 4,5 or 6");
                    System.out.println("Enter again..");
                    choice=scan.nextInt();
                }

                //displaying the Availaable Business class seats
                System.out.println("\nSeat numbers available for business class booking\n");
                for (int i = 0; i < business_src2_desti4_seats.size(); i++) {
                    System.out.println("Seat No.: "+business_src2_desti4_seats.get(i));
                }

                //getting the seat number choice from the user
                System.out.println("\nEnter Seat No.:");
                passengersList.get(passengerCurrCount).seat_no=scan.nextInt();

                //validating the seat number choice
                boolean found=false;
                while(found!=true){

                    for (int i = 0; i < business_src2_desti4_seats.size(); i++) {
                        //finding the seat and removing the seat at the same time in this condition
                        if(passengersList.get(passengerCurrCount).seat_no==business_src2_desti4_seats.get(i)){
                            found=true;
                            business_src2_desti4_seats.remove(i);

                            //after removing sorting the arraylist
                            Collections.sort(business_src2_desti4_seats);
                        }
                    }

                    if(found==false){
                        System.out.println("Invalid! Please select a seat from the above available seats");
                        passengersList.get(passengerCurrCount).seat_no=scan.nextInt();
                    }
                }

                //The selected seat is being removed from the arraylist successfully
            }

            //setting the src and dest variables of the passenger class because it will later help in
            //identifying in which arraylist to add the cancelled seat (seat cancelled by the passenger)
            passengersList.get(passengerCurrCount).src=2;
            passengersList.get(passengerCurrCount).dest=4;
            passengersList.get(passengerCurrCount).source="Sydney";
            passengersList.get(passengerCurrCount).destination="Canberra";

        }

        else if( (src==3 &&  dest==1) )//condition
        {
            //original code
            /*System.out.println("\n\t \t \t \t \t \tFlights Found");
            System.out.println("");
            System.out.println("Airline:\t \tDeparture:\tArrival:\tPrice:\t\tCategory");
            System.out.println("\1.Qantas(1)\t \t08:00\t\t11:05\t\tRs.5000\t\tEconomy");
            System.out.println("\2.Fly Dubai(2)\t14:00\t\t17:05\t\tRs.5500\t\tEconomy");
            System.out.println("\3.Go Air(3)\t \t19:00\t\t22:05\t\tRs.6000\t\tEconomy");

            System.out.println("");
            System.out.println("Airline:\t \tDeparture:\tArrival:\tPrice:\t\tCategory");
            System.out.println("\1.Qantas(1)\t \t08:00\t\t11:05\t\tRs.7000\t\tBusiness");
            System.out.println("\2.Fly Dubai(2)\t14:00\t\t17:05\t\tRs.7500\t\tBusiness");
            System.out.println("\3.Go Air(3)\t \t19:00\t\t22:05\t\tRs.8000\t\tBusiness");
            */
            ///////////////////////////////////////////////////////////////////////////////

            //checking the availability of the seats in the economy and business class
            if(economy_src3_desti1_seats.size()==0 && business_src3_desti1_seats.size()==0){

                char option;
                System.out.println("\nNo seats available in the business and economy class");
                System.out.println("Do you wish to make another Reservation (y/n):");
                option= scan.next().charAt(0);

                while ( (option!='y') && (option!='n') ){
                    System.out.println("Invalid! Please enter y (for yes) or n (for no)");
                    System.out.println("Enter again..");
                    option= scan.next().charAt(0);
                }

                if(option=='n'){
                    passengersList.remove(passengerCurrCount);
                    passengerCurrCount--;
                    g.glob--;
                    return 0;
                }

                else if(option=='y'){
                    return j_detail();
                }

            }

            //Printing the process if these are no seats available in the economy class
            if(economy_src3_desti1_seats.size()==0){
                System.out.println("\nNo seats are available in the Economy class. Only Business class seats are avaiable");
                System.out.println("Do you wish to make another Reservation (y/n/e)");
                System.out.println("Enter 'y' to make another Reservation. Enter 'n' to continue with the business class booking");
                System.out.println("Enter e for exit");
                char option= scan.next().charAt(0);

                while ( (option!='y') && (option!='n' && (option!='e')) ){
                    System.out.println("Invalid! Please enter y (for yes) or n (for no) or e (for exit)");
                    System.out.println("Enter again..");
                    option= scan.next().charAt(0);
                }

                if(option=='e'){
                    passengersList.remove(passengerCurrCount);
                    passengerCurrCount--;
                    g.glob--;
                    return 0;
                }

                else if(option=='y'){
                    return j_detail();
                }
            }

            //Printing the process if these are no seats available in the business class
            if(business_src3_desti1_seats.size()==0){
                System.out.println("\nNo seats are available in the Business class. Only Economy class seats are avaiable");
                System.out.println("Do you wish to make another Reservation (y/n/e)");
                System.out.println("Enter 'y' to make another Reservation. Enter 'n' to continue with the Economy class booking");
                System.out.println("Enter e to exit");
                char option= scan.next().charAt(0);

                while ( (option!='y') && (option!='n') && (option!='e') ){
                    System.out.println("Invalid! Please enter y (for yes) or n (for no) or e (for exit)");
                    System.out.println("Enter again..");
                    option= scan.next().charAt(0);
                }

                if(option=='e'){
                    passengersList.remove(passengerCurrCount);
                    passengerCurrCount--;
                    g.glob--;
                    return 0;
                }

                else if(option=='y'){
                    return j_detail();
                }
            }

            System.out.println("\n\t \t \t \t \t \tFlights Found");
            System.out.println("");

            if( (business_src3_desti1_seats.size()!=0) && (economy_src3_desti1_seats.size()!=0) ){
                System.out.println("Airline:\t \tDeparture:\tArrival:\tPrice:\t\tCategory");
                System.out.println("1.Qantas(1)\t \t08:00\t\t11:05\t\tRs.5000\t\tEconomy");
                System.out.println("2.Fly Dubai(2)\t14:00\t\t17:05\t\tRs.5500\t\tEconomy");
                System.out.println("3.Go Air(3)\t \t19:00\t\t22:05\t\tRs.6000\t\tEconomy");

                System.out.println("");
                System.out.println("Airline:\t \tDeparture:\tArrival:\tPrice:\t\tCategory");
                System.out.println("4.Qantas(1)\t \t08:00\t\t11:05\t\tRs.7000\t\tBusiness");
                System.out.println("5.Fly Dubai(2)\t14:00\t\t17:05\t\tRs.7500\t\tBusiness");
                System.out.println("6.Go Air(3)\t \t19:00\t\t22:05\t\tRs.8000\t\tBusiness");

                //getting the flight option from the user
                System.out.println("\nEnter your Flight choice:");
                choice=scan.nextInt();

                //validating the choice
                while(choice<1 || choice>6){
                    System.out.println("Invalid! The choice can only be 1,2,3,4,5 or 6");
                    System.out.println("Enter again..");
                    choice=scan.nextInt();
                }

                //condition for selection from Economy class
                if(choice>=1 && choice<4){
                    //displaying the Availaable Business class seats
                    System.out.println("\nSeat numbers available for Economy class booking\n");
                    for (int i = 0; i < economy_src3_desti1_seats.size(); i++) {
                        System.out.println("Seat No.: "+economy_src3_desti1_seats.get(i));
                    }

                    //getting the seat number choice from the user
                    System.out.println("\nEnter Seat No.:");
                    passengersList.get(passengerCurrCount).seat_no=scan.nextInt();

                    //validating the seat number choice
                    boolean found=false;
                    while(found!=true){

                        for (int i = 0; i < economy_src3_desti1_seats.size(); i++) {
                            //finding the seat and removing the seat at the same time in this condition
                            if(passengersList.get(passengerCurrCount).seat_no==economy_src3_desti1_seats.get(i)){
                                found=true;
                                economy_src3_desti1_seats.remove(i);

                                //after removing sorting the arraylist
                                Collections.sort(economy_src3_desti1_seats);
                            }
                        }

                        if(found==false){
                            System.out.println("Invalid! Please select a seat from the above available seats");
                            passengersList.get(passengerCurrCount).seat_no=scan.nextInt();
                        }
                    }

                    //The selected seat is being removed from the arraylist successfully
                }

                //condition for selection from the business class
                if(choice>3 && choice<7){
                    //displaying the Availaable Business class seats
                    System.out.println("\nSeat numbers available for business class booking\n");
                    for (int i = 0; i < business_src3_desti1_seats.size(); i++) {
                        System.out.println("Seat No.: "+business_src3_desti1_seats.get(i));
                    }

                    //getting the seat number choice from the user
                    System.out.println("\nEnter Seat No.:");
                    passengersList.get(passengerCurrCount).seat_no=scan.nextInt();

                    //validating the seat number choice
                    boolean found=false;
                    while(found!=true){

                        for (int i = 0; i < business_src3_desti1_seats.size(); i++) {
                            //finding the seat and removing the seat at the same time in this condition
                            if(passengersList.get(passengerCurrCount).seat_no==business_src3_desti1_seats.get(i)){
                                found=true;
                                business_src3_desti1_seats.remove(i);

                                //after removing sorting the arraylist
                                Collections.sort(business_src3_desti1_seats);
                            }
                        }

                        if(found==false){
                            System.out.println("Invalid! Please select a seat from the above available seats");
                            passengersList.get(passengerCurrCount).seat_no=scan.nextInt();
                        }
                    }

                    //The selected seat is being removed from the arraylist successfully
                }
            }

            if(economy_src3_desti1_seats.size()!=0 && business_src3_desti1_seats.size()==0) {
                System.out.println("Airline:\t \tDeparture:\tArrival:\tPrice:\t\tCategory");
                System.out.println("1.Qantas(1)\t \t08:00\t\t11:05\t\tRs.5000\t\tEconomy");
                System.out.println("2.Fly Dubai(2)\t14:00\t\t17:05\t\tRs.5500\t\tEconomy");
                System.out.println("3.Go Air(3)\t \t19:00\t\t22:05\t\tRs.6000\t\tEconomy");
                System.out.println("");

                //getting the flight option from the user
                System.out.println("\nEnter your Flight choice:");
                choice=scan.nextInt();

                //validating the choice
                while(choice<1 || choice>3){
                    System.out.println("Invalid! The choice can only be 1,2 or 3");
                    System.out.println("Enter again..");
                    choice=scan.nextInt();
                }

                //displaying the Availaable Business class seats
                System.out.println("\nSeat numbers available for Economy class booking\n");
                for (int i = 0; i < economy_src3_desti1_seats.size(); i++) {
                    System.out.println("Seat No.: "+economy_src3_desti1_seats.get(i));
                }

                //getting the seat number choice from the user
                System.out.println("\nEnter Seat No.:");
                passengersList.get(passengerCurrCount).seat_no=scan.nextInt();

                //validating the seat number choice
                boolean found=false;
                while(found!=true){

                    for (int i = 0; i < economy_src3_desti1_seats.size(); i++) {
                        //finding the seat and removing the seat at the same time in this condition
                        if(passengersList.get(passengerCurrCount).seat_no==economy_src3_desti1_seats.get(i)){
                            found=true;
                            economy_src3_desti1_seats.remove(i);

                            //after removing sorting the arraylist
                            Collections.sort(economy_src3_desti1_seats);
                        }
                    }

                    if(found==false){
                        System.out.println("Invalid! Please select a seat from the above available seats");
                        passengersList.get(passengerCurrCount).seat_no=scan.nextInt();
                    }
                }

                //The selected seat is being removed from the arraylist successfully
            }

            if(business_src3_desti1_seats.size()!=0 && economy_src3_desti1_seats.size()==0) {
                System.out.println("Airline:\t \tDeparture:\tArrival:\tPrice:\t\tCategory");
                System.out.println("4.Qantas(1)\t \t08:00\t\t11:05\t\tRs.7000\t\tBusiness");
                System.out.println("5.Fly Dubai(2)\t14:00\t\t17:05\t\tRs.7500\t\tBusiness");
                System.out.println("6.Go Air(3)\t \t19:00\t\t22:05\t\tRs.8000\t\tBusiness");

                //getting the flight option from the user
                System.out.println("\nEnter your Flight choice:");
                choice=scan.nextInt();

                //validating the choice
                while(choice<4 || choice>6){
                    System.out.println("Invalid! The choice can only be 4,5 or 6");
                    System.out.println("Enter again..");
                    choice=scan.nextInt();
                }

                //displaying the Availaable Business class seats
                System.out.println("\nSeat numbers available for business class booking\n");
                for (int i = 0; i < business_src3_desti1_seats.size(); i++) {
                    System.out.println("Seat No.: "+business_src3_desti1_seats.get(i));
                }

                //getting the seat number choice from the user
                System.out.println("\nEnter Seat No.:");
                passengersList.get(passengerCurrCount).seat_no=scan.nextInt();

                //validating the seat number choice
                boolean found=false;
                while(found!=true){

                    for (int i = 0; i < business_src3_desti1_seats.size(); i++) {
                        //finding the seat and removing the seat at the same time in this condition
                        if(passengersList.get(passengerCurrCount).seat_no==business_src3_desti1_seats.get(i)){
                            found=true;
                            business_src3_desti1_seats.remove(i);

                            //after removing sorting the arraylist
                            Collections.sort(business_src3_desti1_seats);
                        }
                    }

                    if(found==false){
                        System.out.println("Invalid! Please select a seat from the above available seats");
                        passengersList.get(passengerCurrCount).seat_no=scan.nextInt();
                    }
                }

                //The selected seat is being removed from the arraylist successfully
            }

            //setting the src and dest variables of the passenger class because it will later help in
            //identifying in which arraylist to add the cancelled seat (seat cancelled by the passenger)
            passengersList.get(passengerCurrCount).src=3;
            passengersList.get(passengerCurrCount).dest=1;
            passengersList.get(passengerCurrCount).source="Melbourne";
            passengersList.get(passengerCurrCount).destination="Brisbane";
        }

        else if( ( src==3 &&  dest==2) )//condition
        {
            //original code
            /*System.out.println("\n\t \t \t \t \t \tFlights Found");
            System.out.println("");
            System.out.println("Airline:\t \tDeparture:\tArrival:\tPrice:\t\tCategory");
            System.out.println("\1.Qantas(1)\t \t08:00\t\t11:05\t\tRs.5400\t\tEconomy");
            System.out.println("\2.Fly Dubai(2)\t14:00\t\t17:05\t\tRs.2500\t\tEconomy");
            System.out.println("\3.Go Air(3)\t \t19:00\t\t22:05\t\tRs.2890\t\tEconomy");

            System.out.println("");
            System.out.println("Airline:\t \tDeparture:\tArrival:\tPrice:\t\tCategory");
            System.out.println("\1.Qantas(1)\t \t08:00\t\t11:05\t\tRs.7400\t\tBusiness");
            System.out.println("\2.Fly Dubai(2)\t14:00\t\t17:05\t\tRs.5500\t\tBusiness");
            System.out.println("\3.Go Air(3)\t \t19:00\t\t22:05\t\tRs.4890\t\tBusiness");
            */
            ////////////////////////////////////////////////////////////////////////////

            //checking the availability of the seats in the economy and business class
            if(economy_src3_desti2_seats.size()==0 && business_src3_desti2_seats.size()==0){

                char option;
                System.out.println("\nNo seats available in the business and economy class");
                System.out.println("Do you wish to make another Reservation (y/n):");
                option= scan.next().charAt(0);

                while ( (option!='y') && (option!='n') ){
                    System.out.println("Invalid! Please enter y (for yes) or n (for no)");
                    System.out.println("Enter again..");
                    option= scan.next().charAt(0);
                }

                if(option=='n'){
                    passengersList.remove(passengerCurrCount);
                    passengerCurrCount--;
                    g.glob--;
                    return 0;
                }

                else if(option=='y'){
                    return j_detail();
                }

            }

            //Printing the process if these are no seats available in the economy class
            if(economy_src3_desti2_seats.size()==0){
                System.out.println("\nNo seats are available in the Economy class. Only Business class seats are avaiable");
                System.out.println("Do you wish to make another Reservation (y/n/e)");
                System.out.println("Enter 'y' to make another Reservation. Enter 'n' to continue with the business class booking");
                System.out.println("Enter e for exit");
                char option= scan.next().charAt(0);

                while ( (option!='y') && (option!='n' && (option!='e')) ){
                    System.out.println("Invalid! Please enter y (for yes) or n (for no) or e (for exit)");
                    System.out.println("Enter again..");
                    option= scan.next().charAt(0);
                }

                if(option=='e'){
                    passengersList.remove(passengerCurrCount);
                    passengerCurrCount--;
                    g.glob--;
                    return 0;
                }

                else if(option=='y'){
                    return j_detail();
                }
            }

            //Printing the process if these are no seats available in the business class
            if(business_src3_desti2_seats.size()==0){
                System.out.println("\nNo seats are available in the Business class. Only Economy class seats are avaiable");
                System.out.println("Do you wish to make another Reservation (y/n/e)");
                System.out.println("Enter 'y' to make another Reservation. Enter 'n' to continue with the Economy class booking");
                System.out.println("Enter e to exit");
                char option= scan.next().charAt(0);

                while ( (option!='y') && (option!='n') && (option!='e') ){
                    System.out.println("Invalid! Please enter y (for yes) or n (for no) or e (for exit)");
                    System.out.println("Enter again..");
                    option= scan.next().charAt(0);
                }

                if(option=='e'){
                    passengersList.remove(passengerCurrCount);
                    passengerCurrCount--;
                    g.glob--;
                    return 0;
                }

                else if(option=='y'){
                    return j_detail();
                }
            }

            System.out.println("\n\t \t \t \t \t \tFlights Found");
            System.out.println("");

            if( (business_src3_desti2_seats.size()!=0) && (economy_src3_desti2_seats.size()!=0) ){
                System.out.println("Airline:\t \tDeparture:\tArrival:\tPrice:\t\tCategory");
                System.out.println("\1.Qantas(1)\t \t08:00\t\t11:05\t\tRs.5400\t\tEconomy");
                System.out.println("\2.Fly Dubai(2)\t14:00\t\t17:05\t\tRs.2500\t\tEconomy");
                System.out.println("\3.Go Air(3)\t \t19:00\t\t22:05\t\tRs.2890\t\tEconomy");

                System.out.println("");
                System.out.println("Airline:\t \tDeparture:\tArrival:\tPrice:\t\tCategory");
                System.out.println("\4.Qantas(1)\t \t08:00\t\t11:05\t\tRs.7400\t\tBusiness");
                System.out.println("\5.Fly Dubai(2)\t14:00\t\t17:05\t\tRs.5500\t\tBusiness");
                System.out.println("\6.Go Air(3)\t \t19:00\t\t22:05\t\tRs.4890\t\tBusiness");

                //getting the flight option from the user
                System.out.println("\nEnter your Flight choice:");
                choice=scan.nextInt();

                //validating the choice
                while(choice<1 || choice>6){
                    System.out.println("Invalid! The choice can only be 1,2,3,4,5 or 6");
                    System.out.println("Enter again..");
                    choice=scan.nextInt();
                }

                //condition for selection from Economy class
                if(choice>=1 && choice<4){
                    //displaying the Availaable Business class seats
                    System.out.println("\nSeat numbers available for Economy class booking\n");
                    for (int i = 0; i < economy_src3_desti2_seats.size(); i++) {
                        System.out.println("Seat No.: "+economy_src3_desti2_seats.get(i));
                    }

                    //getting the seat number choice from the user
                    System.out.println("\nEnter Seat No.:");
                    passengersList.get(passengerCurrCount).seat_no=scan.nextInt();

                    //validating the seat number choice
                    boolean found=false;
                    while(found!=true){

                        for (int i = 0; i < economy_src3_desti2_seats.size(); i++) {
                            //finding the seat and removing the seat at the same time in this condition
                            if(passengersList.get(passengerCurrCount).seat_no==economy_src3_desti2_seats.get(i)){
                                found=true;
                                economy_src3_desti2_seats.remove(i);

                                //after removing sorting the arraylist
                                Collections.sort(economy_src3_desti2_seats);
                            }
                        }

                        if(found==false){
                            System.out.println("Invalid! Please select a seat from the above available seats");
                            passengersList.get(passengerCurrCount).seat_no=scan.nextInt();
                        }
                    }

                    //The selected seat is being removed from the arraylist successfully
                }

                //condition for selection from the business class
                if(choice>3 && choice<7){
                    //displaying the Availaable Business class seats
                    System.out.println("\nSeat numbers available for business class booking\n");
                    for (int i = 0; i < business_src3_desti2_seats.size(); i++) {
                        System.out.println("Seat No.: "+business_src2_desti3_seats.get(i));
                    }

                    //getting the seat number choice from the user
                    System.out.println("\nEnter Seat No.:");
                    passengersList.get(passengerCurrCount).seat_no=scan.nextInt();

                    //validating the seat number choice
                    boolean found=false;
                    while(found!=true){

                        for (int i = 0; i < business_src3_desti2_seats.size(); i++) {
                            //finding the seat and removing the seat at the same time in this condition
                            if(passengersList.get(passengerCurrCount).seat_no==business_src3_desti2_seats.get(i)){
                                found=true;
                                business_src3_desti2_seats.remove(i);

                                //after removing sorting the arraylist
                                Collections.sort(business_src3_desti2_seats);
                            }
                        }

                        if(found==false){
                            System.out.println("Invalid! Please select a seat from the above available seats");
                            passengersList.get(passengerCurrCount).seat_no=scan.nextInt();
                        }
                    }

                    //The selected seat is being removed from the arraylist successfully
                }
            }

            if(economy_src3_desti2_seats.size()!=0 && business_src3_desti2_seats.size()==0) {
                System.out.println("Airline:\t \tDeparture:\tArrival:\tPrice:\t\tCategory");
                System.out.println("\1.Qantas(1)\t \t08:00\t\t11:05\t\tRs.5400\t\tEconomy");
                System.out.println("\2.Fly Dubai(2)\t14:00\t\t17:05\t\tRs.2500\t\tEconomy");
                System.out.println("\3.Go Air(3)\t \t19:00\t\t22:05\t\tRs.2890\t\tEconomy");
                System.out.println("");

                //getting the flight option from the user
                System.out.println("\nEnter your Flight choice:");
                choice=scan.nextInt();

                //validating the choice
                while(choice<1 || choice>3){
                    System.out.println("Invalid! The choice can only be 1,2 or 3");
                    System.out.println("Enter again..");
                    choice=scan.nextInt();
                }

                //displaying the Availaable Business class seats
                System.out.println("\nSeat numbers available for Economy class booking\n");
                for (int i = 0; i < economy_src3_desti2_seats.size(); i++) {
                    System.out.println("Seat No.: "+economy_src3_desti2_seats.get(i));
                }

                //getting the seat number choice from the user
                System.out.println("\nEnter Seat No.:");
                passengersList.get(passengerCurrCount).seat_no=scan.nextInt();

                //validating the seat number choice
                boolean found=false;
                while(found!=true){

                    for (int i = 0; i < economy_src3_desti2_seats.size(); i++) {
                        //finding the seat and removing the seat at the same time in this condition
                        if(passengersList.get(passengerCurrCount).seat_no==economy_src3_desti2_seats.get(i)){
                            found=true;
                            economy_src3_desti2_seats.remove(i);

                            //after removing sorting the arraylist
                            Collections.sort(economy_src3_desti2_seats);
                        }
                    }

                    if(found==false){
                        System.out.println("Invalid! Please select a seat from the above available seats");
                        passengersList.get(passengerCurrCount).seat_no=scan.nextInt();
                    }
                }

                //The selected seat is being removed from the arraylist successfully
            }

            if(business_src3_desti2_seats.size()!=0 && economy_src3_desti2_seats.size()==0) {
                System.out.println("Airline:\t \tDeparture:\tArrival:\tPrice:\t\tCategory");
                System.out.println("\4.Qantas(1)\t \t08:00\t\t11:05\t\tRs.7400\t\tBusiness");
                System.out.println("\5.Fly Dubai(2)\t14:00\t\t17:05\t\tRs.5500\t\tBusiness");
                System.out.println("\6.Go Air(3)\t \t19:00\t\t22:05\t\tRs.4890\t\tBusiness");
                System.out.println("");

                //getting the flight option from the user
                System.out.println("\nEnter your Flight choice:");
                choice=scan.nextInt();

                //validating the choice
                while(choice<4 || choice>6){
                    System.out.println("Invalid! The choice can only be 4,5 or 6");
                    System.out.println("Enter again..");
                    choice=scan.nextInt();
                }

                //displaying the Availaable Business class seats
                System.out.println("\nSeat numbers available for business class booking\n");
                for (int i = 0; i < business_src3_desti2_seats.size(); i++) {
                    System.out.println("Seat No.: "+business_src3_desti2_seats.get(i));
                }

                //getting the seat number choice from the user
                System.out.println("\nEnter Seat No.:");
                passengersList.get(passengerCurrCount).seat_no=scan.nextInt();

                //validating the seat number choice
                boolean found=false;
                while(found!=true){

                    for (int i = 0; i < business_src3_desti2_seats.size(); i++) {
                        //finding the seat and removing the seat at the same time in this condition
                        if(passengersList.get(passengerCurrCount).seat_no==business_src3_desti2_seats.get(i)){
                            found=true;
                            business_src3_desti2_seats.remove(i);

                            //after removing sorting the arraylist
                            Collections.sort(business_src3_desti2_seats);
                        }
                    }

                    if(found==false){
                        System.out.println("Invalid! Please select a seat from the above available seats");
                        passengersList.get(passengerCurrCount).seat_no=scan.nextInt();
                    }
                }

                //The selected seat is being removed from the arraylist successfully
            }

            //setting the src and dest variables of the passenger class because it will later help in
            //identifying in which arraylist to add the cancelled seat (seat cancelled by the passenger)
            passengersList.get(passengerCurrCount).src=3;
            passengersList.get(passengerCurrCount).dest=2;
            passengersList.get(passengerCurrCount).source="Melbourne";
            passengersList.get(passengerCurrCount).destination="Sydney";

        }

        else if( (src==3 &&  dest==4) )//condition
        {
            //original code
            /*System.out.println("\n\t \t \t \t \tFlights Found");
            System.out.println("");
            System.out.println("Airline:\t \tDeparture:\tArrival:\tPrice:\t\tCategory");
            System.out.println("\1.Qantas(1)\t \t08:00\t\t11:05\t\tRs.5800\t\tEconomy");
            System.out.println("\2.Fly Dubai(2)\t14:00\t\t17:05\t\tRs.5508\t\tEconomy");
            System.out.println("\3.Go Air(3)\t \t19:00\t\t22:05\t\tRs.6050\t\tEconomy");

            System.out.println("");
            System.out.println("Airline:\t \tDeparture:\tArrival:\tPrice:\t\tCategory");
            System.out.println("\4.Qantas(1)\t \t08:00\t\t11:05\t\tRs.7800\t\tBusiness");
            System.out.println("\5.Fly Dubai(2)\t14:00\t\t17:05\t\tRs.7508\t\tBusiness");
            System.out.println("\6.Go Air(3)\t \t19:00\t\t22:05\t\tRs.8050\t\tBusiness");
            */
            //////////////////////////////////////////////////////////////////////////////

            //checking the availability of the seats in the economy and business class
            if(economy_src3_desti4_seats.size()==0 && business_src3_desti4_seats.size()==0){

                char option;
                System.out.println("\nNo seats available in the business and economy class");
                System.out.println("Do you wish to make another Reservation (y/n):");
                option= scan.next().charAt(0);

                while ( (option!='y') && (option!='n') ){
                    System.out.println("Invalid! Please enter y (for yes) or n (for no)");
                    System.out.println("Enter again..");
                    option= scan.next().charAt(0);
                }

                if(option=='n'){
                    passengersList.remove(passengerCurrCount);
                    passengerCurrCount--;
                    g.glob--;
                    return 0;
                }

                else if(option=='y'){
                    return j_detail();
                }

            }

            //Printing the process if these are no seats available in the economy class
            if(economy_src3_desti4_seats.size()==0){
                System.out.println("\nNo seats are available in the Economy class. Only Business class seats are avaiable");
                System.out.println("Do you wish to make another Reservation (y/n/e)");
                System.out.println("Enter 'y' to make another Reservation. Enter 'n' to continue with the business class booking");
                System.out.println("Enter e for exit");
                char option= scan.next().charAt(0);

                while ( (option!='y') && (option!='n' && (option!='e')) ){
                    System.out.println("Invalid! Please enter y (for yes) or n (for no) or e (for exit)");
                    System.out.println("Enter again..");
                    option= scan.next().charAt(0);
                }

                if(option=='e'){
                    passengersList.remove(passengerCurrCount);
                    passengerCurrCount--;
                    g.glob--;
                    return 0;
                }

                else if(option=='y'){
                    return j_detail();
                }
            }

            //Printing the process if these are no seats available in the business class
            if(business_src3_desti4_seats.size()==0){
                System.out.println("\nNo seats are available in the Business class. Only Economy class seats are avaiable");
                System.out.println("Do you wish to make another Reservation (y/n/e)");
                System.out.println("Enter 'y' to make another Reservation. Enter 'n' to continue with the Economy class booking");
                System.out.println("Enter e to exit");
                char option= scan.next().charAt(0);

                while ( (option!='y') && (option!='n') && (option!='e') ){
                    System.out.println("Invalid! Please enter y (for yes) or n (for no) or e (for exit)");
                    System.out.println("Enter again..");
                    option= scan.next().charAt(0);
                }

                if(option=='e'){
                    passengersList.remove(passengerCurrCount);
                    passengerCurrCount--;
                    g.glob--;
                    return 0;
                }

                else if(option=='y'){
                    return j_detail();
                }
            }

            System.out.println("\n\t \t \t \t \t \tFlights Found");
            System.out.println("");

            if( (business_src3_desti4_seats.size()!=0) && (economy_src3_desti4_seats.size()!=0) ){
                System.out.println("Airline:\t \tDeparture:\tArrival:\tPrice:\t\tCategory");
                System.out.println("\1.Qantas(1)\t \t08:00\t\t11:05\t\tRs.5800\t\tEconomy");
                System.out.println("\2.Fly Dubai(2)\t14:00\t\t17:05\t\tRs.5508\t\tEconomy");
                System.out.println("\3.Go Air(3)\t \t19:00\t\t22:05\t\tRs.6050\t\tEconomy");

                System.out.println("");
                System.out.println("Airline:\t \tDeparture:\tArrival:\tPrice:\t\tCategory");
                System.out.println("\4.Qantas(1)\t \t08:00\t\t11:05\t\tRs.7800\t\tBusiness");
                System.out.println("\5.Fly Dubai(2)\t14:00\t\t17:05\t\tRs.7508\t\tBusiness");
                System.out.println("\6.Go Air(3)\t \t19:00\t\t22:05\t\tRs.8050\t\tBusiness");

                //getting the flight option from the user
                System.out.println("\nEnter your Flight choice:");
                choice=scan.nextInt();

                //validating the choice
                while(choice<1 || choice>6){
                    System.out.println("Invalid! The choice can only be 1,2,3,4,5 or 6");
                    System.out.println("Enter again..");
                    choice=scan.nextInt();
                }

                //condition for selection from Economy class
                if(choice>=1 && choice<4){
                    //displaying the Availaable Business class seats
                    System.out.println("\nSeat numbers available for Economy class booking\n");
                    for (int i = 0; i < economy_src3_desti4_seats.size(); i++) {
                        System.out.println("Seat No.: "+economy_src3_desti4_seats.get(i));
                    }

                    //getting the seat number choice from the user
                    System.out.println("\nEnter Seat No.:");
                    passengersList.get(passengerCurrCount).seat_no=scan.nextInt();

                    //validating the seat number choice
                    boolean found=false;
                    while(found!=true){

                        for (int i = 0; i < economy_src3_desti4_seats.size(); i++) {
                            //finding the seat and removing the seat at the same time in this condition
                            if(passengersList.get(passengerCurrCount).seat_no==economy_src3_desti4_seats.get(i)){
                                found=true;
                                economy_src3_desti4_seats.remove(i);

                                //after removing sorting the arraylist
                                Collections.sort(economy_src3_desti4_seats);
                            }
                        }

                        if(found==false){
                            System.out.println("Invalid! Please select a seat from the above available seats");
                            passengersList.get(passengerCurrCount).seat_no=scan.nextInt();
                        }
                    }

                    //The selected seat is being removed from the arraylist successfully
                }

                //condition for selection from the business class
                if(choice>3 && choice<7){
                    //displaying the Availaable Business class seats
                    System.out.println("\nSeat numbers available for business class booking\n");
                    for (int i = 0; i < business_src3_desti4_seats.size(); i++) {
                        System.out.println("Seat No.: "+business_src3_desti4_seats.get(i));
                    }

                    //getting the seat number choice from the user
                    System.out.println("\nEnter Seat No.:");
                    passengersList.get(passengerCurrCount).seat_no=scan.nextInt();

                    //validating the seat number choice
                    boolean found=false;
                    while(found!=true){

                        for (int i = 0; i < business_src3_desti4_seats.size(); i++) {
                            //finding the seat and removing the seat at the same time in this condition
                            if(passengersList.get(passengerCurrCount).seat_no==business_src3_desti4_seats.get(i)){
                                found=true;
                                business_src3_desti4_seats.remove(i);

                                //after removing sorting the arraylist
                                Collections.sort(business_src3_desti4_seats);
                            }
                        }

                        if(found==false){
                            System.out.println("Invalid! Please select a seat from the above available seats");
                            passengersList.get(passengerCurrCount).seat_no=scan.nextInt();
                        }
                    }

                    //The selected seat is being removed from the arraylist successfully
                }
            }

            if(economy_src3_desti4_seats.size()!=0 && business_src3_desti4_seats.size()==0) {
                System.out.println("Airline:\t \tDeparture:\tArrival:\tPrice:\t\tCategory");
                System.out.println("\1.Qantas(1)\t \t08:00\t\t11:05\t\tRs.5800\t\tEconomy");
                System.out.println("\2.Fly Dubai(2)\t14:00\t\t17:05\t\tRs.5508\t\tEconomy");
                System.out.println("\3.Go Air(3)\t \t19:00\t\t22:05\t\tRs.6050\t\tEconomy");
                System.out.println("");

                //getting the flight option from the user
                System.out.println("\nEnter your Flight choice:");
                choice=scan.nextInt();

                //validating the choice
                while(choice<1 || choice>3){
                    System.out.println("Invalid! The choice can only be 1,2 or 3");
                    System.out.println("Enter again..");
                    choice=scan.nextInt();
                }

                //displaying the Availaable Business class seats
                System.out.println("\nSeat numbers available for Economy class booking\n");
                for (int i = 0; i < economy_src3_desti4_seats.size(); i++) {
                    System.out.println("Seat No.: "+economy_src3_desti4_seats.get(i));
                }

                //getting the seat number choice from the user
                System.out.println("\nEnter Seat No.:");
                passengersList.get(passengerCurrCount).seat_no=scan.nextInt();

                //validating the seat number choice
                boolean found=false;
                while(found!=true){

                    for (int i = 0; i < economy_src3_desti4_seats.size(); i++) {
                        //finding the seat and removing the seat at the same time in this condition
                        if(passengersList.get(passengerCurrCount).seat_no==economy_src3_desti4_seats.get(i)){
                            found=true;
                            economy_src3_desti4_seats.remove(i);

                            //after removing sorting the arraylist
                            Collections.sort(economy_src3_desti4_seats);
                        }
                    }

                    if(found==false){
                        System.out.println("Invalid! Please select a seat from the above available seats");
                        passengersList.get(passengerCurrCount).seat_no=scan.nextInt();
                    }
                }

                //The selected seat is being removed from the arraylist successfully
            }

            if(business_src3_desti4_seats.size()!=0 && economy_src3_desti4_seats.size()==0) {
                System.out.println("Airline:\t \tDeparture:\tArrival:\tPrice:\t\tCategory");
                System.out.println("\4.Qantas(1)\t \t08:00\t\t11:05\t\tRs.7800\t\tBusiness");
                System.out.println("\5.Fly Dubai(2)\t14:00\t\t17:05\t\tRs.7508\t\tBusiness");
                System.out.println("\6.Go Air(3)\t \t19:00\t\t22:05\t\tRs.8050\t\tBusiness");
                System.out.println("");

                //getting the flight option from the user
                System.out.println("\nEnter your Flight choice:");
                choice=scan.nextInt();

                //validating the choice
                while(choice<4 || choice>6){
                    System.out.println("Invalid! The choice can only be 4,5 or 6");
                    System.out.println("Enter again..");
                    choice=scan.nextInt();
                }

                //displaying the Availaable Business class seats
                System.out.println("\nSeat numbers available for business class booking\n");
                for (int i = 0; i < business_src3_desti4_seats.size(); i++) {
                    System.out.println("Seat No.: "+business_src3_desti4_seats.get(i));
                }

                //getting the seat number choice from the user
                System.out.println("\nEnter Seat No.:");
                passengersList.get(passengerCurrCount).seat_no=scan.nextInt();

                //validating the seat number choice
                boolean found=false;
                while(found!=true){

                    for (int i = 0; i < business_src3_desti4_seats.size(); i++) {
                        //finding the seat and removing the seat at the same time in this condition
                        if(passengersList.get(passengerCurrCount).seat_no==business_src3_desti4_seats.get(i)){
                            found=true;
                            business_src3_desti4_seats.remove(i);

                            //after removing sorting the arraylist
                            Collections.sort(business_src3_desti4_seats);
                        }
                    }

                    if(found==false){
                        System.out.println("Invalid! Please select a seat from the above available seats");
                        passengersList.get(passengerCurrCount).seat_no=scan.nextInt();
                    }
                }

                //The selected seat is being removed from the arraylist successfully
            }

            //setting the src and dest variables of the passenger class because it will later help in
            //identifying in which arraylist to add the cancelled seat (seat cancelled by the passenger)
            passengersList.get(passengerCurrCount).src=3;
            passengersList.get(passengerCurrCount).dest=4;
            passengersList.get(passengerCurrCount).source="Melbourne";
            passengersList.get(passengerCurrCount).destination="Canberra";
        }

        else if( ( src==4 &&  dest==1) )//condition
        {
            //original code
            /*System.out.println("\n\t \t \t \t \t \tFlights Found");
            System.out.println("");
            System.out.println("Airline:\t \tDeparture:\tArrival:\tPrice:\t\tCategory");
            System.out.println("\1.Qantas(1)\t \t08:00\t\t11:05\t\tRs.4000\t\tEconomy");
            System.out.println("\2.Fly Dubai(2)\t14:00\t\t17:05\t\tRs.4250\t\tEconomy");
            System.out.println("\3.Go Air(3)\t \t19:00\t\t22:05\t\tRs.6100\t\tEconomy");

            System.out.println("");
            System.out.println("Airline:\t \tDeparture:\tArrival:\tPrice:\t\tCategory");
            System.out.println("\1.Qantas(1)\t \t08:00\t\t11:05\t\tRs.6000\t\tBusiness");
            System.out.println("\2.Fly Dubai(2)\t14:00\t\t17:05\t\tRs.6250\t\tBusiness");
            System.out.println("\3.Go Air(3)\t \t19:00\t\t22:05\t\tRs.8100\t\tBusiness");
            */
            ////////////////////////////////////////////////////////////////////////////

            //checking the availability of the seats in the economy and business class
            if(economy_src4_desti1_seats.size()==0 && business_src4_desti1_seats.size()==0){

                char option;
                System.out.println("\nNo seats available in the business and economy class");
                System.out.println("Do you wish to make another Reservation (y/n):");
                option= scan.next().charAt(0);

                while ( (option!='y') && (option!='n') ){
                    System.out.println("Invalid! Please enter y (for yes) or n (for no)");
                    System.out.println("Enter again..");
                    option= scan.next().charAt(0);
                }

                if(option=='n'){
                    passengersList.remove(passengerCurrCount);
                    passengerCurrCount--;
                    g.glob--;
                    return 0;
                }

                else if(option=='y'){
                    return j_detail();
                }

            }

            //Printing the process if these are no seats available in the economy class
            if(economy_src4_desti1_seats.size()==0){
                System.out.println("\nNo seats are available in the Economy class. Only Business class seats are avaiable");
                System.out.println("Do you wish to make another Reservation (y/n/e)");
                System.out.println("Enter 'y' to make another Reservation. Enter 'n' to continue with the business class booking");
                System.out.println("Enter e for exit");
                char option= scan.next().charAt(0);

                while ( (option!='y') && (option!='n' && (option!='e')) ){
                    System.out.println("Invalid! Please enter y (for yes) or n (for no) or e (for exit)");
                    System.out.println("Enter again..");
                    option= scan.next().charAt(0);
                }

                if(option=='e'){
                    passengersList.remove(passengerCurrCount);
                    passengerCurrCount--;
                    g.glob--;
                    return 0;
                }

                else if(option=='y'){
                    return j_detail();
                }
            }

            //Printing the process if these are no seats available in the business class
            if(business_src4_desti1_seats.size()==0){
                System.out.println("\nNo seats are available in the Business class. Only Economy class seats are avaiable");
                System.out.println("Do you wish to make another Reservation (y/n/e)");
                System.out.println("Enter 'y' to make another Reservation. Enter 'n' to continue with the Economy class booking");
                System.out.println("Enter e to exit");
                char option= scan.next().charAt(0);

                while ( (option!='y') && (option!='n') && (option!='e') ){
                    System.out.println("Invalid! Please enter y (for yes) or n (for no) or e (for exit)");
                    System.out.println("Enter again..");
                    option= scan.next().charAt(0);
                }

                if(option=='e'){
                    passengersList.remove(passengerCurrCount);
                    passengerCurrCount--;
                    g.glob--;
                    return 0;
                }

                else if(option=='y'){
                    return j_detail();
                }
            }

            System.out.println("\n\t \t \t \t \t \tFlights Found");
            System.out.println("");

            if( (business_src4_desti1_seats.size()!=0) && (economy_src4_desti1_seats.size()!=0) ){
                System.out.println("Airline:\t \tDeparture:\tArrival:\tPrice:\t\tCategory");
                System.out.println("\1.Qantas(1)\t \t08:00\t\t11:05\t\tRs.4000\t\tEconomy");
                System.out.println("\2.Fly Dubai(2)\t14:00\t\t17:05\t\tRs.4250\t\tEconomy");
                System.out.println("\3.Go Air(3)\t \t19:00\t\t22:05\t\tRs.6100\t\tEconomy");

                System.out.println("");
                System.out.println("Airline:\t \tDeparture:\tArrival:\tPrice:\t\tCategory");
                System.out.println("\4.Qantas(1)\t \t08:00\t\t11:05\t\tRs.6000\t\tBusiness");
                System.out.println("\5.Fly Dubai(2)\t14:00\t\t17:05\t\tRs.6250\t\tBusiness");
                System.out.println("\6.Go Air(3)\t \t19:00\t\t22:05\t\tRs.8100\t\tBusiness");

                //getting the flight option from the user
                System.out.println("\nEnter your Flight choice:");
                choice=scan.nextInt();

                //validating the choice
                while(choice<1 || choice>6){
                    System.out.println("Invalid! The choice can only be 1,2,3,4,5 or 6");
                    System.out.println("Enter again..");
                    choice=scan.nextInt();
                }

                //condition for selection from Economy class
                if(choice>=1 && choice<4){
                    //displaying the Availaable Business class seats
                    System.out.println("\nSeat numbers available for Economy class booking\n");
                    for (int i = 0; i < economy_src4_desti1_seats.size(); i++) {
                        System.out.println("Seat No.: "+economy_src4_desti1_seats.get(i));
                    }

                    //getting the seat number choice from the user
                    System.out.println("\nEnter Seat No.:");
                    passengersList.get(passengerCurrCount).seat_no=scan.nextInt();

                    //validating the seat number choice
                    boolean found=false;
                    while(found!=true){

                        for (int i = 0; i < economy_src4_desti1_seats.size(); i++) {
                            //finding the seat and removing the seat at the same time in this condition
                            if(passengersList.get(passengerCurrCount).seat_no==economy_src4_desti1_seats.get(i)){
                                found=true;
                                economy_src4_desti1_seats.remove(i);

                                //after removing sorting the arraylist
                                Collections.sort(economy_src4_desti1_seats);
                            }
                        }

                        if(found==false){
                            System.out.println("Invalid! Please select a seat from the above available seats");
                            passengersList.get(passengerCurrCount).seat_no=scan.nextInt();
                        }
                    }

                    //The selected seat is being removed from the arraylist successfully
                }

                //condition for selection from the business class
                if(choice>3 && choice<7){
                    //displaying the Availaable Business class seats
                    System.out.println("\nSeat numbers available for business class booking\n");
                    for (int i = 0; i < business_src4_desti1_seats.size(); i++) {
                        System.out.println("Seat No.: "+business_src4_desti1_seats.get(i));
                    }

                    //getting the seat number choice from the user
                    System.out.println("\nEnter Seat No.:");
                    passengersList.get(passengerCurrCount).seat_no=scan.nextInt();

                    //validating the seat number choice
                    boolean found=false;
                    while(found!=true){

                        for (int i = 0; i < business_src4_desti1_seats.size(); i++) {
                            //finding the seat and removing the seat at the same time in this condition
                            if(passengersList.get(passengerCurrCount).seat_no==business_src4_desti1_seats.get(i)){
                                found=true;
                                business_src4_desti1_seats.remove(i);

                                //after removing sorting the arraylist
                                Collections.sort(business_src4_desti1_seats);
                            }
                        }

                        if(found==false){
                            System.out.println("Invalid! Please select a seat from the above available seats");
                            passengersList.get(passengerCurrCount).seat_no=scan.nextInt();
                        }
                    }

                    //The selected seat is being removed from the arraylist successfully
                }
            }

            if(economy_src4_desti1_seats.size()!=0 && business_src4_desti1_seats.size()==0) {
                System.out.println("Airline:\t \tDeparture:\tArrival:\tPrice:\t\tCategory");
                System.out.println("\1.Qantas(1)\t \t08:00\t\t11:05\t\tRs.4000\t\tEconomy");
                System.out.println("\2.Fly Dubai(2)\t14:00\t\t17:05\t\tRs.4250\t\tEconomy");
                System.out.println("\3.Go Air(3)\t \t19:00\t\t22:05\t\tRs.6100\t\tEconomy");
                System.out.println("");

                //getting the flight option from the user
                System.out.println("\nEnter your Flight choice:");
                choice=scan.nextInt();

                //validating the choice
                while(choice<1 || choice>3){
                    System.out.println("Invalid! The choice can only be 1,2 or 3");
                    System.out.println("Enter again..");
                    choice=scan.nextInt();
                }

                //displaying the Availaable Business class seats
                System.out.println("\nSeat numbers available for Economy class booking\n");
                for (int i = 0; i < economy_src4_desti1_seats.size(); i++) {
                    System.out.println("Seat No.: "+economy_src1_desti4_seats.get(i));
                }

                //getting the seat number choice from the user
                System.out.println("\nEnter Seat No.:");
                passengersList.get(passengerCurrCount).seat_no=scan.nextInt();

                //validating the seat number choice
                boolean found=false;
                while(found!=true){

                    for (int i = 0; i < economy_src4_desti1_seats.size(); i++) {
                        //finding the seat and removing the seat at the same time in this condition
                        if(passengersList.get(passengerCurrCount).seat_no==economy_src4_desti1_seats.get(i)){
                            found=true;
                            economy_src4_desti1_seats.remove(i);

                            //after removing sorting the arraylist
                            Collections.sort(economy_src4_desti1_seats);
                        }
                    }

                    if(found==false){
                        System.out.println("Invalid! Please select a seat from the above available seats");
                        passengersList.get(passengerCurrCount).seat_no=scan.nextInt();
                    }
                }

                //The selected seat is being removed from the arraylist successfully
            }

            if(business_src4_desti1_seats.size()!=0 && economy_src4_desti1_seats.size()==0) {
                System.out.println("Airline:\t \tDeparture:\tArrival:\tPrice:\t\tCategory");
                System.out.println("\4.Qantas(1)\t \t08:00\t\t11:05\t\tRs.6000\t\tBusiness");
                System.out.println("\5.Fly Dubai(2)\t14:00\t\t17:05\t\tRs.6250\t\tBusiness");
                System.out.println("\6.Go Air(3)\t \t19:00\t\t22:05\t\tRs.8100\t\tBusiness");

                //getting the flight option from the user
                System.out.println("\nEnter your Flight choice:");
                choice=scan.nextInt();

                //validating the choice
                while(choice<4 || choice>6){
                    System.out.println("Invalid! The choice can only be 4,5 or 6");
                    System.out.println("Enter again..");
                    choice=scan.nextInt();
                }

                //displaying the Availaable Business class seats
                System.out.println("\nSeat numbers available for business class booking\n");
                for (int i = 0; i < business_src4_desti1_seats.size(); i++) {
                    System.out.println("Seat No.: "+business_src4_desti1_seats.get(i));
                }

                //getting the seat number choice from the user
                System.out.println("\nEnter Seat No.:");
                passengersList.get(passengerCurrCount).seat_no=scan.nextInt();

                //validating the seat number choice
                boolean found=false;
                while(found!=true){

                    for (int i = 0; i < business_src4_desti1_seats.size(); i++) {
                        //finding the seat and removing the seat at the same time in this condition
                        if(passengersList.get(passengerCurrCount).seat_no==business_src4_desti1_seats.get(i)){
                            found=true;
                            business_src4_desti1_seats.remove(i);

                            //after removing sorting the arraylist
                            Collections.sort(business_src4_desti1_seats);
                        }
                    }

                    if(found==false){
                        System.out.println("Invalid! Please select a seat from the above available seats");
                        passengersList.get(passengerCurrCount).seat_no=scan.nextInt();
                    }
                }

                //The selected seat is being removed from the arraylist successfully
            }

            //setting the src and dest variables of the passenger class because it will later help in
            //identifying in which arraylist to add the cancelled seat (seat cancelled by the passenger)
            passengersList.get(passengerCurrCount).src=4;
            passengersList.get(passengerCurrCount).dest=1;
            passengersList.get(passengerCurrCount).source="Canberra";
            passengersList.get(passengerCurrCount).destination="Brisbane";
        }

        else if( ( src==4 && dest==2) )//condition
        {
            //original code
            /*System.out.println("\n\t \t \t \t \t \tFlights Found");
            System.out.println("");
            System.out.println("Airline:\t \tDeparture:\tArrival:\tPrice:\t\tCategory");
            System.out.println("\1.Qantas(1)\t \t08:00\t\t11:05\t\tRs.5000\t\tEconomy");
            System.out.println("\2.Fly Dubai(2)\t14:00\t\t17:05\t\tRs.4500\t\tEconomy");
            System.out.println("\3.Go Air(3)\t \t19:00\t\t22:05\t\tRs.6000\t\tEconomy");

            System.out.println("");
            System.out.println("Airline:\t \tDeparture:\tArrival:\tPrice:\t\tCategory");
            System.out.println("\1.Qantas(1)\t \t08:00\t\t11:05\t\tRs.5000\t\tBusiness");
            System.out.println("\2.Fly Dubai(2)\t14:00\t\t17:05\t\tRs.4500\t\tBusiness");
            System.out.println("\3.Go Air(3)\t \t19:00\t\t22:05\t\tRs.6000\t\tBusiness");
            */
            ///////////////////////////////////////////////////////////////////////////

            //checking the availability of the seats in the economy and business class
            if(economy_src4_desti2_seats.size()==0 && business_src4_desti2_seats.size()==0){

                char option;
                System.out.println("\nNo seats available in the business and economy class");
                System.out.println("Do you wish to make another Reservation (y/n):");
                option= scan.next().charAt(0);

                while ( (option!='y') && (option!='n') ){
                    System.out.println("Invalid! Please enter y (for yes) or n (for no)");
                    System.out.println("Enter again..");
                    option= scan.next().charAt(0);
                }

                if(option=='n'){
                    passengersList.remove(passengerCurrCount);
                    passengerCurrCount--;
                    g.glob--;
                    return 0;
                }

                else if(option=='y'){
                    return j_detail();
                }

            }

            //Printing the process if these are no seats available in the economy class
            if(economy_src4_desti2_seats.size()==0){
                System.out.println("\nNo seats are available in the Economy class. Only Business class seats are avaiable");
                System.out.println("Do you wish to make another Reservation (y/n/e)");
                System.out.println("Enter 'y' to make another Reservation. Enter 'n' to continue with the business class booking");
                System.out.println("Enter e for exit");
                char option= scan.next().charAt(0);

                while ( (option!='y') && (option!='n' && (option!='e')) ){
                    System.out.println("Invalid! Please enter y (for yes) or n (for no) or e (for exit)");
                    System.out.println("Enter again..");
                    option= scan.next().charAt(0);
                }

                if(option=='e'){
                    passengersList.remove(passengerCurrCount);
                    passengerCurrCount--;
                    g.glob--;
                    return 0;
                }

                else if(option=='y'){
                    return j_detail();
                }
            }

            //Printing the process if these are no seats available in the business class
            if(business_src4_desti2_seats.size()==0){
                System.out.println("\nNo seats are available in the Business class. Only Economy class seats are avaiable");
                System.out.println("Do you wish to make another Reservation (y/n/e)");
                System.out.println("Enter 'y' to make another Reservation. Enter 'n' to continue with the Economy class booking");
                System.out.println("Enter e to exit");
                char option= scan.next().charAt(0);

                while ( (option!='y') && (option!='n') && (option!='e') ){
                    System.out.println("Invalid! Please enter y (for yes) or n (for no) or e (for exit)");
                    System.out.println("Enter again..");
                    option= scan.next().charAt(0);
                }

                if(option=='e'){
                    passengersList.remove(passengerCurrCount);
                    passengerCurrCount--;
                    g.glob--;
                    return 0;
                }

                else if(option=='y'){
                    return j_detail();
                }
            }

            System.out.println("\n\t \t \t \t \t \tFlights Found");
            System.out.println("");

            if( (business_src4_desti2_seats.size()!=0) && (economy_src4_desti2_seats.size()!=0) ){
                System.out.println("Airline:\t \tDeparture:\tArrival:\tPrice:\t\tCategory");
                System.out.println("\1.Qantas(1)\t \t08:00\t\t11:05\t\tRs.5400\t\tEconomy");
                System.out.println("\2.Fly Dubai(2)\t14:00\t\t17:05\t\tRs.2500\t\tEconomy");
                System.out.println("\3.Go Air(3)\t \t19:00\t\t22:05\t\tRs.2890\t\tEconomy");

                System.out.println("");
                System.out.println("Airline:\t \tDeparture:\tArrival:\tPrice:\t\tCategory");
                System.out.println("\4.Qantas(1)\t \t08:00\t\t11:05\t\tRs.7400\t\tBusiness");
                System.out.println("\5.Fly Dubai(2)\t14:00\t\t17:05\t\tRs.5500\t\tBusiness");
                System.out.println("\6.Go Air(3)\t \t19:00\t\t22:05\t\tRs.4890\t\tBusiness");

                //getting the flight option from the user
                System.out.println("\nEnter your Flight choice:");
                choice=scan.nextInt();

                //validating the choice
                while(choice<1 || choice>6){
                    System.out.println("Invalid! The choice can only be 1,2,3,4,5 or 6");
                    System.out.println("Enter again..");
                    choice=scan.nextInt();
                }

                //condition for selection from Economy class
                if(choice>=1 && choice<4){
                    //displaying the Availaable Business class seats
                    System.out.println("\nSeat numbers available for Economy class booking\n");
                    for (int i = 0; i < economy_src4_desti2_seats.size(); i++) {
                        System.out.println("Seat No.: "+economy_src4_desti2_seats.get(i));
                    }

                    //getting the seat number choice from the user
                    System.out.println("\nEnter Seat No.:");
                    passengersList.get(passengerCurrCount).seat_no=scan.nextInt();

                    //validating the seat number choice
                    boolean found=false;
                    while(found!=true){

                        for (int i = 0; i < economy_src4_desti2_seats.size(); i++) {
                            //finding the seat and removing the seat at the same time in this condition
                            if(passengersList.get(passengerCurrCount).seat_no==economy_src4_desti2_seats.get(i)){
                                found=true;
                                economy_src4_desti2_seats.remove(i);

                                //after removing sorting the arraylist
                                Collections.sort(economy_src4_desti2_seats);
                            }
                        }

                        if(found==false){
                            System.out.println("Invalid! Please select a seat from the above available seats");
                            passengersList.get(passengerCurrCount).seat_no=scan.nextInt();
                        }
                    }

                    //The selected seat is being removed from the arraylist successfully
                }

                //condition for selection from the business class
                if(choice>3 && choice<7){
                    //displaying the Availaable Business class seats
                    System.out.println("\nSeat numbers available for business class booking\n");
                    for (int i = 0; i < business_src4_desti2_seats.size(); i++) {
                        System.out.println("Seat No.: "+business_src4_desti2_seats.get(i));
                    }

                    //getting the seat number choice from the user
                    System.out.println("\nEnter Seat No.:");
                    passengersList.get(passengerCurrCount).seat_no=scan.nextInt();

                    //validating the seat number choice
                    boolean found=false;
                    while(found!=true){

                        for (int i = 0; i < business_src4_desti2_seats.size(); i++) {
                            //finding the seat and removing the seat at the same time in this condition
                            if(passengersList.get(passengerCurrCount).seat_no==business_src4_desti2_seats.get(i)){
                                found=true;
                                business_src4_desti2_seats.remove(i);

                                //after removing sorting the arraylist
                                Collections.sort(business_src4_desti2_seats);
                            }
                        }

                        if(found==false){
                            System.out.println("Invalid! Please select a seat from the above available seats");
                            passengersList.get(passengerCurrCount).seat_no=scan.nextInt();
                        }
                    }

                    //The selected seat is being removed from the arraylist successfully
                }
            }

            if(economy_src4_desti2_seats.size()!=0 && business_src4_desti2_seats.size()==0) {
                System.out.println("Airline:\t \tDeparture:\tArrival:\tPrice:\t\tCategory");
                System.out.println("\1.Qantas(1)\t \t08:00\t\t11:05\t\tRs.5400\t\tEconomy");
                System.out.println("\2.Fly Dubai(2)\t14:00\t\t17:05\t\tRs.2500\t\tEconomy");
                System.out.println("\3.Go Air(3)\t \t19:00\t\t22:05\t\tRs.2890\t\tEconomy");
                System.out.println("");

                //getting the flight option from the user
                System.out.println("\nEnter your Flight choice:");
                choice=scan.nextInt();

                //validating the choice
                while(choice<1 || choice>3){
                    System.out.println("Invalid! The choice can only be 1,2 or 3");
                    System.out.println("Enter again..");
                    choice=scan.nextInt();
                }

                //displaying the Availaable Business class seats
                System.out.println("\nSeat numbers available for Economy class booking\n");
                for (int i = 0; i < economy_src4_desti2_seats.size(); i++) {
                    System.out.println("Seat No.: "+economy_src4_desti2_seats.get(i));
                }

                //getting the seat number choice from the user
                System.out.println("\nEnter Seat No.:");
                passengersList.get(passengerCurrCount).seat_no=scan.nextInt();

                //validating the seat number choice
                boolean found=false;
                while(found!=true){

                    for (int i = 0; i < economy_src4_desti2_seats.size(); i++) {
                        //finding the seat and removing the seat at the same time in this condition
                        if(passengersList.get(passengerCurrCount).seat_no==economy_src4_desti2_seats.get(i)){
                            found=true;
                            economy_src4_desti2_seats.remove(i);

                            //after removing sorting the arraylist
                            Collections.sort(economy_src4_desti2_seats);
                        }
                    }

                    if(found==false){
                        System.out.println("Invalid! Please select a seat from the above available seats");
                        passengersList.get(passengerCurrCount).seat_no=scan.nextInt();
                    }
                }

                //The selected seat is being removed from the arraylist successfully
            }

            if(business_src4_desti2_seats.size()!=0 && economy_src4_desti2_seats.size()==0) {
                System.out.println("Airline:\t \tDeparture:\tArrival:\tPrice:\t\tCategory");
                System.out.println("\4.Qantas(1)\t \t08:00\t\t11:05\t\tRs.7400\t\tBusiness");
                System.out.println("\5.Fly Dubai(2)\t14:00\t\t17:05\t\tRs.5500\t\tBusiness");
                System.out.println("\6.Go Air(3)\t \t19:00\t\t22:05\t\tRs.4890\t\tBusiness");
                System.out.println("");

                //getting the flight option from the user
                System.out.println("\nEnter your Flight choice:");
                choice=scan.nextInt();

                //validating the choice
                while(choice<4 || choice>6){
                    System.out.println("Invalid! The choice can only be 4,5 or 6");
                    System.out.println("Enter again..");
                    choice=scan.nextInt();
                }

                //displaying the Availaable Business class seats
                System.out.println("\nSeat numbers available for business class booking\n");
                for (int i = 0; i < business_src4_desti2_seats.size(); i++) {
                    System.out.println("Seat No.: "+business_src4_desti2_seats.get(i));
                }

                //getting the seat number choice from the user
                System.out.println("\nEnter Seat No.:");
                passengersList.get(passengerCurrCount).seat_no=scan.nextInt();

                //validating the seat number choice
                boolean found=false;
                while(found!=true){

                    for (int i = 0; i < business_src4_desti2_seats.size(); i++) {
                        //finding the seat and removing the seat at the same time in this condition
                        if(passengersList.get(passengerCurrCount).seat_no==business_src4_desti2_seats.get(i)){
                            found=true;
                            business_src4_desti2_seats.remove(i);

                            //after removing sorting the arraylist
                            Collections.sort(business_src4_desti2_seats);
                        }
                    }

                    if(found==false){
                        System.out.println("Invalid! Please select a seat from the above available seats");
                        passengersList.get(passengerCurrCount).seat_no=scan.nextInt();
                    }
                }

                //The selected seat is being removed from the arraylist successfully
            }

            //setting the src and dest variables of the passenger class because it will later help in
            //identifying in which arraylist to add the cancelled seat (seat cancelled by the passenger)
            passengersList.get(passengerCurrCount).src=4;
            passengersList.get(passengerCurrCount).dest=2;
            passengersList.get(passengerCurrCount).source="Canberra";
            passengersList.get(passengerCurrCount).destination="Sydney";

        }

        else if( ( src==4 &&  dest==3) )//condition
        {
            //original code
            /*System.out.println("\n\t \t \t \t \tFlights Found");
            System.out.println("");
            System.out.println("Airline:\t \tDeparture:\tArrival:\tPrice:\t\tCategory");
            System.out.println("\1.Qantas(1)\t \t08:00\t\t11:05\t\tRs.5800\t\tEconomy");
            System.out.println("\2.Fly Dubai(2)\t14:00\t\t17:05\t\tRs.5508\t\tEconomy");
            System.out.println("\3.Go Air(3)\t \t19:00\t\t22:05\t\tRs.6050\t\tEconomy");

            System.out.println("");
            System.out.println("Airline:\t \tDeparture:\tArrival:\tPrice:\t\tCategory");
            System.out.println("\4.Qantas(1)\t \t08:00\t\t11:05\t\tRs.7800\t\tBusiness");
            System.out.println("\5.Fly Dubai(2)\t14:00\t\t17:05\t\tRs.7508\t\tBusiness");
            System.out.println("\6.Go Air(3)\t \t19:00\t\t22:05\t\tRs.8050\t\tBusiness");
            */
            //////////////////////////////////////////////////////////////////////////////

            //checking the availability of the seats in the economy and business class
            if(economy_src4_desti3_seats.size()==0 && business_src4_desti3_seats.size()==0){

                char option;
                System.out.println("\nNo seats available in the business and economy class");
                System.out.println("Do you wish to make another Reservation (y/n):");
                option= scan.next().charAt(0);

                while ( (option!='y') && (option!='n') ){
                    System.out.println("Invalid! Please enter y (for yes) or n (for no)");
                    System.out.println("Enter again..");
                    option= scan.next().charAt(0);
                }

                if(option=='n'){
                    passengersList.remove(passengerCurrCount);
                    passengerCurrCount--;
                    g.glob--;
                    return 0;
                }

                else if(option=='y'){
                    return j_detail();
                }

            }

            //Printing the process if these are no seats available in the economy class
            if(economy_src4_desti3_seats.size()==0){
                System.out.println("\nNo seats are available in the Economy class. Only Business class seats are avaiable");
                System.out.println("Do you wish to make another Reservation (y/n/e)");
                System.out.println("Enter 'y' to make another Reservation. Enter 'n' to continue with the business class booking");
                System.out.println("Enter e for exit");
                char option= scan.next().charAt(0);

                while ( (option!='y') && (option!='n' && (option!='e')) ){
                    System.out.println("Invalid! Please enter y (for yes) or n (for no) or e (for exit)");
                    System.out.println("Enter again..");
                    option= scan.next().charAt(0);
                }

                if(option=='e'){
                    passengersList.remove(passengerCurrCount);
                    passengerCurrCount--;
                    g.glob--;
                    return 0;
                }

                else if(option=='y'){
                    return j_detail();
                }
            }

            //Printing the process if these are no seats available in the business class
            if(business_src4_desti3_seats.size()==0){
                System.out.println("\nNo seats are available in the Business class. Only Economy class seats are avaiable");
                System.out.println("Do you wish to make another Reservation (y/n/e)");
                System.out.println("Enter 'y' to make another Reservation. Enter 'n' to continue with the Economy class booking");
                System.out.println("Enter e to exit");
                char option= scan.next().charAt(0);

                while ( (option!='y') && (option!='n') && (option!='e') ){
                    System.out.println("Invalid! Please enter y (for yes) or n (for no) or e (for exit)");
                    System.out.println("Enter again..");
                    option= scan.next().charAt(0);
                }

                if(option=='e'){
                    passengersList.remove(passengerCurrCount);
                    passengerCurrCount--;
                    g.glob--;
                    return 0;
                }

                else if(option=='y'){
                    return j_detail();
                }
            }

            System.out.println("\n\t \t \t \t \t \tFlights Found");
            System.out.println("");

            if( (business_src4_desti3_seats.size()!=0) && (economy_src4_desti3_seats.size()!=0) ){
                System.out.println("Airline:\t \tDeparture:\tArrival:\tPrice:\t\tCategory");
                System.out.println("\1.Qantas(1)\t \t08:00\t\t11:05\t\tRs.5800\t\tEconomy");
                System.out.println("\2.Fly Dubai(2)\t14:00\t\t17:05\t\tRs.5508\t\tEconomy");
                System.out.println("\3.Go Air(3)\t \t19:00\t\t22:05\t\tRs.6050\t\tEconomy");

                System.out.println("");
                System.out.println("Airline:\t \tDeparture:\tArrival:\tPrice:\t\tCategory");
                System.out.println("\4.Qantas(1)\t \t08:00\t\t11:05\t\tRs.7800\t\tBusiness");
                System.out.println("\5.Fly Dubai(2)\t14:00\t\t17:05\t\tRs.7508\t\tBusiness");
                System.out.println("\6.Go Air(3)\t \t19:00\t\t22:05\t\tRs.8050\t\tBusiness");

                //getting the flight option from the user
                System.out.println("\nEnter your Flight choice:");
                choice=scan.nextInt();

                //validating the choice
                while(choice<1 || choice>6){
                    System.out.println("Invalid! The choice can only be 1,2,3,4,5 or 6");
                    System.out.println("Enter again..");
                    choice=scan.nextInt();
                }

                //condition for selection from Economy class
                if(choice>=1 && choice<4){
                    //displaying the Availaable Business class seats
                    System.out.println("\nSeat numbers available for Economy class booking\n");
                    for (int i = 0; i < economy_src4_desti3_seats.size(); i++) {
                        System.out.println("Seat No.: "+economy_src4_desti3_seats.get(i));
                    }

                    //getting the seat number choice from the user
                    System.out.println("\nEnter Seat No.:");
                    passengersList.get(passengerCurrCount).seat_no=scan.nextInt();

                    //validating the seat number choice
                    boolean found=false;
                    while(found!=true){

                        for (int i = 0; i < economy_src4_desti3_seats.size(); i++) {
                            //finding the seat and removing the seat at the same time in this condition
                            if(passengersList.get(passengerCurrCount).seat_no==economy_src4_desti3_seats.get(i)){
                                found=true;
                                economy_src4_desti3_seats.remove(i);

                                //after removing sorting the arraylist
                                Collections.sort(economy_src4_desti3_seats);
                            }
                        }

                        if(found==false){
                            System.out.println("Invalid! Please select a seat from the above available seats");
                            passengersList.get(passengerCurrCount).seat_no=scan.nextInt();
                        }
                    }

                    //The selected seat is being removed from the arraylist successfully
                }

                //condition for selection from the business class
                if(choice>3 && choice<7){
                    //displaying the Availaable Business class seats
                    System.out.println("\nSeat numbers available for business class booking\n");
                    for (int i = 0; i < business_src4_desti3_seats.size(); i++) {
                        System.out.println("Seat No.: "+business_src4_desti3_seats.get(i));
                    }

                    //getting the seat number choice from the user
                    System.out.println("\nEnter Seat No.:");
                    passengersList.get(passengerCurrCount).seat_no=scan.nextInt();

                    //validating the seat number choice
                    boolean found=false;
                    while(found!=true){

                        for (int i = 0; i < business_src4_desti3_seats.size(); i++) {
                            //finding the seat and removing the seat at the same time in this condition
                            if(passengersList.get(passengerCurrCount).seat_no==business_src4_desti3_seats.get(i)){
                                found=true;
                                business_src4_desti3_seats.remove(i);

                                //after removing sorting the arraylist
                                Collections.sort(business_src4_desti3_seats);
                            }
                        }

                        if(found==false){
                            System.out.println("Invalid! Please select a seat from the above available seats");
                            passengersList.get(passengerCurrCount).seat_no=scan.nextInt();
                        }
                    }

                    //The selected seat is being removed from the arraylist successfully
                }
            }

            if(economy_src4_desti3_seats.size()!=0 && business_src4_desti3_seats.size()==0) {
                System.out.println("Airline:\t \tDeparture:\tArrival:\tPrice:\t\tCategory");
                System.out.println("\1.Qantas(1)\t \t08:00\t\t11:05\t\tRs.5800\t\tEconomy");
                System.out.println("\2.Fly Dubai(2)\t14:00\t\t17:05\t\tRs.5508\t\tEconomy");
                System.out.println("\3.Go Air(3)\t \t19:00\t\t22:05\t\tRs.6050\t\tEconomy");
                System.out.println("");

                //getting the flight option from the user
                System.out.println("\nEnter your Flight choice:");
                choice=scan.nextInt();

                //validating the choice
                while(choice<1 || choice>3){
                    System.out.println("Invalid! The choice can only be 1,2 or 3");
                    System.out.println("Enter again..");
                    choice=scan.nextInt();
                }

                //displaying the Availaable Business class seats
                System.out.println("\nSeat numbers available for Economy class booking\n");
                for (int i = 0; i < economy_src4_desti3_seats.size(); i++) {
                    System.out.println("Seat No.: "+economy_src4_desti3_seats.get(i));
                }

                //getting the seat number choice from the user
                System.out.println("\nEnter Seat No.:");
                passengersList.get(passengerCurrCount).seat_no=scan.nextInt();

                //validating the seat number choice
                boolean found=false;
                while(found!=true){

                    for (int i = 0; i < economy_src4_desti3_seats.size(); i++) {
                        //finding the seat and removing the seat at the same time in this condition
                        if(passengersList.get(passengerCurrCount).seat_no==economy_src4_desti3_seats.get(i)){
                            found=true;
                            economy_src4_desti3_seats.remove(i);

                            //after removing sorting the arraylist
                            Collections.sort(economy_src4_desti3_seats);
                        }
                    }

                    if(found==false){
                        System.out.println("Invalid! Please select a seat from the above available seats");
                        passengersList.get(passengerCurrCount).seat_no=scan.nextInt();
                    }
                }

                //The selected seat is being removed from the arraylist successfully
            }

            if(business_src4_desti3_seats.size()!=0 && economy_src4_desti3_seats.size()==0) {
                System.out.println("Airline:\t \tDeparture:\tArrival:\tPrice:\t\tCategory");
                System.out.println("\4.Qantas(1)\t \t08:00\t\t11:05\t\tRs.7800\t\tBusiness");
                System.out.println("\5.Fly Dubai(2)\t14:00\t\t17:05\t\tRs.7508\t\tBusiness");
                System.out.println("\6.Go Air(3)\t \t19:00\t\t22:05\t\tRs.8050\t\tBusiness");
                System.out.println("");

                //getting the flight option from the user
                System.out.println("\nEnter your Flight choice:");
                choice=scan.nextInt();

                //validating the choice
                while(choice<4 || choice>6){
                    System.out.println("Invalid! The choice can only be 4,5 or 6");
                    System.out.println("Enter again..");
                    choice=scan.nextInt();
                }

                //displaying the Availaable Business class seats
                System.out.println("\nSeat numbers available for business class booking\n");
                for (int i = 0; i < business_src4_desti3_seats.size(); i++) {
                    System.out.println("Seat No.: "+business_src4_desti3_seats.get(i));
                }

                //getting the seat number choice from the user
                System.out.println("\nEnter Seat No.:");
                passengersList.get(passengerCurrCount).seat_no=scan.nextInt();

                //validating the seat number choice
                boolean found=false;
                while(found!=true){

                    for (int i = 0; i < business_src4_desti3_seats.size(); i++) {
                        //finding the seat and removing the seat at the same time in this condition
                        if(passengersList.get(passengerCurrCount).seat_no==business_src4_desti3_seats.get(i)){
                            found=true;
                            business_src4_desti3_seats.remove(i);

                            //after removing sorting the arraylist
                            Collections.sort(business_src4_desti3_seats);
                        }
                    }

                    if(found==false){
                        System.out.println("Invalid! Please select a seat from the above available seats");
                        passengersList.get(passengerCurrCount).seat_no=scan.nextInt();
                    }
                }

                //The selected seat is being removed from the arraylist successfully
            }

            //setting the src and dest variables of the passenger class because it will later help in
            //identifying in which arraylist to add the cancelled seat (seat cancelled by the passenger)
            passengersList.get(passengerCurrCount).src=4;
            passengersList.get(passengerCurrCount).dest=3;
            passengersList.get(passengerCurrCount).source="Canberra";
            passengersList.get(passengerCurrCount).destination="Melbourne";
        }

        else if( src== dest)//condition
        {
            System.out.println("\nSource and destination can't be same.\nTry again\n\n\n");
            return j_detail();
        }
        else
        {
            System.out.println("\nWrong input entered\nTry again\n\n\n");
            return j_detail();
        }

        //calling the select flight function to move the reservation to the next step
        select_flight();
        return 1;
    }

    int  select_flight() //function declaration and definition for selecting flight
    {


        switch (choice) // switch case
        {
            //Cases for Economy class
            case 1://condition

                System.out.println("\nFlight selected:");
                System.out.println("Qantas");
                passengersList.get(passengerCurrCount).f_d="Qantas";//copy to string
                System.out.println("Departure Time : 08:00");
                System.out.println("Arrival Time: 11:05");
                passengersList.get(passengerCurrCount).tojd="8:00"; //copy to string
                passengersList.get(passengerCurrCount).toja="11:05";// copy to string
                passengersList.get(passengerCurrCount).ticketCategory="Economy";
                break;
            case 2://condition
                System.out.println("\nFlight selected:");
                System.out.println("Fly Dubai");
                passengersList.get(passengerCurrCount).f_d="Fly Dubai";//copy to string
                System.out.println("Departure Time : 14:00");
                System.out.println("Arrival Time: 17:05");
                passengersList.get(passengerCurrCount).tojd="14:00";//copy to string
                passengersList.get(passengerCurrCount).toja="17:05";//copy to string
                passengersList.get(passengerCurrCount).ticketCategory="Economy";
                break;
            case 3://condition
                System.out.println("\nFlight selected:");
                System.out.println("Go Air");
                passengersList.get(passengerCurrCount).f_d="Go Air";//copy to string
                System.out.println("Departure Time : 19:00");
                System.out.println("Arrival Time: 22:05");
                passengersList.get(passengerCurrCount).tojd="19:00";//copy to string
                passengersList.get(passengerCurrCount).toja="22:05";//copy to string
                passengersList.get(passengerCurrCount).ticketCategory="Economy";
                break;

            //Cases for Business class
            case 4://condition
                System.out.println("\nFlight selected:");
                System.out.println("Qantas");
                passengersList.get(passengerCurrCount).f_d="Qantas";//copy to string
                System.out.println("Departure Time : 08:00");
                System.out.println("Arrival Time: 11:05");
                passengersList.get(passengerCurrCount).tojd="8:00"; //copy to string
                passengersList.get(passengerCurrCount).toja="11:05";// copy to string
                passengersList.get(passengerCurrCount).ticketCategory="Business";
                break;
            case 5://condition
                System.out.println("\nFlight selected:");
                System.out.println("Fly Dubai");
                passengersList.get(passengerCurrCount).f_d="Fly Dubai";//copy to string
                System.out.println("Departure Time : 14:00");
                System.out.println("Arrival Time: 17:05");
                passengersList.get(passengerCurrCount).tojd="14:00";//copy to string
                passengersList.get(passengerCurrCount).toja="17:05";//copy to string
                passengersList.get(passengerCurrCount).ticketCategory="Business";
                break;
            case 6://condition
                System.out.println("\nFlight selected:");
                System.out.println("Go Air");
                passengersList.get(passengerCurrCount).f_d="Go Air";//copy to string
                System.out.println("Departure Time : 19:00");
                System.out.println("Arrival Time: 22:05");
                passengersList.get(passengerCurrCount).tojd="19:00";//copy to string
                passengersList.get(passengerCurrCount).toja="22:05";//copy to string
                passengersList.get(passengerCurrCount).ticketCategory="Business";
                break;
            default://condition
                System.out.println("Wrong input entered.\nTry again");
                return select_flight();
        }

        passengersList.get(passengerCurrCount).disp();

        //writing domestic passenger info to Domestic.txt
        try{

            File myObj = new File("Domestic.txt");
            if (myObj.createNewFile()) {
                System.out.println("File created: " + myObj.getName());
            } else {
                System.out.println("File already exists.");
            }

            //code for writing in the file starts from here
            FileWriter writer = new FileWriter("Domestic.txt", true);

            //writing everything manually and one by one in the file
            String out= "PNR: "+String.valueOf(passengersList.get(passengerCurrCount).pnr);
            writer.write(out);
            writer.write("\r\n");

            out= "Date of Journey: "+passengersList.get(passengerCurrCount).doj;
            writer.write(out);
            writer.write("\r\n");

            out= "Flight: "+passengersList.get(passengerCurrCount).f_d;
            writer.write(out);
            writer.write("\r\n");

            out= "Name: "+passengersList.get(passengerCurrCount).f_name;
            writer.write(out);
            writer.write("\r\n");

            out= "Source :"+passengersList.get(passengerCurrCount).source;
            writer.write(out);
            writer.write("\r\n");

            out= "Destination: "+passengersList.get(passengerCurrCount).destination;
            writer.write(out);
            writer.write("\r\n");

            out= "Arrival time: "+passengersList.get(passengerCurrCount).toja;
            writer.write(out);
            writer.write("\r\n");

            out= "Departure time: "+passengersList.get(passengerCurrCount).tojd;
            writer.write(out);
            writer.write("\r\n");

            out= "Seat No.: "+String.valueOf(passengersList.get(passengerCurrCount).seat_no);
            writer.write(out);
            writer.write("\r\n");

            out= "Ticket Category: "+passengersList.get(passengerCurrCount).ticketCategory;
            writer.write(out);
            writer.write("\r\n");
            writer.write("\r\n");

            writer.close();
        }

        catch(Exception e){
            System.out.println(e.getMessage());
        }

        return 1;
    }

    void displayPassengers(){

        if(passengersList.size()==0){
            System.out.println("No Passengers to show");
            return;
        }

        System.out.println("\nDisplaying the list of passsengers having domestic booking\n");

        for (int i = 0; i < passengersList.size(); i++) {
            passengersList.get(i).disp();
            System.out.println("");
        }
    }

    void cancelTicket(int x){ //function getting the pnr as argument to search

        if(passengersList.size()==0){
            System.out.println("\nNo Passengers to Search");
            return;
        }

        boolean found=false;

        for (int i = 0; i < passengersList.size(); i++) {
            if(passengersList.get(i).pnr==x){
                found=true;
                passengersList.get(i).disp();
                System.out.println("\nYour Above ticket is being cancelled");
                System.out.println("Amount Refunded: 1000");

                //condition for adding to the arrays of src1_desti2_seats
                if(passengersList.get(i).src==1 && passengersList.get(i).dest==2){
                    if(passengersList.get(i).seat_no>0 && passengersList.get(i).seat_no<6){

                        int r=passengersList.get(i).seat_no;
                        business_src1_desti2_seats.add(r);
                        Collections.sort(business_src1_desti2_seats);
                    }

                    else if(passengersList.get(i).seat_no>5 && passengersList.get(i).seat_no<26){
                        economy_src1_desti2_seats.add(passengersList.get(i).seat_no);
                        Collections.sort(economy_src1_desti2_seats);
                    }
                }

                //condition for adding to the arrays of src1_desti3_seats
                if(passengersList.get(i).src==1 && passengersList.get(i).dest==3){
                    if(passengersList.get(i).seat_no>0 && passengersList.get(i).seat_no<6){

                        int r=passengersList.get(i).seat_no;
                        business_src1_desti3_seats.add(r);
                        Collections.sort(business_src1_desti3_seats);
                    }

                    else if(passengersList.get(i).seat_no>5 && passengersList.get(i).seat_no<26){
                        economy_src1_desti3_seats.add(passengersList.get(i).seat_no);
                        Collections.sort(economy_src1_desti3_seats);

                    }
                }

                //condition for adding to the arrays of src1_desti4_seats
                if(passengersList.get(i).src==1 && passengersList.get(i).dest==4){
                    if(passengersList.get(i).seat_no>0 && passengersList.get(i).seat_no<6){

                        int r=passengersList.get(i).seat_no;
                        business_src1_desti4_seats.add(r);
                        Collections.sort(business_src1_desti4_seats);
                    }

                    else if(passengersList.get(i).seat_no>5 && passengersList.get(i).seat_no<26){
                        economy_src1_desti4_seats.add(passengersList.get(i).seat_no);
                        Collections.sort(economy_src1_desti4_seats);

                    }
                }

                //condition for adding to the arrays of src2_desti1_seats
                if(passengersList.get(i).src==2 && passengersList.get(i).dest==1){
                    if(passengersList.get(i).seat_no>0 && passengersList.get(i).seat_no<6){

                        int r=passengersList.get(i).seat_no;
                        business_src2_desti1_seats.add(r);
                        Collections.sort(business_src2_desti1_seats);
                    }

                    else if(passengersList.get(i).seat_no>5 && passengersList.get(i).seat_no<26){
                        economy_src2_desti1_seats.add(passengersList.get(i).seat_no);
                        Collections.sort(economy_src2_desti1_seats);

                    }
                }

                //condition for adding to the arrays of src2_desti3_seats
                if(passengersList.get(i).src==2 && passengersList.get(i).dest==3){
                    if(passengersList.get(i).seat_no>0 && passengersList.get(i).seat_no<6){

                        int r=passengersList.get(i).seat_no;
                        business_src2_desti3_seats.add(r);
                        Collections.sort(business_src2_desti3_seats);
                    }

                    else if(passengersList.get(i).seat_no>5 && passengersList.get(i).seat_no<26){
                        economy_src2_desti3_seats.add(passengersList.get(i).seat_no);
                        Collections.sort(economy_src2_desti3_seats);

                    }
                }

                //condition for adding to the arrays of src2_desti4_seats
                if(passengersList.get(i).src==2 && passengersList.get(i).dest==4){
                    if(passengersList.get(i).seat_no>0 && passengersList.get(i).seat_no<6){

                        int r=passengersList.get(i).seat_no;
                        business_src2_desti4_seats.add(r);
                        Collections.sort(business_src2_desti4_seats);
                    }

                    else if(passengersList.get(i).seat_no>5 && passengersList.get(i).seat_no<26){
                        economy_src2_desti4_seats.add(passengersList.get(i).seat_no);
                        Collections.sort(economy_src2_desti4_seats);

                    }
                }

                //condition for adding to the arrays of src3_desti4_seats
                if(passengersList.get(i).src==3 && passengersList.get(i).dest==4){
                    if(passengersList.get(i).seat_no>0 && passengersList.get(i).seat_no<6){

                        int r=passengersList.get(i).seat_no;
                        business_src3_desti4_seats.add(r);
                        Collections.sort(business_src3_desti4_seats);
                    }

                    else if(passengersList.get(i).seat_no>5 && passengersList.get(i).seat_no<26){
                        economy_src3_desti4_seats.add(passengersList.get(i).seat_no);
                        Collections.sort(economy_src3_desti4_seats);

                    }
                }

                //condition for adding to the arrays of src3_desti1_seats
                if(passengersList.get(i).src==3 && passengersList.get(i).dest==1){
                    if(passengersList.get(i).seat_no>0 && passengersList.get(i).seat_no<6){

                        int r=passengersList.get(i).seat_no;
                        business_src3_desti1_seats.add(r);
                        Collections.sort(business_src3_desti1_seats);
                    }

                    else if(passengersList.get(i).seat_no>5 && passengersList.get(i).seat_no<26){
                        economy_src3_desti1_seats.add(passengersList.get(i).seat_no);
                        Collections.sort(economy_src3_desti1_seats);

                    }
                }

                //condition for adding to the arrays of src3_desti2_seats
                if(passengersList.get(i).src==3 && passengersList.get(i).dest==2){
                    if(passengersList.get(i).seat_no>0 && passengersList.get(i).seat_no<6){

                        int r=passengersList.get(i).seat_no;
                        business_src3_desti2_seats.add(r);
                        Collections.sort(business_src3_desti2_seats);
                    }

                    else if(passengersList.get(i).seat_no>5 && passengersList.get(i).seat_no<26){
                        economy_src3_desti2_seats.add(passengersList.get(i).seat_no);
                        Collections.sort(economy_src3_desti2_seats);

                    }
                }

                //condition for adding to the arrays of src4_desti1_seats
                if(passengersList.get(i).src==4 && passengersList.get(i).dest==1){
                    if(passengersList.get(i).seat_no>0 && passengersList.get(i).seat_no<6){

                        int r=passengersList.get(i).seat_no;
                        business_src4_desti1_seats.add(r);
                        Collections.sort(business_src4_desti1_seats);
                    }

                    else if(passengersList.get(i).seat_no>5 && passengersList.get(i).seat_no<26){
                        economy_src4_desti1_seats.add(passengersList.get(i).seat_no);
                        Collections.sort(economy_src4_desti1_seats);

                    }
                }

                //condition for adding to the arrays of src4_desti2_seats
                if(passengersList.get(i).src==4 && passengersList.get(i).dest==2){
                    if(passengersList.get(i).seat_no>0 && passengersList.get(i).seat_no<6){

                        int r=passengersList.get(i).seat_no;
                        business_src4_desti2_seats.add(r);
                        Collections.sort(business_src4_desti2_seats);
                    }

                    else if(passengersList.get(i).seat_no>5 && passengersList.get(i).seat_no<26){
                        economy_src4_desti2_seats.add(passengersList.get(i).seat_no);
                        Collections.sort(economy_src4_desti2_seats);

                    }
                }

                //condition for adding to the arrays of src4_desti3_seats
                if(passengersList.get(i).src==4 && passengersList.get(i).dest==3){
                    if(passengersList.get(i).seat_no>0 && passengersList.get(i).seat_no<6){

                        int r=passengersList.get(i).seat_no;
                        business_src4_desti3_seats.add(r);
                        Collections.sort(business_src4_desti3_seats);
                    }

                    else if(passengersList.get(i).seat_no>5 && passengersList.get(i).seat_no<26){
                        economy_src4_desti3_seats.add(passengersList.get(i).seat_no);
                        Collections.sort(economy_src4_desti3_seats);

                    }
                }

                passengersList.remove(i);
                passengerCurrCount--;
                i=passengersList.size();
            }
        }

        if(found==false){
            System.out.println("\nTicket Not Found!");
        }
    }

    void checkTicket(int x){

        if(passengersList.size()==0){
            System.out.println("The passenger list is empty");
            return;
        }

        boolean found=false;
        for (int i = 0; i < passengersList.size(); i++) {
            if(passengersList.get(i).pnr==x){
                found=true;
                passengersList.get(i).disp();
            }
        }

        if(found==false){
            System.out.println("Ticket not found!");
        }
    }
}

class i_booking//class for international booking
{
    //protected members
    protected int srci,desti,choicei;
    Global g = new Global();
    Scanner scan=new Scanner(System.in);
    Scanner sc = new Scanner(System.in);

    //seats arrays for the option source 1 and destination 2
    ArrayList<Integer> economy_src1_desti2_seats=new ArrayList<Integer>(); //seats for economy class
    ArrayList<Integer> business_src1_desti2_seats=new ArrayList<Integer>(); //seats for business class

    //seats arrays for the option source 1 and destination 3
    ArrayList<Integer> economy_src1_desti3_seats=new ArrayList<Integer>(); //seats for economy class
    ArrayList<Integer> business_src1_desti3_seats=new ArrayList<Integer>(); //seats for business class

    //seats arrays for the option source 1 and destination 4
    ArrayList<Integer> economy_src1_desti4_seats=new ArrayList<Integer>(); //seats for economy class
    ArrayList<Integer> business_src1_desti4_seats=new ArrayList<Integer>(); //seats for business class

    //seats arrays for the option source 1 and destination 5
    ArrayList<Integer> economy_src1_desti5_seats=new ArrayList<Integer>(); //seats for economy class
    ArrayList<Integer> business_src1_desti5_seats=new ArrayList<Integer>(); //seats for business class

    //seats arrays for the option source 2 and destination 1
    ArrayList<Integer> economy_src2_desti1_seats=new ArrayList<Integer>(); //seats for economy class
    ArrayList<Integer> business_src2_desti1_seats=new ArrayList<Integer>(); //seats for business class

    //seats arrays for the option source 2 and destination 3
    ArrayList<Integer> economy_src2_desti3_seats=new ArrayList<Integer>(); //seats for economy class
    ArrayList<Integer> business_src2_desti3_seats=new ArrayList<Integer>(); //seats for business class

    //seats arrays for the option source 2 and destination 4
    ArrayList<Integer> economy_src2_desti4_seats=new ArrayList<Integer>(); //seats for economy class
    ArrayList<Integer> business_src2_desti4_seats=new ArrayList<Integer>(); //seats for business class

    //seats arrays for the option source 2 and destination 5
    ArrayList<Integer> economy_src2_desti5_seats=new ArrayList<Integer>(); //seats for economy class
    ArrayList<Integer> business_src2_desti5_seats=new ArrayList<Integer>(); //seats for business class

    //seats arrays for the option source 3 and destination 1
    ArrayList<Integer> economy_src3_desti1_seats=new ArrayList<Integer>(); //seats for economy class
    ArrayList<Integer> business_src3_desti1_seats=new ArrayList<Integer>(); //seats for business class

    //seats arrays for the option source 3 and destination 2
    ArrayList<Integer> economy_src3_desti2_seats=new ArrayList<Integer>(); //seats for economy class
    ArrayList<Integer> business_src3_desti2_seats=new ArrayList<Integer>(); //seats for business class

    //seats arrays for the option source 3 and destination 4
    ArrayList<Integer> economy_src3_desti4_seats=new ArrayList<Integer>(); //seats for economy class
    ArrayList<Integer> business_src3_desti4_seats=new ArrayList<Integer>(); //seats for business class

    //seats arrays for the option source 3 and destination 5
    ArrayList<Integer> economy_src3_desti5_seats=new ArrayList<Integer>(); //seats for economy class
    ArrayList<Integer> business_src3_desti5_seats=new ArrayList<Integer>(); //seats for business class

    //seats arrays for the option source 4 and destination 1
    ArrayList<Integer> economy_src4_desti1_seats=new ArrayList<Integer>(); //seats for economy class
    ArrayList<Integer> business_src4_desti1_seats=new ArrayList<Integer>(); //seats for business class

    //seats arrays for the option source 4 and destination 2
    ArrayList<Integer> economy_src4_desti2_seats=new ArrayList<Integer>(); //seats for economy class
    ArrayList<Integer> business_src4_desti2_seats=new ArrayList<Integer>(); //seats for business class

    //seats arrays for the option source 4 and destination 3
    ArrayList<Integer> economy_src4_desti3_seats=new ArrayList<Integer>(); //seats for economy class
    ArrayList<Integer> business_src4_desti3_seats=new ArrayList<Integer>(); //seats for business class

    //seats arrays for the option source 4 and destination 5
    ArrayList<Integer> economy_src4_desti5_seats=new ArrayList<Integer>(); //seats for economy class
    ArrayList<Integer> business_src4_desti5_seats=new ArrayList<Integer>(); //seats for business class

    //seats arrays for the option source 5 and destination 1
    ArrayList<Integer> economy_src5_desti1_seats=new ArrayList<Integer>(); //seats for economy class
    ArrayList<Integer> business_src5_desti1_seats=new ArrayList<Integer>(); //seats for business class

   //seats arrays for the option source 5 and destination 2
    ArrayList<Integer> economy_src5_desti2_seats=new ArrayList<Integer>(); //seats for economy class
    ArrayList<Integer> business_src5_desti2_seats=new ArrayList<Integer>(); //seats for business class

    //seats arrays for the option source 5 and destination 3
    ArrayList<Integer> economy_src5_desti3_seats=new ArrayList<Integer>(); //seats for economy class
    ArrayList<Integer> business_src5_desti3_seats=new ArrayList<Integer>(); //seats for business class

    //seats arrays for the option source 5 and destination 4
    ArrayList<Integer> economy_src5_desti4_seats=new ArrayList<Integer>(); //seats for economy class
    ArrayList<Integer> business_src5_desti4_seats=new ArrayList<Integer>(); //seats for business class



    ArrayList<Passenger_International> intenationalPassengersList = new ArrayList<Passenger_International>();
    protected int intenationalPassengerCurrCount=-1;

    //public member functions
    void settingSeats(){

        //1. setting up seats for source 1 and destination 2
        for (int i = 1; i <= 5; i++) {
            business_src1_desti2_seats.add(i);
        }

        for (int i = 6; i <= 25; i++) {
            economy_src1_desti2_seats.add(i);
        }

        //2. setting up seats for source 1 and destination 3
        for (int i = 1; i <= 5; i++) {
            business_src1_desti3_seats.add(i);
        }

        for (int i = 6; i <= 25; i++) {
            economy_src1_desti3_seats.add(i);
        }

        //3. setting up seats for source 1 and destination 4
        for (int i = 1; i <= 5; i++) {
            business_src1_desti4_seats.add(i);
        }

        for (int i = 6; i <= 25; i++) {
            economy_src1_desti4_seats.add(i);
        }

        //4. setting up seats for source 1 and destination 5
        for (int i = 1; i <= 5; i++) {
            business_src1_desti5_seats.add(i);
        }

        for (int i = 6; i <= 25; i++) {
            economy_src1_desti5_seats.add(i);
        }

        //5. setting up seats for source 2 and destination 1
        for (int i = 1; i <= 5; i++) {
            business_src2_desti1_seats.add(i);
        }

        for (int i = 6; i <= 25; i++) {
            economy_src2_desti1_seats.add(i);
        }

        //6. setting up seats for source 2 and destination 3
        for (int i = 1; i <= 5; i++) {
            business_src2_desti3_seats.add(i);
        }

        for (int i = 6; i <= 25; i++) {
            economy_src2_desti3_seats.add(i);
        }

        //7. setting up seats for source 2 and destination 4
        for (int i = 1; i <= 5; i++) {
            business_src2_desti4_seats.add(i);
        }

        for (int i = 6; i <= 25; i++) {
            economy_src2_desti4_seats.add(i);
        }

        //8. setting up seats for source 2 and destination 5
        for (int i = 1; i <= 5; i++) {
            business_src2_desti5_seats.add(i);
        }

        for (int i = 6; i <= 25; i++) {
            economy_src2_desti5_seats.add(i);
        }

        //9. setting up seats for source 3 and destination 1
        for (int i = 1; i <= 5; i++) {
            business_src3_desti1_seats.add(i);
        }

        for (int i = 6; i <= 25; i++) {
            economy_src3_desti1_seats.add(i);
        }

        //10. setting up seats for source 3 and destination 2
        for (int i = 1; i <= 5; i++) {
            business_src3_desti2_seats.add(i);
        }

        for (int i = 6; i <= 25; i++) {
            economy_src3_desti2_seats.add(i);
        }

        //11. setting up seats for source 3 and destination 4
        for (int i = 1; i <= 5; i++) {
            business_src3_desti4_seats.add(i);
        }

        for (int i = 6; i <= 25; i++) {
            economy_src3_desti4_seats.add(i);
        }

        //12. setting up seats for source 3 and destination 5
        for (int i = 1; i <= 5; i++) {
            business_src3_desti5_seats.add(i);
        }

        for (int i = 6; i <= 25; i++) {
            economy_src3_desti5_seats.add(i);
        }

        //13. setting up seats for source 4 and destination 1
        for (int i = 1; i <= 5; i++) {
            business_src4_desti1_seats.add(i);
        }

        for (int i = 6; i <= 25; i++) {
            economy_src4_desti1_seats.add(i);
        }

        //14. setting up seats for source 4 and destination 2
        for (int i = 1; i <= 5; i++) {
            business_src4_desti2_seats.add(i);
        }

        for (int i = 6; i <= 25; i++) {
            economy_src4_desti2_seats.add(i);
        }

        //15. setting up seats for source 4 and destination 3
        for (int i = 1; i <= 5; i++) {
            business_src4_desti3_seats.add(i);
        }

        for (int i = 6; i <= 25; i++) {
            economy_src4_desti3_seats.add(i);
        }

        //16. setting up seats for source 4 and destination 5
        for (int i = 1; i <= 5; i++) {
            business_src4_desti5_seats.add(i);
        }

        for (int i = 6; i <= 25; i++) {
            economy_src4_desti5_seats.add(i);
        }

        //17. setting up seats for source 5 and destination 1
        for (int i = 1; i <= 5; i++) {
            business_src5_desti1_seats.add(i);
        }

        for (int i = 6; i <= 25; i++) {
            economy_src5_desti1_seats.add(i);
        }

        //18. setting up seats for source 5 and destination 2
        for (int i = 1; i <= 5; i++) {
            business_src5_desti2_seats.add(i);
        }

        for (int i = 6; i <= 25; i++) {
            economy_src5_desti2_seats.add(i);
        }

        //19. setting up seats for source 5 and destination 3
        for (int i = 1; i <= 5; i++) {
            business_src5_desti3_seats.add(i);
        }

        for (int i = 6; i <= 25; i++) {
            economy_src5_desti3_seats.add(i);
        }

        //20. setting up seats for source 5 and destination 4
        for (int i = 1; i <= 5; i++) {
            business_src5_desti4_seats.add(i);
        }

        for (int i = 6; i <= 25; i++) {
            economy_src5_desti4_seats.add(i);
        }
    }

    void i_pnr()
    {
        g.global++;//increment variable
        intenationalPassengersList.get(intenationalPassengerCurrCount).pnri=g.global;
    }

    void addPassenger(){
        intenationalPassengersList.add(new Passenger_International());
        intenationalPassengerCurrCount++;
        i_pnr();
    }

    int j_detaili()// function declaration and definition for journey details
    {

        System.out.println("\nEnter DateOfJourney(DD/MM/YYYY). Please enter a valid date.");
        intenationalPassengersList.get(intenationalPassengerCurrCount).doji = scan.next();

        //code for validating the format of the date
        SimpleDateFormat sdfrmt = new SimpleDateFormat("dd/MM/yyyy");
        sdfrmt.setLenient(false);

        try
        {
            Date javaDate = sdfrmt.parse( intenationalPassengersList.get(intenationalPassengerCurrCount).doji);
        }
        /* Date format is invalid */
        catch (ParseException e) {
            System.out.println("Invalid! Date: " + intenationalPassengersList.get(intenationalPassengerCurrCount).doji);
            return j_detaili();
        }

        System.out.println("\n\1.London(1) \2.Dubai(2) \3.Abu Dhabi(3) \4.Singapore(4) \5.NewYork(5) ");
        System.out.println("\n\tEnter Source");
        srci=sc.nextInt();
        System.out.println("\n\tEnter destination");
        desti=sc.nextInt();

        if( (srci==1 && desti==2) )//condition
        {
            //original code
            /*System.out.println("Airline:\t \tDeparture:\tArrival:\tPrice:\t\tCategory");
            System.out.println("1.Vistara(1)\t23:00\t\t16:10\t\tRs.75500\tEconomy");
            System.out.println("2.Fly Dubai(2)\t2:00\t\t19:05\t\tRs.86450\tEconomy");
            System.out.println("3.Emirates(3)\t18:00\t\t10:05\t\tRs.93650\tEconomy");

            System.out.println("");
            System.out.println("Airline:\t \tDeparture:\tArrival:\tPrice:\t\tCategory");
            System.out.println("4.Vistara(1)\t23:00\t\t16:10\t\tRs.85500\tBusiness");
            System.out.println("5.Fly Dubai(2)\t2:00\t\t19:05\t\tRs.96450\tBusiness");
            System.out.println("6.Emirates(3)\t18:00\t\t10:05\t\tRs.1,03,650\tBusiness");
            */
            //////////////////////////////////////////////////////////////////////////

            //checking the availability of the seats in the economy and business class
            if(economy_src1_desti2_seats.size()==0 && business_src1_desti2_seats.size()==0){

                char option;
                System.out.println("\nNo seats available in the business and economy class");
                System.out.println("Do you wish to make another Reservation (y/n):");
                option= scan.next().charAt(0);

                while ( (option!='y') && (option!='n') ){
                    System.out.println("Invalid! Please enter y (for yes) or n (for no)");
                    System.out.println("Enter again..");
                    option= scan.next().charAt(0);
                }

                if(option=='n'){
                    intenationalPassengersList.remove(intenationalPassengerCurrCount);
                    intenationalPassengerCurrCount--;
                    g.global--;
                    return 0;
                }

                else if(option=='y'){
                    return j_detaili();
                }

            }

            //Printing the process if these are no seats available in the economy class
            if(economy_src1_desti2_seats.size()==0){
                System.out.println("\nNo seats are available in the Economy class. Only Business class seats are avaiable");
                System.out.println("Do you wish to make another Reservation (y/n/e)");
                System.out.println("Enter 'y' to make another Reservation. Enter 'n' to continue with the business class booking");
                System.out.println("Enter e for exit");
                char option= scan.next().charAt(0);

                while ( (option!='y') && (option!='n' && (option!='e')) ){
                    System.out.println("Invalid! Please enter y (for yes) or n (for no) or e (for exit)");
                    System.out.println("Enter again..");
                    option= scan.next().charAt(0);
                }

                if(option=='e'){
                    intenationalPassengersList.remove(intenationalPassengerCurrCount);
                    intenationalPassengerCurrCount--;
                    g.global--;
                    return 0;
                }

                else if(option=='y'){
                    return j_detaili();
                }
            }

            //Printing the process if these are no seats available in the business class
            if(business_src1_desti2_seats.size()==0){
                System.out.println("\nNo seats are available in the Business class. Only Economy class seats are avaiable");
                System.out.println("Do you wish to make another Reservation (y/n/e)");
                System.out.println("Enter 'y' to make another Reservation. Enter 'n' to continue with the Economy class booking");
                System.out.println("Enter e to exit");
                char option= scan.next().charAt(0);

                while ( (option!='y') && (option!='n') && (option!='e') ){
                    System.out.println("Invalid! Please enter y (for yes) or n (for no) or e (for exit)");
                    System.out.println("Enter again..");
                    option= scan.next().charAt(0);
                }

                if(option=='e'){
                    intenationalPassengersList.remove(intenationalPassengerCurrCount);
                    intenationalPassengerCurrCount--;
                    g.global--;
                    return 0;
                }

                else if(option=='y'){
                    return j_detaili();
                }
            }

            System.out.println("\n\t \t \t \t \t \tFlights Found");
            System.out.println("");

            if( (business_src1_desti2_seats.size()!=0) && (economy_src1_desti2_seats.size()!=0) ){
                System.out.println("Airline:\t \tDeparture:\tArrival:\tPrice:\t\tCategory");
                System.out.println("1.Vistara(1)\t23:00\t\t16:10\t\tRs.75500\tEconomy");
                System.out.println("2.Fly Dubai(2)\t2:00\t\t19:05\t\tRs.86450\tEconomy");
                System.out.println("3.Emirates(3)\t18:00\t\t10:05\t\tRs.93650\tEconomy");

                System.out.println("");
                System.out.println("Airline:\t \tDeparture:\tArrival:\tPrice:\t\tCategory");
                System.out.println("4.Vistara(1)\t23:00\t\t16:10\t\tRs.85500\tBusiness");
                System.out.println("5.Fly Dubai(2)\t2:00\t\t19:05\t\tRs.96450\tBusiness");
                System.out.println("6.Emirates(3)\t18:00\t\t10:05\t\tRs.1,03,650\tBusiness");

                //getting the flight option from the user
                System.out.println("\nEnter your Flight choice:");
                choicei=scan.nextInt();

                //validating the choice
                while(choicei<1 || choicei>6){
                    System.out.println("Invalid! The choice can only be 1,2,3,4,5 or 6");
                    System.out.println("Enter again..");
                    choicei=scan.nextInt();
                }

                //condition for selection from Economy class
                if(choicei>=1 && choicei<4){
                    //displaying the Availaable Business class seats
                    System.out.println("\nSeat numbers available for Economy class booking\n");
                    for (int i = 0; i < economy_src1_desti2_seats.size(); i++) {
                        System.out.println("Seat No.: "+economy_src1_desti2_seats.get(i));
                    }

                    //getting the seat number choice from the user
                    System.out.println("\nEnter Seat No.:");
                    intenationalPassengersList.get(intenationalPassengerCurrCount).seat_no=scan.nextInt();

                    //validating the seat number choice
                    boolean found=false;
                    while(found!=true){

                        for (int i = 0; i < economy_src1_desti2_seats.size(); i++) {
                            //finding the seat and removing the seat at the same time in this condition
                            if(intenationalPassengersList.get(intenationalPassengerCurrCount).seat_no==economy_src1_desti2_seats.get(i)){
                                found=true;
                                economy_src1_desti2_seats.remove(i);

                                //after removing sorting the arraylist
                                Collections.sort(economy_src1_desti2_seats);
                            }
                        }

                        if(found==false){
                            System.out.println("Invalid! Please select a seat from the above available seats");
                            intenationalPassengersList.get(intenationalPassengerCurrCount).seat_no=scan.nextInt();
                        }
                    }

                    //The selected seat is being removed from the arraylist successfully
                }

                //condition for selection from the business class
                if(choicei>3 && choicei<7){
                    //displaying the Availaable Business class seats
                    System.out.println("\nSeat numbers available for business class booking\n");
                    for (int i = 0; i < business_src1_desti2_seats.size(); i++) {
                        System.out.println("Seat No.: "+business_src1_desti2_seats.get(i));
                    }

                    //getting the seat number choice from the user
                    System.out.println("\nEnter Seat No.:");
                    intenationalPassengersList.get(intenationalPassengerCurrCount).seat_no=scan.nextInt();

                    //validating the seat number choice
                    boolean found=false;
                    while(found!=true){

                        for (int i = 0; i < business_src1_desti2_seats.size(); i++) {
                            //finding the seat and removing the seat at the same time in this condition
                            if(intenationalPassengersList.get(intenationalPassengerCurrCount).seat_no==business_src1_desti2_seats.get(i)){
                                found=true;
                                business_src1_desti2_seats.remove(i);

                                //after removing sorting the arraylist
                                Collections.sort(business_src1_desti2_seats);
                            }
                        }

                        if(found==false){
                            System.out.println("Invalid! Please select a seat from the above available seats");
                            intenationalPassengersList.get(intenationalPassengerCurrCount).seat_no=scan.nextInt();
                        }
                    }

                    //The selected seat is being removed from the arraylist successfully
                }
            }

            if(economy_src1_desti2_seats.size()!=0 && business_src1_desti2_seats.size()==0) {
                System.out.println("Airline:\t \tDeparture:\tArrival:\tPrice:\t\tCategory");
                System.out.println("1.Vistara(1)\t23:00\t\t16:10\t\tRs.75500\tEconomy");
                System.out.println("2.Fly Dubai(2)\t2:00\t\t19:05\t\tRs.86450\tEconomy");
                System.out.println("3.Emirates(3)\t18:00\t\t10:05\t\tRs.93650\tEconomy");
                System.out.println("");

                //getting the flight option from the user
                System.out.println("\nEnter your Flight choice:");
                choicei=scan.nextInt();

                //validating the choice
                while(choicei<1 || choicei>3){
                    System.out.println("Invalid! The choice can only be 1,2 or 3");
                    System.out.println("Enter again..");
                    choicei=scan.nextInt();
                }

                //displaying the Availaable Business class seats
                System.out.println("\nSeat numbers available for Economy class booking\n");
                for (int i = 0; i < economy_src1_desti2_seats.size(); i++) {
                    System.out.println("Seat No.: "+economy_src1_desti2_seats.get(i));
                }

                //getting the seat number choice from the user
                System.out.println("\nEnter Seat No.:");
                intenationalPassengersList.get(intenationalPassengerCurrCount).seat_no=scan.nextInt();

                //validating the seat number choice
                boolean found=false;
                while(found!=true){

                    for (int i = 0; i < economy_src1_desti2_seats.size(); i++) {
                        //finding the seat and removing the seat at the same time in this condition
                        if(intenationalPassengersList.get(intenationalPassengerCurrCount).seat_no==economy_src1_desti2_seats.get(i)){
                            found=true;
                            economy_src1_desti2_seats.remove(i);

                            //after removing sorting the arraylist
                            Collections.sort(economy_src1_desti2_seats);
                        }
                    }

                    if(found==false){
                        System.out.println("Invalid! Please select a seat from the above available seats");
                        intenationalPassengersList.get(intenationalPassengerCurrCount).seat_no=scan.nextInt();
                    }
                }

                //The selected seat is being removed from the arraylist successfully
            }

            if(business_src1_desti2_seats.size()!=0 && economy_src1_desti2_seats.size()==0) {
                System.out.println("");
                System.out.println("Airline:\t \tDeparture:\tArrival:\tPrice:\t\tCategory");
                System.out.println("4.Vistara(1)\t23:00\t\t16:10\t\tRs.85500\tBusiness");
                System.out.println("5.Fly Dubai(2)\t2:00\t\t19:05\t\tRs.96450\tBusiness");
                System.out.println("6.Emirates(3)\t18:00\t\t10:05\t\tRs.1,03,650\tBusiness");
                System.out.println("");

                //getting the flight option from the user
                System.out.println("\nEnter your Flight choice:");
                choicei=scan.nextInt();

                //validating the choice
                while(choicei<4 || choicei>6){
                    System.out.println("Invalid! The choice can only be 4,5 or 6");
                    System.out.println("Enter again..");
                    choicei=scan.nextInt();
                }

                //displaying the Availaable Business class seats
                System.out.println("\nSeat numbers available for business class booking\n");
                for (int i = 0; i < business_src1_desti2_seats.size(); i++) {
                    System.out.println("Seat No.: "+business_src1_desti2_seats.get(i));
                }

                //getting the seat number choice from the user
                System.out.println("\nEnter Seat No.:");
                intenationalPassengersList.get(intenationalPassengerCurrCount).seat_no=scan.nextInt();

                //validating the seat number choice
                boolean found=false;
                while(found!=true){

                    for (int i = 0; i < business_src1_desti2_seats.size(); i++) {
                        //finding the seat and removing the seat at the same time in this condition
                        if(intenationalPassengersList.get(intenationalPassengerCurrCount).seat_no==business_src1_desti2_seats.get(i)){
                            found=true;
                            business_src1_desti2_seats.remove(i);

                            //after removing sorting the arraylist
                            Collections.sort(business_src1_desti2_seats);
                        }
                    }

                    if(found==false){
                        System.out.println("Invalid! Please select a seat from the above available seats");
                        intenationalPassengersList.get(intenationalPassengerCurrCount).seat_no=scan.nextInt();
                    }
                }

                //The selected seat is being removed from the arraylist successfully
            }

            //setting the src and dest variables of the passenger class because it will later help in
            //identifying in which arraylist to add the cancelled seat (seat cancelled by the passenger)
            intenationalPassengersList.get(intenationalPassengerCurrCount).src=1;
            intenationalPassengersList.get(intenationalPassengerCurrCount).dest=2;
            intenationalPassengersList.get(intenationalPassengerCurrCount).source="London";
            intenationalPassengersList.get(intenationalPassengerCurrCount).destination="Dubai";


        }

        else if((srci==1 && desti==3) )//condition
        {
            //original code
            /*System.out.println("Airline:\t \tDeparture:\tArrival:\tPrice:\t\tCategory");
            System.out.println("\1.Vistara(1)\t10:00\t\t14:05\t\tRs.25000\tEcononmy");
            System.out.println("\2.Fly Dubai(2)\t14:00\t\t18:05\t\tRs.21500\tEcononmy");
            System.out.println("\3.Emirates(3)\t18:00\t\t22:05\t\tRs.24000\tEcononmy");

            System.out.println("");
            System.out.println("Airline:\t \tDeparture:\tArrival:\tPrice:\t\tCategory");
            System.out.println("\1.Vistara(1)\t10:00\t\t14:05\t\tRs.35000\tBusiness");
            System.out.println("\2.Fly Dubai(2)\t14:00\t\t18:05\t\tRs.31500\tBusiness");
            System.out.println("\3.Emirates(3)\t18:00\t\t22:05\t\tRs.34000\tBusiness");
            */
            /////////////////////////////////////////////////////////////////////////////

            //checking the availability of the seats in the economy and business class
            if(economy_src1_desti3_seats.size()==0 && business_src1_desti3_seats.size()==0){

                char option;
                System.out.println("\nNo seats available in the business and economy class");
                System.out.println("Do you wish to make another Reservation (y/n):");
                option= scan.next().charAt(0);

                while ( (option!='y') && (option!='n') ){
                    System.out.println("Invalid! Please enter y (for yes) or n (for no)");
                    System.out.println("Enter again..");
                    option= scan.next().charAt(0);
                }

                if(option=='n'){
                    intenationalPassengersList.remove(intenationalPassengerCurrCount);
                    intenationalPassengerCurrCount--;
                    g.global--;
                    return 0;
                }

                else if(option=='y'){
                    return j_detaili();
                }

            }

            //Printing the process if these are no seats available in the economy class
            if(economy_src1_desti3_seats.size()==0){
                System.out.println("\nNo seats are available in the Economy class. Only Business class seats are avaiable");
                System.out.println("Do you wish to make another Reservation (y/n/e)");
                System.out.println("Enter 'y' to make another Reservation. Enter 'n' to continue with the business class booking");
                System.out.println("Enter e for exit");
                char option= scan.next().charAt(0);

                while ( (option!='y') && (option!='n' && (option!='e')) ){
                    System.out.println("Invalid! Please enter y (for yes) or n (for no) or e (for exit)");
                    System.out.println("Enter again..");
                    option= scan.next().charAt(0);
                }

                if(option=='e'){
                    intenationalPassengersList.remove(intenationalPassengerCurrCount);
                    intenationalPassengerCurrCount--;
                    g.global--;
                    return 0;
                }

                else if(option=='y'){
                    return j_detaili();
                }
            }

            //Printing the process if these are no seats available in the business class
            if(business_src1_desti3_seats.size()==0){
                System.out.println("\nNo seats are available in the Business class. Only Economy class seats are avaiable");
                System.out.println("Do you wish to make another Reservation (y/n/e)");
                System.out.println("Enter 'y' to make another Reservation. Enter 'n' to continue with the Economy class booking");
                System.out.println("Enter e to exit");
                char option= scan.next().charAt(0);

                while ( (option!='y') && (option!='n') && (option!='e') ){
                    System.out.println("Invalid! Please enter y (for yes) or n (for no) or e (for exit)");
                    System.out.println("Enter again..");
                    option= scan.next().charAt(0);
                }

                if(option=='e'){
                    intenationalPassengersList.remove(intenationalPassengerCurrCount);
                    intenationalPassengerCurrCount--;
                    g.global--;
                    return 0;
                }

                else if(option=='y'){
                    return j_detaili();
                }
            }

            System.out.println("\n\t \t \t \t \t \tFlights Found");
            System.out.println("");

            if( (business_src1_desti3_seats.size()!=0) && (economy_src1_desti3_seats.size()!=0) ){
                System.out.println("Airline:\t \tDeparture:\tArrival:\tPrice:\t\tCategory");
                System.out.println("1.Vistara(1)\t10:00\t\t14:05\t\tRs.25000\tEcononmy");
                System.out.println("2.Fly Dubai(2)\t14:00\t\t18:05\t\tRs.21500\tEcononmy");
                System.out.println("3.Emirates(3)\t18:00\t\t22:05\t\tRs.24000\tEcononmy");

                System.out.println("");
                System.out.println("Airline:\t \tDeparture:\tArrival:\tPrice:\t\tCategory");
                System.out.println("4.Vistara(1)\t10:00\t\t14:05\t\tRs.35000\tBusiness");
                System.out.println("5.Fly Dubai(2)\t14:00\t\t18:05\t\tRs.31500\tBusiness");
                System.out.println("6.Emirates(3)\t18:00\t\t22:05\t\tRs.34000\tBusiness");


                //getting the flight option from the user
                System.out.println("\nEnter your Flight choice:");
                choicei=scan.nextInt();

                //validating the choice
                while(choicei<1 || choicei>6){
                    System.out.println("Invalid! The choice can only be 1,2,3,4,5 or 6");
                    System.out.println("Enter again..");
                    choicei=scan.nextInt();
                }

                //condition for selection from Economy class
                if(choicei>=1 && choicei<4){
                    //displaying the Availaable Business class seats
                    System.out.println("\nSeat numbers available for Economy class booking\n");
                    for (int i = 0; i < economy_src1_desti3_seats.size(); i++) {
                        System.out.println("Seat No.: "+economy_src1_desti3_seats.get(i));
                    }

                    //getting the seat number choice from the user
                    System.out.println("\nEnter Seat No.:");
                    intenationalPassengersList.get(intenationalPassengerCurrCount).seat_no=scan.nextInt();

                    //validating the seat number choice
                    boolean found=false;
                    while(found!=true){

                        for (int i = 0; i < economy_src1_desti3_seats.size(); i++) {
                            //finding the seat and removing the seat at the same time in this condition
                            if(intenationalPassengersList.get(intenationalPassengerCurrCount).seat_no==economy_src1_desti3_seats.get(i)){
                                found=true;
                                economy_src1_desti3_seats.remove(i);

                                //after removing sorting the arraylist
                                Collections.sort(economy_src1_desti3_seats);
                            }
                        }

                        if(found==false){
                            System.out.println("Invalid! Please select a seat from the above available seats");
                            intenationalPassengersList.get(intenationalPassengerCurrCount).seat_no=scan.nextInt();
                        }
                    }

                    //The selected seat is being removed from the arraylist successfully
                }

                //condition for selection from the business class
                if(choicei>3 && choicei<7){
                    //displaying the Availaable Business class seats
                    System.out.println("\nSeat numbers available for business class booking\n");
                    for (int i = 0; i < business_src1_desti3_seats.size(); i++) {
                        System.out.println("Seat No.: "+business_src1_desti3_seats.get(i));
                    }

                    //getting the seat number choice from the user
                    System.out.println("\nEnter Seat No.:");
                    intenationalPassengersList.get(intenationalPassengerCurrCount).seat_no=scan.nextInt();

                    //validating the seat number choice
                    boolean found=false;
                    while(found!=true){

                        for (int i = 0; i < business_src1_desti3_seats.size(); i++) {
                            //finding the seat and removing the seat at the same time in this condition
                            if(intenationalPassengersList.get(intenationalPassengerCurrCount).seat_no==business_src1_desti3_seats.get(i)){
                                found=true;
                                business_src1_desti3_seats.remove(i);

                                //after removing sorting the arraylist
                                Collections.sort(business_src1_desti3_seats);
                            }
                        }

                        if(found==false){
                            System.out.println("Invalid! Please select a seat from the above available seats");
                            intenationalPassengersList.get(intenationalPassengerCurrCount).seat_no=scan.nextInt();
                        }
                    }

                    //The selected seat is being removed from the arraylist successfully
                }
            }

            if(economy_src1_desti3_seats.size()!=0 && business_src1_desti3_seats.size()==0) {
                System.out.println("Airline:\t \tDeparture:\tArrival:\tPrice:\t\tCategory");
                System.out.println("1.Vistara(1)\t10:00\t\t14:05\t\tRs.25000\tEcononmy");
                System.out.println("2.Fly Dubai(2)\t14:00\t\t18:05\t\tRs.21500\tEcononmy");
                System.out.println("3.Emirates(3)\t18:00\t\t22:05\t\tRs.24000\tEcononmy");
                System.out.println("");

                //getting the flight option from the user
                System.out.println("\nEnter your Flight choice:");
                choicei=scan.nextInt();

                //validating the choice
                while(choicei<1 || choicei>3){
                    System.out.println("Invalid! The choice can only be 1,2 or 3");
                    System.out.println("Enter again..");
                    choicei=scan.nextInt();
                }

                //displaying the Availaable Business class seats
                System.out.println("\nSeat numbers available for Economy class booking\n");
                for (int i = 0; i < economy_src1_desti3_seats.size(); i++) {
                    System.out.println("Seat No.: "+economy_src1_desti3_seats.get(i));
                }

                //getting the seat number choice from the user
                System.out.println("\nEnter Seat No.:");
                intenationalPassengersList.get(intenationalPassengerCurrCount).seat_no=scan.nextInt();

                //validating the seat number choice
                boolean found=false;
                while(found!=true){

                    for (int i = 0; i < economy_src1_desti3_seats.size(); i++) {
                        //finding the seat and removing the seat at the same time in this condition
                        if(intenationalPassengersList.get(intenationalPassengerCurrCount).seat_no==economy_src1_desti3_seats.get(i)){
                            found=true;
                            economy_src1_desti3_seats.remove(i);

                            //after removing sorting the arraylist
                            Collections.sort(economy_src1_desti3_seats);
                        }
                    }

                    if(found==false){
                        System.out.println("Invalid! Please select a seat from the above available seats");
                        intenationalPassengersList.get(intenationalPassengerCurrCount).seat_no=scan.nextInt();
                    }
                }

                //The selected seat is being removed from the arraylist successfully
            }

            if(business_src1_desti3_seats.size()!=0 && economy_src1_desti3_seats.size()==0) {
                System.out.println("Airline:\t \tDeparture:\tArrival:\tPrice:\t\tCategory");
                System.out.println("4.Vistara(1)\t10:00\t\t14:05\t\tRs.35000\tBusiness");
                System.out.println("5.Fly Dubai(2)\t14:00\t\t18:05\t\tRs.31500\tBusiness");
                System.out.println("6.Emirates(3)\t18:00\t\t22:05\t\tRs.34000\tBusiness");

                System.out.println("");

                //getting the flight option from the user
                System.out.println("\nEnter your Flight choice:");
                choicei=scan.nextInt();

                //validating the choice
                while(choicei<4 || choicei>6){
                    System.out.println("Invalid! The choice can only be 4,5 or 6");
                    System.out.println("Enter again..");
                    choicei=scan.nextInt();
                }

                //displaying the Availaable Business class seats
                System.out.println("\nSeat numbers available for business class booking\n");
                for (int i = 0; i < business_src1_desti3_seats.size(); i++) {
                    System.out.println("Seat No.: "+business_src1_desti3_seats.get(i));
                }

                //getting the seat number choice from the user
                System.out.println("\nEnter Seat No.:");
                intenationalPassengersList.get(intenationalPassengerCurrCount).seat_no=scan.nextInt();

                //validating the seat number choice
                boolean found=false;
                while(found!=true){

                    for (int i = 0; i < business_src1_desti3_seats.size(); i++) {
                        //finding the seat and removing the seat at the same time in this condition
                        if(intenationalPassengersList.get(intenationalPassengerCurrCount).seat_no==business_src1_desti3_seats.get(i)){
                            found=true;
                            business_src1_desti3_seats.remove(i);

                            //after removing sorting the arraylist
                            Collections.sort(business_src1_desti3_seats);
                        }
                    }

                    if(found==false){
                        System.out.println("Invalid! Please select a seat from the above available seats");
                        intenationalPassengersList.get(intenationalPassengerCurrCount).seat_no=scan.nextInt();
                    }
                }

                //The selected seat is being removed from the arraylist successfully
            }

            //setting the src and dest variables of the passenger class because it will later help in
            //identifying in which arraylist to add the cancelled seat (seat cancelled by the passenger)
            intenationalPassengersList.get(intenationalPassengerCurrCount).src=1;
            intenationalPassengersList.get(intenationalPassengerCurrCount).dest=3;
            intenationalPassengersList.get(intenationalPassengerCurrCount).source="London";
            intenationalPassengersList.get(intenationalPassengerCurrCount).destination="Abu Dhabi";


        }

        else if((srci==1 && desti==4))//condition
        {
            //original code
            /*System.out.println("Airline:\t \tDeparture:\tArrival:\tPrice:\t\tCategory");
            System.out.println("1.Vistara(1)\t10:00\t\t14:05\t\tRs.25500\tEconomy");
            System.out.println("2.Fly Dubai(2)\t14:00\t\t18:05\t\tRs.21300\tEconomy");
            System.out.println("3.Emirates(3)\t18:00\t\t22:05\t\tRs.24650\t\tEconomy");

            System.out.println("Airline:\t \tDeparture:\tArrival:\tPrice:\t\tCategory");
            System.out.println("4.Vistara(1)\t10:00\t\t14:05\t\tRs.35500\tBusiness");
            System.out.println("5.Fly Dubai(2)\t14:00\t\t18:05\t\tRs.31300\tBusiness");
            System.out.println("6.Emirates(3)\t18:00\t\t22:05\t\tRs.34650\t\tBusiness");
            */
            ///////////////////////////////////////////////////////////////////////////

            //checking the availability of the seats in the economy and business class
            if(economy_src1_desti4_seats.size()==0 && business_src1_desti4_seats.size()==0){

                char option;
                System.out.println("\nNo seats available in the business and economy class");
                System.out.println("Do you wish to make another Reservation (y/n):");
                option= scan.next().charAt(0);

                while ( (option!='y') && (option!='n') ){
                    System.out.println("Invalid! Please enter y (for yes) or n (for no)");
                    System.out.println("Enter again..");
                    option= scan.next().charAt(0);
                }

                if(option=='n'){
                    intenationalPassengersList.remove(intenationalPassengerCurrCount);
                    intenationalPassengerCurrCount--;
                    g.global--;
                    return 0;
                }

                else if(option=='y'){
                    return j_detaili();
                }

            }

            //Printing the process if these are no seats available in the economy class
            if(economy_src1_desti4_seats.size()==0){
                System.out.println("\nNo seats are available in the Economy class. Only Business class seats are avaiable");
                System.out.println("Do you wish to make another Reservation (y/n/e)");
                System.out.println("Enter 'y' to make another Reservation. Enter 'n' to continue with the business class booking");
                System.out.println("Enter e for exit");
                char option= scan.next().charAt(0);

                while ( (option!='y') && (option!='n' && (option!='e')) ){
                    System.out.println("Invalid! Please enter y (for yes) or n (for no) or e (for exit)");
                    System.out.println("Enter again..");
                    option= scan.next().charAt(0);
                }

                if(option=='e'){
                    intenationalPassengersList.remove(intenationalPassengerCurrCount);
                    intenationalPassengerCurrCount--;
                    g.global--;
                    return 0;
                }

                else if(option=='y'){
                    return j_detaili();
                }
            }

            //Printing the process if these are no seats available in the business class
            if(business_src1_desti4_seats.size()==0){
                System.out.println("\nNo seats are available in the Business class. Only Economy class seats are avaiable");
                System.out.println("Do you wish to make another Reservation (y/n/e)");
                System.out.println("Enter 'y' to make another Reservation. Enter 'n' to continue with the Economy class booking");
                System.out.println("Enter e to exit");
                char option= scan.next().charAt(0);

                while ( (option!='y') && (option!='n') && (option!='e') ){
                    System.out.println("Invalid! Please enter y (for yes) or n (for no) or e (for exit)");
                    System.out.println("Enter again..");
                    option= scan.next().charAt(0);
                }

                if(option=='e'){
                    intenationalPassengersList.remove(intenationalPassengerCurrCount);
                    intenationalPassengerCurrCount--;
                    g.global--;
                    return 0;
                }

                else if(option=='y'){
                    return j_detaili();
                }
            }

            System.out.println("\n\t \t \t \t \t \tFlights Found");
            System.out.println("");

            if( (business_src1_desti4_seats.size()!=0) && (economy_src1_desti4_seats.size()!=0) ){
                System.out.println("Airline:\t \tDeparture:\tArrival:\tPrice:\t\tCategory");
                System.out.println("1.Vistara(1)\t10:00\t\t14:05\t\tRs.25000\tEcononmy");
                System.out.println("2.Fly Dubai(2)\t14:00\t\t18:05\t\tRs.21500\tEcononmy");
                System.out.println("3.Emirates(3)\t18:00\t\t22:05\t\tRs.24000\tEcononmy");

                System.out.println("");
                System.out.println("Airline:\t \tDeparture:\tArrival:\tPrice:\t\tCategory");
                System.out.println("4.Vistara(1)\t10:00\t\t14:05\t\tRs.35000\tBusiness");
                System.out.println("5.Fly Dubai(2)\t14:00\t\t18:05\t\tRs.31500\tBusiness");
                System.out.println("6.Emirates(3)\t18:00\t\t22:05\t\tRs.34000\tBusiness");


                //getting the flight option from the user
                System.out.println("\nEnter your Flight choice:");
                choicei=scan.nextInt();

                //validating the choice
                while(choicei<1 || choicei>6){
                    System.out.println("Invalid! The choice can only be 1,2,3,4,5 or 6");
                    System.out.println("Enter again..");
                    choicei=scan.nextInt();
                }

                //condition for selection from Economy class
                if(choicei>=1 && choicei<4){
                    //displaying the Availaable Business class seats
                    System.out.println("\nSeat numbers available for Economy class booking\n");
                    for (int i = 0; i < economy_src1_desti4_seats.size(); i++) {
                        System.out.println("Seat No.: "+economy_src1_desti4_seats.get(i));
                    }

                    //getting the seat number choice from the user
                    System.out.println("\nEnter Seat No.:");
                    intenationalPassengersList.get(intenationalPassengerCurrCount).seat_no=scan.nextInt();

                    //validating the seat number choice
                    boolean found=false;
                    while(found!=true){

                        for (int i = 0; i < economy_src1_desti4_seats.size(); i++) {
                            //finding the seat and removing the seat at the same time in this condition
                            if(intenationalPassengersList.get(intenationalPassengerCurrCount).seat_no==economy_src1_desti4_seats.get(i)){
                                found=true;
                                economy_src1_desti4_seats.remove(i);

                                //after removing sorting the arraylist
                                Collections.sort(economy_src1_desti4_seats);
                            }
                        }

                        if(found==false){
                            System.out.println("Invalid! Please select a seat from the above available seats");
                            intenationalPassengersList.get(intenationalPassengerCurrCount).seat_no=scan.nextInt();
                        }
                    }

                    //The selected seat is being removed from the arraylist successfully
                }

                //condition for selection from the business class
                if(choicei>3 && choicei<7){
                    //displaying the Availaable Business class seats
                    System.out.println("\nSeat numbers available for business class booking\n");
                    for (int i = 0; i < business_src1_desti4_seats.size(); i++) {
                        System.out.println("Seat No.: "+business_src1_desti4_seats.get(i));
                    }

                    //getting the seat number choice from the user
                    System.out.println("\nEnter Seat No.:");
                    intenationalPassengersList.get(intenationalPassengerCurrCount).seat_no=scan.nextInt();

                    //validating the seat number choice
                    boolean found=false;
                    while(found!=true){

                        for (int i = 0; i < business_src1_desti4_seats.size(); i++) {
                            //finding the seat and removing the seat at the same time in this condition
                            if(intenationalPassengersList.get(intenationalPassengerCurrCount).seat_no==business_src1_desti4_seats.get(i)){
                                found=true;
                                business_src1_desti4_seats.remove(i);

                                //after removing sorting the arraylist
                                Collections.sort(business_src1_desti4_seats);
                            }
                        }

                        if(found==false){
                            System.out.println("Invalid! Please select a seat from the above available seats");
                            intenationalPassengersList.get(intenationalPassengerCurrCount).seat_no=scan.nextInt();
                        }
                    }

                    //The selected seat is being removed from the arraylist successfully
                }
            }

            if(economy_src1_desti4_seats.size()!=0 && business_src1_desti4_seats.size()==0) {
                System.out.println("Airline:\t \tDeparture:\tArrival:\tPrice:\t\tCategory");
                System.out.println("1.Vistara(1)\t10:00\t\t14:05\t\tRs.25000\tEcononmy");
                System.out.println("2.Fly Dubai(2)\t14:00\t\t18:05\t\tRs.21500\tEcononmy");
                System.out.println("3.Emirates(3)\t18:00\t\t22:05\t\tRs.24000\tEcononmy");
                System.out.println("");

                //getting the flight option from the user
                System.out.println("\nEnter your Flight choice:");
                choicei=scan.nextInt();

                //validating the choice
                while(choicei<1 || choicei>3){
                    System.out.println("Invalid! The choice can only be 1,2 or 3");
                    System.out.println("Enter again..");
                    choicei=scan.nextInt();
                }

                //displaying the Availaable Business class seats
                System.out.println("\nSeat numbers available for Economy class booking\n");
                for (int i = 0; i < economy_src1_desti4_seats.size(); i++) {
                    System.out.println("Seat No.: "+economy_src1_desti4_seats.get(i));
                }

                //getting the seat number choice from the user
                System.out.println("\nEnter Seat No.:");
                intenationalPassengersList.get(intenationalPassengerCurrCount).seat_no=scan.nextInt();

                //validating the seat number choice
                boolean found=false;
                while(found!=true){

                    for (int i = 0; i < economy_src1_desti4_seats.size(); i++) {
                        //finding the seat and removing the seat at the same time in this condition
                        if(intenationalPassengersList.get(intenationalPassengerCurrCount).seat_no==economy_src1_desti4_seats.get(i)){
                            found=true;
                            economy_src1_desti4_seats.remove(i);

                            //after removing sorting the arraylist
                            Collections.sort(economy_src1_desti4_seats);
                        }
                    }

                    if(found==false){
                        System.out.println("Invalid! Please select a seat from the above available seats");
                        intenationalPassengersList.get(intenationalPassengerCurrCount).seat_no=scan.nextInt();
                    }
                }

                //The selected seat is being removed from the arraylist successfully
            }

            if(business_src1_desti4_seats.size()!=0 && economy_src1_desti4_seats.size()==0) {
                System.out.println("Airline:\t \tDeparture:\tArrival:\tPrice:\t\tCategory");
                System.out.println("4.Vistara(1)\t10:00\t\t14:05\t\tRs.35000\tBusiness");
                System.out.println("5.Fly Dubai(2)\t14:00\t\t18:05\t\tRs.31500\tBusiness");
                System.out.println("6.Emirates(3)\t18:00\t\t22:05\t\tRs.34000\tBusiness");

                System.out.println("");

                //getting the flight option from the user
                System.out.println("\nEnter your Flight choice:");
                choicei=scan.nextInt();

                //validating the choice
                while(choicei<4 || choicei>6){
                    System.out.println("Invalid! The choice can only be 4,5 or 6");
                    System.out.println("Enter again..");
                    choicei=scan.nextInt();
                }

                //displaying the Availaable Business class seats
                System.out.println("\nSeat numbers available for business class booking\n");
                for (int i = 0; i < business_src1_desti4_seats.size(); i++) {
                    System.out.println("Seat No.: "+business_src1_desti4_seats.get(i));
                }

                //getting the seat number choice from the user
                System.out.println("\nEnter Seat No.:");
                intenationalPassengersList.get(intenationalPassengerCurrCount).seat_no=scan.nextInt();

                //validating the seat number choice
                boolean found=false;
                while(found!=true){

                    for (int i = 0; i < business_src1_desti4_seats.size(); i++) {
                        //finding the seat and removing the seat at the same time in this condition
                        if(intenationalPassengersList.get(intenationalPassengerCurrCount).seat_no==business_src1_desti4_seats.get(i)){
                            found=true;
                            business_src1_desti4_seats.remove(i);

                            //after removing sorting the arraylist
                            Collections.sort(business_src1_desti4_seats);
                        }
                    }

                    if(found==false){
                        System.out.println("Invalid! Please select a seat from the above available seats");
                        intenationalPassengersList.get(intenationalPassengerCurrCount).seat_no=scan.nextInt();
                    }
                }

                //The selected seat is being removed from the arraylist successfully
            }

            //setting the src and dest variables of the passenger class because it will later help in
            //identifying in which arraylist to add the cancelled seat (seat cancelled by the passenger)
            intenationalPassengersList.get(intenationalPassengerCurrCount).src=1;
            intenationalPassengersList.get(intenationalPassengerCurrCount).dest=4;
            intenationalPassengersList.get(intenationalPassengerCurrCount).source="London";
            intenationalPassengersList.get(intenationalPassengerCurrCount).destination="Singapore";


        }

        else if((srci==1 && desti==5) )//condition
        {
            //original code
            /*System.out.println("Airline:\t \tDeparture:\tArrival:\tPrice:\t\tCategory");
            System.out.println("1.Vistara(1)\t10:00\t\t14:05\t\tRs.52500\tEconomy");
            System.out.println("2.Fly Dubai(2)\t14:00\t\t18:05\t\tRs.59420\tEconomy");
            System.out.println("3.Emirates(3)\t18:00\t\t22:05\t\tRs.64892\tEconomy");

            System.out.println("Airline:\t \tDeparture:\tArrival:\tPrice:\t\tCategory");
            System.out.println("4.Vistara(1)\t10:00\t\t14:05\t\tRs.62500\tBusiness");
            System.out.println("5.Fly Dubai(2)\t14:00\t\t18:05\t\tRs.69420\tBusiness");
            System.out.println("6.Emirates(3)\t18:00\t\t22:05\t\tRs.74892\tBusiness");
            */
            ////////////////////////////////////////////////////////////////////////////

            //checking the availability of the seats in the economy and business class
            if(economy_src1_desti5_seats.size()==0 && business_src1_desti5_seats.size()==0){

                char option;
                System.out.println("\nNo seats available in the business and economy class");
                System.out.println("Do you wish to make another Reservation (y/n):");
                option= scan.next().charAt(0);

                while ( (option!='y') && (option!='n') ){
                    System.out.println("Invalid! Please enter y (for yes) or n (for no)");
                    System.out.println("Enter again..");
                    option= scan.next().charAt(0);
                }

                if(option=='n'){
                    intenationalPassengersList.remove(intenationalPassengerCurrCount);
                    intenationalPassengerCurrCount--;
                    g.global--;
                    return 0;
                }

                else if(option=='y'){
                    return j_detaili();
                }

            }

            //Printing the process if these are no seats available in the economy class
            if(economy_src1_desti5_seats.size()==0){
                System.out.println("\nNo seats are available in the Economy class. Only Business class seats are avaiable");
                System.out.println("Do you wish to make another Reservation (y/n/e)");
                System.out.println("Enter 'y' to make another Reservation. Enter 'n' to continue with the business class booking");
                System.out.println("Enter e for exit");
                char option= scan.next().charAt(0);

                while ( (option!='y') && (option!='n' && (option!='e')) ){
                    System.out.println("Invalid! Please enter y (for yes) or n (for no) or e (for exit)");
                    System.out.println("Enter again..");
                    option= scan.next().charAt(0);
                }

                if(option=='e'){
                    intenationalPassengersList.remove(intenationalPassengerCurrCount);
                    intenationalPassengerCurrCount--;
                    g.global--;
                    return 0;
                }

                else if(option=='y'){
                    return j_detaili();
                }
            }

            //Printing the process if these are no seats available in the business class
            if(business_src1_desti5_seats.size()==0){
                System.out.println("\nNo seats are available in the Business class. Only Economy class seats are avaiable");
                System.out.println("Do you wish to make another Reservation (y/n/e)");
                System.out.println("Enter 'y' to make another Reservation. Enter 'n' to continue with the Economy class booking");
                System.out.println("Enter e to exit");
                char option= scan.next().charAt(0);

                while ( (option!='y') && (option!='n') && (option!='e') ){
                    System.out.println("Invalid! Please enter y (for yes) or n (for no) or e (for exit)");
                    System.out.println("Enter again..");
                    option= scan.next().charAt(0);
                }

                if(option=='e'){
                    intenationalPassengersList.remove(intenationalPassengerCurrCount);
                    intenationalPassengerCurrCount--;
                    g.global--;
                    return 0;
                }

                else if(option=='y'){
                    return j_detaili();
                }
            }

            System.out.println("\n\t \t \t \t \t \tFlights Found");
            System.out.println("");

            if( (business_src1_desti5_seats.size()!=0) && (economy_src1_desti5_seats.size()!=0) ){
                System.out.println("Airline:\t \tDeparture:\tArrival:\tPrice:\t\tCategory");
                System.out.println("1.Vistara(1)\t10:00\t\t14:05\t\tRs.52500\tEconomy");
                System.out.println("2.Fly Dubai(2)\t14:00\t\t18:05\t\tRs.59420\tEconomy");
                System.out.println("3.Emirates(3)\t18:00\t\t22:05\t\tRs.64892\tEconomy");

                System.out.println("");
                System.out.println("Airline:\t \tDeparture:\tArrival:\tPrice:\t\tCategory");
                System.out.println("4.Vistara(1)\t10:00\t\t14:05\t\tRs.62500\tBusiness");
                System.out.println("5.Fly Dubai(2)\t14:00\t\t18:05\t\tRs.69420\tBusiness");
                System.out.println("6.Emirates(3)\t18:00\t\t22:05\t\tRs.74892\tBusiness");


                //getting the flight option from the user
                System.out.println("\nEnter your Flight choice:");
                choicei=scan.nextInt();

                //validating the choice
                while(choicei<1 || choicei>6){
                    System.out.println("Invalid! The choice can only be 1,2,3,4,5 or 6");
                    System.out.println("Enter again..");
                    choicei=scan.nextInt();
                }

                //condition for selection from Economy class
                if(choicei>=1 && choicei<4){
                    //displaying the Availaable Business class seats
                    System.out.println("\nSeat numbers available for Economy class booking\n");
                    for (int i = 0; i < economy_src1_desti5_seats.size(); i++) {
                        System.out.println("Seat No.: "+economy_src1_desti5_seats.get(i));
                    }

                    //getting the seat number choice from the user
                    System.out.println("\nEnter Seat No.:");
                    intenationalPassengersList.get(intenationalPassengerCurrCount).seat_no=scan.nextInt();

                    //validating the seat number choice
                    boolean found=false;
                    while(found!=true){

                        for (int i = 0; i < economy_src1_desti5_seats.size(); i++) {
                            //finding the seat and removing the seat at the same time in this condition
                            if(intenationalPassengersList.get(intenationalPassengerCurrCount).seat_no==economy_src1_desti5_seats.get(i)){
                                found=true;
                                economy_src1_desti5_seats.remove(i);

                                //after removing sorting the arraylist
                                Collections.sort(economy_src1_desti5_seats);
                            }
                        }

                        if(found==false){
                            System.out.println("Invalid! Please select a seat from the above available seats");
                            intenationalPassengersList.get(intenationalPassengerCurrCount).seat_no=scan.nextInt();
                        }
                    }

                    //The selected seat is being removed from the arraylist successfully
                }

                //condition for selection from the business class
                if(choicei>3 && choicei<7){
                    //displaying the Availaable Business class seats
                    System.out.println("\nSeat numbers available for business class booking\n");
                    for (int i = 0; i < business_src1_desti5_seats.size(); i++) {
                        System.out.println("Seat No.: "+business_src1_desti5_seats.get(i));
                    }

                    //getting the seat number choice from the user
                    System.out.println("\nEnter Seat No.:");
                    intenationalPassengersList.get(intenationalPassengerCurrCount).seat_no=scan.nextInt();

                    //validating the seat number choice
                    boolean found=false;
                    while(found!=true){

                        for (int i = 0; i < business_src1_desti5_seats.size(); i++) {
                            //finding the seat and removing the seat at the same time in this condition
                            if(intenationalPassengersList.get(intenationalPassengerCurrCount).seat_no==business_src1_desti5_seats.get(i)){
                                found=true;
                                business_src1_desti5_seats.remove(i);

                                //after removing sorting the arraylist
                                Collections.sort(business_src1_desti5_seats);
                            }
                        }

                        if(found==false){
                            System.out.println("Invalid! Please select a seat from the above available seats");
                            intenationalPassengersList.get(intenationalPassengerCurrCount).seat_no=scan.nextInt();
                        }
                    }

                    //The selected seat is being removed from the arraylist successfully
                }
            }

            if(economy_src1_desti5_seats.size()!=0 && business_src1_desti5_seats.size()==0) {
                System.out.println("Airline:\t \tDeparture:\tArrival:\tPrice:\t\tCategory");
                System.out.println("1.Vistara(1)\t10:00\t\t14:05\t\tRs.52500\tEconomy");
                System.out.println("2.Fly Dubai(2)\t14:00\t\t18:05\t\tRs.59420\tEconomy");
                System.out.println("3.Emirates(3)\t18:00\t\t22:05\t\tRs.64892\tEconomy");
                System.out.println("");

                //getting the flight option from the user
                System.out.println("\nEnter your Flight choice:");
                choicei=scan.nextInt();

                //validating the choice
                while(choicei<1 || choicei>3){
                    System.out.println("Invalid! The choice can only be 1,2 or 3");
                    System.out.println("Enter again..");
                    choicei=scan.nextInt();
                }

                //displaying the Availaable Business class seats
                System.out.println("\nSeat numbers available for Economy class booking\n");
                for (int i = 0; i < economy_src1_desti5_seats.size(); i++) {
                    System.out.println("Seat No.: "+economy_src1_desti5_seats.get(i));
                }

                //getting the seat number choice from the user
                System.out.println("\nEnter Seat No.:");
                intenationalPassengersList.get(intenationalPassengerCurrCount).seat_no=scan.nextInt();

                //validating the seat number choice
                boolean found=false;
                while(found!=true){

                    for (int i = 0; i < economy_src1_desti5_seats.size(); i++) {
                        //finding the seat and removing the seat at the same time in this condition
                        if(intenationalPassengersList.get(intenationalPassengerCurrCount).seat_no==economy_src1_desti5_seats.get(i)){
                            found=true;
                            economy_src1_desti5_seats.remove(i);

                            //after removing sorting the arraylist
                            Collections.sort(economy_src1_desti5_seats);
                        }
                    }

                    if(found==false){
                        System.out.println("Invalid! Please select a seat from the above available seats");
                        intenationalPassengersList.get(intenationalPassengerCurrCount).seat_no=scan.nextInt();
                    }
                }

                //The selected seat is being removed from the arraylist successfully
            }

            if(business_src1_desti5_seats.size()!=0 && economy_src1_desti5_seats.size()==0) {
                System.out.println("Airline:\t \tDeparture:\tArrival:\tPrice:\t\tCategory");
                System.out.println("4.Vistara(1)\t10:00\t\t14:05\t\tRs.62500\tBusiness");
                System.out.println("5.Fly Dubai(2)\t14:00\t\t18:05\t\tRs.69420\tBusiness");
                System.out.println("6.Emirates(3)\t18:00\t\t22:05\t\tRs.74892\tBusiness");

                System.out.println("");

                //getting the flight option from the user
                System.out.println("\nEnter your Flight choice:");
                choicei=scan.nextInt();

                //validating the choice
                while(choicei<4 || choicei>6){
                    System.out.println("Invalid! The choice can only be 4,5 or 6");
                    System.out.println("Enter again..");
                    choicei=scan.nextInt();
                }

                //displaying the Availaable Business class seats
                System.out.println("\nSeat numbers available for business class booking\n");
                for (int i = 0; i < business_src1_desti5_seats.size(); i++) {
                    System.out.println("Seat No.: "+business_src1_desti5_seats.get(i));
                }

                //getting the seat number choice from the user
                System.out.println("\nEnter Seat No.:");
                intenationalPassengersList.get(intenationalPassengerCurrCount).seat_no=scan.nextInt();

                //validating the seat number choice
                boolean found=false;
                while(found!=true){

                    for (int i = 0; i < business_src1_desti5_seats.size(); i++) {
                        //finding the seat and removing the seat at the same time in this condition
                        if(intenationalPassengersList.get(intenationalPassengerCurrCount).seat_no==business_src1_desti5_seats.get(i)){
                            found=true;
                            business_src1_desti5_seats.remove(i);

                            //after removing sorting the arraylist
                            Collections.sort(business_src1_desti5_seats);
                        }
                    }

                    if(found==false){
                        System.out.println("Invalid! Please select a seat from the above available seats");
                        intenationalPassengersList.get(intenationalPassengerCurrCount).seat_no=scan.nextInt();
                    }
                }

                //The selected seat is being removed from the arraylist successfully
            }

            //setting the src and dest variables of the passenger class because it will later help in
            //identifying in which arraylist to add the cancelled seat (seat cancelled by the passenger)
            intenationalPassengersList.get(intenationalPassengerCurrCount).src=1;
            intenationalPassengersList.get(intenationalPassengerCurrCount).dest=5;
            intenationalPassengersList.get(intenationalPassengerCurrCount).source="London";
            intenationalPassengersList.get(intenationalPassengerCurrCount).destination="NewYork";


        }

        else if( srci==2 && desti==1 )//condition
        {
            //original code
            /*System.out.println("Airline:\t \tDeparture:\tArrival:\tPrice:\t\tCategory");
            System.out.println("1.Vistara(1)\t23:00\t\t16:10\t\tRs.75500\tEconomy");
            System.out.println("2.Fly Dubai(2)\t2:00\t\t19:05\t\tRs.86450\tEconomy");
            System.out.println("3.Emirates(3)\t18:00\t\t10:05\t\tRs.93650\tEconomy");

            System.out.println("");
            System.out.println("Airline:\t \tDeparture:\tArrival:\tPrice:\t\tCategory");
            System.out.println("4.Vistara(1)\t23:00\t\t16:10\t\tRs.85500\tBusiness");
            System.out.println("5.Fly Dubai(2)\t2:00\t\t19:05\t\tRs.96450\tBusiness");
            System.out.println("6.Emirates(3)\t18:00\t\t10:05\t\tRs.1,03,650\tBusiness");
            */
            //////////////////////////////////////////////////////////////////////////

            //checking the availability of the seats in the economy and business class
            if(economy_src2_desti1_seats.size()==0 && business_src2_desti1_seats.size()==0){

                char option;
                System.out.println("\nNo seats available in the business and economy class");
                System.out.println("Do you wish to make another Reservation (y/n):");
                option= scan.next().charAt(0);

                while ( (option!='y') && (option!='n') ){
                    System.out.println("Invalid! Please enter y (for yes) or n (for no)");
                    System.out.println("Enter again..");
                    option= scan.next().charAt(0);
                }

                if(option=='n'){
                    intenationalPassengersList.remove(intenationalPassengerCurrCount);
                    intenationalPassengerCurrCount--;
                    g.global--;
                    return 0;
                }

                else if(option=='y'){
                    return j_detaili();
                }

            }

            //Printing the process if these are no seats available in the economy class
            if(economy_src2_desti1_seats.size()==0){
                System.out.println("\nNo seats are available in the Economy class. Only Business class seats are avaiable");
                System.out.println("Do you wish to make another Reservation (y/n/e)");
                System.out.println("Enter 'y' to make another Reservation. Enter 'n' to continue with the business class booking");
                System.out.println("Enter e for exit");
                char option= scan.next().charAt(0);

                while ( (option!='y') && (option!='n' && (option!='e')) ){
                    System.out.println("Invalid! Please enter y (for yes) or n (for no) or e (for exit)");
                    System.out.println("Enter again..");
                    option= scan.next().charAt(0);
                }

                if(option=='e'){
                    intenationalPassengersList.remove(intenationalPassengerCurrCount);
                    intenationalPassengerCurrCount--;
                    g.global--;
                    return 0;
                }

                else if(option=='y'){
                    return j_detaili();
                }
            }

            //Printing the process if these are no seats available in the business class
            if(business_src2_desti1_seats.size()==0){
                System.out.println("\nNo seats are available in the Business class. Only Economy class seats are avaiable");
                System.out.println("Do you wish to make another Reservation (y/n/e)");
                System.out.println("Enter 'y' to make another Reservation. Enter 'n' to continue with the Economy class booking");
                System.out.println("Enter e to exit");
                char option= scan.next().charAt(0);

                while ( (option!='y') && (option!='n') && (option!='e') ){
                    System.out.println("Invalid! Please enter y (for yes) or n (for no) or e (for exit)");
                    System.out.println("Enter again..");
                    option= scan.next().charAt(0);
                }

                if(option=='e'){
                    intenationalPassengersList.remove(intenationalPassengerCurrCount);
                    intenationalPassengerCurrCount--;
                    g.global--;
                    return 0;
                }

                else if(option=='y'){
                    return j_detaili();
                }
            }

            System.out.println("\n\t \t \t \t \t \tFlights Found");
            System.out.println("");

            if( (business_src2_desti1_seats.size()!=0) && (economy_src2_desti1_seats.size()!=0) ){
                System.out.println("Airline:\t \tDeparture:\tArrival:\tPrice:\t\tCategory");
                System.out.println("1.Vistara(1)\t23:00\t\t16:10\t\tRs.75500\tEconomy");
                System.out.println("2.Fly Dubai(2)\t2:00\t\t19:05\t\tRs.86450\tEconomy");
                System.out.println("3.Emirates(3)\t18:00\t\t10:05\t\tRs.93650\tEconomy");

                System.out.println("");
                System.out.println("Airline:\t \tDeparture:\tArrival:\tPrice:\t\tCategory");
                System.out.println("4.Vistara(1)\t23:00\t\t16:10\t\tRs.85500\tBusiness");
                System.out.println("5.Fly Dubai(2)\t2:00\t\t19:05\t\tRs.96450\tBusiness");
                System.out.println("6.Emirates(3)\t18:00\t\t10:05\t\tRs.1,03,650\tBusiness");

                //getting the flight option from the user
                System.out.println("\nEnter your Flight choice:");
                choicei=scan.nextInt();

                //validating the choice
                while(choicei<1 || choicei>6){
                    System.out.println("Invalid! The choice can only be 1,2,3,4,5 or 6");
                    System.out.println("Enter again..");
                    choicei=scan.nextInt();
                }

                //condition for selection from Economy class
                if(choicei>=1 && choicei<4){
                    //displaying the Availaable Business class seats
                    System.out.println("\nSeat numbers available for Economy class booking\n");
                    for (int i = 0; i < economy_src2_desti1_seats.size(); i++) {
                        System.out.println("Seat No.: "+economy_src2_desti1_seats.get(i));
                    }

                    //getting the seat number choice from the user
                    System.out.println("\nEnter Seat No.:");
                    intenationalPassengersList.get(intenationalPassengerCurrCount).seat_no=scan.nextInt();

                    //validating the seat number choice
                    boolean found=false;
                    while(found!=true){

                        for (int i = 0; i < economy_src2_desti1_seats.size(); i++) {
                            //finding the seat and removing the seat at the same time in this condition
                            if(intenationalPassengersList.get(intenationalPassengerCurrCount).seat_no==economy_src2_desti1_seats.get(i)){
                                found=true;
                                economy_src2_desti1_seats.remove(i);

                                //after removing sorting the arraylist
                                Collections.sort(economy_src2_desti1_seats);
                            }
                        }

                        if(found==false){
                            System.out.println("Invalid! Please select a seat from the above available seats");
                            intenationalPassengersList.get(intenationalPassengerCurrCount).seat_no=scan.nextInt();
                        }
                    }

                    //The selected seat is being removed from the arraylist successfully
                }

                //condition for selection from the business class
                if(choicei>3 && choicei<7){
                    //displaying the Availaable Business class seats
                    System.out.println("\nSeat numbers available for business class booking\n");
                    for (int i = 0; i < business_src2_desti1_seats.size(); i++) {
                        System.out.println("Seat No.: "+business_src2_desti1_seats.get(i));
                    }

                    //getting the seat number choice from the user
                    System.out.println("\nEnter Seat No.:");
                    intenationalPassengersList.get(intenationalPassengerCurrCount).seat_no=scan.nextInt();

                    //validating the seat number choice
                    boolean found=false;
                    while(found!=true){

                        for (int i = 0; i < business_src2_desti1_seats.size(); i++) {
                            //finding the seat and removing the seat at the same time in this condition
                            if(intenationalPassengersList.get(intenationalPassengerCurrCount).seat_no==business_src2_desti1_seats.get(i)){
                                found=true;
                                business_src2_desti1_seats.remove(i);

                                //after removing sorting the arraylist
                                Collections.sort(business_src2_desti1_seats);
                            }
                        }

                        if(found==false){
                            System.out.println("Invalid! Please select a seat from the above available seats");
                            intenationalPassengersList.get(intenationalPassengerCurrCount).seat_no=scan.nextInt();
                        }
                    }

                    //The selected seat is being removed from the arraylist successfully
                }
            }

            if(economy_src2_desti1_seats.size()!=0 && business_src2_desti1_seats.size()==0) {
                System.out.println("Airline:\t \tDeparture:\tArrival:\tPrice:\t\tCategory");
                System.out.println("1.Vistara(1)\t23:00\t\t16:10\t\tRs.75500\tEconomy");
                System.out.println("2.Fly Dubai(2)\t2:00\t\t19:05\t\tRs.86450\tEconomy");
                System.out.println("3.Emirates(3)\t18:00\t\t10:05\t\tRs.93650\tEconomy");
                System.out.println("");

                //getting the flight option from the user
                System.out.println("\nEnter your Flight choice:");
                choicei=scan.nextInt();

                //validating the choice
                while(choicei<1 || choicei>3){
                    System.out.println("Invalid! The choice can only be 1,2 or 3");
                    System.out.println("Enter again..");
                    choicei=scan.nextInt();
                }

                //displaying the Availaable Business class seats
                System.out.println("\nSeat numbers available for Economy class booking\n");
                for (int i = 0; i < economy_src2_desti1_seats.size(); i++) {
                    System.out.println("Seat No.: "+economy_src2_desti1_seats.get(i));
                }

                //getting the seat number choice from the user
                System.out.println("\nEnter Seat No.:");
                intenationalPassengersList.get(intenationalPassengerCurrCount).seat_no=scan.nextInt();

                //validating the seat number choice
                boolean found=false;
                while(found!=true){

                    for (int i = 0; i < economy_src2_desti1_seats.size(); i++) {
                        //finding the seat and removing the seat at the same time in this condition
                        if(intenationalPassengersList.get(intenationalPassengerCurrCount).seat_no==economy_src2_desti1_seats.get(i)){
                            found=true;
                            economy_src2_desti1_seats.remove(i);

                            //after removing sorting the arraylist
                            Collections.sort(economy_src2_desti1_seats);
                        }
                    }

                    if(found==false){
                        System.out.println("Invalid! Please select a seat from the above available seats");
                        intenationalPassengersList.get(intenationalPassengerCurrCount).seat_no=scan.nextInt();
                    }
                }

                //The selected seat is being removed from the arraylist successfully
            }

            if(business_src2_desti1_seats.size()!=0 && economy_src2_desti1_seats.size()==0) {
                System.out.println("");
                System.out.println("Airline:\t \tDeparture:\tArrival:\tPrice:\t\tCategory");
                System.out.println("4.Vistara(1)\t23:00\t\t16:10\t\tRs.85500\tBusiness");
                System.out.println("5.Fly Dubai(2)\t2:00\t\t19:05\t\tRs.96450\tBusiness");
                System.out.println("6.Emirates(3)\t18:00\t\t10:05\t\tRs.1,03,650\tBusiness");
                System.out.println("");

                //getting the flight option from the user
                System.out.println("\nEnter your Flight choice:");
                choicei=scan.nextInt();

                //validating the choice
                while(choicei<4 || choicei>6){
                    System.out.println("Invalid! The choice can only be 4,5 or 6");
                    System.out.println("Enter again..");
                    choicei=scan.nextInt();
                }

                //displaying the Availaable Business class seats
                System.out.println("\nSeat numbers available for business class booking\n");
                for (int i = 0; i < business_src2_desti1_seats.size(); i++) {
                    System.out.println("Seat No.: "+business_src2_desti1_seats.get(i));
                }

                //getting the seat number choice from the user
                System.out.println("\nEnter Seat No.:");
                intenationalPassengersList.get(intenationalPassengerCurrCount).seat_no=scan.nextInt();

                //validating the seat number choice
                boolean found=false;
                while(found!=true){

                    for (int i = 0; i < business_src2_desti1_seats.size(); i++) {
                        //finding the seat and removing the seat at the same time in this condition
                        if(intenationalPassengersList.get(intenationalPassengerCurrCount).seat_no==business_src2_desti1_seats.get(i)){
                            found=true;
                            business_src2_desti1_seats.remove(i);

                            //after removing sorting the arraylist
                            Collections.sort(business_src2_desti1_seats);
                        }
                    }

                    if(found==false){
                        System.out.println("Invalid! Please select a seat from the above available seats");
                        intenationalPassengersList.get(intenationalPassengerCurrCount).seat_no=scan.nextInt();
                    }
                }

                //The selected seat is being removed from the arraylist successfully
            }

            //setting the src and dest variables of the passenger class because it will later help in
            //identifying in which arraylist to add the cancelled seat (seat cancelled by the passenger)
            intenationalPassengersList.get(intenationalPassengerCurrCount).src=2;
            intenationalPassengersList.get(intenationalPassengerCurrCount).dest=1;
            intenationalPassengersList.get(intenationalPassengerCurrCount).source="Dubai";
            intenationalPassengersList.get(intenationalPassengerCurrCount).destination="London";


        }

        else if((srci==2 && desti==3) )//condition
        {
            //original code
            /*System.out.println("Airline:\t \tDeparture:\tArrival:\tPrice:\t\tCategory");
            System.out.println("1.Vistara(1)\t10:00\t\t14:05\t\tRs.17800\tEconomy");
            System.out.println("2.Fly Dubai(2)\t14:00\t\t18:05\t\tRs.14900\tEconomy");
            System.out.println("3.Emirates(3)\t18:00\t\t22:05\t\tRs.18700\tEconomy");

            System.out.println("");
            System.out.println("Airline:\t \tDeparture:\tArrival:\tPrice:\t\tCategory");
            System.out.println("4.Vistara(1)\t10:00\t\t14:05\t\tRs.27800\tBusiness");
            System.out.println("5.Fly Dubai(2)\t14:00\t\t18:05\t\tRs.24900\tBusiness");
            System.out.println("6.Emirates(3)\t18:00\t\t22:05\t\tRs.28700\tBusiness");
            */
            ///////////////////////////////////////////////////////////////////////////

            //checking the availability of the seats in the economy and business class
            if(economy_src2_desti3_seats.size()==0 && business_src2_desti3_seats.size()==0){

                char option;
                System.out.println("\nNo seats available in the business and economy class");
                System.out.println("Do you wish to make another Reservation (y/n):");
                option= scan.next().charAt(0);

                while ( (option!='y') && (option!='n') ){
                    System.out.println("Invalid! Please enter y (for yes) or n (for no)");
                    System.out.println("Enter again..");
                    option= scan.next().charAt(0);
                }

                if(option=='n'){
                    intenationalPassengersList.remove(intenationalPassengerCurrCount);
                    intenationalPassengerCurrCount--;
                    g.global--;
                    return 0;
                }

                else if(option=='y'){
                    return j_detaili();
                }

            }

            //Printing the process if these are no seats available in the economy class
            if(economy_src2_desti3_seats.size()==0){
                System.out.println("\nNo seats are available in the Economy class. Only Business class seats are avaiable");
                System.out.println("Do you wish to make another Reservation (y/n/e)");
                System.out.println("Enter 'y' to make another Reservation. Enter 'n' to continue with the business class booking");
                System.out.println("Enter e for exit");
                char option= scan.next().charAt(0);

                while ( (option!='y') && (option!='n' && (option!='e')) ){
                    System.out.println("Invalid! Please enter y (for yes) or n (for no) or e (for exit)");
                    System.out.println("Enter again..");
                    option= scan.next().charAt(0);
                }

                if(option=='e'){
                    intenationalPassengersList.remove(intenationalPassengerCurrCount);
                    intenationalPassengerCurrCount--;
                    g.global--;
                    return 0;
                }

                else if(option=='y'){
                    return j_detaili();
                }
            }

            //Printing the process if these are no seats available in the business class
            if(business_src2_desti3_seats.size()==0){
                System.out.println("\nNo seats are available in the Business class. Only Economy class seats are avaiable");
                System.out.println("Do you wish to make another Reservation (y/n/e)");
                System.out.println("Enter 'y' to make another Reservation. Enter 'n' to continue with the Economy class booking");
                System.out.println("Enter e to exit");
                char option= scan.next().charAt(0);

                while ( (option!='y') && (option!='n') && (option!='e') ){
                    System.out.println("Invalid! Please enter y (for yes) or n (for no) or e (for exit)");
                    System.out.println("Enter again..");
                    option= scan.next().charAt(0);
                }

                if(option=='e'){
                    intenationalPassengersList.remove(intenationalPassengerCurrCount);
                    intenationalPassengerCurrCount--;
                    g.global--;
                    return 0;
                }

                else if(option=='y'){
                    return j_detaili();
                }
            }

            System.out.println("\n\t \t \t \t \t \tFlights Found");
            System.out.println("");

            if( (business_src2_desti3_seats.size()!=0) && (economy_src2_desti3_seats.size()!=0) ){
                System.out.println("Airline:\t \tDeparture:\tArrival:\tPrice:\t\tCategory");
                System.out.println("1.Vistara(1)\t10:00\t\t14:05\t\tRs.17800\tEconomy");
                System.out.println("2.Fly Dubai(2)\t14:00\t\t18:05\t\tRs.14900\tEconomy");
                System.out.println("3.Emirates(3)\t18:00\t\t22:05\t\tRs.18700\tEconomy");

                System.out.println("");
                System.out.println("Airline:\t \tDeparture:\tArrival:\tPrice:\t\tCategory");
                System.out.println("4.Vistara(1)\t10:00\t\t14:05\t\tRs.27800\tBusiness");
                System.out.println("5.Fly Dubai(2)\t14:00\t\t18:05\t\tRs.24900\tBusiness");
                System.out.println("6.Emirates(3)\t18:00\t\t22:05\t\tRs.28700\tBusiness");


                //getting the flight option from the user
                System.out.println("\nEnter your Flight choice:");
                choicei=scan.nextInt();

                //validating the choice
                while(choicei<1 || choicei>6){
                    System.out.println("Invalid! The choice can only be 1,2,3,4,5 or 6");
                    System.out.println("Enter again..");
                    choicei=scan.nextInt();
                }

                //condition for selection from Economy class
                if(choicei>=1 && choicei<4){
                    //displaying the Availaable Business class seats
                    System.out.println("\nSeat numbers available for Economy class booking\n");
                    for (int i = 0; i < economy_src2_desti3_seats.size(); i++) {
                        System.out.println("Seat No.: "+economy_src2_desti3_seats.get(i));
                    }

                    //getting the seat number choice from the user
                    System.out.println("\nEnter Seat No.:");
                    intenationalPassengersList.get(intenationalPassengerCurrCount).seat_no=scan.nextInt();

                    //validating the seat number choice
                    boolean found=false;
                    while(found!=true){

                        for (int i = 0; i < economy_src2_desti3_seats.size(); i++) {
                            //finding the seat and removing the seat at the same time in this condition
                            if(intenationalPassengersList.get(intenationalPassengerCurrCount).seat_no==economy_src2_desti3_seats.get(i)){
                                found=true;
                                economy_src2_desti3_seats.remove(i);

                                //after removing sorting the arraylist
                                Collections.sort(economy_src2_desti3_seats);
                            }
                        }

                        if(found==false){
                            System.out.println("Invalid! Please select a seat from the above available seats");
                            intenationalPassengersList.get(intenationalPassengerCurrCount).seat_no=scan.nextInt();
                        }
                    }

                    //The selected seat is being removed from the arraylist successfully
                }

                //condition for selection from the business class
                if(choicei>3 && choicei<7){
                    //displaying the Availaable Business class seats
                    System.out.println("\nSeat numbers available for business class booking\n");
                    for (int i = 0; i < business_src2_desti3_seats.size(); i++) {
                        System.out.println("Seat No.: "+business_src2_desti3_seats.get(i));
                    }

                    //getting the seat number choice from the user
                    System.out.println("\nEnter Seat No.:");
                    intenationalPassengersList.get(intenationalPassengerCurrCount).seat_no=scan.nextInt();

                    //validating the seat number choice
                    boolean found=false;
                    while(found!=true){

                        for (int i = 0; i < business_src2_desti3_seats.size(); i++) {
                            //finding the seat and removing the seat at the same time in this condition
                            if(intenationalPassengersList.get(intenationalPassengerCurrCount).seat_no==business_src2_desti3_seats.get(i)){
                                found=true;
                                business_src2_desti3_seats.remove(i);

                                //after removing sorting the arraylist
                                Collections.sort(business_src2_desti3_seats);
                            }
                        }

                        if(found==false){
                            System.out.println("Invalid! Please select a seat from the above available seats");
                            intenationalPassengersList.get(intenationalPassengerCurrCount).seat_no=scan.nextInt();
                        }
                    }

                    //The selected seat is being removed from the arraylist successfully
                }
            }

            if(economy_src2_desti3_seats.size()!=0 && business_src2_desti3_seats.size()==0) {
                System.out.println("Airline:\t \tDeparture:\tArrival:\tPrice:\t\tCategory");
                System.out.println("1.Vistara(1)\t10:00\t\t14:05\t\tRs.17800\tEconomy");
                System.out.println("2.Fly Dubai(2)\t14:00\t\t18:05\t\tRs.14900\tEconomy");
                System.out.println("3.Emirates(3)\t18:00\t\t22:05\t\tRs.18700\tEconomy");
                System.out.println("");

                //getting the flight option from the user
                System.out.println("\nEnter your Flight choice:");
                choicei=scan.nextInt();

                //validating the choice
                while(choicei<1 || choicei>3){
                    System.out.println("Invalid! The choice can only be 1,2 or 3");
                    System.out.println("Enter again..");
                    choicei=scan.nextInt();
                }

                //displaying the Availaable Business class seats
                System.out.println("\nSeat numbers available for Economy class booking\n");
                for (int i = 0; i < economy_src2_desti3_seats.size(); i++) {
                    System.out.println("Seat No.: "+economy_src2_desti3_seats.get(i));
                }

                //getting the seat number choice from the user
                System.out.println("\nEnter Seat No.:");
                intenationalPassengersList.get(intenationalPassengerCurrCount).seat_no=scan.nextInt();

                //validating the seat number choice
                boolean found=false;
                while(found!=true){

                    for (int i = 0; i < economy_src2_desti3_seats.size(); i++) {
                        //finding the seat and removing the seat at the same time in this condition
                        if(intenationalPassengersList.get(intenationalPassengerCurrCount).seat_no==economy_src2_desti3_seats.get(i)){
                            found=true;
                            economy_src2_desti3_seats.remove(i);

                            //after removing sorting the arraylist
                            Collections.sort(economy_src2_desti3_seats);
                        }
                    }

                    if(found==false){
                        System.out.println("Invalid! Please select a seat from the above available seats");
                        intenationalPassengersList.get(intenationalPassengerCurrCount).seat_no=scan.nextInt();
                    }
                }

                //The selected seat is being removed from the arraylist successfully
            }

            if(business_src2_desti3_seats.size()!=0 && economy_src2_desti3_seats.size()==0) {
                System.out.println("Airline:\t \tDeparture:\tArrival:\tPrice:\t\tCategory");
                System.out.println("4.Vistara(1)\t10:00\t\t14:05\t\tRs.27800\tBusiness");
                System.out.println("5.Fly Dubai(2)\t14:00\t\t18:05\t\tRs.24900\tBusiness");
                System.out.println("6.Emirates(3)\t18:00\t\t22:05\t\tRs.28700\tBusiness");
                System.out.println("");

                //getting the flight option from the user
                System.out.println("\nEnter your Flight choice:");
                choicei=scan.nextInt();

                //validating the choice
                while(choicei<4 || choicei>6){
                    System.out.println("Invalid! The choice can only be 4,5 or 6");
                    System.out.println("Enter again..");
                    choicei=scan.nextInt();
                }

                //displaying the Availaable Business class seats
                System.out.println("\nSeat numbers available for business class booking\n");
                for (int i = 0; i < business_src2_desti3_seats.size(); i++) {
                    System.out.println("Seat No.: "+business_src2_desti3_seats.get(i));
                }

                //getting the seat number choice from the user
                System.out.println("\nEnter Seat No.:");
                intenationalPassengersList.get(intenationalPassengerCurrCount).seat_no=scan.nextInt();

                //validating the seat number choice
                boolean found=false;
                while(found!=true){

                    for (int i = 0; i < business_src2_desti3_seats.size(); i++) {
                        //finding the seat and removing the seat at the same time in this condition
                        if(intenationalPassengersList.get(intenationalPassengerCurrCount).seat_no==business_src2_desti3_seats.get(i)){
                            found=true;
                            business_src2_desti3_seats.remove(i);

                            //after removing sorting the arraylist
                            Collections.sort(business_src2_desti3_seats);
                        }
                    }

                    if(found==false){
                        System.out.println("Invalid! Please select a seat from the above available seats");
                        intenationalPassengersList.get(intenationalPassengerCurrCount).seat_no=scan.nextInt();
                    }
                }

                //The selected seat is being removed from the arraylist successfully
            }

            //setting the src and dest variables of the passenger class because it will later help in
            //identifying in which arraylist to add the cancelled seat (seat cancelled by the passenger)
            intenationalPassengersList.get(intenationalPassengerCurrCount).src=2;
            intenationalPassengersList.get(intenationalPassengerCurrCount).dest=3;
            intenationalPassengersList.get(intenationalPassengerCurrCount).source="Dubai";
            intenationalPassengersList.get(intenationalPassengerCurrCount).destination="Abu Dhabi";


        }

        else if((srci==2 && desti==4) )//condition
        {
            //original code
            /*System.out.println("Airline:\t \tDeparture:\tArrival:\tPrice:\t\tCategory");
            System.out.println("1.Vistara(1)\t10:00\t\t14:05\t\tRs.32000\tEconomy");
            System.out.println("2.Fly Dubai(2)\t14:00\t\t18:05\t\tRs.38500\tEconomy");
            System.out.println("3.Emirates(3)\t18:00\t\t22:05\t\tRs41259\tEconomy");

            System.out.println("");
            System.out.println("Airline:\t \tDeparture:\tArrival:\tPrice:\t\tCategory");
            System.out.println("4.Vistara(1)\t10:00\t\t14:05\t\tRs.42000\tBusiness");
            System.out.println("5.Fly Dubai(2)\t14:00\t\t18:05\t\tRs48500\tBusiness");
            System.out.println("6.Emirates(3)\t18:00\t\t22:05\t\tRs51259\tBusiness");
             */
            /////////////////////////////////////////////////////////////////////////

            //checking the availability of the seats in the economy and business class
            if(economy_src2_desti4_seats.size()==0 && business_src2_desti4_seats.size()==0){

                char option;
                System.out.println("\nNo seats available in the business and economy class");
                System.out.println("Do you wish to make another Reservation (y/n):");
                option= scan.next().charAt(0);

                while ( (option!='y') && (option!='n') ){
                    System.out.println("Invalid! Please enter y (for yes) or n (for no)");
                    System.out.println("Enter again..");
                    option= scan.next().charAt(0);
                }

                if(option=='n'){
                    intenationalPassengersList.remove(intenationalPassengerCurrCount);
                    intenationalPassengerCurrCount--;
                    g.global--;
                    return 0;
                }

                else if(option=='y'){
                    return j_detaili();
                }

            }

            //Printing the process if these are no seats available in the economy class
            if(economy_src2_desti4_seats.size()==0){
                System.out.println("\nNo seats are available in the Economy class. Only Business class seats are avaiable");
                System.out.println("Do you wish to make another Reservation (y/n/e)");
                System.out.println("Enter 'y' to make another Reservation. Enter 'n' to continue with the business class booking");
                System.out.println("Enter e for exit");
                char option= scan.next().charAt(0);

                while ( (option!='y') && (option!='n' && (option!='e')) ){
                    System.out.println("Invalid! Please enter y (for yes) or n (for no) or e (for exit)");
                    System.out.println("Enter again..");
                    option= scan.next().charAt(0);
                }

                if(option=='e'){
                    intenationalPassengersList.remove(intenationalPassengerCurrCount);
                    intenationalPassengerCurrCount--;
                    g.global--;
                    return 0;
                }

                else if(option=='y'){
                    return j_detaili();
                }
            }

            //Printing the process if these are no seats available in the business class
            if(business_src2_desti4_seats.size()==0){
                System.out.println("\nNo seats are available in the Business class. Only Economy class seats are avaiable");
                System.out.println("Do you wish to make another Reservation (y/n/e)");
                System.out.println("Enter 'y' to make another Reservation. Enter 'n' to continue with the Economy class booking");
                System.out.println("Enter e to exit");
                char option= scan.next().charAt(0);

                while ( (option!='y') && (option!='n') && (option!='e') ){
                    System.out.println("Invalid! Please enter y (for yes) or n (for no) or e (for exit)");
                    System.out.println("Enter again..");
                    option= scan.next().charAt(0);
                }

                if(option=='e'){
                    intenationalPassengersList.remove(intenationalPassengerCurrCount);
                    intenationalPassengerCurrCount--;
                    g.global--;
                    return 0;
                }

                else if(option=='y'){
                    return j_detaili();
                }
            }

            System.out.println("\n\t \t \t \t \t \tFlights Found");
            System.out.println("");

            if( (business_src2_desti4_seats.size()!=0) && (economy_src2_desti4_seats.size()!=0) ){
                System.out.println("Airline:\t \tDeparture:\tArrival:\tPrice:\t\tCategory");
                System.out.println("1.Vistara(1)\t10:00\t\t14:05\t\tRs.32000\tEconomy");
                System.out.println("2.Fly Dubai(2)\t14:00\t\t18:05\t\tRs.38500\tEconomy");
                System.out.println("3.Emirates(3)\t18:00\t\t22:05\t\tRs41259\t\tEconomy");

                System.out.println("");
                System.out.println("Airline:\t \tDeparture:\tArrival:\tPrice:\t\tCategory");
                System.out.println("4.Vistara(1)\t10:00\t\t14:05\t\tRs.42000\tBusiness");
                System.out.println("5.Fly Dubai(2)\t14:00\t\t18:05\t\tRs48500\t\tBusiness");
                System.out.println("6.Emirates(3)\t18:00\t\t22:05\t\tRs51259\t\tBusiness");


                //getting the flight option from the user
                System.out.println("\nEnter your Flight choice:");
                choicei=scan.nextInt();

                //validating the choice
                while(choicei<1 || choicei>6){
                    System.out.println("Invalid! The choice can only be 1,2,3,4,5 or 6");
                    System.out.println("Enter again..");
                    choicei=scan.nextInt();
                }

                //condition for selection from Economy class
                if(choicei>=1 && choicei<4){
                    //displaying the Availaable Business class seats
                    System.out.println("\nSeat numbers available for Economy class booking\n");
                    for (int i = 0; i < economy_src2_desti4_seats.size(); i++) {
                        System.out.println("Seat No.: "+economy_src2_desti4_seats.get(i));
                    }

                    //getting the seat number choice from the user
                    System.out.println("\nEnter Seat No.:");
                    intenationalPassengersList.get(intenationalPassengerCurrCount).seat_no=scan.nextInt();

                    //validating the seat number choice
                    boolean found=false;
                    while(found!=true){

                        for (int i = 0; i < economy_src2_desti4_seats.size(); i++) {
                            //finding the seat and removing the seat at the same time in this condition
                            if(intenationalPassengersList.get(intenationalPassengerCurrCount).seat_no==economy_src2_desti4_seats.get(i)){
                                found=true;
                                economy_src2_desti4_seats.remove(i);

                                //after removing sorting the arraylist
                                Collections.sort(economy_src2_desti4_seats);
                            }
                        }

                        if(found==false){
                            System.out.println("Invalid! Please select a seat from the above available seats");
                            intenationalPassengersList.get(intenationalPassengerCurrCount).seat_no=scan.nextInt();
                        }
                    }

                    //The selected seat is being removed from the arraylist successfully
                }

                //condition for selection from the business class
                if(choicei>3 && choicei<7){
                    //displaying the Availaable Business class seats
                    System.out.println("\nSeat numbers available for business class booking\n");
                    for (int i = 0; i < business_src2_desti4_seats.size(); i++) {
                        System.out.println("Seat No.: "+business_src2_desti4_seats.get(i));
                    }

                    //getting the seat number choice from the user
                    System.out.println("\nEnter Seat No.:");
                    intenationalPassengersList.get(intenationalPassengerCurrCount).seat_no=scan.nextInt();

                    //validating the seat number choice
                    boolean found=false;
                    while(found!=true){

                        for (int i = 0; i < business_src2_desti4_seats.size(); i++) {
                            //finding the seat and removing the seat at the same time in this condition
                            if(intenationalPassengersList.get(intenationalPassengerCurrCount).seat_no==business_src2_desti4_seats.get(i)){
                                found=true;
                                business_src2_desti4_seats.remove(i);

                                //after removing sorting the arraylist
                                Collections.sort(business_src2_desti4_seats);
                            }
                        }

                        if(found==false){
                            System.out.println("Invalid! Please select a seat from the above available seats");
                            intenationalPassengersList.get(intenationalPassengerCurrCount).seat_no=scan.nextInt();
                        }
                    }

                    //The selected seat is being removed from the arraylist successfully
                }
            }

            if(economy_src2_desti4_seats.size()!=0 && business_src2_desti4_seats.size()==0) {
                System.out.println("Airline:\t \tDeparture:\tArrival:\tPrice:\t\tCategory");
                System.out.println("1.Vistara(1)\t10:00\t\t14:05\t\tRs.32000\tEconomy");
                System.out.println("2.Fly Dubai(2)\t14:00\t\t18:05\t\tRs.38500\tEconomy");
                System.out.println("3.Emirates(3)\t18:00\t\t22:05\t\tRs41259\t\tEconomy");

                System.out.println("");

                //getting the flight option from the user
                System.out.println("\nEnter your Flight choice:");
                choicei=scan.nextInt();

                //validating the choice
                while(choicei<1 || choicei>3){
                    System.out.println("Invalid! The choice can only be 1,2 or 3");
                    System.out.println("Enter again..");
                    choicei=scan.nextInt();
                }

                //displaying the Availaable Business class seats
                System.out.println("\nSeat numbers available for Economy class booking\n");
                for (int i = 0; i < economy_src2_desti4_seats.size(); i++) {
                    System.out.println("Seat No.: "+economy_src2_desti4_seats.get(i));
                }

                //getting the seat number choice from the user
                System.out.println("\nEnter Seat No.:");
                intenationalPassengersList.get(intenationalPassengerCurrCount).seat_no=scan.nextInt();

                //validating the seat number choice
                boolean found=false;
                while(found!=true){

                    for (int i = 0; i < economy_src2_desti4_seats.size(); i++) {
                        //finding the seat and removing the seat at the same time in this condition
                        if(intenationalPassengersList.get(intenationalPassengerCurrCount).seat_no==economy_src2_desti4_seats.get(i)){
                            found=true;
                            economy_src2_desti4_seats.remove(i);

                            //after removing sorting the arraylist
                            Collections.sort(economy_src2_desti4_seats);
                        }
                    }

                    if(found==false){
                        System.out.println("Invalid! Please select a seat from the above available seats");
                        intenationalPassengersList.get(intenationalPassengerCurrCount).seat_no=scan.nextInt();
                    }
                }

                //The selected seat is being removed from the arraylist successfully
            }

            if(business_src2_desti4_seats.size()!=0 && economy_src2_desti4_seats.size()==0) {
                System.out.println("Airline:\t \tDeparture:\tArrival:\tPrice:\t\tCategory");
                System.out.println("4.Vistara(1)\t10:00\t\t14:05\t\tRs.42000\tBusiness");
                System.out.println("5.Fly Dubai(2)\t14:00\t\t18:05\t\tRs48500\t\tBusiness");
                System.out.println("6.Emirates(3)\t18:00\t\t22:05\t\tRs51259\t\tBusiness");
                System.out.println("");

                //getting the flight option from the user
                System.out.println("\nEnter your Flight choice:");
                choicei=scan.nextInt();

                //validating the choice
                while(choicei<4 || choicei>6){
                    System.out.println("Invalid! The choice can only be 4,5 or 6");
                    System.out.println("Enter again..");
                    choicei=scan.nextInt();
                }

                //displaying the Availaable Business class seats
                System.out.println("\nSeat numbers available for business class booking\n");
                for (int i = 0; i < business_src2_desti4_seats.size(); i++) {
                    System.out.println("Seat No.: "+business_src2_desti4_seats.get(i));
                }

                //getting the seat number choice from the user
                System.out.println("\nEnter Seat No.:");
                intenationalPassengersList.get(intenationalPassengerCurrCount).seat_no=scan.nextInt();

                //validating the seat number choice
                boolean found=false;
                while(found!=true){

                    for (int i = 0; i < business_src2_desti4_seats.size(); i++) {
                        //finding the seat and removing the seat at the same time in this condition
                        if(intenationalPassengersList.get(intenationalPassengerCurrCount).seat_no==business_src2_desti4_seats.get(i)){
                            found=true;
                            business_src2_desti4_seats.remove(i);

                            //after removing sorting the arraylist
                            Collections.sort(business_src2_desti4_seats);
                        }
                    }

                    if(found==false){
                        System.out.println("Invalid! Please select a seat from the above available seats");
                        intenationalPassengersList.get(intenationalPassengerCurrCount).seat_no=scan.nextInt();
                    }
                }

                //The selected seat is being removed from the arraylist successfully
            }

            //setting the src and dest variables of the passenger class because it will later help in
            //identifying in which arraylist to add the cancelled seat (seat cancelled by the passenger)
            intenationalPassengersList.get(intenationalPassengerCurrCount).src=2;
            intenationalPassengersList.get(intenationalPassengerCurrCount).dest=4;
            intenationalPassengersList.get(intenationalPassengerCurrCount).source="Dubai";
            intenationalPassengersList.get(intenationalPassengerCurrCount).destination="Singapore";


        }

        else if(srci==2 && desti==5 )//condition
        {
            //original code
            /*System.out.println("Airline:\t \tDeparture:\tArrival:\tPrice:\t\tCategory");
            System.out.println("1.Vistara(1)\t10:00\t\t14:05\t\tRs.82500\tEconomy");
            System.out.println("2.Fly Dubai(2)\t14:00\t\t18:05\t\tRs.87550\tEconomy");
            System.out.println("3.Emirates(3)\t18:00\t\t22:05\t\tRs81478\tEconomy");

            System.out.println("");
            System.out.println("Airline:\t \tDeparture:\tArrival:\tPrice:\t\tCategory");
            System.out.println("4.Vistara(1)\t10:00\t\t14:05\t\tRs.92500\tBusiness");
            System.out.println("5.Fly Dubai(2)\t14:00\t\t18:05\t\tRs.97550\tBusiness");
            System.out.println("6.Emirates(3)\t18:00\t\t22:05\t\tRs91478\tBusiness");
            */
            ///////////////////////////////////////////////////////////////////////////

            //checking the availability of the seats in the economy and business class
            if(economy_src2_desti5_seats.size()==0 && business_src2_desti5_seats.size()==0){

                char option;
                System.out.println("\nNo seats available in the business and economy class");
                System.out.println("Do you wish to make another Reservation (y/n):");
                option= scan.next().charAt(0);

                while ( (option!='y') && (option!='n') ){
                    System.out.println("Invalid! Please enter y (for yes) or n (for no)");
                    System.out.println("Enter again..");
                    option= scan.next().charAt(0);
                }

                if(option=='n'){
                    intenationalPassengersList.remove(intenationalPassengerCurrCount);
                    intenationalPassengerCurrCount--;
                    g.global--;
                    return 0;
                }

                else if(option=='y'){
                    return j_detaili();
                }

            }

            //Printing the process if these are no seats available in the economy class
            if(economy_src2_desti5_seats.size()==0){
                System.out.println("\nNo seats are available in the Economy class. Only Business class seats are avaiable");
                System.out.println("Do you wish to make another Reservation (y/n/e)");
                System.out.println("Enter 'y' to make another Reservation. Enter 'n' to continue with the business class booking");
                System.out.println("Enter e for exit");
                char option= scan.next().charAt(0);

                while ( (option!='y') && (option!='n' && (option!='e')) ){
                    System.out.println("Invalid! Please enter y (for yes) or n (for no) or e (for exit)");
                    System.out.println("Enter again..");
                    option= scan.next().charAt(0);
                }

                if(option=='e'){
                    intenationalPassengersList.remove(intenationalPassengerCurrCount);
                    intenationalPassengerCurrCount--;
                    g.global--;
                    return 0;
                }

                else if(option=='y'){
                    return j_detaili();
                }
            }

            //Printing the process if these are no seats available in the business class
            if(business_src2_desti5_seats.size()==0){
                System.out.println("\nNo seats are available in the Business class. Only Economy class seats are avaiable");
                System.out.println("Do you wish to make another Reservation (y/n/e)");
                System.out.println("Enter 'y' to make another Reservation. Enter 'n' to continue with the Economy class booking");
                System.out.println("Enter e to exit");
                char option= scan.next().charAt(0);

                while ( (option!='y') && (option!='n') && (option!='e') ){
                    System.out.println("Invalid! Please enter y (for yes) or n (for no) or e (for exit)");
                    System.out.println("Enter again..");
                    option= scan.next().charAt(0);
                }

                if(option=='e'){
                    intenationalPassengersList.remove(intenationalPassengerCurrCount);
                    intenationalPassengerCurrCount--;
                    g.global--;
                    return 0;
                }

                else if(option=='y'){
                    return j_detaili();
                }
            }

            System.out.println("\n\t \t \t \t \t \tFlights Found");
            System.out.println("");

            if( (business_src2_desti5_seats.size()!=0) && (economy_src2_desti5_seats.size()!=0) ){
                System.out.println("Airline:\t \tDeparture:\tArrival:\tPrice:\t\tCategory");
                System.out.println("1.Vistara(1)\t10:00\t\t14:05\t\tRs.82500\tEconomy");
                System.out.println("2.Fly Dubai(2)\t14:00\t\t18:05\t\tRs.87550\tEconomy");
                System.out.println("3.Emirates(3)\t18:00\t\t22:05\t\tRs81478\t\tEconomy");

                System.out.println("");
                System.out.println("Airline:\t \tDeparture:\tArrival:\tPrice:\t\tCategory");
                System.out.println("4.Vistara(1)\t10:00\t\t14:05\t\tRs.92500\tBusiness");
                System.out.println("5.Fly Dubai(2)\t14:00\t\t18:05\t\tRs.97550\tBusiness");
                System.out.println("6.Emirates(3)\t18:00\t\t22:05\t\tRs91478\t\tBusiness");


                //getting the flight option from the user
                System.out.println("\nEnter your Flight choice:");
                choicei=scan.nextInt();

                //validating the choice
                while(choicei<1 || choicei>6){
                    System.out.println("Invalid! The choice can only be 1,2,3,4,5 or 6");
                    System.out.println("Enter again..");
                    choicei=scan.nextInt();
                }

                //condition for selection from Economy class
                if(choicei>=1 && choicei<4){
                    //displaying the Availaable Business class seats
                    System.out.println("\nSeat numbers available for Economy class booking\n");
                    for (int i = 0; i < economy_src2_desti5_seats.size(); i++) {
                        System.out.println("Seat No.: "+economy_src2_desti5_seats.get(i));
                    }

                    //getting the seat number choice from the user
                    System.out.println("\nEnter Seat No.:");
                    intenationalPassengersList.get(intenationalPassengerCurrCount).seat_no=scan.nextInt();

                    //validating the seat number choice
                    boolean found=false;
                    while(found!=true){

                        for (int i = 0; i < economy_src2_desti5_seats.size(); i++) {
                            //finding the seat and removing the seat at the same time in this condition
                            if(intenationalPassengersList.get(intenationalPassengerCurrCount).seat_no==economy_src2_desti5_seats.get(i)){
                                found=true;
                                economy_src2_desti5_seats.remove(i);

                                //after removing sorting the arraylist
                                Collections.sort(economy_src2_desti5_seats);
                            }
                        }

                        if(found==false){
                            System.out.println("Invalid! Please select a seat from the above available seats");
                            intenationalPassengersList.get(intenationalPassengerCurrCount).seat_no=scan.nextInt();
                        }
                    }

                    //The selected seat is being removed from the arraylist successfully
                }

                //condition for selection from the business class
                if(choicei>3 && choicei<7){
                    //displaying the Availaable Business class seats
                    System.out.println("\nSeat numbers available for business class booking\n");
                    for (int i = 0; i < business_src2_desti5_seats.size(); i++) {
                        System.out.println("Seat No.: "+business_src2_desti5_seats.get(i));
                    }

                    //getting the seat number choice from the user
                    System.out.println("\nEnter Seat No.:");
                    intenationalPassengersList.get(intenationalPassengerCurrCount).seat_no=scan.nextInt();

                    //validating the seat number choice
                    boolean found=false;
                    while(found!=true){

                        for (int i = 0; i < business_src2_desti5_seats.size(); i++) {
                            //finding the seat and removing the seat at the same time in this condition
                            if(intenationalPassengersList.get(intenationalPassengerCurrCount).seat_no==business_src2_desti5_seats.get(i)){
                                found=true;
                                business_src2_desti5_seats.remove(i);

                                //after removing sorting the arraylist
                                Collections.sort(business_src2_desti5_seats);
                            }
                        }

                        if(found==false){
                            System.out.println("Invalid! Please select a seat from the above available seats");
                            intenationalPassengersList.get(intenationalPassengerCurrCount).seat_no=scan.nextInt();
                        }
                    }

                    //The selected seat is being removed from the arraylist successfully
                }
            }

            if(economy_src2_desti5_seats.size()!=0 && business_src2_desti5_seats.size()==0) {
                System.out.println("Airline:\t \tDeparture:\tArrival:\tPrice:\t\tCategory");
                System.out.println("1.Vistara(1)\t10:00\t\t14:05\t\tRs.82500\tEconomy");
                System.out.println("2.Fly Dubai(2)\t14:00\t\t18:05\t\tRs.87550\tEconomy");
                System.out.println("3.Emirates(3)\t18:00\t\t22:05\t\tRs81478\t\tEconomy");

                System.out.println("");

                //getting the flight option from the user
                System.out.println("\nEnter your Flight choice:");
                choicei=scan.nextInt();

                //validating the choice
                while(choicei<1 || choicei>3){
                    System.out.println("Invalid! The choice can only be 1,2 or 3");
                    System.out.println("Enter again..");
                    choicei=scan.nextInt();
                }

                //displaying the Availaable Business class seats
                System.out.println("\nSeat numbers available for Economy class booking\n");
                for (int i = 0; i < economy_src2_desti5_seats.size(); i++) {
                    System.out.println("Seat No.: "+economy_src2_desti5_seats.get(i));
                }

                //getting the seat number choice from the user
                System.out.println("\nEnter Seat No.:");
                intenationalPassengersList.get(intenationalPassengerCurrCount).seat_no=scan.nextInt();

                //validating the seat number choice
                boolean found=false;
                while(found!=true){

                    for (int i = 0; i < economy_src2_desti5_seats.size(); i++) {
                        //finding the seat and removing the seat at the same time in this condition
                        if(intenationalPassengersList.get(intenationalPassengerCurrCount).seat_no==economy_src2_desti5_seats.get(i)){
                            found=true;
                            economy_src2_desti5_seats.remove(i);

                            //after removing sorting the arraylist
                            Collections.sort(economy_src2_desti5_seats);
                        }
                    }

                    if(found==false){
                        System.out.println("Invalid! Please select a seat from the above available seats");
                        intenationalPassengersList.get(intenationalPassengerCurrCount).seat_no=scan.nextInt();
                    }
                }

                //The selected seat is being removed from the arraylist successfully
            }

            if(business_src2_desti5_seats.size()!=0 && economy_src2_desti5_seats.size()==0) {
                System.out.println("Airline:\t \tDeparture:\tArrival:\tPrice:\t\tCategory");
                System.out.println("4.Vistara(1)\t10:00\t\t14:05\t\tRs.92500\tBusiness");
                System.out.println("5.Fly Dubai(2)\t14:00\t\t18:05\t\tRs.97550\tBusiness");
                System.out.println("6.Emirates(3)\t18:00\t\t22:05\t\tRs91478\t\tBusiness");
                System.out.println("");

                //getting the flight option from the user
                System.out.println("\nEnter your Flight choice:");
                choicei=scan.nextInt();

                //validating the choice
                while(choicei<4 || choicei>6){
                    System.out.println("Invalid! The choice can only be 4,5 or 6");
                    System.out.println("Enter again..");
                    choicei=scan.nextInt();
                }

                //displaying the Availaable Business class seats
                System.out.println("\nSeat numbers available for business class booking\n");
                for (int i = 0; i < business_src2_desti5_seats.size(); i++) {
                    System.out.println("Seat No.: "+business_src2_desti5_seats.get(i));
                }

                //getting the seat number choice from the user
                System.out.println("\nEnter Seat No.:");
                intenationalPassengersList.get(intenationalPassengerCurrCount).seat_no=scan.nextInt();

                //validating the seat number choice
                boolean found=false;
                while(found!=true){

                    for (int i = 0; i < business_src2_desti5_seats.size(); i++) {
                        //finding the seat and removing the seat at the same time in this condition
                        if(intenationalPassengersList.get(intenationalPassengerCurrCount).seat_no==business_src2_desti5_seats.get(i)){
                            found=true;
                            business_src2_desti5_seats.remove(i);

                            //after removing sorting the arraylist
                            Collections.sort(business_src2_desti5_seats);
                        }
                    }

                    if(found==false){
                        System.out.println("Invalid! Please select a seat from the above available seats");
                        intenationalPassengersList.get(intenationalPassengerCurrCount).seat_no=scan.nextInt();
                    }
                }

                //The selected seat is being removed from the arraylist successfully
            }

            //setting the src and dest variables of the passenger class because it will later help in
            //identifying in which arraylist to add the cancelled seat (seat cancelled by the passenger)
            intenationalPassengersList.get(intenationalPassengerCurrCount).src=2;
            intenationalPassengersList.get(intenationalPassengerCurrCount).dest=5;
            intenationalPassengersList.get(intenationalPassengerCurrCount).source="Dubai";
            intenationalPassengersList.get(intenationalPassengerCurrCount).destination="New York";


        }

        else if((srci==3 && desti==1) )//condition
        {
            //original code
            /*System.out.println("Airline:\t \tDeparture:\tArrival:\tPrice:\t\tCategory");
            System.out.println("\1.Vistara(1)\t10:00\t\t14:05\t\tRs.25000\tEcononmy");
            System.out.println("\2.Fly Dubai(2)\t14:00\t\t18:05\t\tRs.21500\tEcononmy");
            System.out.println("\3.Emirates(3)\t18:00\t\t22:05\t\tRs.24000\tEcononmy");

            System.out.println("");
            System.out.println("Airline:\t \tDeparture:\tArrival:\tPrice:\t\tCategory");
            System.out.println("\1.Vistara(1)\t10:00\t\t14:05\t\tRs.35000\tBusiness");
            System.out.println("\2.Fly Dubai(2)\t14:00\t\t18:05\t\tRs.31500\tBusiness");
            System.out.println("\3.Emirates(3)\t18:00\t\t22:05\t\tRs.34000\tBusiness");
            */
            /////////////////////////////////////////////////////////////////////////////

            //checking the availability of the seats in the economy and business class
            if(economy_src3_desti1_seats.size()==0 && business_src3_desti1_seats.size()==0){

                char option;
                System.out.println("\nNo seats available in the business and economy class");
                System.out.println("Do you wish to make another Reservation (y/n):");
                option= scan.next().charAt(0);

                while ( (option!='y') && (option!='n') ){
                    System.out.println("Invalid! Please enter y (for yes) or n (for no)");
                    System.out.println("Enter again..");
                    option= scan.next().charAt(0);
                }

                if(option=='n'){
                    intenationalPassengersList.remove(intenationalPassengerCurrCount);
                    intenationalPassengerCurrCount--;
                    g.global--;
                    return 0;
                }

                else if(option=='y'){
                    return j_detaili();
                }

            }

            //Printing the process if these are no seats available in the economy class
            if(economy_src3_desti1_seats.size()==0){
                System.out.println("\nNo seats are available in the Economy class. Only Business class seats are avaiable");
                System.out.println("Do you wish to make another Reservation (y/n/e)");
                System.out.println("Enter 'y' to make another Reservation. Enter 'n' to continue with the business class booking");
                System.out.println("Enter e for exit");
                char option= scan.next().charAt(0);

                while ( (option!='y') && (option!='n' && (option!='e')) ){
                    System.out.println("Invalid! Please enter y (for yes) or n (for no) or e (for exit)");
                    System.out.println("Enter again..");
                    option= scan.next().charAt(0);
                }

                if(option=='e'){
                    intenationalPassengersList.remove(intenationalPassengerCurrCount);
                    intenationalPassengerCurrCount--;
                    g.global--;
                    return 0;
                }

                else if(option=='y'){
                    return j_detaili();
                }
            }

            //Printing the process if these are no seats available in the business class
            if(business_src3_desti1_seats.size()==0){
                System.out.println("\nNo seats are available in the Business class. Only Economy class seats are avaiable");
                System.out.println("Do you wish to make another Reservation (y/n/e)");
                System.out.println("Enter 'y' to make another Reservation. Enter 'n' to continue with the Economy class booking");
                System.out.println("Enter e to exit");
                char option= scan.next().charAt(0);

                while ( (option!='y') && (option!='n') && (option!='e') ){
                    System.out.println("Invalid! Please enter y (for yes) or n (for no) or e (for exit)");
                    System.out.println("Enter again..");
                    option= scan.next().charAt(0);
                }

                if(option=='e'){
                    intenationalPassengersList.remove(intenationalPassengerCurrCount);
                    intenationalPassengerCurrCount--;
                    g.global--;
                    return 0;
                }

                else if(option=='y'){
                    return j_detaili();
                }
            }

            System.out.println("\n\t \t \t \t \t \tFlights Found");
            System.out.println("");

            if( (business_src3_desti1_seats.size()!=0) && (economy_src3_desti1_seats.size()!=0) ){
                System.out.println("Airline:\t \tDeparture:\tArrival:\tPrice:\t\tCategory");
                System.out.println("1.Vistara(1)\t10:00\t\t14:05\t\tRs.25000\tEcononmy");
                System.out.println("2.Fly Dubai(2)\t14:00\t\t18:05\t\tRs.21500\tEcononmy");
                System.out.println("3.Emirates(3)\t18:00\t\t22:05\t\tRs.24000\tEcononmy");

                System.out.println("");
                System.out.println("Airline:\t \tDeparture:\tArrival:\tPrice:\t\tCategory");
                System.out.println("4.Vistara(1)\t10:00\t\t14:05\t\tRs.35000\tBusiness");
                System.out.println("5.Fly Dubai(2)\t14:00\t\t18:05\t\tRs.31500\tBusiness");
                System.out.println("6.Emirates(3)\t18:00\t\t22:05\t\tRs.34000\tBusiness");


                //getting the flight option from the user
                System.out.println("\nEnter your Flight choice:");
                choicei=scan.nextInt();

                //validating the choice
                while(choicei<1 || choicei>6){
                    System.out.println("Invalid! The choice can only be 1,2,3,4,5 or 6");
                    System.out.println("Enter again..");
                    choicei=scan.nextInt();
                }

                //condition for selection from Economy class
                if(choicei>=1 && choicei<4){
                    //displaying the Availaable Business class seats
                    System.out.println("\nSeat numbers available for Economy class booking\n");
                    for (int i = 0; i < economy_src3_desti1_seats.size(); i++) {
                        System.out.println("Seat No.: "+economy_src3_desti1_seats.get(i));
                    }

                    //getting the seat number choice from the user
                    System.out.println("\nEnter Seat No.:");
                    intenationalPassengersList.get(intenationalPassengerCurrCount).seat_no=scan.nextInt();

                    //validating the seat number choice
                    boolean found=false;
                    while(found!=true){

                        for (int i = 0; i < economy_src3_desti1_seats.size(); i++) {
                            //finding the seat and removing the seat at the same time in this condition
                            if(intenationalPassengersList.get(intenationalPassengerCurrCount).seat_no==economy_src3_desti1_seats.get(i)){
                                found=true;
                                economy_src3_desti1_seats.remove(i);

                                //after removing sorting the arraylist
                                Collections.sort(economy_src3_desti1_seats);
                            }
                        }

                        if(found==false){
                            System.out.println("Invalid! Please select a seat from the above available seats");
                            intenationalPassengersList.get(intenationalPassengerCurrCount).seat_no=scan.nextInt();
                        }
                    }

                    //The selected seat is being removed from the arraylist successfully
                }

                //condition for selection from the business class
                if(choicei>3 && choicei<7){
                    //displaying the Availaable Business class seats
                    System.out.println("\nSeat numbers available for business class booking\n");
                    for (int i = 0; i < business_src3_desti1_seats.size(); i++) {
                        System.out.println("Seat No.: "+business_src3_desti1_seats.get(i));
                    }

                    //getting the seat number choice from the user
                    System.out.println("\nEnter Seat No.:");
                    intenationalPassengersList.get(intenationalPassengerCurrCount).seat_no=scan.nextInt();

                    //validating the seat number choice
                    boolean found=false;
                    while(found!=true){

                        for (int i = 0; i < business_src3_desti1_seats.size(); i++) {
                            //finding the seat and removing the seat at the same time in this condition
                            if(intenationalPassengersList.get(intenationalPassengerCurrCount).seat_no==business_src3_desti1_seats.get(i)){
                                found=true;
                                business_src3_desti1_seats.remove(i);

                                //after removing sorting the arraylist
                                Collections.sort(business_src3_desti1_seats);
                            }
                        }

                        if(found==false){
                            System.out.println("Invalid! Please select a seat from the above available seats");
                            intenationalPassengersList.get(intenationalPassengerCurrCount).seat_no=scan.nextInt();
                        }
                    }

                    //The selected seat is being removed from the arraylist successfully
                }
            }

            if(economy_src3_desti1_seats.size()!=0 && business_src3_desti1_seats.size()==0) {
                System.out.println("Airline:\t \tDeparture:\tArrival:\tPrice:\t\tCategory");
                System.out.println("1.Vistara(1)\t10:00\t\t14:05\t\tRs.25000\tEcononmy");
                System.out.println("2.Fly Dubai(2)\t14:00\t\t18:05\t\tRs.21500\tEcononmy");
                System.out.println("3.Emirates(3)\t18:00\t\t22:05\t\tRs.24000\tEcononmy");
                System.out.println("");

                //getting the flight option from the user
                System.out.println("\nEnter your Flight choice:");
                choicei=scan.nextInt();

                //validating the choice
                while(choicei<1 || choicei>3){
                    System.out.println("Invalid! The choice can only be 1,2 or 3");
                    System.out.println("Enter again..");
                    choicei=scan.nextInt();
                }

                //displaying the Availaable Business class seats
                System.out.println("\nSeat numbers available for Economy class booking\n");
                for (int i = 0; i < economy_src3_desti1_seats.size(); i++) {
                    System.out.println("Seat No.: "+economy_src3_desti1_seats.get(i));
                }

                //getting the seat number choice from the user
                System.out.println("\nEnter Seat No.:");
                intenationalPassengersList.get(intenationalPassengerCurrCount).seat_no=scan.nextInt();

                //validating the seat number choice
                boolean found=false;
                while(found!=true){

                    for (int i = 0; i < economy_src3_desti1_seats.size(); i++) {
                        //finding the seat and removing the seat at the same time in this condition
                        if(intenationalPassengersList.get(intenationalPassengerCurrCount).seat_no==economy_src3_desti1_seats.get(i)){
                            found=true;
                            economy_src3_desti1_seats.remove(i);

                            //after removing sorting the arraylist
                            Collections.sort(economy_src3_desti1_seats);
                        }
                    }

                    if(found==false){
                        System.out.println("Invalid! Please select a seat from the above available seats");
                        intenationalPassengersList.get(intenationalPassengerCurrCount).seat_no=scan.nextInt();
                    }
                }

                //The selected seat is being removed from the arraylist successfully
            }

            if(business_src3_desti1_seats.size()!=0 && economy_src3_desti1_seats.size()==0) {
                System.out.println("Airline:\t \tDeparture:\tArrival:\tPrice:\t\tCategory");
                System.out.println("4.Vistara(1)\t10:00\t\t14:05\t\tRs.35000\tBusiness");
                System.out.println("5.Fly Dubai(2)\t14:00\t\t18:05\t\tRs.31500\tBusiness");
                System.out.println("6.Emirates(3)\t18:00\t\t22:05\t\tRs.34000\tBusiness");

                System.out.println("");

                //getting the flight option from the user
                System.out.println("\nEnter your Flight choice:");
                choicei=scan.nextInt();

                //validating the choice
                while(choicei<4 || choicei>6){
                    System.out.println("Invalid! The choice can only be 4,5 or 6");
                    System.out.println("Enter again..");
                    choicei=scan.nextInt();
                }

                //displaying the Availaable Business class seats
                System.out.println("\nSeat numbers available for business class booking\n");
                for (int i = 0; i < business_src3_desti1_seats.size(); i++) {
                    System.out.println("Seat No.: "+business_src3_desti1_seats.get(i));
                }

                //getting the seat number choice from the user
                System.out.println("\nEnter Seat No.:");
                intenationalPassengersList.get(intenationalPassengerCurrCount).seat_no=scan.nextInt();

                //validating the seat number choice
                boolean found=false;
                while(found!=true){

                    for (int i = 0; i < business_src3_desti1_seats.size(); i++) {
                        //finding the seat and removing the seat at the same time in this condition
                        if(intenationalPassengersList.get(intenationalPassengerCurrCount).seat_no==business_src3_desti1_seats.get(i)){
                            found=true;
                            business_src3_desti1_seats.remove(i);

                            //after removing sorting the arraylist
                            Collections.sort(business_src3_desti1_seats);
                        }
                    }

                    if(found==false){
                        System.out.println("Invalid! Please select a seat from the above available seats");
                        intenationalPassengersList.get(intenationalPassengerCurrCount).seat_no=scan.nextInt();
                    }
                }

                //The selected seat is being removed from the arraylist successfully
            }

            //setting the src and dest variables of the passenger class because it will later help in
            //identifying in which arraylist to add the cancelled seat (seat cancelled by the passenger)
            intenationalPassengersList.get(intenationalPassengerCurrCount).src=3;
            intenationalPassengersList.get(intenationalPassengerCurrCount).dest=1;
            intenationalPassengersList.get(intenationalPassengerCurrCount).source="Abu Dhabi";
            intenationalPassengersList.get(intenationalPassengerCurrCount).destination="London";


        }

        else if((srci==3 && desti==2) )//condition
        {
            //original code
            /*System.out.println("Airline:\t \tDeparture:\tArrival:\tPrice:\t\tCategory");
            System.out.println("1.Vistara(1)\t10:00\t\t14:05\t\tRs.17800\tEconomy");
            System.out.println("2.Fly Dubai(2)\t14:00\t\t18:05\t\tRs.14900\tEconomy");
            System.out.println("3.Emirates(3)\t18:00\t\t22:05\t\tRs.18700\tEconomy");

            System.out.println("");
            System.out.println("Airline:\t \tDeparture:\tArrival:\tPrice:\t\tCategory");
            System.out.println("4.Vistara(1)\t10:00\t\t14:05\t\tRs.27800\tBusiness");
            System.out.println("5.Fly Dubai(2)\t14:00\t\t18:05\t\tRs.24900\tBusiness");
            System.out.println("6.Emirates(3)\t18:00\t\t22:05\t\tRs.28700\tBusiness");
            */
            ///////////////////////////////////////////////////////////////////////////

            //checking the availability of the seats in the economy and business class
            if(economy_src3_desti2_seats.size()==0 && business_src3_desti2_seats.size()==0){

                char option;
                System.out.println("\nNo seats available in the business and economy class");
                System.out.println("Do you wish to make another Reservation (y/n):");
                option= scan.next().charAt(0);

                while ( (option!='y') && (option!='n') ){
                    System.out.println("Invalid! Please enter y (for yes) or n (for no)");
                    System.out.println("Enter again..");
                    option= scan.next().charAt(0);
                }

                if(option=='n'){
                    intenationalPassengersList.remove(intenationalPassengerCurrCount);
                    intenationalPassengerCurrCount--;
                    g.global--;
                    return 0;
                }

                else if(option=='y'){
                    return j_detaili();
                }

            }

            //Printing the process if these are no seats available in the economy class
            if(economy_src3_desti2_seats.size()==0){
                System.out.println("\nNo seats are available in the Economy class. Only Business class seats are avaiable");
                System.out.println("Do you wish to make another Reservation (y/n/e)");
                System.out.println("Enter 'y' to make another Reservation. Enter 'n' to continue with the business class booking");
                System.out.println("Enter e for exit");
                char option= scan.next().charAt(0);

                while ( (option!='y') && (option!='n' && (option!='e')) ){
                    System.out.println("Invalid! Please enter y (for yes) or n (for no) or e (for exit)");
                    System.out.println("Enter again..");
                    option= scan.next().charAt(0);
                }

                if(option=='e'){
                    intenationalPassengersList.remove(intenationalPassengerCurrCount);
                    intenationalPassengerCurrCount--;
                    g.global--;
                    return 0;
                }

                else if(option=='y'){
                    return j_detaili();
                }
            }

            //Printing the process if these are no seats available in the business class
            if(business_src3_desti2_seats.size()==0){
                System.out.println("\nNo seats are available in the Business class. Only Economy class seats are avaiable");
                System.out.println("Do you wish to make another Reservation (y/n/e)");
                System.out.println("Enter 'y' to make another Reservation. Enter 'n' to continue with the Economy class booking");
                System.out.println("Enter e to exit");
                char option= scan.next().charAt(0);

                while ( (option!='y') && (option!='n') && (option!='e') ){
                    System.out.println("Invalid! Please enter y (for yes) or n (for no) or e (for exit)");
                    System.out.println("Enter again..");
                    option= scan.next().charAt(0);
                }

                if(option=='e'){
                    intenationalPassengersList.remove(intenationalPassengerCurrCount);
                    intenationalPassengerCurrCount--;
                    g.global--;
                    return 0;
                }

                else if(option=='y'){
                    return j_detaili();
                }
            }

            System.out.println("\n\t \t \t \t \t \tFlights Found");
            System.out.println("");

            if( (business_src3_desti2_seats.size()!=0) && (economy_src3_desti2_seats.size()!=0) ){
                System.out.println("Airline:\t \tDeparture:\tArrival:\tPrice:\t\tCategory");
                System.out.println("1.Vistara(1)\t10:00\t\t14:05\t\tRs.17800\tEconomy");
                System.out.println("2.Fly Dubai(2)\t14:00\t\t18:05\t\tRs.14900\tEconomy");
                System.out.println("3.Emirates(3)\t18:00\t\t22:05\t\tRs.18700\tEconomy");

                System.out.println("");
                System.out.println("Airline:\t \tDeparture:\tArrival:\tPrice:\t\tCategory");
                System.out.println("4.Vistara(1)\t10:00\t\t14:05\t\tRs.27800\tBusiness");
                System.out.println("5.Fly Dubai(2)\t14:00\t\t18:05\t\tRs.24900\tBusiness");
                System.out.println("6.Emirates(3)\t18:00\t\t22:05\t\tRs.28700\tBusiness");


                //getting the flight option from the user
                System.out.println("\nEnter your Flight choice:");
                choicei=scan.nextInt();

                //validating the choice
                while(choicei<1 || choicei>6){
                    System.out.println("Invalid! The choice can only be 1,2,3,4,5 or 6");
                    System.out.println("Enter again..");
                    choicei=scan.nextInt();
                }

                //condition for selection from Economy class
                if(choicei>=1 && choicei<4){
                    //displaying the Availaable Business class seats
                    System.out.println("\nSeat numbers available for Economy class booking\n");
                    for (int i = 0; i < economy_src3_desti2_seats.size(); i++) {
                        System.out.println("Seat No.: "+economy_src3_desti2_seats.get(i));
                    }

                    //getting the seat number choice from the user
                    System.out.println("\nEnter Seat No.:");
                    intenationalPassengersList.get(intenationalPassengerCurrCount).seat_no=scan.nextInt();

                    //validating the seat number choice
                    boolean found=false;
                    while(found!=true){

                        for (int i = 0; i < economy_src3_desti2_seats.size(); i++) {
                            //finding the seat and removing the seat at the same time in this condition
                            if(intenationalPassengersList.get(intenationalPassengerCurrCount).seat_no==economy_src3_desti2_seats.get(i)){
                                found=true;
                                economy_src3_desti2_seats.remove(i);

                                //after removing sorting the arraylist
                                Collections.sort(economy_src3_desti2_seats);
                            }
                        }

                        if(found==false){
                            System.out.println("Invalid! Please select a seat from the above available seats");
                            intenationalPassengersList.get(intenationalPassengerCurrCount).seat_no=scan.nextInt();
                        }
                    }

                    //The selected seat is being removed from the arraylist successfully
                }

                //condition for selection from the business class
                if(choicei>3 && choicei<7){
                    //displaying the Availaable Business class seats
                    System.out.println("\nSeat numbers available for business class booking\n");
                    for (int i = 0; i < business_src3_desti2_seats.size(); i++) {
                        System.out.println("Seat No.: "+business_src3_desti2_seats.get(i));
                    }

                    //getting the seat number choice from the user
                    System.out.println("\nEnter Seat No.:");
                    intenationalPassengersList.get(intenationalPassengerCurrCount).seat_no=scan.nextInt();

                    //validating the seat number choice
                    boolean found=false;
                    while(found!=true){

                        for (int i = 0; i < business_src3_desti2_seats.size(); i++) {
                            //finding the seat and removing the seat at the same time in this condition
                            if(intenationalPassengersList.get(intenationalPassengerCurrCount).seat_no==business_src3_desti2_seats.get(i)){
                                found=true;
                                business_src3_desti2_seats.remove(i);

                                //after removing sorting the arraylist
                                Collections.sort(business_src3_desti2_seats);
                            }
                        }

                        if(found==false){
                            System.out.println("Invalid! Please select a seat from the above available seats");
                            intenationalPassengersList.get(intenationalPassengerCurrCount).seat_no=scan.nextInt();
                        }
                    }

                    //The selected seat is being removed from the arraylist successfully
                }
            }

            if(economy_src3_desti2_seats.size()!=0 && business_src3_desti2_seats.size()==0) {
                System.out.println("Airline:\t \tDeparture:\tArrival:\tPrice:\t\tCategory");
                System.out.println("1.Vistara(1)\t10:00\t\t14:05\t\tRs.17800\tEconomy");
                System.out.println("2.Fly Dubai(2)\t14:00\t\t18:05\t\tRs.14900\tEconomy");
                System.out.println("3.Emirates(3)\t18:00\t\t22:05\t\tRs.18700\tEconomy");
                System.out.println("");

                //getting the flight option from the user
                System.out.println("\nEnter your Flight choice:");
                choicei=scan.nextInt();

                //validating the choice
                while(choicei<1 || choicei>3){
                    System.out.println("Invalid! The choice can only be 1,2 or 3");
                    System.out.println("Enter again..");
                    choicei=scan.nextInt();
                }

                //displaying the Availaable Business class seats
                System.out.println("\nSeat numbers available for Economy class booking\n");
                for (int i = 0; i < economy_src3_desti2_seats.size(); i++) {
                    System.out.println("Seat No.: "+economy_src3_desti2_seats.get(i));
                }

                //getting the seat number choice from the user
                System.out.println("\nEnter Seat No.:");
                intenationalPassengersList.get(intenationalPassengerCurrCount).seat_no=scan.nextInt();

                //validating the seat number choice
                boolean found=false;
                while(found!=true){

                    for (int i = 0; i < economy_src3_desti2_seats.size(); i++) {
                        //finding the seat and removing the seat at the same time in this condition
                        if(intenationalPassengersList.get(intenationalPassengerCurrCount).seat_no==economy_src3_desti2_seats.get(i)){
                            found=true;
                            economy_src3_desti2_seats.remove(i);

                            //after removing sorting the arraylist
                            Collections.sort(economy_src3_desti2_seats);
                        }
                    }

                    if(found==false){
                        System.out.println("Invalid! Please select a seat from the above available seats");
                        intenationalPassengersList.get(intenationalPassengerCurrCount).seat_no=scan.nextInt();
                    }
                }

                //The selected seat is being removed from the arraylist successfully
            }

            if(business_src3_desti2_seats.size()!=0 && economy_src3_desti2_seats.size()==0) {
                System.out.println("Airline:\t \tDeparture:\tArrival:\tPrice:\t\tCategory");
                System.out.println("4.Vistara(1)\t10:00\t\t14:05\t\tRs.27800\tBusiness");
                System.out.println("5.Fly Dubai(2)\t14:00\t\t18:05\t\tRs.24900\tBusiness");
                System.out.println("6.Emirates(3)\t18:00\t\t22:05\t\tRs.28700\tBusiness");
                System.out.println("");

                //getting the flight option from the user
                System.out.println("\nEnter your Flight choice:");
                choicei=scan.nextInt();

                //validating the choice
                while(choicei<4 || choicei>6){
                    System.out.println("Invalid! The choice can only be 4,5 or 6");
                    System.out.println("Enter again..");
                    choicei=scan.nextInt();
                }

                //displaying the Availaable Business class seats
                System.out.println("\nSeat numbers available for business class booking\n");
                for (int i = 0; i < business_src3_desti2_seats.size(); i++) {
                    System.out.println("Seat No.: "+business_src3_desti2_seats.get(i));
                }

                //getting the seat number choice from the user
                System.out.println("\nEnter Seat No.:");
                intenationalPassengersList.get(intenationalPassengerCurrCount).seat_no=scan.nextInt();

                //validating the seat number choice
                boolean found=false;
                while(found!=true){

                    for (int i = 0; i < business_src3_desti2_seats.size(); i++) {
                        //finding the seat and removing the seat at the same time in this condition
                        if(intenationalPassengersList.get(intenationalPassengerCurrCount).seat_no==business_src3_desti2_seats.get(i)){
                            found=true;
                            business_src3_desti2_seats.remove(i);

                            //after removing sorting the arraylist
                            Collections.sort(business_src3_desti2_seats);
                        }
                    }

                    if(found==false){
                        System.out.println("Invalid! Please select a seat from the above available seats");
                        intenationalPassengersList.get(intenationalPassengerCurrCount).seat_no=scan.nextInt();
                    }
                }

                //The selected seat is being removed from the arraylist successfully
            }

            //setting the src and dest variables of the passenger class because it will later help in
            //identifying in which arraylist to add the cancelled seat (seat cancelled by the passenger)
            intenationalPassengersList.get(intenationalPassengerCurrCount).src=3;
            intenationalPassengersList.get(intenationalPassengerCurrCount).dest=2;
            intenationalPassengersList.get(intenationalPassengerCurrCount).source="Abu Dhabi";
            intenationalPassengersList.get(intenationalPassengerCurrCount).destination="Dubai";


        }

        else if(srci==3 && desti==4 )//condition
        {
            //original code
            /*System.out.println("Airline:\t \tDeparture:\tArrival:\tPrice:\t\tCategory");
            System.out.println("1.Vistara(1)\t1:00\t\t4:15\t\tRs.82500\tEconomy");
            System.out.println("2.Fly Dubai(2)\t6:00\t\t21:05\t\tRs.87550\tEconomy");
            System.out.println("3.Emirates(3)\t23:00\t\t15:05\t\tRs81478\tEconomy");

            System.out.println("");
            System.out.println("Airline:\t \tDeparture:\tArrival:\tPrice:\t\tCategory");
            System.out.println("4.Vistara(1)\t1:00\t\t4:15\t\tRs.82500\tBusiness");
            System.out.println("5.Fly Dubai(2)\t6:00\t\t21:05\t\tRs.87550\tBusiness");
            System.out.println("6.Emirates(3)\t23:00\t\t15:05\t\tRs81478\tBusiness");
            */
            /////////////////////////////////////////////////////////////////////////////

            //checking the availability of the seats in the economy and business class
            if(economy_src3_desti4_seats.size()==0 && business_src3_desti4_seats.size()==0){

                char option;
                System.out.println("\nNo seats available in the business and economy class");
                System.out.println("Do you wish to make another Reservation (y/n):");
                option= scan.next().charAt(0);

                while ( (option!='y') && (option!='n') ){
                    System.out.println("Invalid! Please enter y (for yes) or n (for no)");
                    System.out.println("Enter again..");
                    option= scan.next().charAt(0);
                }

                if(option=='n'){
                    intenationalPassengersList.remove(intenationalPassengerCurrCount);
                    intenationalPassengerCurrCount--;
                    g.global--;
                    return 0;
                }

                else if(option=='y'){
                    return j_detaili();
                }

            }

            //Printing the process if these are no seats available in the economy class
            if(economy_src3_desti4_seats.size()==0){
                System.out.println("\nNo seats are available in the Economy class. Only Business class seats are avaiable");
                System.out.println("Do you wish to make another Reservation (y/n/e)");
                System.out.println("Enter 'y' to make another Reservation. Enter 'n' to continue with the business class booking");
                System.out.println("Enter e for exit");
                char option= scan.next().charAt(0);

                while ( (option!='y') && (option!='n' && (option!='e')) ){
                    System.out.println("Invalid! Please enter y (for yes) or n (for no) or e (for exit)");
                    System.out.println("Enter again..");
                    option= scan.next().charAt(0);
                }

                if(option=='e'){
                    intenationalPassengersList.remove(intenationalPassengerCurrCount);
                    intenationalPassengerCurrCount--;
                    g.global--;
                    return 0;
                }

                else if(option=='y'){
                    return j_detaili();
                }
            }

            //Printing the process if these are no seats available in the business class
            if(business_src3_desti4_seats.size()==0){
                System.out.println("\nNo seats are available in the Business class. Only Economy class seats are avaiable");
                System.out.println("Do you wish to make another Reservation (y/n/e)");
                System.out.println("Enter 'y' to make another Reservation. Enter 'n' to continue with the Economy class booking");
                System.out.println("Enter e to exit");
                char option= scan.next().charAt(0);

                while ( (option!='y') && (option!='n') && (option!='e') ){
                    System.out.println("Invalid! Please enter y (for yes) or n (for no) or e (for exit)");
                    System.out.println("Enter again..");
                    option= scan.next().charAt(0);
                }

                if(option=='e'){
                    intenationalPassengersList.remove(intenationalPassengerCurrCount);
                    intenationalPassengerCurrCount--;
                    g.global--;
                    return 0;
                }

                else if(option=='y'){
                    return j_detaili();
                }
            }

            System.out.println("\n\t \t \t \t \t \tFlights Found");
            System.out.println("");

            if( (business_src3_desti4_seats.size()!=0) && (economy_src3_desti4_seats.size()!=0) ){
                System.out.println("Airline:\t \tDeparture:\tArrival:\tPrice:\t\tCategory");
                System.out.println("1.Vistara(1)\t10:00\t\t14:05\t\tRs.17800\tEconomy");
                System.out.println("2.Fly Dubai(2)\t14:00\t\t18:05\t\tRs.14900\tEconomy");
                System.out.println("3.Emirates(3)\t18:00\t\t22:05\t\tRs.18700\tEconomy");

                System.out.println("");
                System.out.println("Airline:\t \tDeparture:\tArrival:\tPrice:\t\tCategory");
                System.out.println("4.Vistara(1)\t10:00\t\t14:05\t\tRs.27800\tBusiness");
                System.out.println("5.Fly Dubai(2)\t14:00\t\t18:05\t\tRs.24900\tBusiness");
                System.out.println("6.Emirates(3)\t18:00\t\t22:05\t\tRs.28700\tBusiness");


                //getting the flight option from the user
                System.out.println("\nEnter your Flight choice:");
                choicei=scan.nextInt();

                //validating the choice
                while(choicei<1 || choicei>6){
                    System.out.println("Invalid! The choice can only be 1,2,3,4,5 or 6");
                    System.out.println("Enter again..");
                    choicei=scan.nextInt();
                }

                //condition for selection from Economy class
                if(choicei>=1 && choicei<4){
                    //displaying the Availaable Business class seats
                    System.out.println("\nSeat numbers available for Economy class booking\n");
                    for (int i = 0; i < economy_src3_desti4_seats.size(); i++) {
                        System.out.println("Seat No.: "+economy_src3_desti4_seats.get(i));
                    }

                    //getting the seat number choice from the user
                    System.out.println("\nEnter Seat No.:");
                    intenationalPassengersList.get(intenationalPassengerCurrCount).seat_no=scan.nextInt();

                    //validating the seat number choice
                    boolean found=false;
                    while(found!=true){

                        for (int i = 0; i < economy_src3_desti4_seats.size(); i++) {
                            //finding the seat and removing the seat at the same time in this condition
                            if(intenationalPassengersList.get(intenationalPassengerCurrCount).seat_no==economy_src3_desti4_seats.get(i)){
                                found=true;
                                economy_src3_desti4_seats.remove(i);

                                //after removing sorting the arraylist
                                Collections.sort(economy_src3_desti4_seats);
                            }
                        }

                        if(found==false){
                            System.out.println("Invalid! Please select a seat from the above available seats");
                            intenationalPassengersList.get(intenationalPassengerCurrCount).seat_no=scan.nextInt();
                        }
                    }

                    //The selected seat is being removed from the arraylist successfully
                }

                //condition for selection from the business class
                if(choicei>3 && choicei<7){
                    //displaying the Availaable Business class seats
                    System.out.println("\nSeat numbers available for business class booking\n");
                    for (int i = 0; i < business_src3_desti4_seats.size(); i++) {
                        System.out.println("Seat No.: "+business_src3_desti4_seats.get(i));
                    }

                    //getting the seat number choice from the user
                    System.out.println("\nEnter Seat No.:");
                    intenationalPassengersList.get(intenationalPassengerCurrCount).seat_no=scan.nextInt();

                    //validating the seat number choice
                    boolean found=false;
                    while(found!=true){

                        for (int i = 0; i < business_src3_desti4_seats.size(); i++) {
                            //finding the seat and removing the seat at the same time in this condition
                            if(intenationalPassengersList.get(intenationalPassengerCurrCount).seat_no==business_src3_desti4_seats.get(i)){
                                found=true;
                                business_src3_desti4_seats.remove(i);

                                //after removing sorting the arraylist
                                Collections.sort(business_src3_desti4_seats);
                            }
                        }

                        if(found==false){
                            System.out.println("Invalid! Please select a seat from the above available seats");
                            intenationalPassengersList.get(intenationalPassengerCurrCount).seat_no=scan.nextInt();
                        }
                    }

                    //The selected seat is being removed from the arraylist successfully
                }
            }

            if(economy_src3_desti4_seats.size()!=0 && business_src3_desti4_seats.size()==0) {
                System.out.println("Airline:\t \tDeparture:\tArrival:\tPrice:\t\tCategory");
                System.out.println("1.Vistara(1)\t10:00\t\t14:05\t\tRs.17800\tEconomy");
                System.out.println("2.Fly Dubai(2)\t14:00\t\t18:05\t\tRs.14900\tEconomy");
                System.out.println("3.Emirates(3)\t18:00\t\t22:05\t\tRs.18700\tEconomy");
                System.out.println("");

                //getting the flight option from the user
                System.out.println("\nEnter your Flight choice:");
                choicei=scan.nextInt();

                //validating the choice
                while(choicei<1 || choicei>3){
                    System.out.println("Invalid! The choice can only be 1,2 or 3");
                    System.out.println("Enter again..");
                    choicei=scan.nextInt();
                }

                //displaying the Availaable Business class seats
                System.out.println("\nSeat numbers available for Economy class booking\n");
                for (int i = 0; i < economy_src3_desti4_seats.size(); i++) {
                    System.out.println("Seat No.: "+economy_src3_desti4_seats.get(i));
                }

                //getting the seat number choice from the user
                System.out.println("\nEnter Seat No.:");
                intenationalPassengersList.get(intenationalPassengerCurrCount).seat_no=scan.nextInt();

                //validating the seat number choice
                boolean found=false;
                while(found!=true){

                    for (int i = 0; i < economy_src3_desti4_seats.size(); i++) {
                        //finding the seat and removing the seat at the same time in this condition
                        if(intenationalPassengersList.get(intenationalPassengerCurrCount).seat_no==economy_src3_desti4_seats.get(i)){
                            found=true;
                            economy_src3_desti4_seats.remove(i);

                            //after removing sorting the arraylist
                            Collections.sort(economy_src3_desti4_seats);
                        }
                    }

                    if(found==false){
                        System.out.println("Invalid! Please select a seat from the above available seats");
                        intenationalPassengersList.get(intenationalPassengerCurrCount).seat_no=scan.nextInt();
                    }
                }

                //The selected seat is being removed from the arraylist successfully
            }

            if(business_src3_desti4_seats.size()!=0 && economy_src3_desti4_seats.size()==0) {
                System.out.println("Airline:\t \tDeparture:\tArrival:\tPrice:\t\tCategory");
                System.out.println("4.Vistara(1)\t10:00\t\t14:05\t\tRs.27800\tBusiness");
                System.out.println("5.Fly Dubai(2)\t14:00\t\t18:05\t\tRs.24900\tBusiness");
                System.out.println("6.Emirates(3)\t18:00\t\t22:05\t\tRs.28700\tBusiness");
                System.out.println("");

                //getting the flight option from the user
                System.out.println("\nEnter your Flight choice:");
                choicei=scan.nextInt();

                //validating the choice
                while(choicei<4 || choicei>6){
                    System.out.println("Invalid! The choice can only be 4,5 or 6");
                    System.out.println("Enter again..");
                    choicei=scan.nextInt();
                }

                //displaying the Availaable Business class seats
                System.out.println("\nSeat numbers available for business class booking\n");
                for (int i = 0; i < business_src3_desti4_seats.size(); i++) {
                    System.out.println("Seat No.: "+business_src3_desti4_seats.get(i));
                }

                //getting the seat number choice from the user
                System.out.println("\nEnter Seat No.:");
                intenationalPassengersList.get(intenationalPassengerCurrCount).seat_no=scan.nextInt();

                //validating the seat number choice
                boolean found=false;
                while(found!=true){

                    for (int i = 0; i < business_src3_desti4_seats.size(); i++) {
                        //finding the seat and removing the seat at the same time in this condition
                        if(intenationalPassengersList.get(intenationalPassengerCurrCount).seat_no==business_src3_desti4_seats.get(i)){
                            found=true;
                            business_src3_desti4_seats.remove(i);

                            //after removing sorting the arraylist
                            Collections.sort(business_src3_desti4_seats);
                        }
                    }

                    if(found==false){
                        System.out.println("Invalid! Please select a seat from the above available seats");
                        intenationalPassengersList.get(intenationalPassengerCurrCount).seat_no=scan.nextInt();
                    }
                }

                //The selected seat is being removed from the arraylist successfully
            }

            //setting the src and dest variables of the passenger class because it will later help in
            //identifying in which arraylist to add the cancelled seat (seat cancelled by the passenger)
            intenationalPassengersList.get(intenationalPassengerCurrCount).src=3;
            intenationalPassengersList.get(intenationalPassengerCurrCount).dest=4;
            intenationalPassengersList.get(intenationalPassengerCurrCount).source="Abu Dhabi";
            intenationalPassengersList.get(intenationalPassengerCurrCount).destination="Singapore";


        }

        else if(srci==3 && desti==5 )//condition
        {
            //original code

            /*System.out.println("Airline:\t \tDeparture:\tArrival:\tPrice:\t\tCategory");
            System.out.println("1.Vistara(1)\t5:00\t\18:05\t\tRs.91750\tEconomy");
            System.out.println("2.Fly Dubai(2)\t11:00\t\t4:40\t\tRs.96450\tEconomy");
            System.out.println("3.Emirates(3)\t14:30\t\t7:45\t\tRs98360\tEconomy");

            System.out.println("");
            System.out.println("Airline:\t \tDeparture:\tArrival:\tPrice:\t\tCategory");
            System.out.println("4.Vistara(1)\t5:00\t\18:05\t\tRs.1,01,750\tBusiness");
            System.out.println("5.Fly Dubai(2)\t11:00\t\t4:40\t\tRs.1,06,450\tBusiness");
            System.out.println("6.Emirates(3)\t14:30\t\t7:45\t\tRs1,08,360\tBusiness");
            */
            ///////////////////////////////////////////////////////////////////////////

            //checking the availability of the seats in the economy and business class
            if(economy_src3_desti5_seats.size()==0 && business_src3_desti5_seats.size()==0){

                char option;
                System.out.println("\nNo seats available in the business and economy class");
                System.out.println("Do you wish to make another Reservation (y/n):");
                option= scan.next().charAt(0);

                while ( (option!='y') && (option!='n') ){
                    System.out.println("Invalid! Please enter y (for yes) or n (for no)");
                    System.out.println("Enter again..");
                    option= scan.next().charAt(0);
                }

                if(option=='n'){
                    intenationalPassengersList.remove(intenationalPassengerCurrCount);
                    intenationalPassengerCurrCount--;
                    g.global--;
                    return 0;
                }

                else if(option=='y'){
                    return j_detaili();
                }

            }

            //Printing the process if these are no seats available in the economy class
            if(economy_src3_desti5_seats.size()==0){
                System.out.println("\nNo seats are available in the Economy class. Only Business class seats are avaiable");
                System.out.println("Do you wish to make another Reservation (y/n/e)");
                System.out.println("Enter 'y' to make another Reservation. Enter 'n' to continue with the business class booking");
                System.out.println("Enter e for exit");
                char option= scan.next().charAt(0);

                while ( (option!='y') && (option!='n' && (option!='e')) ){
                    System.out.println("Invalid! Please enter y (for yes) or n (for no) or e (for exit)");
                    System.out.println("Enter again..");
                    option= scan.next().charAt(0);
                }

                if(option=='e'){
                    intenationalPassengersList.remove(intenationalPassengerCurrCount);
                    intenationalPassengerCurrCount--;
                    g.global--;
                    return 0;
                }

                else if(option=='y'){
                    return j_detaili();
                }
            }

            //Printing the process if these are no seats available in the business class
            if(business_src3_desti5_seats.size()==0){
                System.out.println("\nNo seats are available in the Business class. Only Economy class seats are avaiable");
                System.out.println("Do you wish to make another Reservation (y/n/e)");
                System.out.println("Enter 'y' to make another Reservation. Enter 'n' to continue with the Economy class booking");
                System.out.println("Enter e to exit");
                char option= scan.next().charAt(0);

                while ( (option!='y') && (option!='n') && (option!='e') ){
                    System.out.println("Invalid! Please enter y (for yes) or n (for no) or e (for exit)");
                    System.out.println("Enter again..");
                    option= scan.next().charAt(0);
                }

                if(option=='e'){
                    intenationalPassengersList.remove(intenationalPassengerCurrCount);
                    intenationalPassengerCurrCount--;
                    g.global--;
                    return 0;
                }

                else if(option=='y'){
                    return j_detaili();
                }
            }

            System.out.println("\n\t \t \t \t \t \tFlights Found");
            System.out.println("");

            if( (business_src3_desti5_seats.size()!=0) && (economy_src3_desti5_seats.size()!=0) ){
                System.out.println("1.Vistara(1)\t5:00\t\t18:05\t\tRs.91750\tEconomy");
                System.out.println("2.Fly Dubai(2)\t11:00\t\t4:40\t\tRs.96450\tEconomy");
                System.out.println("3.Emirates(3)\t14:30\t\t7:45\t\tRs98360\t\tEconomy");

                System.out.println("");
                System.out.println("Airline:\t \tDeparture:\tArrival:\tPrice:\t\tCategory");
                System.out.println("4.Vistara(1)\t5:00\t\t18:05\t\tRs.1,01,750\tBusiness");
                System.out.println("5.Fly Dubai(2)\t11:00\t\t4:40\t\tRs.1,06,450\tBusiness");
                System.out.println("6.Emirates(3)\t14:30\t\t7:45\t\tRs1,08,360\tBusiness");


                //getting the flight option from the user
                System.out.println("\nEnter your Flight choice:");
                choicei=scan.nextInt();

                //validating the choice
                while(choicei<1 || choicei>6){
                    System.out.println("Invalid! The choice can only be 1,2,3,4,5 or 6");
                    System.out.println("Enter again..");
                    choicei=scan.nextInt();
                }

                //condition for selection from Economy class
                if(choicei>=1 && choicei<4){
                    //displaying the Availaable Business class seats
                    System.out.println("\nSeat numbers available for Economy class booking\n");
                    for (int i = 0; i < economy_src3_desti5_seats.size(); i++) {
                        System.out.println("Seat No.: "+economy_src3_desti5_seats.get(i));
                    }

                    //getting the seat number choice from the user
                    System.out.println("\nEnter Seat No.:");
                    intenationalPassengersList.get(intenationalPassengerCurrCount).seat_no=scan.nextInt();

                    //validating the seat number choice
                    boolean found=false;
                    while(found!=true){

                        for (int i = 0; i < economy_src3_desti5_seats.size(); i++) {
                            //finding the seat and removing the seat at the same time in this condition
                            if(intenationalPassengersList.get(intenationalPassengerCurrCount).seat_no==economy_src3_desti5_seats.get(i)){
                                found=true;
                                economy_src3_desti5_seats.remove(i);

                                //after removing sorting the arraylist
                                Collections.sort(economy_src3_desti5_seats);
                            }
                        }

                        if(found==false){
                            System.out.println("Invalid! Please select a seat from the above available seats");
                            intenationalPassengersList.get(intenationalPassengerCurrCount).seat_no=scan.nextInt();
                        }
                    }

                    //The selected seat is being removed from the arraylist successfully
                }

                //condition for selection from the business class
                if(choicei>3 && choicei<7){
                    //displaying the Availaable Business class seats
                    System.out.println("\nSeat numbers available for business class booking\n");
                    for (int i = 0; i < business_src3_desti5_seats.size(); i++) {
                        System.out.println("Seat No.: "+business_src3_desti5_seats.get(i));
                    }

                    //getting the seat number choice from the user
                    System.out.println("\nEnter Seat No.:");
                    intenationalPassengersList.get(intenationalPassengerCurrCount).seat_no=scan.nextInt();

                    //validating the seat number choice
                    boolean found=false;
                    while(found!=true){

                        for (int i = 0; i < business_src3_desti5_seats.size(); i++) {
                            //finding the seat and removing the seat at the same time in this condition
                            if(intenationalPassengersList.get(intenationalPassengerCurrCount).seat_no==business_src3_desti5_seats.get(i)){
                                found=true;
                                business_src3_desti5_seats.remove(i);

                                //after removing sorting the arraylist
                                Collections.sort(business_src3_desti5_seats);
                            }
                        }

                        if(found==false){
                            System.out.println("Invalid! Please select a seat from the above available seats");
                            intenationalPassengersList.get(intenationalPassengerCurrCount).seat_no=scan.nextInt();
                        }
                    }

                    //The selected seat is being removed from the arraylist successfully
                }
            }

            if(economy_src3_desti5_seats.size()!=0 && business_src3_desti5_seats.size()==0) {
                System.out.println("1.Vistara(1)\t5:00\t\t8:05\t\tRs.91750\tEconomy");
                System.out.println("2.Fly Dubai(2)\t11:00\t\t4:40\t\tRs.96450\tEconomy");
                System.out.println("3.Emirates(3)\t14:30\t\t7:45\t\tRs98360\t\tEconomy");
                System.out.println("");

                //getting the flight option from the user
                System.out.println("\nEnter your Flight choice:");
                choicei=scan.nextInt();

                //validating the choice
                while(choicei<1 || choicei>3){
                    System.out.println("Invalid! The choice can only be 1,2 or 3");
                    System.out.println("Enter again..");
                    choicei=scan.nextInt();
                }

                //displaying the Availaable Business class seats
                System.out.println("\nSeat numbers available for Economy class booking\n");
                for (int i = 0; i < economy_src3_desti5_seats.size(); i++) {
                    System.out.println("Seat No.: "+economy_src3_desti5_seats.get(i));
                }

                //getting the seat number choice from the user
                System.out.println("\nEnter Seat No.:");
                intenationalPassengersList.get(intenationalPassengerCurrCount).seat_no=scan.nextInt();

                //validating the seat number choice
                boolean found=false;
                while(found!=true){

                    for (int i = 0; i < economy_src3_desti5_seats.size(); i++) {
                        //finding the seat and removing the seat at the same time in this condition
                        if(intenationalPassengersList.get(intenationalPassengerCurrCount).seat_no==economy_src3_desti5_seats.get(i)){
                            found=true;
                            economy_src3_desti5_seats.remove(i);

                            //after removing sorting the arraylist
                            Collections.sort(economy_src3_desti5_seats);
                        }
                    }

                    if(found==false){
                        System.out.println("Invalid! Please select a seat from the above available seats");
                        intenationalPassengersList.get(intenationalPassengerCurrCount).seat_no=scan.nextInt();
                    }
                }

                //The selected seat is being removed from the arraylist successfully
            }

            if(business_src3_desti5_seats.size()!=0 && economy_src3_desti5_seats.size()==0) {
                System.out.println("Airline:\t \tDeparture:\tArrival:\tPrice:\t\tCategory");
                System.out.println("4.Vistara(1)\t5:00\t\t8:05\t\tRs.1,01,750\tBusiness");
                System.out.println("5.Fly Dubai(2)\t11:00\t\t4:40\t\tRs.1,06,450\tBusiness");
                System.out.println("6.Emirates(3)\t14:30\t\t7:45\t\tRs1,08,360\tBusiness");
                System.out.println("");

                //getting the flight option from the user
                System.out.println("\nEnter your Flight choice:");
                choicei=scan.nextInt();

                //validating the choice
                while(choicei<4 || choicei>6){
                    System.out.println("Invalid! The choice can only be 4,5 or 6");
                    System.out.println("Enter again..");
                    choicei=scan.nextInt();
                }

                //displaying the Availaable Business class seats
                System.out.println("\nSeat numbers available for business class booking\n");
                for (int i = 0; i < business_src3_desti5_seats.size(); i++) {
                    System.out.println("Seat No.: "+business_src3_desti5_seats.get(i));
                }

                //getting the seat number choice from the user
                System.out.println("\nEnter Seat No.:");
                intenationalPassengersList.get(intenationalPassengerCurrCount).seat_no=scan.nextInt();

                //validating the seat number choice
                boolean found=false;
                while(found!=true){

                    for (int i = 0; i < business_src3_desti5_seats.size(); i++) {
                        //finding the seat and removing the seat at the same time in this condition
                        if(intenationalPassengersList.get(intenationalPassengerCurrCount).seat_no==business_src3_desti5_seats.get(i)){
                            found=true;
                            business_src3_desti5_seats.remove(i);

                            //after removing sorting the arraylist
                            Collections.sort(business_src3_desti5_seats);
                        }
                    }

                    if(found==false){
                        System.out.println("Invalid! Please select a seat from the above available seats");
                        intenationalPassengersList.get(intenationalPassengerCurrCount).seat_no=scan.nextInt();
                    }
                }

                //The selected seat is being removed from the arraylist successfully
            }

            //setting the src and dest variables of the passenger class because it will later help in
            //identifying in which arraylist to add the cancelled seat (seat cancelled by the passenger)
            intenationalPassengersList.get(intenationalPassengerCurrCount).src=3;
            intenationalPassengersList.get(intenationalPassengerCurrCount).dest=5;
            intenationalPassengersList.get(intenationalPassengerCurrCount).source="Abu Dhabi";
            intenationalPassengersList.get(intenationalPassengerCurrCount).destination="New York";



        }

        else if((srci==4 && desti==1))//condition
        {
            //original code
            /*System.out.println("Airline:\t \tDeparture:\tArrival:\tPrice:\t\tCategory");
            System.out.println("1.Vistara(1)\t10:00\t\t14:05\t\tRs.25500\tEconomy");
            System.out.println("2.Fly Dubai(2)\t14:00\t\t18:05\t\tRs.21300\tEconomy");
            System.out.println("3.Emirates(3)\t18:00\t\t22:05\t\tRs.24650\t\tEconomy");

            System.out.println("Airline:\t \tDeparture:\tArrival:\tPrice:\t\tCategory");
            System.out.println("4.Vistara(1)\t10:00\t\t14:05\t\tRs.35500\tBusiness");
            System.out.println("5.Fly Dubai(2)\t14:00\t\t18:05\t\tRs.31300\tBusiness");
            System.out.println("6.Emirates(3)\t18:00\t\t22:05\t\tRs.34650\t\tBusiness");
            */
            ///////////////////////////////////////////////////////////////////////////

            //checking the availability of the seats in the economy and business class
            if(economy_src4_desti1_seats.size()==0 && business_src4_desti1_seats.size()==0){

                char option;
                System.out.println("\nNo seats available in the business and economy class");
                System.out.println("Do you wish to make another Reservation (y/n):");
                option= scan.next().charAt(0);

                while ( (option!='y') && (option!='n') ){
                    System.out.println("Invalid! Please enter y (for yes) or n (for no)");
                    System.out.println("Enter again..");
                    option= scan.next().charAt(0);
                }

                if(option=='n'){
                    intenationalPassengersList.remove(intenationalPassengerCurrCount);
                    intenationalPassengerCurrCount--;
                    g.global--;
                    return 0;
                }

                else if(option=='y'){
                    return j_detaili();
                }

            }

            //Printing the process if these are no seats available in the economy class
            if(economy_src4_desti1_seats.size()==0){
                System.out.println("\nNo seats are available in the Economy class. Only Business class seats are avaiable");
                System.out.println("Do you wish to make another Reservation (y/n/e)");
                System.out.println("Enter 'y' to make another Reservation. Enter 'n' to continue with the business class booking");
                System.out.println("Enter e for exit");
                char option= scan.next().charAt(0);

                while ( (option!='y') && (option!='n' && (option!='e')) ){
                    System.out.println("Invalid! Please enter y (for yes) or n (for no) or e (for exit)");
                    System.out.println("Enter again..");
                    option= scan.next().charAt(0);
                }

                if(option=='e'){
                    intenationalPassengersList.remove(intenationalPassengerCurrCount);
                    intenationalPassengerCurrCount--;
                    g.global--;
                    return 0;
                }

                else if(option=='y'){
                    return j_detaili();
                }
            }

            //Printing the process if these are no seats available in the business class
            if(business_src4_desti1_seats.size()==0){
                System.out.println("\nNo seats are available in the Business class. Only Economy class seats are avaiable");
                System.out.println("Do you wish to make another Reservation (y/n/e)");
                System.out.println("Enter 'y' to make another Reservation. Enter 'n' to continue with the Economy class booking");
                System.out.println("Enter e to exit");
                char option= scan.next().charAt(0);

                while ( (option!='y') && (option!='n') && (option!='e') ){
                    System.out.println("Invalid! Please enter y (for yes) or n (for no) or e (for exit)");
                    System.out.println("Enter again..");
                    option= scan.next().charAt(0);
                }

                if(option=='e'){
                    intenationalPassengersList.remove(intenationalPassengerCurrCount);
                    intenationalPassengerCurrCount--;
                    g.global--;
                    return 0;
                }

                else if(option=='y'){
                    return j_detaili();
                }
            }

            System.out.println("\n\t \t \t \t \t \tFlights Found");
            System.out.println("");

            if( (business_src4_desti1_seats.size()!=0) && (economy_src4_desti1_seats.size()!=0) ){
                System.out.println("Airline:\t \tDeparture:\tArrival:\tPrice:\t\tCategory");
                System.out.println("1.Vistara(1)\t10:00\t\t14:05\t\tRs.25000\tEcononmy");
                System.out.println("2.Fly Dubai(2)\t14:00\t\t18:05\t\tRs.21500\tEcononmy");
                System.out.println("3.Emirates(3)\t18:00\t\t22:05\t\tRs.24000\tEcononmy");

                System.out.println("");
                System.out.println("Airline:\t \tDeparture:\tArrival:\tPrice:\t\tCategory");
                System.out.println("4.Vistara(1)\t10:00\t\t14:05\t\tRs.35000\tBusiness");
                System.out.println("5.Fly Dubai(2)\t14:00\t\t18:05\t\tRs.31500\tBusiness");
                System.out.println("6.Emirates(3)\t18:00\t\t22:05\t\tRs.34000\tBusiness");


                //getting the flight option from the user
                System.out.println("\nEnter your Flight choice:");
                choicei=scan.nextInt();

                //validating the choice
                while(choicei<1 || choicei>6){
                    System.out.println("Invalid! The choice can only be 1,2,3,4,5 or 6");
                    System.out.println("Enter again..");
                    choicei=scan.nextInt();
                }

                //condition for selection from Economy class
                if(choicei>=1 && choicei<4){
                    //displaying the Availaable Business class seats
                    System.out.println("\nSeat numbers available for Economy class booking\n");
                    for (int i = 0; i < economy_src4_desti1_seats.size(); i++) {
                        System.out.println("Seat No.: "+economy_src4_desti1_seats.get(i));
                    }

                    //getting the seat number choice from the user
                    System.out.println("\nEnter Seat No.:");
                    intenationalPassengersList.get(intenationalPassengerCurrCount).seat_no=scan.nextInt();

                    //validating the seat number choice
                    boolean found=false;
                    while(found!=true){

                        for (int i = 0; i < economy_src4_desti1_seats.size(); i++) {
                            //finding the seat and removing the seat at the same time in this condition
                            if(intenationalPassengersList.get(intenationalPassengerCurrCount).seat_no==economy_src4_desti1_seats.get(i)){
                                found=true;
                                economy_src4_desti1_seats.remove(i);

                                //after removing sorting the arraylist
                                Collections.sort(economy_src4_desti1_seats);
                            }
                        }

                        if(found==false){
                            System.out.println("Invalid! Please select a seat from the above available seats");
                            intenationalPassengersList.get(intenationalPassengerCurrCount).seat_no=scan.nextInt();
                        }
                    }

                    //The selected seat is being removed from the arraylist successfully
                }

                //condition for selection from the business class
                if(choicei>3 && choicei<7){
                    //displaying the Availaable Business class seats
                    System.out.println("\nSeat numbers available for business class booking\n");
                    for (int i = 0; i < business_src4_desti1_seats.size(); i++) {
                        System.out.println("Seat No.: "+business_src4_desti1_seats.get(i));
                    }

                    //getting the seat number choice from the user
                    System.out.println("\nEnter Seat No.:");
                    intenationalPassengersList.get(intenationalPassengerCurrCount).seat_no=scan.nextInt();

                    //validating the seat number choice
                    boolean found=false;
                    while(found!=true){

                        for (int i = 0; i < business_src4_desti1_seats.size(); i++) {
                            //finding the seat and removing the seat at the same time in this condition
                            if(intenationalPassengersList.get(intenationalPassengerCurrCount).seat_no==business_src4_desti1_seats.get(i)){
                                found=true;
                                business_src4_desti1_seats.remove(i);

                                //after removing sorting the arraylist
                                Collections.sort(business_src4_desti1_seats);
                            }
                        }

                        if(found==false){
                            System.out.println("Invalid! Please select a seat from the above available seats");
                            intenationalPassengersList.get(intenationalPassengerCurrCount).seat_no=scan.nextInt();
                        }
                    }

                    //The selected seat is being removed from the arraylist successfully
                }
            }

            if(economy_src4_desti1_seats.size()!=0 && business_src4_desti1_seats.size()==0) {
                System.out.println("Airline:\t \tDeparture:\tArrival:\tPrice:\t\tCategory");
                System.out.println("1.Vistara(1)\t10:00\t\t14:05\t\tRs.25000\tEcononmy");
                System.out.println("2.Fly Dubai(2)\t14:00\t\t18:05\t\tRs.21500\tEcononmy");
                System.out.println("3.Emirates(3)\t18:00\t\t22:05\t\tRs.24000\tEcononmy");
                System.out.println("");

                //getting the flight option from the user
                System.out.println("\nEnter your Flight choice:");
                choicei=scan.nextInt();

                //validating the choice
                while(choicei<1 || choicei>3){
                    System.out.println("Invalid! The choice can only be 1,2 or 3");
                    System.out.println("Enter again..");
                    choicei=scan.nextInt();
                }

                //displaying the Availaable Business class seats
                System.out.println("\nSeat numbers available for Economy class booking\n");
                for (int i = 0; i < economy_src4_desti1_seats.size(); i++) {
                    System.out.println("Seat No.: "+economy_src4_desti1_seats.get(i));
                }

                //getting the seat number choice from the user
                System.out.println("\nEnter Seat No.:");
                intenationalPassengersList.get(intenationalPassengerCurrCount).seat_no=scan.nextInt();

                //validating the seat number choice
                boolean found=false;
                while(found!=true){

                    for (int i = 0; i < economy_src4_desti1_seats.size(); i++) {
                        //finding the seat and removing the seat at the same time in this condition
                        if(intenationalPassengersList.get(intenationalPassengerCurrCount).seat_no==economy_src4_desti1_seats.get(i)){
                            found=true;
                            economy_src4_desti1_seats.remove(i);

                            //after removing sorting the arraylist
                            Collections.sort(economy_src4_desti1_seats);
                        }
                    }

                    if(found==false){
                        System.out.println("Invalid! Please select a seat from the above available seats");
                        intenationalPassengersList.get(intenationalPassengerCurrCount).seat_no=scan.nextInt();
                    }
                }

                //The selected seat is being removed from the arraylist successfully
            }

            if(business_src4_desti1_seats.size()!=0 && economy_src4_desti1_seats.size()==0) {
                System.out.println("Airline:\t \tDeparture:\tArrival:\tPrice:\t\tCategory");
                System.out.println("4.Vistara(1)\t10:00\t\t14:05\t\tRs.35000\tBusiness");
                System.out.println("5.Fly Dubai(2)\t14:00\t\t18:05\t\tRs.31500\tBusiness");
                System.out.println("6.Emirates(3)\t18:00\t\t22:05\t\tRs.34000\tBusiness");

                System.out.println("");

                //getting the flight option from the user
                System.out.println("\nEnter your Flight choice:");
                choicei=scan.nextInt();

                //validating the choice
                while(choicei<4 || choicei>6){
                    System.out.println("Invalid! The choice can only be 4,5 or 6");
                    System.out.println("Enter again..");
                    choicei=scan.nextInt();
                }

                //displaying the Availaable Business class seats
                System.out.println("\nSeat numbers available for business class booking\n");
                for (int i = 0; i < business_src4_desti1_seats.size(); i++) {
                    System.out.println("Seat No.: "+business_src4_desti1_seats.get(i));
                }

                //getting the seat number choice from the user
                System.out.println("\nEnter Seat No.:");
                intenationalPassengersList.get(intenationalPassengerCurrCount).seat_no=scan.nextInt();

                //validating the seat number choice
                boolean found=false;
                while(found!=true){

                    for (int i = 0; i < business_src4_desti1_seats.size(); i++) {
                        //finding the seat and removing the seat at the same time in this condition
                        if(intenationalPassengersList.get(intenationalPassengerCurrCount).seat_no==business_src4_desti1_seats.get(i)){
                            found=true;
                            business_src4_desti1_seats.remove(i);

                            //after removing sorting the arraylist
                            Collections.sort(business_src4_desti1_seats);
                        }
                    }

                    if(found==false){
                        System.out.println("Invalid! Please select a seat from the above available seats");
                        intenationalPassengersList.get(intenationalPassengerCurrCount).seat_no=scan.nextInt();
                    }
                }

                //The selected seat is being removed from the arraylist successfully
            }

            //setting the src and dest variables of the passenger class because it will later help in
            //identifying in which arraylist to add the cancelled seat (seat cancelled by the passenger)
            intenationalPassengersList.get(intenationalPassengerCurrCount).src=4;
            intenationalPassengersList.get(intenationalPassengerCurrCount).dest=1;
            intenationalPassengersList.get(intenationalPassengerCurrCount).source="Singapore";
            intenationalPassengersList.get(intenationalPassengerCurrCount).destination="London";


        }

        else if((srci==4 && desti==2) )//condition
        {
            //original code
            /*System.out.println("Airline:\t \tDeparture:\tArrival:\tPrice:\t\tCategory");
            System.out.println("1.Vistara(1)\t10:00\t\t14:05\t\tRs.32000\tEconomy");
            System.out.println("2.Fly Dubai(2)\t14:00\t\t18:05\t\tRs.38500\tEconomy");
            System.out.println("3.Emirates(3)\t18:00\t\t22:05\t\tRs41259\tEconomy");

            System.out.println("");
            System.out.println("Airline:\t \tDeparture:\tArrival:\tPrice:\t\tCategory");
            System.out.println("4.Vistara(1)\t10:00\t\t14:05\t\tRs.42000\tBusiness");
            System.out.println("5.Fly Dubai(2)\t14:00\t\t18:05\t\tRs48500\tBusiness");
            System.out.println("6.Emirates(3)\t18:00\t\t22:05\t\tRs51259\tBusiness");
             */
            /////////////////////////////////////////////////////////////////////////

            //checking the availability of the seats in the economy and business class
            if(economy_src4_desti2_seats.size()==0 && business_src4_desti2_seats.size()==0){

                char option;
                System.out.println("\nNo seats available in the business and economy class");
                System.out.println("Do you wish to make another Reservation (y/n):");
                option= scan.next().charAt(0);

                while ( (option!='y') && (option!='n') ){
                    System.out.println("Invalid! Please enter y (for yes) or n (for no)");
                    System.out.println("Enter again..");
                    option= scan.next().charAt(0);
                }

                if(option=='n'){
                    intenationalPassengersList.remove(intenationalPassengerCurrCount);
                    intenationalPassengerCurrCount--;
                    g.global--;
                    return 0;
                }

                else if(option=='y'){
                    return j_detaili();
                }

            }

            //Printing the process if these are no seats available in the economy class
            if(economy_src4_desti2_seats.size()==0){
                System.out.println("\nNo seats are available in the Economy class. Only Business class seats are avaiable");
                System.out.println("Do you wish to make another Reservation (y/n/e)");
                System.out.println("Enter 'y' to make another Reservation. Enter 'n' to continue with the business class booking");
                System.out.println("Enter e for exit");
                char option= scan.next().charAt(0);

                while ( (option!='y') && (option!='n' && (option!='e')) ){
                    System.out.println("Invalid! Please enter y (for yes) or n (for no) or e (for exit)");
                    System.out.println("Enter again..");
                    option= scan.next().charAt(0);
                }

                if(option=='e'){
                    intenationalPassengersList.remove(intenationalPassengerCurrCount);
                    intenationalPassengerCurrCount--;
                    g.global--;
                    return 0;
                }

                else if(option=='y'){
                    return j_detaili();
                }
            }

            //Printing the process if these are no seats available in the business class
            if(business_src4_desti2_seats.size()==0){
                System.out.println("\nNo seats are available in the Business class. Only Economy class seats are avaiable");
                System.out.println("Do you wish to make another Reservation (y/n/e)");
                System.out.println("Enter 'y' to make another Reservation. Enter 'n' to continue with the Economy class booking");
                System.out.println("Enter e to exit");
                char option= scan.next().charAt(0);

                while ( (option!='y') && (option!='n') && (option!='e') ){
                    System.out.println("Invalid! Please enter y (for yes) or n (for no) or e (for exit)");
                    System.out.println("Enter again..");
                    option= scan.next().charAt(0);
                }

                if(option=='e'){
                    intenationalPassengersList.remove(intenationalPassengerCurrCount);
                    intenationalPassengerCurrCount--;
                    g.global--;
                    return 0;
                }

                else if(option=='y'){
                    return j_detaili();
                }
            }

            System.out.println("\n\t \t \t \t \t \tFlights Found");
            System.out.println("");

            if( (business_src4_desti2_seats.size()!=0) && (economy_src4_desti2_seats.size()!=0) ){
                System.out.println("Airline:\t \tDeparture:\tArrival:\tPrice:\t\tCategory");
                System.out.println("1.Vistara(1)\t10:00\t\t14:05\t\tRs.32000\tEconomy");
                System.out.println("2.Fly Dubai(2)\t14:00\t\t18:05\t\tRs.38500\tEconomy");
                System.out.println("3.Emirates(3)\t18:00\t\t22:05\t\tRs41259\t\tEconomy");

                System.out.println("");
                System.out.println("Airline:\t \tDeparture:\tArrival:\tPrice:\t\tCategory");
                System.out.println("4.Vistara(1)\t10:00\t\t14:05\t\tRs.42000\tBusiness");
                System.out.println("5.Fly Dubai(2)\t14:00\t\t18:05\t\tRs48500\t\tBusiness");
                System.out.println("6.Emirates(3)\t18:00\t\t22:05\t\tRs51259\t\tBusiness");


                //getting the flight option from the user
                System.out.println("\nEnter your Flight choice:");
                choicei=scan.nextInt();

                //validating the choice
                while(choicei<1 || choicei>6){
                    System.out.println("Invalid! The choice can only be 1,2,3,4,5 or 6");
                    System.out.println("Enter again..");
                    choicei=scan.nextInt();
                }

                //condition for selection from Economy class
                if(choicei>=1 && choicei<4){
                    //displaying the Availaable Business class seats
                    System.out.println("\nSeat numbers available for Economy class booking\n");
                    for (int i = 0; i < economy_src4_desti2_seats.size(); i++) {
                        System.out.println("Seat No.: "+economy_src4_desti2_seats.get(i));
                    }

                    //getting the seat number choice from the user
                    System.out.println("\nEnter Seat No.:");
                    intenationalPassengersList.get(intenationalPassengerCurrCount).seat_no=scan.nextInt();

                    //validating the seat number choice
                    boolean found=false;
                    while(found!=true){

                        for (int i = 0; i < economy_src4_desti2_seats.size(); i++) {
                            //finding the seat and removing the seat at the same time in this condition
                            if(intenationalPassengersList.get(intenationalPassengerCurrCount).seat_no==economy_src4_desti2_seats.get(i)){
                                found=true;
                                economy_src4_desti2_seats.remove(i);

                                //after removing sorting the arraylist
                                Collections.sort(economy_src4_desti2_seats);
                            }
                        }

                        if(found==false){
                            System.out.println("Invalid! Please select a seat from the above available seats");
                            intenationalPassengersList.get(intenationalPassengerCurrCount).seat_no=scan.nextInt();
                        }
                    }

                    //The selected seat is being removed from the arraylist successfully
                }

                //condition for selection from the business class
                if(choicei>3 && choicei<7){
                    //displaying the Availaable Business class seats
                    System.out.println("\nSeat numbers available for business class booking\n");
                    for (int i = 0; i < business_src4_desti2_seats.size(); i++) {
                        System.out.println("Seat No.: "+business_src4_desti2_seats.get(i));
                    }

                    //getting the seat number choice from the user
                    System.out.println("\nEnter Seat No.:");
                    intenationalPassengersList.get(intenationalPassengerCurrCount).seat_no=scan.nextInt();

                    //validating the seat number choice
                    boolean found=false;
                    while(found!=true){

                        for (int i = 0; i < business_src4_desti2_seats.size(); i++) {
                            //finding the seat and removing the seat at the same time in this condition
                            if(intenationalPassengersList.get(intenationalPassengerCurrCount).seat_no==business_src4_desti2_seats.get(i)){
                                found=true;
                                business_src4_desti2_seats.remove(i);

                                //after removing sorting the arraylist
                                Collections.sort(business_src4_desti2_seats);
                            }
                        }

                        if(found==false){
                            System.out.println("Invalid! Please select a seat from the above available seats");
                            intenationalPassengersList.get(intenationalPassengerCurrCount).seat_no=scan.nextInt();
                        }
                    }

                    //The selected seat is being removed from the arraylist successfully
                }
            }

            if(economy_src4_desti2_seats.size()!=0 && business_src4_desti2_seats.size()==0) {
                System.out.println("Airline:\t \tDeparture:\tArrival:\tPrice:\t\tCategory");
                System.out.println("1.Vistara(1)\t10:00\t\t14:05\t\tRs.32000\tEconomy");
                System.out.println("2.Fly Dubai(2)\t14:00\t\t18:05\t\tRs.38500\tEconomy");
                System.out.println("3.Emirates(3)\t18:00\t\t22:05\t\tRs41259\t\tEconomy");

                System.out.println("");

                //getting the flight option from the user
                System.out.println("\nEnter your Flight choice:");
                choicei=scan.nextInt();

                //validating the choice
                while(choicei<1 || choicei>3){
                    System.out.println("Invalid! The choice can only be 1,2 or 3");
                    System.out.println("Enter again..");
                    choicei=scan.nextInt();
                }

                //displaying the Availaable Business class seats
                System.out.println("\nSeat numbers available for Economy class booking\n");
                for (int i = 0; i < economy_src4_desti2_seats.size(); i++) {
                    System.out.println("Seat No.: "+economy_src4_desti2_seats.get(i));
                }

                //getting the seat number choice from the user
                System.out.println("\nEnter Seat No.:");
                intenationalPassengersList.get(intenationalPassengerCurrCount).seat_no=scan.nextInt();

                //validating the seat number choice
                boolean found=false;
                while(found!=true){

                    for (int i = 0; i < economy_src4_desti2_seats.size(); i++) {
                        //finding the seat and removing the seat at the same time in this condition
                        if(intenationalPassengersList.get(intenationalPassengerCurrCount).seat_no==economy_src4_desti2_seats.get(i)){
                            found=true;
                            economy_src4_desti2_seats.remove(i);

                            //after removing sorting the arraylist
                            Collections.sort(economy_src4_desti2_seats);
                        }
                    }

                    if(found==false){
                        System.out.println("Invalid! Please select a seat from the above available seats");
                        intenationalPassengersList.get(intenationalPassengerCurrCount).seat_no=scan.nextInt();
                    }
                }

                //The selected seat is being removed from the arraylist successfully
            }

            if(business_src4_desti2_seats.size()!=0 && economy_src4_desti2_seats.size()==0) {
                System.out.println("Airline:\t \tDeparture:\tArrival:\tPrice:\t\tCategory");
                System.out.println("4.Vistara(1)\t10:00\t\t14:05\t\tRs.42000\tBusiness");
                System.out.println("5.Fly Dubai(2)\t14:00\t\t18:05\t\tRs48500\t\tBusiness");
                System.out.println("6.Emirates(3)\t18:00\t\t22:05\t\tRs51259\t\tBusiness");
                System.out.println("");

                //getting the flight option from the user
                System.out.println("\nEnter your Flight choice:");
                choicei=scan.nextInt();

                //validating the choice
                while(choicei<4 || choicei>6){
                    System.out.println("Invalid! The choice can only be 4,5 or 6");
                    System.out.println("Enter again..");
                    choicei=scan.nextInt();
                }

                //displaying the Availaable Business class seats
                System.out.println("\nSeat numbers available for business class booking\n");
                for (int i = 0; i < business_src4_desti2_seats.size(); i++) {
                    System.out.println("Seat No.: "+business_src4_desti2_seats.get(i));
                }

                //getting the seat number choice from the user
                System.out.println("\nEnter Seat No.:");
                intenationalPassengersList.get(intenationalPassengerCurrCount).seat_no=scan.nextInt();

                //validating the seat number choice
                boolean found=false;
                while(found!=true){

                    for (int i = 0; i < business_src4_desti2_seats.size(); i++) {
                        //finding the seat and removing the seat at the same time in this condition
                        if(intenationalPassengersList.get(intenationalPassengerCurrCount).seat_no==business_src4_desti2_seats.get(i)){
                            found=true;
                            business_src4_desti2_seats.remove(i);

                            //after removing sorting the arraylist
                            Collections.sort(business_src4_desti2_seats);
                        }
                    }

                    if(found==false){
                        System.out.println("Invalid! Please select a seat from the above available seats");
                        intenationalPassengersList.get(intenationalPassengerCurrCount).seat_no=scan.nextInt();
                    }
                }

                //The selected seat is being removed from the arraylist successfully
            }

            //setting the src and dest variables of the passenger class because it will later help in
            //identifying in which arraylist to add the cancelled seat (seat cancelled by the passenger)
            intenationalPassengersList.get(intenationalPassengerCurrCount).src=4;
            intenationalPassengersList.get(intenationalPassengerCurrCount).dest=2;
            intenationalPassengersList.get(intenationalPassengerCurrCount).source="Singapore";
            intenationalPassengersList.get(intenationalPassengerCurrCount).destination="Dubai";


        }

        else if(srci==4 && desti==3 )//condition
        {
            //original code
            /*System.out.println("Airline:\t \tDeparture:\tArrival:\tPrice:\t\tCategory");
            System.out.println("1.Vistara(1)\t1:00\t\t4:15\t\tRs.82500\tEconomy");
            System.out.println("2.Fly Dubai(2)\t6:00\t\t21:05\t\tRs.87550\tEconomy");
            System.out.println("3.Emirates(3)\t23:00\t\t15:05\t\tRs81478\tEconomy");

            System.out.println("");
            System.out.println("Airline:\t \tDeparture:\tArrival:\tPrice:\t\tCategory");
            System.out.println("4.Vistara(1)\t1:00\t\t4:15\t\tRs.82500\tBusiness");
            System.out.println("5.Fly Dubai(2)\t6:00\t\t21:05\t\tRs.87550\tBusiness");
            System.out.println("6.Emirates(3)\t23:00\t\t15:05\t\tRs81478\tBusiness");
            */
            /////////////////////////////////////////////////////////////////////////////

            //checking the availability of the seats in the economy and business class
            if(economy_src4_desti3_seats.size()==0 && business_src4_desti3_seats.size()==0){

                char option;
                System.out.println("\nNo seats available in the business and economy class");
                System.out.println("Do you wish to make another Reservation (y/n):");
                option= scan.next().charAt(0);

                while ( (option!='y') && (option!='n') ){
                    System.out.println("Invalid! Please enter y (for yes) or n (for no)");
                    System.out.println("Enter again..");
                    option= scan.next().charAt(0);
                }

                if(option=='n'){
                    intenationalPassengersList.remove(intenationalPassengerCurrCount);
                    intenationalPassengerCurrCount--;
                    g.global--;
                    return 0;
                }

                else if(option=='y'){
                    return j_detaili();
                }

            }

            //Printing the process if these are no seats available in the economy class
            if(economy_src4_desti3_seats.size()==0){
                System.out.println("\nNo seats are available in the Economy class. Only Business class seats are avaiable");
                System.out.println("Do you wish to make another Reservation (y/n/e)");
                System.out.println("Enter 'y' to make another Reservation. Enter 'n' to continue with the business class booking");
                System.out.println("Enter e for exit");
                char option= scan.next().charAt(0);

                while ( (option!='y') && (option!='n' && (option!='e')) ){
                    System.out.println("Invalid! Please enter y (for yes) or n (for no) or e (for exit)");
                    System.out.println("Enter again..");
                    option= scan.next().charAt(0);
                }

                if(option=='e'){
                    intenationalPassengersList.remove(intenationalPassengerCurrCount);
                    intenationalPassengerCurrCount--;
                    g.global--;
                    return 0;
                }

                else if(option=='y'){
                    return j_detaili();
                }
            }

            //Printing the process if these are no seats available in the business class
            if(business_src4_desti3_seats.size()==0){
                System.out.println("\nNo seats are available in the Business class. Only Economy class seats are avaiable");
                System.out.println("Do you wish to make another Reservation (y/n/e)");
                System.out.println("Enter 'y' to make another Reservation. Enter 'n' to continue with the Economy class booking");
                System.out.println("Enter e to exit");
                char option= scan.next().charAt(0);

                while ( (option!='y') && (option!='n') && (option!='e') ){
                    System.out.println("Invalid! Please enter y (for yes) or n (for no) or e (for exit)");
                    System.out.println("Enter again..");
                    option= scan.next().charAt(0);
                }

                if(option=='e'){
                    intenationalPassengersList.remove(intenationalPassengerCurrCount);
                    intenationalPassengerCurrCount--;
                    g.global--;
                    return 0;
                }

                else if(option=='y'){
                    return j_detaili();
                }
            }

            System.out.println("\n\t \t \t \t \t \tFlights Found");
            System.out.println("");

            if( (business_src4_desti3_seats.size()!=0) && (economy_src4_desti3_seats.size()!=0) ){
                System.out.println("Airline:\t \tDeparture:\tArrival:\tPrice:\t\tCategory");
                System.out.println("1.Vistara(1)\t10:00\t\t14:05\t\tRs.17800\tEconomy");
                System.out.println("2.Fly Dubai(2)\t14:00\t\t18:05\t\tRs.14900\tEconomy");
                System.out.println("3.Emirates(3)\t18:00\t\t22:05\t\tRs.18700\tEconomy");

                System.out.println("");
                System.out.println("Airline:\t \tDeparture:\tArrival:\tPrice:\t\tCategory");
                System.out.println("4.Vistara(1)\t10:00\t\t14:05\t\tRs.27800\tBusiness");
                System.out.println("5.Fly Dubai(2)\t14:00\t\t18:05\t\tRs.24900\tBusiness");
                System.out.println("6.Emirates(3)\t18:00\t\t22:05\t\tRs.28700\tBusiness");


                //getting the flight option from the user
                System.out.println("\nEnter your Flight choice:");
                choicei=scan.nextInt();

                //validating the choice
                while(choicei<1 || choicei>6){
                    System.out.println("Invalid! The choice can only be 1,2,3,4,5 or 6");
                    System.out.println("Enter again..");
                    choicei=scan.nextInt();
                }

                //condition for selection from Economy class
                if(choicei>=1 && choicei<4){
                    //displaying the Availaable Business class seats
                    System.out.println("\nSeat numbers available for Economy class booking\n");
                    for (int i = 0; i < economy_src4_desti3_seats.size(); i++) {
                        System.out.println("Seat No.: "+economy_src4_desti3_seats.get(i));
                    }

                    //getting the seat number choice from the user
                    System.out.println("\nEnter Seat No.:");
                    intenationalPassengersList.get(intenationalPassengerCurrCount).seat_no=scan.nextInt();

                    //validating the seat number choice
                    boolean found=false;
                    while(found!=true){

                        for (int i = 0; i < economy_src4_desti3_seats.size(); i++) {
                            //finding the seat and removing the seat at the same time in this condition
                            if(intenationalPassengersList.get(intenationalPassengerCurrCount).seat_no==economy_src4_desti3_seats.get(i)){
                                found=true;
                                economy_src4_desti3_seats.remove(i);

                                //after removing sorting the arraylist
                                Collections.sort(economy_src4_desti3_seats);
                            }
                        }

                        if(found==false){
                            System.out.println("Invalid! Please select a seat from the above available seats");
                            intenationalPassengersList.get(intenationalPassengerCurrCount).seat_no=scan.nextInt();
                        }
                    }

                    //The selected seat is being removed from the arraylist successfully
                }

                //condition for selection from the business class
                if(choicei>3 && choicei<7){
                    //displaying the Availaable Business class seats
                    System.out.println("\nSeat numbers available for business class booking\n");
                    for (int i = 0; i < business_src4_desti3_seats.size(); i++) {
                        System.out.println("Seat No.: "+business_src4_desti3_seats.get(i));
                    }

                    //getting the seat number choice from the user
                    System.out.println("\nEnter Seat No.:");
                    intenationalPassengersList.get(intenationalPassengerCurrCount).seat_no=scan.nextInt();

                    //validating the seat number choice
                    boolean found=false;
                    while(found!=true){

                        for (int i = 0; i < business_src4_desti3_seats.size(); i++) {
                            //finding the seat and removing the seat at the same time in this condition
                            if(intenationalPassengersList.get(intenationalPassengerCurrCount).seat_no==business_src4_desti3_seats.get(i)){
                                found=true;
                                business_src4_desti3_seats.remove(i);

                                //after removing sorting the arraylist
                                Collections.sort(business_src4_desti3_seats);
                            }
                        }

                        if(found==false){
                            System.out.println("Invalid! Please select a seat from the above available seats");
                            intenationalPassengersList.get(intenationalPassengerCurrCount).seat_no=scan.nextInt();
                        }
                    }

                    //The selected seat is being removed from the arraylist successfully
                }
            }

            if(economy_src4_desti3_seats.size()!=0 && business_src4_desti3_seats.size()==0) {
                System.out.println("Airline:\t \tDeparture:\tArrival:\tPrice:\t\tCategory");
                System.out.println("1.Vistara(1)\t10:00\t\t14:05\t\tRs.17800\tEconomy");
                System.out.println("2.Fly Dubai(2)\t14:00\t\t18:05\t\tRs.14900\tEconomy");
                System.out.println("3.Emirates(3)\t18:00\t\t22:05\t\tRs.18700\tEconomy");
                System.out.println("");

                //getting the flight option from the user
                System.out.println("\nEnter your Flight choice:");
                choicei=scan.nextInt();

                //validating the choice
                while(choicei<1 || choicei>3){
                    System.out.println("Invalid! The choice can only be 1,2 or 3");
                    System.out.println("Enter again..");
                    choicei=scan.nextInt();
                }

                //displaying the Availaable Business class seats
                System.out.println("\nSeat numbers available for Economy class booking\n");
                for (int i = 0; i < economy_src4_desti3_seats.size(); i++) {
                    System.out.println("Seat No.: "+economy_src4_desti3_seats.get(i));
                }

                //getting the seat number choice from the user
                System.out.println("\nEnter Seat No.:");
                intenationalPassengersList.get(intenationalPassengerCurrCount).seat_no=scan.nextInt();

                //validating the seat number choice
                boolean found=false;
                while(found!=true){

                    for (int i = 0; i < economy_src4_desti3_seats.size(); i++) {
                        //finding the seat and removing the seat at the same time in this condition
                        if(intenationalPassengersList.get(intenationalPassengerCurrCount).seat_no==economy_src4_desti3_seats.get(i)){
                            found=true;
                            economy_src4_desti3_seats.remove(i);

                            //after removing sorting the arraylist
                            Collections.sort(economy_src4_desti3_seats);
                        }
                    }

                    if(found==false){
                        System.out.println("Invalid! Please select a seat from the above available seats");
                        intenationalPassengersList.get(intenationalPassengerCurrCount).seat_no=scan.nextInt();
                    }
                }

                //The selected seat is being removed from the arraylist successfully
            }

            if(business_src4_desti3_seats.size()!=0 && economy_src4_desti3_seats.size()==0) {
                System.out.println("Airline:\t \tDeparture:\tArrival:\tPrice:\t\tCategory");
                System.out.println("4.Vistara(1)\t10:00\t\t14:05\t\tRs.27800\tBusiness");
                System.out.println("5.Fly Dubai(2)\t14:00\t\t18:05\t\tRs.24900\tBusiness");
                System.out.println("6.Emirates(3)\t18:00\t\t22:05\t\tRs.28700\tBusiness");
                System.out.println("");

                //getting the flight option from the user
                System.out.println("\nEnter your Flight choice:");
                choicei=scan.nextInt();

                //validating the choice
                while(choicei<4 || choicei>6){
                    System.out.println("Invalid! The choice can only be 4,5 or 6");
                    System.out.println("Enter again..");
                    choicei=scan.nextInt();
                }

                //displaying the Availaable Business class seats
                System.out.println("\nSeat numbers available for business class booking\n");
                for (int i = 0; i < business_src4_desti3_seats.size(); i++) {
                    System.out.println("Seat No.: "+business_src4_desti3_seats.get(i));
                }

                //getting the seat number choice from the user
                System.out.println("\nEnter Seat No.:");
                intenationalPassengersList.get(intenationalPassengerCurrCount).seat_no=scan.nextInt();

                //validating the seat number choice
                boolean found=false;
                while(found!=true){

                    for (int i = 0; i < business_src4_desti3_seats.size(); i++) {
                        //finding the seat and removing the seat at the same time in this condition
                        if(intenationalPassengersList.get(intenationalPassengerCurrCount).seat_no==business_src4_desti3_seats.get(i)){
                            found=true;
                            business_src4_desti3_seats.remove(i);

                            //after removing sorting the arraylist
                            Collections.sort(business_src4_desti3_seats);
                        }
                    }

                    if(found==false){
                        System.out.println("Invalid! Please select a seat from the above available seats");
                        intenationalPassengersList.get(intenationalPassengerCurrCount).seat_no=scan.nextInt();
                    }
                }

                //The selected seat is being removed from the arraylist successfully
            }

            //setting the src and dest variables of the passenger class because it will later help in
            //identifying in which arraylist to add the cancelled seat (seat cancelled by the passenger)
            intenationalPassengersList.get(intenationalPassengerCurrCount).src=4;
            intenationalPassengersList.get(intenationalPassengerCurrCount).dest=3;
            intenationalPassengersList.get(intenationalPassengerCurrCount).source="Singapore";
            intenationalPassengersList.get(intenationalPassengerCurrCount).destination="Abu Dhabi";


        }

        else if(srci==4 && desti==5 )//condition
        {
            //original code
            /*System.out.println("Airline:\t \tDeparture:\tArrival:\tPrice:\t\tCategory");
            System.out.println("1.Vistara(1)\t7:00\t\16:05\t\tRs.50150\tEconomy");
            System.out.println("2.Fly Dubai(2)\t11:00\t\t12:40\t\tRs.47450\tEconomy");
            System.out.println("3.Emirates(3)\t3:30\t\t17:45\t\tRs52350\tEconomy");

            System.out.println("");
            System.out.println("Airline:\t \tDeparture:\tArrival:\tPrice:\t\tCategory");
            System.out.println("4.Vistara(1)\t7:00\t\16:05\t\tRs.50150\tBusiness");
            System.out.println("5.Fly Dubai(2)\t11:00\t\t12:40\t\tRs.47450\tBusiness");
            System.out.println("6.Emirates(3)\t3:30\t\t17:45\t\tRs52350\tBusiness");
            */
            /////////////////////////////////////////////////////////////////////////////

            //checking the availability of the seats in the economy and business class
            if(economy_src4_desti5_seats.size()==0 && business_src4_desti5_seats.size()==0){

                char option;
                System.out.println("\nNo seats available in the business and economy class");
                System.out.println("Do you wish to make another Reservation (y/n):");
                option= scan.next().charAt(0);

                while ( (option!='y') && (option!='n') ){
                    System.out.println("Invalid! Please enter y (for yes) or n (for no)");
                    System.out.println("Enter again..");
                    option= scan.next().charAt(0);
                }

                if(option=='n'){
                    intenationalPassengersList.remove(intenationalPassengerCurrCount);
                    intenationalPassengerCurrCount--;
                    g.global--;
                    return 0;
                }

                else if(option=='y'){
                    return j_detaili();
                }

            }

            //Printing the process if these are no seats available in the economy class
            if(economy_src4_desti5_seats.size()==0){
                System.out.println("\nNo seats are available in the Economy class. Only Business class seats are avaiable");
                System.out.println("Do you wish to make another Reservation (y/n/e)");
                System.out.println("Enter 'y' to make another Reservation. Enter 'n' to continue with the business class booking");
                System.out.println("Enter e for exit");
                char option= scan.next().charAt(0);

                while ( (option!='y') && (option!='n' && (option!='e')) ){
                    System.out.println("Invalid! Please enter y (for yes) or n (for no) or e (for exit)");
                    System.out.println("Enter again..");
                    option= scan.next().charAt(0);
                }

                if(option=='e'){
                    intenationalPassengersList.remove(intenationalPassengerCurrCount);
                    intenationalPassengerCurrCount--;
                    g.global--;
                    return 0;
                }

                else if(option=='y'){
                    return j_detaili();
                }
            }

            //Printing the process if these are no seats available in the business class
            if(business_src4_desti5_seats.size()==0){
                System.out.println("\nNo seats are available in the Business class. Only Economy class seats are avaiable");
                System.out.println("Do you wish to make another Reservation (y/n/e)");
                System.out.println("Enter 'y' to make another Reservation. Enter 'n' to continue with the Economy class booking");
                System.out.println("Enter e to exit");
                char option= scan.next().charAt(0);

                while ( (option!='y') && (option!='n') && (option!='e') ){
                    System.out.println("Invalid! Please enter y (for yes) or n (for no) or e (for exit)");
                    System.out.println("Enter again..");
                    option= scan.next().charAt(0);
                }

                if(option=='e'){
                    intenationalPassengersList.remove(intenationalPassengerCurrCount);
                    intenationalPassengerCurrCount--;
                    g.global--;
                    return 0;
                }

                else if(option=='y'){
                    return j_detaili();
                }
            }

            System.out.println("\n\t \t \t \t \t \tFlights Found");
            System.out.println("");

            if( (business_src4_desti5_seats.size()!=0) && (economy_src4_desti5_seats.size()!=0) ){
                System.out.println("Airline:\t \tDeparture:\tArrival:\tPrice:\t\tCategory");
                System.out.println("1.Vistara(1)\t7:00\t\t16:05\t\tRs.50150\tEconomy");
                System.out.println("2.Fly Dubai(2)\t11:00\t\t12:40\t\tRs.47450\tEconomy");
                System.out.println("3.Emirates(3)\t3:30\t\t17:45\t\tRs52350\t\tEconomy");

                System.out.println("");
                System.out.println("Airline:\t \tDeparture:\tArrival:\tPrice:\t\tCategory");
                System.out.println("4.Vistara(1)\t7:00\t\t16:05\t\tRs.50150\tBusiness");
                System.out.println("5.Fly Dubai(2)\t11:00\t\t12:40\t\tRs.47450\tBusiness");
                System.out.println("6.Emirates(3)\t3:30\t\t17:45\t\tRs52350\t\tBusiness");


                //getting the flight option from the user
                System.out.println("\nEnter your Flight choice:");
                choicei=scan.nextInt();

                //validating the choice
                while(choicei<1 || choicei>6){
                    System.out.println("Invalid! The choice can only be 1,2,3,4,5 or 6");
                    System.out.println("Enter again..");
                    choicei=scan.nextInt();
                }

                //condition for selection from Economy class
                if(choicei>=1 && choicei<4){
                    //displaying the Availaable Business class seats
                    System.out.println("\nSeat numbers available for Economy class booking\n");
                    for (int i = 0; i < economy_src4_desti5_seats.size(); i++) {
                        System.out.println("Seat No.: "+economy_src4_desti5_seats.get(i));
                    }

                    //getting the seat number choice from the user
                    System.out.println("\nEnter Seat No.:");
                    intenationalPassengersList.get(intenationalPassengerCurrCount).seat_no=scan.nextInt();

                    //validating the seat number choice
                    boolean found=false;
                    while(found!=true){

                        for (int i = 0; i < economy_src4_desti5_seats.size(); i++) {
                            //finding the seat and removing the seat at the same time in this condition
                            if(intenationalPassengersList.get(intenationalPassengerCurrCount).seat_no==economy_src4_desti5_seats.get(i)){
                                found=true;
                                economy_src4_desti5_seats.remove(i);

                                //after removing sorting the arraylist
                                Collections.sort(economy_src4_desti5_seats);
                            }
                        }

                        if(found==false){
                            System.out.println("Invalid! Please select a seat from the above available seats");
                            intenationalPassengersList.get(intenationalPassengerCurrCount).seat_no=scan.nextInt();
                        }
                    }

                    //The selected seat is being removed from the arraylist successfully
                }

                //condition for selection from the business class
                if(choicei>3 && choicei<7){
                    //displaying the Availaable Business class seats
                    System.out.println("\nSeat numbers available for business class booking\n");
                    for (int i = 0; i < business_src4_desti5_seats.size(); i++) {
                        System.out.println("Seat No.: "+business_src4_desti5_seats.get(i));
                    }

                    //getting the seat number choice from the user
                    System.out.println("\nEnter Seat No.:");
                    intenationalPassengersList.get(intenationalPassengerCurrCount).seat_no=scan.nextInt();

                    //validating the seat number choice
                    boolean found=false;
                    while(found!=true){

                        for (int i = 0; i < business_src4_desti5_seats.size(); i++) {
                            //finding the seat and removing the seat at the same time in this condition
                            if(intenationalPassengersList.get(intenationalPassengerCurrCount).seat_no==business_src4_desti5_seats.get(i)){
                                found=true;
                                business_src4_desti5_seats.remove(i);

                                //after removing sorting the arraylist
                                Collections.sort(business_src4_desti5_seats);
                            }
                        }

                        if(found==false){
                            System.out.println("Invalid! Please select a seat from the above available seats");
                            intenationalPassengersList.get(intenationalPassengerCurrCount).seat_no=scan.nextInt();
                        }
                    }

                    //The selected seat is being removed from the arraylist successfully
                }
            }

            if(economy_src4_desti5_seats.size()!=0 && business_src4_desti5_seats.size()==0) {
                System.out.println("Airline:\t \tDeparture:\tArrival:\tPrice:\t\tCategory");
                System.out.println("1.Vistara(1)\t7:00\t\t16:05\t\tRs.50150\tEconomy");
                System.out.println("2.Fly Dubai(2)\t11:00\t\t12:40\t\tRs.47450\tEconomy");
                System.out.println("3.Emirates(3)\t3:30\t\t17:45\t\tRs52350\t\tEconomy");

                //getting the flight option from the user
                System.out.println("\nEnter your Flight choice:");
                choicei=scan.nextInt();

                //validating the choice
                while(choicei<1 || choicei>3){
                    System.out.println("Invalid! The choice can only be 1,2 or 3");
                    System.out.println("Enter again..");
                    choicei=scan.nextInt();
                }

                //displaying the Availaable Business class seats
                System.out.println("\nSeat numbers available for Economy class booking\n");
                for (int i = 0; i < economy_src4_desti5_seats.size(); i++) {
                    System.out.println("Seat No.: "+economy_src4_desti5_seats.get(i));
                }

                //getting the seat number choice from the user
                System.out.println("\nEnter Seat No.:");
                intenationalPassengersList.get(intenationalPassengerCurrCount).seat_no=scan.nextInt();

                //validating the seat number choice
                boolean found=false;
                while(found!=true){

                    for (int i = 0; i < economy_src4_desti5_seats.size(); i++) {
                        //finding the seat and removing the seat at the same time in this condition
                        if(intenationalPassengersList.get(intenationalPassengerCurrCount).seat_no==economy_src4_desti5_seats.get(i)){
                            found=true;
                            economy_src4_desti5_seats.remove(i);

                            //after removing sorting the arraylist
                            Collections.sort(economy_src4_desti5_seats);
                        }
                    }

                    if(found==false){
                        System.out.println("Invalid! Please select a seat from the above available seats");
                        intenationalPassengersList.get(intenationalPassengerCurrCount).seat_no=scan.nextInt();
                    }
                }

                //The selected seat is being removed from the arraylist successfully
            }

            if(business_src4_desti5_seats.size()!=0 && economy_src4_desti5_seats.size()==0) {
                System.out.println("Airline:\t \tDeparture:\tArrival:\tPrice:\t\tCategory");
                System.out.println("4.Vistara(1)\t7:00\t\\t16:05\t\tRs.50150\tBusiness");
                System.out.println("5.Fly Dubai(2)\t11:00\t\t12:40\t\tRs.47450\tBusiness");
                System.out.println("6.Emirates(3)\t3:30\t\t17:45\t\tRs52350\t\tBusiness");
                System.out.println("");

                //getting the flight option from the user
                System.out.println("\nEnter your Flight choice:");
                choicei=scan.nextInt();

                //validating the choice
                while(choicei<4 || choicei>6){
                    System.out.println("Invalid! The choice can only be 4,5 or 6");
                    System.out.println("Enter again..");
                    choicei=scan.nextInt();
                }

                //displaying the Availaable Business class seats
                System.out.println("\nSeat numbers available for business class booking\n");
                for (int i = 0; i < business_src4_desti5_seats.size(); i++) {
                    System.out.println("Seat No.: "+business_src4_desti5_seats.get(i));
                }

                //getting the seat number choice from the user
                System.out.println("\nEnter Seat No.:");
                intenationalPassengersList.get(intenationalPassengerCurrCount).seat_no=scan.nextInt();

                //validating the seat number choice
                boolean found=false;
                while(found!=true){

                    for (int i = 0; i < business_src4_desti5_seats.size(); i++) {
                        //finding the seat and removing the seat at the same time in this condition
                        if(intenationalPassengersList.get(intenationalPassengerCurrCount).seat_no==business_src4_desti5_seats.get(i)){
                            found=true;
                            business_src4_desti5_seats.remove(i);

                            //after removing sorting the arraylist
                            Collections.sort(business_src4_desti5_seats);
                        }
                    }

                    if(found==false){
                        System.out.println("Invalid! Please select a seat from the above available seats");
                        intenationalPassengersList.get(intenationalPassengerCurrCount).seat_no=scan.nextInt();
                    }
                }

                //The selected seat is being removed from the arraylist successfully
            }

            //setting the src and dest variables of the passenger class because it will later help in
            //identifying in which arraylist to add the cancelled seat (seat cancelled by the passenger)
            intenationalPassengersList.get(intenationalPassengerCurrCount).src=4;
            intenationalPassengersList.get(intenationalPassengerCurrCount).dest=5;
            intenationalPassengersList.get(intenationalPassengerCurrCount).source="Singapore";
            intenationalPassengersList.get(intenationalPassengerCurrCount).destination="New York";



        }

        else if((srci==5 && desti==1) )//condition
        {
            //original code
            /*System.out.println("Airline:\t \tDeparture:\tArrival:\tPrice:\t\tCategory");
            System.out.println("1.Vistara(1)\t10:00\t\t14:05\t\tRs.52500\tEconomy");
            System.out.println("2.Fly Dubai(2)\t14:00\t\t18:05\t\tRs.59420\tEconomy");
            System.out.println("3.Emirates(3)\t18:00\t\t22:05\t\tRs.64892\tEconomy");

            System.out.println("Airline:\t \tDeparture:\tArrival:\tPrice:\t\tCategory");
            System.out.println("4.Vistara(1)\t10:00\t\t14:05\t\tRs.62500\tBusiness");
            System.out.println("5.Fly Dubai(2)\t14:00\t\t18:05\t\tRs.69420\tBusiness");
            System.out.println("6.Emirates(3)\t18:00\t\t22:05\t\tRs.74892\tBusiness");
            */
            ////////////////////////////////////////////////////////////////////////////

            //checking the availability of the seats in the economy and business class
            if(economy_src5_desti1_seats.size()==0 && business_src5_desti1_seats.size()==0){

                char option;
                System.out.println("\nNo seats available in the business and economy class");
                System.out.println("Do you wish to make another Reservation (y/n):");
                option= scan.next().charAt(0);

                while ( (option!='y') && (option!='n') ){
                    System.out.println("Invalid! Please enter y (for yes) or n (for no)");
                    System.out.println("Enter again..");
                    option= scan.next().charAt(0);
                }

                if(option=='n'){
                    intenationalPassengersList.remove(intenationalPassengerCurrCount);
                    intenationalPassengerCurrCount--;
                    g.global--;
                    return 0;
                }

                else if(option=='y'){
                    return j_detaili();
                }

            }

            //Printing the process if these are no seats available in the economy class
            if(economy_src5_desti1_seats.size()==0){
                System.out.println("\nNo seats are available in the Economy class. Only Business class seats are avaiable");
                System.out.println("Do you wish to make another Reservation (y/n/e)");
                System.out.println("Enter 'y' to make another Reservation. Enter 'n' to continue with the business class booking");
                System.out.println("Enter e for exit");
                char option= scan.next().charAt(0);

                while ( (option!='y') && (option!='n' && (option!='e')) ){
                    System.out.println("Invalid! Please enter y (for yes) or n (for no) or e (for exit)");
                    System.out.println("Enter again..");
                    option= scan.next().charAt(0);
                }

                if(option=='e'){
                    intenationalPassengersList.remove(intenationalPassengerCurrCount);
                    intenationalPassengerCurrCount--;
                    g.global--;
                    return 0;
                }

                else if(option=='y'){
                    return j_detaili();
                }
            }

            //Printing the process if these are no seats available in the business class
            if(business_src5_desti1_seats.size()==0){
                System.out.println("\nNo seats are available in the Business class. Only Economy class seats are avaiable");
                System.out.println("Do you wish to make another Reservation (y/n/e)");
                System.out.println("Enter 'y' to make another Reservation. Enter 'n' to continue with the Economy class booking");
                System.out.println("Enter e to exit");
                char option= scan.next().charAt(0);

                while ( (option!='y') && (option!='n') && (option!='e') ){
                    System.out.println("Invalid! Please enter y (for yes) or n (for no) or e (for exit)");
                    System.out.println("Enter again..");
                    option= scan.next().charAt(0);
                }

                if(option=='e'){
                    intenationalPassengersList.remove(intenationalPassengerCurrCount);
                    intenationalPassengerCurrCount--;
                    g.global--;
                    return 0;
                }

                else if(option=='y'){
                    return j_detaili();
                }
            }

            System.out.println("\n\t \t \t \t \t \tFlights Found");
            System.out.println("");

            if( (business_src5_desti1_seats.size()!=0) && (economy_src5_desti1_seats.size()!=0) ){
                System.out.println("Airline:\t \tDeparture:\tArrival:\tPrice:\t\tCategory");
                System.out.println("1.Vistara(1)\t10:00\t\t14:05\t\tRs.52500\tEconomy");
                System.out.println("2.Fly Dubai(2)\t14:00\t\t18:05\t\tRs.59420\tEconomy");
                System.out.println("3.Emirates(3)\t18:00\t\t22:05\t\tRs.64892\tEconomy");

                System.out.println("");
                System.out.println("Airline:\t \tDeparture:\tArrival:\tPrice:\t\tCategory");
                System.out.println("4.Vistara(1)\t10:00\t\t14:05\t\tRs.62500\tBusiness");
                System.out.println("5.Fly Dubai(2)\t14:00\t\t18:05\t\tRs.69420\tBusiness");
                System.out.println("6.Emirates(3)\t18:00\t\t22:05\t\tRs.74892\tBusiness");


                //getting the flight option from the user
                System.out.println("\nEnter your Flight choice:");
                choicei=scan.nextInt();

                //validating the choice
                while(choicei<1 || choicei>6){
                    System.out.println("Invalid! The choice can only be 1,2,3,4,5 or 6");
                    System.out.println("Enter again..");
                    choicei=scan.nextInt();
                }

                //condition for selection from Economy class
                if(choicei>=1 && choicei<4){
                    //displaying the Availaable Business class seats
                    System.out.println("\nSeat numbers available for Economy class booking\n");
                    for (int i = 0; i < economy_src5_desti1_seats.size(); i++) {
                        System.out.println("Seat No.: "+economy_src5_desti1_seats.get(i));
                    }

                    //getting the seat number choice from the user
                    System.out.println("\nEnter Seat No.:");
                    intenationalPassengersList.get(intenationalPassengerCurrCount).seat_no=scan.nextInt();

                    //validating the seat number choice
                    boolean found=false;
                    while(found!=true){

                        for (int i = 0; i < economy_src5_desti1_seats.size(); i++) {
                            //finding the seat and removing the seat at the same time in this condition
                            if(intenationalPassengersList.get(intenationalPassengerCurrCount).seat_no==economy_src5_desti1_seats.get(i)){
                                found=true;
                                economy_src5_desti1_seats.remove(i);

                                //after removing sorting the arraylist
                                Collections.sort(economy_src5_desti1_seats);
                            }
                        }

                        if(found==false){
                            System.out.println("Invalid! Please select a seat from the above available seats");
                            intenationalPassengersList.get(intenationalPassengerCurrCount).seat_no=scan.nextInt();
                        }
                    }

                    //The selected seat is being removed from the arraylist successfully
                }

                //condition for selection from the business class
                if(choicei>3 && choicei<7){
                    //displaying the Availaable Business class seats
                    System.out.println("\nSeat numbers available for business class booking\n");
                    for (int i = 0; i < business_src5_desti1_seats.size(); i++) {
                        System.out.println("Seat No.: "+business_src5_desti1_seats.get(i));
                    }

                    //getting the seat number choice from the user
                    System.out.println("\nEnter Seat No.:");
                    intenationalPassengersList.get(intenationalPassengerCurrCount).seat_no=scan.nextInt();

                    //validating the seat number choice
                    boolean found=false;
                    while(found!=true){

                        for (int i = 0; i < business_src5_desti1_seats.size(); i++) {
                            //finding the seat and removing the seat at the same time in this condition
                            if(intenationalPassengersList.get(intenationalPassengerCurrCount).seat_no==business_src5_desti1_seats.get(i)){
                                found=true;
                                business_src5_desti1_seats.remove(i);

                                //after removing sorting the arraylist
                                Collections.sort(business_src5_desti1_seats);
                            }
                        }

                        if(found==false){
                            System.out.println("Invalid! Please select a seat from the above available seats");
                            intenationalPassengersList.get(intenationalPassengerCurrCount).seat_no=scan.nextInt();
                        }
                    }

                    //The selected seat is being removed from the arraylist successfully
                }
            }

            if(economy_src5_desti1_seats.size()!=0 && business_src5_desti1_seats.size()==0) {
                System.out.println("Airline:\t \tDeparture:\tArrival:\tPrice:\t\tCategory");
                System.out.println("1.Vistara(1)\t10:00\t\t14:05\t\tRs.52500\tEconomy");
                System.out.println("2.Fly Dubai(2)\t14:00\t\t18:05\t\tRs.59420\tEconomy");
                System.out.println("3.Emirates(3)\t18:00\t\t22:05\t\tRs.64892\tEconomy");
                System.out.println("");

                //getting the flight option from the user
                System.out.println("\nEnter your Flight choice:");
                choicei=scan.nextInt();

                //validating the choice
                while(choicei<1 || choicei>3){
                    System.out.println("Invalid! The choice can only be 1,2 or 3");
                    System.out.println("Enter again..");
                    choicei=scan.nextInt();
                }

                //displaying the Availaable Business class seats
                System.out.println("\nSeat numbers available for Economy class booking\n");
                for (int i = 0; i < economy_src5_desti1_seats.size(); i++) {
                    System.out.println("Seat No.: "+economy_src5_desti1_seats.get(i));
                }

                //getting the seat number choice from the user
                System.out.println("\nEnter Seat No.:");
                intenationalPassengersList.get(intenationalPassengerCurrCount).seat_no=scan.nextInt();

                //validating the seat number choice
                boolean found=false;
                while(found!=true){

                    for (int i = 0; i < economy_src5_desti1_seats.size(); i++) {
                        //finding the seat and removing the seat at the same time in this condition
                        if(intenationalPassengersList.get(intenationalPassengerCurrCount).seat_no==economy_src5_desti1_seats.get(i)){
                            found=true;
                            economy_src5_desti1_seats.remove(i);

                            //after removing sorting the arraylist
                            Collections.sort(economy_src5_desti1_seats);
                        }
                    }

                    if(found==false){
                        System.out.println("Invalid! Please select a seat from the above available seats");
                        intenationalPassengersList.get(intenationalPassengerCurrCount).seat_no=scan.nextInt();
                    }
                }

                //The selected seat is being removed from the arraylist successfully
            }

            if(business_src5_desti1_seats.size()!=0 && economy_src5_desti1_seats.size()==0) {
                System.out.println("Airline:\t \tDeparture:\tArrival:\tPrice:\t\tCategory");
                System.out.println("4.Vistara(1)\t10:00\t\t14:05\t\tRs.62500\tBusiness");
                System.out.println("5.Fly Dubai(2)\t14:00\t\t18:05\t\tRs.69420\tBusiness");
                System.out.println("6.Emirates(3)\t18:00\t\t22:05\t\tRs.74892\tBusiness");

                System.out.println("");

                //getting the flight option from the user
                System.out.println("\nEnter your Flight choice:");
                choicei=scan.nextInt();

                //validating the choice
                while(choicei<4 || choicei>6){
                    System.out.println("Invalid! The choice can only be 4,5 or 6");
                    System.out.println("Enter again..");
                    choicei=scan.nextInt();
                }

                //displaying the Availaable Business class seats
                System.out.println("\nSeat numbers available for business class booking\n");
                for (int i = 0; i < business_src5_desti1_seats.size(); i++) {
                    System.out.println("Seat No.: "+business_src5_desti1_seats.get(i));
                }

                //getting the seat number choice from the user
                System.out.println("\nEnter Seat No.:");
                intenationalPassengersList.get(intenationalPassengerCurrCount).seat_no=scan.nextInt();

                //validating the seat number choice
                boolean found=false;
                while(found!=true){

                    for (int i = 0; i < business_src5_desti1_seats.size(); i++) {
                        //finding the seat and removing the seat at the same time in this condition
                        if(intenationalPassengersList.get(intenationalPassengerCurrCount).seat_no==business_src5_desti1_seats.get(i)){
                            found=true;
                            business_src5_desti1_seats.remove(i);

                            //after removing sorting the arraylist
                            Collections.sort(business_src5_desti1_seats);
                        }
                    }

                    if(found==false){
                        System.out.println("Invalid! Please select a seat from the above available seats");
                        intenationalPassengersList.get(intenationalPassengerCurrCount).seat_no=scan.nextInt();
                    }
                }

                //The selected seat is being removed from the arraylist successfully
            }

            //setting the src and dest variables of the passenger class because it will later help in
            //identifying in which arraylist to add the cancelled seat (seat cancelled by the passenger)
            intenationalPassengersList.get(intenationalPassengerCurrCount).src=5;
            intenationalPassengersList.get(intenationalPassengerCurrCount).dest=1;
            intenationalPassengersList.get(intenationalPassengerCurrCount).source="NewYork";
            intenationalPassengersList.get(intenationalPassengerCurrCount).destination="London";


        }

        else if(srci==5 && desti==2 )//condition
        {
            //original code
            /*System.out.println("Airline:\t \tDeparture:\tArrival:\tPrice:\t\tCategory");
            System.out.println("1.Vistara(1)\t10:00\t\t14:05\t\tRs.82500\tEconomy");
            System.out.println("2.Fly Dubai(2)\t14:00\t\t18:05\t\tRs.87550\tEconomy");
            System.out.println("3.Emirates(3)\t18:00\t\t22:05\t\tRs81478\tEconomy");

            System.out.println("");
            System.out.println("Airline:\t \tDeparture:\tArrival:\tPrice:\t\tCategory");
            System.out.println("4.Vistara(1)\t10:00\t\t14:05\t\tRs.92500\tBusiness");
            System.out.println("5.Fly Dubai(2)\t14:00\t\t18:05\t\tRs.97550\tBusiness");
            System.out.println("6.Emirates(3)\t18:00\t\t22:05\t\tRs91478\tBusiness");
            */
            ///////////////////////////////////////////////////////////////////////////

            //checking the availability of the seats in the economy and business class
            if(economy_src5_desti2_seats.size()==0 && business_src5_desti2_seats.size()==0){

                char option;
                System.out.println("\nNo seats available in the business and economy class");
                System.out.println("Do you wish to make another Reservation (y/n):");
                option= scan.next().charAt(0);

                while ( (option!='y') && (option!='n') ){
                    System.out.println("Invalid! Please enter y (for yes) or n (for no)");
                    System.out.println("Enter again..");
                    option= scan.next().charAt(0);
                }

                if(option=='n'){
                    intenationalPassengersList.remove(intenationalPassengerCurrCount);
                    intenationalPassengerCurrCount--;
                    g.global--;
                    return 0;
                }

                else if(option=='y'){
                    return j_detaili();
                }

            }

            //Printing the process if these are no seats available in the economy class
            if(economy_src5_desti2_seats.size()==0){
                System.out.println("\nNo seats are available in the Economy class. Only Business class seats are avaiable");
                System.out.println("Do you wish to make another Reservation (y/n/e)");
                System.out.println("Enter 'y' to make another Reservation. Enter 'n' to continue with the business class booking");
                System.out.println("Enter e for exit");
                char option= scan.next().charAt(0);

                while ( (option!='y') && (option!='n' && (option!='e')) ){
                    System.out.println("Invalid! Please enter y (for yes) or n (for no) or e (for exit)");
                    System.out.println("Enter again..");
                    option= scan.next().charAt(0);
                }

                if(option=='e'){
                    intenationalPassengersList.remove(intenationalPassengerCurrCount);
                    intenationalPassengerCurrCount--;
                    g.global--;
                    return 0;
                }

                else if(option=='y'){
                    return j_detaili();
                }
            }

            //Printing the process if these are no seats available in the business class
            if(business_src5_desti2_seats.size()==0){
                System.out.println("\nNo seats are available in the Business class. Only Economy class seats are avaiable");
                System.out.println("Do you wish to make another Reservation (y/n/e)");
                System.out.println("Enter 'y' to make another Reservation. Enter 'n' to continue with the Economy class booking");
                System.out.println("Enter e to exit");
                char option= scan.next().charAt(0);

                while ( (option!='y') && (option!='n') && (option!='e') ){
                    System.out.println("Invalid! Please enter y (for yes) or n (for no) or e (for exit)");
                    System.out.println("Enter again..");
                    option= scan.next().charAt(0);
                }

                if(option=='e'){
                    intenationalPassengersList.remove(intenationalPassengerCurrCount);
                    intenationalPassengerCurrCount--;
                    g.global--;
                    return 0;
                }

                else if(option=='y'){
                    return j_detaili();
                }
            }

            System.out.println("\n\t \t \t \t \t \tFlights Found");
            System.out.println("");

            if( (business_src5_desti2_seats.size()!=0) && (economy_src5_desti2_seats.size()!=0) ){
                System.out.println("Airline:\t \tDeparture:\tArrival:\tPrice:\t\tCategory");
                System.out.println("1.Vistara(1)\t10:00\t\t14:05\t\tRs.82500\tEconomy");
                System.out.println("2.Fly Dubai(2)\t14:00\t\t18:05\t\tRs.87550\tEconomy");
                System.out.println("3.Emirates(3)\t18:00\t\t22:05\t\tRs81478\t\tEconomy");

                System.out.println("");
                System.out.println("Airline:\t \tDeparture:\tArrival:\tPrice:\t\tCategory");
                System.out.println("4.Vistara(1)\t10:00\t\t14:05\t\tRs.92500\tBusiness");
                System.out.println("5.Fly Dubai(2)\t14:00\t\t18:05\t\tRs.97550\tBusiness");
                System.out.println("6.Emirates(3)\t18:00\t\t22:05\t\tRs91478\t\tBusiness");


                //getting the flight option from the user
                System.out.println("\nEnter your Flight choice:");
                choicei=scan.nextInt();

                //validating the choice
                while(choicei<1 || choicei>6){
                    System.out.println("Invalid! The choice can only be 1,2,3,4,5 or 6");
                    System.out.println("Enter again..");
                    choicei=scan.nextInt();
                }

                //condition for selection from Economy class
                if(choicei>=1 && choicei<4){
                    //displaying the Availaable Business class seats
                    System.out.println("\nSeat numbers available for Economy class booking\n");
                    for (int i = 0; i < economy_src5_desti2_seats.size(); i++) {
                        System.out.println("Seat No.: "+economy_src5_desti2_seats.get(i));
                    }

                    //getting the seat number choice from the user
                    System.out.println("\nEnter Seat No.:");
                    intenationalPassengersList.get(intenationalPassengerCurrCount).seat_no=scan.nextInt();

                    //validating the seat number choice
                    boolean found=false;
                    while(found!=true){

                        for (int i = 0; i < economy_src5_desti2_seats.size(); i++) {
                            //finding the seat and removing the seat at the same time in this condition
                            if(intenationalPassengersList.get(intenationalPassengerCurrCount).seat_no==economy_src5_desti2_seats.get(i)){
                                found=true;
                                economy_src5_desti2_seats.remove(i);

                                //after removing sorting the arraylist
                                Collections.sort(economy_src5_desti2_seats);
                            }
                        }

                        if(found==false){
                            System.out.println("Invalid! Please select a seat from the above available seats");
                            intenationalPassengersList.get(intenationalPassengerCurrCount).seat_no=scan.nextInt();
                        }
                    }

                    //The selected seat is being removed from the arraylist successfully
                }

                //condition for selection from the business class
                if(choicei>3 && choicei<7){
                    //displaying the Availaable Business class seats
                    System.out.println("\nSeat numbers available for business class booking\n");
                    for (int i = 0; i < business_src5_desti2_seats.size(); i++) {
                        System.out.println("Seat No.: "+business_src5_desti2_seats.get(i));
                    }

                    //getting the seat number choice from the user
                    System.out.println("\nEnter Seat No.:");
                    intenationalPassengersList.get(intenationalPassengerCurrCount).seat_no=scan.nextInt();

                    //validating the seat number choice
                    boolean found=false;
                    while(found!=true){

                        for (int i = 0; i < business_src5_desti2_seats.size(); i++) {
                            //finding the seat and removing the seat at the same time in this condition
                            if(intenationalPassengersList.get(intenationalPassengerCurrCount).seat_no==business_src5_desti2_seats.get(i)){
                                found=true;
                                business_src5_desti2_seats.remove(i);

                                //after removing sorting the arraylist
                                Collections.sort(business_src5_desti2_seats);
                            }
                        }

                        if(found==false){
                            System.out.println("Invalid! Please select a seat from the above available seats");
                            intenationalPassengersList.get(intenationalPassengerCurrCount).seat_no=scan.nextInt();
                        }
                    }

                    //The selected seat is being removed from the arraylist successfully
                }
            }

            if(economy_src5_desti2_seats.size()!=0 && business_src5_desti2_seats.size()==0) {
                System.out.println("Airline:\t \tDeparture:\tArrival:\tPrice:\t\tCategory");
                System.out.println("1.Vistara(1)\t10:00\t\t14:05\t\tRs.82500\tEconomy");
                System.out.println("2.Fly Dubai(2)\t14:00\t\t18:05\t\tRs.87550\tEconomy");
                System.out.println("3.Emirates(3)\t18:00\t\t22:05\t\tRs81478\t\tEconomy");

                System.out.println("");

                //getting the flight option from the user
                System.out.println("\nEnter your Flight choice:");
                choicei=scan.nextInt();

                //validating the choice
                while(choicei<1 || choicei>3){
                    System.out.println("Invalid! The choice can only be 1,2 or 3");
                    System.out.println("Enter again..");
                    choicei=scan.nextInt();
                }

                //displaying the Availaable Business class seats
                System.out.println("\nSeat numbers available for Economy class booking\n");
                for (int i = 0; i < economy_src5_desti2_seats.size(); i++) {
                    System.out.println("Seat No.: "+economy_src5_desti2_seats.get(i));
                }

                //getting the seat number choice from the user
                System.out.println("\nEnter Seat No.:");
                intenationalPassengersList.get(intenationalPassengerCurrCount).seat_no=scan.nextInt();

                //validating the seat number choice
                boolean found=false;
                while(found!=true){

                    for (int i = 0; i < economy_src5_desti2_seats.size(); i++) {
                        //finding the seat and removing the seat at the same time in this condition
                        if(intenationalPassengersList.get(intenationalPassengerCurrCount).seat_no==economy_src5_desti2_seats.get(i)){
                            found=true;
                            economy_src5_desti2_seats.remove(i);

                            //after removing sorting the arraylist
                            Collections.sort(economy_src5_desti2_seats);
                        }
                    }

                    if(found==false){
                        System.out.println("Invalid! Please select a seat from the above available seats");
                        intenationalPassengersList.get(intenationalPassengerCurrCount).seat_no=scan.nextInt();
                    }
                }

                //The selected seat is being removed from the arraylist successfully
            }

            if(business_src5_desti2_seats.size()!=0 && economy_src5_desti2_seats.size()==0) {
                System.out.println("Airline:\t \tDeparture:\tArrival:\tPrice:\t\tCategory");
                System.out.println("4.Vistara(1)\t10:00\t\t14:05\t\tRs.92500\tBusiness");
                System.out.println("5.Fly Dubai(2)\t14:00\t\t18:05\t\tRs.97550\tBusiness");
                System.out.println("6.Emirates(3)\t18:00\t\t22:05\t\tRs91478\t\tBusiness");
                System.out.println("");

                //getting the flight option from the user
                System.out.println("\nEnter your Flight choice:");
                choicei=scan.nextInt();

                //validating the choice
                while(choicei<4 || choicei>6){
                    System.out.println("Invalid! The choice can only be 4,5 or 6");
                    System.out.println("Enter again..");
                    choicei=scan.nextInt();
                }

                //displaying the Availaable Business class seats
                System.out.println("\nSeat numbers available for business class booking\n");
                for (int i = 0; i < business_src5_desti2_seats.size(); i++) {
                    System.out.println("Seat No.: "+business_src5_desti2_seats.get(i));
                }

                //getting the seat number choice from the user
                System.out.println("\nEnter Seat No.:");
                intenationalPassengersList.get(intenationalPassengerCurrCount).seat_no=scan.nextInt();

                //validating the seat number choice
                boolean found=false;
                while(found!=true){

                    for (int i = 0; i < business_src5_desti2_seats.size(); i++) {
                        //finding the seat and removing the seat at the same time in this condition
                        if(intenationalPassengersList.get(intenationalPassengerCurrCount).seat_no==business_src5_desti2_seats.get(i)){
                            found=true;
                            business_src5_desti2_seats.remove(i);

                            //after removing sorting the arraylist
                            Collections.sort(business_src5_desti2_seats);
                        }
                    }

                    if(found==false){
                        System.out.println("Invalid! Please select a seat from the above available seats");
                        intenationalPassengersList.get(intenationalPassengerCurrCount).seat_no=scan.nextInt();
                    }
                }

                //The selected seat is being removed from the arraylist successfully
            }

            //setting the src and dest variables of the passenger class because it will later help in
            //identifying in which arraylist to add the cancelled seat (seat cancelled by the passenger)
            intenationalPassengersList.get(intenationalPassengerCurrCount).src=5;
            intenationalPassengersList.get(intenationalPassengerCurrCount).dest=2;
            intenationalPassengersList.get(intenationalPassengerCurrCount).source="New York";
            intenationalPassengersList.get(intenationalPassengerCurrCount).destination="Dubai";


        }

        else if(srci==5 && desti==3 )//condition
        {
            //original code

            /*System.out.println("Airline:\t \tDeparture:\tArrival:\tPrice:\t\tCategory");
            System.out.println("1.Vistara(1)\t5:00\t\18:05\t\tRs.91750\tEconomy");
            System.out.println("2.Fly Dubai(2)\t11:00\t\t4:40\t\tRs.96450\tEconomy");
            System.out.println("3.Emirates(3)\t14:30\t\t7:45\t\tRs98360\tEconomy");

            System.out.println("");
            System.out.println("Airline:\t \tDeparture:\tArrival:\tPrice:\t\tCategory");
            System.out.println("4.Vistara(1)\t5:00\t\18:05\t\tRs.1,01,750\tBusiness");
            System.out.println("5.Fly Dubai(2)\t11:00\t\t4:40\t\tRs.1,06,450\tBusiness");
            System.out.println("6.Emirates(3)\t14:30\t\t7:45\t\tRs1,08,360\tBusiness");
            */
            ///////////////////////////////////////////////////////////////////////////

            //checking the availability of the seats in the economy and business class
            if(economy_src5_desti3_seats.size()==0 && business_src5_desti3_seats.size()==0){

                char option;
                System.out.println("\nNo seats available in the business and economy class");
                System.out.println("Do you wish to make another Reservation (y/n):");
                option= scan.next().charAt(0);

                while ( (option!='y') && (option!='n') ){
                    System.out.println("Invalid! Please enter y (for yes) or n (for no)");
                    System.out.println("Enter again..");
                    option= scan.next().charAt(0);
                }

                if(option=='n'){
                    intenationalPassengersList.remove(intenationalPassengerCurrCount);
                    intenationalPassengerCurrCount--;
                    g.global--;
                    return 0;
                }

                else if(option=='y'){
                    return j_detaili();
                }

            }

            //Printing the process if these are no seats available in the economy class
            if(economy_src5_desti3_seats.size()==0){
                System.out.println("\nNo seats are available in the Economy class. Only Business class seats are avaiable");
                System.out.println("Do you wish to make another Reservation (y/n/e)");
                System.out.println("Enter 'y' to make another Reservation. Enter 'n' to continue with the business class booking");
                System.out.println("Enter e for exit");
                char option= scan.next().charAt(0);

                while ( (option!='y') && (option!='n' && (option!='e')) ){
                    System.out.println("Invalid! Please enter y (for yes) or n (for no) or e (for exit)");
                    System.out.println("Enter again..");
                    option= scan.next().charAt(0);
                }

                if(option=='e'){
                    intenationalPassengersList.remove(intenationalPassengerCurrCount);
                    intenationalPassengerCurrCount--;
                    g.global--;
                    return 0;
                }

                else if(option=='y'){
                    return j_detaili();
                }
            }

            //Printing the process if these are no seats available in the business class
            if(business_src5_desti3_seats.size()==0){
                System.out.println("\nNo seats are available in the Business class. Only Economy class seats are avaiable");
                System.out.println("Do you wish to make another Reservation (y/n/e)");
                System.out.println("Enter 'y' to make another Reservation. Enter 'n' to continue with the Economy class booking");
                System.out.println("Enter e to exit");
                char option= scan.next().charAt(0);

                while ( (option!='y') && (option!='n') && (option!='e') ){
                    System.out.println("Invalid! Please enter y (for yes) or n (for no) or e (for exit)");
                    System.out.println("Enter again..");
                    option= scan.next().charAt(0);
                }

                if(option=='e'){
                    intenationalPassengersList.remove(intenationalPassengerCurrCount);
                    intenationalPassengerCurrCount--;
                    g.global--;
                    return 0;
                }

                else if(option=='y'){
                    return j_detaili();
                }
            }

            System.out.println("\n\t \t \t \t \t \tFlights Found");
            System.out.println("");

            if( (business_src5_desti3_seats.size()!=0) && (economy_src5_desti3_seats.size()!=0) ){
                System.out.println("1.Vistara(1)\t5:00\t\t18:05\t\tRs.91750\tEconomy");
                System.out.println("2.Fly Dubai(2)\t11:00\t\t4:40\t\tRs.96450\tEconomy");
                System.out.println("3.Emirates(3)\t14:30\t\t7:45\t\tRs.98360\t\tEconomy");

                System.out.println("");
                System.out.println("Airline:\t \tDeparture:\tArrival:\tPrice:\t\tCategory");
                System.out.println("4.Vistara(1)\t5:00\t\t18:05\t\tRs.1,01,750\tBusiness");
                System.out.println("5.Fly Dubai(2)\t11:00\t\t4:40\t\tRs.1,06,450\tBusiness");
                System.out.println("6.Emirates(3)\t14:30\t\t7:45\t\tRs.1,08,360\tBusiness");


                //getting the flight option from the user
                System.out.println("\nEnter your Flight choice:");
                choicei=scan.nextInt();

                //validating the choice
                while(choicei<1 || choicei>6){
                    System.out.println("Invalid! The choice can only be 1,2,3,4,5 or 6");
                    System.out.println("Enter again..");
                    choicei=scan.nextInt();
                }

                //condition for selection from Economy class
                if(choicei>=1 && choicei<4){
                    //displaying the Availaable Business class seats
                    System.out.println("\nSeat numbers available for Economy class booking\n");
                    for (int i = 0; i < economy_src5_desti3_seats.size(); i++) {
                        System.out.println("Seat No.: "+economy_src5_desti3_seats.get(i));
                    }

                    //getting the seat number choice from the user
                    System.out.println("\nEnter Seat No.:");
                    intenationalPassengersList.get(intenationalPassengerCurrCount).seat_no=scan.nextInt();

                    //validating the seat number choice
                    boolean found=false;
                    while(found!=true){

                        for (int i = 0; i < economy_src5_desti3_seats.size(); i++) {
                            //finding the seat and removing the seat at the same time in this condition
                            if(intenationalPassengersList.get(intenationalPassengerCurrCount).seat_no==economy_src5_desti3_seats.get(i)){
                                found=true;
                                economy_src5_desti3_seats.remove(i);

                                //after removing sorting the arraylist
                                Collections.sort(economy_src5_desti3_seats);
                            }
                        }

                        if(found==false){
                            System.out.println("Invalid! Please select a seat from the above available seats");
                            intenationalPassengersList.get(intenationalPassengerCurrCount).seat_no=scan.nextInt();
                        }
                    }

                    //The selected seat is being removed from the arraylist successfully
                }

                //condition for selection from the business class
                if(choicei>3 && choicei<7){
                    //displaying the Availaable Business class seats
                    System.out.println("\nSeat numbers available for business class booking\n");
                    for (int i = 0; i < business_src5_desti3_seats.size(); i++) {
                        System.out.println("Seat No.: "+business_src5_desti3_seats.get(i));
                    }

                    //getting the seat number choice from the user
                    System.out.println("\nEnter Seat No.:");
                    intenationalPassengersList.get(intenationalPassengerCurrCount).seat_no=scan.nextInt();

                    //validating the seat number choice
                    boolean found=false;
                    while(found!=true){

                        for (int i = 0; i < business_src5_desti3_seats.size(); i++) {
                            //finding the seat and removing the seat at the same time in this condition
                            if(intenationalPassengersList.get(intenationalPassengerCurrCount).seat_no==business_src5_desti3_seats.get(i)){
                                found=true;
                                business_src5_desti3_seats.remove(i);

                                //after removing sorting the arraylist
                                Collections.sort(business_src5_desti3_seats);
                            }
                        }

                        if(found==false){
                            System.out.println("Invalid! Please select a seat from the above available seats");
                            intenationalPassengersList.get(intenationalPassengerCurrCount).seat_no=scan.nextInt();
                        }
                    }

                    //The selected seat is being removed from the arraylist successfully
                }
            }

            if(economy_src5_desti3_seats.size()!=0 && business_src5_desti3_seats.size()==0) {
                System.out.println("1.Vistara(1)\t5:00\t\t8:05\t\tRs.91750\tEconomy");
                System.out.println("2.Fly Dubai(2)\t11:00\t\t4:40\t\tRs.96450\tEconomy");
                System.out.println("3.Emirates(3)\t14:30\t\t7:45\t\tRs.98360\t\tEconomy");
                System.out.println("");

                //getting the flight option from the user
                System.out.println("\nEnter your Flight choice:");
                choicei=scan.nextInt();

                //validating the choice
                while(choicei<1 || choicei>3){
                    System.out.println("Invalid! The choice can only be 1,2 or 3");
                    System.out.println("Enter again..");
                    choicei=scan.nextInt();
                }

                //displaying the Availaable Business class seats
                System.out.println("\nSeat numbers available for Economy class booking\n");
                for (int i = 0; i < economy_src5_desti3_seats.size(); i++) {
                    System.out.println("Seat No.: "+economy_src5_desti3_seats.get(i));
                }

                //getting the seat number choice from the user
                System.out.println("\nEnter Seat No.:");
                intenationalPassengersList.get(intenationalPassengerCurrCount).seat_no=scan.nextInt();

                //validating the seat number choice
                boolean found=false;
                while(found!=true){

                    for (int i = 0; i < economy_src5_desti3_seats.size(); i++) {
                        //finding the seat and removing the seat at the same time in this condition
                        if(intenationalPassengersList.get(intenationalPassengerCurrCount).seat_no==economy_src5_desti3_seats.get(i)){
                            found=true;
                            economy_src5_desti3_seats.remove(i);

                            //after removing sorting the arraylist
                            Collections.sort(economy_src5_desti3_seats);
                        }
                    }

                    if(found==false){
                        System.out.println("Invalid! Please select a seat from the above available seats");
                        intenationalPassengersList.get(intenationalPassengerCurrCount).seat_no=scan.nextInt();
                    }
                }

                //The selected seat is being removed from the arraylist successfully
            }

            if(business_src5_desti3_seats.size()!=0 && economy_src5_desti3_seats.size()==0) {
                System.out.println("Airline:\t \tDeparture:\tArrival:\tPrice:\t\tCategory");
                System.out.println("4.Vistara(1)\t5:00\t\t8:05\t\tRs.1,01,750\tBusiness");
                System.out.println("5.Fly Dubai(2)\t11:00\t\t4:40\t\tRs.1,06,450\tBusiness");
                System.out.println("6.Emirates(3)\t14:30\t\t7:45\t\tRs.1,08,360\tBusiness");
                System.out.println("");

                //getting the flight option from the user
                System.out.println("\nEnter your Flight choice:");
                choicei=scan.nextInt();

                //validating the choice
                while(choicei<4 || choicei>6){
                    System.out.println("Invalid! The choice can only be 4,5 or 6");
                    System.out.println("Enter again..");
                    choicei=scan.nextInt();
                }

                //displaying the Availaable Business class seats
                System.out.println("\nSeat numbers available for business class booking\n");
                for (int i = 0; i < business_src5_desti3_seats.size(); i++) {
                    System.out.println("Seat No.: "+business_src5_desti3_seats.get(i));
                }

                //getting the seat number choice from the user
                System.out.println("\nEnter Seat No.:");
                intenationalPassengersList.get(intenationalPassengerCurrCount).seat_no=scan.nextInt();

                //validating the seat number choice
                boolean found=false;
                while(found!=true){

                    for (int i = 0; i < business_src5_desti3_seats.size(); i++) {
                        //finding the seat and removing the seat at the same time in this condition
                        if(intenationalPassengersList.get(intenationalPassengerCurrCount).seat_no==business_src5_desti3_seats.get(i)){
                            found=true;
                            business_src5_desti3_seats.remove(i);

                            //after removing sorting the arraylist
                            Collections.sort(business_src5_desti3_seats);
                        }
                    }

                    if(found==false){
                        System.out.println("Invalid! Please select a seat from the above available seats");
                        intenationalPassengersList.get(intenationalPassengerCurrCount).seat_no=scan.nextInt();
                    }
                }

                //The selected seat is being removed from the arraylist successfully
            }

            //setting the src and dest variables of the passenger class because it will later help in
            //identifying in which arraylist to add the cancelled seat (seat cancelled by the passenger)
            intenationalPassengersList.get(intenationalPassengerCurrCount).src=5;
            intenationalPassengersList.get(intenationalPassengerCurrCount).dest=3;
            intenationalPassengersList.get(intenationalPassengerCurrCount).source="New York";
            intenationalPassengersList.get(intenationalPassengerCurrCount).destination="Abu Dhabi";



        }

        else if(srci==5 && desti==4 )//condition
        {
            //original code
            /*System.out.println("Airline:\t \tDeparture:\tArrival:\tPrice:\t\tCategory");
            System.out.println("1.Vistara(1)\t7:00\t\16:05\t\tRs.50150\tEconomy");
            System.out.println("2.Fly Dubai(2)\t11:00\t\t12:40\t\tRs.47450\tEconomy");
            System.out.println("3.Emirates(3)\t3:30\t\t17:45\t\tRs52350\tEconomy");

            System.out.println("");
            System.out.println("Airline:\t \tDeparture:\tArrival:\tPrice:\t\tCategory");
            System.out.println("4.Vistara(1)\t7:00\t\16:05\t\tRs.50150\tBusiness");
            System.out.println("5.Fly Dubai(2)\t11:00\t\t12:40\t\tRs.47450\tBusiness");
            System.out.println("6.Emirates(3)\t3:30\t\t17:45\t\tRs52350\tBusiness");
            */
            /////////////////////////////////////////////////////////////////////////////

            //checking the availability of the seats in the economy and business class
            if(economy_src5_desti4_seats.size()==0 && business_src5_desti4_seats.size()==0){

                char option;
                System.out.println("\nNo seats available in the business and economy class");
                System.out.println("Do you wish to make another Reservation (y/n):");
                option= scan.next().charAt(0);

                while ( (option!='y') && (option!='n') ){
                    System.out.println("Invalid! Please enter y (for yes) or n (for no)");
                    System.out.println("Enter again..");
                    option= scan.next().charAt(0);
                }

                if(option=='n'){
                    intenationalPassengersList.remove(intenationalPassengerCurrCount);
                    intenationalPassengerCurrCount--;
                    g.global--;
                    return 0;
                }

                else if(option=='y'){
                    return j_detaili();
                }

            }

            //Printing the process if these are no seats available in the economy class
            if(economy_src5_desti4_seats.size()==0){
                System.out.println("\nNo seats are available in the Economy class. Only Business class seats are avaiable");
                System.out.println("Do you wish to make another Reservation (y/n/e)");
                System.out.println("Enter 'y' to make another Reservation. Enter 'n' to continue with the business class booking");
                System.out.println("Enter e for exit");
                char option= scan.next().charAt(0);

                while ( (option!='y') && (option!='n' && (option!='e')) ){
                    System.out.println("Invalid! Please enter y (for yes) or n (for no) or e (for exit)");
                    System.out.println("Enter again..");
                    option= scan.next().charAt(0);
                }

                if(option=='e'){
                    intenationalPassengersList.remove(intenationalPassengerCurrCount);
                    intenationalPassengerCurrCount--;
                    g.global--;
                    return 0;
                }

                else if(option=='y'){
                    return j_detaili();
                }
            }

            //Printing the process if these are no seats available in the business class
            if(business_src5_desti4_seats.size()==0){
                System.out.println("\nNo seats are available in the Business class. Only Economy class seats are avaiable");
                System.out.println("Do you wish to make another Reservation (y/n/e)");
                System.out.println("Enter 'y' to make another Reservation. Enter 'n' to continue with the Economy class booking");
                System.out.println("Enter e to exit");
                char option= scan.next().charAt(0);

                while ( (option!='y') && (option!='n') && (option!='e') ){
                    System.out.println("Invalid! Please enter y (for yes) or n (for no) or e (for exit)");
                    System.out.println("Enter again..");
                    option= scan.next().charAt(0);
                }

                if(option=='e'){
                    intenationalPassengersList.remove(intenationalPassengerCurrCount);
                    intenationalPassengerCurrCount--;
                    g.global--;
                    return 0;
                }

                else if(option=='y'){
                    return j_detaili();
                }
            }

            System.out.println("\n\t \t \t \t \t \tFlights Found");
            System.out.println("");

            if( (business_src5_desti4_seats.size()!=0) && (economy_src5_desti4_seats.size()!=0) ){
                System.out.println("Airline:\t \tDeparture:\tArrival:\tPrice:\t\tCategory");
                System.out.println("1.Vistara(1)\t7:00\t\t16:05\t\tRs.50150\tEconomy");
                System.out.println("2.Fly Dubai(2)\t11:00\t\t12:40\t\tRs.47450\tEconomy");
                System.out.println("3.Emirates(3)\t3:30\t\t17:45\t\tRs.52350\tEconomy");

                System.out.println("");
                System.out.println("Airline:\t \tDeparture:\tArrival:\tPrice:\t\tCategory");
                System.out.println("4.Vistara(1)\t7:00\t\t16:05\t\tRs.50150\tBusiness");
                System.out.println("5.Fly Dubai(2)\t11:00\t\t12:40\t\tRs.47450\tBusiness");
                System.out.println("6.Emirates(3)\t3:30\t\t17:45\t\tRs.52350\tBusiness");


                //getting the flight option from the user
                System.out.println("\nEnter your Flight choice:");
                choicei=scan.nextInt();

                //validating the choice
                while(choicei<1 || choicei>6){
                    System.out.println("Invalid! The choice can only be 1,2,3,4,5 or 6");
                    System.out.println("Enter again..");
                    choicei=scan.nextInt();
                }

                //condition for selection from Economy class
                if(choicei>=1 && choicei<4){
                    //displaying the Availaable Business class seats
                    System.out.println("\nSeat numbers available for Economy class booking\n");
                    for (int i = 0; i < economy_src5_desti4_seats.size(); i++) {
                        System.out.println("Seat No.: "+economy_src5_desti4_seats.get(i));
                    }

                    //getting the seat number choice from the user
                    System.out.println("\nEnter Seat No.:");
                    intenationalPassengersList.get(intenationalPassengerCurrCount).seat_no=scan.nextInt();

                    //validating the seat number choice
                    boolean found=false;
                    while(found!=true){

                        for (int i = 0; i < economy_src5_desti4_seats.size(); i++) {
                            //finding the seat and removing the seat at the same time in this condition
                            if(intenationalPassengersList.get(intenationalPassengerCurrCount).seat_no==economy_src5_desti4_seats.get(i)){
                                found=true;
                                economy_src5_desti4_seats.remove(i);

                                //after removing sorting the arraylist
                                Collections.sort(economy_src5_desti4_seats);
                            }
                        }

                        if(found==false){
                            System.out.println("Invalid! Please select a seat from the above available seats");
                            intenationalPassengersList.get(intenationalPassengerCurrCount).seat_no=scan.nextInt();
                        }
                    }

                    //The selected seat is being removed from the arraylist successfully
                }

                //condition for selection from the business class
                if(choicei>3 && choicei<7){
                    //displaying the Availaable Business class seats
                    System.out.println("\nSeat numbers available for business class booking\n");
                    for (int i = 0; i < business_src5_desti4_seats.size(); i++) {
                        System.out.println("Seat No.: "+business_src5_desti4_seats.get(i));
                    }

                    //getting the seat number choice from the user
                    System.out.println("\nEnter Seat No.:");
                    intenationalPassengersList.get(intenationalPassengerCurrCount).seat_no=scan.nextInt();

                    //validating the seat number choice
                    boolean found=false;
                    while(found!=true){

                        for (int i = 0; i < business_src5_desti4_seats.size(); i++) {
                            //finding the seat and removing the seat at the same time in this condition
                            if(intenationalPassengersList.get(intenationalPassengerCurrCount).seat_no==business_src5_desti4_seats.get(i)){
                                found=true;
                                business_src5_desti4_seats.remove(i);

                                //after removing sorting the arraylist
                                Collections.sort(business_src5_desti4_seats);
                            }
                        }

                        if(found==false){
                            System.out.println("Invalid! Please select a seat from the above available seats");
                            intenationalPassengersList.get(intenationalPassengerCurrCount).seat_no=scan.nextInt();
                        }
                    }

                    //The selected seat is being removed from the arraylist successfully
                }
            }

            if(economy_src5_desti4_seats.size()!=0 && business_src5_desti4_seats.size()==0) {
                System.out.println("Airline:\t \tDeparture:\tArrival:\tPrice:\t\tCategory");
                System.out.println("1.Vistara(1)\t7:00\t\t16:05\t\tRs.50150\tEconomy");
                System.out.println("2.Fly Dubai(2)\t11:00\t\t12:40\t\tRs.47450\tEconomy");
                System.out.println("3.Emirates(3)\t3:30\t\t17:45\t\tRs.52350\tEconomy");

                //getting the flight option from the user
                System.out.println("\nEnter your Flight choice:");
                choicei=scan.nextInt();

                //validating the choice
                while(choicei<1 || choicei>3){
                    System.out.println("Invalid! The choice can only be 1,2 or 3");
                    System.out.println("Enter again..");
                    choicei=scan.nextInt();
                }

                //displaying the Availaable Business class seats
                System.out.println("\nSeat numbers available for Economy class booking\n");
                for (int i = 0; i < economy_src5_desti4_seats.size(); i++) {
                    System.out.println("Seat No.: "+economy_src5_desti4_seats.get(i));
                }

                //getting the seat number choice from the user
                System.out.println("\nEnter Seat No.:");
                intenationalPassengersList.get(intenationalPassengerCurrCount).seat_no=scan.nextInt();

                //validating the seat number choice
                boolean found=false;
                while(found!=true){

                    for (int i = 0; i < economy_src5_desti4_seats.size(); i++) {
                        //finding the seat and removing the seat at the same time in this condition
                        if(intenationalPassengersList.get(intenationalPassengerCurrCount).seat_no==economy_src5_desti4_seats.get(i)){
                            found=true;
                            economy_src5_desti4_seats.remove(i);

                            //after removing sorting the arraylist
                            Collections.sort(economy_src5_desti4_seats);
                        }
                    }

                    if(found==false){
                        System.out.println("Invalid! Please select a seat from the above available seats");
                        intenationalPassengersList.get(intenationalPassengerCurrCount).seat_no=scan.nextInt();
                    }
                }

                //The selected seat is being removed from the arraylist successfully
            }

            if(business_src5_desti4_seats.size()!=0 && economy_src5_desti4_seats.size()==0) {
                System.out.println("Airline:\t \tDeparture:\tArrival:\tPrice:\t\tCategory");
                System.out.println("4.Vistara(1)\t7:00\t\\t16:05\t\tRs.50150\tBusiness");
                System.out.println("5.Fly Dubai(2)\t11:00\t\t12:40\t\tRs.47450\tBusiness");
                System.out.println("6.Emirates(3)\t3:30\t\t17:45\t\tRs.52350\tBusiness");
                System.out.println("");

                //getting the flight option from the user
                System.out.println("\nEnter your Flight choice:");
                choicei=scan.nextInt();

                //validating the choice
                while(choicei<4 || choicei>6){
                    System.out.println("Invalid! The choice can only be 4,5 or 6");
                    System.out.println("Enter again..");
                    choicei=scan.nextInt();
                }

                //displaying the Availaable Business class seats
                System.out.println("\nSeat numbers available for business class booking\n");
                for (int i = 0; i < business_src5_desti4_seats.size(); i++) {
                    System.out.println("Seat No.: "+business_src5_desti4_seats.get(i));
                }

                //getting the seat number choice from the user
                System.out.println("\nEnter Seat No.:");
                intenationalPassengersList.get(intenationalPassengerCurrCount).seat_no=scan.nextInt();

                //validating the seat number choice
                boolean found=false;
                while(found!=true){

                    for (int i = 0; i < business_src5_desti4_seats.size(); i++) {
                        //finding the seat and removing the seat at the same time in this condition
                        if(intenationalPassengersList.get(intenationalPassengerCurrCount).seat_no==business_src5_desti4_seats.get(i)){
                            found=true;
                            business_src5_desti4_seats.remove(i);

                            //after removing sorting the arraylist
                            Collections.sort(business_src5_desti4_seats);
                        }
                    }

                    if(found==false){
                        System.out.println("Invalid! Please select a seat from the above available seats");
                        intenationalPassengersList.get(intenationalPassengerCurrCount).seat_no=scan.nextInt();
                    }
                }

                //The selected seat is being removed from the arraylist successfully
            }

            //setting the src and dest variables of the passenger class because it will later help in
            //identifying in which arraylist to add the cancelled seat (seat cancelled by the passenger)
            intenationalPassengersList.get(intenationalPassengerCurrCount).src=5;
            intenationalPassengersList.get(intenationalPassengerCurrCount).dest=4;
            intenationalPassengersList.get(intenationalPassengerCurrCount).source="New York";
            intenationalPassengersList.get(intenationalPassengerCurrCount).destination="Singapore";



        }

        else if(srci==desti)//condition
        {
            System.out.println("wrong input entered.\nTry again\n\n\n");
            return j_detaili();
        }
        else//condition
        {
            System.out.println("Wrong input entered.\nTry again\n\n\n");
            return j_detaili();
        }

        select_flighti();
        return 1;
    }

    int select_flighti()//function declaration and definition for selecting flight
    {

        switch(choicei)//switch case
        {
            //cases for economy class booking
            case 1://condition
                System.out.println("\nFlight selected:");
                System.out.println("Vistara");
                intenationalPassengersList.get(intenationalPassengerCurrCount).f_i="Vistara";//copy to string
                System.out.println("Departure Time: 10:00");
                System.out.println("Arrival Time: 14:05");
                intenationalPassengersList.get(intenationalPassengerCurrCount).tojdi="10:00";//copy to string
                intenationalPassengersList.get(intenationalPassengerCurrCount).tojai="14:05";//copy to string
                intenationalPassengersList.get(intenationalPassengerCurrCount).ticketCategory="Economy";
                break;
            case 2://condition
                System.out.println("\nFlight selected:");
                System.out.println("Fly Dubai");
                intenationalPassengersList.get(intenationalPassengerCurrCount).f_i="Fly Dubai";//copy to string
                System.out.println("Departure Time: 14:00");
                System.out.println("Arrival Time: 18:05");
                intenationalPassengersList.get(intenationalPassengerCurrCount).tojdi="14:00";//copy to string
                intenationalPassengersList.get(intenationalPassengerCurrCount).tojai="18:05";//copy to string
                intenationalPassengersList.get(intenationalPassengerCurrCount).ticketCategory="Economy";
                break;
            case 3://condition
                System.out.println("\nFlight selected:");
                System.out.println("Emirates");
                intenationalPassengersList.get(intenationalPassengerCurrCount).f_i="Emirates";//copy to string
                System.out.println("Departure Time : 18:00");
                System.out.println("Arrival Time: 22:05");
                intenationalPassengersList.get(intenationalPassengerCurrCount).tojdi="18:00";//copy to string
                intenationalPassengersList.get(intenationalPassengerCurrCount).tojai="22:05";//copy to string
                intenationalPassengersList.get(intenationalPassengerCurrCount).ticketCategory="Economy";
                break;
            //cases for business class booking
            case 4://condition
                System.out.println("\nFlight selected:");
                System.out.println("Vistara");
                intenationalPassengersList.get(intenationalPassengerCurrCount).f_i="Vistara";//copy to string
                System.out.println("Departure Time: 10:00");
                System.out.println("Arrival Time: 14:05");
                intenationalPassengersList.get(intenationalPassengerCurrCount).tojdi="10:00";//copy to string
                intenationalPassengersList.get(intenationalPassengerCurrCount).tojai="14:05";//copy to string
                intenationalPassengersList.get(intenationalPassengerCurrCount).ticketCategory="Business";
                break;
            case 5://condition
                System.out.println("\nFlight selected:");
                System.out.println("Fly Dubai");
                intenationalPassengersList.get(intenationalPassengerCurrCount).f_i="Fly Dubai";//copy to string
                System.out.println("Departure Time: 14:00");
                System.out.println("Arrival Time: 18:05");
                intenationalPassengersList.get(intenationalPassengerCurrCount).tojdi="14:00";//copy to string
                intenationalPassengersList.get(intenationalPassengerCurrCount).tojai="18:05";//copy to string
                intenationalPassengersList.get(intenationalPassengerCurrCount).ticketCategory="Business";
                break;
            case 6://condition
                System.out.println("\nFlight selected:");
                System.out.println("Emirates");
                intenationalPassengersList.get(intenationalPassengerCurrCount).f_i="Emirates";//copy to string
                System.out.println("Departure Time : 18:00");
                System.out.println("Arrival Time: 22:05");
                intenationalPassengersList.get(intenationalPassengerCurrCount).tojdi="18:00";//copy to string
                intenationalPassengersList.get(intenationalPassengerCurrCount).tojai="22:05";//copy to string
                intenationalPassengersList.get(intenationalPassengerCurrCount).ticketCategory="Business";
                break;
            default://condition
                System.out.println("Wrong input entered");
                return select_flighti();
        }

        intenationalPassengersList.get(intenationalPassengerCurrCount).dispi();

        //writing domestic passenger info to Domestic.txt
        try{

            File myObj = new File("International.txt");
            if (myObj.createNewFile()) {
                System.out.println("File created: " + myObj.getName());
            } else {
                System.out.println("File already exists.");
            }

            //code for writing in the file starts from here
            FileWriter writer = new FileWriter("International.txt", true);

            //writing everything manually and one by one in the file
            String out= "PNR: "+String.valueOf(intenationalPassengersList.get(intenationalPassengerCurrCount).pnri);
            writer.write(out);
            writer.write("\r\n");

            out= "Date of Journey: "+intenationalPassengersList.get(intenationalPassengerCurrCount).doji;
            writer.write(out);
            writer.write("\r\n");

            out= "Flight: "+intenationalPassengersList.get(intenationalPassengerCurrCount).f_i;
            writer.write(out);
            writer.write("\r\n");

            out= "Name: "+intenationalPassengersList.get(intenationalPassengerCurrCount).f_name;
            writer.write(out);
            writer.write("\r\n");

            out= "Source :"+intenationalPassengersList.get(intenationalPassengerCurrCount).source;
            writer.write(out);
            writer.write("\r\n");

            out= "Destination: "+intenationalPassengersList.get(intenationalPassengerCurrCount).destination;
            writer.write(out);
            writer.write("\r\n");

            out= "Arrival time: "+intenationalPassengersList.get(intenationalPassengerCurrCount).tojai;
            writer.write(out);
            writer.write("\r\n");

            out= "Departure time: "+intenationalPassengersList.get(intenationalPassengerCurrCount).tojdi;
            writer.write(out);
            writer.write("\r\n");

            out= "Seat No.: "+String.valueOf(intenationalPassengersList.get(intenationalPassengerCurrCount).seat_no);
            writer.write(out);
            writer.write("\r\n");

            out= "Ticket Category: "+intenationalPassengersList.get(intenationalPassengerCurrCount).ticketCategory;
            writer.write(out);
            writer.write("\r\n");
            writer.write("\r\n");

            writer.close();
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
        return 1;
    }

    void displayPassengers(){

        if(intenationalPassengersList.size()==0){
            System.out.println("No Passengers to show");
            return;
        }

        System.out.println("\nDisplaying the list of passsengers having domestic booking\n");

        for (int i = 0; i < intenationalPassengersList.size(); i++) {
            intenationalPassengersList.get(i).dispi();
            System.out.println("");
        }
    }

    void cancelTicket(int x){ //function getting the pnr as argument to search

        if(intenationalPassengersList.size()==0){
            System.out.println("\nNo Passengers List to Search");
            return;
        }
        boolean found=false;

        for (int i = 0; i < intenationalPassengersList.size(); i++) {
            if(intenationalPassengersList.get(i).pnri==x){
                found=true;
                intenationalPassengersList.get(i).dispi();
                System.out.println("\nYour Above ticket is being cancelled");
                System.out.println("Amount Refunded: 10,000");

                //condition for adding to the arrays of src1_desti2_seats
                if(intenationalPassengersList.get(i).src==1 && intenationalPassengersList.get(i).dest==2){
                    if(intenationalPassengersList.get(i).seat_no>0 && intenationalPassengersList.get(i).seat_no<6){

                        int r=intenationalPassengersList.get(i).seat_no;
                        business_src1_desti2_seats.add(r);
                        Collections.sort(business_src1_desti2_seats);
                    }

                    else if(intenationalPassengersList.get(i).seat_no>5 && intenationalPassengersList.get(i).seat_no<26){
                        economy_src1_desti2_seats.add(intenationalPassengersList.get(i).seat_no);
                        Collections.sort(economy_src1_desti2_seats);

                    }
                }

                //condition for adding to the arrays of src1_desti3_seats
                if(intenationalPassengersList.get(i).src==1 && intenationalPassengersList.get(i).dest==3){
                    if(intenationalPassengersList.get(i).seat_no>0 && intenationalPassengersList.get(i).seat_no<6){

                        int r=intenationalPassengersList.get(i).seat_no;
                        business_src1_desti3_seats.add(r);
                        Collections.sort(business_src1_desti3_seats);
                    }

                    else if(intenationalPassengersList.get(i).seat_no>5 && intenationalPassengersList.get(i).seat_no<26){
                        economy_src1_desti3_seats.add(intenationalPassengersList.get(i).seat_no);
                        Collections.sort(economy_src1_desti3_seats);

                    }
                }

                //condition for adding to the arrays of src1_desti4_seats
                if(intenationalPassengersList.get(i).src==1 && intenationalPassengersList.get(i).dest==4){
                    if(intenationalPassengersList.get(i).seat_no>0 && intenationalPassengersList.get(i).seat_no<6){

                        int r=intenationalPassengersList.get(i).seat_no;
                        business_src1_desti4_seats.add(r);
                        Collections.sort(business_src1_desti4_seats);
                    }

                    else if(intenationalPassengersList.get(i).seat_no>5 && intenationalPassengersList.get(i).seat_no<26){
                        economy_src1_desti4_seats.add(intenationalPassengersList.get(i).seat_no);
                        Collections.sort(economy_src1_desti4_seats);

                    }
                }

                //condition for adding to the arrays of src1_desti5_seats
                if(intenationalPassengersList.get(i).src==1 && intenationalPassengersList.get(i).dest==5){
                    if(intenationalPassengersList.get(i).seat_no>0 && intenationalPassengersList.get(i).seat_no<6){

                        int r=intenationalPassengersList.get(i).seat_no;
                        business_src1_desti5_seats.add(r);
                        Collections.sort(business_src1_desti5_seats);
                    }

                    else if(intenationalPassengersList.get(i).seat_no>5 && intenationalPassengersList.get(i).seat_no<26){
                        economy_src1_desti5_seats.add(intenationalPassengersList.get(i).seat_no);
                        Collections.sort(economy_src1_desti5_seats);

                    }
                }

                //condition for adding to the arrays of src2_desti1_seats
                if(intenationalPassengersList.get(i).src==2 && intenationalPassengersList.get(i).dest==1){
                    if(intenationalPassengersList.get(i).seat_no>0 && intenationalPassengersList.get(i).seat_no<6){

                        int r=intenationalPassengersList.get(i).seat_no;
                        business_src2_desti1_seats.add(r);
                        Collections.sort(business_src2_desti1_seats);
                    }

                    else if(intenationalPassengersList.get(i).seat_no>5 && intenationalPassengersList.get(i).seat_no<26){
                        economy_src2_desti1_seats.add(intenationalPassengersList.get(i).seat_no);
                        Collections.sort(economy_src2_desti1_seats);

                    }
                }

                //condition for adding to the arrays of src2_desti3_seats
                if(intenationalPassengersList.get(i).src==2 && intenationalPassengersList.get(i).dest==3){
                    if(intenationalPassengersList.get(i).seat_no>0 && intenationalPassengersList.get(i).seat_no<6){

                        int r=intenationalPassengersList.get(i).seat_no;
                        business_src2_desti3_seats.add(r);
                        Collections.sort(business_src2_desti3_seats);
                    }

                    else if(intenationalPassengersList.get(i).seat_no>5 && intenationalPassengersList.get(i).seat_no<26){
                        economy_src2_desti3_seats.add(intenationalPassengersList.get(i).seat_no);
                        Collections.sort(economy_src2_desti3_seats);

                    }
                }

                //condition for adding to the arrays of src2_desti4_seats
                if(intenationalPassengersList.get(i).src==2 && intenationalPassengersList.get(i).dest==4){
                    if(intenationalPassengersList.get(i).seat_no>0 && intenationalPassengersList.get(i).seat_no<6){

                        int r=intenationalPassengersList.get(i).seat_no;
                        business_src2_desti4_seats.add(r);
                        Collections.sort(business_src2_desti4_seats);
                    }

                    else if(intenationalPassengersList.get(i).seat_no>5 && intenationalPassengersList.get(i).seat_no<26){
                        economy_src2_desti4_seats.add(intenationalPassengersList.get(i).seat_no);
                        Collections.sort(economy_src2_desti4_seats);

                    }
                }

                //condition for adding to the arrays of src2_desti5_seats
                if(intenationalPassengersList.get(i).src==2 && intenationalPassengersList.get(i).dest==5){
                    if(intenationalPassengersList.get(i).seat_no>0 && intenationalPassengersList.get(i).seat_no<6){

                        int r=intenationalPassengersList.get(i).seat_no;
                        business_src2_desti5_seats.add(r);
                        Collections.sort(business_src2_desti5_seats);
                    }

                    else if(intenationalPassengersList.get(i).seat_no>5 && intenationalPassengersList.get(i).seat_no<26){
                        economy_src2_desti5_seats.add(intenationalPassengersList.get(i).seat_no);
                        Collections.sort(economy_src2_desti5_seats);

                    }
                }

                //condition for adding to the arrays of src3_desti1_seats
                if(intenationalPassengersList.get(i).src==3 && intenationalPassengersList.get(i).dest==1){
                    if(intenationalPassengersList.get(i).seat_no>0 && intenationalPassengersList.get(i).seat_no<6){

                        int r=intenationalPassengersList.get(i).seat_no;
                        business_src3_desti1_seats.add(r);
                        Collections.sort(business_src3_desti1_seats);
                    }

                    else if(intenationalPassengersList.get(i).seat_no>5 && intenationalPassengersList.get(i).seat_no<26){
                        economy_src3_desti1_seats.add(intenationalPassengersList.get(i).seat_no);
                        Collections.sort(economy_src3_desti1_seats);

                    }
                }

                //condition for adding to the arrays of src3_desti2_seats
                if(intenationalPassengersList.get(i).src==3 && intenationalPassengersList.get(i).dest==2){
                    if(intenationalPassengersList.get(i).seat_no>0 && intenationalPassengersList.get(i).seat_no<6){

                        int r=intenationalPassengersList.get(i).seat_no;
                        business_src3_desti2_seats.add(r);
                        Collections.sort(business_src3_desti2_seats);
                    }

                    else if(intenationalPassengersList.get(i).seat_no>5 && intenationalPassengersList.get(i).seat_no<26){
                        economy_src3_desti2_seats.add(intenationalPassengersList.get(i).seat_no);
                        Collections.sort(economy_src3_desti2_seats);

                    }
                }

                //condition for adding to the arrays of src3_desti4_seats
                if(intenationalPassengersList.get(i).src==3 && intenationalPassengersList.get(i).dest==4){
                    if(intenationalPassengersList.get(i).seat_no>0 && intenationalPassengersList.get(i).seat_no<6){

                        int r=intenationalPassengersList.get(i).seat_no;
                        business_src3_desti4_seats.add(r);
                        Collections.sort(business_src3_desti4_seats);
                    }

                    else if(intenationalPassengersList.get(i).seat_no>5 && intenationalPassengersList.get(i).seat_no<26){
                        economy_src3_desti4_seats.add(intenationalPassengersList.get(i).seat_no);
                        Collections.sort(economy_src3_desti4_seats);

                    }
                }

                //condition for adding to the arrays of src3_desti5_seats
                if(intenationalPassengersList.get(i).src==3 && intenationalPassengersList.get(i).dest==5){
                    if(intenationalPassengersList.get(i).seat_no>0 && intenationalPassengersList.get(i).seat_no<6){

                        int r=intenationalPassengersList.get(i).seat_no;
                        business_src3_desti5_seats.add(r);
                        Collections.sort(business_src3_desti5_seats);
                    }

                    else if(intenationalPassengersList.get(i).seat_no>5 && intenationalPassengersList.get(i).seat_no<26){
                        economy_src3_desti5_seats.add(intenationalPassengersList.get(i).seat_no);
                        Collections.sort(economy_src3_desti5_seats);

                    }
                }

                //condition for adding to the arrays of src4_desti1_seats
                if(intenationalPassengersList.get(i).src==4 && intenationalPassengersList.get(i).dest==1){
                    if(intenationalPassengersList.get(i).seat_no>0 && intenationalPassengersList.get(i).seat_no<6){

                        int r=intenationalPassengersList.get(i).seat_no;
                        business_src4_desti1_seats.add(r);
                        Collections.sort(business_src4_desti1_seats);
                    }

                    else if(intenationalPassengersList.get(i).seat_no>5 && intenationalPassengersList.get(i).seat_no<26){
                        economy_src4_desti1_seats.add(intenationalPassengersList.get(i).seat_no);
                        Collections.sort(economy_src4_desti1_seats);

                    }
                }

                //condition for adding to the arrays of src4_desti2_seats
                if(intenationalPassengersList.get(i).src==4 && intenationalPassengersList.get(i).dest==2){
                    if(intenationalPassengersList.get(i).seat_no>0 && intenationalPassengersList.get(i).seat_no<6){

                        int r=intenationalPassengersList.get(i).seat_no;
                        business_src4_desti2_seats.add(r);
                        Collections.sort(business_src4_desti2_seats);
                    }

                    else if(intenationalPassengersList.get(i).seat_no>5 && intenationalPassengersList.get(i).seat_no<26){
                        economy_src4_desti2_seats.add(intenationalPassengersList.get(i).seat_no);
                        Collections.sort(economy_src4_desti2_seats);

                    }
                }

                //condition for adding to the arrays of src4_desti3_seats
                if(intenationalPassengersList.get(i).src==4 && intenationalPassengersList.get(i).dest==3){
                    if(intenationalPassengersList.get(i).seat_no>0 && intenationalPassengersList.get(i).seat_no<6){

                        int r=intenationalPassengersList.get(i).seat_no;
                        business_src4_desti3_seats.add(r);
                        Collections.sort(business_src4_desti3_seats);
                    }

                    else if(intenationalPassengersList.get(i).seat_no>5 && intenationalPassengersList.get(i).seat_no<26){
                        economy_src4_desti3_seats.add(intenationalPassengersList.get(i).seat_no);
                        Collections.sort(economy_src4_desti3_seats);

                    }
                }

                //condition for adding to the arrays of src4_desti5_seats
                if(intenationalPassengersList.get(i).src==4 && intenationalPassengersList.get(i).dest==5){
                    if(intenationalPassengersList.get(i).seat_no>0 && intenationalPassengersList.get(i).seat_no<6){

                        int r=intenationalPassengersList.get(i).seat_no;
                        business_src4_desti5_seats.add(r);
                        Collections.sort(business_src4_desti5_seats);
                    }

                    else if(intenationalPassengersList.get(i).seat_no>5 && intenationalPassengersList.get(i).seat_no<26){
                        economy_src4_desti5_seats.add(intenationalPassengersList.get(i).seat_no);
                        Collections.sort(economy_src4_desti5_seats);

                    }
                }

                //condition for adding to the arrays of src5_desti1_seats
                if(intenationalPassengersList.get(i).src==5 && intenationalPassengersList.get(i).dest==1){
                    if(intenationalPassengersList.get(i).seat_no>0 && intenationalPassengersList.get(i).seat_no<6){

                        int r=intenationalPassengersList.get(i).seat_no;
                        business_src5_desti1_seats.add(r);
                        Collections.sort(business_src5_desti1_seats);
                    }

                    else if(intenationalPassengersList.get(i).seat_no>5 && intenationalPassengersList.get(i).seat_no<26){
                        economy_src5_desti1_seats.add(intenationalPassengersList.get(i).seat_no);
                        Collections.sort(economy_src5_desti1_seats);

                    }
                }

                //condition for adding to the arrays of src5_desti2_seats
                if(intenationalPassengersList.get(i).src==5 && intenationalPassengersList.get(i).dest==2){
                    if(intenationalPassengersList.get(i).seat_no>0 && intenationalPassengersList.get(i).seat_no<6){

                        int r=intenationalPassengersList.get(i).seat_no;
                        business_src5_desti2_seats.add(r);
                        Collections.sort(business_src5_desti2_seats);
                    }

                    else if(intenationalPassengersList.get(i).seat_no>5 && intenationalPassengersList.get(i).seat_no<26){
                        economy_src5_desti2_seats.add(intenationalPassengersList.get(i).seat_no);
                        Collections.sort(economy_src5_desti2_seats);

                    }
                }

                //condition for adding to the arrays of src5_desti3_seats
                if(intenationalPassengersList.get(i).src==5 && intenationalPassengersList.get(i).dest==3){
                    if(intenationalPassengersList.get(i).seat_no>0 && intenationalPassengersList.get(i).seat_no<6){

                        int r=intenationalPassengersList.get(i).seat_no;
                        business_src5_desti3_seats.add(r);
                        Collections.sort(business_src5_desti3_seats);
                    }

                    else if(intenationalPassengersList.get(i).seat_no>5 && intenationalPassengersList.get(i).seat_no<26){
                        economy_src5_desti3_seats.add(intenationalPassengersList.get(i).seat_no);
                        Collections.sort(economy_src5_desti3_seats);

                    }
                }

                //condition for adding to the arrays of src5_desti4_seats
                if(intenationalPassengersList.get(i).src==5 && intenationalPassengersList.get(i).dest==4){
                    if(intenationalPassengersList.get(i).seat_no>0 && intenationalPassengersList.get(i).seat_no<6){

                        int r=intenationalPassengersList.get(i).seat_no;
                        business_src5_desti4_seats.add(r);
                        Collections.sort(business_src5_desti4_seats);
                    }

                    else if(intenationalPassengersList.get(i).seat_no>5 && intenationalPassengersList.get(i).seat_no<26){
                        economy_src5_desti4_seats.add(intenationalPassengersList.get(i).seat_no);
                        Collections.sort(economy_src5_desti4_seats);

                    }
                }

                intenationalPassengersList.remove(i);
                intenationalPassengerCurrCount--;
                i=intenationalPassengersList.size();
            }
        }

        if(found==false){
            System.out.println("\nTicket Not Found!");
        }
    }

    void checkTicketi(int x){

        if(intenationalPassengersList.size()==0){
            System.out.println("The passenger list is empty");
            return;
        }

        boolean found=false;
        for (int i = 0; i < intenationalPassengersList.size(); i++) {
            if(intenationalPassengersList.get(i).pnri==x){
                found=true;
                intenationalPassengersList.get(i).dispi();
            }
        }

        if(found==false){
            System.out.println("Ticket not found!");
        }
    }

}

//Passenger Class for Domestic Booking
class Passenger {
    //protected members
    protected int pnr;
    protected String f_name;
    protected int age;
    protected int gender;
    protected String c_no;
    protected String email;
    protected String doj; //date of journey
    protected String f_d; //fd is for Airline selected for traveling, tojd is
    //for the departure time of the journey and toja is for the arrival time of the jounrey
    protected String source;
    protected String destination;
    protected String toja;
    protected String tojd;
    protected int seat_no;
    protected String ticketCategory;
    protected int src;
    protected int dest;

    //public member functions
    int fname_check() throws InvalidFnameException {

        Scanner sc = new Scanner(System.in);

        System.out.println("Name: ");
        f_name = sc.next();

        if (NameValidation.validateFirstName(f_name)) {
            throw new InvalidFnameException("Invalid! The name must contain all upper case or lower case characters");
        }

        return 1;
    }

    int gender_check() throws InvalidGenderException//to check gender input as valid
    {
        Scanner sc = new Scanner(System.in);

        System.out.println("\nGender:\nMale-press:1::\nFemale-press:2::\nOther-press:3::");
        gender = sc.nextInt();

        if (gender > 3 || gender < 0)//condition
        {
            throw new InvalidGenderException("Invalid Input! The options for gender can only be 1,2 or 3");
            //return gender_check();//function call
        } else {
            return 1;
        }

    }

    int age_check() throws InvalidAgeException//to check gender input as valid
    {
        Scanner sc = new Scanner(System.in);

        System.out.println("\nAge:");
        age = sc.nextInt();

        if (age < 18)//condition
        {
            throw new InvalidAgeException("Invalid Input! For making a reservation the Age must be greater than 18");
        } else {
            return 1;
        }

    }

    int phoneNumber_check() throws InvalidMobileNumberException {

        Scanner sc = new Scanner(System.in);

        System.out.println("\nContact no.(11 digits). Format (03xxxxxxxxx):");
        c_no = sc.next();

        if (!MobileNumberValidation.validateNumber(c_no)) {
            throw new InvalidMobileNumberException("The Length of the Number must be 11 digits. Number must be in the format 03xxxxxxxxx");
        }

        return 1;
    }

    int email_check() throws InvalidEmailException {

        Scanner sc = new Scanner(System.in);

        System.out.println("\nEmail Id:");
        email = sc.next();

        if (!EmailValidation.validateEmail(email)) {
            throw new InvalidEmailException("Invalid! Email address");
        }

        return 1;
    }

    void more_details()//to take more details of the passenger
    {

        System.out.println("\n\nDetails Entered:\n");
        System.out.println("Name:" + f_name);
        System.out.println("Gender:" + gender);     //displaying details
        System.out.println("Age:" + age);
        System.out.println("Email id:" + email);
        System.out.println("Contact No.:" + c_no);
    }


    int getpnr()//function to get pnr for domestic booking
    {
        return getpnr();
    }

    /*int getpnri()//function to get pnr for international booking
    {
        return pnri;
    }*/

    void disp()//function to display details for domestic booking
    {
        System.out.println("\nPNR: " + pnr);
        System.out.println("Flight: " + f_d);
        System.out.println("Name :" + f_name);
        System.out.println("Date Of Journey: " + doj);
        System.out.println("Source:" + source);
        System.out.println("Destination: " + destination);
        System.out.println("Departure Time: " + tojd);
        System.out.println("Arrival Time: " + toja);
        System.out.println("Seat No.: " + seat_no);
        System.out.println("Ticket Category: " + ticketCategory);
    }

}

//Passenger Class for International Booking
class Passenger_International {
    //protected members
    protected int pnri;
    protected String f_name;
    protected int age;
    protected int gender;
    protected String c_no;
    protected String email;
    protected String doji; //date of the international journey
    protected String f_i; //f_i is for Airline selected for international traveling, tojdi is
    //for the departure time of the international journey and tojai is for the arrival time of the international jounrey
    protected String source;
    protected String destination;
    protected String tojai;
    protected String tojdi;
    protected int seat_no;
    protected String ticketCategory;
    protected int src;
    protected int dest;

    //public member functions
    int fname_check() throws  InvalidFnameException{

        Scanner sc = new Scanner(System.in);

        System.out.println("Name: ");
        f_name=sc.next();

        if(NameValidation.validateFirstName(f_name)){
            throw new InvalidFnameException("Invalid! The name must contain all upper case or lower case characters");
        }

        return 1;
    }

    int gender_check() throws InvalidGenderException//to check gender input as valid
    {
        Scanner sc = new Scanner(System.in);

        System.out.println("\nGender:\nMale-press:1::\nFemale-press:2::\nOther-press:3::");
        gender=sc.nextInt();

        if (gender > 3 || gender < 0)//condition
        {
            throw new InvalidGenderException("Invalid Input! The options for gender can only be 1,2 or 3");
            //return gender_check();//function call
        }

        else{
            return 1;
        }

    }

    int age_check() throws InvalidAgeException//to check gender input as valid
    {
        Scanner sc = new Scanner(System.in);

        System.out.println("\nAge:");
        age=sc.nextInt();

        if (age<18)//condition
        {
            throw new InvalidAgeException("Invalid Input! For making a reservation the Age must be greater than 18");
        }

        else{
            return 1;
        }

    }

    int phoneNumber_check() throws InvalidMobileNumberException{

        Scanner sc = new Scanner(System.in);

        System.out.println("\nContact no.(11 digits). Format (03xxxxxxxxx):");
        c_no=sc.next();

        if(!MobileNumberValidation.validateNumber(c_no)){
            throw new InvalidMobileNumberException("The Length of the Number must be 11 digits. Number must be in the format 03xxxxxxxxx");
        }

        return 1;
    }

    int email_check() throws InvalidEmailException{

        Scanner sc = new Scanner(System.in);

        System.out.println("\nEmail Id:");
        email=sc.next();

        if(!EmailValidation.validateEmail(email)){
            throw new InvalidEmailException("Invalid! Email address");
        }

        return 1;
    }

    void more_details()//to take more details of the passenger
    {

        System.out.println("\n\nDetails Entered:\n");
        System.out.println("Name:"+f_name);
        System.out.println("Gender:"+gender);     //displaying details
        System.out.println("Age:"+age);
        System.out.println("Email id:"+email);
        System.out.println("Contact No.:"+c_no);
    }

    /*
    int getpnr()//function to get pnr for domestic booking
    {
        return getpnr();
    }

    int getpnri()//function to get pnr for international booking
    {
        return pnri;
    }*/

    void dispi()//function to display details for international booking
    {
        System.out.println("\nPNR: "+pnri);
        System.out.println("Flight: "+f_i);
        System.out.println("Name: "+f_name);
        System.out.println("Date Of Journey: "+doji);
        System.out.println("Source: "+source);
        System.out.println("Destination: "+destination);
        System.out.println("Departure Time: "+tojdi);
        System.out.println("Arrival Time: "+tojai);
        System.out.println("Seat No.: "+seat_no);
        System.out.println("Ticket Category: "+ticketCategory);
    }
}

//class for payment
class Payment
{
    //protected members
    protected int choice1,bank;
    protected String date,card,cvv,user_id;
    protected String password;
    Scanner sc = new Scanner(System.in);
    //public members functions
    int pay_detail()//function declaration and definition for payment method
    {
        System.out.println("\n\n\nHow would you like to pay?:\n");
        System.out.println("\n\1.Debit Card(1) \n\2.Credit Card(2) \n\3.Net Banking(3)");
        System.out.println("\n\nEnter your choice");
        choice1=sc.nextInt();

        switch(choice1)//switch case
        {
            case 1://condition
                System.out.println("\nEnter card no.:");
                card=sc.next();
                System.out.println("\nEnter expiry date format (DD/MM/YYYY). Please enter a valid date:");;
                date=sc.next();

                SimpleDateFormat sdfrmt = new SimpleDateFormat("dd/MM/yyyy");
                sdfrmt.setLenient(false);

                try
                {
                    Date javaDate = sdfrmt.parse(date);
                }
                // Date format is invalid
                catch (ParseException e) {
                    System.out.println("Invalid! Date: " + date);
                    return pay_detail();
                }

                System.out.println("\nEnter CVV no.:");;
                cvv=sc.next();
                System.out.println("\nTransaction Successful\n");
                break;
            case 2://condition
                System.out.println("\nEnter card no.:");
                card=sc.next();
                System.out.println("\nEnter expiry date format (DD/MM/YYYY). Please enter a valid date:");
                date=sc.next();

                sdfrmt = new SimpleDateFormat("dd/MM/yyyy");
                sdfrmt.setLenient(false);

                try
                {
                    Date javaDate = sdfrmt.parse(date);
                }
                // Date format is invalid
                catch (ParseException e) {
                    System.out.println("Invalid! Date: " + date);
                    return pay_detail();
                }

                System.out.println("\nEnter password:");
                password=sc.next();
                System.out.println("\nTransaction Successful\n");
                break;
            case 3://condition
                System.out.println("Banks Available: \1.West Pac Bank(1) \2.Nabil Bank(2) \3.Standard Chartered Bank(3) \4.AMP Bank(4) \5.Others(5)");
                System.out.println("\nSelect your bank:");
                bank=sc.nextInt();
                System.out.println("\nYou have selected:"+bank);
                System.out.println("\nEnter user id:");
                user_id=sc.next();
                System.out.println("\nEnter password:");
                password=sc.next();
                System.out.println("\nTransaction Successful\n");
                break;
            default://condition
                System.out.println("\nWrong input entered.\nTry again\n\n");
                return pay_detail();
        }

        return 1;
    }

};

public class Main {

    public void mainCaller()
    {
        System.out.println("mainCaller!");

        // Calling the main() method
        main(null);
    }

    //driver program
    public static void main(String[] args) {

        d_booking d=new d_booking();//object for class d_booking
        i_booking i=new i_booking();//object for class i_booking
        Scanner sc=new Scanner(System.in);
        Payment p2=new Payment();//object for class payment
        int ch,ch1,n;//integer variables
        char input;//character variables

        d.settingSeats();
        i.settingSeats();

        do//do while loop
        {
            //clearing the screen
            System.out.print("\033[H\033[2J");
            System.out.flush();

            System.out.println("\n\n \t\tWelcome To Flight Reservation System");
            System.out.println("\t   <><><><><><><><><><><><><><><><><><><><><><><>");
            System.out.println("\t   Book your Flight tickets at affordable prices!");
            System.out.println("\t   <><><><><><><><><><><><><><><><><><><><><><><>");

            System.out.println("\n\t\t\t\1.Book Flight(1) \n\t\t\t\2.Cancel Fight(2) \n\t\t\t\3.Check Ticket(3) \n\t\t\t\4.Exit(4)");
            System.out.print("\n\t\t Please enter your choice: ");
            ch=sc.nextInt();
            switch(ch)//witch case
            {
                case 1://condition
                    //clearing the screen
                    System.out.print("\033[H\033[2J");
                    System.out.flush();

                    System.out.println("\n\n\1.Domestic Fights(1) \n\2.International Flights(2)");
                    System.out.print("\nPlease enter your option: ");
                    ch1=sc.nextInt();
                    switch(ch1)//inner switch case
                    {
                        case 1://for booking domestic ticket

                            d.addPassenger();
                            //getting passanger name
                            int c=0;
                            while(c!=1){
                                try {
                                    c = d.passengersList.get(d.passengerCurrCount).fname_check();
                                }
                                catch(InvalidFnameException e){
                                    System.out.println(e.getMessage());
                                }
                            }

                            //getting passanger age
                            c=0;
                            while(c!=1){
                                try {
                                    c = d.passengersList.get(d.passengerCurrCount).age_check();
                                }
                                catch(InvalidAgeException e){
                                    System.out.println(e.getMessage());
                                }
                            }

                            //getting passanger gender
                            c=0;
                            while(c!=1){
                                try {
                                    c = d.passengersList.get(d.passengerCurrCount).gender_check();
                                }
                                catch(InvalidGenderException e){
                                    System.out.println(e.getMessage());
                                }
                            }

                            //getting passanger monile number
                            c=0;
                            while(c!=1){
                                try {
                                    c = d.passengersList.get(d.passengerCurrCount).phoneNumber_check();
                                }
                                catch(InvalidMobileNumberException e){
                                    System.out.println(e.getMessage());
                                }
                            }

                            //getting passanger email
                            c=0;
                            while(c!=1){
                                try {
                                    c = d.passengersList.get(d.passengerCurrCount).email_check();
                                }
                                catch(InvalidEmailException e){
                                    System.out.println(e.getMessage());
                                }
                            }


                            d.j_detail();
                            p2.pay_detail();

                            break;
                        case 2: //for booking international ticket

                           i.addPassenger();
                            //getting passanger name
                             c=0;
                            while(c!=1){
                                try {
                                    c = i.intenationalPassengersList.get(i.intenationalPassengerCurrCount).fname_check();
                                }
                                catch(InvalidFnameException e){
                                    System.out.println(e.getMessage());
                                }
                            }

                            //getting passanger age
                            c=0;
                            while(c!=1){
                                try {
                                    c = i.intenationalPassengersList.get(i.intenationalPassengerCurrCount).age_check();
                                }
                                catch(InvalidAgeException e){
                                    System.out.println(e.getMessage());
                                }
                            }

                            //getting passanger gender
                            c=0;
                            while(c!=1){
                                try {
                                    c = i.intenationalPassengersList.get(i.intenationalPassengerCurrCount).gender_check();
                                }
                                catch(InvalidGenderException e){
                                    System.out.println(e.getMessage());
                                }
                            }

                            //getting passanger mobile number
                            c=0;
                            while(c!=1){
                                try {
                                    c = i.intenationalPassengersList.get(i.intenationalPassengerCurrCount).phoneNumber_check();
                                }
                                catch(InvalidMobileNumberException e){
                                    System.out.println(e.getMessage());
                                }
                            }

                            //getting passanger email
                            c=0;
                            while(c!=1){
                                try {
                                    c = i.intenationalPassengersList.get(i.intenationalPassengerCurrCount).email_check();
                                }
                                catch(InvalidEmailException e){
                                    System.out.println(e.getMessage());
                                }
                            }

                            i.j_detaili();
                            p2.pay_detail();

                            break;
                        default://wrong input
                            System.out.println("Wrong input entered\nTry again\n\n");
                            main(new String[1]);
                    }
                    break;
                case 2:
                    //for canceling ticket

                    //clearing the screen
                    System.out.print("\033[H\033[2J");
                    System.out.flush();

                    System.out.println("\1.Domestic Fights(1) \n\2.International Flights(2)");
                    System.out.print("\nPlease enter your option: ");
                    ch1=sc.nextInt();
                    if(ch1==1)
                    {
                        System.out.println("\nPlease enter your PNR no.:");
                        n=sc.nextInt();
                        d.cancelTicket(n);//function call for domestic booking cancellation
                    }
                    else if(ch1==2)
                    {   System.out.println("\nPlease enter your PNR no.:");
                        n=sc.nextInt();
                        i.cancelTicket(n);//function call for domestic booking cancellation
                    }
                    else
                    {
                        System.out.println("Wrong input entered\nTry again\n");
                        main(new String[1]);
                    }
                    break;
                case 3://for displaying booked ticket details

                    //clearing the screen
                    System.out.print("\033[H\033[2J");
                    System.out.flush();

                    System.out.println("\n\n\1.Domestic Fights(1) \n\2.International Flights(2)");
                    System.out.print("\nPlease enter your option: ");
                    ch1=sc.nextInt();
                    if(ch1==1)
                    {
                        System.out.println("\n\nPlease enter your PNR no.: ");;
                        n=sc.nextInt();
                        d.checkTicket(n);}//function call to display domestic ticket details
                    else if(ch1==2)
                    {
                        System.out.println("\n\nPlease enter your PNR no.: ");;
                        n=sc.nextInt();
                        i.checkTicketi(n);//function call to display domestic ticket details
                    }
                    else
                    {
                        System.out.println("Wrong input entered.\nTry again\n");
                        main(new String[1]);
                    }
                    break;

                     case 4:
                        //clearing the screen
                        System.out.print("\033[H\033[2J");
                        System.out.flush();
                        //sout
                        System.exit(0);

                default://for wrong input
                    System.out.println("Wrong input entered\nTry again.\n\n\n");
                    main(new String[1]);
            }
            System.out.println("\n\n\nDo you wish to continue:(y/Y)");
            input=sc.next().charAt(0);
        }while(input=='Y' || input=='y');

    }
}

