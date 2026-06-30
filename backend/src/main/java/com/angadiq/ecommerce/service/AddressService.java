package com.angadiq.ecommerce.service;

import java.util.List;

import com.angadiq.ecommerce.entity.Address;

public interface AddressService {

    Address createAddress(

            Address address

    );

    List<Address> getAddressesByUser(

            Long userId

    );

}
