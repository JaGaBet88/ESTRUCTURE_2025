package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class motorDAO {
    // Simulación de base de datos en memoria local
    private static List<Motor> motores = new ArrayList<>();

    public void agregarMotor(Motor motor) {
        // Validación para envitar motores duplicados por número de motor
        if (buscarMotorPorNumero(motor.getNumeroMotor()).isPresent()) {
            System.out.println("Error: Ya existe un motor con el número " + motor.getNumeroMotor());
        } else {
            motores.add(motor);
            System.out.println("Motor " + motor.getNumeroMotor() + " agregado.");
        }
    }

    public Optional<Motor> buscarMotorPorNumero(String numeroMotor) {
        return motores.stream().filter(m -> m.getNumeroMotor().equals(numeroMotor)).findFirst();
    }

    public List<Motor> listarTodosLosMotores(){
        return new ArrayList<>(motores);
    }

    public void actualizarMotor(Motor motorActualizado){
        for (int i = 0; i < motores.size(); i++){
            if (motores.get(i).getNumeroMotor().equals(motorActualizado.getNumeroMotor()))motores.set(i,motorActualizado);
            System.out.println("Motor " + motorActualizado.getNumeroMotor() + " actualizado.");
            return;
        }
    }

}
