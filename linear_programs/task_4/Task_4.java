package linear_programs.task_4;

/*
 * Дано действительное число R вида nnn.ddd (три цифровых разряда в дробной и целой частях).
 * Поменять местами дробную и целую части числа и вывести полученное значение числа.
 */

public class Task_4 {
    public static void main(String[] args) {
        RealNumber realNumber = new RealNumber(314.159);
        realNumber.showRealNumber();
        realNumber.swapIntegerAndFractional();
        realNumber.showRealNumber();
        realNumber.swapIntegerAndFractional();
        System.out.println(realNumber);
    }
}

final class RealNumber {
    private double real_num;

    public RealNumber(double real_num) {
        this.real_num = real_num;
    }

    public void showRealNumber() {
        System.out.println(real_num);
    }

    @Override
    public String toString() {
        return Double.toString(real_num);
    }

    public void swapIntegerAndFractional() {
        real_num = (real_num * 1000) % 1000 +
                (int) real_num / 1000.0;
    }
}