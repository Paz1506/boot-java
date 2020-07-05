package ru.javaops.bootjava.restaurantvoting.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.transaction.annotation.Transactional;
import ru.javaops.bootjava.restaurantvoting.model.Dish;

import java.util.Optional;
import java.util.Set;

/**
 * @author Pavel Zaytsev
 */
@Transactional
public interface DishRepository extends JpaRepository<Dish, Integer> {

    @Transactional(readOnly = true)
    @RestResource(rel = "by-name", path = "by-name")
    Optional<Dish> findByNameContaining(String name);

    @Transactional(readOnly = true)
    @RestResource(rel = "by-price-interval", path = "by-price-interval")
    Set<Dish> findByPriceBetween(Integer from, Integer to);


}
