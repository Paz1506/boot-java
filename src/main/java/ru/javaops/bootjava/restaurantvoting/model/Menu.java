package ru.javaops.bootjava.restaurantvoting.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;

import static javax.persistence.FetchType.LAZY;

/**
 * @author Pavel Zaytsev
 */
@Entity
@Table(name = "menu", uniqueConstraints = {@UniqueConstraint(columnNames = {"offer_date", "name"})})
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)
public class Menu extends BaseEntity {

    @Column(name = "name", nullable = false)
    @NotNull
    @Size(min = 3, max = 255)
    private String name;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "menu_dishes",
               joinColumns = @JoinColumn(name = "menu_id"),
               inverseJoinColumns = @JoinColumn(name = "dish_id"))
    private List<Dish> dishes;

    @ManyToOne(fetch = LAZY, optional = false)
    @JoinColumn(name = "restaurant_id", nullable = false)
    private Restaurant restaurant;

    @Column(name = "offer_date", nullable = false)
    private Date offerDate;
}
