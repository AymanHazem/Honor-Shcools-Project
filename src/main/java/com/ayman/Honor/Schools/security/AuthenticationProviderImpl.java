package com.ayman.Honor.Schools.security;

import com.ayman.Honor.Schools.model.Person;
import com.ayman.Honor.Schools.model.Roles;
import com.ayman.Honor.Schools.repository.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Component
public class AuthenticationProviderImpl implements AuthenticationProvider
{
    private final PersonRepository personRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException
    {
        String email=authentication.getName();
        String password=authentication.getCredentials().toString();
        Person user = personRepository.getByEmail(email);
        if (null !=user && user.getPersonId()>0 && passwordEncoder.matches(password, user.getPwd()))
            return new UsernamePasswordAuthenticationToken(user.getName(),null,getGrantedAuthorities(user.getRoles()));
        else
            throw new BadCredentialsException("Invalid credentials!");
    }

    public List<GrantedAuthority> getGrantedAuthorities(Roles role)
    {
        List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
        grantedAuthorities.add(new SimpleGrantedAuthority("ROLE_"+role.getRoleName()));
        return grantedAuthorities;
    }







    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }
}
