package com.io.vov.vitamio.libray.lib.Internet.Json;

import android.util.Log;
import org.json.JSONArray;
import org.json.JSONObject;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.ParameterizedType;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ${zhangzz} on 2015/7/20.
 */
public class JsonParser {
    public static final String SET="set";

    public static <T> ArrayList<T> toArrayList(JSONArray array,
                                               Class<T> clazz) {
        ArrayList results = new ArrayList();
        if (null == array) {
            return results;
        }
        try {
            final int length = array.length();
            for (int i = 0; i < length; i++) {
                if (array.opt(i) instanceof JSONObject) {

                    Object object = toObject(array.optJSONObject(i), clazz);
                    if(null != object)
                        results.add(object);
                } else if (array.opt(i) instanceof JSONArray) {
                    results.add(toArrayList(array.optJSONArray(i), clazz));
                } else {
                    results.add(array.opt(i));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return results;
    }

    public static <T> T toObject(JSONObject jsonObject,
                                 Class<T> clazz) {
        if (null == jsonObject){
            return null;
        }
        try {
            Class<T> zoClass = (Class<T>) Class.forName(clazz.getName());
            Constructor<?> constructor = zoClass.getConstructor();
            T out = (T) constructor.newInstance();
            handleClassFields(jsonObject, clazz, out, clazz);
            Class supper = clazz.getSuperclass();
            while (null != supper) {
                handleClassFields(jsonObject, clazz, out, supper);
                supper = supper.getSuperclass();
            }
            return out;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private static void handleClassFields(JSONObject jsonObject,
                                          Class<? extends Object> clazz, Object out, Class supper)
            throws IllegalAccessException, InvocationTargetException,
            NoSuchMethodException, ClassNotFoundException,
            InstantiationException {
        final Field[] supperFields = supper.getFields();
        for (Field field : supperFields) {
            if(jsonObject.has(field.getName()))
                invokeValueToObject(clazz, out, field, jsonObject);
        }
        final Field[] supperDeclaredFields = supper.getDeclaredFields();
        for (Field field : supperDeclaredFields) {
            if(jsonObject.has(field.getName()))
                invokeValueToObject(clazz, out, field, jsonObject);
        }
    }

    private static void invokeValueToObject(Class<? extends Object> clazz,
                                            Object out, Field field, JSONObject jsonObject)
            throws IllegalAccessException, InvocationTargetException,
            NoSuchMethodException, ClassNotFoundException,
            InstantiationException {
        String key = field.getName();
        String methodName = generateSetMethod(field);
        Log.v(key, methodName);
        if(methodName.contains("$")) return;
        final Class<?> fieldType = field.getType();
        Object value;
        if (isInterface(fieldType, Json.class)) {
            value = toObject(jsonObject.optJSONObject(key), fieldType);
        } else if (isInterface(fieldType, List.class)) {
            ParameterizedType pt = (ParameterizedType) field.getGenericType();
            value = toArrayList(jsonObject.optJSONArray(key),
                    (Class<? extends Object>) pt.getActualTypeArguments()[0]);
        } else if (fieldType.equals(Integer.class)
                || fieldType.equals(int.class)) {
            value = jsonObject.optInt(key);
        } else if (fieldType.equals(Boolean.class)
                || fieldType.equals(boolean.class)) {
            final String val = jsonObject.optString(key, "false");
            value = !("false".equals(val) || "0".equals(val) || "".equals(val));
        } else if (fieldType.equals(Long.class) || fieldType.equals(long.class)) {
            value = jsonObject.optLong(key);
        } else if (fieldType.equals(Float.class)
                || fieldType.equals(float.class)
                || fieldType.equals(Double.class)
                || fieldType.equals(double.class)) {
            value = jsonObject.optDouble(key);
        } else if (fieldType.equals(BigDecimal.class)) {
            value = BigDecimal.valueOf(jsonObject.optDouble(key));
        } else if (fieldType.isEnum()) {
            value = null;
            final String name = jsonObject.optString(key, "");
            if (!name.trim().equals("null")&&!name.trim().equals("")) {
                value = Enum.valueOf((Class<Enum>) Class.forName(fieldType.getName()), name);
            }
        } else {
            value = jsonObject.optString(key, "");
        }
        clazz.getMethod(methodName, fieldType).invoke(out, value);
    }

    private static String generateSetMethod(Field field) {
        String fieldName = field.getName();
        field.setAccessible(true);
        return SET + fieldName.toUpperCase().charAt(0) + fieldName.substring(1);
    }

    public static boolean isInterface(Class c, Class Interface) {
        String szInterface = Interface.getName();
        Class[] face = c.getInterfaces();
        if (c.getName().equals(szInterface))
            return true;
        for (Class aFace : face) {
            if (aFace.getName().equals(szInterface)) {
                return true;
            } else {
                Class[] face1 = aFace.getInterfaces();
                for (Class aFace1 : face1) {
                    if (aFace1.getName().equals(szInterface)) {
                        return true;
                    } else if (isInterface(aFace1, Interface)) {
                        return true;
                    }
                }
            }
        }
        return null != c.getSuperclass()
                && isInterface(c.getSuperclass(), Interface);
    }
}
