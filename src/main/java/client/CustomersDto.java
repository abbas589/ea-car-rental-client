package client;

import java.util.Collection;

/**
 * @author bazz
 * Apr 24 2023
 * 18:15
 */
public class CustomersDto {
    Collection<CustomerDto> customers;

    public Collection<CustomerDto> getCustomers() {
        return customers;
    }

    public void setCustomers(Collection<CustomerDto> customers) {
        this.customers = customers;
    }

    public CustomersDto(Collection<CustomerDto> customers) {
        this.customers = customers;
    }

    public CustomersDto(){}

    @Override
    public String toString() {
        return "CustomersDto{" +
                "customers=" + customers +
                '}';
    }
}
