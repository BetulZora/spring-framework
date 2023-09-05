package com.cydeo.stereotype_annotations.model;

import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@NoArgsConstructor
@Component
public class ExtraHours {

    public Integer getHours(){
        return 10;
    }
}
