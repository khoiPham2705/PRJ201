package pe.account;

public class AccountDTO {
    //your code here
    private int id;
    private String email;
    private String fullName;
    private String roleId;
    private String password;

    public AccountDTO() {
    }

    public AccountDTO(int id, String email, String fullName, String roleId, String password) {
        this.id = id;
        this.email = email;
        this.fullName = fullName;
        this.roleId = roleId;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getFullName() {
        return fullName;
    }

    public String getRoleId() {
        return roleId;
    }

    public String getPassword() {
        return password;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    
    
}
