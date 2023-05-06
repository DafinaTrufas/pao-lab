package model;

import lombok.Builder;

import java.util.List;
import java.util.Random;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.function.Consumer;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

@Builder
public class WeatherMonitor {

    private List<Sensor> sensorList;

    public Boolean stopMonitoring() {

        Random random = new Random();
        return random.nextBoolean();

    }

    public void displayTemperatures () {

        for (Sensor sensor : sensorList) {

            while(stopMonitoring() == false) {

                doubleSpliterator.tryAdvance(System.out::println);

            }

        }

    }

    static Spliterator<Double> infiniteSpliterator = new Spliterators.AbstractSpliterator<>(Long.MAX_VALUE, Spliterator.ORDERED) {
        private double value = 0;

        @Override
        public boolean tryAdvance(Consumer<? super Double> action) {
            action.accept(value++);
            return true;
        }

    };

    static Stream<Double> infiniteStream = StreamSupport.stream(infiniteSpliterator, false);

    static Spliterator<Double> doubleSpliterator = infiniteStream.spliterator();


}
