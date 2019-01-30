package org.firstinspires.ftc.teamcode;


import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;

import java.util.concurrent.TimeUnit;

@Autonomous
public class AutonomousTest extends LO2Library {

    Turning turning;

    boolean gold = false;
    int step = 1;
    boolean goldNow = false;
    ElapsedTime eTimeObj = new ElapsedTime();
    imuData imu;
    float timeDone = 0;
    ColorSensorV colorSensor;
    float timer1;
    DcMotor latchM;
    boolean isDelay;
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
    void nextStep(float delay, int stepNum) {
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

    void sample(float time) {
        if(timer1 > time + 500 && timer1 < time + 1000)
            if(colorSensor.isGold()){
                goldNow = true;
            }

        if(goldNow){
            if(timer1 > time + 1000 && timer1 < time + 1250){
                drive(1.5f,1.5f,1.5f,1.5f);
            }
            if(timer1 > time + 1250 && timer1 < time + 1500){
                drive(-1.5f,-1.5f,-1.5f,-1.5f);
            }
            if(timer1 < time + 1495){
                goldNow = false;
            }
        }

        nextStep( 1500);
    }
//void unlatch(){ }

    @Override
    public void init() {
        super.initialize_robot();
        turning = new Turning(-45);
        latchM = hardwareMap.dcMotor.get("latchM");
        colorSensor= new ColorSensorV(hardwareMap);
        imu = new imuData(hardwareMap);
        turning.setOffset(imu.getAngle());
        latchM.setPower(1);
    }

    public void loop() {
        timer1 = eTimeObj.time(TimeUnit.MILLISECONDS);

        switch (step) {

            case (1):
                drive(-0.2f, -0.2f, -0.2f, -0.2f);
                nextStep(1000);
                break;
            case (2):
                turning  = new Turning(45);
                turning.update(imu);
                nextStep(1000, 60);
                break;
            case (60):
               drive(-0.2, 0.2, -0.2, 0.2);
                nextStep(1000);
                break;
            case (61):
                drive(0.2, -0.2, 0.2, -0.2);
                nextStep(1000);
                break;
            default:
                drive(0,0,0,0);
                break;
          }

        telemetry.addData("FL Power: ", frontLeft.getPower() + " " + speedBar(frontLeft.getPower(),8));
        telemetry.addData("FR Power: ", frontRight.getPower() + " " + speedBar(frontRight.getPower(),8));
        telemetry.addData("BL Power: ", backLeft.getPower() + " " + speedBar(backLeft.getPower(),8));
        telemetry.addData("BR Power: ", backRight.getPower() + " " + speedBar(backRight.getPower(),8));
        telemetry.addData("Time: ", timer1 + "");
        telemetry.addData("Step: ", step + "");
        telemetry.addData("Orientation", turning.get_Angle() + "");
        telemetry.addData("pComponent", turning.getpComponent() + "");
        telemetry.addData("turning", turning.isTurning() + "");
        telemetry.addData("destination", turning.getDestination() + "");
        telemetry.addData("isGold", colorSensor.isGold() + "");
        telemetry.addData("Error",  turning.getError() + "" );
        telemetry.addData("Off Set: ", turning.offSet +"");
        telemetry.addData("Angle",  imu.getAngle() + "");
        telemetry.addData("Hex code", colorSensor.getHexCode() + "");

        telemetry.update();
    }
}
