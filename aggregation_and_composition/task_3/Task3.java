package aggregation_and_composition.task_3;

/**
 * Create an object of the State class using the classes Region, District, City.
 * Methods: display the capital, the number of regions, area, regional centers on the console.
 */

public class Task3 {
    public static void main(String[] args) {
        City minsk = new City("Minsk", true, true);
        City molodechno = new City("Molodechno");
        City borisov = new City("Borisov");
        City zhodino = new City("Zhodino");
        City grodno = new City("Grodno", true);
        City lida = new City("Lida");
        City brest = new City("Brest", true);
        City pinsk = new City("Pinsk");
        City mogilev = new City("Mogilev", true);
        City shklov = new City("Shlov");

        District minskDistrict = new District("Minsk");
        minskDistrict.addCity(minsk);
        District molodechnoDistrict = new District("Molodechno");
        molodechnoDistrict.addCity(molodechno);
        District borisovDistrict = new District("Borisov");
        borisovDistrict.addCity(borisov);
        District zhodinoDistrict = new District("Zhodino");
        zhodinoDistrict.addCity(zhodino);
        District grodnoDistrict = new District("Grodno");
        grodnoDistrict.addCity(grodno);
        District lidaDistrict = new District("Lida");
        lidaDistrict.addCity(lida);
        District brestDistrict = new District("Brest");
        brestDistrict.addCity(brest);
        District pinskDistrict = new District("Pinsk");
        pinskDistrict.addCity(pinsk);
        District mogilevDistrict = new District("Mogilev");
        mogilevDistrict.addCity(mogilev);
        District shklovDistrict = new District("Shklov");
        shklovDistrict.addCity(shklov);

        Region minskRegion = new Region("Minsk", 39854);
        minskRegion.addDistrict(minskDistrict);
        minskRegion.addDistrict(molodechnoDistrict);
        minskRegion.addDistrict(borisovDistrict);
        minskRegion.addDistrict(zhodinoDistrict);
        Region grodnoRegion = new Region("Grodno", 25127);
        grodnoRegion.addDistrict(grodnoDistrict);
        grodnoRegion.addDistrict(lidaDistrict);
        Region brestRegion = new Region("Brest", 32786);
        brestRegion.addDistrict(brestDistrict);
        brestRegion.addDistrict(pinskDistrict);
        Region mogilevRegion = new Region("Mogilev", 29068);
        mogilevRegion.addDistrict(mogilevDistrict);
        mogilevRegion.addDistrict(shklovDistrict);

        State belarus = new State("Belarus");
        belarus.addRegion(minskRegion);
        belarus.addRegion(grodnoRegion);
        belarus.addRegion(brestRegion);
        belarus.addRegion(mogilevRegion);

        System.out.println("Capital of Belarus");
        belarus.displayCapital();
        System.out.println();

        System.out.println("Belarus number of regions");
        belarus.displayRegionsNumber();
        System.out.println();

        System.out.println("Belarus total area");
        belarus.displayTotalArea();
        System.out.println();

        System.out.println("Belarus regional centers");
        belarus.displayRegionalCenters();
        System.out.println();
    }
}