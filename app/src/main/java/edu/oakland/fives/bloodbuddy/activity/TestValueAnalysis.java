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
                    if (dataModel.getValue() < 11.5){
                        dataModel.setRange(1);
                        dataModel.setAnalysis("White Blood Cell Test");
                    }
                    else if (dataModel.getValue() > 14.5) {
                        dataModel.setRange(3);
                        dataModel.setAnalysis("White Blood Cell Test");
                    } else {
                        dataModel.setRange(2);
                        dataModel.setAnalysis("White Blood Cell Test");
                    }
                    break;
                case "RBC":
                    if (dataModel.getValue() < 4.6) {
                        dataModel.setRange(1);
                        dataModel.setAnalysis("Red Blood Cell Test");
                    }
                    else if (dataModel.getValue() > 6.0) {
                        dataModel.setRange(3);
                        dataModel.setAnalysis("Red Blood Cell Test");
                    } else {
                        dataModel.setRange(2);
                        dataModel.setAnalysis("Red Blood Cell Test");
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
                case "MPV":
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
                case "NEUT %":
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
                case "LYMPH %":
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
                case "MONO %":
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
                case "EOS %":
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
                case "BASO %":
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
                case "NEUT,ABS":
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
                case "LYMPH,ABS":
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
                case "MONO,ABS":
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
                case "EOS,ABS":
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
                case "BASO,ABS":
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
                default:
                    throw new RuntimeException("unreachable");
            }
        }
    }

}