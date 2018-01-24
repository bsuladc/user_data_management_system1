/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ibm.udms;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;

/**
 *
 * @author bryan ceniza
 */
@Named(value = "userOverviewManager")
@SessionScoped
public class UserOverviewManager implements Serializable{    
    private static final long serialVersionUID = 1l;
    
    private final List<User> userList = new ArrayList<>();
    private final Map<String, User> userMap = new HashMap<>();

    private final User userDataEntry = new User();

    public User[] getUserList() {
        return userList.toArray(new User[0]);
    }

    public User getUserDataEntry() {
        return userDataEntry;
    }

    public void addUser(User user) {
        if (userMap.get(user.getUserId()) == null) {
            userMap.put(user.getUserId(), user);
            userList.add(user);
        }
    }

    public void modifyUser(User user) {
        User existingUser = userMap.get(user.getUserId());
        if (existingUser != null) {
            userMap.put(user.getUserId(), user);
            userList.remove(existingUser);
            userList.add(user);
        }
    }

    public void removeUser() {
        String userId = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("userId");
        User existingUser = userMap.get(userId);
        if (existingUser != null) {
            userMap.remove(userId);
            userList.remove(existingUser);
        }
    }

    public User getUser(String userId) {
        return userMap.get(userId);
    }
}
