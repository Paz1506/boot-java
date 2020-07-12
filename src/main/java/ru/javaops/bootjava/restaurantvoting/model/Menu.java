package ru.javaops.bootjava.restaurantvoting.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;

import static javax.persistence.FetchType.EAGER;
import static javax.persistence.FetchType.LAZY;

/**
 * @author Pavel Zaytsev
 */
@Entity
@Table(name = "menu")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)
public class Menu extends BaseEntity {

    @Column(name = "menu_name", nullable = false, unique = true)
    @NotNull
    @Size(min = 3, max = 255)
    private String menuName;

    @NotNull
    @Column(name = "offer_date", nullable = false, updatable = false)
    private Date offerDate;

    @ManyToOne(fetch = EAGER, optional = false)
    @JoinColumn(name = "restaurant_id", nullable = false)
    private Restaurant restaurant;
}
