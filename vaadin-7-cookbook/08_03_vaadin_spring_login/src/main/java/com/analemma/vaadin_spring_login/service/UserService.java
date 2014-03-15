package com.analemma.vaadin_spring_login.service;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.core.userdetails.User;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Ondrej Kvasnovsky
 */
public class UserService implements UserDetailsService {

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
    // fetch user from e.g. DB
    if ("client".equals(username)) {
      authorities.add(new SimpleGrantedAuthority("CLIENT"));
      User user = new User(username, "pass", true, true, false, false, authorities);
      return user;
    }
    if ("admin".equals(username)) {
      authorities.add(new SimpleGrantedAuthority("ADMIN"));
      User user = new User(username, "pass", true, true, false, false, authorities);
      return user;
    } else {
      return null;
    }
  }
}
