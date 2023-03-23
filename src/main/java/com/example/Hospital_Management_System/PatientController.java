package com.example.Hospital_Management_System;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/Patient")
public class PatientController {
    Map<Integer, Patient> patientDb = new HashMap<>();
    @PostMapping("/addViaParameters")
    public String addPatient(@RequestParam("patientId")Integer patientId, @RequestParam("name")String name,
                             @RequestParam("disease")String disease, @RequestParam("age")Integer age){
        Patient patient = new Patient(patientId, name, disease, age);
        patientDb.put(patientId, patient);
        return "Patient added successfully";
    }

    @PostMapping("/addViaRequestBody")
    public String addPatient(@RequestBody Patient patient){
        int patientId = patient.getPatientId();
        patientDb.put(patientId, patient);
        return "Patient Added via RequestBody";
    }

    @GetMapping("/getInfo")
    public Patient getPatientInfo(@RequestParam("patientId")Integer patientId){

        Patient patient =  patientDb.get(patientId);
        return patient;
    }

    @GetMapping("/getAllDetails")
    public List<Patient> getAllPatients(){
        List<Patient> list = new ArrayList<>();
        for(Patient p : patientDb.values()){
            list.add(p);
        }
        return  list;
    }
    @GetMapping("/getByName")
    public Patient getPatientDetail(@RequestParam("name")String name){
        for(Patient p : patientDb.values()){
            if(p.getName().equals(name)) return p;
        }
        return null;
    }
    @GetMapping("/getPatientsGreaterThanAnAge")
    public List<Patient> getAllPatients(@RequestParam("age")Integer age){

        List<Patient> list = new ArrayList<>();
        for(Patient p : patientDb.values()){
            if(p.getAge() > age) list.add(p);
        }
        return list;
    }
    @GetMapping("/getViaPathVariable/{patientId}")
    public Patient getPatient(@PathVariable("patientId")Integer patientId){
        Patient patient = patientDb.get(patientId);
        return patient;
    }

    @GetMapping("/getPatientViaPathVariable/{age}/{disease}")
    public List<Patient> getPatientViaPathVariables(@PathVariable("age")Integer age,
                                              @PathVariable("disease")String disease){
        List<Patient> list = new ArrayList<>();

        for(Patient p : patientDb.values()){
            if(p.getAge() > age && p.getDisease().equals(disease)){
                list.add(p);
            }
        }
        return list;
    }

    @PutMapping("/updatePatientDetails")
    public String update(@RequestBody Patient patient){

        int key = patient.getPatientId();
        if(patientDb.containsKey(key)) {
            patientDb.put(key, patient);
            return "updated Patient successfully";
        }
        else return "data was not found";
    }

    @DeleteMapping("/deletePatient")
    public String delete(@RequestBody Patient patient){
        int key = patient.getPatientId();
            patientDb.remove(key);
            return "Patient Deleted Successfully";
    }
    @PutMapping("/updateDisease/")
    public String updateDisease(@RequestParam("patientId")Integer patientId,
                                @RequestParam("disease")String disease){
        if(patientDb.containsKey(patientId)){
            Patient patient = patientDb.get(patientId);
            patient.setDisease(disease);
            patientDb.put(patientId, patient);
            return "Updated Successfully" ;
        }
        return "Patient Does not Exist";
    }

}
