
package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import org.firstinspires.ftc.teamcode.LO2Library;


@Autonomous
public class Turning extends LO2Library {
    float currentAngle;
    float destination;
    float pComponent;
    float dComponent;
    float iComponent;
    boolean turning=false;
    float prevError = 0;
    float sumError = 0;
    float prevTime = 0;
    final float P = 0.03f;
    final float D = 0.3f;
    final float I = 0.01f;

    DcMotor frontLeft, backLeft, frontRight, backRight;


    public void init() {
        /*Namiyng the Motors for phone*/
        frontLeft = hardwareMap.dcMotor.get("FL");
        backLeft = hardwareMap.dcMotor.get("BL");
        frontRight = hardwareMap.dcMotor.get("FR");
        backRight = hardwareMap.dcMotor.get("BR");
    }

    public final void drive(float bl, float fl, float fr, float br ) {

        frontLeft.setPower(-fl);
        backRight.setPower(br);
        frontRight.setPower(-fr);
        backLeft.setPower(bl);

    }

    public Turning(){
        destination=0;
    }

    public void setDestination(float degrees){
        if(degrees>180) destination=degrees-360;
        else destination=degrees;
        prevTime = getCurrTime();
        destination=degrees;
        turning=true;
    }

    public void stopTurning(){
        turning = false;
        sumError=0;
        drive(0,0,0,0);
    }

    public void update(imuData sean) {
        currentAngle = sean.getAngle();
        float error = getError();
        pComponent = error * P;
        double currTime = getCurrTime();
        dComponent = (float)-Math.abs(D*(error-prevError)/(currTime- prevTime));

        sumError += error*(currTime-prevTime);
        iComponent = I * sumError;
        if (turning) {
            if (Math.abs(error) < 3) {
                stopTurning();
            }
            drive((pComponent+dComponent+iComponent), (pComponent+dComponent+iComponent),-(pComponent+dComponent+iComponent),-(pComponent+dComponent+iComponent));

        }
        prevTime = (float)currTime;
    }

    public float getError(){
        return currentAngle- destination ;
    }

    public float getCurrTime() {
        return System.currentTimeMillis();
    }
}