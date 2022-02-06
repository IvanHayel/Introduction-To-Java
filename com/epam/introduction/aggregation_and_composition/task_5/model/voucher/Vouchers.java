package com.epam.introduction.aggregation_and_composition.task_5.model.voucher;

import com.epam.introduction.aggregation_and_composition.task_5.model.voucher.nutrition.NutritionForm;
import com.epam.introduction.aggregation_and_composition.task_5.model.voucher.transport.TransportType;

import java.time.Period;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Vouchers {
    private List<Voucher> vouchers;

    public Vouchers() {
        vouchers = new ArrayList<>();
    }

    public void add(Voucher voucher) {
        vouchers.add(voucher);
    }

    public void search(int id) {
        System.out.println("Voucher with id = " + id);
        for (Voucher voucher : vouchers) {
            if (voucher.getID() == id) {
                System.out.println(voucher);
                return;
            }
        }
    }

    public void search(VoucherType voucherType) {
        System.out.println("Vouchers by voucher type = " + voucherType);
        for (Voucher voucher : vouchers) {
            if (voucher.getVoucherType() == voucherType) {
                System.out.println(voucher);
            }
        }
    }

    public void search(TransportType transportType) {
        System.out.println("Vouchers by transport type = " + transportType);
        for (Voucher voucher : vouchers) {
            if (voucher.getTransportType() == transportType) {
                System.out.println(voucher);
            }
        }
    }

    public void search(NutritionForm nutritionForm) {
        System.out.println("Vouchers by nutrition form = " + nutritionForm);
        for (Voucher voucher : vouchers) {
            if (voucher.getNutritionForm() == nutritionForm) {
                System.out.println(voucher);
            }
        }
    }

    public void search(Period period) {
        System.out.println("Vouchers by number of days = " + period.getDays());
        for (Voucher voucher : vouchers) {
            if (voucher.getPeriod().equals(period)) {
                System.out.println(voucher);
            }
        }
    }

    public void sort() {
        Collections.sort(vouchers);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        int counter = 1;
        for (Voucher voucher : vouchers) {
            builder.append(counter++);
            builder.append(". " + voucher + '\n');
        }
        return builder.toString();
    }
}