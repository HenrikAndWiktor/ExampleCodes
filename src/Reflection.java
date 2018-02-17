import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;

public class Reflection {
    public static void main(String[] args) throws Throwable {
        Class<ReflectMe> clazz = ReflectMe.class;
        Constructor<ReflectMe> constructor = clazz.getDeclaredConstructor();
        constructor.setAccessible(true);
        ReflectMe reflectMe = constructor.newInstance();
        Field f = clazz.getDeclaredField("myPrivateInt");
        f.setAccessible(true);
        System.out.println("Reflected as ReflectMe: myPrivateInt=="+f.getInt(reflectMe));
        Method m = clazz.getDeclaredMethod("imPrivate");
        m.setAccessible(true);
        m.invoke(reflectMe);
        Method m2 = clazz.getDeclaredMethod("dontReflectMe");
        m2.setAccessible(true);
        m2.invoke(reflectMe);
    }
}
class ReflectMe {
    private ReflectMe() {}
    private int myPrivateInt = 33;
    private void imPrivate() {
        System.out.println("You reflected me!");
    }
    private void dontReflectMe() throws IllegalAccessException {
        if (Arrays.stream(new Exception().getStackTrace()).anyMatch(s -> s.toString().contains("Method.invoke"))) throw new IllegalAccessException();
        System.out.println("You reflected me!");
    }
}