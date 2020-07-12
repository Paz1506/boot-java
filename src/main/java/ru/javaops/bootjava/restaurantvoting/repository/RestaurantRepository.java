package ru.javaops.bootjava.restaurantvoting.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.transaction.annotation.Transactional;
import ru.javaops.bootjava.restaurantvoting.model.Restaurant;

import java.util.Optional;
import java.util.Set;

/**
 * @author Pavel Zaytsev
 */
@Transactional
public interface RestaurantRepository extends JpaRepository<Restaurant, Integer> {

    @Transactional(readOnly = true)
    @RestResource(rel = "by-restaurant-name", path = "by-restaurant-name")
    Set<Restaurant> findByRestaurantNameContaining(String restaurantName);
}
