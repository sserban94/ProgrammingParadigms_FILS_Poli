package com.serbanscorteanu.pp.lab6.problemset2;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TourismDemo {

    public static void main(String[] args) {
        TouristPackage package1 = new TouristPackage("Barcelona Tourist Package", 1, 300,
               List.of(new Attraction("La Sagrada Familia", "Barcelona"),
                       new Attraction("Park Guell", "Barcelona"),
                       new Attraction("Casa Mila", "Barcelona")));
        TouristPackage package2 = new TouristPackage("Spain Tourist Package", 2, 400,
                List.of(new Attraction("Picasso Museum", "Barcelona"),
                        new Attraction("La Sagrada Familia", "Barcelona"),
                        new Attraction("Palau de la Musica Catalana", "Barcelona")));
        TouristPackage package3 = new TouristPackage("Espagnol Tourist Package", 3, 500,
                List.of(new Attraction("Park Guell", "Barcelona"),
                        new Attraction("Ciutadella Park", "Barcelona"),
                        new Attraction("Casa Mila", "Barcelona")));
        TouristPackage package4 = new TouristPackage("Madrid Tourist Package", 4, 350,
                List.of(new Attraction("Plaza Mayor", "Madrid"),
                        new Attraction("Museo Nacional del Prado", "Madrid"),
                        new Attraction("El Retiro Park", "Madrid")));
        TouristPackage package5 = new TouristPackage("ES Tourist Package", 5, 375,
                List.of(new Attraction("Plaza Mayor", "Madrid"),
                        new Attraction("Park Guell", "Barcelona"),
                        new Attraction("La Sagrada Familia", "Barcelona")));
        TouristPackage package6 = new TouristPackage("Pachet Turistic Spaniol", 6, 320,
                List.of(new Attraction("Royal Palace of Madrid", "Madrid"),
                        new Attraction("La Sagrada Familia", "Barcelona"),
                        new Attraction("Temple of Debod", "Madrid")));
        TouristPackage package7 = new TouristPackage("Pachet Turistic Spania", 7, 450,
                List.of(new Attraction("Bioparc Valencia", "Valencia"),
                        new Attraction("Placa de la Verge", "Valencia"),
                        new Attraction("Casa Mila", "Barcelona")));
        TouristPackage package8 = new TouristPackage("Pachet Turistic ES", 8, 600,
                List.of(new Attraction("Temple of Debod", "Madrid"),
                        new Attraction("Placa de la Verge", "Valencia")));
        TouristPackage package9 = new TouristPackage("Pachetos Turisticos", 9, 700,
                List.of(new Attraction("El Micalet", "Valencia"),
                        new Attraction("Park Guell", "Barcelona"),
                        new Attraction("Jardi del Turia", "Valencia")));
        TouristPackage package10 = new TouristPackage("Hai in Madeira", 10, 800,
                List.of(new Attraction("Madeira Botanical Garden", "Madeira"),
                        new Attraction("Monte Palace Tropical Garden", "Madeira"),
                        new Attraction("Vereda da Ponta de Sao Lourenco", "Madeira")));
        TouristPackage package11 = new TouristPackage("Welcome to Spain TP", 11, 650,
                List.of(new Attraction("La Sagrada Familia", "Barcelona"),
                        new Attraction("Monte Palace Tropical Garden", "Madeira"),
                        new Attraction("El Micalet", "Valencia")));
        TouristPackage package12 = new TouristPackage("Spaniaaaaaaa Tourist Package", 12, 900,
                List.of(new Attraction("Jardi del Turia", "Valencia"),
                        new Attraction("Casa Mila", "Barcelona")));

        List<TouristPackage> touristSoldPackageList = List.of(
                package1,
                package2,
                package3,
                package4,
                package5,
                package6,
                package7,
                package8,
                package9,
                package10,
                package11,
                package12
        );

        Map<Attraction, Integer> attractionMap = new HashMap<>();
        for (TouristPackage tp : touristSoldPackageList){
            for (Attraction attraction : tp.attractions) {
                if (!attractionMap.containsKey(attraction)) {
                    attractionMap.put(attraction, 1);
                } else {
                    attractionMap.put(attraction, attractionMap.get(attraction) + 1);
                }
            }
        }

        for (Map.Entry<Attraction, Integer> entry: attractionMap.entrySet()) {
            System.out.println(entry.getKey() + " - " + entry.getValue());
        }
        System.out.println();

        Map<Attraction, Double> attractionRelativePopularityMap = new HashMap<>();
        // for each attraction in the attraction map
        // check how many attraction were in the packages besides them (where they exist as well)
        // Relative Popularity =
        // total no of occurrences / total no of attractions in the packages where that attraction existed
        for (Attraction attraction : attractionMap.keySet()) {
            int totalNoOccurrences = attractionMap.get(attraction);
            // 1 instead of 0 to avoid division by zero exception
            double noNeighbourAttractions = 0;
            for (TouristPackage tp : touristSoldPackageList){
                if (tp.attractions.contains(attraction)){
                    noNeighbourAttractions += tp.attractions.size();
                }
            }
            attractionRelativePopularityMap.put(attraction, totalNoOccurrences/noNeighbourAttractions);
        }

        for (Map.Entry<Attraction, Double> entry: attractionRelativePopularityMap.entrySet()) {
            System.out.println(entry.getKey() + " - " + entry.getValue());
        }
    }

    public static void printMap(Map<Attraction,Integer> map) {
        for (Map.Entry<Attraction, Integer> entry: map.entrySet()) {
            System.out.println(entry.getKey() + " - " + entry.getValue());
        }
    }
}
