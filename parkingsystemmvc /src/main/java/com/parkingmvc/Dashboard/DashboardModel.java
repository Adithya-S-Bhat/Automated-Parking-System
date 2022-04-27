package com.parkingmvc.Dashboard;

public class DashboardModel {
    

    private String parkingLotSelected;

    public DashboardModel(String parkingLotSelected) {
        this.parkingLotSelected = parkingLotSelected;
    }

    public String getParkingLotSelected() {
        return parkingLotSelected;
    }
    
    public void setParkingLotSelected(String parkingLotSelected) {
        this.parkingLotSelected = parkingLotSelected;
    }

}
