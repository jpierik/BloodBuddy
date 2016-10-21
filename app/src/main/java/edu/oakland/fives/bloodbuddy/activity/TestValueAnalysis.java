package edu.oakland.fives.bloodbuddy.activity;

import java.util.ArrayList;

import edu.oakland.fives.bloodbuddy.model.DataModel;

public class TestValueAnalysis {

    ArrayList<DataModel> tests;

    public TestValueAnalysis(ArrayList<DataModel> tests) {
        this.tests = tests;
    }

    public void analysis() {
        for (DataModel dataModel : this.tests) {
            switch (dataModel.getTestName()) {
                case "WBC":
                    break;
                case "RBC":
                    if (dataModel.getValue() < 4.6) {
                        dataModel.setRange(1);
                        dataModel.setAnalysis("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. ");
                    }
                    else if (dataModel.getValue() > 6.0) {
                        dataModel.setRange(3);
                        dataModel.setAnalysis("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. ");
                    } else {
                        dataModel.setRange(2);
                        dataModel.setAnalysis("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. ");
                    }
                    break;
                case "HGB":
                    if (dataModel.getValue() < 13){
                        dataModel.setRange(1);
                        dataModel.setAnalysis("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. ");
                    }
                    else if (dataModel.getValue() > 16.5) {
                        dataModel.setRange(3);
                        dataModel.setAnalysis("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. ");
                    } else {
                        dataModel.setRange(2);
                        dataModel.setAnalysis("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. ");
                    }
                    break;
                case "HCT":
                    if (dataModel.getValue() < 37.5){
                        dataModel.setRange(1);
                        dataModel.setAnalysis("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. ");
                    }
                    else if (dataModel.getValue() > 52) {
                        dataModel.setRange(3);
                        dataModel.setAnalysis("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. ");
                    } else {
                        dataModel.setRange(2);
                        dataModel.setAnalysis("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. ");
                    }
                    break;
                case "MCV":
                    if (dataModel.getValue() < 80){
                        dataModel.setRange(1);
                        dataModel.setAnalysis("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. ");
                    }
                    else if (dataModel.getValue() > 100) {
                        dataModel.setRange(3);
                        dataModel.setAnalysis("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. ");
                    } else {
                        dataModel.setRange(2);
                        dataModel.setAnalysis("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. ");
                    }
                    break;
                case "MCH":
                    if (dataModel.getValue() < 26){
                        dataModel.setRange(1);
                        dataModel.setAnalysis("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. ");
                    }
                    else if (dataModel.getValue() > 32) {
                        dataModel.setRange(3);
                        dataModel.setAnalysis("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. ");
                    } else {
                        dataModel.setRange(2);
                        dataModel.setAnalysis("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. ");
                    }
                    break;
                case "MCHC":
                    if (dataModel.getValue() < 32){
                        dataModel.setRange(1);
                        dataModel.setAnalysis("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. ");
                    }
                    else if (dataModel.getValue() > 36) {
                        dataModel.setRange(3);
                        dataModel.setAnalysis("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. ");
                    } else {
                        dataModel.setRange(2);
                        dataModel.setAnalysis("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. ");
                    }
                    break;
                case "RDW":
                    if (dataModel.getValue() < 11.5){
                        dataModel.setRange(1);
                        dataModel.setAnalysis("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. ");
                    }
                    else if (dataModel.getValue() > 14.5) {
                        dataModel.setRange(3);
                        dataModel.setAnalysis("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. ");
                    } else {
                        dataModel.setRange(2);
                        dataModel.setAnalysis("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. ");
                    }
                    break;
                case "PLT":
                    break;
                case "MPV":
                    break;
                case "NEUT %":
                    break;
                case "LYMPH %":
                    break;
                case "MONO %":
                    break;
                case "EOS %":
                    break;
                case "BASO %":
                    break;
                case "NEUT,ABS":
                    break;
                case "LYMPH,ABS":
                    break;
                case "MONO,ABS":
                    break;
                case "EOS,ABS":
                    break;
                case "BASO,ABS":
                    break;
                default:
                    throw new RuntimeException("unreachable");
            }
        }
    }

}