import java.util.*;

public class Main{
    public static final int NUMBERS = 6;
    public static final int MAX_NUMBERS = 40;
    public static final int PRIZE = 100;



    public static void main(String[] args){

        // 3- Getting winning number and ticket sets
        Set<Integer> winning = createWinningNumbers();
        Set<Integer> ticket  = getTicket();

        // 4- Keeping only winning numbers from user's ticket
        // using retainAll() to remove non common numbers
        Set<Integer> matches = new TreeSet<>(ticket);
        matches.retainAll(winning);             // keeps the elements that has same value in winning set

        Iterator<Integer> i1 = matches.iterator();
        System.out.println("matches : ");
        while(i1.hasNext())
        {
            System.out.println(i1.next());
        }



        // 5- calculating the prize
        System.out.println("Your ticket was: " +ticket);
        System.out.println("Winning Numbers: " +winning);
        if (matches.size()> 0){
            double prize = PRIZE  * Math.pow(2, matches.size());
            System.out.println("Matched Numbers: " +matches);
            System.out.printf("Your prize is $%.2f\n", prize);
        }


    }


    // 1- generates a set of the winning lotto numbers
    public static Set<Integer> createWinningNumbers(){
        Set<Integer> winning = new TreeSet<>();
        Random random = new Random();

        while(winning.size() < NUMBERS){
            int number = random.nextInt(MAX_NUMBERS) +1;
            winning.add(number);
        }
        return winning;
    }



    // 2- Reading the player's lottery ticket from the consol
    public static Set<Integer> getTicket(){
        Set<Integer> ticket = new TreeSet<>();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter " +NUMBERS + " Lotto numbers: ");

        while (ticket.size() < NUMBERS){
            int number = scanner.nextInt();
            if (number<= MAX_NUMBERS)
                ticket.add(number);
        }
        return ticket;
    }



}
