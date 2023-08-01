package frc.robot.commands;

import java.util.function.Supplier;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveSubsystem;

public class ArcadeDriveCm extends CommandBase {

    private final DriveSubsystem driveSubsystem;
    private final Supplier<Double> speedFunction, turnFunction;

    public ArcadeDriveCm(DriveSubsystem drivesubsystem, 
            Supplier<Double> speedFunction, Supplier<Double> turnFunction){
        this.speedFunction = speedFunction;
        this.turnFunction = turnFunction;
        this.driveSubsystem = drivesubsystem;
        addRequirements(driveSubsystem);
    }
    

    
        @Override
        public void initialize(){     
        }

        @Override
        public void execute(){
            double realTimeSpeed = speedFunction.get();
            double realTimeTurn = turnFunction.get();

            double left = realTimeSpeed + realTimeTurn;
            double right = realTimeSpeed - realTimeTurn;
            driveSubsystem.setMotors(left, right);
        }

        @Override 
        public void end(boolean interrupted){

        }

        @Override
        public boolean isFinished(){
            return false;    
        }


}






