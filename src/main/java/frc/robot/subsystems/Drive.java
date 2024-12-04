package frc.robot.subsystems;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj.motorcontrol.Talon;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Drive extends SubsystemBase {

    // Declare motors
    Talon frontLeft, rearLeft, frontRight, rearRight, backShooterBottom, backShooterTop, frontShooterTop, frontShooterBottom, shooterTurn;

    // Motor controller groups
    MotorControllerGroup leftMotors;
    MotorControllerGroup rightMotors;

    DifferentialDrive robotDrive;

    /** Creates a new Drive. */
    public Drive() {
        // Initialize Talon motors

        // Bottom Movement
        frontLeft = new Talon(0);
        rearLeft = new Talon(1);
        frontRight = new Talon(2);
        rearRight = new Talon(3);

        // Shooter
        backShooterBottom = new Talon(4);
        backShooterTop = new Talon(5);
        frontShooterTop = new Talon(6);
        frontShooterBottom = new Talon(7);

        // Shooter Turn Mech
        shooterTurn = new Talon(8);
        
        // Invert the right motors to correct direction
        frontRight.setInverted(true);
        rearRight.setInverted(true);
        
        // Create motor controller groups
        leftMotors = new MotorControllerGroup(frontLeft, rearLeft);
        rightMotors = new MotorControllerGroup(frontRight, rearRight);   

        // Initialize MecanumDrive
        robotDrive = new DifferentialDrive(leftMotors, rightMotors);
    }

    public void arcadeDrive(double xSpeed, double rotation) {
        robotDrive.arcadeDrive(xSpeed, rotation);
    }

    @Override
    public void periodic() {
        // This method will be called once per scheduler run
    }
}