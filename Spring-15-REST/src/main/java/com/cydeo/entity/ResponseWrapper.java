package com.cydeo.entity;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
@NoArgsConstructor
public class ResponseWrapper {

    private boolean success;
    private String message;
    private Integer code;
    private Object data;

    // having the message be a part of the constructor allows us to create custom messages when calling the constructor
    public ResponseWrapper(String message, Object data) {
        this.success = true; // for now hardcoding it
        this.message = message;
        this.code = HttpStatus.OK.value(); // for now hardcoding it
        this.data = data;
    }

    public ResponseWrapper(String message) { // a simpler constructor shown as an example
        this.message = message;
        this.code = HttpStatus.OK.value();
        this.success = true;
    }

    public ResponseWrapper(String message, Object data, HttpStatus status) {
        this.success = true; // for now hardcoding it
        this.message = message;
        this.code = status.value(); //
        this.data = data;
    }

    public ResponseWrapper(String message, HttpStatus status) { //
        this.message = message;
        this.code = status.value();
        this.success = true;
    }


}
