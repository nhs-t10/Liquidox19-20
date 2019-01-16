package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;


public abstract class LO2Library extends OpMode {

    public static DcMotor frontLeft, backLeft, frontRight, backRight;
    public static Servo rightChestShoulder, leftChestShoulder, leftOuterShoulder, rightOuterShoulder;

    public void initialize_robot() {
        /*Naming the Motors for phone*/
        frontLeft = hardwareMap.dcMotor.get("FL");
        backLeft = hardwareMap.dcMotor.get("BL");
        frontRight = hardwareMap.dcMotor.get("FR");
        backRight = hardwareMap.dcMotor.get("BR");



    }

    public static String repeatString(String s, int n) {
        for(int i = 0; i < n; i++ ) {
            s = s + s;
        }
        return s;
    }

    public static void drive(float bl, float fl, float fr, float br) {
        frontLeft.setPower(-fl);
        backRight.setPower(br);
        frontRight.setPower(fr);
        backLeft.setPower(-bl);

    }

    public static void TurnDrive(double bl, double fl, double fr, double br) {
        frontLeft.setPower(-fl);
        backRight.setPower(br);
        frontRight.setPower(fr);
        backLeft.setPower(-bl);
    }
    public static String speedBar(double percent, int resolution) {
        percent = Math.abs(percent);
        return "["+repeatString("\u2588",(int)Math.floor(percent*resolution)) + repeatString(" ",(int)Math.floor(resolution - (percent*resolution)))+"]";
    }

}
