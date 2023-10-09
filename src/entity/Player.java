package entity;
import service.IService;

public class Player extends Person implements IService<Player>{

    private String fullName;
    private String email;
    private String totalMoney;

    public Player(Integer id, String username, String password,String fullName, String email, String totalMoney) {
        super(id, username, password);
        this.fullName = fullName;
        this.email = email;
        this.totalMoney = totalMoney;
    }
    
    @Override
    public Player insertObject() {
        return this;
    }

    public Player() { 
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(String totalMoney) {
        this.totalMoney = totalMoney;
    }

    @Override
    public Integer getId() {
        return id;
    }
    @Override
    public void setId(Integer id) {
        this.id = id;
    }
    @Override
    public String getUsername() {
        return username;
    }
    @Override
    public void setUsername(String username) {
        this.username = username;
    }
    @Override
    public String getPassword() {
        return password;
    }
    @Override
    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Player{" + "id=" + super.id + ", username=" + super.username + ", password=" + super.password + ", fullName=" + fullName + ", email=" + email + ", totalMoney=" + totalMoney + '}';
    }
    

}
