//package com.odji.spring_back_end.test;
//
//import com.odji.spring_back_end.model.Command;
//import com.odji.spring_back_end.services.CommandService;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//
//import java.io.IOException;
//
//@SpringBootTest // Annotate with SpringBootTest for integration test
//public class CommandServiceIntegrationTest {
//
//    @Autowired
//    private CommandService commandService;
//
//    @Test
//    public void testExecuteCommand() throws IOException, InterruptedException {
//        String commandToExecute = "ls"; // Replace with your desired command
//
//        try {
//            Command commandResult = commandService.executeCommand(commandToExecute);
//            System.out.println("Command: " + commandResult.getCommand());
//            System.out.println("Output: \n" + commandResult.getOutput());
//            System.out.println("Exit Code: " + commandResult.getExitCode());
//        } catch (IOException | InterruptedException e) {
//            e.printStackTrace();
//        }
//    }
//}
