package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import java.util.concurrent.TimeUnit;
//Hello! This entire section is just going to be a sort of logbook for all of the changes I intend to make
//
//Right now I am working on simplifying my cascading if statements into methods.
//This will probably take a while but it will be worth it in the end.
//Work on autonomus has started
@TeleOp
public class OpModeTwo extends OpMode {
    DcMotor frontLeft, backLeft, frontRight, backRight;
    int  sanic;
    public int boostSpeed (boolean boost){
        if (boost == false){
            return 1;
        }else{
            return 2;
        }
    }
    public boolean boost (boolean a, boolean b, boolean x, boolean y){
    if (a == true && b == true && x == true && y == false){
    return true;
    }else{
        return false;
    }
    }
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
    }
    public void loop() {
        //boost test
        if (gamepad1.start == true){
           if ((boost (gamepad1.a, gamepad1.b, gamepad1.x, gamepad1.y)) == true){
               sanic = 2;
           }else{
               sanic = 1;
           }
        }
        //lag
        try {
            TimeUnit.SECONDS.sleep(1/100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (Math.abs(gamepad1.right_stick_x) > Math.abs(gamepad1.left_stick_y) && Math.abs(gamepad1.right_stick_x) > Math.abs(gamepad1.left_stick_x)) {
            if (gamepad1.left_stick_x >= 0.5 || gamepad1.left_stick_x <= -0.5) {
                //insert strafing code
                drive((0.5  * sanic * gamepad1.right_stick_x), (-0.5  * sanic * gamepad1.right_stick_x), (0.5  * sanic * gamepad1.right_stick_x), (-0.5  * sanic * gamepad1.right_stick_x));
            }
        } else if (Math.abs(gamepad1.left_stick_x) > Math.abs(gamepad1.left_stick_y)) {
            //turning
            drive((-0.5  * sanic * gamepad1.right_stick_x), (-0.5  * sanic * gamepad1.right_stick_x), (-0.5  * sanic * gamepad1.right_stick_x), (-0.5  * sanic * gamepad1.right_stick_x));
        } else if (gamepad1.left_stick_y >= 0.5 || gamepad1.left_stick_y <= -0.5) {
            //basic front and back
            drive((-0.5 * sanic *gamepad1.left_stick_y), (-0.5 * sanic *gamepad1.left_stick_y), (0.5 * sanic *gamepad1.left_stick_y), (0.5 * sanic *gamepad1.left_stick_y));
        }else{
            //it stops now
            drive(0,0,0,0);
        }
    }
}