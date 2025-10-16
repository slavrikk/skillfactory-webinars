package skillfactory.financeapp;

import skillfactory.financeapp.model.User;
import skillfactory.financeapp.service.UserService;
import skillfactory.financeapp.service.FinanceService;
import skillfactory.financeapp.exception.UserNotFoundException;
import skillfactory.financeapp.exception.InvalidCredentialsException;

import java.util.Scanner;
import java.util.Map;

public class FinanceApp {
    
    private final UserService userService;
    private final FinanceService financeService;
    private final Scanner scanner;
    
    public FinanceApp() {
        userService = new UserService();
        financeService = new FinanceService();
        scanner = new Scanner(System.in);
    }
    
    public void run() {
        System.out.println("Добро пожаловать в приложение для управления личными финансами!");
        
        while (true) {
            if (!userService.isUserLoggedIn()) {
                showAuthMenu();
                handleAuthMenu();
            } else {
                showMainMenu();
                handleMainMenu();
            }
        }
    }
    
    private void showAuthMenu() {
        System.out.println("\n--- Меню авторизации ---");
        System.out.println("1. Регистрация");
        System.out.println("2. Вход");
        System.out.println("3. Выход");
        System.out.print("Выберите действие: ");
    }
    
    private void handleAuthMenu() {
        String choice = scanner.nextLine().trim();
        
        switch (choice) {
            case "1":
                handleRegistration();
                break;
            case "2":
                handleLogin();
                break;
            case "3":
                System.out.println("До свидания!");
                System.exit(0);
                break;
            default:
                System.out.println("Неверный выбор. Попробуйте снова.");
        }
    }
    
    private void handleRegistration() {
        try {
            System.out.print("Введите имя пользователя: ");
            String username = scanner.nextLine().trim();
            
            System.out.print("Введите пароль: ");
            String password = scanner.nextLine().trim();
            
            userService.registerUser(username, password);
            System.out.println("Регистрация успешна!");
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка регистрации: " + e.getMessage());
        }
    }
    
    private void handleLogin() {
        try {
            System.out.print("Введите имя пользователя: ");
            String username = scanner.nextLine().trim();
            
            System.out.print("Введите пароль: ");
            String password = scanner.nextLine().trim();
            
            userService.authenticateUser(username, password);
            System.out.println("Вход выполнен успешно!");
        } catch (UserNotFoundException | InvalidCredentialsException e) {
            System.out.println("Ошибка входа: " + e.getMessage());
        }
    }
    
    private void showMainMenu() {
        System.out.println("\n--- Главное меню ---");
        System.out.println("1. Добавить доход");
        System.out.println("2. Добавить расход");
        System.out.println("3. Установить бюджет");
        System.out.println("4. Просмотр статистики");
        System.out.println("5. Выход");
        System.out.print("Выберите действие: ");
    }
    
    private void handleMainMenu() {
        String choice = scanner.nextLine().trim();
        
        switch (choice) {
            case "1":
                handleAddIncome();
                break;
            case "2":
                handleAddExpense();
                break;
            case "3":
                handleSetBudget();
                break;
            case "4":
                showStatistics();
                break;
            case "5":
                userService.logout();
                break;
            default:
                System.out.println("Неверный выбор. Попробуйте снова.");
        }
    }
    
    private void handleAddIncome() {
        try {
            System.out.print("Введите категорию дохода: ");
            String category = scanner.nextLine().trim();
            
            System.out.print("Введите сумму дохода: ");
            double amount = Double.parseDouble(scanner.nextLine().trim());
            
            financeService.addIncome(userService.getCurrentUser(), category, amount);
            System.out.println("Доход успешно добавлен!");
        } catch (NumberFormatException e) {
            System.out.println("Ошибка: введите корректное числовое значение.");
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }
    
    private void handleAddExpense() {
        try {
            System.out.print("Введите категорию расхода: ");
            String category = scanner.nextLine().trim();
            
            System.out.print("Введите сумму расхода: ");
            double amount = Double.parseDouble(scanner.nextLine().trim());
            
            financeService.addExpense(userService.getCurrentUser(), category, amount);
            
            // Проверяем превышение бюджета
            if (financeService.isBudgetExceeded(userService.getCurrentUser(), category)) {
                System.out.println("Внимание: бюджет по категории '" + category + "' превышен!");
            }
            
            System.out.println("Расход успешно добавлен!");
        } catch (NumberFormatException e) {
            System.out.println("Ошибка: введите корректное числовое значение.");
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }
    
    private void handleSetBudget() {
        try {
            System.out.print("Введите категорию: ");
            String category = scanner.nextLine().trim();
            
            System.out.print("Введите бюджет: ");
            double budget = Double.parseDouble(scanner.nextLine().trim());
            
            financeService.setBudget(userService.getCurrentUser(), category, budget);
            System.out.println("Бюджет успешно установлен!");
        } catch (NumberFormatException e) {
            System.out.println("Ошибка: введите корректное числовое значение.");
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }
    
    private void showStatistics() {
        User user = userService.getCurrentUser();
        
        System.out.println("\n--- Статистика ---");
        
        // Общие данные
        double totalIncome = financeService.getTotalIncome(user);
        double totalExpenses = financeService.getTotalExpenses(user);
        
        System.out.println("Общий доход: " + totalIncome);
        System.out.println("Общие расходы: " + totalExpenses);
        
        // Доходы по категориям
        Map<String, Double> incomeByCategory = financeService.getIncomeByCategory(user);
        if (!incomeByCategory.isEmpty()) {
            System.out.println("Доходы по категориям:");
            incomeByCategory.forEach((category, amount) -> 
                System.out.println(category + ": " + amount));
        }
        
        // Расходы по категориям с бюджетами
        Map<String, Double> expensesByCategory = financeService.getExpensesByCategory(user);
        if (!expensesByCategory.isEmpty()) {
            System.out.println("Расходы по категориям:");
            expensesByCategory.forEach((category, amount) -> {
                System.out.println(category + ": " + amount);
                Double budget = user.getWallet().getBudget(category);
                if (budget != null) {
                    double remaining = financeService.getBudgetRemaining(user, category);
                    System.out.println("  Бюджет: " + budget + ", Оставшийся бюджет: " + remaining);
                }
            });
        }
        
        // Проверка превышения расходов над доходами
        if (financeService.areExpensesExceedingIncome(user)) {
            System.out.println("Внимание: Ваши расходы превышают доходы!");
        }
    }

    public static void main(String[] args) {
        new FinanceApp().run();
    }
}