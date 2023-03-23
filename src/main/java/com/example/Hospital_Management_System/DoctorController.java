package com.example.Hospital_Management_System;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/Doctor")
public class DoctorController {
    Map<Integer, Doctor> doctorDb = new HashMap<>();
    @PostMapping("/add")
    public String addDoctor(@RequestBody Doctor doctor){
        int doctorId = doctor.getDoctorId();
        doctorDb.put(doctorId, doctor);
        return "Doctor Added successfully";
    }
}
