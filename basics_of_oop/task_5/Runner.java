package basics_of_oop.task_5;

import basics_of_oop.task_5.model.pack.*;
import basics_of_oop.task_5.model.sweet.SweetType;
import basics_of_oop.task_5.model.sweet_gift.SweetGift;

/**
 * Gift. Implement an application that allows you to create gifts
 * (an object representing gift).
 * The ingredients of the whole gift are sweets and pack.
 */

public class Runner {
    public static void main(String[] args) {
        Pack firstPack = new Pack(PackSize.M, PackColor.RED);
        SweetGift firstGift = new SweetGift(SweetType.GUMMIES, firstPack);
        System.out.println(firstGift);
        System.out.println();

        Pack secondPack = new Pack(PackSize.XL, PackColor.RAINBOW);
        SweetGift secondGift = new SweetGift(SweetType.CARAMEL, secondPack);
        System.out.println(secondGift);
        System.out.println();

        Pack thirdPack = new Pack(PackSize.L, PackColor.CUSTOM);
        SweetGift thirdGift = new SweetGift(SweetType.CHOCOLATE, thirdPack);
        System.out.println(thirdGift);
        System.out.println();
    }
}