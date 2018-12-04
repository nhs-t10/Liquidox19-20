package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.Range;

@TeleOp
public class OpModeFiveSevo extends OpMode {
    //private double random;
    //instantiate hardware devices
    boolean a = true;
    boolean b = true;
    DcMotor frontLeft, backLeft, frontRight, backRight;

    Servo rightChestShoulder, leftChestShoulder, leftOuterShoulder, rightOuterShoulder;

    float speed = 0.6f;
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
    }
    public final void drive(float bl, float fl, float fr, float br ) {
/** Tells the robot how to drive */
          frontLeft.setPower(-fl*1.8*speed);
          backRight.setPower(br*speed);
          frontRight.setPower(fr*speed);
          backLeft.setPower(-bl*1.8*speed);

    }

    float[] sum = {0,0,0,0};



    public void loop() {
/** finds the values from the controller*/
        float lX = Range.clip((gamepad1.left_stick_x * gamepad1.left_stick_x * gamepad1.left_stick_x)/3, -1, 1);
        float lY = Range.clip((gamepad1.left_stick_y * gamepad1.left_stick_y * gamepad1.left_stick_y)/3, -1, 1);
        float rX = Range.clip((gamepad1.right_stick_x * gamepad1.right_stick_x * gamepad1.right_stick_x)/3, -1, 1);

/** creates driving modes */
        float[] vertical = {0.7f * lY, 0.7f * lY, 0.7f * lY, 0.7f * lY};
        float[] horizontal = {-lX, lX, lX, -lX};
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

        //if the left bumper is down, down the speed by 1.

        if(gamepad1.left_bumper) {
            speed = 1.5f;
        } else if(gamepad1.right_bumper) {
            speed = 4.5f;
        }
        else {
            speed = 3f;
        }
        //////////////////////////////

        //////////////////////////////
        telemetry.addData("Front Left Power: ", frontLeft.getPower());
        telemetry.addData("Front Right Power: ", frontRight.getPower());
        telemetry.addData("Back Left Power: ", backLeft.getPower());
        telemetry.addData("Back Right Power: ", backRight.getPower());
        telemetry.addData("Left Gamepad X-Coordinate: ", lX);
        telemetry.addData("Left Gamepad X-Coordinate: ", lY);
        telemetry.addData("leftChestShoulder: ", leftChestShoulder.getPosition());
        telemetry.addData("leftOuterShoulder: ", leftOuterShoulder.getPosition());
        telemetry.addData("rightChestShoulder: ", rightChestShoulder.getPosition());
        telemetry.addData("leftOuterShoulder: ", leftOuterShoulder.getPosition());
        telemetry.addData("Current speed: ", speed);
        telemetry.update();
    }


}