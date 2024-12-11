package frc.robot.subsystems;

// import com.ctre.phoenix.motorcontrol.can.TalonSRX;
// import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.drive.MecanumDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj.motorcontrol.Talon;
import edu.wpi.first.wpilibj.motorcontrol.Victor;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Drive extends SubsystemBase {

    Victor frontLeft, rearLeft, frontRight, rearRight, backShooterBottom, backShooterTop, frontShooterTop, frontShooterBottom, shooterTurn;

    // Motor controller groups
    MotorControllerGroup rightMotors;
    MotorControllerGroup leftMotors;

    DifferentialDrive robotDrive;

    /** Creates a new Drive. */
    public Drive() {
        // Initialize Talon motors

        // Bottom Movement
        WPI_TalonSRX frontLeft = new WPI_TalonSRX(2);
        WPI_VictorSPX rearLeft = new WPI_VictorSPX(1);
        WPI_VictorSPX frontRight = new WPI_VictorSPX(3);
        WPI_VictorSPX rearRight = new WPI_VictorSPX(4);

        // Shooter
        Victor backShooterBottom = new Victor(5);
        Victor backShooterTop = new Victor(6);
        Victor frontShooterTop = new Victor(7);
        Victor frontShooterBottom = new Victor(8);

        // Shooter Turn Mech
        // shooterTurn = new Talon(8);
        
        // Invert the right motors to correct direction
        frontRight.setInverted(true);
        rearRight.setInverted(true);
        frontLeft.setInverted(true);
        rearLeft.setInverted(true);
        
        // Create motor controller groups
        leftMotors = new MotorControllerGroup(frontLeft, rearLeft);
        rightMotors = new MotorControllerGroup(frontRight, rearRight);

        // Initialize Differential Drive
        robotDrive = new DifferentialDrive(leftMotors, rightMotors);
    }

    public void DifferentialDrive(double xSpeed, double rotation) {
        robotDrive.arcadeDrive(xSpeed, rotation);
        SmartDashboard.putNumber("test", xSpeed);
        SmartDashboard.putNumber("tests", rotation);
    }

    @Override
    public void periodic() {
        // This method will be called once per scheduler run
    }

    public void arcadeDrive(double xSpeedVal, double rotationVal) {
        throw new UnsupportedOperationException("Unimplemented method 'arcadeDrive'");
    }
}