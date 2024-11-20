package org.example.view;

import org.example.model.Project;

public class ProjectView {
    private int projectCount = 0;

    public void displayProject(Project project) {
        projectCount++;
        System.out.println("\n=====================================");
        System.out.println("          PROJECT DETAILS - " + projectCount);
        System.out.println(project);
    }
}
