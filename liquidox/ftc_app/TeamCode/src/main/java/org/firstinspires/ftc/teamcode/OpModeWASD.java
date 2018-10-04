package org.firstinspires.ftc.teamcode;
//This isn't actually set to the letter buttons, WIP
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;


@TeleOp
public class OpModeWASD extends OpMode{

    DcMotor frontLeft, backLeft, frontRight, backRight;

    public void init(){
        //Naming the Motors for phone
        frontLeft = hardwareMap.dcMotor.get("FL");
        backLeft = hardwareMap.dcMotor.get("BL");
        frontRight = hardwareMap.dcMotor.get("FR");
        backRight = hardwareMap.dcMotor.get("BR");

    }
    public void loop(){
       if(gamepad1.right_bumper=true){
           frontLeft.setPower(-5);
           frontRight.setPower(5);
           backLeft.setPower(-5);
           backRight.setPower(10);
       }
        if(gamepad1.left_bumper=true){
            frontLeft.setPower(5);
            frontRight.setPower(-5);
            backLeft.setPower(5);
            backRight.setPower(-10);
        }
    }
}
