package com.example.hydrate;

import android.content.res.AssetManager;
import android.os.Environment;

import com.opencsv.CSVReader;

import java.io.File;
import java.io.IOException;
import java.io.FileReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.List;

@SuppressWarnings({"WeakerAccess", "SpellCheckingInspection"})
public class DataParser {

//    /** Reader for csv files. */
//    private CSVReader reader;

//    /** Data file name. */
//    private String csvfile;

    /** Data list parsed from the csv. */
    private static List data;

    public static List getRatingData(AssetManager assets) {
        try {
//            String csvFileString = applicationInfo + File.separatorChar + "Data.csv";
//            //System.out.println("HERE YOU BIT: " + csvFileString);
//            File csvfile = new File(csvFileString);
//            CSVReader reader = new CSVReader(new FileReader(applicationInfo));
//            data = reader.readAll();

            InputStream inputStream = assets.open("Data/Data.csv");
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            System.out.println((char) inputStreamReader.read());
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        return data;
    }
}
