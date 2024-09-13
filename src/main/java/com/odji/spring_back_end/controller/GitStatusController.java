package com.odji.spring_back_end.controller;
import ch.qos.logback.core.status.Status;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.info.ProjectInfoProperties;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/update")
@RequiredArgsConstructor
public class GitStatusController {


   // @PostMapping("/status-check")





}


























//    public ResponseEntity<String> getGitStatus(@RequestBody String repositoryUrl) {
//        try {
//            // Replace "cloned-repo" with your desired directory
//            File localRepoDir = new File("cloned-repo");
//            // Clone the repository using JGit
//            ProjectInfoProperties.Git git = ProjectInfoProperties.Git.cloneRepository()
//                    .setURI(URIish.create(repositoryUrl))
//                    .setDirectory(localRepoDir)
//                    .call();
//
//            // Get the status of the cloned repository
//            Iterable<Ref> refs = git.listBranches();
//            StringBuilder output = new StringBuilder();
//            output.append("Current branch: ";
//            output.append(refs.iterator().next().getName() + "\n");
//            Status status = git.getRepository().getStatus();
//            if (status.getUncommittedChanges().isEmpty() && status.getUntracked().isEmpty()) {
//                output.append("Working directory is clean.");
//            } else {
//                // ... (rest of the logic for handling uncommitted and untracked files)
//            }
//
//            // Close the Git object (optional, but recommended)
//            git.close();
//            return ResponseEntity.ok(output.toString());
//        } catch (GitException e) {
//            // Handle Git exceptions (e.g., cloning failed)
//            return ResponseEntity.badRequest().body("Error: " + e.getMessage());
//        }
//    }
//}
//
//
//}
//package com.odji.spring_back_end.controller;
//
//import ch.qos.logback.core.status.Status;  // This import is not used in the code and can be removed
//import lombok.RequiredArgsConstructor;
//import org.springframework.boot.autoconfigure.info.ProjectInfoProperties;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.io.File;
//
//    @RestController
//    @CrossOrigin(origins = "http://localhost:4200")
//    @RequestMapping("/update")
//    @RequiredArgsConstructor
//    public class GitStatusController {

//        @PostMapping("/status-check")
//        public ResponseEntity<String> getGitStatus(@RequestBody String repositoryPath) {
//            String output = executeGitStatusCommand(repositoryPath);
//            return ResponseEntity.ok(output);
//        }
//
//        private String executeGitStatusCommand(String repositoryPath) {
//            try {
//                // Using JGit library (recommended)
//                ProjectInfoProperties.Git git = ProjectInfoProperties.Git.open(new File(repositoryPath));
//                Iterable<Ref> refs = git.listBranches();
//                StringBuilder output = new StringBuilder();
//                output.append("Current branch: ");
//                output.append(refs.iterator().next().getName() + "\n");
//                Status status = git.getRepository().getStatus();
//                if (status.getUncommittedChanges().isEmpty() && status.getUntracked().isEmpty()) {
//                    output.append("Working directory is clean.");
//                } else {
//                    if (!status.getUncommittedChanges().isEmpty()) {
//                        output.append("Uncommitted changes:\n");
//                        for (FilePath change : status.getUncommittedChanges()) {
//                            output.append(change.getStatus().name() + " " + change.toString() + "\n");
//                        }
//                    }
//                    if (!status.getUntracked().isEmpty()) {
//                        output.append("Untracked files:\n");
//                        for (FilePath file : status.getUntracked()) {
//                            output.append(file.toString() + "\n");
//                        }
//                    }
//                }
//                git.close();
//                return output.toString();
//            } catch (Exception e) {
//                // Handle exceptions (e.g., Git repository not found)
//                return "Error: " + e.getMessage();
//            }
//        }
//    }
//



//    private final ResourcePatternResolver resourcePatternResolver;
//
//    @GetMapping("/check-updates")
//    public UpdateStatus checkUpdates() throws IOException {
//        String gitStatusOutput = executeCommand("git status");
//        Matcher matcher = Pattern.compile("(behind|diverged|integrate|pull)", Pattern.CASE_INSENSITIVE).matcher(gitStatusOutput);
//        boolean updateAvailable = matcher.find();
//
//        return new UpdateStatus(updateAvailable, gitStatusOutput);
//    }
//
//    private static String executeCommand(String command) throws IOException {
//        try (BufferedReader reader = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec(command).getInputStream()))) {
//            StringBuilder output = new StringBuilder();
//            String line;
//            while ((line = reader.readLine()) != null) {
//                output.append(line).append("\n");
//            }
//            return output.toString();
//        }
//    }
//
//    public static class UpdateStatus {
//        @JsonProperty("updateAvailable")
//        private final boolean updateAvailable;
//
//        @JsonProperty("gitStatusOutput")
//        private final String gitStatusOutput;
//
//        public UpdateStatus(boolean updateAvailable, String gitStatusOutput) {
//            this.updateAvailable = updateAvailable;
//            this.gitStatusOutput = gitStatusOutput;
//        }
//
//        public boolean isUpdateAvailable() {
//            return updateAvailable;
//        }
//
//        public String getGitStatusOutput() {
//            return gitStatusOutput;
//        }
//    }
//}
