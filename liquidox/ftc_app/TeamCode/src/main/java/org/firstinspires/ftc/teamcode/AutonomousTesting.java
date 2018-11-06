package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import java.util.concurrent.TimeUnit;

@TeleOp
public class AutonomousTesting extends OpMode {
    DcMotor frontLeft, backLeft, frontRight, backRight;

    public void drive(double FL, double BL, double FR, double BR){
        frontLeft.setPower(FL);
        backRight.setPower(BR);
        frontRight.setPower(FR);
        backLeft.setPower(BL);
    }
    public void init() {
        //Naming the Motors for phone
        frontLeft = hardwareMap.dcMotor.get("FL");
        backLeft = hardwareMap.dcMotor.get("BL");
        frontRight = hardwareMap.dcMotor.get("FR");
        backRight = hardwareMap.dcMotor.get("BR");
        drive(-0.5, -0.5, 0.5, 0.5);
        try {
            TimeUnit.SECONDS.sleep(3/2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        drive(0,0,0,0);
    }
    public void loop(){
        //nothing in here, its autonomous
    }
}