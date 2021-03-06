package org.kishan22;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Repository;


@Repository
public class Circle implements Shape{
	private Point center;
	@Autowired
	private MessageSource msg;
	

	public MessageSource getMsg() {
		return msg;
	}

	public void setMsg(MessageSource msg) {
		this.msg = msg;
	}

	public Point getCenter() {
		return center;
	}
	
	@Resource
	public void setCenter(Point center) {
		this.center = center;
	}
	@Override
	public void draw()
	{
		System.out.println(this.msg.getMessage("Circle_Msg",null,"Default Greeting",null));
		System.out.println("Circle Point from XML file: "+center.getX() + "," + center.getY());
		//above reads from xml file
		
		//below line gets the value from properties file
		System.out.println("Circle Point from Properties file : "+this.msg.getMessage("Drawing_Point",new Object[] {center.getX(),center.getY()},"Default Point message",null));
		System.out.println(this.msg.getMessage("greeting",null,"Default Greeting",null));
	}
	
	@PostConstruct
	public void initialise()
	{
		System.out.println("Init of circle");
	}
	@PreDestroy
	public void destroy()
	{
		System.out.println("destroy of circle");
	}
}
