package basics_of_oop.task_4.resource.model.treasure;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class DragonTreasures {
    private List<Treasure> treasures;

    public DragonTreasures() {
        treasures = new ArrayList<>();
        try {
            loadTreasures();
        } catch (IOException exception) {
            System.out.println(exception.getMessage());
        }
    }

    private void loadTreasures() throws IOException {
        Path path = Path.of("src/basics_of_oop/task_4/resource/database/treasures.txt");
        if (Files.notExists(path)) {
            throw new FileNotFoundException("Can't find treasures file.");
        }
        List<String> fileLines = Files.readAllLines(path);
        for (String line : fileLines) {
            if (isTreasure(line)) {
                String[] data = line.split("-");
                treasures.add(new Treasure(data[0], Integer.parseInt(data[1])));
            }
        }
    }

    private boolean isTreasure(String treasure) {
        return treasure.matches("[^-]+-\\d+");
    }

    public void displayTreasures() {
        Collections.shuffle(treasures);
        System.out.println("DragonTreasures:");
        int counter = 0;
        for (Treasure treasure : treasures) {
            System.out.println(++counter + ". " + treasure);
        }
    }

    public void displayMostExpensiveTreasures() {
        System.out.println("Most expensive treasures:");
        int maxTreasureCost = getMaxTreasureCost();
        int counter = 0;
        for (Treasure treasure : treasures) {
            if (treasure.getCost() == maxTreasureCost) {
                System.out.println(++counter + ". " + treasure);
            }
        }
    }

    private int getMaxTreasureCost() {
        if (treasures.isEmpty()) {
            return 0;
        }
        int maxTreasureCost = treasures.get(0).getCost();
        for (Treasure treasure : treasures) {
            if (maxTreasureCost < treasure.getCost()) {
                maxTreasureCost = treasure.getCost();
            }
        }
        return maxTreasureCost;
    }

    private int getMinTreasureCost() {
        if (treasures.isEmpty()) {
            return 0;
        }
        int minTreasureCost = treasures.get(0).getCost();
        for (Treasure treasure : treasures) {
            if (minTreasureCost > treasure.getCost()) {
                minTreasureCost = treasure.getCost();
            }
        }
        return minTreasureCost;
    }

    public void makeDealWithDragon(int amount) {
        if (amount < getMinTreasureCost()) {
            System.out.println("The deal is unsuccessful.");
            return;
        }
        List<Treasure> dealTreasures = getDealTreasures(amount);
        System.out.println("Deal succeed, you earn: ");
        int counter = 0;
        for (Treasure treasure : dealTreasures) {
            System.out.println(++counter + ". " + treasure);
        }
    }

    private List<Treasure> getDealTreasures(int amount) {
        treasures.sort(Comparator.comparingInt(Treasure::getCost));
        Collections.reverse(treasures);
        List<Treasure> dealTreasures = new ArrayList<>();
        for (Treasure treasure : treasures) {
            if (amount >= treasure.getCost()) {
                dealTreasures.add(treasure);
                amount -= treasure.getCost();
            }
        }
        treasures.removeAll(dealTreasures);
        return dealTreasures;
    }
}