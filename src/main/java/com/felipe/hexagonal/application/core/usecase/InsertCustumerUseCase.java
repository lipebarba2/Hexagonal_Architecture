package com.felipe.hexagonal.application.core.usecase;

import com.felipe.hexagonal.application.core.domain.Customer;
import com.felipe.hexagonal.application.ports.out.FindAddressByZipCodeOutputPort;
import com.felipe.hexagonal.application.ports.out.InsertCustomerOutputPort;

public class InsertCustumerUseCase {

    private final FindAddressByZipCodeOutputPort findAddressByZipCodeOutputPort;

    private final InsertCustomerOutputPort insertCustomerOutputPort;

    public InsertCustumerUseCase(
            FindAddressByZipCodeOutputPort findAddressByZipCodeOutputPort,
            InsertCustomerOutputPort insertCustomerOutputPort
    ) {
        this.findAddressByZipCodeOutputPort = findAddressByZipCodeOutputPort;
        this.insertCustomerOutputPort = insertCustomerOutputPort;
    }

    public void insert(Customer customer, String zipCode) {
        var address = findAddressByZipCodeOutputPort.find(zipCode);
        customer.setAddress(address);
        insertCustomerOutputPort.insert(customer);


    }
}
