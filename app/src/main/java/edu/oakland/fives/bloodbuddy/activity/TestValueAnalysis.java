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
                        dataModel.setAnalysis("White Blood Cell Test Low");
                    }
                    else if (dataModel.getValue() > 14.5) {
                        dataModel.setRange(3);
                        dataModel.setAnalysis("White Blood Cell Test High");
                    } else {
                        dataModel.setRange(2);
                        dataModel.setAnalysis("White Blood Cell Test Average");
                    }
                    break;
                case "RBC":
                    //Male test values for RBC
                    if (gender.matches("Male") && dataModel.getValue() < 4.6) {
                        dataModel.setRange(1);
                        dataModel.setAnalysis("Red Blood Cell Test Low ");
                    }
                    else if (gender.matches("Male") &&dataModel.getValue() > 6.0) {
                        dataModel.setRange(3);
                        dataModel.setAnalysis("Red Blood Cell Test High");
                    }
                    else if (gender.matches("Male") && (dataModel.getValue() >= 4.6 && dataModel.getValue() <= 6.0)) {
                        dataModel.setRange(2);
                        dataModel.setAnalysis("Red Blood Cell Test Average");
                    }
                    //Female Test values for rbc
                    else if (gender.matches("Female") && dataModel.getValue() < 20) {
                        dataModel.setRange(1);
                        dataModel.setAnalysis("Red Blood Cell Test Low ");
                    }
                    else if (gender.matches("Female") &&dataModel.getValue() > 30) {
                        dataModel.setRange(3);
                        dataModel.setAnalysis("Red Blood Cell Test High");
                    }
                    else if (gender.matches("Female") && (dataModel.getValue() >= 20 || dataModel.getValue() <= 6.0)){
                        dataModel.setRange(2);
                        dataModel.setAnalysis("Red Blood Cell Test Average");
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
                        dataModel.setAnalysis("HGB Test High");
                    }
                    else if (gender.matches("Female") && (dataModel.getValue() >= 20 && dataModel.getValue() <= 6.0)){
                        dataModel.setRange(2);
                        dataModel.setAnalysis("HGB Test Average");
                    }
                    break;
                case "HCT":
                    //Male test values for hct
                    if (gender.matches("Male") && dataModel.getValue() < 37.5){
                        dataModel.setRange(1);
                        dataModel.setAnalysis("HCT Test Low");
                    }
                    else if (gender.matches("Male") && dataModel.getValue() > 52) {
                        dataModel.setRange(3);
                        dataModel.setAnalysis("HCT Test High");
                    } else if(gender.matches("Male") && (dataModel.getValue() >= 37.5 && dataModel.getValue() <= 52)){
                        dataModel.setRange(2);
                        dataModel.setAnalysis("HCT Test Average");
                    }
                    //Female Test values for hct
                    else if (gender.matches("Female") && dataModel.getValue() < 20) {
                        dataModel.setRange(1);
                        dataModel.setAnalysis("HCT Test Low ");
                    }
                    else if (gender.matches("Female") &&dataModel.getValue() > 30) {
                        dataModel.setRange(3);
                        dataModel.setAnalysis("HCT Test High");
                    }
                    else if (gender.matches("Female") && (dataModel.getValue() >= 20 && dataModel.getValue() <= 6.0)){
                        dataModel.setRange(2);
                        dataModel.setAnalysis("HCT Test Average");
                    }
                    break;
                case "MCV":
                    if (dataModel.getValue() < 80){
                        dataModel.setRange(1);
                        dataModel.setAnalysis("MCV Test Low");
                    }
                    else if (dataModel.getValue() > 100) {
                        dataModel.setRange(3);
                        dataModel.setAnalysis("MCV Test High");
                    } else {
                        dataModel.setRange(2);
                        dataModel.setAnalysis("MCV Test Average");
                    }
                    break;
                case "MCH":
                    if (dataModel.getValue() < 26){
                        dataModel.setRange(1);
                        dataModel.setAnalysis("MCH Test Low");
                    }
                    else if (dataModel.getValue() > 32) {
                        dataModel.setRange(3);
                        dataModel.setAnalysis("MCH Test High");
                    } else {
                        dataModel.setRange(2);
                        dataModel.setAnalysis("MCH Test Average");
                    }
                    break;
                case "MCHC":
                    if (dataModel.getValue() < 32){
                        dataModel.setRange(1);
                        dataModel.setAnalysis("MCHC Test Low");
                    }
                    else if (dataModel.getValue() > 36) {
                        dataModel.setRange(3);
                        dataModel.setAnalysis("MCHC Test High");
                    } else {
                        dataModel.setRange(2);
                        dataModel.setAnalysis("MCHC Test Average");
                    }
                    break;
                case "RDW":
                    if (dataModel.getValue() < 11.5){
                        dataModel.setRange(1);
                        dataModel.setAnalysis("RDW Test Low");
                    }
                    else if (dataModel.getValue() > 14.5) {
                        dataModel.setRange(3);
                        dataModel.setAnalysis("RDW Test High");
                    } else {
                        dataModel.setRange(2);
                        dataModel.setAnalysis("RDW Test Average");
                    }
                    break;
                case "PLT":
                    //Male test values for PLT
                    if (gender.matches("Male") && dataModel.getValue() < 150){
                        dataModel.setRange(1);
                        dataModel.setAnalysis("PLT Test Low");
                    }

                    else if (gender.matches("Male") && dataModel.getValue() > 450) {
                        dataModel.setRange(3);
                        dataModel.setAnalysis("PLT Test High");
                    }
                    else if (gender.matches("Male") && (dataModel.getValue() >= 20 && dataModel.getValue() <= 6.0)){
                        dataModel.setRange(2);
                        dataModel.setAnalysis("PLT Test Average");
                    }
                    //Female Test values for PLT
                    else if (gender.matches("Female") && dataModel.getValue() < 20) {
                        dataModel.setRange(1);
                        dataModel.setAnalysis("PLT Test Low ");
                    }
                    else if (gender.matches("Female") &&dataModel.getValue() > 30) {
                        dataModel.setRange(3);
                        dataModel.setAnalysis("PLT Test High");
                    }
                    else if (gender.matches("Female") && (dataModel.getValue() >= 20 && dataModel.getValue() <= 6.0)){
                        dataModel.setRange(2);
                        dataModel.setAnalysis("PLT Test Average");
                    }
                    break;
                case "MPV":
                    if (dataModel.getValue() < 6.8){
                        dataModel.setRange(1);
                        dataModel.setAnalysis("MPV Test Low ");
                    }
                    else if (dataModel.getValue() > 10.2) {
                        dataModel.setRange(3);
                        dataModel.setAnalysis("MPV Test High");
                    } else {
                        dataModel.setRange(2);
                        dataModel.setAnalysis("MPV Test Average");
                    }
                    break;
                case "NEUT %":
                    if (dataModel.getValue() < 50){
                        dataModel.setRange(1);
                        dataModel.setAnalysis("NEUT % Test Low");
                    }
                    else if (dataModel.getValue() > 70) {
                        dataModel.setRange(3);
                        dataModel.setAnalysis("NEUT % Test High");
                    } else {
                        dataModel.setRange(2);
                        dataModel.setAnalysis("NEUT % Test Average");
                    }
                    break;
                case "LYMPH %":
                    if (dataModel.getValue() < 18){
                        dataModel.setRange(1);
                        dataModel.setAnalysis("LYMPH % Test Low");
                    }
                    else if (dataModel.getValue() > 42) {
                        dataModel.setRange(3);

                        dataModel.setAnalysis("LYMPH % Test High ");
                    }
                    else {
                        dataModel.setRange(2);
                        dataModel.setAnalysis("LYMPH % Test Average");
                    }
                    break;
                case "MONO %":
                    if (dataModel.getValue() < 2){
                        dataModel.setRange(1);
                        dataModel.setAnalysis("MONO % Test Low ");
                    }
                    else if (dataModel.getValue() > 11) {
                        dataModel.setRange(3);
                        dataModel.setAnalysis("MONO % Test High");
                    }
                    else {
                        dataModel.setRange(2);
                        dataModel.setAnalysis("MONO % Test Average");
                    }
                    break;
                case "EOS %":
                    if (dataModel.getValue() < 1){
                        dataModel.setRange(1);
                        dataModel.setAnalysis("EOS % Test Low");
                    }
                    else if (dataModel.getValue() > 3) {
                        dataModel.setRange(3);
                        dataModel.setAnalysis("EOS % Test High");
                    } else {
                        dataModel.setRange(2);
                        dataModel.setAnalysis("EOS % Test Average");
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
                        dataModel.setAnalysis("NEUT,ABS Test Low");
                    }
                    else if (dataModel.getValue() > 8.1) {
                        dataModel.setRange(3);
                        dataModel.setAnalysis("NEUT,ABS Test High");
                    }
                    else {
                        dataModel.setRange(2);
                        dataModel.setAnalysis("NEUT,ABS Test Average");
                    }
                    break;
                case "LYMPH,ABS":
                    if (dataModel.getValue() < 0.8){
                        dataModel.setRange(1);
                        dataModel.setAnalysis("LYMPH,ABS Test Low");
                    }
                    else if (dataModel.getValue() > 4.8) {
                        dataModel.setRange(3);
                        dataModel.setAnalysis("LYMPH,ABS Test High");
                    }
                    else {
                        dataModel.setRange(2);
                        dataModel.setAnalysis("LYMPH,ABS Test Average");
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