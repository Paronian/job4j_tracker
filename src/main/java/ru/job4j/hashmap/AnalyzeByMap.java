package ru.job4j.hashmap;

import java.util.*;

public class AnalyzeByMap {
    public static double averageScore(List<Pupil> pupils) {
        int totalScore = 0;
        double totalCountOfSubject = 0;
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                totalScore += subject.score();
            }
            totalCountOfSubject += pupil.subjects().size();
        }
        return totalScore / totalCountOfSubject;
    }

    public static List<Label> averageScoreByPupil(List<Pupil> pupils) {
        List<Label> listOfAverageScoreByPupil = new ArrayList<>();
        for (Pupil pupil : pupils) {
            double averageScore = 0;
            for (Subject subject : pupil.subjects()) {
                averageScore += subject.score();
            }
            averageScore = averageScore / pupil.subjects().size();
            listOfAverageScoreByPupil.add(new Label(pupil.name(), averageScore));
        }
        return listOfAverageScoreByPupil;
    }

    public static List<Label> averageScoreBySubject(List<Pupil> pupils) {
        List<Label> averageScoreBySubject = new ArrayList<>();
        LinkedHashMap<String, Integer> map = new LinkedHashMap<>();
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                map.put(subject.name(), map.getOrDefault(subject.name(), 0) + subject.score());
            }
        }
        for (String key : map.keySet()) {
            averageScoreBySubject.add(new Label(key, map.get(key) / pupils.size()));
        }
        return averageScoreBySubject;
    }

    public static Label bestStudent(List<Pupil> pupils) {
        List<Label> listForBestStudent = new ArrayList<>();
        for (Pupil pupil : pupils) {
            int totalScore = 0;
            for (Subject subject : pupil.subjects()) {
                totalScore += subject.score();
            }
            listForBestStudent.add(new Label(pupil.name(), totalScore));
        }
        Collections.sort(listForBestStudent, Comparator.naturalOrder());
        return listForBestStudent.get(listForBestStudent.size() - 1);
    }

    public static Label bestSubject(List<Pupil> pupils) {
        List<Label> listOfSubjects = new ArrayList<>();
        LinkedHashMap<String, Integer> map = new LinkedHashMap<>();
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                map.put(subject.name(), map.getOrDefault(subject.name(), 0) + subject.score());
            }
        }
        for (String key : map.keySet()) {
            listOfSubjects.add(new Label(key, map.get(key)));
        }
        Collections.sort(listOfSubjects, Comparator.naturalOrder());
        return listOfSubjects.get(listOfSubjects.size() - 1);
    }
}
