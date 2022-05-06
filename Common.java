package Airline_reservation;

import java.util.*;

public class Common {
    public static Map<Long, Flights> flightdetails = new HashMap<>();
    public static Map<Long, PassengersDetails> passengerdetails = new HashMap<>();
   
@Override
    protected void finalize() {
	
        System.out.println("object is garbage collected");
    }

    public static void main(String[] args) {
    	 Scanner sc = new Scanner(System.in);
     try 
     {

        boolean con = true;
        int option = -1;
        while (con) {
            try {
                Thread.sleep(100);
                System.out.println(
                        "\n....ENTER YOUR CHOICE... \n1. adding Flight details \n2.available Flight Details \n3.cancel Flight Details \n4.booking a flight \n5.cancel the booking \n6.exit");
                option = sc.nextInt();
                if (option > 6)
                    System.out.println("\nPlease Enter The Input in Valid Number\n");
            } catch (InputMismatchException e) {
                System.out.println("\nPlease Enter The Input in Valid Number\n");
                sc.nextLine();
                continue;
                
            }

            switch (option) {
            case 1:
                Flights fob = new Flights();
                fob.addFlightRecords();
                System.out.println("flight details added successfully with flighitid "+fob.getFlightId());
                flightdetails.put(fob.getFlightId(), fob);
                break;
            case 2:
                boolean available = false;
                for (Map.Entry<Long, Flights> mp : flightdetails.entrySet()) {
                	System.out.println("Available Flights are");
                    Flights ob = mp.getValue();
                    available = true;
                    System.out.println(ob.getFlightId() + " " + ob.getName() + " " + ob.getSource() + " "
                            + ob.getDestination() + " " + " " + ob.getSourcesDate() + ob.getDestinationDate() + " "
                            + ob.getfare() + " " + ob.getSeatcount());
                }
                if (!available) {
                    System.out.println("there is no flight to show");
                }
                break;
            case 3:
                 boolean exist = false;
                System.out.println("Available Flights are");
                for (Map.Entry<Long, Flights> mp : flightdetails.entrySet()) {
                    Flights ob = mp.getValue();
                    exist = true;
                    System.out.println(ob.getFlightId() + " " + ob.getName() + " " + ob.getSource() + " "
                            + ob.getDestination() + " " + " " + ob.getSourcesDate() + ob.getDestinationDate() + " "
                            + ob.getfare() + " " + ob.getSeatcount());
                }
                if (!exist) {
                    System.out.println("there is no flight available");
                    continue;
                }
                System.out.println("Enter the flightId do you want to remove");
                Flights remFlightOb = flightdetails.remove(sc.nextLong());
                if (remFlightOb != null) {
                    System.out.println(" flight details canclled successfully");
                    remFlightOb = null;
                    System.gc();
                    System.runFinalization();
                }
                break;
            case 4:
                PassengersDetails pObj = new PassengersDetails();
                boolean sucess = pObj.PassengersBooking();
                if (!sucess) {
                    pObj=null;
                   System.gc();
                } else {
                    passengerdetails.put(pObj.getBookingId(), pObj);
                }
                break;
            case 5:
                System.out.println("Enter the booking do you want to cancel");
                PassengersDetails remPassobj = passengerdetails.remove(sc.nextLong());
                if (remPassobj != null) {
                    remPassobj = null;
                    System.out.println("your booking canclled successfully");
                   System.gc();
                    
                } else {
                    System.out.println("there is no booking id to cancel");
                    continue;
                }
            case 6:
                con = false;
                break;
            }
        }
}
        catch(Exception e)
        {
        	e.printStackTrace();
        }
        finally {
            System.gc();
        }
            
         // while ending
        System.out.println("programming terminated");
        sc.close();
    }

}
