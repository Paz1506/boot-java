package ru.javaops.bootjava.restaurantvoting.model;

import lombok.*;
import org.hibernate.validator.constraints.Range;

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
@Table(name = "offer", uniqueConstraints = {@UniqueConstraint(columnNames = {"offer_date", "restaurant_id"})})
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)
public class Offer extends BaseEntity {

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "offer_menus",
               joinColumns = @JoinColumn(name = "offer_id"),
               inverseJoinColumns = @JoinColumn(name = "menu_id"))
    private List<Menu> menus;

    @NotNull
    @Column(name = "offer_date", nullable = false, updatable = false)
    private Date offerDate;

    @ManyToOne(fetch = LAZY, optional = false)
    @JoinColumn(name = "restaurant_id", nullable = false)
    private Restaurant restaurant;
}
