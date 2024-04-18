package com.example.comment;

import java.awt.*;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.*;
import java.util.List;

import com.opencsv.*;



public class GeneratorForFile {
    public static final String startAnewLine = "\n \n";
    public static final String comma = "，";
    public static String inputFilePath = new File("student list.csv").getAbsolutePath();
    public static String outputFilePath = new File("output comments.csv").getAbsolutePath();
    public static void generatorForFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader(inputFilePath))) {
            reader.readLine();
//            Map<String, String[]> student = new HashMap<>();
            List<String[]> comments = new ArrayList<>();
            String line = null;
//            BufferedWriter writer = new BufferedWriter(new FileWriter(outputFilePath));
            while ((line = reader.readLine()) != null) {
                String[] lineArray = line.split(",");
                String name = lineArray[0];
                boolean concept1 = lineArray[1].equals("1");
                boolean concept2 = lineArray[2].equals("1");
                boolean concept3 = lineArray[3].equals("1");
                boolean quizQ1 = lineArray[4].equals("1");
                boolean quizQ2 = lineArray[5].equals("1");
                boolean quizQ3 = lineArray[6].equals("1");
                String quizFeedback = lineArray[7];
                String hwWrongPage = lineArray[8];
                String hwFeedback = lineArray[9];


                String output = name + " Lesson #" + HelloApplication.lesson + "的课堂反馈来啦： \n \n";
                output += "本次课知识点: " + HelloApplication.lessonTopic + startAnewLine;
                if (concept1 && !HelloApplication.lessonConcept1A1.isEmpty()) {
                    output += HelloApplication.lessonConcept1A1 + startAnewLine;
                } else if (!concept1 && !HelloApplication.lessonConcept1A2.isEmpty()) {
                    output += HelloApplication.lessonConcept1A2 + startAnewLine;
                }
                if (concept2 && !HelloApplication.lessonConcept2A1.isEmpty()) {
                    output += HelloApplication.lessonConcept2A1 + startAnewLine;
                } else if (!concept2 && !HelloApplication.lessonConcept2A2.isEmpty()) {
                    output += HelloApplication.lessonConcept2A2 + startAnewLine;
                }
                if (concept3 && !HelloApplication.lessonConcept3A1.isEmpty()) {
                    output += HelloApplication.lessonConcept3A1 + startAnewLine;
                } else if (!concept3 && !HelloApplication.lessonConcept3A2.isEmpty()) {
                    output += HelloApplication.lessonConcept3A2 + startAnewLine;
                }
                int quizCorrectTotal = 0;
                quizCorrectTotal = quizQ1?quizCorrectTotal+1:quizCorrectTotal;
                quizCorrectTotal = quizQ2?quizCorrectTotal+1:quizCorrectTotal;
                quizCorrectTotal = quizQ3?quizCorrectTotal+1:quizCorrectTotal;
                output += "本次课上quiz的正确率为";
                if (quizCorrectTotal == HelloApplication.quizTotal) {
                    output += "满分。希望" + name + "继续保持课后复习的好习惯哦！";
                } else {
                    output += quizCorrectTotal + "/" + HelloApplication.quizTotal + "。 错题对应知识点";
                    if (!quizQ1) {
                        output += HelloApplication.quizConcept1 + comma;
                    }
                    if (!quizQ2) {
                        output += HelloApplication.quizConcept2 + comma;
                    }
                    if (!quizQ3) {
                        output += HelloApplication.quizConcept3 + comma;
                    }
                    output = output.substring(0,output.length()-1);
                    output += "。" ;
                    if (HelloApplication.quizComment != null) {
                        output += HelloApplication.quizComment + startAnewLine;
                    }
                }
                Map<String, String> lastHWPageToConcept = HelloApplication.lastHWPageToConcept;

                if (hwWrongPage.isEmpty()) {
                    output += "";
//                    name + "的作业全对哦！很厉害，希望再接再厉！" + startAnewLine;
                } else {
                    output += "上周作业错题页数： ";
//        if (hwWrongPage.isEmpty()) {
//            output += name + "的作业全对哦！很厉害，希望再接再厉！";
//        } else {

                    String[] pages = hwWrongPage.split(" ");
                    output += Arrays.toString(pages) + "，对应知识点：";
                    for (String page:pages) {
                        output += lastHWPageToConcept.get(page) + comma;
                        System.out.println(page);
                    }
                    output = output.substring(0,output.length()-1);
                    output += "。";
                }
                output += startAnewLine + HelloApplication.currentHW + startAnewLine;




                comments.add(new String[]{output});

//                System.out.println(output);
            }

//            writer.close();
//            writeCSV(outputFilePath, comments);

            try (CSVWriter writer = new CSVWriter(new OutputStreamWriter(new FileOutputStream(outputFilePath),
                    "GBK"))) {
                writer.writeAll(comments);
                if (Desktop.isDesktopSupported()&&HelloApplication.alwaysOpenCSV) {
                    try {
                        Desktop.getDesktop().open(new File(outputFilePath));
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }




//            System.out.println(lines);

            if (Desktop.isDesktopSupported()&&HelloApplication.alwaysOpenCSV) {
                try {
                    Desktop.getDesktop().open(new File(new File("output comments.csv").getAbsolutePath()));
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void writeCSV(String filePath, List<String[]> list) {
        try {
            OutputStreamWriter outputStreamWriter =
                    new OutputStreamWriter(new FileOutputStream(filePath), "GBK");
            BufferedWriter writer = new BufferedWriter(outputStreamWriter);
            for (String[] s : list) {
                writer.write(Arrays.toString(s));
                writer.newLine();
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
