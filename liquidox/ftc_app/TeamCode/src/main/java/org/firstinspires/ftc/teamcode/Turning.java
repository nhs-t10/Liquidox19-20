//
//package org.firstinspires.ftc.teamcode;
//import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
//import com.qualcomm.robotcore.hardware.DcMotor;
//
//
//@Autonomous
//public class Turning extends LO2Library {
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
//    public Turning() {
//        this.currentAngle = currentAngle;
//        this.pComponent = pComponent;
//        this.sumError = sumError;
//    }
//
//
//    public void init() {
//        /*Naming the Motors for phone*/
//        frontLeft = hardwareMap.dcMotor.get("FL");
//        backLeft = hardwareMap.dcMotor.get("BL");
//        frontRight = hardwareMap.dcMotor.get("FR");
//        backRight = hardwareMap.dcMotor.get("BR");
//    }
//
//
//    public void Turning() {
//        destination=0;
//    }
//
//    public void setDestination(float degrees){
//        if(degrees>180) destination=degrees-360;
//        else destination=degrees;
//        prevTime = System.currentTimeMillis();
//        destination=degrees;
//        turning=true;
//    }
//
//    public void stopTurning(){
//        turning = false;
//        sumError=0;
//        drive(0,0,0,0);
//    }
//
//    public void update(float sean) {
//        currentAngle = sean;
//        error = currentAngle - destination;
//        pComponent = error * P;
//        double currTime = System.currentTimeMillis();
//
//
//        sumError += error * (currTime - prevTime);
//        if (turning) {
//            if (Math.abs(error) < 3) {
//                stopTurning();
//            }
//                drive((pComponent), (pComponent), -(pComponent), -(pComponent));
//
//            }
//            prevTime = (float) currTime;
//        }
//
////    public float getError(){
////        return currentAngle- destination ;
////    }
//
//}
