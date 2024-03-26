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
    public void searchWhenMultipleTasksFoundTest() {
        SimpleTask simpleTask1 = new SimpleTask(1, "Позвонить другу");
        SimpleTask simpleTask2 = new SimpleTask(2, "Позвонить коллеге");

        Epic epic = new Epic(55, new String[]{"Молоко", "Яйца", "Хлеб"});
        Meeting meeting = new Meeting(555, "Выкатка 3й версии приложения",
                "Приложение НетоБанка", "Во вторник после обеда");

        Todos todos = new Todos();

        todos.add(simpleTask1);
        todos.add(simpleTask2);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = { simpleTask1, simpleTask2 };
        Task[] actual = todos.search("Позвонить");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void searchWhenOneTaskFoundTest() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");

        Epic epic = new Epic(55, new String[]{"Молоко", "Яйца", "Хлеб"});
        Meeting meeting = new Meeting(555, "Выкатка 3й версии приложения",
                "Приложение НетоБанка", "Во вторник после обеда");

        Todos todos = new Todos();

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = { simpleTask };
        Task[] actual = todos.search("родителям");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void searchWhenNoTasksFoundTest() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");

        Epic epic = new Epic(55, new String[]{"Молоко", "Яйца", "Хлеб"});
        Meeting meeting = new Meeting(555, "Выкатка 3й версии приложения",
                "Приложение НетоБанка", "Во вторник после обеда");

        Todos todos = new Todos();

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = {};
        Task[] actual = todos.search("сходить в магазин");

        Assertions.assertArrayEquals(expected, actual);
    }
}