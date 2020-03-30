package entity;

public class User {
    public String userid;
    public String username;
    public int money;
    public int school;

    public User(String userid, String username, int money, int school) {
        this.userid = userid;
        this.username = username;
        this.money = money;
        this.school = school;
    }

    public User() {
    }


    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public int getSchool() {
        return school;
    }

    public void setSchool(int school) {
        this.school = school;
    }
}
