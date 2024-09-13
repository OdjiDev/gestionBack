package com.odji.spring_back_end.model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Command {

        private String command;
        private String output;
        private int exitCode;

        // Getters and setters omitted for brevity


//
//        public static void main(String[] args) throws IOException, InterruptedException {
//            // Replace with the actual command and arguments
//            String command = "git status";
//            String[] argsArray = {"git status"}; // Array of arguments
//
//            // Create a ProcessBuilder object
//            ProcessBuilder builder = new ProcessBuilder(command, "argsArray");
//
//            // Start the process and get the Process instance
//            //Process process = builder.start();
//           Process process = builder.start();
//
//
//            // Get the input stream of the process
//            InputStreamReader inputStreamReader = new InputStreamReader(process.getInputStream());
//            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
//
//            // Read the output line by line
//            String line;
//            while ((line = bufferedReader.readLine()) != null) {
//                System.out.println(line); // Print each line of output
//            }
//
//            // Wait for the command to finish executing
//            process.waitFor();
//
//            // Check the exit code for any errors
//            int exitCode = process.exitValue();
//            if (exitCode != 0) {
//                System.err.println("Command execution failed with exit code: " + exitCode);
//            } else {
//                System.out.println("Command executed successfully.");
//            }
//
//            // Close the buffered reader and input stream reader
//            bufferedReader.close();
//            inputStreamReader.close();
//        }
    }


