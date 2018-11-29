
package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.hardware.DcMotor;


@Autonomous
public class Turning {
    public static float error;
    public static float currentAngle;
    private static float destination;
    private static float pComponent;
    private static boolean turning=false;
    private static float sumError = 0;
    private static float prevTime = 0;
    private static final float P = 0.03f;

//    static DcMotor frontLeft, backLeft, frontRight, backRight;
//
//    frontLeft = hardwareMap.dcMotor.get("FL");
//    backLeft = hardwareMap.dcMotor.get("BL");
//    frontRight = hardwareMap.dcMotor.get("FR");
//    backRight = hardwareMap.dcMotor.get("BR");
//
//    public static void drive(float bl, float fl, float fr, float br ) {
//        frontLeft.setPower(-fl*speed);
//        backRight.setPower(br*speed);
//        frontRight.setPower(fr*speed);
//        backLeft.setPower(-bl*speed);
//    }

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
        LO2Library.drive(0,0,0,0);
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
