//package org.firstinspires.ftc.teamcode;
//
//import com.qualcomm.robotcore.eventloop.opmode.OpMode;
//import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
//import com.qualcomm.robotcore.hardware.DcMotor;
//
//
//@TeleOp
//public class OpModeOne extends OpMode {
//
//    DcMotor frontLeft, backLeft, frontRight, backRight;
//
//    public void init(){
//       //Naming the Motors for phone
//        frontLeft = hardwareMap.dcMotor.get("FL");
//        backLeft = hardwareMap.dcMotor.get("BL");
//        frontRight = hardwareMap.dcMotor.get("FR");
//        backRight = hardwareMap.dcMotor.get("BR");
//
//    }
//    public void loop(){
//       // forward and backward
//        frontLeft.setPower(-gamepad1.left_stick_y);
//        backLeft.setPower(-gamepad1.left_stick_y);
//        frontRight.setPower(gamepad1.left_stick_y);
//        backRight.setPower(gamepad1.left_stick_y);
//       // circular rotations (not strafing)
//        frontLeft.setPower(-gamepad1.right_stick_x);
//        backLeft.setPower(-gamepad1.right_stick_x);
//        frontRight.setPower(gamepad1.right_stick_x);
//        backRight.setPower(gamepad1.right_stick_x);
//
//    }
//}
