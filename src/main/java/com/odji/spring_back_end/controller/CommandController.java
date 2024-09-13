package com.odji.spring_back_end.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.odji.spring_back_end.model.Command;
import com.odji.spring_back_end.services.CommandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@CrossOrigin(origins ="http://localhost:4200/") // Enable CORS for frontend at port 4200
@RestController
@RequestMapping("/api")
public class CommandController {
   // private static final String SCRIPT_PATH = " Z:/logiciel_MAJ/Gestion/Gestion_Spring_Back_end/script.sh";
    //private static final String SCRIPT_PATH = "Z:/a rapport/Gestion/Gestion_Spring_Back_end/script.sh"; // Hardcoded script path
    //private static final String SCRIPT_PATH = "Z:/script.sh"; // Hardcoded script path
//    //    /



    //private static final String SCRIPT_PATH = "Z:/a rapport/Gestion/Gestion_Spring_Back_end/script.sh"; // Hardcoded script path

   //  private static final String SCRIPT_PATH = "Z:/logiciel_MAJ/client/gestion-complet-all-files-included-/Gestion_Spring_Back_end/script.sh"; // Hardcoded script path

    private static final String SCRIPT_PATH = "Z:/logiciel_MAJ/client/gestion-complet-all-files-included-/Gestion_Spring_Back_end/script.sh"; // Hardcoded script path

    //    /
    @GetMapping("/miseajours/execute")
    public ResponseEntity<String> executeScript() throws JsonProcessingException {
        String output;
        int exitCode;

        try {
            //essaie de mise a jour
            // Exécuter le script en utilisant ProcessBuilder avec Git Bash
            List<String> command = List.of("cmd", "/c", "C:\\Program Files\\Git\\bin\\bash.exe", "-c", SCRIPT_PATH);
            // Ajuster le chemin d'accès à l'installation de Git Bash si nécessaire
            ProcessBuilder processBuilder = new ProcessBuilder(command);
            Process process = processBuilder.start();

            InputStream inputStream = process.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            StringBuilder outputBuilder = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                outputBuilder.append(line).append("\n");
            }
            reader.close();
            process.waitFor();
            exitCode = process.exitValue();

            if (exitCode != 0) {
                throw new RuntimeException("Script exited with error code: " + exitCode);
            }

            output = outputBuilder.toString();
        } catch (IOException | InterruptedException | RuntimeException e) {
            output = "Error executing script: " + e.getMessage();
            exitCode = -1;
        }

        Map<String, Object> responseMap = new HashMap<>();
        responseMap.put("output", output);
        responseMap.put("exitCode", exitCode);


        return ResponseEntity.status(exitCode == 0 ? HttpStatus.OK : HttpStatus.BAD_REQUEST)
                .body(new ObjectMapper().writeValueAsString(responseMap));
    }
}




//    @GetMapping("/execute")
//    public ResponseEntity<String> executeScript() throws JsonProcessingException {
//        String output;
//        int exitCode;
//
//        try {
//            //essaie de mise a jour
//            // Exécuter le script en utilisant ProcessBuilder avec Git Bash
//            List<String> command = List.of("cmd", "/c", "C:\\Program Files\\Git\\bin\\bash.exe", "-c", SCRIPT_PATH);
//            // Ajuster le chemin d'accès à l'installation de Git Bash si nécessaire
//            ProcessBuilder processBuilder = new ProcessBuilder(command);
//            Process process = processBuilder.start();
//
//            InputStream inputStream = process.getInputStream();
//            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
//            StringBuilder outputBuilder = new StringBuilder();
//            String line;
//            while ((line = reader.readLine()) != null) {
//                outputBuilder.append(line).append("\n");
//            }
//            reader.close();
//            process.waitFor();
//            exitCode = process.exitValue();
//
//            if (exitCode != 0) {
//                throw new RuntimeException("Script exited with error code: " + exitCode);
//            }
//
//            output = outputBuilder.toString();
//        } catch (IOException | InterruptedException | RuntimeException e) {
//            output = "Error executing script: " + e.getMessage();
//            exitCode = -1;
//        }
//
//        Map<String, Object> responseMap = new HashMap<>();
//        responseMap.put("output", output);
//        responseMap.put("exitCode", exitCode);
//
//        return ResponseEntity.status(exitCode == 0 ? HttpStatus.OK : HttpStatus.BAD_REQUEST)
//                .body(new ObjectMapper().writeValueAsString(responseMap));
//    }
//}


//
//@CrossOrigin(origins = "*") // Enable CORS for frontend at port 4200
//@RestController
//@RequestMapping("/api/command")
//public class CommandController {
//
//    private static final String SCRIPT_PATH = "C:/script.sh"; // Hardcoded script path
//
//    @GetMapping("/execute")
//    public ResponseEntity<String> executeScript() throws JsonProcessingException {
//        String output;
//        int exitCode;
//
//        try {
//            // Execute script using ProcessBuilder
//            List<String> command = List.of( SCRIPT_PATH); // Split command into arguments
//            ProcessBuilder processBuilder = new ProcessBuilder(command);
//            Process process = processBuilder.start();
//
//            InputStream inputStream = process.getInputStream();
//            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
//            StringBuilder outputBuilder = new StringBuilder();
//            String line;
//            while ((line = reader.readLine()) != null) {
//                outputBuilder.append(line).append("\n");
//            }
//            reader.close();
//            process.waitFor();
//            exitCode = process.exitValue();
//
//            if (exitCode != 0) {
//                throw new RuntimeException("Script exited with error code: " + exitCode);
//            }
//
//            output = outputBuilder.toString();
//        } catch (IOException | InterruptedException | RuntimeException e) {
//            output = "Error executing script: " + e.getMessage();
//            exitCode = -1;
//        }
//
//        Map<String, Object> responseMap = new HashMap<>();
//        responseMap.put("output", output);
//        responseMap.put("exitCode", exitCode);
//
//        return ResponseEntity.status(exitCode == 0 ? HttpStatus.OK : HttpStatus.BAD_REQUEST)
//                .body(new ObjectMapper().writeValueAsString(responseMap));
//    }
//}


//processBuilder.directory(new File("/path/to/working/directory"));


//
//    @GetMapping("/execute")
//    @ResponseBody
//    public String executePing() {
//        try {
//            // Create a ProcessBuilder for the "ping" command
//            ProcessBuilder processBuilder = new ProcessBuilder("ping");
//
//            // Start the process
//            Process process = processBuilder.start();
//
//            // Read the process output and build a String
//            StringBuilder outputBuilder = new StringBuilder();
//            try (BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()))) {
//                String line;
//                while ((line = reader.readLine()) != null) {
//                    outputBuilder.append(line).append("\n");
//                }
//            }
//
//            // Wait for the process to finish
//            process.waitFor();
//
//            // Check exit status and append message
//            int exitCode = process.exitValue();
//            outputBuilder.append("\nExit Code: ").append(exitCode);
//            if (exitCode == 0) {
//                outputBuilder.append("\nPing command executed successfully.");
//            } else {
//                outputBuilder.append("\nPing command failed.");
//            }
//
//            // Return the output String
//            return outputBuilder.toString();
//        } catch (IOException | InterruptedException e) {
//            e.printStackTrace();
//            return "Error executing ping command.";
//        }
//    }
//}




