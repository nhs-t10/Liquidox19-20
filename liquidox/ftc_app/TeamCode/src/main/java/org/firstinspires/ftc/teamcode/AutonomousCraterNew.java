package org.firstinspires.ftc.teamcode;


import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.util.ElapsedTime;

import java.util.concurrent.TimeUnit;

@Autonomous
public class AutonomousCraterNew extends LO2Library {
    boolean gold = false;
    int step = 1;
    ElapsedTime eTimeObj = new ElapsedTime();
    imuData imu = null;
    ColorSensorV colorSensor = new ColorSensorV();
    float timer1;
    boolean isDelay;
    public void nextStep(float delay) {
        float timeDone = 99999;
        if(isDelay == false){
            timeDone = timer1 + delay;
            isDelay = true;
        }
        if(timer1 >= timeDone) {
            drive(0, 0, 0, 0);
            isDelay = false;
            step++;
        }

    }

    void sample(float time1) {
        gold = colorSensor.isGold();
            if(timer1 > time1 && timer1 < time1 + 500) {
                drive(-0.2f, -0.2f, -0.2f, -0.2f);
            }
            float time2 = timer1 + 500;
            if(gold){
                if (timer1 > time2 && timer1 < time2 + 500) {
                    drive(0.2f, 0.2f, 0.2f, 0.2f);
                } else if (timer1 > time2 + 500) {
                    drive(-0.2f, -0.2f, -0.2f, -0.2f);
                }
            }
            if(timer1 <time2 + 500 &&timer1 > time2 + 1000){
                drive(0.2f, 0.2f, 0.2f, 0.2f);

            }
        }

    //void unlatch(){ }

    @Override
    public void init() {
        super.initialize_robot();
        Turning.offSet = imu.getAngle();
        colorSensor.init(hardwareMap);
        imu = new imuData(hardwareMap);
    }

    public void loop() {
        timer1 = eTimeObj.time(TimeUnit.MILLISECONDS);

        switch (step) {
            case (1):
                //unlatch();
                nextStep(5000);
                break;

            case (2):
                //move forwards to the the sample sites
                drive(-0.285f, -0.285f, -0.285f, -0.285f);
                nextStep(5750);
                break;

            case (3):
                //move to the side to get to the sample sites
                drive(0.285f, -0.285f, 0.285f, -0.285f);
                nextStep(6750);
                break;
            case (4):
                //first sample
                sample(7000);
                nextStep(5000);

                break;
            case (5):
                //moving to the next thing
                drive(-0.285f, 0.285f, -0.285f, 0.285f);
                if (timer1 >= 8750f) {
                    drive(0f, 0f, 0f, 0f);
                    step++;
                }
                break;
            case (6):
                //sample 2
                sample(9000);
                if (timer1 >= 9000) {
                    drive(0f, 0f, 0f, 0f);
                    step++;
                }
                break;
            case (7):
                drive(-0.285f, 0.285f, -0.285f, 0.285f);
                if (timer1 >= 10000) {
                    drive(0f, 0f, 0f, 0f);
                    step++;
                }
                break;
            case (8):
                //sample 3
                sample(10000);
                if (timer1 >= 10500) {
                    drive(0f, 0f, 0f, 0f);
                    step++;
                }

                break;
            case (9):
                drive(-0.255f, 0.255f, -0.255f, 0.255f);
                if (timer1 >= 13000) {
                    drive(0f, 0f, 0f, 0f);
                    step++;
                }
                break;
            case (10):
                Turning.setDestination(45);
                Turning.update(imu);
                if (timer1 >= 18500) {
                    drive(0f, 0f, 0f, 0f);
                    step++;
                }
                break;
            case (11):
              drive(-0.285f, -0.285f, -0.285f, -0.285f);
                if (timer1 >= 19000) {
                    drive(0f, 0f, 0f, 0f);
                    step++;
                }
                break;
            case (12):
                drive(-0.285f, -0.285f, -0.285f, -0.285f);
                if (timer1 >= 22000) {
                    drive(0f, 0f, 0f, 0f);
                    step++;
                }
                break;
            default:
                drive(0, 0, 0, 0);
                break;
        }

        telemetry.addData("Front Left Power: ", frontLeft.getPower());
        telemetry.addData("Front Right Power: ", frontRight.getPower());
        telemetry.addData("Back Left Power: ", backLeft.getPower());
        telemetry.addData("Back Right Power: ", backRight.getPower());
        telemetry.addData("Time: ", timer1 + "");
        telemetry.addData("Step: ", step + "");
        telemetry.addData("Orientation", Turning.currentAngle + "");
        telemetry.addData("Error",  Turning.getError() + "" );
        telemetry.addData("Off Set: ", Turning.offSet +"");
        telemetry.addData("Angle",  imu.getAngle() + "");

    }
}
