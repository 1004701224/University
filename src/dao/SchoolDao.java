package dao;

import entity.School;
import entity.User;

import java.sql.SQLException;

public interface SchoolDao {
    School queryStudentSchool(User u) throws SQLException;

}
