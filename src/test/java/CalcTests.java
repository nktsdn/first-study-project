import Task5.Calc;
import org.junit.Assert;
import org.junit.Test;

public class CalcTests {
    Calc calc = new Calc();

    @Test
    public void testAddition() {
        Assert.assertEquals("Сложение целых чисел не прошло проверку", 15, calc.calculate(5, 10, '+'), 0);
        Assert.assertEquals("Сложение дробных чисел не прошло проверку", 15.2661, calc.calculate(5.0232, 10.2429, '+'), 0.0001);
        Assert.assertEquals("Сложение отрицательных чисел не прошло проверку", 5, calc.calculate(-5, 10, '+'), 0);
    }

    @Test
    public void testDivision() {
        Assert.assertEquals("Деление целых чисел не прошло проверку", 2, calc.calculate(10, 5, '/'), 0);
        Assert.assertEquals("Деление дробных чисел не прошло проверку", 4.396, calc.calculate(45.02, 10.24, '/'), 0.001);
        Assert.assertEquals("Деление отрицательных чисел не прошло проверку", -1.25, calc.calculate(-15, 12, '/'), 0.01);
    }

    @Test
    public void testMultiplication() {
        Assert.assertEquals("Умножение целых чисел не прошло проверку", 240, calc.calculate(20, 12, '*'), 0);
        Assert.assertEquals("Умножение дробных чисел не прошло проверку", 276.5408, calc.calculate(19.42, 14.24, '*'), 0.0001);
        Assert.assertEquals("Умножение отрицательных чисел не прошло проверку", -135, calc.calculate(-45, 3, '*'), 0);
    }

    @Test
    public void testSubtraction() {
        Assert.assertEquals("Вычитание целых чисел не прошло проверку", 8, calc.calculate(20, 12, '-'), 0);
        Assert.assertEquals("Вычитание дробных чисел не прошло проверку", 5.18, calc.calculate(19.42, 14.24, '-'), 0.01);
        Assert.assertEquals("Вычитание отрицательных чисел не прошло проверку", 74, calc.calculate(43, -31, '-'), 0);
    }
}
