public abstract class NummerValidator {

    //Metod som kollar om de integers som matas in i inputen utgör ett giltigt datum
    public static boolean isValidDate(int year, int month, int day) {

        //Kollar så att "year" inte är större än 9999, annars är numret ett ogiltigt datum
        if (year > 9999) {
            return false;
        }

        //Kollar så att månaden är inom ett giltigt spann, nämligen 1-12
        if (month < 1 || month > 12) {
            return false;
        }

        //Definierar antalet dagar i en månad, och har skottåt i åtanke
        int[] daysInMonth = { 0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

        //Kollar om det är skottår
        if ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)) {
            daysInMonth[2] = 29;
        }

        //Kollar så att dagen är inom det giltiga spannet i den givna månaden
        return day >= 1 && day <= daysInMonth[month];
    }

    //Metod som applicerar Luhns Algoritm för att validera numeriska strängar
    public static int luhnsAlgoritm(String number) {

        int sum = 0;
        boolean doubleDigit = false;

        //Här itererar vi genom siffrorna i strängen från höger till vänster
        for (int i = number.length() - 1; i >= 0; i--) {
            char c = number.charAt(i);

            if (Character.isDigit(c)) {
                int digit = Character.getNumericValue(c);

                //Här dubblerar vi varannan siffra
                if (doubleDigit) {
                    digit *= 2;

                    //Om resultatet av ovan är ett två-siffrigt nummer så subtraheras 9
                    if (digit > 9) {
                        digit -= 9;
                    }
                }

                //Lägger till siffran i det totala värdet av den numeriska strängen
                sum += digit;
                doubleDigit = !doubleDigit;
            }
        }

        //Räknar ut kontrollsiffran beroende på summan av numret
        return (10 - (sum % 10)) % 10;
    }
}