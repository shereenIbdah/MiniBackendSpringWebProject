package com.example.employee.controller;

import com.example.employee.model.Address;
import com.example.employee.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/address")
public class AddressController {
    private final AddressService addressService;

    @Autowired
    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }

    @PostMapping(path = "/addAddress")
    public void addAddress(@RequestBody Address address) {
        addressService.addAddress(address);
    }

    @GetMapping("/allAddress")
    public List<Address> getAddresses() {
        return addressService.getAddresses();
    }

    @DeleteMapping(path = "/deleteAddress/{addressId}")
    public void deleteAddress(@PathVariable("addressId") Long addressId) {
        addressService.deleteAddress(addressId);
    }

    @PutMapping(path = "{addressId}")
    public void updateAddress(@PathVariable("addressId") Long addressId,
                              @RequestParam(required = true) String location) {
        addressService.updateAddress(addressId, location);
    }
}
