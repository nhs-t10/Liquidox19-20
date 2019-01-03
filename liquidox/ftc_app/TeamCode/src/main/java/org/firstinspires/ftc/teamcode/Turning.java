
package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.util.Range;
import org.firstinspires.ftc.teamcode.imuData;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.HardwareMap;





public class Turning {
    public double error;
    public double currentAngle;
    public double destination = 0;
    public double pComponent;
    public boolean turning=false;
    private final double P = 0.0048;
    public double offSet;

    public void setDestination(double degrees){
        if(degrees > 180) {
            destination = degrees 360;
        }else {
            destination = this.degrees;
            this.destination = this.degrees;
            this.turning = true;
        }
    }

    public Turning() {
        this.error = error;
        this.currentAngle = 0;
        this.destination = 0;
        this.pComponent = 0;
        this.turning = false;
        this.offSet = 0;
    }

    public void setOffset(double angel_i_know_its_wrong) {
        this.offSet = angel_i_know_its_wrong;
    }


    public void stopTurning(){
        this.turning = false;
        LO2Library.drive(0f,0f,0f,0f);
    }

    public void update(imuData imu) {
        this.currentAngle = imu.getAngle() - this.offSet;
        this.error = this.currentAngle - this.destination;
        this.pComponent = Range.clip(error * P,-1,1);

        if (turning) {
            if (Math.abs(error) < 5) {
                stopTurning();
            }
            LO2Library.TurnDrive((this.pComponent), (this.pComponent), -(this.pComponent), -(this.pComponent));
        }

    }

    public double get_angle(){
        return this.currentAngle;
    }

}
