package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
@TeleOp
public class OpModeTwo extends OpMode {
    DcMotor frontLeft, backLeft, frontRight, backRight;

    public void init() {
        //Naming the Motors for phone
        frontLeft = hardwareMap.dcMotor.get("FL");
        backLeft = hardwareMap.dcMotor.get("BL");
        frontRight = hardwareMap.dcMotor.get("FR");
        backRight = hardwareMap.dcMotor.get("BR");
    }

    public void loop() {
        if (Math.abs(gamepad1.right_stick_x) > Math.abs(gamepad1.left_stick_y) && Math.abs(gamepad1.right_stick_x) > Math.abs(gamepad1.left_stick_x)) {
            if (gamepad1.left_stick_x >= 0.5 || gamepad1.left_stick_x <= -0.5) {
                //insert strafing code
                frontLeft.setPower(0.25 * gamepad1.right_stick_x);
                backRight.setPower(-0.25 * gamepad1.right_stick_x);
                frontRight.setPower(0.25 * gamepad1.right_stick_x);
                backLeft.setPower(-0.25 * gamepad1.right_stick_x);
                telemetry.addData("FL", gamepad1.right_stick_x);
                telemetry.addData("BR", -gamepad1.right_stick_x);
                telemetry.addData("FR", gamepad1.right_stick_x);
                telemetry.addData("BL", -gamepad1.right_stick_x);
            }
        } else if (Math.abs(gamepad1.left_stick_x) > Math.abs(gamepad1.left_stick_y)) {
            //turning
            frontLeft.setPower(-0.25 * gamepad1.left_stick_x);
            backLeft.setPower(-0.25 * gamepad1.left_stick_x);
            frontRight.setPower(-0.25 * gamepad1.left_stick_x);
            backRight.setPower(-0.25 * gamepad1.left_stick_x);
            telemetry.addData("FL", -gamepad1.left_stick_x);
            telemetry.addData("BL", -gamepad1.left_stick_x);
            telemetry.addData("FR", -gamepad1.left_stick_x);
            telemetry.addData("BR", -gamepad1.left_stick_x);
        } else if (gamepad1.left_stick_y >= 0.5 || gamepad1.left_stick_y <= -0.5) {
            //basic front and back
            frontLeft.setPower(-0.5 * gamepad1.left_stick_y);
            backLeft.setPower(-0.5 * gamepad1.left_stick_y);
            frontRight.setPower(0.5 * gamepad1.left_stick_y);
            backRight.setPower(0.5 * gamepad1.left_stick_y);
            telemetry.addData("FL", -gamepad1.left_stick_y);
            telemetry.addData("BL", -gamepad1.left_stick_y);
        }
    }
}