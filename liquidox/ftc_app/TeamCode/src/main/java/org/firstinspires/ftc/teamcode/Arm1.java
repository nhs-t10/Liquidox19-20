package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import java.util.concurrent.TimeUnit;

@TeleOp
public class Arm1 extends OpMode {
    DcMotor Arm1;

    public void drive(double FL, double BL, double FR, double BR){
        frontLeft.setPower(FL);
        backRight.setPower(BR);
        frontRight.setPower(FR);
        backLeft.setPower(BL);
    }
    public void init() {
        //Naming the Motors for phone
        arm = hardwareMap.dcMotor.get("");

    }
    public void loop(){
        if (){

        }
    }
}