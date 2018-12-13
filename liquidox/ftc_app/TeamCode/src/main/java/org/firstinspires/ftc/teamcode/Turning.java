
package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.util.Range;
import org.firstinspires.ftc.teamcode.imuData;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.HardwareMap;





public class Turning {
    public static double error;
    public static double currentAngle;
    private static double destination;
    private static double pComponent;
    private static boolean turning=false;
    private static final double P = 0.03;

    public static void Turning() {
        destination=0;
    }

    public static void setDestination(double degrees){
        if(degrees > 180) destination = degrees - 360;
        else destination = degrees;
        destination = degrees;
        turning = true;

    }

    public static void stopTurning(){
        turning = false;
        LO2Library.drive(0f,0f,0f,0f);
    }

    public static void update(imuData imu) {
        currentAngle = imu.getAngle();
        error = getError();
        pComponent = Range.clip(error * P,-1,1);


        if (turning) {
            if (Math.abs(error) < 3) {
                stopTurning();
            }
                LO2Library.TurnDrive((pComponent), (pComponent), -(pComponent), -(pComponent));
        }

    }

    public static double getError(){
        return currentAngle- destination ;
    }

}
