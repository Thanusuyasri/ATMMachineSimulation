import java.util.Scanner;
class AtmMachine
{
    private static int amount=10000;

    public static int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }


    public static int SufficitionAmount(int am, int userEnteredAmount) throws  InSufficientFundaException{
        if(am>userEnteredAmount){
            am-=userEnteredAmount;
            return am;
        }
        else{
            throw new InSufficientFundaException("You have less amount");
        }
    }
    public static void Invalidecase(int userEnteredAmount) throws InValidAmountException
    {
        if(userEnteredAmount<=0) {
            throw new InValidAmountException("You have Entered the amount less or equal to zero");
        }
    }
}
public class Main {
    public static void main(String[] args) {

        AtmMachine ram = new AtmMachine();
        AtmAcction(ram);

    }
    public static void AtmAcction(AtmMachine ram) {
        int option, userEnteredAmount;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter 1 for deposit \nEnter 2 for withdraw \nEnter 3 to view balance\nEnter 4 for exit");
        option = scanner.nextInt();
        while (option != 4) {
            if (option == 1) {
                System.out.println("Enter the amount to deposit: ");
                userEnteredAmount = scanner.nextInt();
                ram.setAmount(ram.getAmount() + userEnteredAmount);
                System.out.println("Total amount " + ram.getAmount());
            } else if (option == 2) {

                System.out.println("Enter the amount to withdraw");
                userEnteredAmount = scanner.nextInt();
                try {
                    ram.Invalidecase(userEnteredAmount);
                    ram.setAmount(ram.SufficitionAmount(ram.getAmount(), userEnteredAmount));
                    System.out.println(ram.getAmount());

                } catch (InSufficientFundaException e) {
                    System.out.println(e.getMessage());
                } catch (InValidAmountException e) {
                    System.out.println(e.getMessage());
                }
            } else if (option==3) {
                System.out.println("Balance"+ram.getAmount());
            }
            else{
                System.out.println("Enter the valide input");
            }
            System.out.println("Enter 1 for deposit \nEnter 2 for withdraw \nEnter 3 for exit\nEnter 4 for exit");
            option = scanner.nextInt();
        }
    }


}
class InSufficientFundaException extends Exception {
    public InSufficientFundaException(String exceptionmessage) {
        super(exceptionmessage);
    }
}
class InValidAmountException extends Exception {
    public InValidAmountException(String exceptionmessage) {
        super(exceptionmessage);
    }
}