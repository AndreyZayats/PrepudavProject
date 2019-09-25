package ru.prepudav.services.security.provider;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;
import ru.prepudav.services.models.AdminToken;
import ru.prepudav.services.repositories.TokensAdminRepository;
import ru.prepudav.services.security.token.TokenAuthentication;

import java.util.Optional;

@Component
public class AdminTokenAuthentacationProvider implements AuthenticationProvider {
    @Autowired
    private TokensAdminRepository tokensAdminRepository;

    @Qualifier("adminDetailsServiceImpl")
    @Autowired
    private UserDetailsService userDetailsService;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        TokenAuthentication tokenAuthentication = (TokenAuthentication) authentication;

        Optional<AdminToken> tokenCandidate = tokensAdminRepository.findOneByValue(tokenAuthentication.getName());

        if(tokenCandidate.isPresent()) {
            UserDetails userDetails = userDetailsService.loadUserByUsername(tokenCandidate.get().getAdmin().getLogin());

            tokenAuthentication.setUserDetails(userDetails);
            tokenAuthentication.setAuthenticated(true);
            return tokenAuthentication;
        } else throw new IllegalArgumentException("Bad token");
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return TokenAuthentication.class.equals(authentication);
    }
}
