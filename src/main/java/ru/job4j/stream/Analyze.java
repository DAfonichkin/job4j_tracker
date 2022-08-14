package ru.job4j.stream;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Analyze {
    public static double averageScore(Stream<Pupil> stream) {
        return stream
                .flatMap(p -> p.subjects().stream())
                .mapToInt(Subject::score)
                .average()
                .orElse(0);
    }

    public static List<Tuple> averageScoreByPupil(Stream<Pupil> stream) {
        return stream
                .map(p -> new Tuple(p.name(), averageScore(Stream.of(p))))
                .collect(Collectors.toList());
    }

    public static List<Tuple> averageScoreBySubject(Stream<Pupil> stream) {
        return stream
                .flatMap(p -> p.subjects().stream())
                .collect(Collectors
                        .groupingBy(Subject::name,
                                LinkedHashMap::new,
                                Collectors
                                        .averagingDouble(Subject::score)))
                .entrySet()
                .stream()
                .map(s -> new Tuple(s.getKey(), s.getValue()))
                .collect(Collectors.toList());
    }

    public static Tuple bestStudent(Stream<Pupil> stream) {
        return stream
                .map(pupil -> new Tuple(pupil.name(),
                        Stream.of(pupil)
                                .flatMap(p -> p.subjects().stream())
                                .mapToInt(Subject::score)
                                .sum()))
                .max((o1, o2) -> o1.score() == o2.score() ? 0 : o1.score() > o2.score() ? 1 : 0)
                .orElse(null);
    }

    public static Tuple bestSubject(Stream<Pupil> stream) {
        return stream
                .flatMap(p -> p.subjects().stream())
                .collect(Collectors
                        .groupingBy(Subject::name,
                                LinkedHashMap::new,
                                Collectors
                                        .summingDouble(Subject::score)))
                .entrySet()
                .stream()
                .map(s -> new Tuple(s.getKey(), s.getValue()))
                .max((o1, o2) -> o1.score() == o2.score() ? 0 : o1.score() > o2.score() ? 1 : 0)
                .orElse(null);
    }
}