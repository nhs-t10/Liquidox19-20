package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import org.firstinspires.ftc.teamcode.Turning;
import org.firstinspires.ftc.teamcode.BasicTankMode;

@Autonomous
public class AutonomousCrater extends AutonomousTesting {



    /* WE STILL NEED TO INITIALIZE THE IMU, ASK PAUL WHAT WE HAVE TO DO FOR THAT */
    int step  = 1;
    float timer1;
    public void init(){
        init();
    }
    public void loop() {
        timer1 = System.currentTimeMillis();

        if (step == 1) {
            /*We don't have unlatch code*/
//            unLatch();
            if (timer1 >= 5000) {
                LO2Library.drive(0f, 0f,0f,0f);
                step++;
            }
        }




        if (step == 2) {
            LO2Library.drive(0.2f,0.2f,0.2f,0.2f);
            if (timer1 >= 1500) {
                LO2Library.drive(0f, 0f,0f,0f);
                step++;
            }

        }

        if (step == 3) {
            Turning.setDestination(-90f);
            Turning.update(Turning.currentAngle);
            if (timer1 >= 6500) {
                LO2Library.drive(0f, 0f,0f,0f);
                step++;
            }
        }

        if (step == 4) {
            LO2Library.drive(0.2f,0.2f,0.2f, 0.2f);
            if (timer1 >= 7500) {
                LO2Library.drive(0f,0f,0f,0f);
                step++;
            }
        }

        if (step == 5) {
            Turning.setDestination(-135f);
            Turning.update(Turning.currentAngle);
            if (timer1 >= 12500) {
                LO2Library.drive(0f,0f,0f,0f);
                step++;
            }
        }

        if (step == 6) {
            LO2Library.drive(0.2f,0.2f, 0.2f, 0.2f);
            if (timer1 >= 14000) {
                LO2Library.drive(0f,0f,0f,0f);
                step++;
            }
        }

        if (step == 7) {
            LO2Library.drive(-1f,-1f,-1f,-1f);
            if (timer1 == 16000) {
                LO2Library.drive(0f,0f,0f,0f);
            }
        }
        telemetry.addData("Front Left Power: ", frontLeft.getPower());
        telemetry.addData("Front Right Power: ", frontRight.getPower());
        telemetry.addData("Back Left Power: ", backLeft.getPower());
        telemetry.addData("Back Right Power: ", backRight.getPower());
        telemetry.addData("Time: ", System.currentTimeMillis() + "");
        telemetry.addData("Step: ", step + "");
    }
}
