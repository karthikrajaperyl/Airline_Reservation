package Airline_reservation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.util.*;

public class PassengersDetails {
    private Long fid;
    private String name;
    private Long bookingId;
    private int NumberOfPassenger;
    private int totFare;
    
    // HashMap<Integer,String> confirmed=new HashMap<>();
    void setFlightId(Long id) {
        this.fid = id;
    }

    Long getFlightId() {
        return fid;
    }

    void setSeat(int seats) {
        this.NumberOfPassenger = seats;
    }

    int setSeat() {
        return NumberOfPassenger;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setBookingId(Long bookingId) {
        this.bookingId = bookingId;
    }

    public Long getBookingId() {
        return bookingId;
    }

    public void setTotalFare(int fare) {
        this.totFare = fare;
    }

    public int getTotalFare() {
        return totFare;
    }

    public boolean PassengersBooking() throws IOException, ParseException {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        boolean available = false;
       System.out.println("Enter your Name");
            setName(sc.readLine());
            System.out.println("Enter the boarding place ");
            String PassengerSource = sc.readLine();
            for (Map.Entry<Long, Flights> mp : Common.flightdetails.entrySet()) {
                Flights fob = mp.getValue();
                if (fob.getSource().equals(PassengerSource)) {
                    available = true;
                    System.out.println("Available Flights With destination \n" + fob.getFlightId() + " " + fob.getName()
                            + " " + fob.getSource() + " " + fob.getDestination() + " " + " " + fob.getSourcesDate()
                            + fob.getDestinationDate() + " " + fob.getfare() + " " + fob.getSeatcount());
                }
            }

            if (!(available)) {
                System.out.println("For Given place,Flight is not Available");
                for (Map.Entry<Long, Flights> mp : Common.flightdetails.entrySet()) {
                    Flights fob = mp.getValue();
                    System.out.println("Available Flights are");
                    System.out.println(fob.getFlightId() + " " + fob.getName() + " " + fob.getSource() + " "
                            + fob.getDestination() + " " + " " + fob.getSourcesDate() + fob.getDestinationDate() + " "
                            + fob.getfare() + " " + fob.getSeatcount());
                }
                System.out.println("Do you want to Continue  1 or 0");
                int n = Integer.parseInt(sc.readLine());
                if (n == 0) {
                    return false;
                }
            }

            System.out.println("Choose the Flight id to travel");
            Long fid =Long.parseLong(sc.readLine());
            Flights fob = Common.flightdetails.get(fid);
            while (fob == null) {
                System.out.println("please enter the right flightId");
                fob = Common.flightdetails.get(fid);
            }
            System.out.println("Enter the number of passenger");
            int NumberOfPassenger = Integer.parseInt(sc.readLine());
            while (fob.getSeatcount() < NumberOfPassenger) {
                System.out.println("Available seats are " + fob.getSeatcount() + "\nDo you want to Continue  1 or 0");
                int n = Integer.parseInt(sc.readLine());
                if (n == 0) {
                    return false;
                }
                System.out.println("again please enter  the number of passenger");
                NumberOfPassenger = Integer.parseInt(sc.readLine());
            }
            setSeat(NumberOfPassenger);
            fob.setSeatcount(fob.getSeatcount() - NumberOfPassenger);
            System.out.println("Do you want meals --1 or 0");
            
            int s = Integer.parseInt(sc.readLine());
           
            int fare = s == 1 ? NumberOfPassenger * (fob.getfare() + 500) : NumberOfPassenger * (fob.getfare());
            setTotalFare(fare);
            
                System.out.println("Total Amount:" + fare);
                Long uniqueId= System.currentTimeMillis();
                setBookingId(uniqueId);
                System.out.println("Flight Booked Successfully . yuor booking id " + uniqueId);
            
        return true;
    }

}
