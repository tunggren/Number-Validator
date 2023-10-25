
public class Main {

    public static void main(String[] args) {

        //Skriv in önskat nummer här för att kolla om det är giltigt eller inte
        String input = "0000000000";

        //Kallar på metoden ValidityChecker för att se om inputen är ett giltigt nummer och vilket typ av nummer det är
        String output = ValidityCheck.ValidityChecker(input);

        //Printar ut resultatet
        System.out.println(output);
    }
}
