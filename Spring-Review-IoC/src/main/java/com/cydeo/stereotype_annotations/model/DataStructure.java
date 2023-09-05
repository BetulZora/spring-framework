package com.cydeo.stereotype_annotations.model;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class DataStructure {
    ExtraHours extra;
    public void getTotalHours(){
        System.out.println("Total hours: " + (40+ extra.getHours()));
    }

}
