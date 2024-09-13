//package com.odji.spring_back_end.model;
//
//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//import org.springframework.stereotype.Component;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.regex.Matcher;
//import java.util.regex.Pattern;
//
//@Component
//public class GitUpdateChecker {
//
//    private static final String GIT_STATUS_COMMAND = "git status";
//    private static final Pattern UPDATE_PATTERN = Pattern.compile("(behind|diverged|integrate|pull)", Pattern.CASE_INSENSITIVE);
//
//    public static String getGitStatus() throws IOException {
//        String gitStatusOutput = executeCommand(GIT_STATUS_COMMAND);
//        Matcher matcher = UPDATE_PATTERN.matcher(gitStatusOutput);
//        boolean updateAvailable = matcher.find();
//
//        StringBuilder jsonResponse = new StringBuilder("{");
//        jsonResponse.append("\"updateAvailable\": ").append(updateAvailable).append(", ");
//        jsonResponse.append("\"message\": \"").append(updateAvailable ? "Updates available!" : "No updates available.").append("\"");
//        jsonResponse.append("}");
//
//        return jsonResponse.toString();
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
//}
