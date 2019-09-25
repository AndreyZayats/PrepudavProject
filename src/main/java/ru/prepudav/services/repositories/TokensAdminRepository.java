package ru.prepudav.services.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.prepudav.services.models.AdminToken;

import java.util.Optional;

public interface TokensAdminRepository extends JpaRepository<AdminToken, Long> {
    Optional<AdminToken> findOneByValue(String value);
}
