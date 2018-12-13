package org.firstinspires.ftc.teamcode;


import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.Turning;
import org.firstinspires.ftc.teamcode.BasicTankMode;

import java.util.concurrent.TimeUnit;

@Autonomous
public class AutonomousCrater extends LO2Library {
    boolean gold = false;
    int step  = 1;
    ElapsedTime eTimeObj = new ElapsedTime();

    imuData imu;
    float timer1;
    void sample(float time1, float time2, float next){
        if(gold){
            if(timer1 < time1){
                drive(0.2f, 0.2f, 0.2f, 0.2f);
            } else if(timer1 < time2)
                drive(-0.2f, -0.2f, -0.2f, -0.2f);
        }
        if (timer1 >= next) {
            drive(0f, 0f, 0f, 0f);
            step++;
        }
    }
    void unlatch(){
        //
    }
    public void init(){
        /*Namiyng the Motors for phone*/
        frontLeft = hardwareMap.dcMotor.get("FL");
        backLeft = hardwareMap.dcMotor.get("BL");
        frontRight = hardwareMap.dcMotor.get("FR");
        backRight = hardwareMap.dcMotor.get("BR");
        imu = new imuData(hardwareMap);
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
                unlatch();
                if (timer1 >= 5000) {
                    drive(0f, 0f, 0f, 0f);
                    step++;
                }
                break;

            case (2):
                drive(0.2f, 0.2f, 0.2f, 0.2f);
                if (timer1 >= 6000) {
                    drive(0f, 0f, 0f, 0f);
                    step++;
                }
                break;

            case (3):
                drive(-0.2f, 0.2f, 0.2f, -0.2f);
                if (timer1 >= 6500) {
                    drive(0f, 0f, 0f, 0f);
                    step++;
                }
                break;
            case (4):

                sample(7000f, 7500, 8000);

                break;
            case (5):
                //moving to the next thing
                drive(-0.2f, 0.2f, 0.2f, -0.2f);
                if (timer1 >= 8500) {
                    drive(0f, 0f, 0f, 0f);
                    step++;
                }
                break;
            case (6):
                //sample 2
                sample(9000f, 9500f, 10000f);
                if (timer1 >= 10500) {
                    drive(0f, 0f, 0f, 0f);
                    step++;
                }
                break;
            case (7):
                drive(-0.2f, 0.2f, 0.2f, -0.2f);
                if (timer1 >= 11000) {
                    drive(0f, 0f, 0f, 0f);
                    step++;
                }
                break;
            case (8):
                //sample 3
                sample(11500, 12000, 12500);
                if (timer1 >= 13000) {
                    drive(0f, 0f, 0f, 0f);
                    step++;
                }
                break;
            case (9):
                drive(0.2f,-0.2f,-0.2f,0.2f);
                if(timer1 >= 16000) {
                    drive(0f,0f,0f,0f);
                    step++;
                }
            case (10):
                Turning.setDestination(-135);
                Turning.update(imu);
                if(timer1 >= 18000) {
                    drive(0f,0f,0f,0f);
                    step++;
                }
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
        telemetry.addData("Orientation", Turning.currentAngle + "");


    }
}
