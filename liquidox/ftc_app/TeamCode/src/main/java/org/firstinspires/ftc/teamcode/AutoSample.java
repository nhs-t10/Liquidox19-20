package org.firstinspires.ftc.teamcode;


import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;

import java.util.concurrent.TimeUnit;


@Autonomous
public class AutoSample extends LO2Library {

    Turning turning = new Turning(-135);

    boolean gold = false;
    int step = 1;
    int condition = 0;
    boolean goldNow = false;
    ElapsedTime eTimeObj = new ElapsedTime();
    imuData imu;
    float timeDone = 0;
    ColorSensorV colorSensor;
    float timer1;
    boolean isDelay;
    DcMotor latchM;
    boolean GoldNow;
    void nextStep(float delay) {
        if(!isDelay){
            timeDone = timer1 + delay;
            isDelay = true;
        }
        if(timer1 >= timeDone) {
            drive(0, 0, 0, 0);
            isDelay = false;
            step++;
        }

    }
    void nextStepX(float delay, int stepNum) {
        if(!isDelay){
            timeDone = timer1 + delay;
            isDelay = true;
        }
        if(timer1 >= timeDone) {
            drive(0, 0, 0, 0);
            isDelay = false;
            step = stepNum;
            goldNow = false;
        }
    }
    boolean haveInit = false;
    @Override
    public void init() {
        super.initialize_robot();
        latchM = hardwareMap.dcMotor.get("latchM");
        colorSensor= new ColorSensorV(hardwareMap);
        imu = new imuData(hardwareMap);
        turning.setOffset(imu.getAngle());
        latchM.setPower(0.7);
    }

    public void loop() {
        timer1 = eTimeObj.time(TimeUnit.MILLISECONDS);
        haveInit = true;
        if(goldNow = false){
            goldNow = colorSensor.isGold();
        }
        switch (step) {
            case (1):
                latchM.setPower(0.03);
                nextStep(3500);//3000
                break;
            case (2):
                latchM.setPower(0);
                //strafing left
                drive(-0.33f,0.33f,-0.33f,0.33f);
                nextStep(400);//4000
                break;
            case (3):
                //strafing back
                drive(0.33f,-0.33f,0.33f,-0.33f);
                nextStep(400);//7000
                break;
            /**we are now at the centre, unlatched, at 2800ms*/
            case (4):
                // going forward
                drive(-0.4f,-0.4f,-0.4f,-0.4f);
                nextStep(475);//8000
                break;
            case(5):
                drive(0.33f,-0.33f,0.33f,-0.33f);
                nextStep(500);
                break;
            case (6):
                drive(-0.15f, 0.15f, -0.15f, 0.15f);
                if(goldNow) {
                   step = 12;
                }
                nextStep(7000);
                break;
            case(12):
                drive(-0.2f, -0.2f, -0.2f, -0.2f);
                nextStep(500);
                break;
            default:
                drive(0, 0, 0, 0);
                break;
        }




        telemetry.addData("FL Power: ", frontLeft.getPower() + " " + speedBar(frontLeft.getPower(),8));
        telemetry.addData("FR Power: ", frontRight.getPower() + " " + speedBar(frontRight.getPower(),8));
        telemetry.addData("BL Power: ", backLeft.getPower() + " " + speedBar(backLeft.getPower(),8));
        telemetry.addData("BR Power: ", backRight.getPower() + " " + speedBar(backRight.getPower(),8));
        telemetry.addData("Time: ", timer1 + "");
        telemetry.addData("Step: ", step + "");
        telemetry.addData("Orientation", turning.currentAngle + "");
        telemetry.addData("pComponent", turning.pComponent + "");
        telemetry.addData("turning", turning.turning + "");
        telemetry.addData("destination", turning.destination + "");
        telemetry.addData("isGold", colorSensor.isGold() + "");
        telemetry.addData("Error",  turning.getError() + "" );
        telemetry.addData("Off Set: ", turning.offSet +"");
        telemetry.addData("Angle",  imu.getAngle() + "");
        telemetry.addData("site: ", condition + "");
        telemetry.addData("gold now? ", goldNow + "");

        telemetry.update();
    }
}
