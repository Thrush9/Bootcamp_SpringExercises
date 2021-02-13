package com.stackroute.foodapp;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.stackroute.foodapp.model.Bill;
import com.stackroute.foodapp.model.Hotel;

public class FoodMain 
{
    public static void main( String[] args )
    {
        ApplicationContext context=new ClassPathXmlApplicationContext("mybeans.xml");
        
        Hotel hotelObj = context.getBean("hotelbean",Hotel.class);
        System.out.println(hotelObj);
        
        Bill billObj = context.getBean("billbean",Bill.class);
        System.out.println(billObj);
    }
}
