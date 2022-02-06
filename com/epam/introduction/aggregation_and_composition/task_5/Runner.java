package com.epam.introduction.aggregation_and_composition.task_5;

import com.epam.introduction.aggregation_and_composition.task_5.model.voucher.Voucher;
import com.epam.introduction.aggregation_and_composition.task_5.model.voucher.VoucherType;
import com.epam.introduction.aggregation_and_composition.task_5.model.voucher.Vouchers;
import com.epam.introduction.aggregation_and_composition.task_5.model.voucher.nutrition.NutritionForm;
import com.epam.introduction.aggregation_and_composition.task_5.model.voucher.transport.TransportType;

import java.time.Period;

/**
 * Tourist vouchers.
 * To form a set of proposals for the client on the choice of a
 * tourist voucher of various types (rest, excursions, treatment, shopping, cruise, etc.)
 * for the optimal choice.
 * Consider the choice of transport, food and the number of days.
 * Realize the selection and sorting of tours.
 */

public class Runner {
    public static void main(String[] args) {
        Vouchers vouchers = new Vouchers();
        vouchers.add(new Voucher(
                VoucherType.EXCURSION, TransportType.LAND, NutritionForm.RO, Period.ofDays(10)
        ));
        vouchers.add(new Voucher(
                VoucherType.CRUISE, TransportType.WATER, NutritionForm.AL, Period.ofDays(14)
        ));
        vouchers.add(new Voucher(
                VoucherType.REST, TransportType.AIR, NutritionForm.HB, Period.ofDays(20)
        ));
        vouchers.add(new Voucher(
                VoucherType.SHOPPING, TransportType.INDIVIDUAL, NutritionForm.BB, Period.ofDays(3)
        ));
        vouchers.add(new Voucher(
                VoucherType.TREATMENT, TransportType.AIR, NutritionForm.EP, Period.ofDays(30)
        ));
        vouchers.add(new Voucher(
                VoucherType.TREATMENT, TransportType.INDIVIDUAL, NutritionForm.EP, Period.ofDays(10)
        ));

        System.out.println("List of vouchers:");
        System.out.println(vouchers);

        System.out.println();
        vouchers.search(3);
        vouchers.search(VoucherType.TREATMENT);
        vouchers.search(TransportType.AIR);
        vouchers.search(NutritionForm.AL);
        vouchers.search(Period.ofDays(10));

        System.out.println();
        System.out.println("Sorted vouchers by ascending number of days:");
        vouchers.sort();
        System.out.println(vouchers);
    }
}