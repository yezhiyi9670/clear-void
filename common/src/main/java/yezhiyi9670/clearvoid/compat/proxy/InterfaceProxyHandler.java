package yezhiyi9670.clearvoid.compat.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class InterfaceProxyHandler implements InvocationHandler {
    private final Object target;

    public InterfaceProxyHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        try {
            Method targetMethod = target.getClass().getMethod(method.getName(), method.getParameterTypes());
            if (!method.getReturnType().isAssignableFrom(targetMethod.getReturnType())) {
                throw new UnsupportedOperationException(
                        "Method " + method.getName() + " has incompatible return type"
                );
            }
            return targetMethod.invoke(target, args);
        } catch (NoSuchMethodException e) {
            throw new UnsupportedOperationException(
                    "Target object doesn't have method: " + method.getName(), e
            );
        }
    }

    public static <T> T createProxy(Object target, Class<T> interfaceClass) {
        return (T) Proxy.newProxyInstance(
                interfaceClass.getClassLoader(),
                new Class<?>[] { interfaceClass },
                new InterfaceProxyHandler(target)
        );
    }
}