import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class OrganisationsnummerValidator extends NummerValidator {

    //Metod som validerar ett svenskt organisationsnummer
    public static boolean isValid(String number) {
        Pattern ORGANISATIONSNUMMER_PATTERN = Pattern.compile("^(16)?\\d{6}[-]?\\d{4}$");

        String testNummer = number.replaceAll("[^0-9]", "");
        Matcher matcher = ORGANISATIONSNUMMER_PATTERN.matcher(testNummer);

        if (!matcher.matches()) {
            return false;
        }

        if (testNummer.length() == 12) {
            testNummer = testNummer.substring(2);
        }

        if (testNummer.length() != 10) {
            return false;
        }

        //Kollar så att inputen matchar med vårt regex-pattern
        if (matcher.matches()) {

            //Plockar ut mittensiffrorna och kollar om de är större än eller lika med 20, isåfall kontrolleras inputen med Luhns Algoritm
            int middleDigits = Integer.parseInt(testNummer.substring(2, 4));
            if (middleDigits >= 20) {
                int testSum = luhnsAlgoritm(testNummer);
                return testSum == 0;
            }
        }

        return false;
    }
}
