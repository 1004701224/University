package servlet;

import entity.School;
import entity.User;
import net.sf.json.JSONObject;
import service.SchoolService;
import service.impl.SchoolServiceImpl;

import java.io.IOException;
import java.io.PrintWriter;

@javax.servlet.annotation.WebServlet("/SchoolServlet")
public class SchoolServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {


    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        SchoolService schoolService = new SchoolServiceImpl();
        String userid =request.getParameter("userid");
        String usename = request.getParameter("username");
        int money = Integer.parseInt(request.getParameter("money"));
        User u = new User();
        u.setUserid(userid);
        u.setUsername(usename);
        u.setMoney(money);

        School school = schoolService.schoolService(u);
        String schoolname = school.getSchoolname();
        System.out.println(schoolname);


        JSONObject json = new JSONObject();

        json.put("school", school);

        PrintWriter out = response.getWriter();
        out.print(json);
        out.close();
    }
}
