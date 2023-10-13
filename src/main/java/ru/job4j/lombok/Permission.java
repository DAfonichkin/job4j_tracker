package ru.job4j.lombok;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder(builderMethodName = "of")
public class Permission {
    private int id;
    private String name;
    private List<String> rules;
}