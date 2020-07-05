package ru.javaops.bootjava.restaurantvoting.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.transaction.annotation.Transactional;
import ru.javaops.bootjava.restaurantvoting.model.Menu;
import ru.javaops.bootjava.restaurantvoting.model.Offer;

import java.util.Date;
import java.util.Optional;
import java.util.Set;

/**
 * @author Pavel Zaytsev
 */
@Transactional
public interface OfferRepository extends JpaRepository<Offer, Integer> {

    @Transactional(readOnly = true)
    @RestResource(rel = "by-restaurant-id-and-offer-between", path = "by-restaurant-id-and-offer-between")
    Set<Offer> findByRestaurantIdAndOfferDateBetween(Integer restaurantId, Date from, Date to);

    @Transactional(readOnly = true)
    @RestResource(rel = "by-menu-ids-and-create-between", path = "by-menu-ids-and-create-between")
    Set<Offer> findByMenusIdInAndOfferDateBetween(Set<Integer> menusIds, Date from, Date to);
}
