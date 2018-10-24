package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.Range;

import java.util.concurrent.TimeUnit;

@TeleOp
public class OpModeFour extends OpMode {

    DcMotor frontLeft, backLeft, frontRight, backRight;

    public void init() {
        //Naming the Motors for phone
        frontLeft = hardwareMap.dcMotor.get("FL");
        backLeft = hardwareMap.dcMotor.get("BL");
        frontRight = hardwareMap.dcMotor.get("FR");
        backRight = hardwareMap.dcMotor.get("BR");


    }

    public void leftStickDrive(double L, double R) {
        frontLeft.setPower(L);
        backRight.setPower(-R);
        frontRight.setPower(-R);
        backLeft.setPower(L);
    }
    public void rightStickDrive(float x , float y) {
        frontLeft.setPower(L);
        backRight.setPower(-R);
        frontRight.setPower(R);
        backLeft.setPower(-L);
    }
    double scaleFactor = 0.4;
    public void loop() {

        double lX = Range.clip(gamepad1.left_stick_x, -1, 1);
        double lY = Range.clip(gamepad1.left_stick_y, -1, 1);
        double rX = Range.clip(gamepad1.right_stick_x, -1, 1);
        double rY = Range.clip(gamepad1.right_stick_y, -1, 1);

        //Adam's lag that makes it work better... somehow
        try {
            TimeUnit.SECONDS.sleep(1 / 100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //setting, and  chging scale factor
        if (gamepad1.left_bumper) {
            if (scaleFactor < 0.8) {
                scaleFactor = scaleFactor + 0.1;
            }
        }

        if (gamepad1.right_bumper) {
            if (scaleFactor < 1) {
                scaleFactor = scaleFactor - 0.1;
            }
        }

        if (lX + lY != 0) {
            leftStickDrive((lY + lX) * scaleFactor, (lY - lX) * scaleFactor);
        }
        //NOT DONE, NEEDS TO BE FINISHED
        if (Math.abs(rX) + Math.abs(rY) != 0) {
            switch() {






            }
        }


        rightStickDrive(rX * scaleFactor, rY * scaleFactor);
    }
    //Adds motor values for bug fixing
        telemetry.addData("Front Left: ", frontLeft.getPower());
        telemetry.addData("Front Right: ", frontRight.getPower());
        telemetry.addData("Back Left: ", backLeft.getPower());
        telemetry.addData("Back Right: ", backRight.getPower());
}
}


