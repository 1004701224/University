package mapper;

import entity.School;
import entity.User;

public interface UserMapper {
    School queryStudentByUserId(String userid);
}
