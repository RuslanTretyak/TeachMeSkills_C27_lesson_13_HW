import autorization.Authorization;
import exception.WrongLoginException;
import exception.WrongPasswordException;

import java.util.Scanner;

public class RunnerSecondWay {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean isRegistered = false;
        do {
            System.out.println("\nвведите login:");
            String login = scanner.nextLine();
            System.out.println("введите password");
            String password = scanner.nextLine();
            System.out.println("подтвердите password");
            String confirmPassword = scanner.nextLine();

            try {
                isRegistered = Authorization.registerSecondWay(login, password, confirmPassword);
            } catch (WrongLoginException | WrongPasswordException e) {
                System.out.println("пользователь не зарегистрирован:");
                System.out.println(e.getMessage());
            }
        } while (!isRegistered);
        System.out.println("\nпользователь зарегистрирован");
    }
}
