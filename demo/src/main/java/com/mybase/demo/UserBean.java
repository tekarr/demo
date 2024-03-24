/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mybase.demo;

/**
 *
 * @author mohamed
 */


import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@RequestScoped
@Named
public class UserBean {
    private String username;
    private String password;

    @PersistenceContext
    private EntityManager entityManager;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Transactional
    public String saveUser() {
      try {
        Users user = new Users();
        user.setUsername(username);
        user.setPassword(password);
        entityManager.persist(user);
        return "success"; // Redirect to a success page
    } catch (Exception e) {
        // Log the exception or display an error message
        e.printStackTrace();
        return "error"; // Redirect to an error page
    }
}
}
