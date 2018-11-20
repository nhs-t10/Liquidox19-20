package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.Range;

@TeleOp
public class BasicTankMode extends OpMode {

    DcMotor frontLeft, backLeft, frontRight, backRight;

    public void init() {
        /*Namiyng the Motors for phone*/
        frontLeft = hardwareMap.dcMotor.get("FL");
        backLeft = hardwareMap.dcMotor.get("BL");
        frontRight = hardwareMap.dcMotor.get("FR");
        backRight = hardwareMap.dcMotor.get("BR");

    }
    public void drive(float bl, float fl, float fr, float br ) {
            float coef = 0.8f;
          frontLeft.setPower(-fl * coef);
          backRight.setPower(br* coef);
          frontRight.setPower(fr* coef);
          backLeft.setPower(-bl* coef);

    }

    float[] sum = {0 ,0 , 0, 0};



    public void loop() {

        float lX = Range.clip(gamepad1.left_stick_x, -1, 1);
        float lY = Range.clip(gamepad1.left_stick_y, -1, 1);
        float rX = Range.clip(gamepad1.right_stick_x, -1, 1);
        float rY = Range.clip(gamepad1.right_stick_y, -1, 1);
        if((rX > -0.6 && rX < 0.6) || (lX > -0.6 && lX < 0.6)) {
            drive(lY, lY, rY, rY);
        } else {
            drive((rX+lX)/2,-((rX+lX)/2),-((rX+lX)/2),(rX+lX)/2);
        }
        //drive(lY,lY,rY,rY);//multiply by x?
    }

    //Adds motor values for bug fixing*/
        /*telemetry.addData("Front Left: ", frontLeft.getPower());
        telemetry.addData("Front Right: ", frontRight.getPower());
        telemetry.addData("Back Left: ", backLeft.getPower());
        telemetry.addData("Back Right: ", backRight.getPower());*/
}



