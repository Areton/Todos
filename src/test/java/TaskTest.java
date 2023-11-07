import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TaskTest {

    @Test
    public void testSimpleTaskMatches() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");
        boolean actual = simpleTask.matches("родителям");
        boolean expected = true;
        Assertions.assertEquals(actual, expected);
    }

    @Test
    public void testSimpleTaskNotMatches() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");
        boolean actual = simpleTask.matches("родитель");
        boolean expected = false;
        Assertions.assertEquals(actual, expected);
    }

    @Test
    public void testEpicMatches() {
        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(11, subtasks);
        boolean actual = epic.matches("Яйца");
        boolean expected = true;
        Assertions.assertEquals(actual, expected);
    }

    @Test
    public void testEpicNotMatches() {
        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(11, subtasks);
        boolean actual = epic.matches("Сок");
        boolean expected = false;
        Assertions.assertEquals(actual, expected);
    }

    @Test
    public void testMeetingMatchesTopic() {
        Meeting meeting = new Meeting(43, "ДЗ", "Тесты", "06.11.23");
        boolean actual = meeting.matches("ДЗ");
        boolean expected = true;
        Assertions.assertEquals(actual, expected);
    }

    @Test
    public void testMeetingMatchesProject() {
        Meeting meeting = new Meeting(43, "ДЗ", "Тесты", "06.11.23");
        boolean actual = meeting.matches("ест");
        boolean expected = true;
        Assertions.assertEquals(actual, expected);
    }

    @Test
    public void testMeetingNotMatches() {
        Meeting meeting = new Meeting(43, "ДЗ", "Тесты", "06.11.23");
        boolean actual = meeting.matches("Прогул");
        boolean expected = false;
        Assertions.assertEquals(actual, expected);
    }
}