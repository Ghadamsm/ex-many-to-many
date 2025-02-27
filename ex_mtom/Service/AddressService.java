package com.example.ex_mtom.Service;

import com.example.ex_mtom.Api.ApiException;
import com.example.ex_mtom.DTO.AddressDTO;
import com.example.ex_mtom.Model.Address;
import com.example.ex_mtom.Model.Teacher;
import com.example.ex_mtom.Repository.AddressRepository;
import com.example.ex_mtom.Repository.TeacherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AddressService {


    private final AddressRepository addressRepository ;
    private final TeacherRepository teacherRepository ;

    public List<Address> get(){
        return addressRepository.findAll();
    }


    public void addAddress(AddressDTO addressDTO){

        Teacher t = teacherRepository.findTeacherById(addressDTO.getTeacher_id());

        if (t == null){
            throw new ApiException("customer not found");
        }

        Address address = new Address(null , addressDTO.getArea() , addressDTO.getStreet(), addressDTO.getBuildingNumber() , t);

        addressRepository.save(address);
    }



    public void update(AddressDTO addressDTO){

        Address a = addressRepository.findAddressById(addressDTO.getTeacher_id());

        if (a == null){
            throw new ApiException("teacher not found");
        }

        a.setArea(addressDTO.getArea());
        a.setStreet(addressDTO.getStreet());
        a.setBuildingNumber(addressDTO.getBuildingNumber());


        addressRepository.save(a);


    }




    public void delete(Integer id){
        Address a = addressRepository.findAddressById(id);

        if (a == null){
            throw new ApiException("teacher not found");
        }

        addressRepository.delete(a);

    }


}
