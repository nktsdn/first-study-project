package Task5.operation;

public class Division extends Operation {
    public float getResult(float a, float b) throws ArithmeticException {
        if (b!=0) {
            return a / b;
        }else{
            System.err.println("Ошибка. Деление на 0!");
            throw new ArithmeticException();
        }
    }
}
