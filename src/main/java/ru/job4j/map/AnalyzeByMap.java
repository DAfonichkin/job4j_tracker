package ru.job4j.map;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
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
        double sum;
        double count;
        List<Label> rsl = new ArrayList<>();
        List<Subject> subjList = new ArrayList<>();
        HashSet<String> subjNamesList = new HashSet<>();
        for (Pupil pupil : pupils) {
            for (Subject subj : pupil.subjects()) {
                subjList.add(subj);
                subjNamesList.add(subj.name());
            }
        }
        for (String subjName : subjNamesList) {
            sum = 0;
            count = 0;
            for (Subject subj : subjList) {
                System.out.println(subjName);
                System.out.println(subj.name());
                if (subj.name().equals(subjName)) {
                    sum += subj.score();
                    count++;
                }
            }
            rsl.add(new Label(subjName, sum / count));
        }
        return rsl;
    }

    public static List<Label> averageScoreByPupil(List<Pupil> pupils) {
        double sum;
        double count;
        List<Label> rsl = new ArrayList<>();
        for (Pupil pupil : pupils) {
            sum = 0;
            count = 0;
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
        double sum;
        for (Pupil pupil : pupils) {
            sum = 0;
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
        Label bestSubject = new Label("", 0);
        HashMap<String, Integer> scoresBySubj = new HashMap<>();
        double sum;
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
            sum = scoresBySubj.get(subjName);
            if (bestSubject.score() < sum) {
                bestSubject = new Label(subjName, sum);
            }
        }
        return bestSubject;
    }

}