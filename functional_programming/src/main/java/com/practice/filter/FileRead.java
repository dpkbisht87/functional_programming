package com.practice.filter;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class FileRead {
    public static void main(String[] args) throws IOException {

        List<String> listOfFiles = Files.lines(Paths.get("/Users/dbisht/Documents/CodeBase/personal/springboot/functional_programming/pom.xml"))
               .filter(line -> line.contains("groupId"))
               .map(line -> line.trim().replaceAll("groupId", "")
               .replaceAll(">", "")
               .replaceAll("<", "")
               .replaceAll("/", ""))
               .collect(Collectors.toList());

        System.out.println(listOfFiles);

    }
}
