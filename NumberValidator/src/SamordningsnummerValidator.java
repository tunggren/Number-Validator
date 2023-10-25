import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SamordningsnummerValidator extends NummerValidator {

    //Metod som efterlinkar isValid metoden i PersonnummerValidator, den stora skillnaden är en subtraktion som sker på rad 30
    public static boolean isValid (String number) {

        Pattern SAMORDNINGSNUMMER_PATTERN = Pattern.compile("^(18|19|20)?\\d{6}[-+]?\\d{4}$");

        String testNummer = number.replaceAll("[^0-9]", "");

        Matcher matcher = SAMORDNINGSNUMMER_PATTERN.matcher(number);
        if (!matcher.matches()) {
            return false;
        }

        if (testNummer.length() == 12) {
            testNummer = testNummer.substring(2);
        }

        if (testNummer.length() != 10) {
            return false;
        }

        //Om inputen matchar regex-mönstret så gör vi samma sak som i metoden för personnummer, fast vi subtraherar 60 från datumets dag
        if (matcher.matches()) {
            int year = Integer.parseInt(testNummer.substring(0, 2));
            int month = Integer.parseInt(testNummer.substring(2, 4));
            int day = Integer.parseInt(testNummer.substring(4, 6)) - 60;

            if (!isValidDate(year, month, day)) {
                return false;
            }
        }

        int testSum = luhnsAlgoritm(testNummer);
        return testSum == 0;
    }
}
