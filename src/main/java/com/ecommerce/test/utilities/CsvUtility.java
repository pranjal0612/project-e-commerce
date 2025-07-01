package com.ecommerce.test.utilities;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class CsvUtility {

    public static void writeToCsv(String filePath, List<Map<String, String>> data) {
        try (FileWriter csvWriter = new FileWriter(filePath)) {
            if (!data.isEmpty()) {
                for (String key : data.get(0).keySet()) {
                    csvWriter.append(key);
                    csvWriter.append(",");
                }
                csvWriter.append("\n");
            }

            for (Map<String, String> row : data) {
                for (String value : row.values()) {
                    csvWriter.append("\"").append(value.replace("\"", "\"\"")).append("\"");
                    csvWriter.append(",");
                }
                csvWriter.append("\n");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

