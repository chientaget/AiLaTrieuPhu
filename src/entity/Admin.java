package entity;

import service.IService;

public class Admin extends Person implements IService<Admin> {

    public Admin(Integer id, String username, String password) {
        super(id, username, password);
    }

    public Admin() {
    }

    @Override
    public Admin insertObject() {
        // Triển khai cụ thể cho việc chèn một đối tượng Admin vào cơ sở dữ liệu hoặc thực hiện một tác vụ tương tự.
        return this; // Trả về đối tượng Admin hiện tại
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
        return "Admin{" + "id=" + super.id + ", username=" + super.username + ", password=" + super.password + '}';
    }
}
