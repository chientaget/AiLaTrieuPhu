package entity;

import java.io.Serializable;

public abstract class Person implements Serializable {

    protected Integer id;
    protected String username;
    protected String password;

    
    public  Person(Integer id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }

    public Person() {
    }
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    
}
