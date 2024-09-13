//package com.odji.spring_back_end.services;
//
//import com.odji.spring_back_end.GitUpdate.GitUpdateManagerApplication;
//import com.odji.spring_back_end.GitUpdateChecker;
//
//import com.odji.spring_back_end.repository.UpdateStatusRepository;
//import lombok.RequiredArgsConstructor;
//import org.springframework.stereotype.Service;
//
//import java.io.IOException;
//
//@Service
//@RequiredArgsConstructor
//public class UpdateService {
//    private final UpdateStatusRepository updateStatusRepository;
//    private final GitUpdateChecker gitUpdateChecker;
//
//    public GitUpdateManagerApplication checkForUpdates() throws IOException {
//        boolean updateAvailable = gitUpdateChecker.isUpdateAvailable();
//        String message = updateAvailable ? "Updates available!" : "No updates available.";
//        GitUpdateManagerApplication updateStatus = new GitUpdateManagerApplication(updateAvailable, message);
//        updateStatusRepository.save(updateStatus);
//        return updateStatus;
//    }
//
//    public GitUpdateManagerApplication getLatestUpdateStatus() {
//        return updateRepository.findLatestUpdateStatus();
//    }
//}
