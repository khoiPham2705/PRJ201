/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.user;

/**
 *
 * @author LAPTOP
 */
public class UserDTO {
    private String userId;
    private String fullName;
    private String password;
    private String roleID;
    private boolean status;

    public UserDTO() {
    }

    public UserDTO(String userId, String fullName, String password, String roleID, boolean status) {
        this.userId = userId;
        this.fullName = fullName;
        this.password = password;
        this.roleID = roleID;
        this.status = status;
    }

    public String getUserId() {
        return userId;
    }

    public String getFullName() {
        return fullName;
    }

    public String getPassword() {
        return password;
    }

    public String getRoleID() {
        return roleID;
    }

    public boolean isStatus() {
        return status;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setRoleID(String roleID) {
        this.roleID = roleID;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
    
    
}
