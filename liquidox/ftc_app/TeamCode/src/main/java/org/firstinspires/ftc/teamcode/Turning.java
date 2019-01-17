
package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.util.Range;
import org.firstinspires.ftc.teamcode.imuData;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.HardwareMap;





public class Turning {
    public double error;
    public double currentAngle;
    public double destination;
    public double pComponent;
    public boolean turning=false;
    public double offSet;
    float p = 0.0005f;



    public Turning(double destination) {
        this.error = 0;
        this.currentAngle = 0;
        this.destination = destination;
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
        this.pComponent = Range.clip(this.error * p,-1,1);

        if (this.turning) {
            if (Math.abs(this.error) < 10) {
                this.stopTurning();
            }
            LO2Library.TurnDrive((this.pComponent), (this.pComponent), -(this.pComponent), -(this.pComponent));
        }

    }

    public double get_angle(){
        return this.currentAngle;
    }

    public double getError(){
        return this.error;
    }
    public double getDestination(){
        return this.destination;
    }

}
