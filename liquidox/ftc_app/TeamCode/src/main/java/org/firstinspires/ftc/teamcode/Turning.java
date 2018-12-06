
package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;



@Autonomous
public class Turning extends AutonomousTesting{
    public static float error;
    public static float currentAngle;
    private static float destination;
    private static float pComponent;
    private static boolean turning=false;
    private static float sumError = 0;
    private static float prevTime = 0;
    private static final float P = 0.03f;


    public static void Turning() {
        destination=0;
    }

    public static void setDestination(float degrees){
        if(degrees > 180) destination = degrees - 360;
        else destination = degrees;
        prevTime = System.currentTimeMillis();
        destination = degrees;
        turning = true;
    }

    public static void stopTurning(){
        turning = false;
        sumError = 0;
        LO2Library.drive(0f,0f,0f,0f);
    }

    public static void update(float sean) {
        currentAngle = sean;
        error = getError();
        pComponent = error * P;
        double currTime = System.currentTimeMillis();


        sumError += error * (currTime - prevTime);
        if (turning) {
            if (Math.abs(error) < 3) {
                stopTurning();
            }
                LO2Library.drive((pComponent), (pComponent), -(pComponent), -(pComponent));

            }
            prevTime = (float) currTime;
        }

    public static float getError(){
        return currentAngle- destination ;
    }

}
