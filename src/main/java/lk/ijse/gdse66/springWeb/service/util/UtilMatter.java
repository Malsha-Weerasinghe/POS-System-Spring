package lk.ijse.gdse66.springWeb.service.util;

import java.util.UUID;

public class UtilMatter {

    public static String generateId(){
        return UUID.randomUUID().toString();
    }
}
