package com.example.comment;

import java.util.Arrays;
import java.util.Map;
import java.util.Random;

// 名字、
// 课堂表现：注意力、笔记卷面、举手互动、独特或突出的表现（如第一个完成xx题）、随机鼓励评语
// 3个知识点（数量待定）（知识点哪里好，为什么好，哪里不好，为什么不好）、
// 作业反馈（哪道题错了，是否有订正）、
// quiz反馈（哪道题错了，是否有订正）、
// 作业布置
public class CommentGenerator {

    public static final String startAnewLine = "\n \n";
    public static final String comma = "，";
    public static int quizCorrectTotal;


//    public static String[]
//    public static String[]
//    public static String[]
//    public static String[]

    public static String commentGenerator() {
        quizCorrectTotal = 0;
        String output = "";
        String name = HelloApplication.name;

        output += name + " Lesson #" + HelloApplication.lesson + "的课堂反馈来啦： \n \n";
        output += "本次课知识点: " + HelloApplication.lessonTopic + startAnewLine;

        if (HelloApplication.lessonConcept1Check && !HelloApplication.lessonConcept1A1.isEmpty()) {
            output += HelloApplication.lessonConcept1A1 + startAnewLine;
        } else if (HelloApplication.lessonConcept1Check2 && !HelloApplication.lessonConcept1A2.isEmpty()) {
            output += HelloApplication.lessonConcept1A2 + startAnewLine;
        }
        if (HelloApplication.lessonConcept2Check && !HelloApplication.lessonConcept2A1.isEmpty()) {
            output += HelloApplication.lessonConcept2A1 + startAnewLine;
        } else if (HelloApplication.lessonConcept2Check2 && !HelloApplication.lessonConcept2A2.isEmpty()) {
            output += HelloApplication.lessonConcept2A2 + startAnewLine;
        }
        if (HelloApplication.lessonConcept3Check && !HelloApplication.lessonConcept3A1.isEmpty()) {
            output += HelloApplication.lessonConcept3A1 + startAnewLine;
        } else if (HelloApplication.lessonConcept3Check2 && !HelloApplication.lessonConcept3A2.isEmpty()) {
            output += HelloApplication.lessonConcept3A2 + startAnewLine;
        }

//        quizCountCorrect();
        quizCorrectTotal = HelloApplication.quizCorrectTotal;
        output += "本次课上quiz的正确率为";
        if (quizCorrectTotal == HelloApplication.quizTotal) {
            output += "满分。希望" + name + "继续保持课后复习的好习惯哦！";
        } else {
            output += quizCorrectTotal + "/" + HelloApplication.quizTotal + "。 错题对应知识点";
            if (!HelloApplication.quizQ1Check) {
                output += HelloApplication.quizConcept1 + comma;
            }
            if (!HelloApplication.quizQ2Check) {
                output += HelloApplication.quizConcept2 + comma;
            }
            if (!HelloApplication.quizQ3Check) {
                output += HelloApplication.quizConcept3 + comma;
            }
            output = output.substring(0,output.length()-1);
            output += "。" ;
            if (!HelloApplication.quizComment.isEmpty()) {
                output += HelloApplication.quizComment + startAnewLine;
            }
        }

        Map<String, String> lastHWPageToConcept = HelloApplication.lastHWPageToConcept;

        String hwWrongPage = HelloApplication.hwWrongPage;
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
            }
            output = output.substring(0,output.length()-1);
            output += "。";
        }
        output += startAnewLine + HelloApplication.currentHW + startAnewLine;










//        HelloApplication.quizCorrectTotal = 0;
        return output;
    }

    public static String randomPick(String[] arr) {
        int n = arr.length;
        Random ran = new Random();
        return arr[ran.nextInt(n)];
    }



}
