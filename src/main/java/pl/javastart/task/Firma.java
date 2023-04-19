package pl.javastart.task;

public class Firma {

    private final String nazwa;
    private final FormaOpodatkowania formaOpodatkowania;
    private double wartosciPrzychodow = 0;
    private double wartosciWydatkow = 0;

    public Firma(String nazwa, FormaOpodatkowania formaOpodatkowania) {
        this.nazwa = nazwa;
        this.formaOpodatkowania = formaOpodatkowania;
    }

    public void wyswietlPodsumowanie() {
        double sumaPrzychodow = zsumujPrzychody();
        double sumaWydatkow = zsumujWydatki();

        System.out.printf("======= Firma: %s ===========\n", nazwa);
        System.out.printf("Forma opodatkowania: %s\n", formaOpodatkowania.drukFormaOpodatkowania());
        System.out.printf("Suma przychodów: %.2f zł\n", sumaPrzychodow);
        System.out.printf("Suma wydatków: %.2f zł\n", sumaWydatkow);
        System.out.printf("Podatek do zapłacenia: %.2f zł", formaOpodatkowania.wyliczPodatek(sumaPrzychodow, sumaWydatkow));
        System.out.print("\n\n");
    }

    private double zsumujWydatki() {
        return wartosciWydatkow;
    }

    private double zsumujPrzychody() {
        return wartosciPrzychodow;
    }

    public void dodajPrzychod(String nazwa, double wartosc) {
        wartosciPrzychodow += wartosc;
    }

    public void dodajWydatek(String nazwa, double wartosc) {
        wartosciWydatkow += wartosc;
    }
}
