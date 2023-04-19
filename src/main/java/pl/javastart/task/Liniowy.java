package pl.javastart.task;

public class Liniowy extends FormaOpodatkowania {
    @Override
    public double wyliczPodatek(double przychody, double wydatki) {
        double dochod = przychody - wydatki;
        return dochod * 0.19;
    }

    @Override
    public String drukFormaOpodatkowania() {
        return "Liniowa";
    }
}
