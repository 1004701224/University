package service;

import entity.School;
import entity.User;

import java.io.IOException;

public interface UserService {
    School queryStudentByUserId(User u) throws IOException;
}
