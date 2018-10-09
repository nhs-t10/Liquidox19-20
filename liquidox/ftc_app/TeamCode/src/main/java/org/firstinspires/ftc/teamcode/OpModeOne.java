package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.Range;

@TeleOp
public class OpModeOne extends OpMode {

    DcMotor frontLeft, backLeft, frontRight, backRight;
    double X,Y,W,V,right,left;
    public void init(){
       //Naming the Motors for phone
        frontLeft = hardwareMap.dcMotor.get("FL");
        backLeft = hardwareMap.dcMotor.get("BL");
        frontRight = hardwareMap.dcMotor.get("FR");
        backRight = hardwareMap.dcMotor.get("BR");

    }
    public void loop(){
        //1 Stick Drive
        V = (100-Math.abs(X)) * (Y/100) + Y; // R+L
        W = (100-Math.abs(Y)) * (X/100) + X; // R-L

        right = (V+W)/2;
        left = (V-W)/2;

        right = Range.clip(right, -1f, 1f);
        left = Range.clip(left, -1f, 1f);

        //Apply values to motors
        frontLeft.setPower(left);
        backLeft.setPower(right);
        frontRight.setPower(left);
        backRight.setPower(right);
        //Making the motors move

    }
}
