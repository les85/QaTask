import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TodosTest {
    @Test
    public void shouldAddThreeTasksOfDifferentType() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");

        String[] subtasks = { "Молоко", "Яйца", "Хлеб" };
        Epic epic = new Epic(55, subtasks);

        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        Todos todos = new Todos();

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = { simpleTask, epic, meeting };
        Task[] actual = todos.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }


    @Test
    public void searchWhen0TasksFoundTest() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить");

        String[] subtasks = { "Молоко", "Яйца", "Хлеб" };
        Epic epic = new Epic(55, subtasks);

        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        Todos todos = new Todos();

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = { };
        Task[] actual = todos.search("хлеб");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldAddOneTasksOfDifferentType() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить маме");

        Todos todos = new Todos();

        todos.add(simpleTask);

        Task[] expected = { simpleTask };
        Task[] actual = todos.search("маме");

        Assertions.assertArrayEquals(expected, actual);
    }


}