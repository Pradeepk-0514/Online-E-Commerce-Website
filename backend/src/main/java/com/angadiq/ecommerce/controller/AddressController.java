package com.angadiq.ecommerce.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.angadiq.ecommerce.entity.Address;
import com.angadiq.ecommerce.service.AddressService;

@RestController

@RequestMapping("/api/addresses")

public class AddressController {

    private final AddressService addressService;

    public AddressController(

            AddressService addressService

    ) {

        this.addressService = addressService;

    }

    @PostMapping

    public ResponseEntity<Address>

    createAddress(

            @RequestBody Address address

    ) {

        return ResponseEntity.ok(

                addressService.createAddress(

                        address

                )

        );

    }

    @GetMapping("/{userId}")

    public ResponseEntity<List<Address>>

    getAddresses(

            @PathVariable Long userId

    ) {

        return ResponseEntity.ok(

                addressService.getAddressesByUser(

                        userId

                )

        );

    }

}