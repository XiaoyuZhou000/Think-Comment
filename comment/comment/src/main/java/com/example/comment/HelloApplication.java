package com.example.comment;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import java.awt.datatransfer.StringSelection;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class HelloApplication extends Application {

    public static String currComment;
    public static String filePath = new File("commentsProfile.txt").getAbsolutePath();

    // Constant
    public static final int leftX = 100;
    public static final int rightX = 740;

    public static final int topY = 70;
    public static int quizCorrectTotal = 0;
    public static int quizTotal = 3;
    public static String newLine = "\n";
    public static int leftProfileTotal = 23;

    // Global variable
    public static Map<String, String> lastHWPageToConcept = new HashMap<>();

    // Left box
    public static TextField lessonField;
    public static TextField lessonTopicField;
    public static TextArea lessonConcept1Area1;
    public static TextArea lessonConcept1Area2;
    public static TextArea lessonConcept2Area1;
    public static TextArea lessonConcept2Area2;
    public static TextArea lessonConcept3Area1;
    public static TextArea lessonConcept3Area2;
    public static TextArea lessonConcept4Area1;
    public static TextArea lessonConcept4Area2;
    public static TextField quizQuestionField1;
    public static TextField quizConceptField1;
    public static TextField quizQuestionField2;
    public static TextField quizConceptField2;
    public static TextField quizQuestionField3;
    public static TextField quizConceptField3;
    public static TextField hwConceptPageField1;
    public static TextField hwConceptField1;
    public static TextField hwConceptPageField2;
    public static TextField hwConceptField2;
    public static TextField hwConceptPageField3;
    public static TextField hwConceptField3;
    public static TextArea thisHwArea;

    // Left profile
    public static String lesson;
    public static String lessonTopic;
    public static String lessonConcept1A1;
    public static String lessonConcept1A2;
    public static String lessonConcept2A1;
    public static String lessonConcept2A2;
    public static String lessonConcept3A1;
    public static String lessonConcept3A2;
    public static String lessonConcept4A1;
    public static String lessonConcept4A2;
    public static String quizQ1;
    public static String quizConcept1;
    public static String quizQ2;
    public static String quizConcept2;
    public static String quizQ3;
    public static String quizConcept3;
    public static String hwConceptPage1;
    public static String hwConcept1;
    public static String hwConceptPage2;
    public static String hwConcept2;
    public static String hwConceptPage3;
    public static String hwConcept3;
    public static String currentHW;

    // Right profile
    public static String name;
    public static boolean lessonConcept1Check;
    public static boolean lessonConcept1Check2;
    public static boolean lessonConcept2Check;
    public static boolean lessonConcept2Check2;
    public static boolean lessonConcept3Check;
    public static boolean lessonConcept3Check2;
//    public static int quizCorrectTotal = 0;
    public static boolean quizQ1Check;
    public static boolean quizQ2Check;
    public static boolean quizQ3Check;
    public static String quizComment;
    public static String hwWrongPage;




    @Override
    public void start(Stage stage) throws IOException {
//        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));

//        System.out.println("javafx.runtime.version: " + System.getProperty("javafx.runtime.version"));
        AnchorPane root = new AnchorPane();
        Scene scene = new Scene(root, 1280, 720);
        stage.setTitle("反馈生成");
        stage.setScene(scene);
        stage.setResizable(false);

        leftProfileWin(root);
        rightConversationWin(root);


        stage.show();

    }

    public static void leftProfileWin(AnchorPane root) {
        Label lessonLabel = new Label("课次：");
        lessonLabel.setLayoutX(100);
        lessonLabel.setLayoutY(topY);

        lessonField = new TextField();
        lessonField.setPromptText("Enter your text here");
        lessonField.setLayoutX(100);
        lessonField.setLayoutY(topY+20);

        Label lessonConcept = new Label("本次课主题及其知识点：");
        lessonConcept.setLayoutX(100);
        lessonConcept.setLayoutY(topY+50);

        lessonTopicField = new TextField();
        lessonTopicField.setPromptText("主题");
        lessonTopicField.setLayoutX(100);
        lessonTopicField.setLayoutY(topY+70);

        lessonConcept1Area1 = new TextArea();
        lessonConcept1Area1.setPromptText("知识点1掌握评语");
        lessonConcept1Area1.setWrapText(true);
        lessonConcept1Area1.setPrefWidth(200);
        lessonConcept1Area1.setPrefHeight(50);
        lessonConcept1Area1.setLayoutX(leftX);
        lessonConcept1Area1.setLayoutY(topY+90);

        lessonConcept1Area2 = new TextArea();
        lessonConcept1Area2.setPromptText("知识点1没掌握评语");
        lessonConcept1Area2.setWrapText(true);
        lessonConcept1Area2.setLayoutX(leftX+200);
        lessonConcept1Area2.setLayoutY(topY+90);
        lessonConcept1Area2.setPrefWidth(200);
        lessonConcept1Area2.setPrefHeight(50);

        lessonConcept2Area1 = new TextArea();
        lessonConcept2Area1.setPromptText("知识点2掌握评语");
        lessonConcept2Area1.setWrapText(true);
        lessonConcept2Area1.setLayoutX(leftX);
        lessonConcept2Area1.setLayoutY(topY+140);
        lessonConcept2Area1.setPrefWidth(200);
        lessonConcept2Area1.setPrefHeight(50);

        lessonConcept2Area2 = new TextArea();
        lessonConcept2Area2.setPromptText("知识点2没掌握评语");
        lessonConcept2Area2.setWrapText(true);
        lessonConcept2Area2.setLayoutX(leftX+200);
        lessonConcept2Area2.setLayoutY(topY+140);
        lessonConcept2Area2.setPrefWidth(200);
        lessonConcept2Area2.setPrefHeight(50);

        lessonConcept3Area1 = new TextArea();
        lessonConcept3Area1.setPromptText("知识点3掌握评语");
        lessonConcept3Area1.setWrapText(true);
        lessonConcept3Area1.setLayoutX(leftX);
        lessonConcept3Area1.setLayoutY(topY+190);
        lessonConcept3Area1.setPrefWidth(200);
        lessonConcept3Area1.setPrefHeight(50);

        lessonConcept3Area2 = new TextArea();
        lessonConcept3Area2.setPromptText("知识点3没掌握评语");
        lessonConcept3Area2.setWrapText(true);
        lessonConcept3Area2.setLayoutX(leftX+200);
        lessonConcept3Area2.setLayoutY(topY+190);
        lessonConcept3Area2.setPrefWidth(200);
        lessonConcept3Area2.setPrefHeight(50);

        lessonConcept4Area1 = new TextArea();
        lessonConcept4Area1.setPromptText("知识点4掌握评语");
        lessonConcept4Area1.setWrapText(true);
        lessonConcept4Area1.setLayoutX(leftX);
        lessonConcept4Area1.setLayoutY(topY+240);
        lessonConcept4Area1.setPrefWidth(200);
        lessonConcept4Area1.setPrefHeight(50);

        lessonConcept4Area2 = new TextArea();
        lessonConcept4Area2.setPromptText("知识点4没掌握评语");
        lessonConcept4Area2.setWrapText(true);
        lessonConcept4Area2.setLayoutX(leftX+200);
        lessonConcept4Area2.setLayoutY(topY+240);
        lessonConcept4Area2.setPrefWidth(200);
        lessonConcept4Area2.setPrefHeight(50);

        Label quizConcept = new Label("Quiz题号及其对应的知识点：");
        quizConcept.setLayoutX(leftX);
        quizConcept.setLayoutY(topY+300);

        quizQuestionField1 = new TextField();
        quizQuestionField1.setPromptText("题号1");
        quizQuestionField1.setLayoutX(100);
        quizQuestionField1.setLayoutY(topY+320);

        quizConceptField1 = new TextField();
        quizConceptField1.setPromptText("知识点1");
        quizConceptField1.setLayoutX(leftX+50);
        quizConceptField1.setLayoutY(topY+320);

        quizQuestionField2 = new TextField();
        quizQuestionField2.setPromptText("题号2");
        quizQuestionField2.setLayoutX(leftX);
        quizQuestionField2.setLayoutY(topY+340);

        quizConceptField2 = new TextField();
        quizConceptField2.setPromptText("知识点2");
        quizConceptField2.setLayoutX(leftX+50);
        quizConceptField2.setLayoutY(topY+340);

        quizQuestionField3 = new TextField();
        quizQuestionField3.setPromptText("题号3");
        quizQuestionField3.setLayoutX(100);
        quizQuestionField3.setLayoutY(topY+360);

        quizConceptField3 = new TextField();
        quizConceptField3.setPromptText("知识点3");
        quizConceptField3.setLayoutX(leftX+50);
        quizConceptField3.setLayoutY(topY+360);

        Label hwConcept = new Label("上周作业页码以及对应的知识点：");
        hwConcept.setLayoutX(leftX);
        hwConcept.setLayoutY(topY+390);

        hwConceptPageField1 = new TextField();
        hwConceptPageField1.setPromptText("页码1");
        hwConceptPageField1.setLayoutX(leftX);
        hwConceptPageField1.setLayoutY(topY+410);

        hwConceptField1 = new TextField();
        hwConceptField1.setPromptText("知识点1");
        hwConceptField1.setLayoutX(leftX+50);
        hwConceptField1.setLayoutY(topY+410);

        hwConceptPageField2 = new TextField();
        hwConceptPageField2.setPromptText("页码2");
        hwConceptPageField2.setLayoutX(leftX);
        hwConceptPageField2.setLayoutY(topY+430);

        hwConceptField2 = new TextField();
        hwConceptField2.setPromptText("知识点2");
        hwConceptField2.setLayoutX(leftX+50);
        hwConceptField2.setLayoutY(topY+430);

        hwConceptPageField3 = new TextField();
        hwConceptPageField3.setPromptText("页码3");
        hwConceptPageField3.setLayoutX(leftX);
        hwConceptPageField3.setLayoutY(topY+450);

        hwConceptField3 = new TextField();
        hwConceptField3.setPromptText("知识点3");
        hwConceptField3.setLayoutX(leftX+50);
        hwConceptField3.setLayoutY(topY+450);

        Label thisHwLabel = new Label("本次作业：");
        thisHwLabel.setLayoutX(leftX);
        thisHwLabel.setLayoutY(topY+480);

        thisHwArea = new TextArea();
        thisHwArea.setPromptText("本次作业");
        thisHwArea.setWrapText(true);
        thisHwArea.setLayoutX(leftX);
        thisHwArea.setLayoutY(topY+500);
        thisHwArea.setMaxWidth(300);
        thisHwArea.setMaxHeight(100);


        Button saveProfileButton = new Button("Save");
        saveProfileButton.setOnAction(e -> {
            lesson = lessonField.getText();
            lessonTopic = lessonTopicField.getText();
            lessonConcept1A1 = lessonConcept1Area1.getText();
            lessonConcept1A2 = lessonConcept1Area2.getText();
            lessonConcept2A1 = lessonConcept2Area1.getText();
            lessonConcept2A2 = lessonConcept2Area2.getText();
            lessonConcept3A1 = lessonConcept3Area1.getText();
            lessonConcept3A2 = lessonConcept3Area2.getText();
            lessonConcept4A1 = lessonConcept4Area1.getText();
            lessonConcept4A2 = lessonConcept4Area2.getText();
            quizConcept1 = quizConceptField1.getText();
            quizConcept2 = quizConceptField2.getText();
            quizConcept3 = quizConceptField3.getText();
            quizQ1 = quizQuestionField1.getText();
            quizQ2 = quizQuestionField2.getText();
            quizQ3 = quizQuestionField3.getText();
            hwConceptPage1 = hwConceptPageField1.getText();
            hwConcept1 = hwConceptField1.getText();
            hwConceptPage2 = hwConceptPageField2.getText();
            hwConcept2 = hwConceptField2.getText();
            hwConceptPage3 = hwConceptPageField3.getText();
            hwConcept3 = hwConceptField3.getText();
            currentHW = thisHwArea.getText();



            lastHWPageToConcept.put(hwConceptPage1, hwConcept1);
            lastHWPageToConcept.put(hwConceptPage2, hwConcept2);
            lastHWPageToConcept.put(hwConceptPage3, hwConcept3);

            write();

        });

        Button saveProfileAsButton = new Button("Save As");
        saveProfileAsButton.setLayoutX(50);
        saveProfileAsButton.setOnAction(e -> {
//            write();
        });

        Button loadProfileButton = new Button("Load");
        loadProfileButton.setLayoutX(115);
        loadProfileButton.setOnAction(e -> {
            read();
        });


        root.getChildren().addAll(
                lessonLabel,
                lessonField,
                lessonConcept,
                lessonTopicField,
                lessonConcept1Area1,
                lessonConcept1Area2,
                lessonConcept2Area1,
                lessonConcept2Area2,
                lessonConcept3Area1,
                lessonConcept3Area2,
                lessonConcept4Area1,
                lessonConcept4Area2,
                quizConcept,
                quizQuestionField1,
                quizConceptField1,
                quizQuestionField2,
                quizConceptField2,
                quizQuestionField3,
                quizConceptField3,

                hwConcept,
                hwConceptPageField1,
                hwConceptField1,
                hwConceptPageField2,
                hwConceptField2,
                hwConceptPageField3,
                hwConceptField3,
                thisHwLabel,
                thisHwArea,
                saveProfileButton,
                saveProfileAsButton,
                loadProfileButton
        );



    }

    public static void rightConversationWin(AnchorPane root) {
        Label nameLebel = new Label("名字：");
        nameLebel.setLayoutX(740);
        nameLebel.setLayoutY(topY);

        TextField nameField = new TextField();
        nameField.setPromptText("Enter your text here");
        nameField.setLayoutX(rightX);
        nameField.setLayoutY(topY+20);

        Label lessonConceptLabel1 = new Label("知识点1");
        lessonConceptLabel1.setLayoutX(rightX);
        lessonConceptLabel1.setLayoutY(topY+50);

        CheckBox lessonConcept1CheckBox = new CheckBox("掌握");
        lessonConcept1CheckBox.setLayoutX(rightX);
        lessonConcept1CheckBox.setLayoutY(topY+70);
        lessonConcept1CheckBox.setOnAction(event -> {
            lessonConcept1Check = lessonConcept1CheckBox.isSelected();
        });

        CheckBox lessonConcept1CheckBox2 = new CheckBox("没掌握");
        lessonConcept1CheckBox2.setLayoutX(rightX+50);
        lessonConcept1CheckBox2.setLayoutY(topY+70);
        lessonConcept1CheckBox2.setOnAction(event -> {
            lessonConcept1Check2 = lessonConcept1CheckBox2.isSelected();
        });

        Label lessonConceptLabel2 = new Label("知识点2");
        lessonConceptLabel2.setLayoutX(rightX);
        lessonConceptLabel2.setLayoutY(topY+100);

        CheckBox lessonConcept2CheckBox = new CheckBox("掌握");
        lessonConcept2CheckBox.setLayoutX(rightX);
        lessonConcept2CheckBox.setLayoutY(topY+120);
        lessonConcept2CheckBox.setOnAction(event -> {
            lessonConcept2Check = lessonConcept2CheckBox.isSelected();
        });

        CheckBox lessonConcept2CheckBox2 = new CheckBox("没掌握");
        lessonConcept2CheckBox2.setLayoutX(rightX+50);
        lessonConcept2CheckBox2.setLayoutY(topY+120);
        lessonConcept2CheckBox2.setOnAction(event -> {
            lessonConcept2Check2 = lessonConcept2CheckBox2.isSelected();
        });

        Label lessonConceptLabel3 = new Label("知识点3");
        lessonConceptLabel3.setLayoutX(rightX);
        lessonConceptLabel3.setLayoutY(topY+150);

        CheckBox lessonConcept3CheckBox = new CheckBox("掌握");
        lessonConcept3CheckBox.setLayoutX(rightX);
        lessonConcept3CheckBox.setLayoutY(topY+170);
        lessonConcept3CheckBox.setOnAction(event -> {
            lessonConcept3Check = lessonConcept3CheckBox.isSelected();
        });

        CheckBox lessonConcept3CheckBox2 = new CheckBox("没掌握");
        lessonConcept3CheckBox2.setLayoutX(rightX+50);
        lessonConcept3CheckBox2.setLayoutY(topY+170);
        lessonConcept3CheckBox2.setOnAction(event -> {
            lessonConcept3Check2 = lessonConcept3CheckBox2.isSelected();
        });

        Label quizLabel = new Label("Quiz答对的题有：");
        quizLabel.setLayoutX(rightX);
        quizLabel.setLayoutY(topY+200);

        CheckBox quizQ1CheckBox = new CheckBox("Q1");
        quizQ1CheckBox.setLayoutX(rightX+100);
        quizQ1CheckBox.setLayoutY(topY+200);
        quizQ1CheckBox.setOnAction(event -> {
            quizQ1Check = quizQ1CheckBox.isSelected();
//            quizCorrectTotal++;
        });

        CheckBox quizQ2CheckBox = new CheckBox("Q2");
        quizQ2CheckBox.setLayoutX(rightX+150);
        quizQ2CheckBox.setLayoutY(topY+200);
        quizQ2CheckBox.setOnAction(event -> {
            quizQ2Check = quizQ2CheckBox.isSelected();
//            quizCorrectTotal++;
        });

        CheckBox quizQ3CheckBox = new CheckBox("Q3");
        quizQ3CheckBox.setLayoutX(rightX+200);
        quizQ3CheckBox.setLayoutY(topY+200);
        quizQ3CheckBox.setOnAction(event -> {
            quizQ3Check = quizQ3CheckBox.isSelected();
//            quizCorrectTotal++;
        });

        TextArea quizCommentArea = new TextArea();
        quizCommentArea.setPromptText("quiz评语");
        quizCommentArea.setLayoutX(rightX);
        quizCommentArea.setLayoutY(topY+220);
        quizCommentArea.setWrapText(true);
        quizCommentArea.setPrefWidth(300);
        quizCommentArea.setPrefHeight(100);




        Label hwWrongQLabel = new Label("上周错题页数(留白表示没有错题，页数用空格隔开。例如：1 2):");
        hwWrongQLabel.setLayoutX(rightX);
        hwWrongQLabel.setLayoutY(topY+330);

        TextField hwWrongQField = new TextField();
        hwWrongQField.setPromptText("Enter your text here");
        hwWrongQField.setLayoutX(rightX);
        hwWrongQField.setLayoutY(topY+350);



        Label submitPrompt = new Label("生成的文本会被自动复制，可直接粘贴");
        submitPrompt.setLayoutX(710);
        submitPrompt.setLayoutY(5);
        Button submitButton = new Button("Generate");
        submitButton.setLayoutX(640);
        submitButton.setOnAction(e -> {

            zeroCorrectedQuizCount();
            quizQ1CheckBox.setOnAction(event -> {
                quizQ1Check = quizQ1CheckBox.isSelected();
            });
            quizQ2CheckBox.setOnAction(event -> {
                quizQ2Check = quizQ2CheckBox.isSelected();
            });
            quizQ3CheckBox.setOnAction(event -> {
                quizQ3Check = quizQ3CheckBox.isSelected();
            });
            quizCountCorrect();


            name = nameField.getText();
            hwWrongPage = hwWrongQField.getText();
            quizComment = quizCommentArea.getText();


            currComment = CommentGenerator.commentGenerator();

            Stage commentStage = new Stage();
            commentStage.setHeight(650);
            commentStage.setWidth(650);
            commentStage.setTitle("Current Generated Comment");

            Label showCurrComment = new Label(currComment);
            showCurrComment.setLayoutX(250);
            showCurrComment.setLayoutY(topY);

            StackPane commentStageLayout = new StackPane();
            commentStageLayout.getChildren().addAll(showCurrComment);
            Scene commentStageScene = new Scene(commentStageLayout, 200, 200);
            commentStage.setScene(commentStageScene);
            commentStage.setResizable(false);


            commentStage.show();



            StringSelection stringSelectionObj = new StringSelection(currComment);
            Clipboard clipboardObj = Toolkit.getDefaultToolkit().getSystemClipboard();
            clipboardObj.setContents(stringSelectionObj, null);
        });

        Button submitForAllButton = new Button("Generate From File");
        submitForAllButton.setLayoutX(640);
        submitForAllButton.setLayoutY(30);


        root.getChildren().addAll(
                nameLebel,
                nameField,
                lessonConceptLabel1,
                lessonConcept1CheckBox,
                lessonConcept1CheckBox2,
                lessonConceptLabel2,
                lessonConcept2CheckBox,
                lessonConcept2CheckBox2,
                lessonConceptLabel3,
                lessonConcept3CheckBox,
                lessonConcept3CheckBox2,
                quizLabel,
                quizQ1CheckBox,
                quizQ2CheckBox,
                quizQ3CheckBox,
                quizCommentArea,
                hwWrongQLabel,
                hwWrongQField,
                submitButton,
                submitPrompt,
                submitForAllButton
        );
    }

    public static void main(String[] args) {
        checkProfileExists();
        launch();
    }

    public static void write() {

        // 可自定义文件存放路径
        // 路径需要为绝对路径
        String textToWrite = lesson+ newLine +
                            lessonTopic+ newLine +
                            lessonConcept1A1+ newLine +
                            lessonConcept1A2+ newLine +
                            lessonConcept2A1+ newLine +
                            lessonConcept2A2+ newLine +
                            lessonConcept3A1+ newLine +
                            lessonConcept3A2+ newLine +
                            lessonConcept4A1+ newLine +
                            lessonConcept4A2+ newLine +
                            quizQ1+ newLine +
                            quizConcept1+ newLine +
                            quizQ2+ newLine +
                            quizConcept2+ newLine +
                            quizQ3+ newLine +
                            quizConcept3+ newLine +
                            hwConceptPage1+ newLine +
                            hwConcept1+ newLine +
                            hwConceptPage2+ newLine +
                            hwConcept2+ newLine +
                            hwConceptPage3+ newLine +
                            hwConcept3+ newLine +
                            currentHW;

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            writer.write(textToWrite);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void read() {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            String[] input = new String[leftProfileTotal];
            int index = 0;
            while ((line = reader.readLine()) != null) {
//                System.out.println(line);
                input[index] = line;
                index++;
            }
            index = 0;
            lesson = input[index++];
            lessonTopic = input[index++];
            lessonConcept1A1 = input[index++];
            lessonConcept1A2 = input[index++];
            lessonConcept2A1 = input[index++];
            lessonConcept2A2 = input[index++];
            lessonConcept3A1 = input[index++];
            lessonConcept3A2 = input[index++];
            lessonConcept4A1 = input[index++];
            lessonConcept4A2 = input[index++];
            quizQ1 = input[index++];
            quizConcept1 = input[index++];
            quizQ2 = input[index++];
            quizConcept2 = input[index++];
            quizQ3 = input[index++];
            quizConcept3 = input[index++];
            hwConceptPage1 = input[index++];
            hwConcept1 = input[index++];
            hwConceptPage2 = input[index++];
            hwConcept2 = input[index++];
            hwConceptPage3 = input[index++];
            hwConcept3 = input[index++];
            currentHW = input[index++];

            lessonField.setText(lesson);
            lessonTopicField.setText(lessonTopic);
            lessonConcept1Area1.setText(lessonConcept1A1);
            lessonConcept1Area2.setText(lessonConcept1A2);
            lessonConcept2Area1.setText(lessonConcept2A1);
            lessonConcept2Area2.setText(lessonConcept2A2);
            lessonConcept3Area1.setText(lessonConcept3A1);
            lessonConcept3Area2.setText(lessonConcept3A2);
            lessonConcept4Area1.setText(lessonConcept4A1);
            lessonConcept4Area2.setText(lessonConcept4A2);
            quizQuestionField1.setText(quizQ1);
            quizConceptField1.setText(quizConcept1);
            quizQuestionField2.setText(quizQ2);
            quizConceptField2.setText(quizConcept2);
            quizQuestionField3.setText(quizQ3);
            quizConceptField3.setText(quizConcept3);
            hwConceptPageField1.setText(hwConceptPage1);
            hwConceptField1.setText(hwConcept1);
            hwConceptPageField2.setText(hwConceptPage2);
            hwConceptField2.setText(hwConcept2);
            hwConceptPageField3.setText(hwConceptPage3);
            hwConceptField3.setText(hwConcept3);
            thisHwArea.setText(currentHW);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void checkProfileExists() {
        try {
            if (!new File(filePath).exists()) {
//                System.out.println(filePath);
                new File(filePath).createNewFile();
            }
//            System.out.println(filePath);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void zeroCorrectedQuizCount() {
        quizCorrectTotal = 0;
    }

    public static void quizCountCorrect() {
        if (HelloApplication.quizQ1Check) {
            quizCorrectTotal++;
        }
        if (HelloApplication.quizQ2Check) {
            quizCorrectTotal++;
        }
        if (HelloApplication.quizQ3Check) {
            quizCorrectTotal++;
        }

    }

    public static String writeField() {
        String output = "lesson" + lesson;

        return output;
    }
}