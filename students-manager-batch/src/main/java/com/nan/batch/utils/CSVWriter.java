package com.nan.batch.utils;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.List;

public class CSVWriter {
    File csvFile;
    BufferedWriter csvWriter;

    public CSVWriter() throws FileNotFoundException, UnsupportedEncodingException {
        csvFile = new File("src/main/resources/students-info.csv");
        csvWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(csvFile), StandardCharsets.UTF_8), 1024);
    }


    public void writeCsv(List<List<String>> rows) throws IOException {
        try {
            for (List<String> row : rows){
                writeRow(row);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                csvWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
        private void writeRow(List<String> row) throws IOException {
            for(int i = 0; i < row.size(); i++){
                if(i != row.size() - 1){
                    csvWriter.write(row.get(i) + ",");
                }else {
                    csvWriter.write(row.get(i));
                    csvWriter.newLine();
                }
            }

        }


    }
