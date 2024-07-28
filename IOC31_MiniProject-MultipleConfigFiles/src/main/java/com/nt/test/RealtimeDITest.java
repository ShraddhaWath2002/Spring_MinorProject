package com.nt.test;

import java.util.Scanner;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nt.controller.MainController;
import com.nt.vo.CustomerVO;

public class RealtimeDITest {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String name = null, addrs = null, pamt = null, rate = null, time = null;
		
		if(sc!= null) {
			System.out.println("Enter Customer name : ");
			name = sc.next();
			System.out.println("Enter Customer address : ");
			addrs = sc.next();
			System.out.println("Enter Principle amount : ");
			pamt = sc.next();
			System.out.println("Enter rate of intrest : ");
			rate = sc.next();
			System.out.println("Enter time in months : ");
			time = sc.next();
		}
		
		CustomerVO vo = new CustomerVO();
		vo.setCname(name);
		vo.setCadd(addrs);
		vo.setPamt(pamt);
		vo.setRate(rate);
		vo.setTime(time);
		
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext("com/nt/cfgs/applicationContext.xml");
		MainController controller = ctx.getBean("controller",MainController.class);
		
		try {
			String resultMsg = controller.processCustomer(vo);
			System.out.println(resultMsg);
		}catch(Exception e) {
			System.err.println("Problem in custom registration::"+e.getMessage());
			e.printStackTrace();
		}
	}

}
