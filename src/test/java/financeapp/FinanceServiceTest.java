package financeapp;

import skillfactory.financeapp.model.User;
import skillfactory.financeapp.service.FinanceService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class FinanceServiceTest {
    
    private FinanceService financeService;
    private User testUser;
    
    @BeforeEach
    public void setUp() {
        financeService = new FinanceService();
        testUser = new User("testuser", "password123");
    }
    
    @Test
    public void testAddIncome() {
        // Добавляем доход
        assertDoesNotThrow(() -> financeService.addIncome(testUser, "Зарплата", 50000.0));
        
        // Проверяем, что доход добавлен
        assertEquals(50000.0, financeService.getTotalIncome(testUser), 0.01);
        assertEquals(0.0, financeService.getTotalExpenses(testUser), 0.01);
    }
    
    @Test
    public void testAddExpense() {
        // Добавляем расход
        assertDoesNotThrow(() -> financeService.addExpense(testUser, "Еда", 1000.0));
        
        // Проверяем, что расход добавлен
        assertEquals(0.0, financeService.getTotalIncome(testUser), 0.01);
        assertEquals(1000.0, financeService.getTotalExpenses(testUser), 0.01);
    }
    
    @Test
    public void testAddNegativeAmount() {
        // Проверяем, что нельзя добавить отрицательный доход
        assertThrows(IllegalArgumentException.class, () -> {
            financeService.addIncome(testUser, "Зарплата", -50000.0);
        });
        
        // Проверяем, что нельзя добавить отрицательный расход
        assertThrows(IllegalArgumentException.class, () -> {
            financeService.addExpense(testUser, "Еда", -1000.0);
        });
    }
    
    @Test
    public void testSetBudget() {
        // Устанавливаем бюджет
        assertDoesNotThrow(() -> financeService.setBudget(testUser, "Еда", 5000.0));
        
        // Проверяем, что бюджет установлен
        Map<String, Double> budgets = testUser.getWallet().getBudgets();
        assertTrue(budgets.containsKey("Еда"));
        assertEquals(5000.0, budgets.get("Еда"), 0.01);
    }
    
    @Test
    public void testSetNegativeBudget() {
        // Проверяем, что нельзя установить отрицательный бюджет
        assertThrows(IllegalArgumentException.class, () -> {
            financeService.setBudget(testUser, "Еда", -5000.0);
        });
    }
    
    @Test
    public void testGetIncomeByCategory() {
        // Добавляем доходы
        financeService.addIncome(testUser, "Зарплата", 50000.0);
        financeService.addIncome(testUser, "Бонус", 5000.0);
        financeService.addIncome(testUser, "Зарплата", 30000.0);
        
        // Проверяем доходы по категориям
        Map<String, Double> incomeByCategory = financeService.getIncomeByCategory(testUser);
        assertEquals(2, incomeByCategory.size());
        assertEquals(80000.0, incomeByCategory.get("Зарплата"), 0.01);
        assertEquals(5000.0, incomeByCategory.get("Бонус"), 0.01);
    }
    
    @Test
    public void testGetExpensesByCategory() {
        // Добавляем расходы
        financeService.addExpense(testUser, "Еда", 1000.0);
        financeService.addExpense(testUser, "Транспорт", 500.0);
        financeService.addExpense(testUser, "Еда", 2000.0);
        
        // Проверяем расходы по категориям
        Map<String, Double> expensesByCategory = financeService.getExpensesByCategory(testUser);
        assertEquals(2, expensesByCategory.size());
        assertEquals(3000.0, expensesByCategory.get("Еда"), 0.01);
        assertEquals(500.0, expensesByCategory.get("Транспорт"), 0.01);
    }
    
    @Test
    public void testGetBudgetRemaining() {
        // Устанавливаем бюджет
        financeService.setBudget(testUser, "Еда", 5000.0);
        
        // Добавляем расходы
        financeService.addExpense(testUser, "Еда", 1000.0);
        financeService.addExpense(testUser, "Еда", 2000.0);
        
        // Проверяем оставшийся бюджет
        assertEquals(2000.0, financeService.getBudgetRemaining(testUser, "Еда"), 0.01);
    }
    
    @Test
    public void testIsBudgetExceeded() {
        // Устанавливаем бюджет
        financeService.setBudget(testUser, "Еда", 5000.0);
        
        // Добавляем расходы, превышающие бюджет
        financeService.addExpense(testUser, "Еда", 3000.0);
        financeService.addExpense(testUser, "Еда", 4000.0);
        
        // Проверяем, что бюджет превышен
        assertTrue(financeService.isBudgetExceeded(testUser, "Еда"));
    }
    
    @Test
    public void testAreExpensesExceedingIncome() {
        // Добавляем доходы и расходы, где расходы больше доходов
        financeService.addIncome(testUser, "Зарплата", 50000.0);
        financeService.addExpense(testUser, "Еда", 30000.0);
        financeService.addExpense(testUser, "Транспорт", 25000.0);
        
        // Проверяем, что расходы превышают доходы
        assertTrue(financeService.areExpensesExceedingIncome(testUser));
    }
}