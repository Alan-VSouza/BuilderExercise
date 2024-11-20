package org.example.model;

import lombok.Builder;

import java.util.Arrays;

@Builder
public class Project {
    private final String name;
    private final String client;
    private final String deadline;
    private final String[] technologies;
    private final String[] team;
    private final Double budget;

    @Override
    public String toString() {
        return String.format(
                        "\n" +
                        " - name: '%s',\n" +
                        " - client: '%s',\n" +
                        " - deadline: '%s',\n" +
                        " - technologies: %s,\n" +
                        " - team: %s,\n" +
                        " - budget: %s\n",
                name,
                client,
                deadline,
                (technologies != null ? Arrays.toString(technologies) : "None"),
                (team != null ? Arrays.toString(team) : "None"),
                (budget != null ? budget : "None")
        );
    }

    public static NameStep builder() {
        return new ProjectSteps();
    }

    public interface NameStep {
        ClientStep name(String name);
    }

    public interface ClientStep {
        DeadlineStep client(String client);
    }

    public interface DeadlineStep {
        OptionalSteps deadline(String deadline);
    }

    public interface OptionalSteps {
        OptionalSteps technologies(String[] technologies);
        OptionalSteps team(String[] team);
        OptionalSteps budget(Double budget);
        Project build();
    }

    private static class ProjectSteps implements NameStep, ClientStep, DeadlineStep, OptionalSteps {
        private String name;
        private String client;
        private String deadline;
        private String[] technologies;
        private String[] team;
        private Double budget;

        @Override
        public ClientStep name(String name) {
            this.name = name;
            return this;
        }

        @Override
        public DeadlineStep client(String client) {
            this.client = client;
            return this;
        }

        @Override
        public OptionalSteps deadline(String deadline) {
            this.deadline = deadline;
            return this;
        }

        @Override
        public OptionalSteps technologies(String[] technologies) {
            this.technologies = technologies;
            return this;
        }

        @Override
        public OptionalSteps team(String[] team) {
            this.team = team;
            return this;
        }

        @Override
        public OptionalSteps budget(Double budget) {
            this.budget = budget;
            return this;
        }

        @Override
        public Project build() {
            return new Project(name, client, deadline, technologies, team, budget);
        }
    }
}
