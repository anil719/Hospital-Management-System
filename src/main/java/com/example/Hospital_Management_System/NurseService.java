package com.example.Hospital_Management_System;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class NurseService {

    NurseRepository nurseRepository = new NurseRepository();
    public String addNurse(Nurse nurse){
        if(nurse.getNurseId() < 0) return "Enter a valid nurseId";

        String ans = nurseRepository.addNurse(nurse);
        return ans;
    }
    public List<Nurse> getList(int age){
        List<Nurse> nurses = nurseRepository.getAllNurses();

        //Now im writing logic to extract required
        List<Nurse> finalList = new ArrayList<>();
        for(Nurse nurse : nurses){
            if(nurse.getAge()> age)
                finalList.add(nurse);
        }
        return  finalList;
    }
    public List<Nurse> getNursesByQualification(String qualification){
        List<Nurse> nurseList = nurseRepository.getAllNurses();
        //logic to filter based on qualification
        List<Nurse> finalNurseList = new ArrayList<>();
        for(Nurse nurse : nurseList){
            if(nurse.getQualification().equals(qualification))
                finalNurseList.add(nurse);
        }
        return finalNurseList;
    }
}
