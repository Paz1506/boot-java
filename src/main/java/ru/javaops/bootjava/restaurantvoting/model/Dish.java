package ru.javaops.bootjava.restaurantvoting.model;

import lombok.*;
import org.hibernate.validator.constraints.Range;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

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

    @Column(name = "name", nullable = false, unique = true)
    @NotNull
    @Size(min = 3, max = 255)
    private String name;

    @Column(name = "price", nullable = false)
    @NotNull
    @Range(min = 50, max = 10000)
    private Integer price;
}
