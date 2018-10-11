package org.firstinspires.ftc.teamcode;
<<<<<<< HEAD
=======

>>>>>>> de3c915e6fd00b40064710b97a1291cfd2129a17
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
@TeleOp
public class OpModeTwo extends OpMode{
<<<<<<< HEAD
    DcMotor frontLeft, backLeft, frontRight, backRight;
=======

    DcMotor frontLeft, backLeft, frontRight, backRight;

>>>>>>> de3c915e6fd00b40064710b97a1291cfd2129a17
    public void init(){
        //Naming the Motors for phone
        frontLeft = hardwareMap.dcMotor.get("FL");
        backLeft = hardwareMap.dcMotor.get("BL");
        frontRight = hardwareMap.dcMotor.get("FR");
        backRight = hardwareMap.dcMotor.get("BR");
    }
    public void loop(){
<<<<<<< HEAD
        if (Math.abs(gamepad1.right_stick_x) > Math.abs(gamepad1.left_stick_y) && Math.abs(gamepad1.right_stick_x) > Math.abs(gamepad1.left_stick_x)){
            if (gamepad1.left_stick_x >= 0.5 || gamepad1.left_stick_x <= -0.5){
                //insert strafing code
                frontLeft.setPower(1/2*gamepad1.right_stick_x);
                backRight.setPower(-1/2*gamepad1.right_stick_x);
                frontRight.setPower(1/2*gamepad1.right_stick_x);
                backLeft.setPower(-1/2*gamepad1.right_stick_x);

                telemetry.addData("FL",gamepad1.right_stick_x);
                telemetry.addData("BR",-gamepad1.right_stick_x);
                telemetry.addData("FR",gamepad1.right_stick_x);
                telemetry.addData("BL",-gamepad1.right_stick_x);
            }
        }else if(Math.abs(gamepad1.left_stick_x) > Math.abs(gamepad1.left_stick_y)){
            frontLeft.setPower(-1/2*gamepad1.left_stick_x);
            backLeft.setPower(-1/2*gamepad1.left_stick_x);
            frontRight.setPower(-1/2*gamepad1.left_stick_x);
            backRight.setPower(-1/2*gamepad1.left_stick_x);

            telemetry.addData("FL",-gamepad1.left_stick_x);
            telemetry.addData("BL",-gamepad1.left_stick_x);
            telemetry.addData("FR",-gamepad1.left_stick_x);
            telemetry.addData("BR",-gamepad1.left_stick_x);
        }
        else if (gamepad1.left_stick_y >= 0.5 || gamepad1.left_stick_y <= -0.5){
            frontLeft.setPower(-1/2*gamepad1.left_stick_y);
            backLeft.setPower(-1/2*gamepad1.left_stick_y);
            frontRight.setPower(1/2*gamepad1.left_stick_y);
            backRight.setPower(1/2*gamepad1.left_stick_y);

            telemetry.addData("FL",-gamepad1.left_stick_y);
            telemetry.addData("BL",-gamepad1.left_stick_y);
            telemetry.addData("FR",gamepad1.left_stick_y);
            telemetry.addData("BR",gamepad1.left_stick_y);
        }
      
=======
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

>>>>>>> de3c915e6fd00b40064710b97a1291cfd2129a17
    }
}