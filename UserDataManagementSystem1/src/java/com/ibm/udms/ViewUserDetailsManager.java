/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ibm.udms;

import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

/**
 *
 * @author bryan ceniza
 */
@Named(value = "viewUserDetailsManager")
@RequestScoped
public class ViewUserDetailsManager {
    
    @Inject
    private UserOverviewManager userOverviewManager;
    
    private User userDataEntry;
    
    /**
     * Creates a new instance of ViewUserDetailsManager
     */
    public ViewUserDetailsManager() {
    }
    
    public User getUserDataEntry() {
        return userDataEntry;
    }
  
    public String viewUser() {        
        String userId = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("userId");
        userDataEntry = userOverviewManager.getUser(userId);
        return "view_user_details.xhtml";
    }
}
