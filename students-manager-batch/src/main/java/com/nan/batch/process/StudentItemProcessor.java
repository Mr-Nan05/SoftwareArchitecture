package com.nan.batch.process;

import com.nan.batch.model.Student;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.batch.item.ItemProcessor;

public class StudentItemProcessor implements ItemProcessor<Student, Student> {

    private static final Logger log = LoggerFactory.getLogger(StudentItemProcessor.class);

    @Override
    public Student process(final Student student) throws Exception {

        log.info("Converting (" + student + ") into (" + student + ")");
        return student;
    }

}

