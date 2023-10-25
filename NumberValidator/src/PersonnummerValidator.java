import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PersonnummerValidator extends NummerValidator {

    //Metod som validerar ett svenskt personnummer
    public static boolean isValid (String number) {

        //Ett regular-expression mönster för att matcha personnummer
        Pattern PERSON_NUMMER_PATTERN = Pattern.compile("^(18|19|20)?\\d{6}[-+]?\\d{4}$");

        //Tar bort alla icke-numeriska karaktärer ur input-strängen
        String testNummer = number.replaceAll("[^0-9]", "");

        Matcher matcher = PERSON_NUMMER_PATTERN.matcher(number);

        //Jämför inputen med vårt regex-mönster
        if (!matcher.matches()) {
            return false;
        }

        //Om inputen är 12 karaktärer lång så tas de första två karaktärerna bort ur inputen
        if (testNummer.length() == 12) {
            testNummer = testNummer.substring(2);
        }

        //Kollar så att inputen nu är 10 karaktärer lång
        if (testNummer.length() != 10) {
            return false;
        }

        //Här plockar vi ut år, månad och dag ur inputen för att kunna validera om det är ett giltigt datum
        int year = Integer.parseInt(testNummer.substring(0, 2));
        int month = Integer.parseInt(testNummer.substring(2, 4));
        int day = Integer.parseInt(testNummer.substring(4, 6));

        //Validerar datumet som vi plockat ut ovan
        if (!isValidDate(year, month, day)) {
            return false;
        }

        //Kollar om inputen går igenom Luhn's Algoritm och om det isåfall är ett korrekt personnummer eller inte
        int testSum = luhnsAlgoritm(testNummer);
        return testSum == 0;
    }

}
