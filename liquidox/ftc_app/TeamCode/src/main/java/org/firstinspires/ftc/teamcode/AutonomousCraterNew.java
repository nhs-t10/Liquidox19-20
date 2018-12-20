package org.firstinspires.ftc.teamcode;


import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.util.ElapsedTime;
import org.firstinspires.ftc.teamcode.Turning;
import org.firstinspires.ftc.teamcode.ColorSensorV;
import java.util.concurrent.TimeUnit;

@Autonomous
public class AutonomousCraterNew extends LO2Library {

    Turning turning = new Turning();

    boolean gold = false;
    int step = 1;
    boolean goldNow = false;
    ElapsedTime eTimeObj = new ElapsedTime();
    imuData imu;
    float timeDone = 0;
    ColorSensorV colorSensor = new ColorSensorV();
    float timer1;
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

    void sample() {
        gold = colorSensor.isGold();
        /** The robot should move forward, strafe left slowly, and see if it can see a gold
         * then, if it saw a gold it will go up, then come back to knock the gold off, else: nothing
         * */
        float time1 = timer1;
        float time2 = time1 + 500;//<--the number that is being added is how many Millis the step takes
        float time3 = time2 + 500;
        float time4 = time3 + 250;
        float time5 = time4 + 250;
        int sampleStep = 1;
        //this will take 1.5 seconds
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
        if(timer1 > time3 && timer1 <time4){
            if(goldNow){
                drive(0.2f, 0.2f, 0.2f, 0.2f);
            }else{
                drive(0,0,0,0);
            }
        }
        //step four of sample
        if(timer1 > time4 && timer1 <time5) {
            if (goldNow) {
                drive(-0.2f, -0.2f, -0.2f, -0.2f);
            }else{
                drive(0,0,0,0);
            }
        }
        //setting the goldNow boolean back to false
        if(timer1 > time5 - 10) {
            goldNow = false;
        }
        nextStep( 1500);
    }
//void unlatch(){ }

    @Override
    public void init() {
        super.initialize_robot();

        colorSensor.init(hardwareMap);
        imu = new imuData(hardwareMap);

        turning.offSet = imu.getAngle();
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
                sample();//6750
                //it will automatically move to the next one after 1500ms
                break;
            case (5):
                //moving to the next thing
                drive(-0.285f, 0.285f, -0.285f, 0.285f);
                nextStep(1000);//9250
                break;
            case (6):
                //sample 2
                sample();//9250
                break;
            case (7):
                drive(-0.285f, 0.285f, -0.285f, 0.285f);
                 nextStep(1); //10,000
                break;
            case (8):
                //sample 3
                sample();//1000
                break;
            case (9):
                drive(-0.255f, 0.255f, -0.255f, 0.255f);
                nextStep(3000);//13,000
                break;
            case (10):
                turning.setDestination(-135);
                turning.update(imu);
                if (timer1 >= 18500) {
                    drive(0f, 0f, 0f, 0f);
                    step++;
                }
                break;
            case (11):
              drive(-0.285f, -0.285f, -0.285f, -0.285f);
               nextStep(1500);
                break;
            case (12):
                drive(-0.285f, -0.285f, -0.285f, -0.285f);
                nextStep(3000);
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
