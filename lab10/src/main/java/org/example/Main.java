
package main.java.org.example;

import model.Area;
import model.TreasureChest;

import java.io.File;
import java.util.*;
import java.util.function.Consumer;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class Main {
    public static void main(String[] args) {

        List<Area> areas = new ArrayList<>(Arrays.asList(Area.builder()
                        .treasureChests(Arrays.asList(TreasureChest.builder().value(12.3).build(), TreasureChest.builder().value(15.6).build()))
                        .build(),
                                   Area.builder()
                        .treasureChests(Arrays.asList(TreasureChest.builder().value(10.1).build(), TreasureChest.builder().value(19.0).build()))
                        .build()));

        Iterator<Area> areaIterator = areas.iterator();

        Double maxTreasureChest = 0.d;

        while (areaIterator.hasNext()) {

            Area area = areaIterator.next();

            Iterator<TreasureChest> treasureChestIterator = area.getTreasureChests().iterator();

            while (treasureChestIterator.hasNext()) {

                Double treasureChestValue = treasureChestIterator.next().getValue();
                if (treasureChestValue > maxTreasureChest) {
                    maxTreasureChest = treasureChestValue;
                }

            }

        }

        System.out.println("The most valuable TreasureChest has value " + maxTreasureChest);

    }
}
