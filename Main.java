import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        try {
            System.out.println(calc(str));
        } catch (IOException | NumberFormatException e) {
            System.out.println("Формат математической операции не удовлетворяет заданию - два операнда и один оператор");
        } catch (ArithmeticException e) {
            System.out.println("Ошибка деления на 0");
        } catch (RangeException e) {
            System.out.println("Диапазон чисел не удовлетворяет заданию - от 1 до 10");
        }
    }

    public static String calc(String input) throws IOException, NumberFormatException, ArithmeticException, RangeException {
        String[] string = input.split(" ");
        if (string.length != 3) {
            throw new IOException();
        }
        int first = Integer.parseInt(string[0]);
        int second = Integer.parseInt(string[2]);
        if (first < 1 || first > 10 || second < 1 || second > 10) {
            throw new RangeException();
        }
        int result = switch (string[1]) {
            case "+" -> first + second;
            case "-" -> first - second;
            case "*" -> first * second;
            case "/" -> first / second;
            default -> 0;
        };
        return Integer.toString(result);
    }
}

class RangeException extends Exception {
    public RangeException() {
        super();
    }
}
