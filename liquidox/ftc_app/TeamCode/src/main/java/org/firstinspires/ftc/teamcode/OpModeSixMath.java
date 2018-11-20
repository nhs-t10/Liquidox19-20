package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.Range;

import java.util.concurrent.TimeUnit;

@TeleOp
public class OpModeSixMath extends OpMode {

    DcMotor frontLeft, backLeft, frontRight, backRight;
    float sanic = 1;
    public void init() {
        /*Naming the Motors for phone*/
        frontLeft = hardwareMap.dcMotor.get("FL");
        backLeft = hardwareMap.dcMotor.get("BL");
        frontRight = hardwareMap.dcMotor.get("FR");
        backRight = hardwareMap.dcMotor.get("BR");

    }

    private void rightStickDrive(float front, float back) {

        frontLeft.setPower(-front);
        backRight.setPower(back);
        frontRight.setPower(front);
        backLeft.setPower(-back);

    }

    private void leftStickDrive(float right, float left){

        frontLeft.setPower(-left);
        backRight.setPower(right);
        frontRight.setPower(right);
        backLeft.setPower(-left);
    }
    public void loop() {

        float lX = Range.clip(gamepad1.left_stick_x, -1, 1);
        float lY = Range.clip(gamepad1.left_stick_y, -1, 1);
        float rX = Range.clip(gamepad1.right_stick_x, -1, 1);





        leftStickDrive((lY + lX) / 2 * sanic,
                (lY - lX) / 2 * sanic);
        if(Math.abs(rX)>0.1){


            rightStickDrive(-rX, rX);


        }



    }
}





