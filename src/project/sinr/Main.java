package project.sinr;

import java.util.ArrayList;
import java.util.List;
import java.util.function.ToDoubleFunction;

public class Main {

    public double logOfBase(int base, int num) {
        return Math.log(num) / Math.log(base);
    }

    public static void main(String[] args) throws Exception {
        double threshold = 3d; // beta
        double accurate = 0.2d;
        Signal signal = new Signal(3, 10 * Math.pow(10, -9)); // Path Loss and Noise
        Transmission t1 = new Transmission(0.003, 10, 11);
        Transmission t2 = new Transmission(3.4235, 6, 14);
        Transmission t3 = new Transmission(6.02435, 0, 64);
        List<Transmission> transmissions = new ArrayList<>();
        transmissions.add(t1);
        transmissions.add(t2);
        transmissions.add(t3);
        for (int i = 0; i < transmissions.size(); i++) {
            Transmission transmission = transmissions.get(i);
            if (!signal.valido(transmissions, threshold, accurate)) {
                do {
                    if (signal.sinr(transmissions, transmission) < threshold) {
                        transmission.setPowerTransmission((transmission.getPowerTransmission() * (1 + (signal.getPathLoss() / 100))));
                    } else if (signal.sinr(transmissions, transmission) > (threshold + 0.2)) {
                        transmission.setPowerTransmission((transmission.getPowerTransmission() * (1 - (signal.getPathLoss() / 100))));
                    }
                    if (signal.sinr(transmissions, transmission) == Double.POSITIVE_INFINITY) {
                        transmission.setEndPoint(transmission.getEndPoint() - (Math.pow(2, i + 1) - 1));
                    }
                } while (!(signal.sinr(transmissions, transmission) > threshold && signal.sinr(transmissions, transmission) < threshold + accurate));
            }
            if (!signal.valido(transmissions, threshold, accurate)) {
                for (int j = 0; j < transmissions.size(); j++) {
//                 // Trabalhando a distancia
                    Transmission trasmissionManipulate = transmissions.get(j);
                    double variacao = signal.sinr(transmissions, transmission) < threshold ? +1 : -1;
                    if (j == 0) {
                        trasmissionManipulate.setStartPoint(trasmissionManipulate.getStartPoint() + 1);
                        trasmissionManipulate.setEndPoint(trasmissionManipulate.getStartPoint() + 1);
                    } else {
                        Transmission transmissionAnterior = transmissions.get(j - 1);
                        if (j != transmissions.size() - 1) {
                            trasmissionManipulate.setStartPoint(trasmissionManipulate.getStartPoint() - 1);
                        }
                        trasmissionManipulate.setEndPoint(trasmissionManipulate.getEndPoint() + 1);
                    }
                    
                    double sinr = signal.sinr(transmissions, trasmissionManipulate);
                    if (sinr < threshold) {
                        //2^i+2*10^-6 ou
                        //Acrescentar porcetagem nele?
                        trasmissionManipulate.setPowerTransmission((trasmissionManipulate.getPowerTransmission() + 1) * (1 + (signal.getPathLoss() / 100)));
                        
                    } else if (sinr > threshold + accurate) {
                        trasmissionManipulate.setPowerTransmission((trasmissionManipulate.getPowerTransmission() + 1) * (1 - (signal.getPathLoss() / 100)));
                    }

                    // nan /0
                    //
                    System.out.println("Inicio,fim da transmissao " + j);
                    System.out.println("sinr = " + sinr);
//                    System.out.println("Pwr Transmission " + trasmissionManipulate.getPowerTransmission());
                }
                i = 0;
            }
        }
        System.out.println("t1 = " + signal.sinr(transmissions, t1) + " " + (signal.sinr(transmissions, t1) >= threshold ? "is valid" : "is invalid") + " with distance: " + (transmissions.get(0).getEndPoint() - transmissions.get(0).getStartPoint()) + " and Power Transmission: " + transmissions.get(0).getPowerTransmission());
        System.out.println("t2 = " + signal.sinr(transmissions, t2) + " " + (signal.sinr(transmissions, t2) >= threshold ? "is valid" : "is invalid") + " with distance: " + (transmissions.get(1).getEndPoint() - transmissions.get(1).getStartPoint()) + " and Power Transmission: " + transmissions.get(1).getPowerTransmission());
        System.out.println("t3 = " + signal.sinr(transmissions, t3) + " " + (signal.sinr(transmissions, t3) >= threshold ? "is valid" : "is invalid") + " with distance: " + (transmissions.get(2).getEndPoint() - transmissions.get(2).getStartPoint()) + " and Power Transmission: " + transmissions.get(2).getPowerTransmission());

    }
}
