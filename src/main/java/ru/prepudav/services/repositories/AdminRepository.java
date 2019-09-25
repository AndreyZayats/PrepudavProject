package ru.prepudav.services.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.prepudav.services.models.Admin;

import java.util.List;
import java.util.Optional;

public interface AdminRepository extends JpaRepository<Admin, Long> {
    List<Admin> findAllByFirstName(String firstName);

    Optional<Admin> findOneByLogin(String login);
}
