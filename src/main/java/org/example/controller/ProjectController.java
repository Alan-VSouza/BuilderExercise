package org.example.controller;

import org.example.model.Project;
import org.example.view.ProjectView;

public class ProjectController {
    private final ProjectView view;

    public ProjectController(ProjectView view) {
        this.view = view;
    }

    public void createProject(String name, String client, String deadline) {
        createProject(name, client, deadline, null, null, null);
    }

    public void createProject(String name, String client, String deadline,
                              String[] technologies, String[] team, Double budget) {
        Project project = Project.builder()
                .name(name)
                .client(client)
                .deadline(deadline)
                .technologies(technologies)
                .team(team)
                .budget(budget)
                .build();

        view.displayProject(project);
    }
}
