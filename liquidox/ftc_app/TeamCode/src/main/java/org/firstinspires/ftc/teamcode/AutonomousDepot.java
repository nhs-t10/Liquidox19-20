package org.firstinspires.ftc.teamcode;


import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import org.firstinspires.ftc.teamcode.Turning;
import org.firstinspires.ftc.teamcode.BasicTankMode;

@Autonomous
public class AutonomousDepot extends AutonomousTesting {

    public void init(){
        init();
    }

    public void loop(){


        step = 2;

        if(step == 2){
            LO2Library.drive(0.2f, 0.2f, 0.2f, 0.2f);
            if(timer1 >= 1500){
                LO2Library.drive(0f,0f,0f,0f);
                timer1 = 0;
                step++;
            }
        }

        if(step == 3) {
            Turning.setDestination(45);
            Turning.update(Turning.currentAngle);
//            if (Turning.error < 3) {
//                drive(0, 0,0,0);
//                timer1 = 0;
//                step++;
//            }

            if (timer1 == 6500) {
                LO2Library.drive(0f, 0f,0f,0f);
                timer1 = 0;
                step++;
            }
        }

        if(step == 4) {
            LO2Library.drive(-0.2f,0.2f,0.2f,-0.2f);
            if(timer1 == 7000) {
                LO2Library.drive(0f,0f,0f,0f);
                timer1 = 0;
                step++;
            }
        }

        if(step == 5) {
            LO2Library.drive(-1f,-1f,-1f,-1f);
            if (timer1 == 6000) {
                LO2Library.drive(0f,0f,0f,0f);
            }
        }

    }
}
