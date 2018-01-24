/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ibm.udms;

import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

/**
 *
 * @author bryan ceniza
 */
@Named(value = "addUserDetailsManager")
@RequestScoped
public class AddUserDetailsManager {
    
    @Inject
    private UserOverviewManager userOverviewManager;
    
    private final User userDataEntry = new User();
    
    /**
     * Creates a new instance of AddUserDetailsManager
     */
    public AddUserDetailsManager() {
    }
    
    public User getUserDataEntry() {
        return userDataEntry;
    }

    public String addUser() {
        userDataEntry.setUserId(System.currentTimeMillis() + "");
        userOverviewManager.addUser(userDataEntry);
        return "user_overview.xhtml";
    }
}
