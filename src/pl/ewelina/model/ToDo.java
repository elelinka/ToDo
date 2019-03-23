package pl.ewelina.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ToDo {


    private List<Task> tasks = new ArrayList<Task>();

    public void addNewTask(int id, String title) {
        Task task = new Task(id, title);
        tasks.add(task);
    }

    public int createId() {
        int id;
        if (tasks.size() == 0) {
            id = 1;
        } else {
            id = tasks.get(tasks.size() - 1).getId() + 1;
        }
        return id;
    }

    public void addUserTask(String title) {
        int id = createId();
        addNewTask(id, title);
    }

    public void showAllTasks() {

        for (int i = 0; i < tasks.size(); i++) {
            Task task = tasks.get(i);

            System.out.print(task.getId() + " ");
            System.out.print(task.getTitle() + " ");
            System.out.print(task.getStatus() + " ");
            System.out.println("");
        }
    }

    public boolean changeTasksStatus(int id) {

        for (int i = 0; i < tasks.size(); i++) {
            Task task = tasks.get(i);
            if (task.getId() == id) {
                task.changeStatus();
                return false;
            }
        }
        return true;
    }

    public void deleteTask(int id) {
        for (int i = 0; i < tasks.size(); i++) {
            Task task = tasks.get(i);
            if (task.getId() == id) {
                tasks.remove(task);
            }
        }
    }

    public void interractionWithUser() {
        Scanner newInput = new Scanner(System.in).useDelimiter("\\n");

        while (true) {
            System.out.println("Obsługa programu");
            System.out.println("1. Podaj tytuł taska");
            System.out.println("2. Wpisz: status i id w celu zmiany statusu");
            System.out.println("3. Wpisz: usuń id w celu usunięcia taska");

            String command = newInput.next();
            if (command.contains("status")) {
                int id = Integer.parseInt(command.substring(7));
                changeTasksStatus(id);
            } else if (command.contains("usuń")) {
                int id = Integer.parseInt(command.substring(5));
                deleteTask(id);
            } else if (command.contains("exit")) {
                break;
            } else {
                addUserTask(command);
            }


            showAllTasks();

        }

    }

}
