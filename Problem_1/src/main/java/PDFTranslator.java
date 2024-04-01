//import org.apache.pdfbox.pdmodel.PDDocument;
//import org.apache.pdfbox.text.PDFTextStripper;
//import java.io.File;
//import java.io.FileWriter;
//import java.io.IOException;
//
//public class PDFTranslator {
//	
//
//    public static void main(String[] args) {
//       
//    	String pdfFilePath = "D:\\CDAC\\_Local_Repository\\QQ_CDAC_Shubham_Lokhande\\3963 - गहाणखत.pdf"; // Replace with the path to your PDF file
//        String outputFilePath = "D:\\CDAC\\_Local_Repository\\QQ_CDAC_Shubham_Lokhande\\translated_text.csv"; // Output CSV file path
//
//        try {
//            // Extract text from rows 4, 7, and 8
//            String extractedText = extractTextFromPDF(pdfFilePath);
//            String[] lines = extractedText.split("\\r?\\n");
//            String row4 = lines.length > 3 ? lines[3] : "";
//            String row7 = lines.length > 6 ? lines[6] : "";
//            String row8 = lines.length > 7 ? lines[7] : "";
//
//            // Translate text from Marathi to English
//            String translatedRow4 = translateText(row4, "mr", "en");
//            String translatedRow7 = translateText(row7, "mr", "en");
//            String translatedRow8 = translateText(row8, "mr", "en");
//
//            // Save translated text into CSV file
//            saveToCSV(outputFilePath, translatedRow4, translatedRow7, translatedRow8);
//
//            System.out.println("Translation completed. Output saved to " + outputFilePath);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//
//    public static String extractTextFromPDF(String pdfFilePath) throws IOException {
//        try (PDDocument document = PDDocument.load(new File(pdfFilePath))) {
//            if (!document.isEncrypted()) {
//                PDFTextStripper stripper = new PDFTextStripper();
//                return stripper.getText(document);
//            } else {
//                throw new IOException("PDF is encrypted");
//            }
//        }
//    }
//
//    public static String translateText(String text, String sourceLang, String targetLang) {
//        // Implement translation logic here using your preferred translation library or service
//        // For example, you can use the Google Translate API or any other translation service.
//        // Here, we assume a placeholder method.
//        return "Translated: " + text; // Replace with actual translation logic
//    }
//
//    public static void saveToCSV(String filePath, String... rows) throws IOException {
//        try (FileWriter writer = new FileWriter(filePath)) {
//            for (String row : rows) {
//                writer.append(row).append("\n");
//            }
//        }	
//    	
//    	
//    	
//    }	
//}


import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;


public class PDFTranslator {

    public static void main(String[] args) {
        String pdfFilePath = "D:\\CDAC\\_Local_Repository\\QQ_CDAC_Shubham_Lokhande\\3963 - गहाणखत.pdf"; // Replace with the path to your PDF file
        String outputFilePath = "D:\\CDAC\\_Local_Repository\\QQ_CDAC_Shubham_Lokhande\\translated_text.csv"; // Output CSV file path

        try {
            // Extract specific rows from the PDF and translate them to English
            String translatedRow4 = translateText(extractRowFromPDF(pdfFilePath, 4), "mr", "en");
            String translatedRow7 = translateText(extractRowFromPDF(pdfFilePath, 7), "mr", "en");
            String translatedRow8 = translateText(extractRowFromPDF(pdfFilePath, 8), "mr", "en");

            // Save translated rows into a CSV file
            saveToCSV(outputFilePath, translatedRow4, translatedRow7, translatedRow8);

            System.out.println("Translation completed. Output saved to " + outputFilePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String extractRowFromPDF(String pdfFilePath, int rowNumber) throws IOException {
        try (PDDocument document = PDDocument.load(new File(pdfFilePath))) {
            if (!document.isEncrypted()) {
                PDFTextStripper stripper = new PDFTextStripper();
                String text = stripper.getText(document);
                String[] lines = text.split("\\r?\\n");
                if (rowNumber >= 1 && rowNumber <= lines.length) {
                    return lines[rowNumber - 1];
                }
                throw new IOException("Row number out of range");
            } else {
                throw new IOException("PDF is encrypted");
            }
        }
    }

    public static String translateText(String text, String sourceLang, String targetLang) {
        // Implement translation logic here using your preferred translation library or service
        // For example, you can use the Google Translate API or any other translation service.
        // Here, we assume a placeholder method.
        return "Translated: " + text; // Replace with actual translation logic
    }

    public static void saveToCSV(String filePath, String... rows) throws IOException {
        try (FileWriter writer = new FileWriter(filePath)) {
            for (String row : rows) {
                writer.append(row).append("\n");
            }
        }
    }
}

