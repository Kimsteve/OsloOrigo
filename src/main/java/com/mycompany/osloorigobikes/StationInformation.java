/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.osloorigobikes;

import java.util.List;


/**
 *
 * @author stephenkimogol
 */

public class StationInformation {

    String last_updated;
    int ttl;
    StationInformationData data;

    StationInformation(String last_updated, int ttl, StationInformationData data) {
        this.last_updated = last_updated;
        this.ttl = ttl;
        this.data = data;
    }

    public String getLast_updated() {
        return last_updated;
    }

    class StationInformationData {

        List<StationInfo> stations;

        StationInformationData(List<StationInfo> stations) {
            this.stations = stations;
        }
    }

    public class StationInfo {

        String station_id;
        String name;
        String address;
        Double lat;
        Double lon;
        int capacity;

        StationInfo(String station_id, String name,
                String address, Double lat,
                Double lon, int capacity
        ) {
            this.station_id = station_id;
            this.name = name;
            this.address = address;
            this.lat = lat;
            this.lon = lon;
            this.capacity = capacity;

        }

        /**
         * @return the station_id
         */
        public String getStation_id() {
            return station_id;
        }

        /**
         * @return the name
         */
        public String getName() {
            return name;
        }

        /**
         * @return the address
         */
        public String getAddress() {
            return address;
        }

        /**
         * @return the lat
         */
        public Double getLat() {
            return lat;
        }

        /**
         * @return the lon
         */
        public Double getLon() {
            return lon;
        }

        /**
         * @return the capacity
         */
        public int getCapacity() {
            return capacity;
        }

    }

}
