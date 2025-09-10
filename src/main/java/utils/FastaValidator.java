package utils;

import java.security.MessageDigest;
import java.util.regex.Pattern;

public class FastaValidator {
    private static final Pattern FASTA_HEADER = Pattern.compile("^>[a-zA-Z0-9_]+$");
    private static final Pattern FASTA_SEQUENCE = Pattern.compile("^[ACGTN]+$");

    public static boolean validateFasta(String fastaContent) {
        String[] lines = fastaContent.split("\n");
        if (lines.length < 2) return false;

        if (!FASTA_HEADER.matcher(lines[0]).matches()) return false;

        for (int i = 1; i < lines.length; i++) {
            if (!FASTA_SEQUENCE.matcher(lines[i].trim()).matches()) return false;
        }
        return true;
    }
    public static String calculateChecksum(String content) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hash = md.digest(content.getBytes());
            StringBuilder hexString = new StringBuilder();
            for (byte b : hash) {
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1) hexString.append('0');
                hexString.append(hex);
            }
            return hexString.toString();
        } catch (Exception e) {
            throw new RuntimeException("Error calculating checksum", e);
        }
    }
}


