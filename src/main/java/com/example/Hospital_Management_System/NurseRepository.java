package com.example.Hospital_Management_System;

import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

@Repository
public class NurseRepository {
    //This is a class that will contain the database (HashMap,Mysql)

    HashMap<Integer,Nurse> nurseDb = new HashMap<>();

    public String addNurse(Nurse nurse){
        int key = nurse.getNurseId();
        nurseDb.put(key,nurse);
        return "Nurse Added Successfully";
    }
    public List<Nurse> getAllNurses(){
        return nurseDb.values().stream().toList();
    }
}
