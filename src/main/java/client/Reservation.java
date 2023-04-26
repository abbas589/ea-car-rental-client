package client;



import java.time.LocalDate;

/**
 * @author bazz
 * Apr 23 2023
 * 15:01
 */

public class Reservation {

    private Long id;
    private String licensePlate;

    private String reservationStatus;

    private LocalDate startDate;
    private LocalDate endDate;
    private LocalDate pickupDate;
    private LocalDate returnDate;

    private Customer customer;


    private Payment payment;


    public Reservation(String licensePlate, LocalDate startDate, LocalDate endDate, Customer customer) {
        this.licensePlate = licensePlate;
        this.startDate = startDate;
        this.endDate = endDate;
        this.customer = customer;
    }

    public Reservation() {
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public LocalDate getPickupDate() {
        return pickupDate;
    }

    public void setPickupDate(LocalDate pickupDate) {
        this.pickupDate = pickupDate;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    public String getReservationStatus() {
        return reservationStatus;
    }

    public void setReservationStatus(String reservationStatus) {
        this.reservationStatus = reservationStatus;
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "id=" + id +
                ", licensePlate='" + licensePlate + '\'' +
                ", reservationStatus=" + reservationStatus +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", pickupDate=" + pickupDate +
                ", returnDate=" + returnDate +
                ", customer=" + customer +
                ", payment=" + payment +
                '}';
    }
}
