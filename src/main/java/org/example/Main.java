package org.example;

import org.example.controller.ProjectController;
import org.example.view.ProjectView;

public class Main {
    public static void main(String[] args) {
        ProjectView view = new ProjectView();
        ProjectController controller = new ProjectController(view);

        controller.createProject(
                "E-Commerce Platform",
                "ABC Corp",
                "31/12/2024",
                new String[]{"Java", "Spring Boot", "React"},
                new String[]{"Alice", "Bob", "Charlie"},
                150000.0
        );

        controller.createProject(
                "Inventory Management System",
                "XYZ Inc",
                "30/06/2025",
                null,
                new String[]{"Alice", "Bob"},
                null
        );
    }
}
