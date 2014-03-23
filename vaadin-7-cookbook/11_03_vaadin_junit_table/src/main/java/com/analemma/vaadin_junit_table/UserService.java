package com.analemma.vaadin_junit_table;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Ondrej Kvasnovsky
 */
public class UserService {

  public List<User> findAll() {
    final List<User> res = new ArrayList<User>();
    res.add(new User("Jaromir Jagr"));
    res.add(new User("Wayne Gretzky"));
    res.add(new User("David Vyborny"));
    res.add(new User("Jari Kurri"));
    res.add(new User("Martin Straka"));
    res.add(new User("Patrik Elias"));
    res.add(new User("Sidney Crosby"));
    return res;
  }
}
