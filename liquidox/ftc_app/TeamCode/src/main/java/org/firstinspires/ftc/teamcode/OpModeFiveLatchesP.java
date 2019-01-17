package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
//import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.Range;
import org.firstinspires.ftc.teamcode.LO2Library;


import org.firstinspires.ftc.teamcode.LiftHandler;

@TeleOp
public class OpModeFiveLatchesP extends OpMode {
    //private double random;
    //instantiate hardware devices
    boolean a = true;
    boolean b = true;
    DcMotor frontLeft, backLeft, frontRight, backRight, latchM;
    Servo john;
    LiftHandler lift;

    CRServo latchS;

    float speed = 0.8f;
    public void upArm() throws InterruptedException {
        latchS.setPower(1);
        latchM.setPower(0.12);
        Thread.sleep(900);
        latchM.setPower(0f);
    }

    public void downArm() throws InterruptedException {
        latchS.setPower(-1);
        latchM.setPower(-0.2f);
        Thread.sleep(1000);
        latchM.setPower(0f);
    }
    public void init() {
        /*Naming the Motors for phone*/
        frontLeft = hardwareMap.dcMotor.get("FL");
        backLeft = hardwareMap.dcMotor.get("BL");
        frontRight = hardwareMap.dcMotor.get("FR");
        backRight = hardwareMap.dcMotor.get("BR");


       /*naming the latching devices*/
        latchS = hardwareMap.crservo.get("latchS");
        latchM = hardwareMap.dcMotor.get("latchM");
        john = hardwareMap.servo.get("john");
        john.setPosition(0);
    }
    public final void drive(float bl, float fl, float fr, float br ) {
/** Tells the robot how to drive */
          frontLeft.setPower(-fl*speed); //Scaled by 1.8
          backRight.setPower(br*speed);
          frontRight.setPower(fr*speed);
          backLeft.setPower(-bl*speed);

    }

    float[] sum = {0,0,0,0};


    public void loop() {
/** finds the values from the controller*/
        float lX = Range.clip(gamepad1.left_stick_x , -1, 1);
        float lY = Range.clip(gamepad1.left_stick_y, -1, 1);
        float rX = Range.clip(gamepad1.right_stick_x/1.5f, -1, 1);

/** creates driving modes */
        float[] vertical = {0.7f * lY, 0.7f * lY, 0.7f * lY, 0.7f * lY};
        float[] horizontal = {lX, -lX, lX, -lX};
        float[] rotational = {-0.7f * rX, -0.7f * rX, 0.7f * rX, 0.7f * rX};
/** Adds all of the driving modes together */
        for(int i=0; i<4; i++) {
            sum[i] = vertical[i] + horizontal[i] + rotational[i];
        }

        float highest = Math.max(Math.max(sum[0], sum[1]), Math.max(sum[2], sum[3]));
/** Makes sure the robot doesnt drive above the maximum speed */
        if(Math.abs(highest)>1) {
            for (int i=0; i<4; i++) {
                sum[i]=sum[i]/highest;
            }
        }

/** makes it go vroom*/
        drive(sum[0],sum[1],sum[2],sum[3]);

        //if the button is down, move left and right shoulders forwards.
        /**moves outer servos if a button is pressed*/
        if(gamepad1.a) {
            latchM.setPower(1);
            try {
                Thread.sleep(750);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            latchM.setPower(0.1); //we only need to let it sit at 0.05 power; the rest is wasted (I have it a bit higher just in case)
            }
        /**moves outer servos in opposite direction when b button is pressed*/// - we only need one direction... think about it
        if (gamepad1.b) {
            latchS.setPower(-0.3);
        } else if(gamepad1.y) {
            latchS.setPower(0.3);
        }else{
          latchS.setPower(0);
        }

        if(gamepad1.x) {

        }
        //Throttle Code

        //If both bumpers are down, revert the speed to default
        if(gamepad1.left_bumper && gamepad2.right_bumper) {
           speed = 0.8f;
           //otherwise, if the left bumper is down, decrease the speed (with a minumum of 0)
        } else if(gamepad1.left_bumper) {
            speed = 0.3f;
        } else if(gamepad1.right_bumper) {
            //then, if the right bumper is down, increase the speed (max of 5)
            speed = 1;
        }
        if(gamepad1.left_trigger > 0.1){
            john.setPosition(0.8);
        }
        if(gamepad1.right_trigger > 0.1) {
            john.setPosition(0);
        }
        //////////////////////////////

        //////////////////////////////
        telemetry.addData("FL Power: ", frontLeft.getPower() + " " + LO2Library.speedBar(frontLeft.getPower(),8));
        telemetry.addData("FR Power: ", frontRight.getPower() + " " + LO2Library.speedBar(frontRight.getPower(),8));
        telemetry.addData("BL Power: ", backLeft.getPower() + " " + LO2Library.speedBar(backLeft.getPower(),8));
        telemetry.addData("BR Power: ", backRight.getPower() + " " + LO2Library.speedBar(backRight.getPower(),8));
        telemetry.addData("Left Gamepad X-Coordinate: ", lX);
        telemetry.addData("Left Gamepad Y-Coordinate: ", lY);
        telemetry.update();
    }




}