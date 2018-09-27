package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;


@TeleOp
public class OpModeOne extends OpMode {

    DcMotor frontLeft;
    DcMotor backLeft;
    DcMotor frontRight;
    DcMotor backRight;

    public void init(){
        frontLeft = hardwareMap.dcMotor.get("PHFL");
        backLeft = hardwareMap.dcMotor.get("PHBL");
        frontRight = hardwareMap.dcMotor.get("PHFR");
        backRight = hardwareMap.dcMotor.get("PHBR");

    }
    public void loop(){
       // forward and backward
        frontLeft.setPower(-gamepad1.left_stick_y);
        backLeft.setPower(-gamepad1.left_stick_y);
        frontRight.setPower(gamepad1.left_stick_y);
        backRight.setPower(gamepad1.left_stick_y);
       // circular roatations (not strafing)
        frontLeft.setPower(-gamepad1.right_stick_x);
        backLeft.setPower(-gamepad1.right_stick_x);
        frontRight.setPower(gamepad1.right_stick_x);
        backRight.setPower(gamepad1.right_stick_x);
    }
}
