package com.example.demo.config;

import org.springframework.context.ApplicationContext;

public class ContextLoader {
    
    private static ContextLoader myObj;
    
    private static  ApplicationContext ctx;
    /**
     * Create private constructor
     */
    private ContextLoader(){
         
    }
    /**
     * Create a static method to get instance.
     */
    public static ContextLoader getInstance(){
        if(myObj == null){
            myObj = new ContextLoader();
        }
        return myObj;
    }
     
    public ApplicationContext getApplicationContext(){
        // do something here
    	System.out.println("get app context....");
        return ctx;
    }
    
    public void storeApplicationContext(ApplicationContext ctx){
        // do something here
      	System.out.println("set app context....");
      	this.ctx=ctx;
    }
     
   
}