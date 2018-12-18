package org.firstinspires.ftc.teamcode;


import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.util.ElapsedTime;
import org.firstinspires.ftc.teamcode.ColorSensorV;

import org.firstinspires.ftc.teamcode.Turning;


import java.util.concurrent.TimeUnit;

@Autonomous
public class AutonomousCrater extends LO2Library {
    boolean gold = false;
    int step = 1;
    ElapsedTime eTimeObj = new ElapsedTime();
    imuData imu = null;
    ColorSensorV colorSensor = new ColorSensorV();

    float timer1;

    void sample(float time1, float time2) {
        gold = colorSensor.isGold();
        if (gold) {
            if (timer1 > time1 && timer1 < time2) {
                drive(0.2f, 0.2f, 0.2f, 0.2f);
            } else if (timer1 > time2) {
                drive(-0.2f, -0.2f, -0.2f, -0.2f);
            }
        }
    }

    //void unlatch(){ }

    @Override
    public void init() {
        super.initialize_robot();
        colorSensor.init(hardwareMap);
        imu = new imuData(hardwareMap);
    }

    public void loop() {
        timer1 = eTimeObj.time(TimeUnit.MILLISECONDS);

        switch (step) {
            case (1):
                //unlatch();
                if (timer1 >= 5000) {
                    drive(0f, 0f, 0f, 0f);
                    step++;
                }
                break;

            case (2):
                //move forwards to the the sample sites
                drive(-0.285f, -0.285f, -0.285f, -0.285f);
                if (timer1 >= 5750) {
                    drive(0f, 0f, 0f, 0f);
                    step++;
                }
                break;

            case (3):
                //move to the side to get to the sample sites
                drive(0.285f, -0.285f, 0.285f, -0.285f);
                if (timer1 >= 6750) {
                    drive(0f, 0f, 0f, 0f);
                    step++;
                }
                break;
            case (4):
                //first sample
                sample(7000, 7250);
                if (timer1 >= 7500f) {
                    drive(0f, 0f, 0f, 0f);
                    step++;
                }

                break;
            case (5):
                //moving to the next thing
                drive(-0.285f, 0.285f, -0.285f, 0.285f);
                if (timer1 >= 8500f) {
                    drive(0f, 0f, 0f, 0f);
                    step++;
                }
                break;
            case (6):
                //sample 2
                sample(8750f, 9000);
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
                sample(10000, 10250);
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
        telemetry.addData("error", Turning.getError() + "");

    }
}
