package homework.market.commands;

public interface MarketCommands {

    String LOGIN = "0";
    String REGISTER = "1";
    String EXIT = "2";

    static void marketCommands() {
        System.out.println("Please input " + LOGIN + " for LOGIN");
        System.out.println("Please input " + REGISTER + " for REGISTER");
        System.out.println("Please input " + EXIT + " for EXIT");
    }
}
