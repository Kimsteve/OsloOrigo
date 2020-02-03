/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.osloorigobikes;

/**
 *
 * @author stephenkimogol
 */
import com.google.gson.Gson;
import java.io.File;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringReader;
import java.util.logging.Level;
import java.util.logging.Logger;
import com.google.gson.stream.JsonReader;

/**
 *
 * @author stephenkimogol
 */
public class OsloOrigo {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException {
        String request1 = "curl -H \"Kimogol-OsloOrigoBikes: IDENTIFIER\" https://gbfs.urbansharing.com/oslobysykkel.no/station_information.json";
        String request2 = "curl -H \"Kimogol-OsloOrigoBikes: IDENTIFIER\" https://gbfs.urbansharing.com/oslobysykkel.no/station_status.json";
        String stationInfo = processBuild(request1);
        String stationStatus = processBuild(request2);

        //Station Information
        Gson gson = new Gson();
        JsonReader jsonReader = new JsonReader(new StringReader(stationInfo));
        jsonReader.setLenient(true);
        StationInformation stationInfoGson = gson.fromJson(jsonReader, StationInformation.class);

        //Station Status
        Gson gson2 = new Gson();
        JsonReader jsonReader2 = new JsonReader(new StringReader(stationStatus));
        jsonReader.setLenient(true);
        StationStatus stationStatusGson = gson2.fromJson(jsonReader2, StationStatus.class);

        System.out.println("Station name\tnumber of bikes available\tnumber of docks available");

        for (int i = 0; i < stationInfoGson.data.stations.size(); i++) {
            for (int n = 0; n < stationStatusGson.data.stations.size(); n++) {
                if (stationInfoGson.data.stations.get(i).getStation_id().equals(stationStatusGson.data.stations.get(n).getStation_id())) {

                    String statioName = stationInfoGson.data.stations.get(i).getName();
                    int num_bikes_available = stationStatusGson.data.stations.get(n).getNum_bikes_available();
                    int num_docks_available = stationStatusGson.data.stations.get(n).getNum_docks_available();

                    System.out.println(statioName + "\t" + num_bikes_available + "\t" + num_docks_available);

                }

            }
        }

    }

    public static String processBuild(String command) throws IOException {
        String incomingData = null;
        ProcessBuilder processBuilder = new ProcessBuilder(command.split(" "));
        processBuilder.directory(new File("/home/"));
        Process process = processBuilder.start();
        InputStream inputStream = process.getInputStream();

        // Consume the inputStream so the process can exit
        incomingData = consumeInputStream(inputStream);
        try {
            process.waitFor();
        } catch (InterruptedException ex) {
            Logger.getLogger(OsloOrigo.class.getName()).log(Level.SEVERE, null, ex);
        }
        int exitCode = process.exitValue();

        return incomingData;
    }

    public static String inputStreamToString(InputStream inputStream) {
        final int bufferSize = 8 * 1024;
        byte[] buffer = new byte[bufferSize];
        final StringBuilder builder = new StringBuilder();
        try (BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream, bufferSize)) {
            while (bufferedInputStream.read(buffer) != -1) {
                builder.append(new String(buffer));
            }
        } catch (IOException ex) {
            Logger.getLogger(OsloOrigo.class.getName()).log(Level.SEVERE, null, ex);
        }
        return builder.toString();
    }

    public static String consumeInputStream(InputStream inputStream) {
        String incomingData;
        incomingData = inputStreamToString(inputStream).trim();
        return incomingData;

    }

}
