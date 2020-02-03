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
public class StationStatus {

    String last_updated;
    int ttl;
    StationStatusData data;

    StationStatus(String last_updated, int ttl, StationStatusData data) {
        this.last_updated = last_updated;
        this.ttl = ttl;
        this.data = data;
    }

    public String getLast_updated() {
        return last_updated;
    }

    class StationStatusData {

        List<DockInfo> stations;

        StationStatusData(List<DockInfo> stations) {
            this.stations = stations;
        }
    }

    class DockInfo {

        int is_installed;
        int is_renting;
        int num_bikes_available;
        int num_docks_available;
        int last_reported;
        int is_returning;
        String station_id;

        DockInfo(int is_installed, int is_renting,
                int num_bikes_available, int num_docks_available,
                int last_reported, int is_returning, String station_id
        ) {
            this.is_installed = is_installed;
            this.is_renting = is_renting;
            this.num_bikes_available = num_bikes_available;
            this.num_docks_available = num_docks_available;
            this.last_reported = last_reported;
            this.is_returning = is_returning;
            this.station_id = station_id;
        }

        /**
         * @return the is_installed
         */
        public int getIs_installed() {
            return is_installed;
        }

        /**
         * @return the is_renting
         */
        public int getIs_renting() {
            return is_renting;
        }

        /**
         * @return the num_bikes_available
         */
        public int getNum_bikes_available() {
            return num_bikes_available;
        }

        /**
         * @return the num_docks_available
         */
        public int getNum_docks_available() {
            return num_docks_available;
        }

        /**
         * @return the last_reported
         */
        public int getLast_reported() {
            return last_reported;
        }

        /**
         * @return the is_returning
         */
        public int getIs_returning() {
            return is_returning;
        }

        /**
         * @return the station_id
         */
        public String getStation_id() {
            return station_id;
        }

    }

}
