package com.cydeo.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.persistence.OneToOne;
import java.util.List;

@Entity
@Table(name="carts")
@Data
@NoArgsConstructor
public class Cart extends BaseEntity{

    @OneToOne(mappedBy = "cart")
    private Payment payment;

    @ManyToMany
    @JoinTable(name = "cart_item_rel", // changes the helper table name
    joinColumns = @JoinColumn(name="c_id"), // the foreignkey owner's column name
    inverseJoinColumns = @JoinColumn(name="i_id")) // the other class' column name
    private List<Item> itemList;
}
