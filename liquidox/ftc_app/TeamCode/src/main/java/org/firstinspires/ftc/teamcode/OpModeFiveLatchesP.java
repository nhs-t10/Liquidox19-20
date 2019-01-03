package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.Range;

@TeleOp
public class OpModeFiveLatchesP extends OpMode {
    //private double random;
    //instantiate hardware devices
    boolean a = true;
    boolean b = true;
    DcMotor frontLeft, backLeft, frontRight, backRight, latchM;

    Servo rightChestShoulder, leftChestShoulder, leftOuterShoulder, rightOuterShoulder;

    CRServo latchS;

    float speed = 0.8f;
    public void upArm() throws InterruptedException {
        this.latchS.setPower(0.2);
        latchM.setPower(0.2f);
        Thread.sleep(1000);
        this.latchS.setPower(0);
        latchM.setPower(0f);
    }
    public void downArm() throws InterruptedException {
        this.latchS.setPower(-0.2);
        latchM.setPower(-0.2f);
        Thread.sleep(1000);
        this.latchS.setPower(0);
        latchM.setPower(0f);
    }
    public void init() {
        /*Naming the Motors for phone*/
        frontLeft = hardwareMap.dcMotor.get("FL");
        backLeft = hardwareMap.dcMotor.get("BL");
        frontRight = hardwareMap.dcMotor.get("FR");
        backRight = hardwareMap.dcMotor.get("BR");


       // assign shoulders (motors involved in arms)
        rightChestShoulder = hardwareMap.servo.get("RCS");
        leftChestShoulder = hardwareMap.servo.get("LCS");
        rightOuterShoulder = hardwareMap.servo.get("ROS");
        leftOuterShoulder = hardwareMap.servo.get("LOS");
        leftOuterShoulder.setDirection(Servo.Direction.REVERSE);


       /*naming the latching devices*/
        latchS = hardwareMap.crservo.get("latchS");
        latchM = hardwareMap.dcMotor.get("latchM");
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

        //okay now that that masterpiece of coding is done, have some disgusting pasta.
        //if the button is down, move left and right shoulders forwards.
        /**moves outer servos if a button is pressed*/
        if(gamepad1.a) {
                leftOuterShoulder.setPosition(0.5);
                rightOuterShoulder.setPosition(0.5);
            } /*no else because we don't want one button to "take precedence" over another-- might be jittery, but there you go `\_('-')_/` */
        /**moves outer servos in opposite direction when b button is pressed*/
        if (gamepad1.b) {
            leftOuterShoulder.setPosition(0);
            rightOuterShoulder.setPosition(0);
        }
        if(gamepad1.x) {
//            rightChestShoulder.setPosition(0.5);
//            leftChestShoulder.setPosition(0.5);
        } /*no else because we don't want one button to "take precedence" over another-- might be jittery, but there you go `\_('-')_/` */
        if(gamepad1.y) {
//            rightChestShoulder.setPosition(0);
//            leftChestShoulder.setPosition(0);
        }

/** going up*/
        if (gamepad1.left_stick_button) {
            try {
                upArm();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
/** coming down*/
        if (gamepad1.right_stick_button) {
            try {
                downArm();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        //Throttle Code

        //If both bumpers are down, revert the speed to default
        if(gamepad1.left_bumper && gamepad2.right_bumper) {
           speed = 0.8f;
           //otherwise, if the left bumper is down, decrease the speed (with a minumum of 0)
        } else if(gamepad1.left_bumper) {
            speed = Math.max(speed - 0.05f, 0);
        } else if(gamepad1.right_bumper) {
            //then, if the right bumper is down, increase the speed (max of 5)
            speed = Math.min(speed + 0.05f, 5);
        }
        //////////////////////////////

        //////////////////////////////
        telemetry.addData("Front Left Power: ", frontLeft.getPower());
        telemetry.addData("Front Right Power: ", frontRight.getPower());
        telemetry.addData("Back Left Power: ", backLeft.getPower());
        telemetry.addData("Back Right Power: ", backRight.getPower());
        telemetry.addData("Left Gamepad X-Coordinate: ", lX);
        telemetry.addData("Left Gamepad Y-Coordinate: ", lY);
        telemetry.addData("leftChestShoulder: ", leftChestShoulder.getPosition());
        telemetry.addData("leftOuterShoulder: ", leftOuterShoulder.getPosition());
        telemetry.addData("rightChestShoulder: ", rightChestShoulder.getPosition());
        telemetry.addData("leftOuterShoulder: ", leftOuterShoulder.getPosition());
        telemetry.addData("Clock: ", time);
        telemetry.update();
    }


}