package ru.job4j.collection;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class JobTest {

    @Test
    public void whenComparatorByNameAscending() {
        Comparator<Job> sortName = new JobAscByName();
        List<Job> jobs = Arrays.asList(
                new Job("Dance work", 0),
                new Job("Office work", 0),
                new Job("Animal work", 0),
                new Job("Drawing work", 0)
        );
        Collections.sort(jobs, sortName);
        List<Job> expected = Arrays.asList(
                new Job("Animal work", 0),
                new Job("Dance work", 0),
                new Job("Drawing work", 0),
                new Job("Office work", 0)
        );
        assertThat(jobs).isEqualTo(expected);
    }

    @Test
    public void whenComparatorByNameDescending() {
        Comparator<Job> sortName = new JobDescByName();
        List<Job> jobs = Arrays.asList(
                new Job("Dance work", 0),
                new Job("Office work", 0),
                new Job("Animal work", 0),
                new Job("Drawing work", 0)
        );
        Collections.sort(jobs, sortName);
        List<Job> expected = Arrays.asList(
                new Job("Office work", 0),
                new Job("Drawing work", 0),
                new Job("Dance work", 0),
                new Job("Animal work", 0)
        );
        assertThat(jobs).isEqualTo(expected);
    }

    @Test
    public void whenComparatorByPriorityAscending() {
        Comparator<Job> sortPriority = new JobAscByPriority();
        List<Job> jobs = Arrays.asList(
                new Job("Dance work", 1),
                new Job("Office work", 10),
                new Job("Animal work", 5),
                new Job("Drawing work", 8)
        );
        Collections.sort(jobs, sortPriority);
        List<Job> expected = Arrays.asList(
                new Job("Dance work", 1),
                new Job("Animal work", 5),
                new Job("Drawing work", 8),
                new Job("Office work", 10)
        );
        assertThat(jobs).isEqualTo(expected);
    }

    @Test
    public void whenComparatorByPriorityDescending() {
        Comparator<Job> sortPriority = new JobDescByPriority();
        List<Job> jobs = Arrays.asList(
                new Job("Dance work", 1),
                new Job("Office work", 10),
                new Job("Animal work", 5),
                new Job("Drawing work", 8)
        );
        Collections.sort(jobs, sortPriority);
        List<Job> expected = Arrays.asList(
                new Job("Office work", 10),
                new Job("Drawing work", 8),
                new Job("Animal work", 5),
                new Job("Dance work", 1)
        );
        assertThat(jobs).isEqualTo(expected);
    }

    @Test
    public void whenComparatorByNameAndPriorityDesc() {
        Comparator<Job> cmpNamePriority = new JobDescByName().thenComparing(new JobDescByPriority());
        int rsl = cmpNamePriority.compare(
                new Job("Impl task", 0),
                new Job("Fix bug", 1)
        );
        assertThat(rsl).isLessThan(0);
    }

    @Test
    public void whenComparatorByNameAndPriorityAsc() {
        Comparator<Job> cmpNamePriority = new JobAscByName().thenComparing(new JobAscByPriority());
        int rsl = cmpNamePriority.compare(
                new Job("Office work", 1),
                new Job("Animal care", 10)
        );
        assertThat(rsl).isGreaterThan(0);
    }

    @Test
    public void whenComparatorByNameAndPriorityAscAndNameEqual() {
        Comparator<Job> cmpNamePriority = new JobAscByName().thenComparing(new JobAscByPriority());
        int rsl = cmpNamePriority.compare(
                new Job("Animal care", 1),
                new Job("Animal care", 0)
        );
        assertThat(rsl).isGreaterThan(0);
    }

    @Test
    public void whenComparatorByNameAndPriorityAscAndAllEqual() {
        Comparator<Job> cmpNamePriority = new JobAscByName().thenComparing(new JobAscByPriority());
        int rsl = cmpNamePriority.compare(
                new Job("Animal care", 1),
                new Job("Animal care", 1)
        );
        assertThat(rsl).isEqualTo(0);
    }

    @Test
    public void whenComparatorByPriorityAndNameAsc() {
        Comparator<Job> cmpNamePriority = new JobAscByPriority().thenComparing(new JobAscByName());
        int rsl = cmpNamePriority.compare(
                new Job("Impl task", 1),
                new Job("Fix bug", 0)
        );
        assertThat(rsl).isGreaterThan(0);
    }

    @Test
    public void whenComparatorByPriorityAndNameAndPriorityIsEqual() {
        Comparator<Job> cmpNamePriority = new JobAscByPriority().thenComparing(new JobAscByName());
        int rsl = cmpNamePriority.compare(
                new Job("Impl task", 1),
                new Job("Fix bug", 1)
        );
        assertThat(rsl).isGreaterThan(0);
    }

    @Test
    public void whenComparatorByNameAscAndPriorityDesc() {
        Comparator<Job> cmpNamePriority = new JobAscByName().thenComparing(new JobDescByPriority());
        int rsl = cmpNamePriority.compare(
                new Job("Impl task", 10),
                new Job("Fix bug", 1)
        );
        assertThat(rsl).isGreaterThan(0);
    }

    @Test
    public void whenComparatorByNameAscAndPriorityDescAndNemeEqual() {
        Comparator<Job> cmpNamePriority = new JobAscByName().thenComparing(new JobDescByPriority());
        int rsl = cmpNamePriority.compare(
                new Job("Fix bug", 10),
                new Job("Fix bug", 1)
        );
        assertThat(rsl).isLessThan(0);
    }
}