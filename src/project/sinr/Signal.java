package project.sinr;

import java.util.List;
import java.util.function.ToDoubleFunction;

public class Signal {

    private double pathLoss; // alpha
    private double noise;

    public Signal(double pathLoss, double noise) {
        this.pathLoss = pathLoss;
        this.noise = noise;
    }

    public double getPathLoss() {
        return pathLoss;
    }

    public double receivedSignalPower(Transmission transmission) {
        double result = transmission.getPowerTransmission() / Math.pow((transmission.getEndPoint() - transmission.getStartPoint()), pathLoss);
        return result;
    }

    public double receivedSignalPower(Transmission transmission, Transmission mainTransmission) {
        double result = transmission.getPowerTransmission() / Math.pow((mainTransmission.getEndPoint() - transmission.getStartPoint()), pathLoss);
        return result;
    }

    public double sinr(List<Transmission> transmissions, final Transmission transmission) {
        double interference = transmissions.stream().filter((Transmission t) -> !t.equals(transmission)).mapToDouble(new ToDoubleFunction<Transmission>() {
            @Override
            public double applyAsDouble(Transmission value) {
                return receivedSignalPower(value, transmission);
            }
        }).sum();

        double result = receivedSignalPower(transmission) / (noise + interference);

        //System.out.println("Transmission: " + receivedSignalPower(transmission));
        //System.out.println("Interference: " + interference);
        //double result = receivedSignalPower(transmission)/(interference);
        return result;
    }

    public boolean valido(List<Transmission> transmissions, double threshold, double accurate) {
        for (Transmission transmission : transmissions) {
            if (sinr(transmissions, transmission) < threshold) {
                return false;
            } else if (sinr(transmissions, transmission) > (threshold + accurate)) {
                return false;
            }
        }
        return true;
    }
}
