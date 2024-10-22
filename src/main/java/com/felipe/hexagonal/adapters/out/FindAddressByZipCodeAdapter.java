package com.felipe.hexagonal.adapters.out;

import com.felipe.hexagonal.adapters.out.client.FindAdressByZipCodeClient;
import com.felipe.hexagonal.adapters.out.client.mapper.AddressResponseMapper;
import com.felipe.hexagonal.application.core.domain.Address;
import com.felipe.hexagonal.application.ports.out.FindAddressByZipCodeOutputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FindAddressByZipCodeAdapter implements FindAddressByZipCodeOutputPort {

    @Autowired
    private FindAdressByZipCodeClient findAdressByZipCodeClient;

    @Autowired
    private AddressResponseMapper addressResponseMapper;

    @Override
    public Address find(String zipCode) {
        var adressResponse  = findAdressByZipCodeClient.find(zipCode);
        return addressResponseMapper.toAddress(adressResponse);
    }
}
