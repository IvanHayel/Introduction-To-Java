package linear_programs.task_4;

public class Task_4 {
    public static void main(String[] args) {
        RealNumber r = new RealNumber(314.159);
        r.showRealNumber();
        r.swapIntegerAndFractional();
        r.showRealNumber();
        r.swapIntegerAndFractional();
        System.out.println(r);
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