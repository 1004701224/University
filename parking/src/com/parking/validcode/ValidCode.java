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
//��������Ϊ����ҳ��������֤��ʹ��
@WebServlet("/validcode")
public class ValidCode extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		�����װ�ͼ��
		BufferedImage image = new BufferedImage(200, 100,BufferedImage.TYPE_INT_BGR);
//		����graphics2D���������ɿɻ�ͼ����
		Graphics2D gra = image.createGraphics();
//		������ɫΪ��ɫ�����ƴ������ɫ
		gra.setColor(Color.white);
//		���ƾ�������
		gra.fillRect(0, 0, 200, 100);
//		���������б����ڴ洢���ɵ���֤��
		List<Integer> number = new ArrayList<Integer>();
		Random random = new Random();
//		�������4λ����֤��
		for(int i = 0; i < 4; i++) {
			number.add(random.nextInt(10));
		}
//		���û�ͼ��ɫ�����������
		gra.setFont(new Font("����",Font.ITALIC|Font.BOLD,40));
		Color[] color = {Color.black,Color.blue,Color.gray,Color.green,Color.red,Color.pink,Color.orange,Color.yellow,Color.magenta};
		for(int i = 0; i < 4; i++) {
//			���������ɫ
			gra.setColor(color[random.nextInt(9)]);
//			����������дλ��
			if(i != 0)
			gra.drawString(number.get(i)+"", (int)(i*45+Math.random()*20-10), (int)(70+Math.random()*30-15));
			else {
				gra.drawString(number.get(i)+"", (int)(i*45+Math.random()*10), (int)(70+Math.random()*30-15));
			}
		}
		for(int i = 0; i < 2; i++) {
//			���ø��ź�����ɫ����дλ��
			gra.setColor(color[random.nextInt(9)]);
			gra.drawLine((int)Math.random()*10, (int)(Math.random()*101), (int)Math.random()*11+190, (int)(Math.random()*101));
		}
//		��ȡ�ֽ���
		ServletOutputStream outputStream = resp.getOutputStream();
//		�����Ƶ�ͼƬͨ���ֽ������
		ImageIO.write(image, "jpg",outputStream);
		String code="";
//		��ȡsession����
		HttpSession session = req.getSession();
		for(int i = 0; i < 4; i++) {
//			��4λ��֤��ת��Ϊһ���ַ������㴫ֵ
			code+=number.get(i);
		}
//		����֤���ַ�������session��
		session.setAttribute("number", code);
	}
}
