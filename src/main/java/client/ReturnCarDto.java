package client;

import java.math.BigDecimal;

/**
 * @author bazz
 * Apr 25 2023
 * 14:40
 */
public class ReturnCarDto {
    private String creditCardNumber;
    private String cardCvv;
    private BigDecimal amountPaid;
    private String paymentType;
    private Long customerNumber;


    public String getCreditCardNumber() {
        return creditCardNumber;
    }

    public void setCreditCardNumber(String creditCardNumber) {
        this.creditCardNumber = creditCardNumber;
    }

    public String getCardCvv() {
        return cardCvv;
    }

    public void setCardCvv(String cardCvv) {
        this.cardCvv = cardCvv;
    }

    public BigDecimal getAmountPaid() {
        return amountPaid;
    }

    public void setAmountPaid(BigDecimal amountPaid) {
        this.amountPaid = amountPaid;
    }

    public String getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }

    public Long getCustomerNumber() {
        return customerNumber;
    }

    public void setCustomerNumber(Long customerNumber) {
        this.customerNumber = customerNumber;
    }


    public ReturnCarDto(String creditCardNumber, String cardCvv, BigDecimal amountPaid, String paymentType, Long customerNumber) {
        this.creditCardNumber = creditCardNumber;
        this.cardCvv = cardCvv;
        this.amountPaid = amountPaid;
        this.paymentType = paymentType;
        this.customerNumber = customerNumber;
    }
}
