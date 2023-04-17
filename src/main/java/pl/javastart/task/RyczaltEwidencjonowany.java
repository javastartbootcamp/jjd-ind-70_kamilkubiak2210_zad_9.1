package pl.javastart.task;

public class RyczaltEwidencjonowany extends FormaOpodatkowania {
    private static final int MAX_KWOTA_WOLNA_OD_PODATKU = 10_000;
    private static final int MAX_KWOTA_DLA_PODATKU_18_PROCENT = 100_000;

    @Override
    public double wyliczPodatek(double przychody, double wydatki) {
        double dochod = przychody - wydatki;
        if (dochod <= MAX_KWOTA_WOLNA_OD_PODATKU) {
            return 0;
        } else if (dochod > MAX_KWOTA_WOLNA_OD_PODATKU && dochod <= MAX_KWOTA_DLA_PODATKU_18_PROCENT) {
            return (dochod - MAX_KWOTA_WOLNA_OD_PODATKU) * 0.18;
        } else if (dochod > MAX_KWOTA_DLA_PODATKU_18_PROCENT) {
            double dochodPoPomniejszeniuO100000 = dochod - MAX_KWOTA_DLA_PODATKU_18_PROCENT;
            double podatek18Procent = (MAX_KWOTA_DLA_PODATKU_18_PROCENT - MAX_KWOTA_WOLNA_OD_PODATKU) * 0.18;
            double podatek32Procent = dochodPoPomniejszeniuO100000 * 0.32;
            return podatek18Procent + podatek32Procent;
        }
        return -1;
    }

    @Override
    public String drukFormaOpodatkowania(double dochod) {
        if (dochod <= MAX_KWOTA_WOLNA_OD_PODATKU) {
            return "0";
        } else if (dochod > MAX_KWOTA_WOLNA_OD_PODATKU && dochod <= MAX_KWOTA_DLA_PODATKU_18_PROCENT) {
            return "18";
        } else if (dochod > MAX_KWOTA_DLA_PODATKU_18_PROCENT) {
            return "18+32";
        }
        return "-1";
    }
}
