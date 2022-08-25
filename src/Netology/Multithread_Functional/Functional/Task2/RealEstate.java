package Netology.Multithread_Functional.Functional.Task2;

public class RealEstate {
    final private String address;
    final private double width;
    final private double length;
    final private double cost;

    public RealEstate(String address, double width, double length, double cost) {
        this.address = address;
        this.width = width;
        this.length = length;
        this.cost = cost;
    }

    public double getCostPerMeter() {
        return cost / width / length;
    }

    @Override
    public String toString() {
        return String.format("Объект по адресу %s Площадь %5.1f кв.м. Стоимость 1кв.м.%10.2f руб.", address, width * length, getCostPerMeter());
    }

    @Override
    public int hashCode() {
        return address.hashCode();
    }
}
