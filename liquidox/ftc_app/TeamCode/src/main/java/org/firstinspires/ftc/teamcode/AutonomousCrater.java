package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import org.firstinspires.ftc.teamcode.Turning;
import org.firstinspires.ftc.teamcode.BasicTankMode;

@Autonomous
public class AutonomousCrater extends LO2Library {



    /* WE STILL NEED TO INITIALIZE THE IMU, ASK PAUL WHAT WE HAVE OT DO FOR THAT */
    int step  = 1;
    float timer1, timerOffset;
    public void init(){
        /*Namiyng the Motors for phone*/
        frontLeft = hardwareMap.dcMotor.get("FL");
        backLeft = hardwareMap.dcMotor.get("BL");
        frontRight = hardwareMap.dcMotor.get("FR");
        backRight = hardwareMap.dcMotor.get("BR");
        step = 1;
        timerOffset = System.currentTimeMillis();
    }
    public void loop() {
        timer1 = System.currentTimeMillis() - timerOffset;

        if (step == 1) {
            /*We doon't have unlatch code*/
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
