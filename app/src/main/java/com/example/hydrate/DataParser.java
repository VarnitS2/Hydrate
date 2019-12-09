package com.example.hydrate;

import android.content.res.AssetManager;

import java.io.InputStream;
import java.io.InputStreamReader;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SuppressWarnings({"WeakerAccess", "SpellCheckingInspection"})
public class DataParser {

    /** Map of building names to their ratings. */
    private static Map<String, Double> ratings = new HashMap<>();

    public static Map<String, Double> getRatings(AssetManager assets) {
        try {
            InputStream inputStream = assets.open("Data/Data.csv");
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);

            List<Character> data = new ArrayList<>();
            while (true) {
                int charAscii = inputStreamReader.read();

                if (charAscii == -1) {
                    break;
                }
                data.add((char) charAscii);
            }

            StringBuilder stringBuilder = new StringBuilder();
            for (Character c : data) {
                stringBuilder.append(c);
            }
            String dataString = stringBuilder.toString();

            String[] row = dataString.split("\n");

            ArrayList<String[]> metaList = new ArrayList<>();

            for (int i = 0; i < row.length; i++) {
                String[] column = row[i].split(",");
                metaList.add(column);
            }

            for (int i = 1; i < metaList.get(0).length; i++) {
                double rating = 0;
                int counter = 0;

                for (int j = 1; j < metaList.size(); j++) {
                    int temp = Integer.parseInt(metaList.get(j)[i].trim());
                    if (temp != -1) {
                        rating += temp;
                        counter++;
                    }
                }

                rating /= counter;

                ratings.put(metaList.get(0)[i], rating);
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }

        return ratings;
    }
}
