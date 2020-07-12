package ru.javaops.bootjava.restaurantvoting.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.transaction.annotation.Transactional;
import ru.javaops.bootjava.restaurantvoting.model.Menu;

import java.util.Date;
import java.util.Set;

/**
 * @author Pavel Zaytsev
 */
@Transactional
public interface MenuRepository extends JpaRepository<Menu, Integer> {

    @Transactional(readOnly = true)
    @RestResource(rel = "by-menu-name", path = "by-menu-name")
    Set<Menu> findByMenuNameContaining(String menuName);

    @Transactional(readOnly = true)
    @RestResource(rel = "by-restaurantId", path = "by-restaurantId")
    Set<Menu> findByRestaurantId(Integer restaurantId);

    @Transactional(readOnly = true)
    @RestResource(rel = "by-create-between", path = "by-create-between")
    Set<Menu> findByCreateDateBetween(Date from, Date to);

    @Transactional(readOnly = true)
    @RestResource(rel = "by-offer-date-between", path = "by-offer-date-between")
    Set<Menu> findByOfferDateBetween(Date from, Date to);

    @Transactional(readOnly = true)
    @RestResource(rel = "by-restaurant-and-offer-date-between", path = "by-restaurant-and-offer-date-between")
    Set<Menu> findByRestaurantIdAndOfferDateBetween(Integer restaurantId, Date from, Date to);
}
