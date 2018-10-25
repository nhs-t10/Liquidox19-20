package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

public class OpModeThree {
    public void loop() {
        //1 Stick Drive
        double Y = -(gamepad1.left_stick_x / 1.0); //Y is inverted with the negative sign
        double X = (gamepad1.left_stick_y / 1.0); //NOT inverted

        double V = (100 - Math.abs(X)) * (Y / 100) + Y; // R+L
        double W = (100 - Math.abs(Y)) * (X / 100) + X; // R-L

        right = (V + W) / 2;
        left = (V - W) / 2;

        right = Range.clip(right, -1f, 1f);
        left = Range.clip(left, -1f, 1f);

        //Apply values to motors
        leftMotorFront.setPower(left);
        rightMotorFront.setPower(right);
        leftMotorBack.setPower(left);
        rightMotorBack.setPower(right);
    }

}