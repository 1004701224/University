package servlet;

import entity.School;
import entity.User;
import org.json.JSONObject;
import service.UserService;
import service.impl.UserServiceImpl;

import java.io.IOException;
import java.io.PrintWriter;

@javax.servlet.annotation.WebServlet("/UserServlet")
public class UserServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=utf-8");
        UserService userService = new UserServiceImpl();
        String userid =request.getParameter("userid");
        String usename = request.getParameter("username");
        int money = Integer.parseInt(request.getParameter("money"));
        User u = new User();
        u.setUserid(userid);
        u.setUsername(usename);
        u.setMoney(money);

        School school = userService.queryStudentByUserId(u);
        String schoolname = school.getSchoolname();
        System.out.println(schoolname);


        JSONObject json = new JSONObject();

        json.put("schoolname", schoolname);

        PrintWriter out = response.getWriter();
        out.print(json);

        out.close();
    }
}
