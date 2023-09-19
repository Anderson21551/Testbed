package frc.robot.commands;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveTrain;

import java.util.function.DoubleSupplier;
public class Driveteleop extends CommandBase {
    
    private DoubleSupplier leftInput,rightInput,steeringInput;
    private final DriveTrain driveTrain;
    private final double DEADBAND = 0.12;

    /**
     * @param driveTrain
     * @param leftInput
     * @param rightInput
     * @param steeringInput
     */
    public Driveteleop (DriveTrain driveTrain, DoubleSupplier leftInput,DoubleSupplier rightInput,DoubleSupplier steeringInput ){
        this.driveTrain = driveTrain;
        this.leftInput = leftInput;
        this.rightInput = rightInput;
        this.steeringInput = steeringInput;
        addRequirements(driveTrain);
    }

        @Override
        public void initialize(){

               }      @Override
        public void execute (){

            double speedSensetivity = 1.0;

            double steering = steeringInput.getAsDouble();
            if ( steering > -DEADBAND && steering < DEADBAND ){
                steering = 0; 
            }
            double throttle = rightInput.getAsDouble() - leftInput.getAsDouble();
            double rpower = throttle * (0.5 + steering);
            double lpower = throttle * (0.5 - steering); // what else can be used for throttle
            driveTrain.set(lpower*speedSensetivity,rpower*speedSensetivity, lpower, lpower);
            SmartDashboard.putNumber("steering",steering);
            SmartDashboard.putNumber("throttle",throttle);
        }

            @Override

            public boolean isFinished(){
                return false; 
            }
            @Override
            public void end (boolean interrupted){
                this.driveTrain.stop();
            }

            

        
    }
    

    


