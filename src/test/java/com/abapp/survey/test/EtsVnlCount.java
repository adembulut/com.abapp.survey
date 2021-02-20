//package com.abapp.survey.test;
//
//import org.springframework.util.FileCopyUtils;
//import org.springframework.util.FileSystemUtils;
//
//import java.io.File;
//import java.io.FileReader;
//import java.util.HashSet;
//import java.util.List;
//import java.util.Set;
//import java.util.regex.Matcher;
//import java.util.regex.Pattern;
//
///*
//    Project : com.abapp.survey
//    User    : adem.bulut
//    Date    : 2/14/21 14:24
//*/
//public class EtsVnlCount {
//    public static void main(String[] args) throws Exception{
//        File file = new File("/Users/adem.bulut/Desktop/anket.sql");
//        String content = FileCopyUtils.copyToString(new FileReader(file));
//        Pattern pattern = Pattern.compile("(ets_vnl|ETS_VNTL)(\\.)([a-zA-Z0-9_]+)");
//        Matcher matcher = pattern.matcher(content);
//
//        Set<String> dependency = new HashSet<>();
//        while (matcher.find()){
//            String text = matcher.group(0);
//            dependency.add(text.trim().toUpperCase());
//        }
//        for (String s : dependency) {
//            System.out.println("bağımlılık \t : "+s);
//        }
//        System.out.println();
//    }
//}
