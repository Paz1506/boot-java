package ru.javaops.bootjava.restaurantvoting.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * @author Pavel Zaytsev
 */
@Entity
@Table(name = "restaurant")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)
public class Restaurant extends BaseEntity {

    @Column(name = "restaurant_name", nullable = false, unique = true)
    @NotNull
    @Size(min = 3, max = 255)
    private String restaurantName;
}
