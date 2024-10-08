package ru.job4j.queue;

import java.util.Deque;
import java.util.Queue;

public class ReconstructPhrase {
    private final Deque<Character> descendingElements;

    private final Deque<Character> evenElements;

    public ReconstructPhrase(Deque<Character> descendingElements, Deque<Character> evenElements) {
        this.descendingElements = descendingElements;
        this.evenElements = evenElements;
    }

    private String getEvenElements() {
        StringBuilder string = new StringBuilder();
        int size = evenElements.size();
        for (int i = 0; i < size; i++) {
            if (i % 2 == 0) {
                string.append(evenElements.pollFirst());
            } else {
                evenElements.pollFirst();
            }
        }
        return string.toString();
    }

    private String getDescendingElements() {
        StringBuilder string = new StringBuilder();
        int size = descendingElements.size();
        for (int i = 0; i < size; i++) {
            string.append(descendingElements.pollLast());
        }
        return string.toString();
    }

    public String getReconstructPhrase() {
        return getEvenElements() + getDescendingElements();
    }
}

