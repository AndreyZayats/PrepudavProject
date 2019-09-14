package ru.prepudav.services.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.prepudav.services.models.Token;

import java.util.Optional;

public interface TokensRepository extends JpaRepository<Token, Long> {
    Optional<Token> findOneByValue(String value);
}
