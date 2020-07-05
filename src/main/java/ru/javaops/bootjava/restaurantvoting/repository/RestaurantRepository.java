package ru.javaops.bootjava.restaurantvoting.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.transaction.annotation.Transactional;
import ru.javaops.bootjava.restaurantvoting.model.Restaurant;

import java.util.Optional;

/**
 * @author Pavel Zaytsev
 */
@Transactional
public interface RestaurantRepository extends JpaRepository<Restaurant, Integer> {

    @Transactional(readOnly = true)
    @RestResource(rel = "by-name", path = "by-name")
    Optional<Restaurant> findByNameContaining(String name);
}
