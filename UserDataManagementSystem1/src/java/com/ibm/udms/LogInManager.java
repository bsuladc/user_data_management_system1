/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ibm.udms;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

/**
 *
 * @author bryan ceniza
 */
@ManagedBean(name = "logInManager")
public class LogInManager{
    private String userName;
    private String password;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    public String logIn() {
        if("admin".equals(userName) && "password".equals(password))
        {
            return "user_overview.xhtml";
        } else {
            FacesContext.getCurrentInstance().addMessage("login_form", new FacesMessage("Wrong username or password"));
            return "index.xhtml";
        }
    }
}
