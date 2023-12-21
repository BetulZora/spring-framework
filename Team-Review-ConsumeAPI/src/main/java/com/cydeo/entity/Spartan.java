
package com.cydeo.entity;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "id",
    "name",
    "gender",
    "phone"
})
@Getter
@Setter
@Entity
@NoArgsConstructor
public class Spartan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long LocalId;

    @JsonProperty("id")
    public Long id;
    @JsonProperty("name")
    public String name;
    @JsonProperty("gender")
    public String gender;
    @JsonProperty("phone")
    public Long phone;

}
