package com.company;

import com.company.writer.Writer;
import com.company.writer.XmlWriter;

import java.lang.reflect.InvocationTargetException;

public class Example {
    Example (){ }

    @AutoInject("XML")
    private Writer xmlWriter;

    //@AutoInject("XML")
    void setXmlWriter(XmlWriter writer){
        this.xmlWriter = writer;
    }

    Writer getXmlWriter(){
        return  xmlWriter;
    }

    public void start(){
        try {

            ApplicationContext.getInstance().doInjection(this);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        //autoinject works
        checkAutoInject();
    }


    private void checkAutoInject(){
        try {
            getXmlWriter().write("Auoinject for Writer works!");
        }
        catch (NullPointerException e){
            System.out.println("AutoInject does not works!");
        }
    }
}
