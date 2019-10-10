package only.luzejin.ExcelUtil.domain;


import cn.afterturn.easypoi.excel.annotation.Excel;

/**
 * 包名称only.luzejin.ExcelUtil
 * 类名称HouseSource
 * 类描述 房源信息
 * 创建人luzejin
 * 创建时间2019/8/4 21:46
 **/
public class HouseSource {

    //房源上架时间	 页面网址	靠近地铁线	租赁方式	wgs84经纬度	gcj02经纬度


    @Excel(name="房源名称")
    private String houseName;

    @Excel(name="房源出租价格")
    private String housePrice;

    @Excel(name="房源优势")
    private String houseAdvantage;

    @Excel(name="房源户型")
    private String houseLayout;

    @Excel(name="房源面积")
    private String houseArea;

    @Excel(name="房源朝向")
    private String houseOrientated;

    @Excel(name="经度")
    private String longitude;

    @Excel(name="纬度")
    private String latitude;

    @Excel(name="发布时间")
    private String publishTime;

    @Excel(name="入住要求")
    private String liveRequire;

    @Excel(name="租期")
    private String leaseTerm;

    @Excel(name="看房要求")
    private String showRequire;

    @Excel(name="楼层")
    private String floor;

    @Excel(name="电梯")
    private String elevator;

    @Excel(name="车位")
    private String parking;

    @Excel(name="用水")
    private String water;

    @Excel(name="用电")
    private String electric;

    @Excel(name="燃气")
    private String gas;

    @Excel(name="最近地铁距离")
    private String nearestMetroDistance;

    @Excel(name="最近地铁站")
    private String nearestMetroStation;

    @Excel(name="第一区域")
    private String firstArea;

    @Excel(name="第二区域")
    private String secondArea;

    @Excel(name="小区名")
    private String communitName;

    @Excel(name="房源描述")
    private String houseDescription;

    @Excel(name="房屋编号")
    private String houseNum;

    @Excel(name="房源上架时间")
    private String shelfTime;

    @Excel(name="页面网址")
    private String pageAddress;

    @Excel(name="靠近地铁线")
    private String nearMetroLine;

    @Excel(name="租赁方式")
    private String leasingMode;

    @Excel(name="wgs84经纬度")
    private String wgs84Location;

    @Excel(name="gcj02经纬度")
    private String gcj02Location;

    public String getHouseName() {
        return houseName;
    }

    public void setHouseName(String houseName) {
        this.houseName = houseName;
    }

    public String getHousePrice() {
        return housePrice;
    }

    public void setHousePrice(String housePrice) {
        this.housePrice = housePrice;
    }

    public String getHouseAdvantage() {
        return houseAdvantage;
    }

    public void setHouseAdvantage(String houseAdvantage) {
        this.houseAdvantage = houseAdvantage;
    }

    public String getHouseLayout() {
        return houseLayout;
    }

    public void setHouseLayout(String houseLayout) {
        this.houseLayout = houseLayout;
    }

    public String getHouseArea() {
        return houseArea;
    }

    public void setHouseArea(String houseArea) {
        this.houseArea = houseArea;
    }

    public String getHouseOrientated() {
        return houseOrientated;
    }

    public void setHouseOrientated(String houseOrientated) {
        this.houseOrientated = houseOrientated;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getPublishTime() {
        return publishTime;
    }

    public void setPublishTime(String publishTime) {
        this.publishTime = publishTime;
    }

    public String getLiveRequire() {
        return liveRequire;
    }

    public void setLiveRequire(String liveRequire) {
        this.liveRequire = liveRequire;
    }

    public String getLeaseTerm() {
        return leaseTerm;
    }

    public void setLeaseTerm(String leaseTerm) {
        this.leaseTerm = leaseTerm;
    }

    public String getShowRequire() {
        return showRequire;
    }

    public void setShowRequire(String showRequire) {
        this.showRequire = showRequire;
    }

    public String getFloor() {
        return floor;
    }

    public void setFloor(String floor) {
        this.floor = floor;
    }

    public String getElevator() {
        return elevator;
    }

    public void setElevator(String elevator) {
        this.elevator = elevator;
    }

    public String getParking() {
        return parking;
    }

    public void setParking(String parking) {
        this.parking = parking;
    }

    public String getWater() {
        return water;
    }

    public void setWater(String water) {
        this.water = water;
    }

    public String getElectric() {
        return electric;
    }

    public void setElectric(String electric) {
        this.electric = electric;
    }

    public String getGas() {
        return gas;
    }

    public void setGas(String gas) {
        this.gas = gas;
    }

    public String getNearestMetroDistance() {
        return nearestMetroDistance;
    }

    public void setNearestMetroDistance(String nearestMetroDistance) {
        this.nearestMetroDistance = nearestMetroDistance;
    }

    public String getNearestMetroStation() {
        return nearestMetroStation;
    }

    public void setNearestMetroStation(String nearestMetroStation) {
        this.nearestMetroStation = nearestMetroStation;
    }

    public String getFirstArea() {
        return firstArea;
    }

    public void setFirstArea(String firstArea) {
        this.firstArea = firstArea;
    }

    public String getSecondArea() {
        return secondArea;
    }

    public void setSecondArea(String secondArea) {
        this.secondArea = secondArea;
    }

    public String getCommunitName() {
        return communitName;
    }

    public void setCommunitName(String communitName) {
        this.communitName = communitName;
    }

    public String getHouseDescription() {
        return houseDescription;
    }

    public void setHouseDescription(String houseDescription) {
        this.houseDescription = houseDescription;
    }

    public String getHouseNum() {
        return houseNum;
    }

    public void setHouseNum(String houseNum) {
        this.houseNum = houseNum;
    }

    public String getShelfTime() {
        return shelfTime;
    }

    public void setShelfTime(String shelfTime) {
        this.shelfTime = shelfTime;
    }

    public String getPageAddress() {
        return pageAddress;
    }

    public void setPageAddress(String pageAddress) {
        this.pageAddress = pageAddress;
    }

    public String getNearMetroLine() {
        return nearMetroLine;
    }

    public void setNearMetroLine(String nearMetroLine) {
        this.nearMetroLine = nearMetroLine;
    }

    public String getLeasingMode() {
        return leasingMode;
    }

    public void setLeasingMode(String leasingMode) {
        this.leasingMode = leasingMode;
    }

    public String getWgs84Location() {
        return wgs84Location;
    }

    public void setWgs84Location(String wgs84Location) {
        this.wgs84Location = wgs84Location;
    }

    public String getGcj02Location() {
        return gcj02Location;
    }

    public void setGcj02Location(String gcj02Location) {
        this.gcj02Location = gcj02Location;
    }

    @Override
    public String toString() {
        return "HouseSource{" +
                "houseName='" + houseName + '\'' +
                ", housePrice='" + housePrice + '\'' +
                ", houseAdvantage='" + houseAdvantage + '\'' +
                ", houseLayout='" + houseLayout + '\'' +
                ", houseArea='" + houseArea + '\'' +
                ", houseOrientated='" + houseOrientated + '\'' +
                ", longitude='" + longitude + '\'' +
                ", latitude='" + latitude + '\'' +
                ", publishTime='" + publishTime + '\'' +
                ", liveRequire='" + liveRequire + '\'' +
                ", leaseTerm='" + leaseTerm + '\'' +
                ", showRequire='" + showRequire + '\'' +
                ", floor='" + floor + '\'' +
                ", elevator='" + elevator + '\'' +
                ", parking='" + parking + '\'' +
                ", water='" + water + '\'' +
                ", electric='" + electric + '\'' +
                ", gas='" + gas + '\'' +
                ", nearestMetroDistance='" + nearestMetroDistance + '\'' +
                ", nearestMetroStation='" + nearestMetroStation + '\'' +
                ", firstArea='" + firstArea + '\'' +
                ", secondArea='" + secondArea + '\'' +
                ", communitName='" + communitName + '\'' +
                ", houseDescription='" + houseDescription + '\'' +
                ", houseNum='" + houseNum + '\'' +
                ", shelfTime='" + shelfTime + '\'' +
                ", pageAddress='" + pageAddress + '\'' +
                ", nearMetroLine='" + nearMetroLine + '\'' +
                ", leasingMode='" + leasingMode + '\'' +
                ", wgs84Location='" + wgs84Location + '\'' +
                ", gcj02Location='" + gcj02Location + '\'' +
                '}';
    }
}
