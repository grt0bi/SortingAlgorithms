package com.example.sortingalgorithms;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.chart.LineChart;
import javafx.scene.control.*;

import java.util.Arrays;

public class Controller {

    @FXML
    private Button btnBenchmark;

    @FXML
    private Button btnGenerate;

    @FXML
    private Button btnSort;

    @FXML
    private Label lblErgebnis;

    @FXML
    private RadioButton optBubbleSort;

    @FXML
    private RadioButton optInsertionSort;

    @FXML
    private RadioButton optMergeSort;

    @FXML
    private RadioButton optQuickSort;

    @FXML
    private RadioButton optSelectionSort;

    @FXML
    private RadioButton optSort;

    @FXML
    private ToggleGroup tgSortierverfahren;

    @FXML
    private TextField txtRandom;

    @FXML
    private TextField txtTries;

    @FXML
    private TextField txtUpperLimit;

    @FXML
    void actBenchmark(ActionEvent event) {

    }

    long[] randomNumbers;
    boolean sorted;

    @FXML
    void actGenerate(ActionEvent event) {
         randomNumbers = SortingAlgorithms.GenerateRandomNumbers(Integer.parseInt(txtRandom.getText()), Integer.parseInt(txtUpperLimit.getText()));
         sorted = false;
    }

    private long zeitmessung(){
        long start = 0;
        long end = 0;
        if(optBubbleSort.isSelected()){
            start = System.currentTimeMillis();
            SortingAlgorithms.bubbleSort(randomNumbers);
            end = System.currentTimeMillis();
        }
        else if(optInsertionSort.isSelected()){
            start = System.currentTimeMillis();
            SortingAlgorithms.insertionSort(randomNumbers);
            end = System.currentTimeMillis();
        }
        else if(optMergeSort.isSelected()){
            start = System.currentTimeMillis();
            SortingAlgorithms.mergeSort(randomNumbers);
            end = System.currentTimeMillis();
        }
        else if(optQuickSort.isSelected()){
            start = System.currentTimeMillis();
            SortingAlgorithms.quickSort(randomNumbers);
            end = System.currentTimeMillis();
        }
        else if(optSelectionSort.isSelected()){
            start = System.currentTimeMillis();
            SortingAlgorithms.selectionSort(randomNumbers);
            end = System.currentTimeMillis();
        }
        else{
            lblErgebnis.setText("Bitte wählen Sie ein Sortierverfahren aus.");
        }

        return end-start;
    }

    @FXML
    void actSort(ActionEvent event) {
        if (randomNumbers == null) {
            lblErgebnis.setText("Bitte zuerst Zahlen generieren.");
            return;
        }

        if (sorted) {
            lblErgebnis.setText("Die Zahlen sind bereits sortiert.");
            return;
        }

        long time = zeitmessung();

        if (SortingAlgorithms.IsSorted(randomNumbers)) {
            lblErgebnis.setText("SorterDauer: " + time + "ms für " + randomNumbers.length + " Elemente");
        } else {
            lblErgebnis.setText("Die Zahlen sind nicht sortiert.");
        }
    }


}
