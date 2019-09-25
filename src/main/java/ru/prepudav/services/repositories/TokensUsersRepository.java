package ru.prepudav.services.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.prepudav.services.models.UserToken;

import java.util.Optional;

public interface TokensUsersRepository extends JpaRepository<UserToken, Long> {
    Optional<UserToken> findOneByValue(String value);
}
