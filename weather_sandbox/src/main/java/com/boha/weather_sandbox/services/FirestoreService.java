package com.boha.weather_sandbox.services;

import com.boha.weather_sandbox.util.E;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;

@Service
public class FirestoreService {
    private static final Logger LOGGER = Logger.getLogger(FirestoreService.class.getSimpleName());

    public FirestoreService() {
        LOGGER.info(E.RED_APPLE+E.RED_APPLE+
                " FirestoreService constructed");
    }
//    void initFirebase() {
//        LOGGER.info(E.AMP+E.AMP+E.AMP+ " initializing Firebase ....");
//        FirebaseOptions options = null;
//        projectId = System.getenv().get("PROJECT_ID");
//        if (projectId == null) {
//            return;
//        }
//        LOGGER.info(E.AMP+E.AMP+E.AMP+
//                " Project Id from System.getenv: "+E.RED_APPLE + " " + projectId);
//        try {
//            options = FirebaseOptions.builder()
//                    .setCredentials(GoogleCredentials.getApplicationDefault())
//                    .setDatabaseUrl("https://" +  projectId  + ".firebaseio.com/")
//                    .build();
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//
//        FirebaseApp app = FirebaseApp.initializeApp(options);
//        LOGGER.info(E.AMP+E.AMP+E.AMP+
//                " Firebase has been initialized: " + app.getOptions().getDatabaseUrl()
//                + " " + E.RED_APPLE);
//
//    }
}
