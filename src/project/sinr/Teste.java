/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project.sinr;

/**
 *
 * @author lucas
 */
public class Teste {
//    boolean valid = false;
//        do {
//            for (Transmission transmission : transmissions) {
//                if (transmission.getPowerTransmission() == 0d) {
//                    transmission.setPowerTransmission(2 * Math.pow(10, -6));
//                }
//                do {
//                    if (signal.sinr(transmissions, transmission) < threshold) {
//                        valid = false;
//                        transmission.setPowerTransmission((transmission.getPowerTransmission() * (1 + (signal.getPathLoss() / 100))));
//                    } else if (signal.sinr(transmissions, transmission) > (threshold + 0.2)) {
//                        valid = false;
//                        transmission.setPowerTransmission((transmission.getPowerTransmission() * (1 - (signal.getPathLoss() / 100))));
//                    } else {
//                        valid = true;
//                    }
//
//                    if (signal.sinr(transmissions, transmission) == Double.POSITIVE_INFINITY) {
//                        //Gerenciar as distancias
//                        for (int i = 0; i < transmissions.size(); i++) {
//                            //Objeto para trabalhar
//                            Transmission trasmissionManipulate = transmissions.get(i);
//                            if (i == 0) {
//                                trasmissionManipulate.setStartPoint(trasmissionManipulate.getStartPoint() + 1);
//                                trasmissionManipulate.setEndPoint(trasmissionManipulate.getStartPoint() + 1);
//                            } else {
//                                Transmission transmissionAnterior = transmissions.get(i - 1);
//                                if (i < transmissions.size() - 1 && trasmissionManipulate.getStartPoint()==0) {
//                                    trasmissionManipulate.setStartPoint(transmissionAnterior.getStartPoint() - (Math.pow(2, i + 1)));
//                                }
//                                trasmissionManipulate.setEndPoint(transmissionAnterior.getEndPoint() + (Math.pow(2, i + 1) - 1));
//                            }
//                            double sinr = signal.sinr(transmissions, trasmissionManipulate);
//                            if (sinr < threshold) {
//                                //2^i+2*10^-6 ou
//                                //Acrescentar porcetagem nele?
//                                trasmissionManipulate.setPowerTransmission((trasmissionManipulate.getPowerTransmission()+1) * (1 + (signal.getPathLoss() / 100)));
//                            } else if (sinr > threshold + accurate) {
//                                trasmissionManipulate.setPowerTransmission((trasmissionManipulate.getPowerTransmission()+1) * (1 - (signal.getPathLoss() / 100)));
//                            }
//
//                            // nan /0
//                            //
//                            System.out.println("Inicio,fim da transmissao " + i);
//                            System.out.println(trasmissionManipulate.getStartPoint());
//                            System.out.println(trasmissionManipulate.getEndPoint());
//                            System.out.println("sinr = " + sinr);
//                            System.out.println("Pwr Transmission " + trasmissionManipulate.getPowerTransmission());
//                        }
////                        transmissions.get(0).setPowerTransmission(0.0000655);
////                        transmissions.get(1).setPowerTransmission(0.0027);
////                        transmissions.get(2).setPowerTransmission(1.485);
//                    }
//                } while (!valid);
//            }
//        } while (!signal.valido(transmissions, threshold, accurate));
}
