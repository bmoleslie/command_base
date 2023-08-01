// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;


public class DriveSubsystem extends SubsystemBase {
  private final WPI_TalonFX leftMotor = new WPI_TalonFX(1);
  private final WPI_TalonFX rightMotor = new WPI_TalonFX(3);

  private final Encoder rightEncoder = new Encoder (0,1);
  private final Encoder leftEncoder = new Encoder (2,3);

  public double getEncoderMeters(){
    return( leftEncoder.get() + - rightEncoder.get()) / 2 * Constants.kEncoderTick2Meter ;
  }


  /** Creates a new ExampleSubsystem. */
  public DriveSubsystem() {}

  /**
   * Example command factory method.
   *
   * @return a command
   */
  public CommandBase exampleMethodCommand() {
    // Inline construction of command goes here.
    // Subsystem::RunOnce implicitly requires `this` subsystem.
    return runOnce(
        () -> {
          /* one-time action goes here */
        });
  }

  /**
   * An example method querying a boolean state of the subsystem (for example, a digital sensor).
   *
   * @return value of some boolean subsystem state, such as a digital sensor.
   */
  public boolean exampleCondition() {
    // Query some boolean state, such as a digital sensor.
    return false;
  }

  @Override
  public void periodic() {
    SmartDashboard.putNumber("Drive encoder value", getEncoderMeters());
    // This method will be called once per scheduler run
  }

  public void setMotors(double leftSpeed, double rightSpeed )
  {
    leftMotor.set(leftSpeed);
    rightMotor.set(-rightSpeed);
  }


  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }
}
