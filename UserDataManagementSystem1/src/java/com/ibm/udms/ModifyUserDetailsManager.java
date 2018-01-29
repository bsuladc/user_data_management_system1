/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ibm.udms;

import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.inject.Named;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;

/**
 *
 * @author bryan ceniza
 */
@Named(value = "modifyUserDetailsManager")
@ViewScoped
public class ModifyUserDetailsManager implements Serializable{
    
    @Inject
    private UserOverviewManager userOverviewManager;
    
    private User userDataEntry;
    
    /**
     * Creates a new instance of ModifyUserDetailsManager
     */
    public ModifyUserDetailsManager() {
    }
    
    @PostConstruct
    public void init() {
        String userId = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("userId");
        userDataEntry = userOverviewManager.getUser(userId);      
        System.out.println("constrt");
    }
    
    @PreDestroy
    public void whenDestroyed() {
        System.out.println("destroyed");
    }
    
    public User getUserDataEntry() {
        return userDataEntry;
    }
    
    public String saveUser() {
        userOverviewManager.modifyUser(userDataEntry);
        return "user_overview";
    }
}
