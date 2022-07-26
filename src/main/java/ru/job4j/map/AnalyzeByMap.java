package ru.job4j.map;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.List;

public class AnalyzeByMap {

    public static double averageScore(List<Pupil> pupils) {
        double sum = 0;
        double count = 0;
        for (Pupil pupil : pupils) {
            for (Subject subj : pupil.subjects()) {
                sum += subj.score();
                count++;
            }
        }
        return sum / count;
    }

    public static List<Label> averageScoreBySubject(List<Pupil> pupils) {
        List<Label> rsl = new ArrayList<>();
        Map<String, Integer> scoresBySubj = new HashMap<>();
        for (Pupil pupil : pupils) {
            for (Subject subj : pupil.subjects()) {
                if (scoresBySubj.containsKey(subj.name())) {
                    scoresBySubj.put(subj.name(), scoresBySubj.get(subj.name()) + subj.score());
                } else {
                    scoresBySubj.put(subj.name(), subj.score());
                }
            }
        }
        for (String subjName : scoresBySubj.keySet()) {
            rsl.add(new Label(subjName, scoresBySubj.get(subjName) / pupils.size()));
        }
        return rsl;
    }

    public static List<Label> averageScoreByPupil(List<Pupil> pupils) {
        List<Label> rsl = new ArrayList<>();
        for (Pupil pupil : pupils) {
            double sum = 0;
            double count = 0;
            for (Subject subj : pupil.subjects()) {
                sum += subj.score();
                count++;
            }
            rsl.add(new Label(pupil.name(), sum / count));
        }
        return rsl;
    }

    public static Label bestStudent(List<Pupil> pupils) {
        Label bestStudent = new Label("", 0);
        for (Pupil pupil : pupils) {
            double sum = 0;
            for (Subject subj : pupil.subjects()) {
                sum += subj.score();
            }
            if (bestStudent.score() < sum) {
                bestStudent = new Label(pupil.name(), sum);
            }
        }
        return bestStudent;
    }

    public static Label bestSubject(List<Pupil> pupils) {
        Label bestSubject = null;
        Map<String, Integer> scoresBySubj = new HashMap<>();
        for (Pupil pupil : pupils) {
            for (Subject subj : pupil.subjects()) {
                if (scoresBySubj.containsKey(subj.name())) {
                    scoresBySubj.put(subj.name(), scoresBySubj.get(subj.name()) + subj.score());
                } else {
                    scoresBySubj.put(subj.name(), subj.score());
                }
            }
        }
        for (String subjName : scoresBySubj.keySet()) {
            double sum = scoresBySubj.get(subjName);
            if (bestSubject == null || bestSubject.score() < sum) {
                bestSubject = new Label(subjName, sum);
            }
        }
        return bestSubject;
    }

}