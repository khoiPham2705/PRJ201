package pe.utils;

public class UserDTO {
    private String userID;
    private String name;
    private String password;

    public UserDTO(String userID, String name, String password) {
        this.userID = userID;
        this.name = name;
        this.password = password;
    }
    
    public UserDTO() {
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    
}
