package ru.job4j.tracker.input;

import ru.job4j.tracker.input.Input;

public class StubInput implements Input {
    private String[] answers;
    private int position = 0;

    public StubInput(String[] answers) {
        this.answers = answers;
    }

    public String[] getAnswers() {
        return answers;
    }

    @Override
    public String askStr(String question) {
        System.out.print(question);
        return answers[position++];
    }

    @Override
    public int askInt(String question) {
        return Integer.parseInt(askStr(question));
    }
}
