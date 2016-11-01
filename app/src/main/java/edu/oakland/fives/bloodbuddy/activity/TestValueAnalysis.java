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
                        dataModel.setRange(1);
                        dataModel.setAnalysis("White Blood Cell Test High");
                    } else {
                        dataModel.setRange(3);
                        dataModel.setAnalysis("White Blood Cell Test Average");
                    }
                    break;
                case "RBC":
                    if (dataModel.getValue() < 4.6) {
                        dataModel.setRange(1);
                        dataModel.setAnalysis("Red Blood Cell Test Low ");
                    }
                    else if (dataModel.getValue() > 6.0) {
                        dataModel.setRange(1);
                        dataModel.setAnalysis("Red Blood Cell Test High");
                    } else {
                        dataModel.setRange(3);
                        dataModel.setAnalysis("Red Blood Cell Test Average");
                    }
                    break;
                case "HGB":
                    if (dataModel.getValue() < 13){
                        dataModel.setRange(1);
                        dataModel.setAnalysis("HGB Test Low");
                    }
                    else if (dataModel.getValue() > 16.5) {
                        dataModel.setRange(1);
                        dataModel.setAnalysis("HGB Test High");
                    } else {
                        dataModel.setRange(3);
                        dataModel.setAnalysis("HGB Test Average");
                    }
                    break;
                case "HCT":
                    if (dataModel.getValue() < 37.5){
                        dataModel.setRange(1);
                        dataModel.setAnalysis("HCT Test Low");
                    }
                    else if (dataModel.getValue() > 52) {
                        dataModel.setRange(1);
                        dataModel.setAnalysis("HCT Test High");
                    } else {
                        dataModel.setRange(3);
                        dataModel.setAnalysis("HCT Test Average");
                    }
                    break;
                case "MCV":
                    if (dataModel.getValue() < 80){
                        dataModel.setRange(1);
                        dataModel.setAnalysis("MCV Test Low");
                    }
                    else if (dataModel.getValue() > 100) {
                        dataModel.setRange(1);
                        dataModel.setAnalysis("MCV Test High");
                    } else {
                        dataModel.setRange(3);
                        dataModel.setAnalysis("MCV Test Average");
                    }
                    break;
                case "MCH":
                    if (dataModel.getValue() < 26){
                        dataModel.setRange(1);
                        dataModel.setAnalysis("MCH Test Low");
                    }
                    else if (dataModel.getValue() > 32) {
                        dataModel.setRange(1);
                        dataModel.setAnalysis("MCH Test High");
                    } else {
                        dataModel.setRange(3);
                        dataModel.setAnalysis("MCH Test Average");
                    }
                    break;
                case "MCHC":
                    if (dataModel.getValue() < 32){
                        dataModel.setRange(1);
                        dataModel.setAnalysis("MCHC Test Low");
                    }
                    else if (dataModel.getValue() > 36) {
                        dataModel.setRange(1);
                        dataModel.setAnalysis("MCHC Test High");
                    } else {
                        dataModel.setRange(3);
                        dataModel.setAnalysis("MCHC Test Average");
                    }
                    break;
                case "RDW":
                    if (dataModel.getValue() < 11.5){
                        dataModel.setRange(1);
                        dataModel.setAnalysis("RDW Test Low");
                    }
                    else if (dataModel.getValue() > 14.5) {
                        dataModel.setRange(1);
                        dataModel.setAnalysis("RDW Test High");
                    } else {
                        dataModel.setRange(3);
                        dataModel.setAnalysis("RDW Test Average");
                    }
                    break;
                case "PLT":
                    if (dataModel.getValue() < 11.5){
                        dataModel.setRange(1);
                        dataModel.setAnalysis("PLT Test Low");
                    }
                    else if (dataModel.getValue() > 14.5) {
                        dataModel.setRange(1);
                        dataModel.setAnalysis("PLT Test High");
                    } else {
                        dataModel.setRange(3);
                        dataModel.setAnalysis("PLT Test Average");
                    }
                    break;
                case "MPV":
                    if (dataModel.getValue() < 11.5){
                        dataModel.setRange(1);
                        dataModel.setAnalysis("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. ");
                    }
                    else if (dataModel.getValue() > 14.5) {
                        dataModel.setRange(1);
                        dataModel.setAnalysis("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. ");
                    } else {
                        dataModel.setRange(3);
                        dataModel.setAnalysis("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. ");
                    }
                    break;
                case "NEUT %":
                    if (dataModel.getValue() < 11.5){
                        dataModel.setRange(1);
                        dataModel.setAnalysis("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. ");
                    }
                    else if (dataModel.getValue() > 14.5) {
                        dataModel.setRange(1);
                        dataModel.setAnalysis("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. ");
                    } else {
                        dataModel.setRange(3);
                        dataModel.setAnalysis("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. ");
                    }
                    break;
                case "LYMPH %":
                    if (dataModel.getValue() < 11.5){
                        dataModel.setRange(1);
                        dataModel.setAnalysis("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. ");
                    }
                    else if (dataModel.getValue() > 14.5) {
                        dataModel.setRange(1);
                        dataModel.setAnalysis("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. ");
                    } else {
                        dataModel.setRange(3);
                        dataModel.setAnalysis("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. ");
                    }
                    break;
                case "MONO %":
                    if (dataModel.getValue() < 11.5){
                        dataModel.setRange(1);
                        dataModel.setAnalysis("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. ");
                    }
                    else if (dataModel.getValue() > 14.5) {
                        dataModel.setRange(1);
                        dataModel.setAnalysis("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. ");
                    } else {
                        dataModel.setRange(3);
                        dataModel.setAnalysis("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. ");
                    }
                    break;
                case "EOS %":
                    if (dataModel.getValue() < 11.5){
                        dataModel.setRange(1);
                        dataModel.setAnalysis("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. ");
                    }
                    else if (dataModel.getValue() > 14.5) {
                        dataModel.setRange(1);
                        dataModel.setAnalysis("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. ");
                    } else {
                        dataModel.setRange(3);
                        dataModel.setAnalysis("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. ");
                    }
                    break;
                case "BASO %":
                    if (dataModel.getValue() < 11.5){
                        dataModel.setRange(1);
                        dataModel.setAnalysis("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. ");
                    }
                    else if (dataModel.getValue() > 14.5) {
                        dataModel.setRange(1);
                        dataModel.setAnalysis("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. ");
                    } else {
                        dataModel.setRange(3);
                        dataModel.setAnalysis("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. ");
                    }
                    break;
                case "NEUT,ABS":
                    if (dataModel.getValue() < 11.5){
                        dataModel.setRange(1);
                        dataModel.setAnalysis("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. ");
                    }
                    else if (dataModel.getValue() > 14.5) {
                        dataModel.setRange(1);
                        dataModel.setAnalysis("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. ");
                    } else {
                        dataModel.setRange(3);
                        dataModel.setAnalysis("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. ");
                    }
                    break;
                case "LYMPH,ABS":
                    if (dataModel.getValue() < 11.5){
                        dataModel.setRange(1);
                        dataModel.setAnalysis("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. ");
                    }
                    else if (dataModel.getValue() > 14.5) {
                        dataModel.setRange(1);
                        dataModel.setAnalysis("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. ");
                    } else {
                        dataModel.setRange(3);
                        dataModel.setAnalysis("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. ");
                    }
                    break;
                case "MONO,ABS":
                    if (dataModel.getValue() < 11.5){
                        dataModel.setRange(1);
                        dataModel.setAnalysis("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. ");
                    }
                    else if (dataModel.getValue() > 14.5) {
                        dataModel.setRange(1);
                        dataModel.setAnalysis("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. ");
                    } else {
                        dataModel.setRange(3);
                        dataModel.setAnalysis("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. ");
                    }
                    break;
                case "EOS,ABS":
                    if (dataModel.getValue() < 11.5){
                        dataModel.setRange(1);
                        dataModel.setAnalysis("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. ");
                    }
                    else if (dataModel.getValue() > 14.5) {
                        dataModel.setRange(1);
                        dataModel.setAnalysis("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. ");
                    } else {
                        dataModel.setRange(3);
                        dataModel.setAnalysis("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. ");
                    }
                    break;
                case "BASO,ABS":
                    if (dataModel.getValue() < 11.5){
                        dataModel.setRange(1);
                        dataModel.setAnalysis("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. ");
                    }
                    else if (dataModel.getValue() > 14.5) {
                        dataModel.setRange(1);
                        dataModel.setAnalysis("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. ");
                    } else {
                        dataModel.setRange(3);
                        dataModel.setAnalysis("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. ");
                    }
                    break;
                default:
                    throw new RuntimeException("unreachable");
            }
        }
    }

}