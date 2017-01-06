package com.company;

import java.io.FileInputStream;
import java.lang.reflect.InvocationTargetException;

public class ApplicationContext {
    private AutoInjectAnalyzer analyzer;
    private java.util.Properties properties;
    private static ApplicationContext instance;
    static
    {
        instance = new ApplicationContext();
    }
    private ApplicationContext() {

        properties = new java.util.Properties();

        try {
            properties.load(new FileInputStream("config.properties"));
            analyzer = new AutoInjectAnalyzer(properties);
        }
        catch (Exception e) {
            e.printStackTrace();

        }
    }

    public static ApplicationContext getInstance() {
        return instance;
    }

    public void doInjection(Object instance) throws ClassNotFoundException, IllegalAccessException, InstantiationException, InvocationTargetException {
        analyzer.checkAnnotation(instance.getClass(), instance);
    }
}