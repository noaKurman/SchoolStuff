public class BillCalc {

	public static void main(String[] args){

        int amountToPay = Integer.parseInt(args[0]);
        int numberOfGuests = Integer.parseInt(args[1]);
        int amountWithTip = amountToPay + ((15 * amountToPay) / 100);
        int amountForGuest = amountWithTip / numberOfGuests;
        System.out.printf("Each guest should pay %s Shekels%n", amountForGuest);

    }
}
