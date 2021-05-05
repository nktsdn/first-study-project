package Task5.operation;

public class Division extends Operation {
    public double getResult(double a, double b) throws ArithmeticException {
        if (b!=0) {
            return a / b;
        }else{
            System.err.println("Ошибка. Деление на 0!");
            throw new ArithmeticException();
        }
    }
}
