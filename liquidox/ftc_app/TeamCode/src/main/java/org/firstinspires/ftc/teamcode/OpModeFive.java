package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.Range;
import org.firstinspires.ftc.robotcore.external.*;
import java.util.concurrent.TimeUnit;

@TeleOp
public class OpModeFive extends OpMode {
    //private double random;
    //instantiate hardware devices
    DcMotor frontLeft, backLeft, frontRight, backRight;

    Servo rightChestShoulder, leftChestShoulder, leftOuterShoulder, rightOuterShoulder;

    float speed = 0.6f;
    public void init() {
        /*Naming the Motors for phone*/
        frontLeft = hardwareMap.dcMotor.get("FL");
        backLeft = hardwareMap.dcMotor.get("BL");
        frontRight = hardwareMap.dcMotor.get("FR");
        backRight = hardwareMap.dcMotor.get("BR");

        rightChestShoulder = hardwareMap.servo.get("RCS");
        leftChestShoulder = hardwareMap.servo.get("LCS");
        rightOuterShoulder = hardwareMap.servo.get("ROS");
        leftOuterShoulder = hardwareMap.servo.get("LOS");

    }
    public final void drive(float bl, float fl, float fr, float br ) {

        frontLeft.setPower(-fl*speed*9/10);
        backRight.setPower(br*speed*4.5/10);
        frontRight.setPower(fr*speed*4.5/10);
        backLeft.setPower(-bl*speed*9/10);

    }

    float[] sum = {0,0,0,0};



    public void loop() {

        float lX = Range.clip((gamepad1.left_stick_x * gamepad1.left_stick_x * gamepad1.left_stick_x)/3, -1, 1);
        float lY = Range.clip((gamepad1.left_stick_y * gamepad1.left_stick_y * gamepad1.left_stick_y)/3, -1, 1);
        float rX = Range.clip((gamepad1.right_stick_x * gamepad1.right_stick_x * gamepad1.right_stick_x)/3, -1, 1);


        float[] vertical = {0.7f * lY, 0.7f * lY, 0.7f * lY, 0.7f * lY};
        float[] horizontal = {-lX, lX, lX, -lX};
        float[] rotational = {-rX, -rX, rX, rX};

        for(int i=0; i<4; i++) {
            sum[i] = vertical[i] + horizontal[i] + rotational[i];
        }

        float highest = Math.max(Math.max(sum[0], sum[1]), Math.max(sum[2], sum[3]));

        if(Math.abs(highest)>1) {
            for (int i=0; i<4; i++) {
                sum[i]=sum[i]/highest;
            }
        }


        drive(sum[0],sum[1],sum[2],sum[3]);
        //okay now that that masterpiece of coding is done, have some disgusting pasta.
        //if the button is down, move left and right shoulders forwards.
        if (gamepad1.b) {
            leftChestShoulder.setPosition(0);
            rightChestShoulder.setPosition(1);

        }
        if(gamepad1.a) {
            leftOuterShoulder.setPosition(0);
            rightOuterShoulder.setPosition(1);

        }
        if (gamepad1.x) {
            leftChestShoulder.setPosition(1);
            rightChestShoulder.setPosition(0);

        }
        if(gamepad1.y) {
            leftOuterShoulder.setPosition(1);
            rightOuterShoulder.setPosition(0);

        }
        // why the heck did this show up here? }
        //if the left bumper is down, down the speed by 1.
        if(gamepad1.left_bumper) { speed = 1.5f; }
        else if(gamepad1.right_bumper) { speed = 4.5f; }
        else { speed = 3f; }
        //////////////////////////////

        //////////////////////////////
        telemetry.addData("Front Left Power: ", frontLeft.getPower());
        telemetry.addData("Front Right Power: ", frontRight.getPower());
        telemetry.addData("Back Left Power: ", backLeft.getPower());
        telemetry.addData("Back Right Power: ", backRight.getPower());
        telemetry.addData("Left Gamepad X-Coordinate: ", lX);
        telemetry.addData("Left Gamepad X-Coordinate: ", lY);
        telemetry.addData("Data we  fed into `drive()`: ", sum.toString());
        telemetry.addData("Current speed: ", speed);
        telemetry.update();
    }


}