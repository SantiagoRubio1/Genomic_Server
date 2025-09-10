package utils;

import model.Patient;
import java.io.*;
import java.time.LocalDateTime;
import java.util.logging.*;

public class FileManager {
    private static final String PATIENTS_CSV = "src/resources/logs/patients.csv";
    private static final String DISEASES_REPORT = "src/resources/logs/disease_detections.csv";
    private static final Logger logger = Logger.getLogger(FileManager.class.getName());

    public static void savePatientToCSV(Patient patient) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(PATIENTS_CSV, true))) {
            writer.println(String.format("%s,%s,%s,%d,%c,%s,%s,%s,%s,%d",
                    patient.getPatientId(), patient.getFullName(), patient.getDocumentId(),
                    patient.getAge(), patient.getGender(), patient.getEmail(),
                    patient.getRegistrationDate(), patient.getClinicalNotes(),
                    patient.getChecksumFasta(), patient.getFileSizeBytes()));
        } catch (IOException e) {
            logger.severe("Error guardando paciente en CSV: " + e.getMessage());
        }
    }

    public static void logDiseaseDetection(String patientId, String diseaseId,
                                           int severity, String description) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(DISEASES_REPORT, true))) {
            writer.println(String.format("%s,%s,%d,%s,%s",
                    patientId, diseaseId, severity, LocalDateTime.now(), description));
        } catch (IOException e) {
            logger.severe("Error guardando detección de enfermedad: " + e.getMessage());
        }
    }
}