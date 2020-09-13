/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.entities;

/**
 *
 * @author dypad
 */
public class Invoice {

    private Double basicPayments;
    private Double tax;

    public Invoice() {
    }

    public Invoice(Double basicPayments, Double tax) {
        this.basicPayments = basicPayments;
        this.tax = tax;
    }

    public Double getBasicPayments() {
        return basicPayments;
    }

    public void setBasicPayments(Double basicPayments) {
        this.basicPayments = basicPayments;
    }

    public Double getTax() {
        return tax;
    }

    public void setTax(Double tax) {
        this.tax = tax;
    }

    public Double getTotalPayment() {

        return getBasicPayments() + getTax();
    }

}
