//package org.firstinspires.ftc.teamcode;
//import com.qualcomm.robotcore.eventloop.opmode.OpMode;
//import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
//import com.qualcomm.robotcore.hardware.DcMotor;
//import java.util.concurrent.TimeUnit;
//
//
//@Autonomous(name="LO2 Auto")
//public class AutonomousTesting extends OpMode {
//    float timer1;
//    DcMotor frontLeft, backLeft, frontRight, backRight;
//    enum currentState{
//        starting, lTurning, rTurning, forward, backward, stop;
//    }
//    public currentState cState;
//
//    public void drive(double FL, double BL, double FR, double BR){
//        frontLeft.setPower(FL);
//        backRight.setPower(BR);
//        frontRight.setPower(FR);
//        backLeft.setPower(BL);
//    }
//
//    public void sleep(int seconds){
//        try{
//            Thread.sleep(seconds*1000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//    }
//
//    public void init() {
//        //Naming the Motors for phone
//        frontLeft = hardwareMap.dcMotor.get("FL");
//        backLeft = hardwareMap.dcMotor.get("BL");
//        frontRight = hardwareMap.dcMotor.get("FR");
//        backRight = hardwareMap.dcMotor.get("BR");
//        cState = currentState.starting;
//    }
//
//    public void loop(){
//        if(cState == currentState.starting){
//           unLatch();
//           if(timer1 = 5){
//               cState = cu
//           }
//        }
//        System.currentTimeMillis();
////        if(current == currentState.Turning){
////            turn();
////        }
////        if(current. )
//
//
//    }
//
//    public void turn(){
//        drive(-1,1,1,-1);
//    }
//    public void unLatch() {
//        //code to unlatch
//    }
//}