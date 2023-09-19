package frc.robot.subsystems;
import edu.wpi.first.wpilibj.motorcontrol.VictorSP;
import edu.wpi.first.wpilibj2.command.SubsystemBase;


public class DriveTrain extends SubsystemBase {
    VictorSP leftFront,leftRear,rightFront,rightRear;
    public DriveTrain(VictorSP leftFront, VictorSP leftRear, VictorSP rightFront, VictorSP rightRear)
    {
        this.leftFront = leftFront;
        this.leftRear = leftRear;
        this.rightFront = rightFront;
        this.rightRear = rightRear;

    }
    public void set (double lfSpeed, double lrSpeed, double rfSpeed, double rrSpeed)
    {
        this.leftFront.set(lfSpeed);
        this.leftRear.set(lrSpeed);
        this.rightFront.set(rfSpeed);
        this.rightRear.set(rrSpeed);
    }
    //another set method but for what 
    public Object set(double speed)
    {
        this.set(speed,speed,speed,speed);
        return speed;
    }
    public void stop()
    {
        this.set(0);
    }
public VictorSP getLeftFront(){
    return leftFront;
}
public VictorSP getLeftRear(){
    return leftRear;
}
public VictorSP getRightRear(){
    return rightRear;
}
public VictorSP getRightFront(){
    return rightFront;
}
    
}
    
