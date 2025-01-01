package com.gchaldu.utils;

import java.util.UUID;

public class ValidationUtils {
    private ValidationUtils() {
        //para evitar instanciar
    }
    public static boolean isValidUUID(String uuid){
        if (uuid==null){
            return false;
        }
        try {
            UUID.fromString(uuid);
            return true;
        }catch (IllegalArgumentException e){
            return false;
        }
    }
}
