import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Main {
  public static void main(String[] args) throws InterruptedException {
    System.out.println("Welcome to the Exchange Rate Calculator");
    System.out.println();

    var reader = new Scanner(System.in);
    int option1 = 0;

    while (option1 != 9) {
      printMainMenu();
      System.out.print("Enter an option: ");
      option1 = reader.nextInt();

      switch (option1) {
        case 1: // USD to ARS
          getExchangeAmount("USD", "ARS");
          break;
        case 2: // ARS to USD
          getExchangeAmount("ARS", "USD");
          break;
        case 3: // USD to BRL
          getExchangeAmount("USD", "BRL");
          break;
        case 4: // BRL to USD
          getExchangeAmount("BRL", "USD");
          break;
        case 5: // USD to PEN
          getExchangeAmount("USD", "PEN");
          break;
        case 6: // PEN to USD
          getExchangeAmount("PEN", "USD");
          break;
        case 7: // USD to RUB
          getExchangeAmount("USD", "RUB");
          break;
        case 8: // RUB to USD
          getExchangeAmount("RUB", "USD");
          break;
        case 9: // Exit program
          exitProgram();
          break;
        default:
          System.out.println("Invalid option");
          TimeUnit.SECONDS.sleep(1);
          break;
      }
    }
  }

  static void printMainMenu() {
    System.out.println("******************************");
    System.out.println("1. United States Dollar -> Argentine Peso");
    System.out.println("2. Argentine Peso -> United States Dollar");
    System.out.println("3. United States Dollar -> Brazilian Real");
    System.out.println("4. Brazilian Reals -> United States Dollar");
    System.out.println("5. United States Dollar -> Peruvian Sol");
    System.out.println("6. Peruvian Sol -> United States Dollar");
    System.out.println("7. United States Dollar -> Russian Ruble");
    System.out.println("8. Russian Ruble -> United States Dollar");
    System.out.println("9. Exit");
    System.out.println("******************************");
    System.out.println();
  }

  static void getExchangeAmount(String inputCurrency, String outputCurrency) {
    // Selected currencies
    // USD	United States Dollar
    // ARS	Argentine Peso
    // BRL	Brazilian Real
    // PEN	Peruvian Sol
    // RUB	Russian Ruble
    // The available options for the user will be USD, ARS, BRL, PEN or RUB
    var reader = new Scanner(System.in);

    System.out.print("Enter the amount: ");
    var inputAmount = reader.nextDouble();

    var requester = new RequestExchangeRate();
    var response = requester.searchExchangeRate(inputCurrency);
    var conversionRate = response.conversion_rates().get(outputCurrency);

    var outputAmount = inputAmount * conversionRate;

    System.out.println();
    System.out.println(inputCurrency + " -> " + outputCurrency);
    System.out.println(inputAmount + " " + inputCurrency + " -> " + outputAmount + " " + outputCurrency);
    System.out.println();
  }

  static void exitProgram() {
    System.out.println("Thanks, see you next time.");
    System.exit(0);
  }
}