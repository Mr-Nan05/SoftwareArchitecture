package com.nan.batch;

import com.nan.batch.utils.CSVWriter;
import com.nan.batch.utils.XLSXReader;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

import static org.apache.tomcat.jni.Time.sleep;

@SpringBootApplication
public class StudentsManagerBatchApplication {

    public static void main(String[] args) throws IOException, InterruptedException {
        XLSXReader reader = new XLSXReader();
        CSVWriter csvWriter= new CSVWriter();
        List<List<String>> tmp = reader.xlsxReader("src/main/resources/students-info.xlsx");
        csvWriter.writeCsv(tmp);
        System.exit(SpringApplication.exit(SpringApplication.run(StudentsManagerBatchApplication.class, args)));
    }

}
