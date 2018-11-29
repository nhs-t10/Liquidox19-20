//package org.firstinspires.ftc.teamcode;
//
//import com.qualcomm.robotcore.eventloop.opmode.OpMode;
//import com.qualcomm.robotcore.hardware.DcMotor;
//
//
//public abstract class LO2Library extends OpMode {
//
//    DcMotor frontLeft, backLeft, frontRight, backRight;
//
//    public void init() {
//        /*Namiyng the Motors for phone*/
//        frontLeft = hardwareMap.dcMotor.get("FL");
//        backLeft = hardwareMap.dcMotor.get("BL");
//        frontRight = hardwareMap.dcMotor.get("FR");
//        backRight = hardwareMap.dcMotor.get("BR");
//    }
//
//    public final void drive(float bl, float fl, float fr, float br ) {
//        frontLeft.setPower(-fl);
//        backRight.setPower(br);
//        frontRight.setPower(fr);
//        backLeft.setPower(-bl);
//
//    }
//}
