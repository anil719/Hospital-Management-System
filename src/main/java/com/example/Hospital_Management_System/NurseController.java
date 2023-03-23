package com.example.Hospital_Management_System;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/nurse")
public class NurseController {

    NurseService nurseService = new NurseService();
    @PostMapping("/add")
    public String addNurse(@RequestBody Nurse nurse){
        String ans = nurseService.addNurse(nurse);
        return ans;
    }
    @GetMapping("/getList")
    public List<Nurse> getNursesGreaterThanAge(@RequestParam("age")Integer age){
         List<Nurse> nurseList =  nurseService.getList(age);
         return nurseList;
    }

    @GetMapping("/getByQualification")
    public List<Nurse> getNursesByQualification(@RequestParam("Qualification")String qualification){
        List<Nurse> nurses = nurseService.getNursesByQualification(qualification);
        return nurses;
    }
}
