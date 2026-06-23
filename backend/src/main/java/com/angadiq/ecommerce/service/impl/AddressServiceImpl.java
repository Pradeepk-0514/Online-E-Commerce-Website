package com.angadiq.ecommerce.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.angadiq.ecommerce.entity.Address;
import com.angadiq.ecommerce.repository.AddressRepository;
import com.angadiq.ecommerce.service.AddressService;

@Service

public class AddressServiceImpl

        implements AddressService {

    private final AddressRepository addressRepository;

    public AddressServiceImpl(

            AddressRepository addressRepository

    ) {

        this.addressRepository = addressRepository;

    }

    @Override

    public Address createAddress(

            Address address

    ) {

        return addressRepository.save(

                address

        );

    }

    @Override

    public List<Address> getAddressesByUser(

            Long userId

    ) {

        return addressRepository.findByUserId(

                userId

        );

    }

}