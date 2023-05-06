
package main.java.org.example;

import model.*;

import java.io.File;
import java.util.*;
import java.util.function.Consumer;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class Main {

    public static void searchPlayList(Spliterator<Song> spliterator, PlayList playList, String keyword) {

        Spliterator<Song> trySplitIterator = spliterator.trySplit();
        trySplitIterator.forEachRemaining(song ->  { if (song.getTitle().contains(keyword)) { System.out.println(song.getTitle()); } });

        Spliterator<Song> newSplit = spliterator.trySplit();
        newSplit.forEachRemaining(song ->  { if (song.getTitle().contains(keyword)) { System.out.println(song.getTitle()); } });

        spliterator.forEachRemaining(song ->  { if (song.getTitle().contains(keyword)) { System.out.println(song.getTitle()); } });
    }

    public static void main(String[] args) {

        // Ex 1:

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

        // Ex 2:

        PlayList playList = PlayList.builder()
                .playlist(Arrays.asList(Song.builder().title("Piesa1").build(), Song.builder().title("Cantec1").build(),
                        Song.builder().title("Piesa2").build(), Song.builder().title("Cantec2").build()))
                .build();

        Spliterator<Song> spliterator = playList.getPlaylist().spliterator();

        searchPlayList(spliterator, playList, "Cantec");

        // Ex 3:

        WeatherMonitor weatherMonitor = WeatherMonitor.builder().sensorList(List.of(Sensor.builder().temperature(10.d).build())).build();

        weatherMonitor.displayTemperatures();

    }

}
