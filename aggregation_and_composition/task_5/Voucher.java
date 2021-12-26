package aggregation_and_composition.task_5;

import java.time.Period;

public class Voucher implements Comparable<Voucher> {
    private final int ID;

    private static int nextID = 1;

    private VoucherType voucherType;
    private TransportType transportType;
    private NutritionForm nutritionForm;
    private Period period;

    public Voucher(VoucherType voucherType, TransportType transportType, NutritionForm nutritionForm, Period period) {
        this.voucherType = voucherType;
        this.transportType = transportType;
        this.nutritionForm = nutritionForm;
        this.period = period;
        ID = nextID++;
    }

    public int getID() {
        return ID;
    }

    public VoucherType getVoucherType() {
        return voucherType;
    }

    public TransportType getTransportType() {
        return transportType;
    }

    public NutritionForm getNutritionForm() {
        return nutritionForm;
    }

    public Period getPeriod() {
        return period;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Voucher voucher = (Voucher) o;

        if (voucherType != voucher.voucherType) return false;
        if (transportType != voucher.transportType) return false;
        if (nutritionForm != voucher.nutritionForm) return false;
        return period.equals(voucher.period);
    }

    @Override
    public int hashCode() {
        int result = voucherType.hashCode();
        result = 31 * result + transportType.hashCode();
        result = 31 * result + nutritionForm.hashCode();
        result = 31 * result + period.hashCode();
        return result;
    }


    @Override
    public int compareTo(Voucher another) {
        return period.getDays() - another.period.getDays();
    }

    @Override
    public String toString() {
        return "Voucher №" + ID + " {" +
                "voucher type = " + voucherType +
                ", transport type = " + transportType +
                ", nutrition form = " + nutritionForm +
                ", number of days = " + period.getDays() +
                '}';
    }
}