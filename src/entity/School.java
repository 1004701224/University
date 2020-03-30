package entity;

public class School {
    public int id;
    public String schoolname;

    public School(int id, String schoolname) {
        this.id = id;
        this.schoolname = schoolname;
    }

    public School() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSchoolname() {
        return schoolname;
    }

    public void setSchoolname(String schoolname) {
        this.schoolname = schoolname;
    }
}
