package Airline_reservation;

import java.util.*;


import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Flights {
    private Long flightId;
    private String name;
    private String source;
    private String destination;
    private int NumberofSeats;
    private Date SourceDate;
    private Date desDate;
    private int fare = 0;

    void setFlightId(Long id) {
        this.flightId = id;
    }

    Long getFlightId() {
        return flightId;
    }

    void setName(String name) {
        this.name = name;
    }

    String getName() {
        return name;
    }

    void setSource(String source) {
        this.source = source;
    }

    String getSource() {
        return source;
    }

    void setDestination(String destination) {
        this.destination = destination;
    }

    String getDestination() {
        return destination;
    }

    void setfare(int amount) {
        this.fare = amount;
    }

    int getfare() {
        return fare;
    }

    void setSourcesDate(Date str) {
        this.SourceDate = str;
    }

    Date getSourcesDate() {
        return SourceDate;
    }

    void setDestinationDate(Date str) {
        this.desDate = str;
    }

    Date getDestinationDate() {
        return desDate;
    }

    public void setSeatcount(int seat) {
        NumberofSeats = seat;
    }

    public int getSeatcount() {
        return NumberofSeats;
    }

    public void addFlightRecords() throws IOException, ParseException {

//    Scanner sc=new Scanner(System.in);
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter the flight name - ");
            String fname = sc.readLine();
            setName(fname);
            System.out.println("Enter The maximum number of passensger can Accomodate");
           setSeatcount(Integer.parseInt(sc.readLine()));
            System.out.println("Enter the starting date in dd-MMM-yyy HH:mm:ss ( Eg :22-may-2020 23:03:22)");
            String source = sc.readLine();
            Date date1 = new SimpleDateFormat("dd-MMM-yyy HH:mm:ss").parse(source);
            setSourcesDate(date1);
            System.out.println("Enter the ending date in dd-MMM-yyy HH:mm:ss");
            String destination = sc.readLine();
            Date date2 = new SimpleDateFormat("dd-MMM-yyy HH:mm:ss").parse(destination);
            setDestinationDate(date2);
            System.out.println("Enter the flight Source country");
            String sourcename = sc.readLine();
            setSource(sourcename);
            System.out.println("Enter the flight destination country");
            String destname = sc.readLine();
            setDestination(destname);
            System.out.println("Enter the price amount");
            setfare(Integer.parseInt(sc.readLine()));
            Long uniqueId= System.currentTimeMillis();
            setFlightId(uniqueId);

    }
}
