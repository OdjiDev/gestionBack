package com.odji.spring_back_end.services;

import org.slf4j.LoggerFactory;
import ch.qos.logback.classic.Logger;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

@Service
public class CommandService {

    private static final Logger LOGGER = (Logger) LoggerFactory.getLogger(CommandService.class);

//    public String executeCommand() throws IOException, InterruptedException {
//        String command = "dir"; // Hardcoded for "ls" command
//        ProcessBuilder pb = new ProcessBuilder(command); // Use the command directly
//
//        Process process = pb.start();
//
//        StringBuilder output = new StringBuilder();
//        try (BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()))) {
//            String line;
//            while ((line = reader.readLine()) != null) {
//                output.append(line).append("\n");
//                System.out.println(line);
//                LOGGER.info(line); // Print each line to the server console
//            }
//        }
//
//        process.waitFor();
//
//        int exitCode = process.exitValue();
//        if (exitCode != 0) {
//            throw new RuntimeException("Command execution failed with exit code: " + exitCode);
//        }
//
//        // You can return the output string if needed
//        return output.toString();
//       // return command;
//    }

//
//    public  void executeCommand( ) throws IOException, InterruptedException {
//
//        try {
//            Process process = Runtime.getRuntime().exec("ping");
//
//            try (BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()))) {
//                String line;
//
//                while ((line = reader.readLine()) != null) {
//                    System.out.println(line);
//                    //return line;
//                }
//            }
//
//            process.waitFor();
//
//            int exitCode = process.exitValue();
//            if (exitCode == 0) {
//                System.out.println("Command executed successfully.");
//            } else {
//                System.out.println("Command failed with exit code: " + exitCode);
//            }
//        } catch (IOException | InterruptedException e) {
//            e.printStackTrace();
//        }
//
//
//
//    }
//
//
//
//}
//
//
//
//
//

    public class PingController {

        @GetMapping("/execute")
        @ResponseBody
        public String executePing() {
            try {
                // Create a ProcessBuilder for the "ping" command
                ProcessBuilder processBuilder = new ProcessBuilder("ping");

                // Start the process
                Process process = processBuilder.start();

                // Read the process output and build a String
                StringBuilder outputBuilder = new StringBuilder();
                try (BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()))) {
                    String line;
                    while ((line = reader.readLine()) != null) {
                        outputBuilder.append(line).append("\n");
                    }
                }

                // Wait for the process to finish
                process.waitFor();

                // Check exit status and append message
                int exitCode = process.exitValue();
                outputBuilder.append("\nExit Code: ").append(exitCode);
                if (exitCode == 0) {
                    outputBuilder.append("\nPing command executed successfully.");
                } else {
                    outputBuilder.append("\nPing command failed.");
                }

                // Return the output String
                return outputBuilder.toString();
            } catch (IOException | InterruptedException e) {
                e.printStackTrace();
                return "Error executing ping command.";
            }
        }
    }
}
















//
//@Service
//public class CommandService {
//
//        private static final Logger LOGGER = (Logger) LoggerFactory.getLogger(CommandService.class);
//
//        public Command executeCommand(String command) throws IOException, InterruptedException {
//            ProcessBuilder pb = new ProcessBuilder(command.split(""));
//            Process process = pb.start();
//
//            StringBuilder output = new StringBuilder();
//            try (BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()))) {
//                String line;
//                while ((line = reader.readLine()) != null) {
//                    output.append(line).append("\n");
//                }
//            }
//
//            process.waitFor();
//
//            int exitCode = process.exitValue();
//            if (exitCode != 0) {
//                throw new RuntimeException("Command execution failed with exit code: " + exitCode);
//            }
//
//            return new Command(command, output.toString(), exitCode);
//        }
//
//}
