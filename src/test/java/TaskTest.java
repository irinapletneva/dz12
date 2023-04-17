import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TaskTest {

    @Test
    public void testSimpleTaskTrue() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");
        boolean expected = true;
        boolean actual = simpleTask.matches("род");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testSimpleTaskFalse() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");
        boolean expected = false;
        boolean actual = simpleTask.matches("маме");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testEpicTrue() {
        Epic epic = new Epic(5, new String[]{"Позвонить родителям"});
        boolean expected = true;
        boolean actual = epic.matches("род");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testEpicFalse() {
        Epic epic = new Epic(5, new String[]{"Позвонить родителям"});
        boolean expected = false;
        boolean actual = epic.matches("маме");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testMeetingTrueProject() {
        Meeting meeting = new Meeting(5, "Позвонить родителям", "Договориться о встрече", "17:00");
        boolean expected = true;
        boolean actual = meeting.matches("встр");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testMeetingTrueTopic() {
        Meeting meeting = new Meeting(5, "Позвонить родителям", "Договориться о встрече", "17:00");
        boolean expected = true;
        boolean actual = meeting.matches("род");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testMeetingFalseMatches() {
        Meeting meeting = new Meeting(5, "Позвонить родителям", "Договориться о встрече", "17:00");
        boolean expected = false;
        boolean actual = meeting.matches("маме");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testMeetingFalseNotMatches() {
        Meeting meeting = new Meeting(5, "Позвонить родителям", "Договориться о встрече", "17:00");
        boolean expected = false;
        boolean actual = meeting.matches("17");
        Assertions.assertEquals(expected, actual);
    }
}