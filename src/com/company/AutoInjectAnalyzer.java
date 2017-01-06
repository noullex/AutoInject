package com.company;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Properties;

public class AutoInjectAnalyzer {
    private Properties props;
    public AutoInjectAnalyzer(Properties props){
        this.props = props;
    }
    public void checkAnnotation(Class<?> cl, Object instance) throws IllegalAccessException, InstantiationException, ClassNotFoundException, InvocationTargetException {
        Method[] methods = cl.getDeclaredMethods();
        Field[] fields = cl.getDeclaredFields();

        for (Method method: methods ) {
            if (method.isAnnotationPresent(AutoInject.class)) {
                method.setAccessible(true);
                method.invoke(instance, Class.forName(props.getProperty(method.getAnnotation(AutoInject.class).value())).newInstance());
            }
        }
        for (Field field:fields ) {
            if (field.isAnnotationPresent(AutoInject.class)) {
                field.setAccessible(true);
                field.set(instance, Class.forName(props.getProperty(field.getAnnotation(AutoInject.class).value())).newInstance());
            }
        }
    }
}
