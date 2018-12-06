package org.firstinspires.ftc.teamcode;


import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.Turning;
import org.firstinspires.ftc.teamcode.BasicTankMode;

import java.util.concurrent.TimeUnit;

@Autonomous
public class AutonomousDepot extends AutonomousTesting {

    int step  = 1;
    ElapsedTime eTimeObj = new ElapsedTime();
    float timer1;
    public void init(){
        /*Namiyng the Motors for phone*/
        frontLeft = hardwareMap.dcMotor.get("FL");
        backLeft = hardwareMap.dcMotor.get("BL");
        frontRight = hardwareMap.dcMotor.get("FR");
        backRight = hardwareMap.dcMotor.get("BR");
        step = 1;
    }
    public void loop() {
        timer1 = eTimeObj.time(TimeUnit.MILLISECONDS);
        //emergency stop
        if(gamepad1.x){
            step = 30;
        }
        switch(step) {
            case (1):
                if (timer1 >= 5000) {
                    drive(0f, 0f, 0f, 0f);
                    step++;
                }
                break;

            case (2):
                if (timer1 >= 10000) {
                    drive(0f, 0f, 0f, 0f);
                    step++;
                }
                break;

            case (3):
                if (timer1 >= 15000) {
                    drive(0f, 0f, 0f, 0f);
                    step++;
                }
                break;
            case (4):
                if (timer1 >= 20000) {
                    drive(0f, 0f, 0f, 0f);
                    step++;
                }
                break;

            case (5):
                if (timer1 >= 25000) {
                    drive(0f, 0f, 0f, 0f);
                    step++;
                }
                break;

            case (6):
                if (timer1 >= 30000) {
                    drive(0f, 0f, 0f, 0f);
                    step++;
                }
                break;
            default:
                drive(0,0,0,0);
                break;
        }

        telemetry.addData("Front Left Power: ", frontLeft.getPower());
        telemetry.addData("Front Right Power: ", frontRight.getPower());
        telemetry.addData("Back Left Power: ", backLeft.getPower());
        telemetry.addData("Back Right Power: ", backRight.getPower());
        telemetry.addData("Time: ", timer1 + "");
        telemetry.addData("Step: ", step + "");
//        if(step == 2){
//            LO2Library.drive(0.2f, 0.2f, 0.2f, 0.2f);
//            if(timer1 >= 1500){
//                LO2Library.drive(0f,0f,0f,0f);
//                timer1 = 0;
//                step++;
//            }
//        }
//
//        if(step == 3) {
//            Turning.setDestination(45);
//            Turning.update(Turning.currentAngle);
//
//        }
//
//            if (timer1 == 6500) {
//                LO2Library.drive(0f, 0f,0f,0f);
//                timer1 = 0;
//                step++;
//            }
//        }
//
//        if(step == 4) {
//            LO2Library.drive(-0.2f,0.2f,0.2f,-0.2f);
//            if(timer1 == 7000) {
//                LO2Library.drive(0f,0f,0f,0f);
//                timer1 = 0;
//                step++;
//            }
//        }
//
//        if(step == 5) {
//            LO2Library.drive(-1f,-1f,-1f,-1f);
//            if (timer1 == 6000) {
//                LO2Library.drive(0f,0f,0f,0f);
//            }
//        }

    }
}
