package org.isnumber;

public class NumberValidator {
    public static void main(String [] args) {

    }

    public boolean isNumber(String number) {
        return validate(number.toCharArray());
    }

    private boolean validate(char[] number){
        if (number == null || number.length == 0)  return false;
        if (number.length == 1 && !(number[0] >= 48 && number[0] <= 57) ) {
            return false;
        }
        boolean hasDigits = false;
        byte eIndex = -1;
        byte signIndex = -1;
        byte dotIndex = -1;
        byte countE = 0;
        byte countDot = 0;
        byte countSign = 0;
        for (byte i = 0; i < number.length; i++) {
            if (number[i] == 'e' || number[i] == 'E'){
                eIndex = i;
                if (i == 0 || i == number.length -1 || i == signIndex + 1 ||
                        (dotIndex == 0 && eIndex == dotIndex + 1) || !hasDigits) {
                    return false;
                }
                countE++;
            } else if (number[i] == '.') {
                dotIndex = i;
                if (eIndex > 0 && i > eIndex) return false;
                countDot++;
            } else if (number[i] == '+' || number[i] == '-') {
                signIndex = i;
                if (!(i == 0 || i == eIndex + 1) || i == number.length -1) {
                    return false;
                }
                countSign++;
            } else if (!(number[i] >= 48 && number[i] <= 57)) {
              return false;
            } else {
                hasDigits = true;
            }
        }

        if ( countE > 1 || countDot > 1 || countSign > 2 || !hasDigits) return false;
        return true;
    }
}
