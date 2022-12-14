package edu.hanoi.service.springhnservice.service;

import edu.hanoi.service.springhnservice.DAO.UserDAO;
import edu.hanoi.service.springhnservice.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class HnUserAuthProvider implements AuthenticationProvider {
    @Autowired
    private UserDAO userDAO;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
       String username = authentication.getName().toString();
       User user = userDAO.get(username);
       if (user == null) return null;

       if (!user.getPassword().equals(authentication.getCredentials())) return null;

       return successful(username, authentication.getCredentials().toString(),"ROLE_USER");
    }
    
    private UsernamePasswordAuthenticationToken successful(String username, String password, String role){
        ArrayList<GrantedAuthority> grantedAuthorities = new ArrayList<>();
        grantedAuthorities.add(new SimpleGrantedAuthority(role));
        return new UsernamePasswordAuthenticationToken(username, password, grantedAuthorities);
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }
}
