package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
@TeleOp
public class OpModeTwo extends OpMode{

    DcMotor frontLeft, backLeft, frontRight, backRight;

    public void init(){
        //Naming the Motors for phone
        frontLeft = hardwareMap.dcMotor.get("FL");
        backLeft = hardwareMap.dcMotor.get("BL");
        frontRight = hardwareMap.dcMotor.get("FR");
        backRight = hardwareMap.dcMotor.get("BR");
    }
    public void loop(){
        if (Math.abs(gamepad1.left_stick_x) > Math.abs(gamepad1.left_stick_y)){
            if (gamepad1.left_stick_x >= 0.5 || gamepad1.left_stick_x <= -0.5){
                //insert strafing code
                frontLeft.setPower(-gamepad1.left_stick_x);
                backRight.setPower(gamepad1.left_stick_x);
                frontRight.setPower(-gamepad1.left_stick_x);
                backLeft.setPower(gamepad1.left_stick_x);
            }
        }else if (gamepad1.left_stick_y >= 0.5 || gamepad1.left_stick_y <= -0.5){
            frontLeft.setPower(-gamepad1.left_stick_y);
            backLeft.setPower(-gamepad1.left_stick_y);
            frontRight.setPower(gamepad1.left_stick_y);
            backRight.setPower(gamepad1.left_stick_y);
        }else{
            frontLeft.setPower(0);
            backLeft.setPower(0);
            frontRight.setPower(0);
            backRight.setPower(0);
        }

    }
}