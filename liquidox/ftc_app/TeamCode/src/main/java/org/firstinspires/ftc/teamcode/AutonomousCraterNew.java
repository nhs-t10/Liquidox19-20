package org.firstinspires.ftc.teamcode;


import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.util.ElapsedTime;

import java.util.concurrent.TimeUnit;

@Autonomous
public class AutonomousCraterNew extends LO2Library {
    boolean gold = false;
    int step = 1;
    boolean goldNow = false;
    float timeDone = 99999;
    ElapsedTime eTimeObj = new ElapsedTime();
    imuData imu = null;
    ColorSensorV colorSensor = new ColorSensorV();
    float timer1;
    boolean isDelay;
    public void nextStep(float delay) {
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
        /** The robot should move forward, strafe left slowly, and see if it can see a gold
         * then, if it saw a gold it will go up, then come back to knock the gold off, else: nothing
         * */
        float time2 = time1 + 500;//<--the number that is being added is how many Millis the step takes
        float time3 = time2 + 500;
        float time4 = time3 + 250;
        float time5 = time4 + 250;
        //this will take is 1.5 seconds
        //step one of sample
        if(timer1 > time1 && timer1 <time2){
            drive(0.2f, 0.2f, 0.2f, 0.2f);
        }
        //step two of sample
        if(timer1 > time2 && timer1 <time3){
            drive(0.1f, -0.1f, -0.1f, 0.1f);
            if(gold){
                goldNow = true;
            }
        }
        //step three of sample
        if(timer1 > time3 && timer1 <time4 - 10){
            if(goldNow == true){
                drive(0.2f, 0.2f, 0.2f, 0.2f);
            }
        }
        //step four of sample
        if(timer1 > time4 && timer1 <time5) {
            if (goldNow == true) {
                drive(-0.2f, -0.2f, -0.2f, -0.2f);
            }
        }
        //setting the goleNow boolean back to false
        if(timer1 > time5 - 10) {
            goldNow = false;
        }
        nextStep( 1500);
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
                nextStep(750); //5750
                break;

            case (3):
                //move to the side to get to the sample sites
                drive(0.285f, -0.285f, 0.285f, -0.285f);
                nextStep(1000);//6750
                break;
            case (4):
                //first sample
                sample(1000);//inc
                //it will automatically move to the next one after 1500ms
                break;
            case (5):
                //moving to the next thing
                drive(-0.285f, 0.285f, -0.285f, 0.285f);
                nextStep(8500);
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
