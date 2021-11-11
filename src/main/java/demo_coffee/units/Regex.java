package demo_coffee.units;

import java.util.regex.Pattern;

public class Regex {

    public static boolean isFullNameValidator(String full_name){
        String FULL_NAME_REGEX = "^([AÀẢÃÁẠĂẰẮẲẴẶÂẤẦẨẪẬBCDĐEÈÉẺẼẸÊỀẾỂỄỆFGHIÍÌỈĨỊJKLMNOÒÓỎÕỌÔỒỐỔỖỘƠỜỚỞỠỢPQRSTUÙÚỦŨỤƯỪỨỬỮỰVWXYÝỲỶỸỴZ]+[aàảãáạăằẳẵắặâầẩẫấậbcdđeèẻẽéẹêềểễếệfghiìỉĩíịjklmnoòỏõóọôồổỗốộơờởỡớợpqrstuùủũúụưừửữứựvwxyỳỷỹýỵz]*?[ ]?)+$";
         return Pattern.compile(FULL_NAME_REGEX).matcher(full_name).matches();
    }

    public static boolean isIdCardValidator( String idCard){
        String IDENTITY_CARD_REGEX = "^[1|2][0-9]{8,11}$";
        return Pattern.compile(IDENTITY_CARD_REGEX).matcher(idCard).matches();
    }

    public static boolean isEmailValidator(String email){
        String EMAIL_REGEX="^[a-z][a-z0-9_\\.]{3,32}@[a-z0-9]{2,}(\\.[a-z0-9]{2,7}){1,7}$" ;
        return Pattern.compile(EMAIL_REGEX).matcher(email).matches();
    }

    public static boolean isPhoneNumber(String phone){
        String NUMBER_PHONE_REGEX = "^[0][1-9][0-9]{8,9}$";
        return Pattern.compile(NUMBER_PHONE_REGEX).matcher(phone).matches();
    }

    public static boolean isUserNameValidator(String username){
        String USERNAME_REGEX = "^[a-z][a-z0-9_]{6,16}$"; //user name 6-16 ki tu bat dau bang chu ;
        return Pattern.compile(USERNAME_REGEX).matcher(username).matches();
    }

    public static boolean isPasswordMediumValidator(String password){
        String PASSWORD_REGEX = "^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{6,}$"; // có ít nhất 6 kí tự chu va so khong có ki tu dat biet
        return Pattern.compile(PASSWORD_REGEX).matcher(password).matches();
    }

    public static boolean isPasswordHardValidator(String password){
        String PASSWORD_REGEX = "^(?=.*[A-Za-z])(?=.*\\d)(?=.*[@$!%*#?&])[A-Za-z\\d@$!%*#?&]{6,}$"; // Tối thiểu 8 ký tự, ít nhất một chữ cái, một số và một ký tự đặc biệt:
        return Pattern.compile(PASSWORD_REGEX).matcher(password).matches();
    }
}
