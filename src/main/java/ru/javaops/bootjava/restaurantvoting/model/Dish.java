package ru.javaops.bootjava.restaurantvoting.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import org.hibernate.validator.constraints.Range;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import static javax.persistence.FetchType.EAGER;

/**
 * @author Pavel Zaytsev
 */
@Entity
@Table(name = "dish")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)
public class Dish extends BaseEntity {

    @Column(name = "dish_name", nullable = false, unique = true)
    @NotNull
    @Size(min = 3, max = 255)
    private String dishName;

    @ManyToOne(fetch = EAGER, optional = false)
    @JoinColumn(name = "menu_id", nullable = false)
    private Menu menu;

    @Column(name = "price", nullable = false)
    @NotNull
    @Range(min = 30, max = 10000)
    private Integer price;
}
