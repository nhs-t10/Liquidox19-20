//
//package org.firstinspires.ftc.teamcode;
//import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
//import com.qualcomm.robotcore.hardware.DcMotor;
//import org.firstinspires.ftc.teamcode.LO2Library;
//
//
//@Autonomous
//public class Turning {
//    private float error;
//    private float currentAngle;
//    private float destination;
//    private float pComponent;
//    private boolean turning=false;
//    private float sumError = 0;
//    private float prevTime = 0;
//    private final float P = 0.03f;
//
//
//    DcMotor frontLeft, backLeft, frontRight, backRight;
//
//
//
//    public void Turning() {
//        destination=0;
//    }
//
//    public void setDestination(float degrees){
//        if(degrees > 180) destination = degrees - 360;
//        else destination = degrees;
//        prevTime = System.currentTimeMillis();
//        destination = degrees;
//        turning = true;
//    }
//
//    public void stopTurning(){
//        turning = false;
//        sumError = 0;
//        LO2Library.drive(0,0,0,0);
//    }
//
//    public void update(float sean) {
//        currentAngle = sean;
//        error = getError();
//        pComponent = error * P;
//        double currTime = System.currentTimeMillis();
//
//
//        sumError += error * (currTime - prevTime);
//        if (turning) {
//            if (Math.abs(error) < 3) {
//                stopTurning();
//            }
//                LO2Library.drive((pComponent), (pComponent), -(pComponent), -(pComponent));
//
//            }
//            prevTime = (float) currTime;
//        }
//
//    public float getError(){
//        return currentAngle- destination ;
//    }
//
//}
