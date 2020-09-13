/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.services;

import model.entities.CarRental;
import model.entities.Invoice;

/**
 *
 * @author dypad
 */
public class RentalService {

    private Double pricePerDay;
    private Double pricePerHour;

    private TaxService taxService;

    public RentalService(Double pricePerDay, Double pricePerHour, TaxService taxService) {
        super();
        this.pricePerDay = pricePerDay;
        this.pricePerHour = pricePerHour;
        this.taxService = taxService;
    }

    public void processInvoice(CarRental carRental) {

        long t1 = carRental.getStart().getTime();
        long t2 = carRental.getFinish().getTime();

        double hour = (double) (t2 - t1) / 1000 / 60 / 60;
        double basicPayment;
        if (hour <= 12) {
            basicPayment = Math.ceil(hour) * pricePerHour;

        } else {
            basicPayment = Math.ceil(hour / 24) * pricePerDay;
        }
        double tax = taxService.tax(basicPayment);

        carRental.setInvoice(new Invoice(basicPayment, tax));
    }

}
