package skillfactory.module4;

public class UserProcessor {

    public void processUser(String name, String email) {

        // --- Начало объявления локального класса ---
        // Этот класс виден только здесь, внутри processUser()
        class Validator {
            private static final int MIN_NAME_LENGTH = 2;

            public boolean isNameValid() {
                return name != null && name.length() > MIN_NAME_LENGTH;
            }

            public boolean isEmailValid() {
                return email != null && email.contains("@");
            }

            public static void hello(){
                System.out.println("hi");
            }
        }
        // --- Конец объявления локального класса ---

        // Теперь мы можем использовать наш локальный класс
        Validator validator = new Validator();
        Validator.hello();

        if (validator.isNameValid() && validator.isEmailValid()) {
            System.out.println("Пользователь " + name + " прошел валидацию.");
            // ... дальнейшая сложная обработка ...
        } else {
            System.out.println("Ошибка: неверные данные.");
        }
    }
}
