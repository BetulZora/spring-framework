package com.cydeo.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="items")
@Data
@NoArgsConstructor
public class Item extends BaseEntity{

    private String code;
    private String name;

    public Item(String code, String name) {
        this.code = code;
        this.name = name;
    }

    @ManyToMany(mappedBy = "itemList") //mappedBy defines the ForeignKey owner
    // The foreign key owner is designated arbitrarily, can be any of the pair.
    private List<Cart> carts;
}
