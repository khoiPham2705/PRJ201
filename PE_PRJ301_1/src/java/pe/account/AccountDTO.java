package pe.account;

public class AccountDTO {
    //your code here
    private int id;
    private String email;
    private String fullName;
    private String roleID;
    private String password;

    public AccountDTO(int id, String email, String fullName, String roleID, String password) {
        this.id = id;
        this.email = email;
        this.fullName = fullName;
        this.roleID = roleID;
        this.password = password;
    }

    public AccountDTO() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getRoleID() {
        return roleID;
    }

    public void setRoleID(String roleID) {
        this.roleID = roleID;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    
}