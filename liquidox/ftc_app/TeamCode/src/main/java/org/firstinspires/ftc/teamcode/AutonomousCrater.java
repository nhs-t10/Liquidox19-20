package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import org.firstinspires.ftc.teamcode.Turning;

@Autonomous
public class AutonomousCrater extends AutonomousTesting {

    public void loop() {

        if (step == 1) {
            unLatch();
            if (timer1 >= 5000) {
                step++;
            }
        }

        if (step==2) {
            //Turning.setDestination();
        }

    }
}


