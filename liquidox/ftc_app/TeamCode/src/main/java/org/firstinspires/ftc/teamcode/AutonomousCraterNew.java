package org.firstinspires.ftc.teamcode;


import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.util.ElapsedTime;
import org.firstinspires.ftc.teamcode.Turning;
import org.firstinspires.ftc.teamcode.ColorSensorV;
import java.util.concurrent.TimeUnit;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.Range;


@Autonomous
public class AutonomousCraterNew extends LO2Library {

    Turning turning = new Turning();

    boolean gold = false;
    int step = 1;
    boolean goldNow = false;
    ElapsedTime eTimeObj = new ElapsedTime();
    imuData imu;
    float timeDone = 0;
    ColorSensorV colorSensor;
    float timer1;
    boolean isDelay;
    DcMotor latchM;
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
boolean haveInit = false;
    @Override
    public void init() {
        super.initialize_robot();
        latchM = hardwareMap.dcMotor.get("latchM");
        colorSensor= new ColorSensorV(hardwareMap);
        imu = new imuData(hardwareMap);
        turning.setOffset(imu.getAngle());
            latchM.setPower(0.6);
    }

    public void loop() {
        timer1 = eTimeObj.time(TimeUnit.MILLISECONDS);
        haveInit = true;
        switch (step) {
            case (1):
                latchM.setPower(Range.clip(3/timer1, 0, 1));
                nextStep(3000);//3000
                break;
            case (2):
                //strafing left
                drive(-0.2f,0.2f,-0.2f,0.2f);
                nextStep(1000);//4000
                break;
            case (3):
                //Contract bar
                nextStep(5);//7000
                break;
            case (4):
                //strafing to center
                drive(0.2f,-0.2f,0.2f,-0.2f);
                nextStep(1000);//8000
                break;
            case (5):
                //move forwards to the the sample sites
                drive(-0.285f, -0.285f, -0.285f, -0.285f);
                nextStep(650); //8500
                break;

            case (6):
                //move to the side to get to the sample sites
                //drive(0.285f, -0.285f, 0.285f, -0.285f);
                nextStep(5);//9250
                break;
            case (7):
                //first sample
                //sample(9250);//10750
                //it will automatically move to the next one after 1500ms
                nextStep(5);
                break;
            case (8):
                //moving to the next thing
                //drive(-0.285f, 0.285f, -0.285f, 0.285f);
                nextStep(5);//11750
                break;
            case (9):
                //sample 2
                //sample(11750);//13250
                nextStep(5);
                break;
            case (10):
                drive(-0.285f, 0.285f, -0.285f, 0.285f);
                 nextStep(1000); //14250
                break;
            case (11):
                //sample 3
                drive(-0.285f, -0.285f, -0.285f, -0.285f);
                nextStep(325); //850
                break;
            case (12):
                drive(-0.2f, 0.2f, -0.2f, 0.2f);
                nextStep(3100);//18750
                break;
            case (13):
                turning.setDestination(-135);
                turning.update(imu);
                nextStep(4000);
                break;
            case (14):
              drive(-0.24f, -0.24f, -0.24f, -0.24f);
               nextStep(2000);
                break;
            case (15):
                drive(0.5f, 0.5f, 0.5f, 0.5f);
                nextStep(2250);
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
        telemetry.addData("Orientation", turning.currentAngle + "");
        telemetry.addData("pComponent", turning.pComponent + "");
        telemetry.addData("turning", turning.turning + "");
        telemetry.addData("destination", turning.destination + "");
        telemetry.addData("isGold", colorSensor.isGold() + "");
        telemetry.addData("Error",  turning.getError() + "" );
        telemetry.addData("Off Set: ", turning.offSet +"");
        telemetry.addData("Angle",  imu.getAngle() + "");
        telemetry.addData("Hex code", colorSensor.getHexCode() + "");

        telemetry.update();
    }
}
