/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;
import model.entities.CarRental;
import model.entities.Vehicle;
import model.services.BrasilTaxServices;
import model.services.RentalService;

/**
 *
 * @author dypad
 */
public class Program {

    /**
     * @param args the command line arguments
     * @throws java.text.ParseException
     */
    public static void main(String[] args) throws ParseException {
       
        Locale.setDefault(Locale.US);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:ss");
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Enter rental data:");
        System.out.println("Car model:");
        String carModel = sc.nextLine();
        System.out.println("PickUp:");
        Date start = sdf.parse(sc.nextLine());
        System.out.println("Return :");
        Date finish = sdf.parse(sc.nextLine());
        
        CarRental cr = new CarRental(start, finish, new Vehicle(carModel));
        
        System.out.println("Price per hour:");
        double pricePerHour = sc.nextDouble();
        System.out.println("Price per day:");
        double pricePerDay = sc.nextDouble();
        
        RentalService rentalService = new RentalService(pricePerDay, pricePerHour, new BrasilTaxServices());
        
        rentalService.processInvoice(cr);
        
        System.out.println("INVOICE:");
        System.out.println("Basic Payment: "+String.format("%.2f", cr.getInvoice().getBasicPayments()));
        System.out.println("Tax : "+ String.format("%.2f", cr.getInvoice().getTax()));
        System.out.println("Total Payment: " + String.format("%.2f", cr.getInvoice().getTotalPayment()));
        
        sc.close();
        
    }
    
}
