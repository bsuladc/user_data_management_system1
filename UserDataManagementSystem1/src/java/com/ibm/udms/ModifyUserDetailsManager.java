/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ibm.udms;

import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.faces.context.FacesContext;
import javax.faces.flow.FlowScoped;
import javax.inject.Inject;

/**
 *
 * @author bryan ceniza
 */
@Named(value = "modifyUserDetailsManager")
@FlowScoped(value = "modify_user_details")
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
    }
    
    public User getUserDataEntry() {
        return userDataEntry;
    }
    
    public String saveUser() {
        userOverviewManager.modifyUser(userDataEntry);
        return "user_overview";
    }
}
