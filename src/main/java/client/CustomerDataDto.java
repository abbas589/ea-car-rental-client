package client;

import java.util.List;

/**
 * @author bazz
 * Apr 26 2023
 * 14:36
 */
public class CustomerDataDto {
    private CustomerDto customer;
    private List<Reservation> reservations;
    private List<Payment> payments;

    public CustomerDto getCustomer() {
        return customer;
    }

    public void setCustomer(CustomerDto customer) {
        this.customer = customer;
    }

    public List<Reservation> getReservations() {
        return reservations;
    }

    public void setReservations(List<Reservation> reservations) {
        this.reservations = reservations;
    }

    public List<Payment> getPayments() {
        return payments;
    }

    public void setPayments(List<Payment> payments) {
        this.payments = payments;
    }

    @Override
    public String toString() {
        return "CustomerDataDto{" +
                "customer=" + customer +
                ", reservations=" + reservations +
                ", payments=" + payments +
                '}';
    }
}
