package service.impl;

import dao.SchoolDao;
import dao.impl.SchoolDaoImpl;
import entity.School;
import entity.User;
import service.SchoolService;

import java.sql.SQLException;

public class SchoolServiceImpl implements SchoolService {

    @Override
    public School schoolService(User u) {
        SchoolDao schoolDao = new SchoolDaoImpl();
        School school = new School();
        try {
            school = schoolDao.queryStudentSchool(u);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return school;
    }
}
