package ru.javaops.bootjava.restaurantvoting.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.transaction.annotation.Transactional;
import ru.javaops.bootjava.restaurantvoting.model.Menu;

import java.util.Date;
import java.util.Optional;
import java.util.Set;

/**
 * @author Pavel Zaytsev
 */
@Transactional
public interface MenuRepository extends JpaRepository<Menu, Integer> {

    @Transactional(readOnly = true)
    @RestResource(rel = "by-name", path = "by-name")
    Optional<Menu> findByNameContaining(String name);

    @Transactional(readOnly = true)
    @RestResource(rel = "by-create-between", path = "by-create-between")
    Set<Menu> findByCreateDateBetween(Date from, Date to);
}
