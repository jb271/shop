package domain.entity;

public class User {
    private int id;
    private String name;
    private String password;
    private int balance;

    public User(int id, String name, String password, int balance) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.balance = balance;
    }
    
    public User() {
    }

    public int getId() {
        return id;
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

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "Customer{" + "id=" + id + ", name=" + name + ", password=" + password + ", balance=" + balance + '}';
    }
}
