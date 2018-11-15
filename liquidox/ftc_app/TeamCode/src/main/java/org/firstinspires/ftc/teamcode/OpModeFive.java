package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.Range;

import java.util.concurrent.TimeUnit;

@TeleOp
public class OpModeFive extends OpMode {

    //instantiate hardware devices
    DcMotor frontLeft, backLeft, frontRight, backRight;

    Servo rightShoulder, leftShoulder, chestShoulder;

    public void init() {
        /*Namiyng the Motors for phone*/
        frontLeft = hardwareMap.dcMotor.get("FL");
        backLeft = hardwareMap.dcMotor.get("BL");
        frontRight = hardwareMap.dcMotor.get("FR");
        backRight = hardwareMap.dcMotor.get("BR");

        //assign shoulders (motors involved in arms)
      //  rightShoulder = hardwareMap.servo.get("RS");
        leftShoulder = hardwareMap.servo.get("LS");
        //chestShoulder = hardwareMap.servo.get("CS");

    }
    public final void drive(float bl, float fl, float fr, float br ) {

          frontLeft.setPower(-1/2*fl);
          backRight.setPower(1/2*br);
          frontRight.setPower(1/2*fr);
          backLeft.setPower(-1/2*bl);

    }

    float[] sum;



    public void loop() {

        float lX = Range.clip(gamepad1.left_stick_x, -1, 1);
        float lY = Range.clip(gamepad1.left_stick_y, -1, 1);
        float rX = Range.clip(gamepad1.right_stick_x, -1, 1);

        float[] vertical = {lY, lY, lY, lY};
        float[] horizontal = {lX, -lX, -lX, lX};
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
            if(gamepad1.a) {
              //  rightShoulder.setPosition(rightShoulder.getPosition()+1);
                leftShoulder.setPosition(leftShoulder.getPosition()+1);
            } /*no else because we don't want one button to "take precedence" over another-- might be jittery, but there you go `\_('-')_/` */ if (gamepad1.b) {
            //rightShoulder.setPosition(rightShoulder.getPosition()-1);
            leftShoulder.setPosition(leftShoulder.getPosition() - 1);
        }
        // why the heck did this show up here? }

    }

    /**Adds motor values for bug fixing*/
//        telemetry.addData("Front Left: ", frontLeft.getPower());
//        telemetry.addData("Front Right: ", frontRight.getPower());
//        telemetry.addData("Back Left: ", backLeft.getPower());
//        telemetry.addData("Back Right: ", backRight.getPower());

}