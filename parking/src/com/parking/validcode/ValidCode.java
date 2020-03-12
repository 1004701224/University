package com.parking.validcode;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
//本方法作为各个页面生成验证码使用
@WebServlet("/validcode")
public class ValidCode extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		创建底板图像
		BufferedImage image = new BufferedImage(200, 100,BufferedImage.TYPE_INT_BGR);
//		调用graphics2D方法，生成可绘图区域
		Graphics2D gra = image.createGraphics();
//		设置颜色为白色，绘制大面积颜色
		gra.setColor(Color.white);
//		绘制矩形区域
		gra.fillRect(0, 0, 200, 100);
//		创建数字列表，用于存储生成的验证码
		List<Integer> number = new ArrayList<Integer>();
		Random random = new Random();
//		随机生成4位数验证码
		for(int i = 0; i < 4; i++) {
			number.add(random.nextInt(10));
		}
//		设置绘图颜色，字体等属性
		gra.setFont(new Font("宋体",Font.ITALIC|Font.BOLD,40));
		Color[] color = {Color.black,Color.blue,Color.gray,Color.green,Color.red,Color.pink,Color.orange,Color.yellow,Color.magenta};
		for(int i = 0; i < 4; i++) {
//			设置随机颜色
			gra.setColor(color[random.nextInt(9)]);
//			设置文字书写位置
			if(i != 0)
			gra.drawString(number.get(i)+"", (int)(i*45+Math.random()*20-10), (int)(70+Math.random()*30-15));
			else {
				gra.drawString(number.get(i)+"", (int)(i*45+Math.random()*10), (int)(70+Math.random()*30-15));
			}
		}
		for(int i = 0; i < 2; i++) {
//			设置干扰横线颜色及书写位置
			gra.setColor(color[random.nextInt(9)]);
			gra.drawLine((int)Math.random()*10, (int)(Math.random()*101), (int)Math.random()*11+190, (int)(Math.random()*101));
		}
//		获取字节流
		ServletOutputStream outputStream = resp.getOutputStream();
//		将绘制的图片通过字节流输出
		ImageIO.write(image, "jpg",outputStream);
		String code="";
//		获取session对象
		HttpSession session = req.getSession();
		for(int i = 0; i < 4; i++) {
//			将4位验证码转换为一个字符串方便传值
			code+=number.get(i);
		}
//		将验证码字符串置于session中
		session.setAttribute("number", code);
	}
}
