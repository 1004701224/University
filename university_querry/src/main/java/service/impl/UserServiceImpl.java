package service.impl;

import entity.School;
import entity.User;
import mapper.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import service.UserService;

import java.io.IOException;
import java.io.Reader;

public class UserServiceImpl implements UserService {
    @Override
    public School queryStudentByUserId(User u) throws IOException {

        Reader reader = Resources.getResourceAsReader("conf.xml");
        SqlSessionFactory sessionFactory = (new SqlSessionFactoryBuilder()).build(reader);
        SqlSession session = sessionFactory.openSession();
        UserMapper userMapper = (UserMapper)session.getMapper(UserMapper.class);
        School school = userMapper.queryStudentByUserId(u.getUserid());
        session.close();
        return school;
    }
}
