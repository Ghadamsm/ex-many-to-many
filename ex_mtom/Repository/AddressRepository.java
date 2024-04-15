package com.example.ex_mtom.Repository;

import com.example.ex_mtom.Model.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Integer> {

    Address findAddressById(Integer id);


}
