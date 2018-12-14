package cn.linj2n.javacore.stream.chap5;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.Comparator.comparing;


public class PuttingIntoPractice {
    public static void main(String... args) {
        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario", "Milan");
        Trader alan = new Trader("Alan", "Cambridge");
        Trader brian = new Trader("Brian", "Cambridge");

        List<Transaction> transactions = Arrays.asList(
                new Transaction(brian, 2011, 300),
                new Transaction(raoul, 2012, 1000),
                new Transaction(raoul, 2011, 400),
                new Transaction(mario, 2012, 710),
                new Transaction(mario, 2012, 700),
                new Transaction(alan, 2012, 950)
        );


        // Query 1: Find all transactions from year 2011 and sort them by value (small to high).
        List<Transaction> tr2011 = transactions
                .stream()
                .filter(transaction -> transaction.getYear() == 2011)
                .sorted(comparing(Transaction::getValue))
                .collect(Collectors.toList());
        System.out.println("tr2011--> " + tr2011.toString());

        // Query 2: What are all the unique cities where the traders work?
        List<String> cities = transactions
                .stream()
                .map(transaction -> transaction.getTrader().getCity())
                .distinct()
                .collect(Collectors.toList());
        System.out.println("cities--> " + cities.toString());

        // Query 3: Find all traders from Cambridge and sort them by name.
        List<Trader> traders = transactions
                .stream()
                .map(Transaction::getTrader)
                .filter(trader -> trader.getName().equals("Cambridge"))
                .sorted(comparing(Trader::getName))
                .collect(Collectors.toList());
        System.out.println("traders--> " + traders);

        // Query 4: Return a string of all traders’ names sorted alphabetically.
        List<String> traderNames = transactions
                .stream()
                .map(transaction -> transaction.getTrader().getName())
                .distinct()
                .sorted(String::compareTo)
                .collect(Collectors.toList());
        System.out.println("traderNames--> " + traderNames);

        // Query 5: Are there any trader based in Milan?
        Boolean result = transactions
                .stream()
                .anyMatch(transaction -> transaction.getTrader().getCity().equals("Milan"));
        System.out.println("Are there any trader based in Milan? --> " + result);

        // Query 6: Update all transactions so that the traders from Milan are set to Cambridge.
        transactions
                .stream()
                .filter(transaction -> transaction.getTrader().getCity().equals("Milan"))
                .forEach(transaction -> transaction.getTrader().setCity("Cambridge"));
        System.out.println("Query 6: updatedTransaction--> " + transactions);

        // Query 7: What's the highest value in all the transactions?
        Optional<Integer> highestValue = transactions
                .stream()
                .map(Transaction::getValue)
                .reduce(Integer::max);
        System.out.println("Query 7: the highest value--> " + highestValue.orElse(0));
    }
}
