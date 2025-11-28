package validation;

public class UserValidator {

    public boolean isUserNameValid(String userName){
//        userName khong duoc rong va co do dai nho hon bang 20
        if(userName == null || userName.trim().length() > 20){
            return false;
        }
        return true;
    }

    public boolean isUserIdValid(int userId){
            return userId > 0;
    }
    public boolean isPassWordValid(String passWord){
        if(passWord == null || passWord.trim().length() < 5 || passWord.trim().length() > 30){
            return false;
        }
        return true;
    }


    public boolean isEmailValid(String email){
        if(email == null
                || !email.trim().endsWith("@gmail.com")
                || email.trim().length() < 13
        ){
            return false;
        }
        return true;
    }

    public boolean isWalletBalanceValid(double walletBalance){
        return walletBalance > 0.0;
    }
}
