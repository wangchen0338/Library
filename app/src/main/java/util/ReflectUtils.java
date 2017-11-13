package util;

import android.text.TextUtils;

import java.lang.reflect.Field;

/**
 * 作者：wangchen on 2017/11/13 09:42
 * 邮箱：wangchen0338@163.com
 */
public class ReflectUtils
{
    private ReflectUtils()
    {
    }

    public static boolean isString(Class<?> clazz)
    {
        return clazz == String.class;
    }

    public static boolean isInteger(Class<?> clazz)
    {
        return clazz == Integer.TYPE || clazz == Integer.class;
    }

    public static boolean isLong(Class<?> clazz)
    {
        return clazz == Long.TYPE || clazz == Long.class;
    }

    public static boolean isShort(Class<?> clazz)
    {
        return clazz == Short.TYPE || clazz == Short.class;
    }

    public static boolean isFloat(Class<?> clazz)
    {
        return clazz == Float.TYPE || clazz == Float.class;
    }

    public static boolean isDouble(Class<?> clazz)
    {
        return clazz == Double.TYPE || clazz == Double.class;
    }

    /**
     *
     * @Title: getField
     * @Description: 获取对象的私有变量
     * @param @param instance
     * @param @param name
     * @param @return
     * @param @throws SecurityException
     * @param @throws NoSuchFieldException
     * @param @throws IllegalArgumentException
     * @param @throws IllegalAccessException    参数说明
     * @return Object    返回类型
     * @throws
     */
    public static Object getField(Object instance, String name)
            throws SecurityException, NoSuchFieldException,
            IllegalArgumentException, IllegalAccessException
    {
        Object object = null;
        if(instance != null && !TextUtils.isEmpty(name))
        {
            Field field = instance.getClass().getDeclaredField(name);
            if(field != null)
            {
                field.setAccessible(true);
                object = field.get(instance);
            }
        }
        return object;
    }
}
