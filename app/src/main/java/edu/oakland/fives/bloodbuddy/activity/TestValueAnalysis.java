package edu.oakland.fives.bloodbuddy.activity;

import android.content.Context;
import android.widget.Toast;

import java.util.ArrayList;

import edu.oakland.fives.bloodbuddy.model.DataModel;

public class TestValueAnalysis {

    private ArrayList<DataModel> tests;
    private String gender;
    private Context context;

    public TestValueAnalysis(Context context, ArrayList<DataModel> tests, String gender) {
        this.tests = tests;
        this.gender=gender;
        this.context=context;
    }

    public void analysis() {

        Toast.makeText(context,""+gender, Toast.LENGTH_LONG).show();

        for (DataModel dataModel : this.tests) {
            switch (dataModel.getTestName()) {
                case "WBC":
                    if (dataModel.getValue() < 11.5){
                        dataModel.setRange(1);
                        dataModel.setAnalysis("Your white blood cell count is low. This generally means your immune system is weaker than the" +
                                "average person. Your body's ability to fight diseases has been lessened. " +
                                "This could be attributed to many diseases. See your doctor for more information.");
                    }
                    else if (dataModel.getValue() > 14.5) {
                        dataModel.setRange(3);
                        dataModel.setAnalysis("Your body's white blood cell count is high. White blood cells are produced by your body" +
                                " at a certain rate. Usually, this means that your body is producing white blood cells at a higher" +
                                "than normal rate. This can sometimes mean that one has a more serious disease like leukemia. Do not" +
                                "panic. See your doctor for more information.");
                    } else {
                        dataModel.setRange(2);
                        dataModel.setAnalysis("Your white blood cell count is normal. This is indicitive of a healthy immune system.");
                    }
                    break;
                case "RBC":
                    //Male test values for RBC
                    if (gender.matches("Male") && dataModel.getValue() < 4.6) {
                        dataModel.setRange(1);
                        dataModel.setAnalysis("Your red blood cell count is low compared to the average man. This means that you have fewer red blood" +
                                "cells than the average individual. Red blood cells carry oxygen, so this could mean that your body is having trouble" +
                                "getting oxygen to the rest of your body. This is often indicative of more serious conditions. Consult your doctor straight" +
                                "away. ");
                    }
                    else if (gender.matches("Male") &&dataModel.getValue() > 6.0) {
                        dataModel.setRange(3);
                        dataModel.setAnalysis("Your red blood cell count is high compared to the average man. This means that you have more " +
                                "red blood cells than the average person. Usually this is not a problem as your body is very good at adjusting the number" +
                                "of red cells produced to match what you need. In some situations, however, this can indicate more serious" +
                                "diseases such as leukemia. ");
                    }
                    else if (gender.matches("Male") && (dataModel.getValue() >= 4.6 && dataModel.getValue() <= 6.0)) {
                        dataModel.setRange(2);
                        dataModel.setAnalysis("Your red blood cell count compared to the average man is normal. This means you have" +
                                "a healthy amount of red blood cells. ");
                    }
                    //Female Test values for rbc
                    else if (gender.matches("Female") && dataModel.getValue() < 20) {
                        dataModel.setRange(1);
                        dataModel.setAnalysis("Your red blood cell count is low compared to the average woman. This means you have fewer" +
                                "red blood cells than the average indicidual. Red blood cells carry oxygen, so this could mean that your body is  having trouble" +
                                "getting oxygen to the rest of your body. This is often indicative of more serious conditions. Consult your doctor.");
                    }
                    else if (gender.matches("Female") &&dataModel.getValue() > 30) {
                        dataModel.setRange(3);
                        dataModel.setAnalysis("Your red blood cell count is high compared to the average woman. This means that you have more " +
                                "red blood cells than the average person. Usually this is not a problem as your body is very good at adjusting the number" +
                                "of red cells produced to match what you need. In some situations, however, this can indicate more serious" +
                                "diseases such as leukemia. ");
                    }
                    else if (gender.matches("Female") && (dataModel.getValue() >= 20 || dataModel.getValue() <= 6.0)){
                        dataModel.setRange(2);
                        dataModel.setAnalysis("Your red blood cell count compared to the average woman is normal. This means you have" +
                                "a healthy amount of red blood cells. ");
                    }
                    break;
                case "HGB":
                    //Male Test values for hgb
                    if (gender.matches("Male") && dataModel.getValue() < 13){
                        dataModel.setRange(1);
                        dataModel.setAnalysis("Your hemoglobin is low. Recall that hemoglobin is the chemical that helps" +
                                " your red cells carry oxygen. Low hemoglobin means that your red cells cannot do their job." +
                                " This is a condition called anemia. It may sound scary, but anemia can come from many sources," +
                                " and not all of them are diseases. For example, you may not be eating enough healthy foods. In" +
                                " some cases anemia can be a symptom of more severe diseases. Please consult your doctor.");
                    }
                    else if (gender.matches("Male") && dataModel.getValue() > 16.5) {
                        dataModel.setRange(3);
                        dataModel.setAnalysis("Your hemoglobin is higher than the average person. This is usually not a big issue." +
                                " Too much hemogobin is not a difficult problem for your body to solve. Give it some time, eat healthy," +
                                "and the problem will usually sort itself out. ");
                    }
                    else if(gender.matches("Male") && (dataModel.getValue() >= 13 && dataModel.getValue() <= 16.5)) {
                        dataModel.setRange(2);
                        dataModel.setAnalysis("Everything looks good. Your red blood cells have the right amount of hemoglobin to" +
                                " do their job.");
                    }
                    //Female Test values for hgb
                    else if (gender.matches("Female") && dataModel.getValue() < 20) {
                        dataModel.setRange(1);
                        dataModel.setAnalysis("Your hemoglobin is low. Recall that hemoglobin is the chemical that helps" +
                                " your red cells carry oxygen. Low hemoglobin means that your red cells cannot do their job." +
                                " This is a condition called anemia. It may sound scary, but anemia can come from many sources," +
                                " and not all of them are diseases. For example, you may not be eating enough healthy foods. In" +
                                " some cases, anemia can be a symptom of more severe diseases. Please consult your doctor.");
                    }
                    else if (gender.matches("Female") &&dataModel.getValue() > 30) {
                        dataModel.setRange(3);
                        dataModel.setAnalysis("Your hemoglobin is higher than the average person. This is usually not a big issue." +
                                " Too much hemogobin is not a difficult problem for your body to solve. Give it some time, eat healthy," +
                                "and the problem will usually sort itself out. ");
                    }
                    else if (gender.matches("Female") && (dataModel.getValue() >= 20 && dataModel.getValue() <= 6.0)){
                        dataModel.setRange(2);
                        dataModel.setAnalysis("Everything looks good. Your red blood cells have the right amount of hemoglobin to" +
                                " do their job.");
                    }
                    break;
                case "HCT":
                    //Male test values for hct
                    if (gender.matches("Male") && dataModel.getValue() < 37.5){
                        dataModel.setRange(1);
                        dataModel.setAnalysis("Your hematocrit is low. This means that the proportion of cells to the volume of " +
                                "blood is low. This could mean a wide variety of things medically. Just know that the total volume of your " +
                                "cells is lower than the average man in comparison to the amount of fluid in your blood.");
                    }
                    else if (gender.matches("Male") && dataModel.getValue() > 52) {
                        dataModel.setRange(3);
                        dataModel.setAnalysis("Your hematocrit is high. This means that the proportion of cells to the volume of" +
                                "your blood is high. This could mean a wide variety of things medically. Just know that the total" +
                                "volume of your cells is lower than the average man in comparison to the amount of fluid in your body.");
                    } else if(gender.matches("Male") && (dataModel.getValue() >= 37.5 && dataModel.getValue() <= 52)){
                        dataModel.setRange(2);
                        dataModel.setAnalysis("Your hematocrit is average. This means that, in comparison to the average man, your blood" +
                                "to cell ratio is just fine.");
                    }
                    //Female Test values for hct
                    else if (gender.matches("Female") && dataModel.getValue() < 20) {
                        dataModel.setRange(1);
                        dataModel.setAnalysis("Your hematocrit is low. This means that the proportion of cells to the volume of " +
                                "blood is low. This could mean a wide variety of things medically. Just know that the total volume of your " +
                                "cells is lower than the average woman in comparison to the amount of fluid in your blood.");
                    }
                    else if (gender.matches("Female") &&dataModel.getValue() > 30) {
                        dataModel.setRange(3);
                        dataModel.setAnalysis("Your hematocrit is high. This means that the proportion of cells to the volume of" +
                                "your blood is high. This could mean a wide variety of things medically. Just know that the total" +
                                "volume of your cells is lower than the average woman in comparison to the amount of fluid in your body.");
                    }
                    else if (gender.matches("Female") && (dataModel.getValue() >= 20 && dataModel.getValue() <= 6.0)){
                        dataModel.setRange(2);
                        dataModel.setAnalysis("Your hematocrit is average. This means that, in comparison to the average woman, your blood" +
                                "to cell ratio is just fine.");
                    }
                    break;
                case "MCV":
                    if (dataModel.getValue() < 80){
                        dataModel.setRange(1);
                        dataModel.setAnalysis("Your mean cell volume is low. This means the average size of your red blood cells is smaller" +
                                "than the average person. This is known as microcytic.");
                    }
                    else if (dataModel.getValue() > 100) {
                        dataModel.setRange(3);
                        dataModel.setAnalysis("Your mean cell volume is high. This means the average size of your red cells is larger" +
                                "than the average person. This is known as macrocytic. ");
                    } else {
                        dataModel.setRange(2);
                        dataModel.setAnalysis("Your mean cell volume is average. This means the average size of your red cells is " +
                                "avareage compared to the average person. This is known as normocytic.");
                    }
                    break;
                case "MCH":
                    if (dataModel.getValue() < 26){
                        dataModel.setRange(1);
                        dataModel.setAnalysis("Your mean cell hemoglobin is low. Recall that hemoglobin is the chemical that helps" +
                                "red blood cells carry oxygen. Your average amount of hemoglobin in your cells is low. This is known" +
                                "as anemia. Consult your doctor for what to do about anemia.");
                    }
                    else if (dataModel.getValue() > 32) {
                        dataModel.setRange(3);
                        dataModel.setAnalysis("Your mean cell hemoglobin is high. Recall that hemoglobin is the chemical that helps" +
                                "red blood cells carry oxygen. Your average amount of hemoglobin in your cells is low. This usually" +
                                " is not a problem. With too much hemoglobin, your body can usually correct itself, but in rare cases" +
                                "this might be a symptom of a more serious disease like leukemia. Consult your doctor.");
                    } else {
                        dataModel.setRange(2);
                        dataModel.setAnalysis("Your mean cell hemoglobin is average. Recall that hemoglobin is the chemical that helps" +
                                "red blood ells carry oxygen. Your average amount of hemoglobin in your red cells is just right.");
                    }
                    break;
                case "MCHC":
                    if (dataModel.getValue() < 32){
                        dataModel.setRange(1);
                        dataModel.setAnalysis("Your mean cell hemoglobin concentration is low. This means that the concentration of" +
                                " hemoglobin, the chemical which helps your red blood cells carry oxygen, in your red cells is low." +
                                " This means you have a lessened ability to carry oxygen to your body. This is called anemia, and it can" +
                                "indicate more serious medical conditions. Consult your doctor.");
                    }
                    else if (dataModel.getValue() > 36) {
                        dataModel.setRange(3);
                        dataModel.setAnalysis("Your mean cell hemoglobin concentration is high. This means that the concentration of" +
                                " hemoglobin, the chemical which helps your red blood cells carry oxgyen, in your red cells is high." +
                                " This is a very unusual result. It could mean that your cells are smaller than normal, so the concentration" +
                                "of hemoglobin is relatively higher. Consult your doctor for further information.");
                    } else {
                        dataModel.setRange(2);
                        dataModel.setAnalysis("Your mean cell hemoglobin concentration is normal.Your red blood cells have the right " +
                                "concentration of hemoglobin.");
                    }
                    break;
                case "RDW":
                    if (dataModel.getValue() < 11.5){
                        dataModel.setRange(1);
                        dataModel.setAnalysis("Your red cell distribution width is low. This result means that your red blood cells are" +
                                " suspiciously uniform in size. This could mean nothing, but it could also be an indicator for other medical" +
                                " conditions. Consult your doctor for more information.");
                    }
                    else if (dataModel.getValue() > 14.5) {
                        dataModel.setRange(3);
                        dataModel.setAnalysis("Your red cell distribution width is high. This result means that your red blood cells are" +
                                " very ununiform in size. This usually indicates that your body is producing red cells at a very fast rate" +
                                " seeing as younger red blood cells tend to be larger than older ones. This could also indicate that you are" +
                                " anemic. See your doctor right away.");
                    } else {
                        dataModel.setRange(2);
                        dataModel.setAnalysis("Your red cell distribution width is average. This means that the varience on the size of" +
                                "your red blood cells is normal compared to the average person.");
                    }
                    break;
                case "PLT":
                    //Male test values for PLT
                    if (gender.matches("Male") && dataModel.getValue() < 150){
                        dataModel.setRange(1);
                        dataModel.setAnalysis("Your platelet count is low. This means that you may have some trouble healing when you" +
                                " receive an injury like a cut. Platelets help your blood to clot, so your clotting may or may not be slower" +
                                " due to what this test indicates.");
                    }

                    else if (gender.matches("Male") && dataModel.getValue() > 450) {
                        dataModel.setRange(3);
                        dataModel.setAnalysis("Your plately count is fairly high. This means that you have an increased chance of getting" +
                                "blood clots. Platelets help clot your blood when you get an injury, so having too many means that your " +
                                "blood could randomly clot. This can also indicate more serious medical issues, so please consult your" +
                                "doctor. ");
                    }
                    else if (gender.matches("Male") && (dataModel.getValue() >= 20 && dataModel.getValue() <= 6.0)){
                        dataModel.setRange(2);
                        dataModel.setAnalysis("You have the right amount of platelets for the average adult man. This means that your" +
                                " body will heal from cuts and injuries in the way that it is supposed to.");
                    }
                    //Female Test values for PLT
                    else if (gender.matches("Female") && dataModel.getValue() < 20) {
                        dataModel.setRange(1);
                        dataModel.setAnalysis("Your platelet count is low. This means that you may have some trouble healing when you" +
                                " receive an injury like a cut. Platelets help your blood to clot, so your clotting may or may not be slower" +
                                " due to what this test indicates.");
                    }
                    else if (gender.matches("Female") &&dataModel.getValue() > 30) {
                        dataModel.setRange(3);
                        dataModel.setAnalysis("Your plately count is fairly high. This means that you have an increased chance of getting" +
                                "blood clots. Platelets help clot your blood when you get an injury, so having too many means that your " +
                                "blood could randomly clot. This can also indicate more serious medical issues, so please consult your" +
                                "doctor. ");
                    }
                    else if (gender.matches("Female") && (dataModel.getValue() >= 20 && dataModel.getValue() <= 6.0)){
                        dataModel.setRange(2);
                        dataModel.setAnalysis("Your platelet count is low. This means that you may have some trouble healing when you" +
                                " receive an injury like a cut. Platelets help your blood to clot, so your clotting may or may not be slower" +
                                " due to what this test indicates.");
                    }
                    break;
                case "MPV":
                    if (dataModel.getValue() < 6.8){
                        dataModel.setRange(1);
                        dataModel.setAnalysis("Your mean platelet volume is low. This means you have small platelets. ");
                    }
                    else if (dataModel.getValue() > 10.2) {
                        dataModel.setRange(3);
                        dataModel.setAnalysis(" Your mean platelet volume is high. This means you have large platelets. ");
                    } else {
                        dataModel.setRange(2);
                        dataModel.setAnalysis("Your platelet size is just right" );
                    }
                    break;
                case "NEUT %":
                    if (dataModel.getValue() < 50){
                        dataModel.setRange(1);
                        dataModel.setAnalysis("The percentage of neutrophils in your blood is very low. This could mean that you have" +
                                " a lessened ability to fight off disease, were it to occur. Having fewer neutrophils can be indicitive" +
                                "of serious immune system difficulties. Consult your doctor straight away. ");
                    }
                    else if (dataModel.getValue() > 70) {
                        dataModel.setRange(3);
                        dataModel.setAnalysis("The percentage of neutrophils in your body is very high. This could mean that you are " +
                                "currently fighting a disease. Neutrophil percentages go up when your body is in the middle of helping you" +
                                " heal from sickness. It could also indicate leukemia. Do not panic. Consult your doctor before making any " +
                                "decisions.");
                    } else {
                        dataModel.setRange(2);
                        dataModel.setAnalysis("You seem to have the right amount of neutrophils. This means that you are a healthy individual. " +
                                "with no immune system problems. ");
                    }
                    break;
                case "LYMPH %":
                    if (dataModel.getValue() < 18){
                        dataModel.setRange(1);
                        dataModel.setAnalysis("Your lymphocyte percentage is low. Lymphocytes counts are not usually low. This is an issue" +
                                "that only your doctor can solve. The cause could be a great many things including malnutrition and HIV.");
                    }
                    else if (dataModel.getValue() > 42) {
                        dataModel.setRange(3);

                        dataModel.setAnalysis("Your lymphocyte percentage is high. High lymphocyte counts usually indicate that the body " +
                                "is fighting some sort of infection, likely viral. High lymphocyte counts are also sometimes attributed to " +
                                "certain types of leukemia, but please consult your doctor before making any decisions.");
                    }
                    else {
                        dataModel.setRange(2);
                        dataModel.setAnalysis("You seem to have the lymphocyte percentage that a healthy person would have. ");
                    }
                    break;
                case "MONO %":
                    if (dataModel.getValue() < 2){
                        dataModel.setRange(1);
                        dataModel.setAnalysis("Your monocyte percentage is low. ");
                    }
                    else if (dataModel.getValue() > 11) {
                        dataModel.setRange(3);
                        dataModel.setAnalysis("Your monocyte percentage is high. ");
                    }
                    else {
                        dataModel.setRange(2);
                        dataModel.setAnalysis("Your monocyte percentage is average. ");
                    }
                    break;
                case "EOS %":
                    if (dataModel.getValue() < 1){
                        dataModel.setRange(1);
                        dataModel.setAnalysis("Your eosinophil percentage is low. This is not a problem. This result can usually be" +
                                " ignored. ");
                    }
                    else if (dataModel.getValue() > 3) {
                        dataModel.setRange(3);
                        dataModel.setAnalysis("Your eosinophil percentage is high. High eosinophil counts usually represent a problem" +
                                " with allergies. ");
                    } else {
                        dataModel.setRange(2);
                        dataModel.setAnalysis("You have the correct amount of eosinophils.");
                    }
                    break;
                case "BASO %":
                    if (dataModel.getValue() < 0){
                        dataModel.setRange(1);
                        dataModel.setAnalysis("BASO % Test Low");
                    }
                    else if (dataModel.getValue() > 2) {
                        dataModel.setRange(3);

                        dataModel.setAnalysis("BASO % Test High");
                    }
                    else {
                        dataModel.setRange(2);
                        dataModel.setAnalysis("BASO % Test Average");
                    }
                    break;
                case "NEUT,ABS":
                    if (dataModel.getValue() < 2.3){
                        dataModel.setRange(1);
                        dataModel.setAnalysis("The absolute amount of neutrophils in your blood is very low. This could mean that you have" +
                                " a lessened ability to fight off disease, were it to occur. Having fewer neutrophils can be indicitive" +
                                "of serious immune system difficulties. Consult your doctor straight away. ");
                    }
                    else if (dataModel.getValue() > 8.1) {
                        dataModel.setRange(3);
                        dataModel.setAnalysis("The absolute amount of neutrophils in your body is very high. This could mean that you are " +
                                "currently fighting a disease. Neutrophil percentages go up when your body is in the middle of helping you" +
                                " heal from sickness. It could also indicate leukemia. Do not panic. Consult your doctor before making any " +
                                "decisions.");
                    }
                    else {
                        dataModel.setRange(2);
                        dataModel.setAnalysis("You seem to have the right amount of neutrophils. This means that you are a healthy individual. " +
                                "with no immune system problems. ");
                    }
                    break;
                case "LYMPH,ABS":
                    if (dataModel.getValue() < 0.8){
                        dataModel.setRange(1);
                        dataModel.setAnalysis("Your lymphocyte count is low. Lymphocytes counts are not usually low. This is an issue" +
                                "that only your doctor can solve. The cause could be a great many things including malnutrition and HIV.");
                    }
                    else if (dataModel.getValue() > 4.8) {
                        dataModel.setRange(3);
                        dataModel.setAnalysis("Your lymphocyte count is high. High lymphocyte counts usually indicate that the body " +
                                "is fighting some sort of infection, likely viral. High lymphocyte counts are also sometimes attributed to " +
                                "certain types of leukemia, but please consult your doctor before making any decisions.");
                    }
                    else {
                        dataModel.setRange(2);
                        dataModel.setAnalysis("You seem to have the lymphocyte count that a healthy person would have. ");
                    }
                    break;
                case "MONO,ABS":
                    if (dataModel.getValue() < 0.45){
                        dataModel.setRange(1);
                        dataModel.setAnalysis("MONO,ABS Test Low");
                    }
                    else if (dataModel.getValue() > 1.3) {
                        dataModel.setRange(3);
                        dataModel.setAnalysis("MONO,ABS Test High");
                    }
                    else {
                        dataModel.setRange(2);
                        dataModel.setAnalysis("MONO,ABS Test Average");
                    }
                    break;
                case "EOS,ABS":
                    if (dataModel.getValue() < 0){
                        dataModel.setRange(1);
                        dataModel.setAnalysis("EOS,ABS Test Low");
                    }
                    else if (dataModel.getValue() > 0.4) {
                        dataModel.setRange(3);
                        dataModel.setAnalysis("EOS,ABS Test High");
                    } else {
                        dataModel.setRange(2);
                        dataModel.setAnalysis("EOS,ABS Test Average");
                    }
                    break;
                case "BASO,ABS":
                    if (dataModel.getValue() < 0){
                        dataModel.setRange(1);
                        dataModel.setAnalysis("BASO,ABS Test Low");
                    }
                    else if (dataModel.getValue() > 0.1) {
                        dataModel.setRange(3);

                        dataModel.setAnalysis("BASO,ABS Test High");
                    } else {
                        dataModel.setRange(2);
                        dataModel.setAnalysis("BASO,ABS Test Average");
                    }
                    break;
                default:
                    throw new RuntimeException("unreachable");
            }
        }
    }

}