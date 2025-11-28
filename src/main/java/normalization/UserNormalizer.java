package normalization;

import com.steam.model.User;

public class UserNormalizer {
    public static String normalizeUserName(String userName){
        if(userName == null) return null;

        return userName.trim().toLowerCase();
    }

    public static String normalizeEmail(String email){
        if(email == null) return null;

        return email.trim().toLowerCase();
    }




}
