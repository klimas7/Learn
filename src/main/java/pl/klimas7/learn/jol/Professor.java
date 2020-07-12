package pl.klimas7.learn.jol;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Professor {
    private String name;
    private boolean tenured;
    private List<Course> courses = new ArrayList<>();
    private int level;
    private LocalDate birthDay;
    private double lastEvaluation;
}
