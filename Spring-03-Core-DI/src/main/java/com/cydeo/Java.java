package com.cydeo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Java {

    /* Field injection like this is not recommended
    @Autowired
    OfficeHours officeHours;
     */
    public void getTeachingHours(){
        System.out.println("Weekly teaching hours : " + (20 + officeHours.getHours()));
    }
    OfficeHours officeHours;

    // This is injection into constructor and is the recommended method.
    // @Autowired // with one constructor this annotation is applied by default
    public Java(OfficeHours officeHours){
        this.officeHours = officeHours;
    }

}
