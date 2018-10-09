package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.Range;

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

//    public void drive(float FL, float BL, float FR, float BR){
//        frontLeft.setPower(FL);
//        backRight.setPower(BR);
//        frontRight.setPower(FR);
//        backLeft.setPower(BL);
//    }

    public void loop() {


        if (gamepad1.left_stick_y > 0.1) {
            frontLeft.setPower(-gamepad1.left_stick_y);
           //  backRight.setPower(gamepad1.left_stick_y);
            frontRight.setPower(gamepad1.left_stick_y);
          //  backLeft.setPower(-gamepad1.left_stick_y);
        } else if (gamepad1.left_stick_y < -0.1) {
            frontLeft.setPower(gamepad1.left_stick_y);
           // backRight.setPower(-gamepad1.left_stick_y);
            frontRight.setPower(-gamepad1.left_stick_y);
           // backLeft.setPower(gamepad1.left_stick_y);
        }
    }
}

