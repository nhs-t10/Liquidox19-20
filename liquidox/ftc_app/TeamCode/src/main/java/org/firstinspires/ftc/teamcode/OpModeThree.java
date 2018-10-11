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

    public void drive(double FL, double BL, double FR, double BR){
        frontLeft.setPower(FL);
        backRight.setPower(-BR);
        frontRight.setPower(-FR);
        backLeft.setPower(BL);
    }
    public void Sdrive(double L, double R) {
        frontLeft.setPower(L);
        backRight.setPower(-R);
        frontRight.setPower(-R);
        backLeft.setPower(L);
    }
    public void loop() {
        double LX = range.clip(gamepad1.left_stick_x, -1, 1);
        double LY = range.clip(gamepad1.left_stick_y, -1, 1);
        double RX = range.clip(gamepad1.right_stick_x, -1, 1);
        double RY = range.clip(gamepad1.right_stick_y, -1, 1);

        Sdrive((LY + LX)/2, (LY -LX)/2);
//        telemetry.addData("Front Left mortor", LX/2);
//        telemetry.addData("Front Right mortor", LX/2);
//        telemetry.addData("Back Left", LX/2);
//        telemetry.addData("Back Right", LX/2);


        //drive(1, 1, 1, 1);


    }
}

