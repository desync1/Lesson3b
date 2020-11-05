import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Main {
    public static void main(String[] args) {
        TextContainer tc = new TextContainer();
        Class<?> cls = tc.getClass();
        Method[] methods = cls.getMethods();
        for (Method method : methods) {
            if (method.isAnnotationPresent(Saver.class)) {
                SaveTo save = cls.getAnnotation(SaveTo.class);
                try {
                    method.invoke(tc, save.path());
                } catch (IllegalAccessException | InvocationTargetException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
