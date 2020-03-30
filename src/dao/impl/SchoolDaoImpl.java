package dao.impl;

import dao.SchoolDao;
import entity.School;
import entity.User;
import util.DBUtil;

import java.sql.ResultSet;
import java.sql.SQLException;

public class SchoolDaoImpl implements SchoolDao {

    @Override
    public School queryStudentSchool(User u) throws SQLException {
        String sql = "select schoolname from school where id = (select school from user where userid = ?)";
        Object[] params = new Object[]{u.getUserid()};
        ResultSet resultSet = DBUtil.executeQuery(sql , params);

        School school = new School();
        while (resultSet.next()){
            school.setSchoolname(resultSet.getString("schoolname"));
        }

        return school;
    }
}
