public class ValidityCheck {

    public static String ValidityChecker(String input) {

            if (PersonnummerValidator.isValid(input)) {
                return input + " är ett giltigt personnummer.";
            }

            else if (SamordningsnummerValidator.isValid(input)) {
                return input + " är ett giltigt samordningsnummer.";
            }

            else if (OrganisationsnummerValidator.isValid(input)) {
                return input + " är ett giltigt organisationsnummer.";
            }

            else {
                return input + " är ogiltigt.";
            }

    }
}